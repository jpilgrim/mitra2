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

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IThread;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Mitra 1
 */
public interface IDebuggerObserver {

	IThread[] getThreads() throws DebugException;

	void resumed(int detail);

	void suspended(IBreakpoint breakpoint);

	void suspended(int detail);

	void terminated();
}
