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
 * StepIntoState
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Mitra 1
 */
public class StepIntoState extends AbstractDebuggerState {

	public StepIntoState(MitraDebugProxy debugger) {
		super(StateID.STEPINTO, debugger);
	}

	@Override
	public void activate() {
		debugger.resumeInterpreter();
	}

	@Override
	public synchronized void handleExitStatement() {
		debugger.setCurrentState(StateID.SUSPENDED);
		debugger.suspended(DebugEvent.STEP_END);
	}

	@Override
	public synchronized void handleSuspend(int detail) {
		debugger.setCurrentState(StateID.SUSPENDED);
	}

}
