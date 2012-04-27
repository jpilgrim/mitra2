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
 * SuspendedState
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Mitra 1
 */
public class SuspendedState extends AbstractDebuggerState {

	public SuspendedState(MitraDebugProxy debugger) {
		super(StateID.SUSPENDED, debugger);
	}

	@Override
	public synchronized void handleResume() {
		debugger.setCurrentState(StateID.RESUMED);
	}

	@Override
	public synchronized void handleStepInto() {
		debugger.setCurrentState(StateID.STEPINTO);
	}

	@Override
	public synchronized void handleStepOver() {
		debugger.setCurrentState(StateID.STEPOVER);
	}

	@Override
	public synchronized void handleStepReturn() {
		debugger.setCurrentState(StateID.STEPRETURN);
	}

}
