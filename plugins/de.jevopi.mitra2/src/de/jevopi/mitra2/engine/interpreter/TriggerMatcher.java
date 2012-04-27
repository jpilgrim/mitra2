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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.metamodel.IMetamodel;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.metamodel.MetamodelManager.MetamodelNotFoundException;
import de.jevopi.mitra2.mitra.QualifiedParameterReference;
import de.jevopi.mitra2.mitra.QualifiedRuleReference;
import de.jevopi.mitra2.mitra.RuleReference;
import de.jevopi.mitra2.mitra.Trigger;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.traces.Trace;
import de.jevopi.mitra2.traces.TraceElement;
import de.jevopi.utils.ComposedIterable;

/**
 * Search traces matching a trigger, considering implicit constraint that all
 * parameters with same name must reference the same elements.
 * <p>
 * Notes:
 * 
 * <pre>
 * - all combinations have to be tested, even if no when clause exists. Example:
 *   x(a,b), 
 *   x(a,c), 
 *   y(c,d)
 *   
 *   (t(rulename, value par 1, value par 2):
 *   t1(x,0,1), t2(x,0,2), t3(y,0,1)
 *   
 *   t1,t2,t3 doesn't work, but t2,t1,t3 does!
 * </pre>
 * 
 * </p>
 * 
 * @author Jens von Pilgrim
 * @version $Revision: 966 $
 * @since Dec 13, 2008
 */
public class TriggerMatcher {
	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(TriggerMatcher.class
		.getName());

	TraceRegistry traceRegistry;

	// MetamodelManager metamodelManager;

	transient Map<Trigger, String[]> cachedMultipleParameterNames;

	transient Map<Trigger, IndexTranslationRow[]> cachedIndexTranslationTable;

	transient Trigger currentTrigger;

	transient IndexTranslationRow[] currentIndexMapper;

	/**
	 * Maps the index of a rule in the trigger to the index of a rule in an
	 * optimized order, see {@link #getRuleRefOrder(Trigger, Trace, int[])}.
	 */
	transient int[] currentRuleRefOrder;

	transient int currentMax;

	transient List<Trace>[] currentSearchSpace;

	transient Trace currentTrace;

	transient List<List<Trace>> allResults;

	transient List<Trace> currentSelectionInOptimizedOrder;

	/**
	 * Contains the values of the multiple parameters, that is the values
	 * matching the parameters names calculated in
	 * {@link #getMultipleParameterNames(Trigger)}.
	 */
	transient MObject[] currentValues;

	transient int currentRuleIndex;

	private MetamodelManager metamodelManager;

	/**
	 * @param traceRegistry
	 */
	public TriggerMatcher(TraceRegistry traceRegistry) {
		if (traceRegistry == null) {
			throw new NullPointerException("traceRegistry must not be null");
		}

		this.traceRegistry = traceRegistry;
		metamodelManager = traceRegistry.getMetamodelManager();
		cachedMultipleParameterNames = new HashMap<Trigger, String[]>();
		cachedIndexTranslationTable =
			new HashMap<Trigger, IndexTranslationRow[]>();
	}

	/**
	 * Resolves all values of a triggered rule. Precondition: If a parameter has
	 * the same name in multiple rule references, its types must be compatible.
	 * This must be checked before.
	 * 
	 * @todo check precondition of compatible types in triggers
	 * @param trigger The rule which is possibly triggered
	 * @param current The trace created by triggering rule
	 * @param triggeringRule The rule which triggered the process, this rule is
	 *            expected to be not yet registered in {@link TraceRegistry}.
	 * @return list of traces in the order of the referenced rules, or null if
	 *         not all traces (i.e. RuleReferences) could be resolved.
	 */
	public List<List<Trace>>
			resolveTriggerValues(Trigger trigger, Trace current) {
		reset();

		if (log.isLoggable(Level.INFO)) {
			log.info("Resolve trigger " + trigger + " for trace " + current); //$NON-NLS-1$
			log.info(String.valueOf(traceRegistry));
		}

		currentTrigger = trigger;
		currentTrace = current;

		// create index maps
		currentIndexMapper = getParameterIndexMappings(trigger);

		// sort rule references, i.e. sort indices
		currentRuleRefOrder = new int[trigger.getTriggerRules().size()];
		currentMax = getRuleRefOrder(trigger, current, currentRuleRefOrder);

		// create search space
		currentSearchSpace = createSearchSpace(trigger);

		if (log.isLoggable(Level.INFO)) {
			StringBuilder strb = new StringBuilder();
			int i = 0;
			for (List<Trace> row : currentSearchSpace) {
				strb.append(i++).append(" / ");
				for (Trace trace : row) {
					strb.append(trace);
					strb.append(" / ");
				}
				strb.append("\n");
			}

			log.info("Current Search Space:\n" + strb.toString()); //$NON-NLS-1$
		}

		allResults = new ArrayList<List<Trace>>();

		currentRuleIndex = 0;
		currentSelectionInOptimizedOrder =
			new ArrayList<Trace>(trigger.getTriggerRules().size());
		currentValues = new MObject[getMultipleParameterNames(trigger).length];

		// search
		search();

		// clean up (only big junks)
		currentSearchSpace = null;
		currentSelectionInOptimizedOrder = null;

		return allResults;

	}

	/**
	 * Resets all members used for resolving a trigger, this is mainly used for
	 * debug reasons in order to sync {@link #toString()}.
	 */
	private void reset() {
		currentTrigger = null;
		currentIndexMapper = null;
		currentRuleRefOrder = null;
		currentMax = -1;
		currentSearchSpace = null;
		currentTrace = null;
		allResults = null;
		currentSelectionInOptimizedOrder = null;
	}

	/**
	 * Searches for matching traces of current rule.
	 */
	private void search() {

		int ruleIndex = currentRuleRefOrder[currentRuleIndex];

		if (!traceInSelection(currentTrace)) {
			if (currentRuleIndex == currentMax) {
				// perform one last test with current trace, we can skip
				// the rest since the current trace must be contained in
				// a result (and cannot be after the following test
				testAndSearch(currentTrace, ruleIndex);
				return;
			}
			if (currentRuleIndex == currentMax) {
				return; // do not proceed, current trace was not selected
				// and can not be selected anymore
			}
		}

		// search in search space:
		for (Trace trace : currentSearchSpace[ruleIndex]) {
			if (!traceInSelection(trace)) {
				testAndSearch(trace, ruleIndex);
			}
		}

	}

	/**
	 * Tests if parameters of a given trigger rule were unified with given
	 * trace, matches current selection. If it matches, it is added the
	 * selection and a trace for the following rules is searched. If there are
	 * no more rules, that is a result was found, the result is saved.
	 * 
	 * @param trace
	 * @param ruleIndex
	 */
	private void testAndSearch(Trace trace, int ruleIndex) {
		boolean bMatched = trace.getElements().size() > 0;

		if (!bMatched) { // short cut: no traces found for current reference.
			// Actually this must not happen since traces without elements are
			// not possible.
			if (log.isLoggable(Level.WARNING)) {
				log.warning("No match, trace " //$NON-NLS-1$
					+ trace + " contains no elements"); //$NON-NLS-1$
			}
			return;
		}

		Stack<Integer> stack = new Stack<Integer>();

		// get parameter translation row of current rule
		IndexTranslationRow rulesIndexTranslationRow =
			currentIndexMapper[ruleIndex];
		int iNumberOfDuplicateParams = rulesIndexTranslationRow.size();
		// do not iterate through all parameters, instead compare only
		// duplicate parameters using index translation table of current rule
		for (int i = 0; i < iNumberOfDuplicateParams; i++) {
			TraceElement element =
				trace.getElements().get(
						rulesIndexTranslationRow.getFromIndex(i));
			MObject elementValue = TracePolicy.getTraceElementValue(element, metamodelManager);
			int refValueIndex = rulesIndexTranslationRow.getToIndex(i);
			// parameter was not set before, so we set it to the current value:
			if (currentValues[refValueIndex] == null) {
				currentValues[refValueIndex] = elementValue;
				// store this index, the value is to deleted when this trace
				// is no longer tested (or in selection):
				stack.push(refValueIndex);
			} else if (!currentValues[refValueIndex].equals(elementValue)) {
				// not matched
				bMatched = false;

				if (log.isLoggable(Level.INFO)) {
					log.info("No match, trace element " //$NON-NLS-1$
						+ elementValue
						+ " differs from previous ones"); //$NON-NLS-1$
				}

				break;
			} // else matched, go on
		}

		if (bMatched) { // add this trace to the selection and search rest
			currentSelectionInOptimizedOrder.add(trace);
			currentRuleIndex++; // search matching trace for next rule...
			if (currentRuleIndex == currentRuleRefOrder.length) { // no rest,
				// i.e. we found a result!
				allResults.add(remapOptimizedSelection());

				if (log.isLoggable(Level.INFO)) {
					log.info("Found Result: " + currentSelectionInOptimizedOrder); //$NON-NLS-1$
				}
			} else { // search the rest
				search(); // recursive call!
			}
			// however: remove this trace after the recursive search (or
			// saving the result), in order to find other matches:
			currentRuleIndex--;
			currentSelectionInOptimizedOrder
				.remove(currentSelectionInOptimizedOrder.size() - 1); // pop
		}

		// clear values set by current test:
		while (!stack.isEmpty()) {
			currentValues[stack.pop()] = null;
		}

	}

	/**
	 * Re-maps the current selection of traces (which is in optimized order)
	 * back to the original rule order as found in the trigger.
	 * 
	 * @return
	 */
	private List<Trace> remapOptimizedSelection() {
		int iLength = currentSelectionInOptimizedOrder.size();
		List<Trace> remappedSelection = new ArrayList<Trace>(iLength);
		for (int i = 0; i < iLength; i++) {
			remappedSelection.add(currentSelectionInOptimizedOrder
				.get(currentRuleRefOrder[i]));

		}
		return remappedSelection;
	}

	/**
	 * Returns true if the given trace is found in the current select.
	 * 
	 * @param trace
	 * @return true, if traced is found in current selection
	 */
	private boolean traceInSelection(Trace trace) {
		for (Trace selected : currentSelectionInOptimizedOrder) {
			if (trace == selected) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Creates search space for given trigger. The search space is a table, its
	 * number of rows equal the number of triggering methods (i.e. rule
	 * references), each row contains all traces matching this rule reference
	 * i.e. its declaration.
	 * 
	 * @param trigger
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<Trace>[] createSearchSpace(Trigger trigger) {
		List<Trace>[] searchSpace =
			(List<Trace>[]) new List<?>[trigger.getTriggerRules().size()];

		for (int i = 0; i < trigger.getTriggerRules().size(); i++) {
			RuleReference ref = trigger.getTriggerRules().get(i);

			// maybe we had the same rule/row previously:
			for (int j = 0; j < i; j++) {
				RuleReference prev = trigger.getTriggerRules().get(j);
				if (ref.getRuleDeclaration() == prev.getRuleDeclaration()) {
					searchSpace[i] = searchSpace[j];
				}
			}
			if (searchSpace[i] == null) { // create row:
				searchSpace[i] =
					traceRegistry.getTraces(ref.getRuleDeclaration());
				if (searchSpace[i] == null) { // set empty list to avoid NPEs
					// later
					searchSpace[i] = Collections.emptyList();
				}
			}
		}

		return searchSpace;

	}

	/**
	 * Creates an index translation table mapping the index of a rule reference
	 * as it appears in the trigger to an optimized index, such that all rule
	 * references matching the current trigger are sorted first.
	 * <p>
	 * Example:
	 * <dl>
	 * <dt>given</dt>
	 * <dd>ruleref_0, ruleref_1, ruleref_2<br/>
	 * current trace matches ruleref_2</dd>
	 * <dt>return:</dt>
	 * <dd>ruleRefOrder=[2,1,0], returns 0</dd>
	 * </dl>
	 * What does that mean? The first rule to evaluate later is ruleref_2, the
	 * second ruleref_1 and the third one ruleref_0. The last index, in which
	 * the current trace can be found, is 0, i.e. ruleref_2.
	 * </p>
	 * 
	 * @param trigger the current trigger
	 * @param current the current trace, rule matching this trace are sorted
	 *            first
	 * @param io_ruleRefOrder the sort order
	 * @return the highest index in io_ruleRefOrder containing the current trace
	 * @throws IllegalArgumentException if current trace doen't match any rule
	 *             reference
	 */
	private int getRuleRefOrder(Trigger trigger, Trace current,
			int[] io_ruleRefOrder) {
		// tricky (up and down)
		int length = trigger.getTriggerRules().size();
		int up = 0;
		int down = length - 1;
		RuleReference ruleRef;

		for (int indexOfRuleInTrigger = 0; indexOfRuleInTrigger < length; indexOfRuleInTrigger++) {
			ruleRef = trigger.getTriggerRules().get(indexOfRuleInTrigger);
			if (match(current, ruleRef)) {
				io_ruleRefOrder[indexOfRuleInTrigger] = up;
				up++;
			} else {
				io_ruleRefOrder[indexOfRuleInTrigger] = down;
				down--;
			}
		}

		if (up == 0) {
			throw new IllegalArgumentException("Current trace (" + current
				+ ") didn't match any trigger rule ("
				+ trigger.getTriggerRules() + ")");
		}

		return up - 1;
	}

	/**
	 * Returns a list of names sorted in ascending order of all parameters
	 * appearing in more then one rule reference. The types of the parameters
	 * are not checked here, this must have been done before (e.g. in the
	 * {@link SemanticChecker}). The ordering is is used to make the list
	 * deterministic.
	 * <p>
	 * The lists are cached in order to optimize performance.
	 * </p>
	 * <p>
	 * An example is given in {@link #getParameterIndexMappings(Trigger)}
	 * </p>
	 * 
	 * @param trigger
	 * @return list of names in ascending order
	 */
	@SuppressWarnings("unchecked")
	private String[] getMultipleParameterNames(Trigger trigger) {
		String[] mplist = cachedMultipleParameterNames.get(trigger);
		if (mplist == null) {
			TreeSet<String> multipleParameters = new TreeSet<String>();
			Set<String> allParameters = new HashSet<String>();
			String name;
			for (QualifiedRuleReference ref : trigger.getTriggerRules()) {

				for (QualifiedParameterReference pref : ComposedIterable
					.compose(ref.getParameterReferences(),
							ref.getReturnReferences())) {

					name = pref.getVardecl().getName();
					if (!allParameters.add(name)) {
						multipleParameters.add(name);
					}
				}
			}
			mplist = new String[multipleParameters.size()];
			multipleParameters.toArray(mplist);
			Arrays.sort(mplist);
			cachedMultipleParameterNames.put(trigger, mplist);
		}
		return mplist;
	}

	/**
	 * Returns a list of integer pairs which translates the parameter index of a
	 * rule reference to the index of the parameter in a reference list. The
	 * reference list is created in {@link #getMultipleParameterNames(Trigger)},
	 * it contains all parameters found in at least two rule references. For
	 * each rule reference of the trigger a row in the index translation table
	 * is created. For each parameter a column in the table contains a mapping
	 * form the index of the parameter in the rule reference to the the
	 * parameter's index of the reference table. This table is then sealed, that
	 * is the memory space is adjusted.
	 * <p>
	 * Example: (only the names of the parameters are given here)
	 * <dl>
	 * <dt>given</dt>
	 * <dd>ruleref_0(a,b,c), ruleref_1(b,d,e), ruleref_2(c,e)</dd>
	 * <dt>reference list:</dt>
	 * <dd>the reference list calculated in
	 * {@link #getMultipleParameterNames(Trigger)} will look like [b,c,d,e]
	 * <dt>the table:</dt>
	 * <dd>
	 * <table>
	 * <tr>
	 * <td>ruleref_0:</td>
	 * <td>1-0 (b)</td>
	 * <td>2-1 (c)</td>
	 * </tr>
	 * <tr>
	 * <td>ruleref_1:</td>
	 * <td>0-0 (b)</td>
	 * <td>1-2 (d)</td>
	 * <td>2-2 (e)</td>
	 * </tr>
	 * <tr>
	 * <td>ruleref_2:</td>
	 * <td>0-1 (c)</td>
	 * <td>1-3 (e)</td>
	 * </tr>
	 * </table>
	 * </dd>
	 * </dl>
	 * </p>
	 * 
	 * @todo do we have to consider the declaration of the triggered rule?
	 * @param trigger
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private IndexTranslationRow[] getParameterIndexMappings(Trigger trigger) {
		IndexTranslationRow[] indexMapper =
			cachedIndexTranslationTable.get(trigger);
		if (indexMapper == null) {
			String[] parameterReferenceList =
				getMultipleParameterNames(trigger);
			indexMapper =
				new IndexTranslationRow[trigger.getTriggerRules().size()];

			int toIndex, fromIndex, ruleCount = 0;

			for (QualifiedRuleReference ref : trigger.getTriggerRules()) {
				indexMapper[ruleCount] =
					new IndexTranslationRow(parameterReferenceList.length);
				fromIndex = 0;
				for (QualifiedParameterReference pref : ComposedIterable
					.compose(ref.getParameterReferences(),
							ref.getReturnReferences())) {
					toIndex =
						indexOf(parameterReferenceList, pref.getVardecl()
							.getName());
					if (toIndex >= 0) {
						indexMapper[ruleCount].put(fromIndex, toIndex);
					}
					fromIndex++;
				}
				indexMapper[ruleCount].seal();
				ruleCount++;
			}
			cachedIndexTranslationTable.put(trigger, indexMapper);
		}
		return indexMapper;
	}

	/**
	 * Returns the index of the given name in the list of strings. The list is
	 * assumed to be sorted in ascending order.
	 * 
	 * @param strings
	 * @param name
	 * @return index of name in strings or -1, if is is not found
	 */
	private static int indexOf(String[] strings, String name) {
		for (int i = 0; i < strings.length; i++) {
			switch (strings[i].compareTo(name)) {
			case 0:
				return i;
			case 1:
				return -1;
			}
		}
		return -1;
	}

	boolean match(Trace trace, RuleReference ruleRef) {
		int iSize = trace.getElements().size();
		List<Type> parameterTypes =
			MitraUtils.retrieveRuleRefParameterTypes(ruleRef);
		if (iSize != parameterTypes.size()) {
			return false;
		}

		String fqnRuleName = MitraUtils.fqn(ruleRef);

		if (!fqnRuleName.equals(trace.getRuleName())) {
			return false;
		}

		for (int i = 0; i < iSize; i++) {
			TraceElement traceElement = trace.getElements().get(i);
			MObject mobj =
				TracePolicy
					.getTraceElementValue(traceElement, metamodelManager);
			if (!metamodelManager.isSubType(mobj.getActualType(),
					parameterTypes.get(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Convenience method, returns {@link MetamodelManager#getMetamodel(Type)}.
	 * 
	 * @param actualtype
	 * @return
	 * @throws MetamodelNotFoundException
	 */
	protected IMetamodel getMetamodel(Type type)
			throws MetamodelNotFoundException {
		return metamodelManager.getMetamodel(type);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		if (currentTrigger == null || currentTrace == null) {
			return "TriggerMatcher pending";
		}

		StringBuilder result = new StringBuilder();
		result.append("Trigger: ").append(currentTrigger).append("\n");
		result.append("Current trace: ").append(currentTrace).append("\n");

		result.append("Rule References in Trigger:\n");
		int i = 0;
		for (QualifiedRuleReference ref : currentTrigger.getTriggerRules()) {
			result.append(i).append(": ").append(ref.toString()).append("\n");
			i++;
		}

		if (currentRuleRefOrder == null) {
			result.append("Rule's order not optimized yet\n");
		} else {
			int iRuleIndexInTrigger = 0;
			result.append("Optimized order: { ");
			for (int iOptimizedOrder : currentRuleRefOrder) {
				if (iRuleIndexInTrigger > 0) {
					result.append(", ");
				}
				result.append("(").append(iRuleIndexInTrigger).append("->")
					.append(iOptimizedOrder).append(")");
				iRuleIndexInTrigger++;
			}
			result.append("}\n");
			result.append("Current trace appears at last in optimized index ")
				.append(currentMax).append("\n");
		}

		return result.toString();
	}

}
