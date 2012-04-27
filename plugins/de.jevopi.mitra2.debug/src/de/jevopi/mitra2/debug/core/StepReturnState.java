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

import org.eclipse.debug.core.DebugEvent;

/**
 * StepReturnState
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Mitra 1
 */
public class StepReturnState extends AbstractDebuggerState {

	private int numberOfFunctionsToExecute;

	public StepReturnState(MitraDebugProxy debugger) {
		super(StateID.STEPRETURN, debugger);
	}

	/**
	 * @see de.feu.mitra.debug.core.AbstractDebuggerState#activate()
	 */
	@Override
	public void activate() {
		numberOfFunctionsToExecute = 0;
		debugger.resumeInterpreter();
	}

	@Override
	public synchronized void handleEnterFunction() {
		numberOfFunctionsToExecute++;
	}

	@Override
	public synchronized void handleExitFunction() {
		if (numberOfFunctionsToExecute == 0) {
			debugger.setCurrentState(StateID.SUSPENDED);

			debugger.suspended(DebugEvent.STEP_END);
		} else {
			numberOfFunctionsToExecute--;
		}
	}

	@Override
	public synchronized void handleExitStatement() {
		debugger.resumeInterpreter();
	}

}
