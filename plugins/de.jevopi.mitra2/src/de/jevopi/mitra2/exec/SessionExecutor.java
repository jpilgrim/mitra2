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

package de.jevopi.mitra2.exec;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.engine.RuleResolver;
import de.jevopi.mitra2.engine.debug.DebugEventType;
import de.jevopi.mitra2.engine.debug.DebugableInterpreter;
import de.jevopi.mitra2.engine.debug.IDebugableListener;
import de.jevopi.mitra2.engine.debug.IDebuggable;
import de.jevopi.mitra2.engine.debug.TransactionalDebugableInterpreter;
import de.jevopi.mitra2.engine.interpreter.ExecutionContext;
import de.jevopi.mitra2.engine.interpreter.SessionContext;
import de.jevopi.mitra2.exec.IResultProcessor.Result;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.traces.TraceRecord;

/**
 * The executor is a facade for the Mitra interpreter. Since the interpreter is
 * usually running asynchronously, it is especially important not to directly
 * access the interpreter or its context. The facade is to be used as follows:
 * <dl>
 * <dt>Set up executor</dt>
 * <dd>This has to be done only once (or if the build modules have been
 * changed). Set the build modules via {@link #setBuiltModules(Collection)} and
 * the metamodel manager (retrieved from the builder) via
 * {@link #setMetamodelManager(IMetamodelManager)} (This is all usually done by
 * the {@link MitraEngine}.</dd>
 * <dt>Set up interpreter</dt>
 * <dd>Set rule to be executed ({@link #setRuleToExecute(FQN)} and arguments (
 * {@link #setArguments(Collection)}). If you want to enable triggers, set the
 * trace record (which can be reused) via {@link #setTraceRecord(TraceRecord)}</dd>
 * <dt>Get runnable and start it</dt>
 * <dd>Get the runnable interpreter via {@link #prepareInterpreter()}, this
 * runnable can be started directly or in its own thread.</dd>
 * <dt>Control interpreter during execution</dt>
 * <dd>If the interpreter is started in its own thread, the execution can be
 * debugged via the {@link IDebuggable} interface (see {@link #getDebugable()}).
 * </dd>
 * <dt>Retrieve results</dt>
 * <dd>Ensure that interpreter has terminated ({@link #isTerminated()}), get
 * reslts via {@link #getResults()}. Possible errors can be retrieved via
 * {@link #getErrors()} all the time.</dd>
 * </dl>
 * 
 * @author Jens von Pilgrim
 */
public class SessionExecutor implements IDebugableListener {

	ProjectContext projectContext;

	SessionContext sessionContext;

	private DebugableInterpreter interpreter;

	private Map<String, Object> result;

	private String fqnRuleToExecute;

	private Object[] arguments;

	protected Vector<IDebugableListener> preparedListeners;

	private IResultProcessor resultProcessor;

	/**
	 * 
	 */
	public SessionExecutor(ProjectContext projectContext,
			SessionContext sessionContext) {
		this.projectContext = projectContext;
		this.sessionContext = sessionContext;

		interpreter = null;
		preparedListeners = new Vector<IDebugableListener>(2);
		result = Collections.emptyMap();

		fqnRuleToExecute = null;
		arguments = null;
	}

	public synchronized Runnable prepareInterpreter() {
		if (interpreter != null && interpreter.isActive()) {
			throw new IllegalStateException("Interpreter is still active.");
		}

		interpreter = new TransactionalDebugableInterpreter(sessionContext,
				createExecutionContext());
		result = Collections.emptyMap();

		// add executor in order to collect results
		interpreter.addInterpreterListener(this);

		for (IDebugableListener listener : preparedListeners) {
			interpreter.addInterpreterListener(listener);
		}
		clearPreparedDebugableListener(); // only for one run, executor is
		// reused

		return interpreter;
	}

	/**
	 * @return
	 */
	protected ExecutionContext createExecutionContext() {
		RuleResolver ruleResolver = new RuleResolver(projectContext);
		MObject[] wrappedArguments = wrapArguments();
		RuleDeclaration invokedRule = ruleResolver.findBestMatchingRule(
				fqnRuleToExecute, wrappedArguments);

		ExecutionContext executionContext = new ExecutionContext(invokedRule,
				Arrays.asList(wrappedArguments));
		return executionContext;
	}

	/**
	 * @return
	 */
	private MObject[] wrapArguments() {
		MObject[] wrappedArguments = new MObject[arguments.length];
		MetamodelManager metamodelManager = projectContext
				.getMetamodelManager();
		for (int i = 0; i < arguments.length; i++) {
			wrappedArguments[i] = metamodelManager.wrap(arguments[i]);
		}
		return wrappedArguments;
	}

	public boolean isTerminated() {
		return (interpreter != null && interpreter.isTerminated());
	}

	/**
	 * @param arguments the arguments to set
	 */
	public void setArguments(MObject[] arguments) {
		this.arguments = arguments;
	}

	public IDebuggable getDebugable() {
		return interpreter;
	}

	/**
	 * Adds a listener to the interpreter. Note that this method only prepares
	 * the listener, as the interpreter is only created when the execution
	 * actually takes place.
	 * 
	 * @param i_debugableListener
	 * @return
	 * @see java.util.Vector#add(java.lang.Object)
	 */
	public void prepareDebugableListener(IDebugableListener i_debugableListener) {
		if (i_debugableListener != null) {
			preparedListeners.add(i_debugableListener);
		}
	}

	/**
	 * Remove all listener from the interpreter. Note that this method has no
	 * effect on an actually running interpreter.
	 * 
	 * @see java.util.Vector#clear()
	 */
	public void clearPreparedDebugableListener() {
		preparedListeners.clear();
	}

	/**
	 * Removes a listener from the interpreter.
	 * 
	 * @param i_o
	 * @return
	 * @see java.util.Vector#remove(java.lang.Object)
	 */
	public void removeDebugableListener(IDebugableListener i_debugableListener) {
		if (i_debugableListener != null) {
			preparedListeners.remove(i_debugableListener);
			if (interpreter != null) {
				interpreter.removeInterpreterListener(i_debugableListener);
			}
		}
	}

	/**
	 * {@inheritDoc} Does nothing since we're only interested in termination
	 * 
	 * @see de.feu.mitra.engine.debugapi.IDebugableListener#processDebugableEvent(de.feu.mitra.engine.debugapi.DebugEventType)
	 */
	@Override
	public void processDebugableEvent(DebugEventType i_eventType) {
	}

	/**
	 * {@inheritDoc} Does nothing since we're only interested in termination
	 * 
	 * @see de.feu.mitra.engine.debugapi.IDebugableListener#suspended()
	 */
	@Override
	public void suspended() {
	}

	/**
	 * @see de.feu.mitra.engine.debugapi.IDebugableListener#terminated()
	 */
	@Override
	public void terminated() {
		ExecutionContext executionContext = interpreter.getExecutionContext();
		Map<String, MObject> mitraResult = executionContext.getResults();

		result = new HashMap<String, Object>();

		for (Entry<String, MObject> entry : mitraResult.entrySet()) {
			result.put(entry.getKey(), entry.getValue().getValue());
		}

		if (resultProcessor != null) {
			resultProcessor.resultArrived(new Result(result));
		}
	}

	/**
	 * @param i_resultProcessor the resultProcessor to set
	 */
	public void setResultProcessor(IResultProcessor i_resultProcessor) {
		resultProcessor = i_resultProcessor;
	}

}
