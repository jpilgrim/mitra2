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

import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IVariable;

import de.jevopi.mitra2.debug.core.IDebuggerState.StateID;
import de.jevopi.mitra2.engine.debug.IDebuggable;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Mitra 1
 */
public interface IDebugProxy {

	void addBreakpoint(IBreakpoint breakpoint);

	void addBreakpoints(IBreakpoint[] breakpoints);

	boolean checkBreakpoints();

	int getCurrentLine();

	IDebuggable getDebuggable();

	IVariable[] getlocalVariables(IStackFrame stackFrame);

	String getSourcefile();

	IStackFrame[] getStackFrames();

	boolean isStepping();

	boolean isSuspended();

	boolean isTerminated();

	void removeBreakpoint(IBreakpoint breakpoint);

	void resume();

	void resumeInterpreter();

	void setCurrentState(StateID currentState);

	void setDebugTarget(IDebuggerObserver target);

	void stepInto();

	void stepOver();

	void stepReturn();

	void suspend();

	void suspended(int detail);

	void terminate();

	void terminated();

}
