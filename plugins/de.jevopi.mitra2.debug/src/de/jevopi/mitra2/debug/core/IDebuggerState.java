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

/**
 * IDebuggerState There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @since Mitra 1
 */
public interface IDebuggerState {

	enum StateID {
		RESUMED, STEPINTO, STEPOVER, //
		STEPOVER_FUNCTION, STEPRETURN, SUSPENDED, TERMINATED
	}

	/**
	 * Called by the debugger when the state is activated.
	 */
	public void activate();

	/**
	 * Called by the debugger when the state is deacivated.
	 */
	public void deactivate();

	public StateID getStateId();

	public void handleBlockEntered();

	public void handleBlockLeft();

	public void handleBreakpoint();

	public void handleEnterFunction();

	public void handleExitFunction();

	public void handleExitStatement();

	public void handleResume();

	public void handleStepInto();

	public void handleStepOver();

	public void handleStepReturn();

	public void handleSuspend(int detail);

	public void handleTerminate();

}