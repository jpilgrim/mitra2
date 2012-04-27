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

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

import de.jevopi.mitra2.debug.core.IDebugProxy;
import de.jevopi.mitra2.debug.core.IDebuggerObserver;
import de.jevopi.mitra2.metamodel.MetamodelManager;

public class MitraDebugTarget extends MitraDebugElement implements
		IDebugTarget, IDebuggerObserver {

	private IDebugProxy debugger;

	private ILaunch launch;

	// threads
	private MitraThread mitraThread;

	// program name
	private String name;

	private IThread[] threads;

	public MitraDebugTarget(ILaunch launch, IDebugProxy debugger,
			String programName) throws CoreException {
		super(null);
		name = programName;
		this.launch = launch;
		this.debugger = debugger;
		this.debugger.setDebugTarget(this);
		mitraDebugTarget = this;
		mitraThread = new MitraThread(this);
		threads = new IThread[] { mitraThread };
		DebugPlugin.getDefault().getBreakpointManager()
				.addBreakpointListener(this);
		started();
	}

	/** 
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointAdded(org.eclipse.debug.core.model.IBreakpoint)
	 */
	@Override
	public void breakpointAdded(IBreakpoint breakpoint) {
		if (supportsBreakpoint(breakpoint)) {
			debugger.addBreakpoint(breakpoint);
		}

	}

	/** 
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointChanged(org.eclipse.debug.core.model.IBreakpoint, org.eclipse.core.resources.IMarkerDelta)
	 */
	@Override
	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
		if (supportsBreakpoint(breakpoint)) {
			try {
				if (breakpoint.isEnabled()) {
					breakpointAdded(breakpoint);
				} else {
					breakpointRemoved(breakpoint, null);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	/** 
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointRemoved(org.eclipse.debug.core.model.IBreakpoint, org.eclipse.core.resources.IMarkerDelta)
	 */
	@Override
	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
		if (supportsBreakpoint(breakpoint)) {
			debugger.removeBreakpoint(breakpoint);
		}
	}

	/** 
	 * @see org.eclipse.debug.core.model.IDisconnect#canDisconnect()
	 */
	@Override
	public boolean canDisconnect() {
		return false;
	}

	/**
	 * @see org.eclipse.debug.core.model.ISuspendResume
	 */
	@Override
	public boolean canResume() {
		return !isTerminated() && isSuspended();
	}

	/**
	 * @see org.eclipse.debug.core.model.ISuspendResume
	 */
	@Override
	public boolean canSuspend() {
		return !isTerminated() && !isSuspended();
	}

	/**
	 * @see org.eclipse.debug.core.model.ITerminate
	 */
	@Override
	public boolean canTerminate() {
		return false;
	}

	/** 
	 * @see org.eclipse.debug.core.model.IDisconnect#disconnect()
	 */
	@Override
	public void disconnect() throws DebugException {
	}

	/**
	 * @see de.feu.mitra.debug.modelMitraDebugElement
	 */
	@Override
	public IDebugTarget getDebugTarget() {
		return this;
	}

	/**
	 * @see de.feu.mitra.debug.modelMitraDebugElement
	 */
	@Override
	public ILaunch getLaunch() {
		return launch;
	}

	/** 
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#getMemoryBlock(long, long)
	 */
	@Override
	public IMemoryBlock getMemoryBlock(long startAddress, long length)
			throws DebugException {
		return null;
	}

	/**
	 * Returns the metamodel manager, used to retrieve features of a variable.
	 * 
	 * @return
	 */
	public MetamodelManager getMetamodelManager() {
		return debugger.getDebuggable().getMetamodelManager();
	}

	/**
	 * @see org.eclipse.debug.core.model.IDebugTarget
	 */
	@Override
	public String getName() throws DebugException {
		if (name == null) {
			name = "Unknown Mitra Programm";

		}
		return name;
	}

	/**
	 * @see org.eclipse.debug.core.model.IDebugTarget
	 */
	@Override
	public IProcess getProcess() {
		return null;
	}

	protected IStackFrame[] getStackFrames() throws DebugException {
		IStackFrame[] stackFrames = debugger.getStackFrames();
		for (int i = 0; i < stackFrames.length; i++) {
			MitraStackFrame stackFrame = (MitraStackFrame) stackFrames[i];
			stackFrame.setThread(mitraThread);
		}
		return stackFrames;
	}

	/**
	 * @see org.eclipse.debug.core.model.IDebugTarget
	 */
	@Override
	public IThread[] getThreads() throws DebugException {
		return threads;
	}

	public IVariable[] getVariables(IStackFrame stackFrame) {
		if (stackFrame instanceof MitraStackFrame) {
			MitraStackFrame mitraStackFrame = (MitraStackFrame) stackFrame;
			IVariable[] stackVisibleVariables = debugger
					.getlocalVariables(mitraStackFrame);
			return stackVisibleVariables;
		}
		return null;
	}

	protected IValue getVariableValue(MitraVariable variable)
			throws DebugException {

		IValue value = variable.getValue();
		return value;
	}

	/**
	 * @see org.eclipse.debug.core.model.IDebugTarget
	 */
	@Override
	public boolean hasThreads() throws DebugException {
		return true;
	}

	private void installDeferredBreakpoints() {
		IBreakpoint[] breakpoints = DebugPlugin.getDefault()
				.getBreakpointManager().getBreakpoints(getModelIdentifier());
		debugger.addBreakpoints(breakpoints);

	}

	/** 
	 * @see org.eclipse.debug.core.model.IDisconnect#isDisconnected()
	 */
	@Override
	public boolean isDisconnected() {
		return false;
	}

	public boolean isStepping() {
		boolean isStepping = debugger.isStepping();
		return isStepping;
	}

	/**
	 * @see org.eclipse.debug.core.model.ISuspendResume
	 */
	@Override
	public boolean isSuspended() {
		return debugger.isSuspended();
	}

	/**
	 * @see org.eclipse.debug.core.model.ITerminate
	 */
	@Override
	public boolean isTerminated() {
		return debugger.isTerminated();
	}

	/**
	 * @see org.eclipse.debug.core.model.ISuspendResume
	 */
	@Override
	public void resume() throws DebugException {
		debugger.resume();
	}

	/** 
	 * @see de.jevopi.mitra2.debug.core.IDebuggerObserver#resumed(int)
	 */
	@Override
	public void resumed(int detail) {
		mitraThread.fireResumeEvent(detail);
	}

	private void started() {
		fireCreationEvent();
		installDeferredBreakpoints();
		try {
			resume();
		} catch (DebugException e) {
		}
	}

	public void stepInto() throws DebugException {
		debugger.stepInto();
	}

	public void stepOver() throws DebugException {
		debugger.stepOver();
	}

	public void stepReturn() {
		debugger.stepReturn();

	}

	/**
	 * @see org.eclipse.debug.core.model.IDebugTarget
	 */
	@Override
	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		if (breakpoint instanceof MitraLineBreakpoint) {
			return true;
		}
		return false;
	}

	/** 
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#supportsStorageRetrieval()
	 */
	@Override
	public boolean supportsStorageRetrieval() {
		return false;
	}

	/**
	 * @see org.eclipse.debug.core.model.ISuspendResume
	 */
	@Override
	public void suspend() throws DebugException {
		debugger.suspend();
	}

	/** 
	 * @see de.jevopi.mitra2.debug.core.IDebuggerObserver#suspended(org.eclipse.debug.core.model.IBreakpoint)
	 */
	@Override
	public void suspended(IBreakpoint breakpoint) {
		mitraThread.setBreakpoints(new IBreakpoint[] { breakpoint });
		mitraThread.fireSuspendEvent(DebugEvent.BREAKPOINT);
	}

	/** 
	 * @see de.jevopi.mitra2.debug.core.IDebuggerObserver#suspended(int)
	 */
	@Override
	public void suspended(int detail) {
		mitraThread.fireSuspendEvent(detail);
	}

	/**
	 * @see org.eclipse.debug.core.model.ITerminate
	 */
	@Override
	public void terminate() throws DebugException {
		debugger.terminate();
		terminated();

	}

	/** 
	 * @see de.jevopi.mitra2.debug.core.IDebuggerObserver#terminated()
	 */
	@Override
	public void terminated() {
		try {
			launch.terminate();
			DebugPlugin.getDefault().getBreakpointManager()
					.removeBreakpointListener(this);
			fireTerminateEvent();
		} catch (DebugException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
