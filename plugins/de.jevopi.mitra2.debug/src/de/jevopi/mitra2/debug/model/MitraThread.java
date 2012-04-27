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
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;

/**
 * MitraThread
 * 
 * @author Jens von Pilgrim
 * @since Mitra 1
 */
public class MitraThread extends MitraDebugElement implements IThread {

	private IBreakpoint[] breakpoints;

	private boolean isSuspended = false;

	public MitraThread(MitraDebugTarget target) {
		super(target);
	}

	@Override
	public boolean canResume() {
		return isSuspended();
	}

	@Override
	public boolean canStepInto() {
		return isSuspended();
	}

	@Override
	public boolean canStepOver() {
		return isSuspended();
	}

	@Override
	public boolean canStepReturn() {
		return isSuspended();
	}

	@Override
	public boolean canSuspend() {
		return !isSuspended();
	}

	@Override
	public boolean canTerminate() {
		return !isTerminated();
	}

	@Override
	public IBreakpoint[] getBreakpoints() {
		if (breakpoints == null) {
			return new IBreakpoint[0];
		}
		return breakpoints;
	}

	@Override
	public String getName() throws DebugException {
		return "Single Thread";
	}

	@Override
	public int getPriority() throws DebugException {
		return 0;
	}

	@Override
	public IStackFrame[] getStackFrames() throws DebugException {
		if (isSuspended()) {
			return ((MitraDebugTarget) getDebugTarget()).getStackFrames();
		} else {
			return new IStackFrame[0];
		}
	}

	@Override
	public IStackFrame getTopStackFrame() throws DebugException {
		IStackFrame[] frames = getStackFrames();
		if (frames.length > 0) {
			return frames[0];
		}
		return null;
	}

	@Override
	public boolean hasStackFrames() throws DebugException {
		return isSuspended();
	}

	@Override
	public boolean isStepping() {
		boolean isStepping = false;
		IDebugTarget target = getDebugTarget();
		if (target instanceof MitraDebugTarget) {
			MitraDebugTarget mitraTarget = (MitraDebugTarget) target;
			isStepping = mitraTarget.isStepping();
		}

		return isStepping;
	}

	@Override
	public boolean isSuspended() {
		isSuspended = getDebugTarget().isSuspended();
		return isSuspended;
	}

	@Override
	public boolean isTerminated() {
		return getDebugTarget().isTerminated();
	}

	@Override
	public void resume() throws DebugException {
		getDebugTarget().resume();
	}

	protected void setBreakpoints(IBreakpoint[] breakpoints) {
		this.breakpoints = breakpoints;
	}

	@Override
	public void stepInto() throws DebugException {
		((MitraDebugTarget) getDebugTarget()).stepInto();
	}

	@Override
	public void stepOver() throws DebugException {
		((MitraDebugTarget) getDebugTarget()).stepOver();

	}

	@Override
	public void stepReturn() throws DebugException {
		((MitraDebugTarget) getDebugTarget()).stepReturn();
	}

	@Override
	public void suspend() throws DebugException {
		getDebugTarget().suspend();
	}

	@Override
	public void terminate() throws DebugException {
		getDebugTarget().terminate();
	}

}
