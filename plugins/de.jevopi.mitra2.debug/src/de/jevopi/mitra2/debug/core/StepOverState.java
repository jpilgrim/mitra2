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

import java.util.logging.Logger;

import org.eclipse.debug.core.DebugEvent;

/**
 * StepOverState There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @since Mitra 1
 */
public class StepOverState extends AbstractDebuggerState {
	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(StepOverState.class
			.getName());

	public StepOverState(MitraDebugProxy debugger) {
		super(StateID.STEPOVER, debugger);
	}

	/**
	 * @see de.feu.mitra.debug.core.AbstractDebuggerState#activate()
	 */
	@Override
	public void activate() {
		debugger.resumeInterpreter();
	}

	@Override
	public synchronized void handleEnterFunction() {
		debugger.setCurrentState(StateID.STEPOVER_FUNCTION);
	}

	@Override
	public synchronized void handleExitStatement() {
		debugger.setCurrentState(StateID.SUSPENDED);
		debugger.suspended(DebugEvent.STEP_END);
	}

}
