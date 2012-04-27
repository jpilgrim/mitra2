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
package de.jevopi.mitra2.engine.debug;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.jevopi.mitra2.engine.interpreter.StackFrame;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.mitra.RuleDeclaration;

/**
 * IDebugable There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 */
public interface IDebuggable extends Runnable {

	/* *************************************************************************
	 * Control the debugable
	 * **********************************************************************
	 */

	/**
	 * Enables or disables debugging.
	 * 
	 * @param bFlag
	 */
	void enableDebug(boolean bFlag);

	/**
	 * Resumes the debuggable if previously suspended.
	 */
	void resume();

	/**
	 * Suspends the debuggable (if running).
	 */
	void suspend();

	/**
	 * Returns true if debuggable is currently suspended.
	 * 
	 * @return
	 */
	boolean isSuspended();

	/**
	 * Returns true if debuggable is terminated. Note that the debuggable may
	 * not immediately terminate after {@link #terminate()} is called.
	 * 
	 * @return
	 */
	boolean isTerminated();

	/**
	 * Terminates the debuggable as soon as possible.
	 */
	void terminate();

	/* *************************************************************************
	 * Get internal information
	 * **********************************************************************
	 */
	RuleDeclaration getCalledRule();

	EObject getCurrentElement();

	List<StackFrame> getStackFrames();

	StackFrame getStackFrame(int id);

	MetamodelManager getMetamodelManager();

	/* *************************************************************************
	 * Listener stuff
	 * **********************************************************************
	 */
	public void addInterpreterListener(IDebugableListener listener);

	public void removeInterpreterListener(IDebugableListener listener);

}
