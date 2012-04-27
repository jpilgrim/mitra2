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
 * TerminatedState
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Mitra 1
 */
public class TerminatedState extends AbstractDebuggerState {

	public TerminatedState(MitraDebugProxy debugger) {
		super(StateID.TERMINATED, debugger);
	}

	/**
	 * @see de.feu.mitra.debug.core.AbstractDebuggerState#activate()
	 */
	@Override
	public void activate() {
		if (debugger != null) {
			debugger.terminated();
		}
	}

}
