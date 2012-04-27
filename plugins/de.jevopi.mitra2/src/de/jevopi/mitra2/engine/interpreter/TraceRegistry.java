/*******************************************************************************
 * Copyright (c) 2012 Jens von Pilgrim
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package de.jevopi.mitra2.engine.interpreter;

import static de.jevopi.mitra2.MitraUtils.isTraced;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.mitra.Parameter;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.SimpleRuleReference;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.traces.Model;
import de.jevopi.mitra2.traces.Trace;
import de.jevopi.mitra2.traces.TraceElement;
import de.jevopi.mitra2.traces.TraceRecord;
import de.jevopi.mitra2.traces.TracesFactory;

/**
 * Maps rules (viz. rule declarations) to traces.
 * 
 * @author Jens von Pilgrim
 * @since Jan 5, 2009
 */
public class TraceRegistry extends TraceToRuleDeclarationMapper {

	private static int COUNTER = 0;

	private final int id = COUNTER++;

	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(TraceRegistry.class
			.getName());


	/**
	 * Map of all registered trace records and their rule declarations.
	 */
	Map<String, BlownTraceRecord> traceMaps;

	/**
	 * Maps rule declarations to traces, note that {@link RuleDeclaration}
	 * implements {@link #hashCode()} efficiently. Note that this map may
	 * contain more entries then stored in a trace recored, since it also
	 * contains entries of implemented and overridden rules.
	 */
	BlownTraceRecord volatileRecord;

	BlownTraceRecord currentMap;

	/**
	 * In stealth mode, the current map is set to the volantile map. The
	 * currently active map is saved to this field. If this field is null,
	 * registry is in normal mode, otherwise it is in stealth mode.
	 */
	BlownTraceRecord stealthedMap;

	public static class BlownTraceRecord {
		TraceRecord traceRecord;

		Map<RuleDeclaration, List<Trace>> traceMap;

		/**
		 * @param i_traceRecord
		 * @param i_traceMap
		 */
		public BlownTraceRecord(TraceRecord i_traceRecord) {
			super();
			traceRecord = i_traceRecord;
			traceMap = new HashMap<RuleDeclaration, List<Trace>>();
		}

	}

	/**
	 * Only used in returned list in {@link TraceRegistry#registerTrace(Trace)}.
	 * 
	 * @author Jens von Pilgrim
	 */
	public static class DeclTracePair {
		public RuleDeclaration decl;

		public Trace trace;

		/**
		 * @param decl
		 * @param trace
		 */
		public DeclTracePair(RuleDeclaration decl, Trace trace) {
			this.decl = decl;
			this.trace = trace;
		}

	}

	

	/**
	 * @param ruleMap
	 */
	public TraceRegistry(ProjectContext projectContext) {
		super(projectContext);

		volatileRecord = new BlownTraceRecord(null);
		currentMap = volatileRecord;
		traceMaps = new HashMap<String, BlownTraceRecord>(2);
	}

	

	/**
	 * Reads all traces from a given trace record and sets this trace record as
	 * currently active trace record. If registry was in stealth mode before, it
	 * is switch to normal mode.
	 * 
	 * @param traceRecord
	 */
	public void registerTraceRecord(TraceRecord traceRecord) {
		currentMap = new BlownTraceRecord(traceRecord);

		// end of stealth mode
		stealthedMap = null;

		traceMaps.put(traceRecord.getName(), currentMap);

		for (Trace t : traceRecord.getTraces()) {
			registerTrace(t, false);
		}
	}

	/**
	 * Registers this trace to current trace map and add the trace to the
	 * currently active trace record. Returns a list of derived traces created
	 * by this trace.
	 * 
	 * @param t
	 * @return
	 */
	public List<DeclTracePair> registerTrace(Trace t) {
		return registerTrace(t, false);
	}

	/**
	 * Registers this trace in the currently active map and creates all derived
	 * traces.
	 * 
	 * @param t
	 * @param readingRecord
	 * @return the derived traces
	 */
	protected List<DeclTracePair> registerTrace(Trace t, boolean readingRecord) {

		RuleDeclaration decl = findRuleDeclarationForTrace(t);

		if (decl == null) {
			throw new IllegalArgumentException("No rule found for trace " + t);
		}
		putTrace(t, decl, !readingRecord);

		// register implemented and overloaded rules as well
		List<DeclTracePair> derivedTraces = new LinkedList<DeclTracePair>();
		SimpleRuleReference overridden = decl.getOverriddenRule();
		if (overridden != null) {
			registerDerivedTrace(t, decl, derivedTraces, overridden);
		}

		for (SimpleRuleReference implRef : decl.getImplementedRules()) {
			registerDerivedTrace(t, decl, derivedTraces, implRef);
		}

		return derivedTraces;
	}

	/**
	 * Called by {@link #registerTrace(Trace)} for (recursively) registering
	 * implemented and overloaded rule traces.
	 * 
	 * @param trace
	 * @param calledRuleDecl
	 * @param io_derivedTraces
	 * @param ruleReference
	 */
	protected void registerDerivedTrace(Trace trace,
			RuleDeclaration calledRuleDecl,
			List<DeclTracePair> io_derivedTraces,
			SimpleRuleReference ruleReference) {

		RuleDeclaration referencedDecl = ruleReference.getRuleDeclaration();

		if (isTraced(referencedDecl)) {
			Trace derivedTrace = TracesFactory.eINSTANCE.createTrace();
			derivedTrace.setRuleName(MitraUtils.fqn(referencedDecl));
			derivedTrace.setTimestamp(trace.getTimestamp());
			if (referencedDecl.getExec() != null) {
				derivedTrace.setRuleInfo(referencedDecl.getExec().getName());
			}
			String typename;
			String parname;
			List<Type> parameterTypes = MitraUtils
					.retrieveRuleRefParameterTypes(ruleReference);
			List<String> parameterNames = MitraUtils
					.retrieveRuleRefParameterNames(ruleReference, true);
			for (int i = 0; i < parameterNames.size(); i++) {
				parname = parameterNames.get(i);
				typename = parameterTypes.get(i).toString();
				
				TraceElement createdElement = getTraceElementByName(calledRuleDecl, trace, parname);
				TraceElement te = TracesFactory.eINSTANCE.createTraceElement();
				te.setTypeName(typename);
				te.setElement(createdElement.getElement());
				te.setValue(createdElement.getValue());
				derivedTrace.getElements().add(te);
			}
			// derived traces are never saved to record, only to map
			putTrace(derivedTrace, referencedDecl, false);

			io_derivedTraces
					.add(new DeclTracePair(referencedDecl, derivedTrace));

			if (log.isLoggable(Level.INFO)) {
				log.info("created derived trace: " + derivedTrace); //$NON-NLS-1$
			}

			// recursive call:
			SimpleRuleReference overridden = referencedDecl.getOverriddenRule();
			if (overridden != null) {
				registerDerivedTrace(derivedTrace, referencedDecl,
						io_derivedTraces, overridden);
			}

			for (SimpleRuleReference implRef : referencedDecl
					.getImplementedRules()) {
				registerDerivedTrace(derivedTrace, referencedDecl,
						io_derivedTraces, implRef);
			}

		}
	}

	/**
	 * @param decl
	 * @param t
	 * @param parname
	 * @return
	 */
	private TraceElement getTraceElementByName( //
			RuleDeclaration decl, Trace t, String parname) {
		int i = 0;
		// TODO seems weird, what if order has been changed?
		for (Parameter par : MitraUtils.collectRuleParameters(decl)) {
			if (par.getVardecl().getName().equals(parname)) {
				return t.getElements().get(i);
			}
			i++;
		}
		// this must not happen and should be recognized by SemanticChecker
		throw new IllegalStateException("Parameter " + parname
				+ " not found in declaration " + decl);
	}

	/**
	 * Puts a declaration, mapped by a trace, to the currently active trace map.
	 * 
	 * @param t
	 * @param decl
	 */
	private void putTrace(Trace t, RuleDeclaration decl,
			boolean saveTraceToRecord) {
		List<Trace> traces = currentMap.traceMap.get(decl);
		if (traces == null) {
			traces = new ArrayList<Trace>();
			currentMap.traceMap.put(decl, traces);
		}
		traces.add(t);
		if (saveTraceToRecord && currentMap.traceRecord != null) {
			currentMap.traceRecord.getTraces().add(t);
		}

	}

	

	/**
	 * Returns traces possibly created by a given rule declaration. All known
	 * maps are searched.
	 * 
	 * @param decl
	 * @return List of Traces, possibly an empty list if no traces were
	 *         registered matching the given declaration (null is never
	 *         returned)
	 */
	public List<Trace> getTraces(RuleDeclaration decl) {

		List<Trace> result = new ArrayList<Trace>();
		List<Trace> partialResult;

		for (BlownTraceRecord blownTraceRecord : traceMaps.values()) {
			partialResult = blownTraceRecord.traceMap.get(decl);
			if (partialResult != null) {
				result.addAll(partialResult);
			}
		}
		if (result.isEmpty()) {
			return Collections.emptyList();
		}
		return result;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		int iTotal = 0;
		for (BlownTraceRecord blownTraceRecord : traceMaps.values()) {
			for (List<Trace> tracesPerRule : blownTraceRecord.traceMap.values()) {
				if (tracesPerRule != null) {
					iTotal += tracesPerRule.size();
				}
			}
		}

		return MessageFormat.format(
				"TraceRegistry #{0}, {1} records with totally {2} traces{3}",
				id, traceMaps.keySet().size(), iTotal,
				isInStealthMode() ? ", stealthmode" : "");

	}

	/**
	 * Activates the trace record with the given name. If registry was in
	 * stealth mode, it is switched to normal mode. If specified record is
	 * unknown, the current record and mode are not changed.
	 * 
	 * @param name
	 * @return true, if specified record has been found, false otherwise
	 */
	public boolean activateRecord(String name) {
		BlownTraceRecord newCurrentTraces = traceMaps.get(name);

		if (newCurrentTraces != null) {
			if (isInStealthMode()) {
				deactivateStealthMode();
			}
			currentMap = newCurrentTraces;
			return true;
		}

		return false;
	}

	/**
	 * Clears all volatile traces.
	 */
	public void clearVolatileTraces() {
		volatileRecord.traceMap.clear();
	}

	/**
	 * If registry is in stealth mode, traces are evaluated but not stored to a
	 * record. That is, all created traces in stealthmode are not persisted and
	 * may be removed by calling {@link #clearVolatileTraces()}
	 * 
	 * @return
	 */
	public boolean isInStealthMode() {
		return stealthedMap != null;
	}

	/**
	 * Sets current mode to stealth mode, that is all traces are stored to the
	 * volatile record which is not saved and may get cleared by calling
	 * {@link #clearVolatileTraces()}. If registry already is in stealth mode,
	 * an {@link IllegalStateException} is thrown.
	 * 
	 * @throws IllegalStateException if registry is already in stealth mode.
	 */
	public void activateStealthMode() {
		if (isInStealthMode()) {
			throw new IllegalStateException(
					"registry is already in stealthmode");
		}
		stealthedMap = currentMap;
		currentMap = volatileRecord;
	}

	/**
	 * Sets current mode to normal mode. Usually, this sets the registry to use
	 * some trace recored, into which traces are stored and which can be
	 * persisted. However, if no trace record has been registered, the volatile
	 * record is used by deault. If registry already is not in stealth mode, an
	 * {@link IllegalStateException} is thrown.
	 * 
	 * @throws IllegalStateException if registry is not in stealth mode.
	 */

	public void deactivateStealthMode() {
		if (!isInStealthMode()) {
			throw new IllegalStateException("registry is not in stealthmode");
		}
		currentMap = stealthedMap;
		stealthedMap = null;
	}
	
	
}
