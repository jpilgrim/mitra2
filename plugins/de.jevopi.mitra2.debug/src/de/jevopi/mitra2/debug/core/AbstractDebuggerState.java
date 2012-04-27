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
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Mitra 1
 */
public abstract class AbstractDebuggerState implements IDebuggerState {

	protected MitraDebugProxy debugger;

	protected IDebuggerState.StateID stateId;

	public AbstractDebuggerState(StateID stateId, MitraDebugProxy debugger) {
		if (debugger == null) {
			throw new NullPointerException("debugger must not be null");
		}
		if (stateId == null) {
			throw new NullPointerException("stateId must not be null");
		}

		this.stateId = stateId;
		this.debugger = debugger;
	}

	/**
	 * By default, the state does nothing on activate.
	 * 
	 * @see de.feu.mitra.debug.core.IDebuggerState#activate()
	 */
	@Override
	public void activate() {
	}

	/**
	 * By default, the state does nothing on deactivate.
	 * 
	 * @see de.feu.mitra.debug.core.IDebuggerState#deactivate()
	 */
	@Override
	public void deactivate() {
	}

	@Override
	public StateID getStateId() {
		return stateId;
	}

	/**
	 * @see de.jevopi.mitra2.debug.core.IDebuggerState#handleBlockEntered()
	 */
	@Override
	public void handleBlockEntered() {
	}

	/* *************************************************************************
	 * toString etc.
	 * **********************************************************************
	 */

	/**
	 * @see de.jevopi.mitra2.debug.core.IDebuggerState#handleBlockLeft()
	 */
	@Override
	public void handleBlockLeft() {
	}

	/**
	 * @see de.jevopi.mitra2.debug.core.IDebuggerState#handleBreakpoint()
	 */
	@Override
	public void handleBreakpoint() {
	}

	/**
	 * @see de.jevopi.mitra2.debug.core.IDebuggerState#handleEnterFunction()
	 */
	@Override
	public void handleEnterFunction() {
	}

	/**
	 * @see de.jevopi.mitra2.debug.core.IDebuggerState#handleExitFunction()
	 */
	@Override
	public void handleExitFunction() {
	}

	/**
	 * @see de.jevopi.mitra2.debug.core.IDebuggerState#handleExitStatement()
	 */
	@Override
	public void handleExitStatement() {
	}

	/**
	 * @see de.jevopi.mitra2.debug.core.IDebuggerState#handleResume()
	 */
	@Override
	public void handleResume() {
	}

	/**
	 * @see de.jevopi.mitra2.debug.core.IDebuggerState#handleStepInto()
	 */
	@Override
	public void handleStepInto() {
	}

	/**
	 * @see de.jevopi.mitra2.debug.core.IDebuggerState#handleStepOver()
	 */
	@Override
	public void handleStepOver() {
	}

	/**
	 * @see de.jevopi.mitra2.debug.core.IDebuggerState#handleStepReturn()
	 */
	@Override
	public void handleStepReturn() {
	}

	/**
	 * @see de.jevopi.mitra2.debug.core.IDebuggerState#handleSuspend(int)
	 */
	@Override
	public void handleSuspend(int i_detail) {
	}

	@Override
	public synchronized void handleTerminate() {
		debugger.setCurrentState(StateID.TERMINATED);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getStateId().toString();
	}

}
