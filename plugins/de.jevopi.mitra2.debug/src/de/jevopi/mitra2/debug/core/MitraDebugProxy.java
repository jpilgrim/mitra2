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
package de.jevopi.mitra2.debug.core;

import static de.jevopi.mitra2.debug.core.IDebuggerState.StateID.RESUMED;
import static de.jevopi.mitra2.debug.core.IDebuggerState.StateID.STEPINTO;
import static de.jevopi.mitra2.debug.core.IDebuggerState.StateID.STEPOVER;
import static de.jevopi.mitra2.debug.core.IDebuggerState.StateID.STEPOVER_FUNCTION;
import static de.jevopi.mitra2.debug.core.IDebuggerState.StateID.STEPRETURN;
import static de.jevopi.mitra2.debug.core.IDebuggerState.StateID.SUSPENDED;
import static de.jevopi.mitra2.debug.core.IDebuggerState.StateID.TERMINATED;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import de.jevopi.mitra2.debug.core.IDebuggerState.StateID;
import de.jevopi.mitra2.debug.model.MitraDebugElement;
import de.jevopi.mitra2.debug.model.MitraDebugTarget;
import de.jevopi.mitra2.debug.model.MitraStackFrame;
import de.jevopi.mitra2.debug.model.MitraValue;
import de.jevopi.mitra2.debug.model.MitraVariable;
import de.jevopi.mitra2.engine.debug.DebugEventType;
import de.jevopi.mitra2.engine.debug.IDebugableListener;
import de.jevopi.mitra2.engine.debug.IDebuggable;
import de.jevopi.mitra2.engine.interpreter.StackFrame;
import de.jevopi.mitra2.engine.interpreter.Variable;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.xtext.utils.XtextUtils;

/**
 * MitraDebugProxy There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @since Mitra 1
 */
public class MitraDebugProxy extends MitraDebugElement implements IDebugProxy,
		IDebugableListener {
	/**
	 * Thread "listening" to incoming events from the interpreter.
	 */
	private class ProcessEventHandler extends Thread {

		@Override
		public void run() {

			while (currentState.getStateId() != TERMINATED) {
				if (breakpoints != null) {
					// DebugEventType event = consumeEvent();
					DebugEventType event = eventQueue.poll();
					if (event != null && event != DebugEventType.idle) {
						try {
							switch (event) {
							case statement_finished:
								currentState.handleExitStatement();
								break;
							case resumed:
								interpreter.resume();
								break;
							case rule_enter:
								currentState.handleEnterFunction();
								break;
							case rule_left:
								currentState.handleExitFunction();
								break;
							case terminated:
								currentState.handleTerminate();
								break;
							}
						} catch (Exception e) {

							e.printStackTrace();
						}
					} else {
						try {
							sleep(50);
						} catch (Exception ex) {
							log.info(ex.toString());
						}
					}
				}
			}

		}
	}

	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(MitraDebugProxy.class
		.getName());

	private Vector<IBreakpoint> breakpoints;

	private IBreakpoint currentBreakpoint;

	private IDebuggerState currentState;

	private LinkedBlockingQueue<DebugEventType> eventQueue;

	private IDebuggable interpreter;

	private IDebuggerObserver observer;

	private ProcessEventHandler processEventHandler;

	private Map<IDebuggerState.StateID, IDebuggerState> states;

	public MitraDebugProxy(IDebuggable interpreter) {
		initStates();

		eventQueue = new LinkedBlockingQueue<DebugEventType>();
		this.interpreter = interpreter;
		this.interpreter.addInterpreterListener(this);
		currentState = getState(RESUMED);

		processEventHandler = new ProcessEventHandler();
		processEventHandler.setName("MitraListener");
		processEventHandler.start();

	}

	@Override
	public void addBreakpoint(IBreakpoint breakpoint) {
		if (breakpoints == null) {
			breakpoints = new Vector<IBreakpoint>();
		}
		breakpoints.add(breakpoint);

	}

	@Override
	public void addBreakpoints(IBreakpoint[] defferedBreakpoints) {
		if (breakpoints == null) {
			breakpoints = new Vector<IBreakpoint>();
		}
		for (int i = 0; i < defferedBreakpoints.length; i++) {
			breakpoints.add(defferedBreakpoints[i]);
		}

	}

	@Override
	public synchronized boolean checkBreakpoints() {

		try {
			int currentLineNumber = getCurrentLine();
			String currentSourceFile = getSourcefile();
			if (currentSourceFile == null) {
				return false;
			}
			for (IBreakpoint breakpoint : breakpoints) {
				String modelId = breakpoint.getModelIdentifier();
				if (modelId.equals(getModelIdentifier())) {
					if (breakpoint instanceof ILineBreakpoint) {
						ILineBreakpoint linebreakpoint =
							(ILineBreakpoint) breakpoint;
						int lineNumber = linebreakpoint.getLineNumber();
						String sourceFile =
							linebreakpoint.getMarker().getResource()
								.getLocation().toOSString();
						if (lineNumber == currentLineNumber
							&& sourceFile.equals(currentSourceFile)) {
							return true;
						}
					}
				}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	IBreakpoint getCurrentBreakpoint() {
		return currentBreakpoint;
	}

	@Override
	public int getCurrentLine() {
		return XtextUtils.getStartLine(interpreter.getCurrentElement());
	}

	@Override
	public synchronized IDebuggable getDebuggable() {
		return interpreter;
	}

	@Override
	public IVariable[] getlocalVariables(IStackFrame stackFrame) {
		try {
			MitraStackFrame mitraStackFrame = (MitraStackFrame) stackFrame;
			StackFrame interpreterStackFrame =
				interpreter.getStackFrame(mitraStackFrame.getIdentifier());
			if (interpreterStackFrame != null) {
				List<Variable> variables = interpreterStackFrame.getVariables();
				IVariable[] debugModelVariables =
					new IVariable[variables.size()];
				int i = 0;
				for (Variable variable : variables) {
					MObject value = variable.getValue();
					String varName =
						variable.getVariableDeclaration().getName();
					MitraVariable debugModelVariable =
						new MitraVariable(mitraStackFrame, varName);

					debugModelVariable
						.setValue(new MitraValue((MitraDebugTarget) observer,
							debugModelVariable, value));
					debugModelVariables[i] = debugModelVariable;
					i++;
				}
				return debugModelVariables;
			}
		} catch (DebugException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new IVariable[0];
	}

	@Override
	public String getSourcefile() {
		EObject eobj = interpreter.getCurrentElement();
		if (eobj != null) {
			Resource res = eobj.eResource();
			if (res != null) {
				if (res.getURI() != null) {
					return res.getURI().toFileString();
				}
			}
		}
		return null;
	}

	@Override
	public synchronized IStackFrame[] getStackFrames() {
		try {
			List<StackFrame> interpreterStackFrames =
				interpreter.getStackFrames();
			// less one, skip initial (manual) invocation
			IStackFrame[] debugModelStackFrames =
				new IStackFrame[interpreterStackFrames.size() - 1];
			int lineNumber = 0;
			for (int i = 0; i < interpreterStackFrames.size() - 1; i++) {
				StackFrame interpreterStackFrame =
					interpreterStackFrames.get(interpreterStackFrames.size()
						- i - 1);
				RuleDeclaration decl =
					interpreterStackFrame.getRuleDeclaration();
				String stackName =
					interpreterStackFrame.getRuleDeclaration().getName();
				String sourceFile = null;
				if (decl.eResource() != null) {
					sourceFile = decl.eResource().getURI().toFileString();
				}
				int id = interpreterStackFrame.getID();

				if (i == 0) {
					lineNumber = XtextUtils.getStartLine(interpreter.getCurrentElement());
				} else {
					lineNumber = XtextUtils.getStartLine(interpreterStackFrame
							.getRuleInvocationLocation());
					if (lineNumber<0) {
						lineNumber = XtextUtils.getStartLine(interpreterStackFrame
								.getRuleDeclaration());
					}
				}
				IThread[] threads = observer.getThreads();
				IThread thread = threads[0];
				IStackFrame modelStackFrame =
					new MitraStackFrame(thread, stackName, sourceFile, id,
						lineNumber);
				debugModelStackFrames[i] = modelStackFrame;
			}
			return debugModelStackFrames;
		} catch (DebugException e) {
			e.printStackTrace();
		}
		return new IStackFrame[0];
	}

	public IDebuggerState getState(StateID stateID) {
		return states.get(stateID);
	}

	private void initStates() {
		states = new EnumMap<StateID, IDebuggerState>(StateID.class);

		states.put(SUSPENDED, new SuspendedState(this));
		states.put(RESUMED, new ResumedState(this));
		states.put(TERMINATED, new TerminatedState(this));
		states.put(STEPOVER, new StepOverState(this));
		states.put(STEPOVER_FUNCTION, new StepOverFunctionState(this));
		states.put(STEPINTO, new StepIntoState(this));
		states.put(STEPRETURN, new StepReturnState(this));
	}

	@Override
	public synchronized boolean isStepping() {
		StateID stateId = currentState.getStateId();
		boolean isStepping =
			(stateId == STEPINTO || stateId == STEPOVER
				|| stateId == STEPOVER_FUNCTION || stateId == STEPRETURN);
		return isStepping;
	}

	@Override
	public boolean isSuspended() {
		boolean isSuspended = currentState.getStateId() == SUSPENDED;
		return isSuspended;
	}

	@Override
	public boolean isTerminated() {
		boolean isTerminated = currentState.getStateId() == TERMINATED;
		return isTerminated;
	}

	@Override
	public void processDebugableEvent(DebugEventType event) {
		try {
			if (!eventQueue.offer(event)) {
				throw new InterruptedException();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void removeBreakpoint(IBreakpoint breakpoint) {
		breakpoints.remove(breakpoint);

	}

	@Override
	public void resume() {
		if (log.isLoggable(Level.INFO)) {
			log.info("resume"); //$NON-NLS-1$
		}

		observer.resumed(DebugEvent.RESUME);
		currentState.handleResume();
	}

	@Override
	public void resumeInterpreter() {
		processDebugableEvent(DebugEventType.resumed);
	}

	public void setCurrentBreakpoint(IBreakpoint breakpoint) {
		currentBreakpoint = breakpoint;
	}

	@Override
	public synchronized void setCurrentState(StateID stateID) {
		currentState = getState(stateID);
		currentState.activate();
	}

	@Override
	public synchronized void setDebugTarget(IDebuggerObserver target) {
		if (target instanceof MitraDebugTarget) {
			observer = target;
		} else {
			throw new RuntimeException(
				"Unsuppported IDebugTarget implementation");
		}

	}

	@Override
	public void stepInto() {
		observer.resumed(DebugEvent.RESUME);
		currentState.handleStepInto();
	}

	@Override
	public void stepOver() {
		observer.resumed(DebugEvent.RESUME);
		currentState.handleStepOver();
	}

	@Override
	public void stepReturn() {
		observer.resumed(DebugEvent.RESUME);
		currentState.handleStepReturn();
	}

	@Override
	public void suspend() {
		currentState.handleSuspend(DebugEvent.SUSPEND);
	}

	@Override
	public void suspended() {

	}

	@Override
	public void suspended(int detail) {

		if (observer != null) {
			if (detail == DebugEvent.BREAKPOINT) {
				observer.suspended(currentBreakpoint);
				// this.currentBreakpoint = null;
			}
			observer.suspended(detail);
		}

	}

	@Override
	public void terminate() {
		interpreter.terminate();
		currentState.handleTerminate();

	}

	@Override
	public void terminated() {
		observer.terminated();

	}

	/*
	 * *************************************************************************
	 * toString etc.
	 * **********************************************************************
	 */

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("DebugProxy: ");
		result.append("Current State: ").append(String.valueOf(currentState));
		if (currentBreakpoint != null) {
			result.append(", Current Breakpoint: ").append(
					String.valueOf(currentBreakpoint));
		}
		return result.toString();
	}

}
