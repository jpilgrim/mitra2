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
package de.jevopi.mitra2.debug.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;

/**
 * MitraStackFrame There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 */
public class MitraStackFrame extends MitraDebugElement implements IStackFrame {

	private String functionName;

	private int lineNumber;

	private IVariable[] localVariables;

	private IThread singleThread;

	private String sourceFile;

	private int stackFrameId;

	public MitraStackFrame(IThread thread, String name, String sourceFile,
			int id) {
		super((MitraDebugTarget) thread.getDebugTarget());
		stackFrameId = id;
		singleThread = thread;
		functionName = name;
		this.sourceFile = sourceFile;

	}

	public MitraStackFrame(IThread thread, String name, String sourceFile,
			int id, int lineNumber) {
		this(thread, name, sourceFile, id);
		this.lineNumber = lineNumber;
	}

	/** 
	 * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
	 */
	@Override
	public boolean canResume() {
		return getThread().canResume();
	}

	/** 
	 * @see org.eclipse.debug.core.model.IStep#canStepInto()
	 */
	@Override
	public boolean canStepInto() {
		return getThread().canStepInto();
	}

	/** 
	 * @see org.eclipse.debug.core.model.IStep#canStepOver()
	 */
	@Override
	public boolean canStepOver() {
		return getThread().canStepOver();
	}

	/** 
	 * @see org.eclipse.debug.core.model.IStep#canStepReturn()
	 */
	@Override
	public boolean canStepReturn() {
		return getThread().canStepReturn();
	}

	/** 
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	@Override
	public boolean canSuspend() {
		return getThread().canSuspend();
	}

	/** 
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	@Override
	public boolean canTerminate() {
		return getThread().canTerminate();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MitraStackFrame) {
			MitraStackFrame stackFrame = (MitraStackFrame) obj;
			try {
				return getSourceName().equals(stackFrame.getSourceName())
						&& stackFrame.getLineNumber() == getLineNumber()
						&& stackFrame.stackFrameId == stackFrameId;
			} catch (DebugException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getSourceName().hashCode() + stackFrameId;
	}

	/** 
	 * @see org.eclipse.debug.core.model.IStackFrame#getCharEnd()
	 */
	@Override
	public int getCharEnd() throws DebugException {
		return -1;
	}

	/** 
	 * @see org.eclipse.debug.core.model.IStackFrame#getCharStart()
	 */
	@Override
	public int getCharStart() throws DebugException {
		return -1;
	}

	public int getIdentifier() {
		return stackFrameId;
	}

	/**
	 * @see org.eclipse.debug.core.model.IStackFrame#getLineNumber()
	 */
	@Override
	public int getLineNumber() throws DebugException {

		return lineNumber;
	}

	/** 
	 * @see org.eclipse.debug.core.model.IStackFrame#getName()
	 */
	@Override
	public String getName() throws DebugException {
		return functionName;
	}

	/** 
	 * @see org.eclipse.debug.core.model.IStackFrame#getRegisterGroups()
	 */
	@Override
	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		return null;
	}

	public String getSourceName() {
		return (sourceFile == null) ? "" : sourceFile;
	}

	/** 
	 * @see org.eclipse.debug.core.model.IStackFrame#getThread()
	 */
	@Override
	public IThread getThread() {
		return singleThread;
	}

	/** 
	 * @see org.eclipse.debug.core.model.IStackFrame#getVariables()
	 */
	@Override
	public synchronized IVariable[] getVariables() throws DebugException {
		IVariable[] vars = ((MitraDebugTarget) singleThread.getDebugTarget())
				.getVariables(this);
		return vars;
	}

	

	/** 
	 * @see org.eclipse.debug.core.model.IStackFrame#hasRegisterGroups()
	 */
	@Override
	public boolean hasRegisterGroups() throws DebugException {
		return false;
	}

	/** 
	 * @see org.eclipse.debug.core.model.IStackFrame#hasVariables()
	 */
	@Override
	public synchronized boolean hasVariables() throws DebugException {
		if (localVariables == null) {
			return false;
		}
		return localVariables.length > 0;
	}

	/** 
	 * @see org.eclipse.debug.core.model.IStep#isStepping()
	 */
	@Override
	public boolean isStepping() {
		return getThread().isStepping();
	}

	/** 
	 * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
	 */
	@Override
	public boolean isSuspended() {
		return getThread().isSuspended();
	}

	/** 
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	@Override
	public boolean isTerminated() {
		return getThread().isTerminated();
	}

	/** 
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	@Override
	public void resume() throws DebugException {
		getThread().resume();
	}

	public void setThread(IThread thread) {
		singleThread = thread;
	}

	/** 
	 * @see org.eclipse.debug.core.model.IStep#stepInto()
	 */
	@Override
	public void stepInto() throws DebugException {
		getThread().stepInto();
	}

	/** 
	 * @see org.eclipse.debug.core.model.IStep#stepOver()
	 */
	@Override
	public void stepOver() throws DebugException {
		getThread().stepOver();
	}

	/** 
	 * @see org.eclipse.debug.core.model.IStep#stepReturn()
	 */
	@Override
	public void stepReturn() throws DebugException {
		getThread().stepReturn();
	}

	/** 
	 * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
	 */
	@Override
	public void suspend() throws DebugException {
		getThread().suspend();
	}

	/** 
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	@Override
	public void terminate() throws DebugException {
		getThread().terminate();
	}
}
