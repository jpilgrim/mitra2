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

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.jevopi.mitra2.engine.interpreter.ExecutionContext;
import de.jevopi.mitra2.engine.interpreter.Interpreter;
import de.jevopi.mitra2.engine.interpreter.SessionContext;
import de.jevopi.mitra2.engine.interpreter.TerminateException;
import de.jevopi.mitra2.mitra.RuleDeclaration;

/**
 * DebugableInterpreter There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @version $Revision: 962 $
 * @since Mar 31, 2009
 */
public class DebugableInterpreter extends Interpreter implements IDebuggable {
	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger
		.getLogger(DebugableInterpreter.class.getName());

	private Vector<IDebugableListener> debugableListener;

	private boolean toBeTerminated;

	private boolean debugEnabled;

	private boolean isSuspended;

	private boolean isTerminated;

	/**
	 * @param i_sessionContext
	 * @param i_executionContext
	 */
	public DebugableInterpreter(SessionContext i_sessionContext,
			ExecutionContext i_executionContext) {
		super(i_sessionContext, i_executionContext);
		debugableListener = new Vector<IDebugableListener>();
		toBeTerminated = false;
		isTerminated = false;
		isSuspended = false;
		debugEnabled = false;
	}

	/**
	 * {@inheritDoc} The debugable interpreter is started via the Eclipse launch
	 * API. The interpreter thread is created and started via <code>
	 * de.feu.mitra.launch.LaunchDelegate.launch(ILaunchConfiguration, String,
	 * ILaunch, IProgressMonitor)#launch(ILaunchConfiguration , String , ILaunch
	 * , IProgressMonitor )</code>
	 * 
	 * @see de.jevopi.mitra2.engine.execution.feu.mitra.engine.execution.Interpreter#run()
	 */
	@Override
	public void run() {
		try {
			doRunInterpreter();
		} finally {
			doFireTerminationEvent();
		}
	}

	protected void doRunInterpreter() {
		if (log.isLoggable(Level.INFO)) {
			log.info("Interpreter started, active"); //$NON-NLS-1$
		}

		try {
			super.run();
		} finally {
			toBeTerminated = true;
			isTerminated = true;
		}

		if (log.isLoggable(Level.INFO)) {
			log.info("Interpreter terminated, inactive"); //$NON-NLS-1$
		}
	}

	protected void doFireTerminationEvent() {
		terminated();
		fireEvent(DebugEventType.terminated);
	}

	/**
	 * 
	 */
	@Override
	protected synchronized void waitForNextStep() {
		if (debugEnabled) {
			try {
				confirm(DebugEventType.statement_finished);

				//				if (log.isLoggable(Level.INFO)) {
				//					log.info("Waiting to resume"); //$NON-NLS-1$
				//				}

				wait();

				//				if (log.isLoggable(Level.INFO)) {
				//					log.info("OK, resume"); //$NON-NLS-1$
				//				}

			} catch (InterruptedException e) {
				if (log.isLoggable(Level.INFO)) {
					log.info("Uups, interupted while waiting to result"); //$NON-NLS-1$
				}

				throw new RuntimeException(e.getMessage());
			}
		}
	}

	/**
	 * Notifies listeners about the event. If the interpreter was terminated,
	 * the termination event is sent instead and an {@link TerminateException}
	 * is thrown to stop current flow.
	 * 
	 * @param event
	 */
	@Override
	protected void confirm(DebugEventType event) {
		if (debugEnabled) {
			if (toBeTerminated) {
				fireEvent(DebugEventType.terminated);
				throw new TerminateException();
			} else {
				fireEvent(event);
			}
		}
	}

	@Override
	public boolean isTerminated() {
		return toBeTerminated || isTerminated;
	}

	public void terminated() {
		for (int i = 0; i < debugableListener.size(); i++) {
			IDebugableListener listener = debugableListener.get(i);
			try {
				listener.terminated();
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
		isTerminated = true;
	}

	@Override
	public synchronized void terminate() {
		toBeTerminated = true;
		resume();
	}

	public synchronized void setDebugMode(boolean debugEnabled) {
		this.debugEnabled = debugEnabled;
	}

	@Override
	public synchronized void resume() {
		// this.isSuspended = false;
		notifyAll();
	}

	@Override
	public synchronized void suspend() {
		isSuspended = true;
	}

	@Override
	public synchronized boolean isSuspended() {
		return isSuspended;
	}

	public synchronized void suspended() {
		for (int i = 0; i < debugableListener.size(); i++) {
			IDebugableListener listener = debugableListener.get(i);
			listener.suspended();
		}
	}

	/**
	 * @see de.feu.mitra.engine.debugapi.IDebuggable#addInterpreterListener(de.feu.mitra.engine.debugapi.IDebugableListener)
	 */
	@Override
	public void addInterpreterListener(IDebugableListener listener) {
		if (!debugableListener.contains(listener)) {
			debugableListener.add(listener);
		}
	}

	/**
	 * @see de.feu.mitra.engine.debugapi.IDebuggable#removeInterpreterListener(de.feu.mitra.engine.debugapi.IDebugableListener)
	 */
	@Override
	public void removeInterpreterListener(IDebugableListener listener) {
		debugableListener.remove(listener);
	}

	public synchronized void fireEvent(DebugEventType eventType) {
		for (IDebugableListener listener : debugableListener) {
			try {
			listener.processDebugableEvent(eventType);
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}

	}

	/**
	 * @see de.feu.mitra.engine.debugapi.IDebuggable#enableDebug(boolean)
	 */
	@Override
	public synchronized void enableDebug(boolean bEnable) {
		debugEnabled = bEnable;

	}

	/**
	 * @return
	 */
	public boolean isActive() {
		// TODO implement method DebugableInterpreter.isActive
		return false;
	}

	/**
	 * @see de.jevopi.mitra2.engine.debug.IDebuggable#getCalledRule()
	 */
	@Override
	public RuleDeclaration getCalledRule() {
		return executionContext.getInvokedRule();
	}

	/**
	 * @return
	 */
	public ExecutionContext getExecutionContext() {
		return executionContext;
	}

}
