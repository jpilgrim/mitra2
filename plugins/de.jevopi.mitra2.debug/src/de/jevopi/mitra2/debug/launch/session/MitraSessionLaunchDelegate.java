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
package de.jevopi.mitra2.debug.launch.session;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.swt.widgets.Display;

import de.jevopi.mitra2.debug.MitraDebugPlugin;
import de.jevopi.mitra2.debug.core.MitraDebugProxy;
import de.jevopi.mitra2.debug.model.MitraDebugTarget;
import de.jevopi.mitra2.engine.debug.IDebuggable;
import de.jevopi.mitra2.exec.SessionExecutor;
import de.jevopi.mitra2.mitra.RuleDeclaration;

/**
 * LaunchDelegate There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @since Mitra 1
 */
public class MitraSessionLaunchDelegate extends LaunchConfigurationDelegate {
	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger
			.getLogger(MitraSessionLaunchDelegate.class.getName());

	private ILaunch launch;

	private void cleanup() {

		ILaunch[] allLaunches = DebugPlugin.getDefault().getLaunchManager()
				.getLaunches();
		if (allLaunches != null) {
			for (int i = 0; i < allLaunches.length; i++) {
				if (launch != allLaunches[i]) {
					DebugPlugin.getDefault().getLaunchManager()
							.removeLaunch(allLaunches[i]);
				}
			}
		}
	}

	/**
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration,
	 *      java.lang.String, org.eclipse.debug.core.ILaunch,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		this.launch = launch;
		cleanup();

		SessionExecutor executor = MitraSessionLaunchFactory.instance()
				.popExecutor(configuration);

		executor.prepareInterpreter();
		IDebuggable debugable = executor.getDebugable(); // debugable supports
		// listeners!

		if (debugable == null) {
			throw new CoreException(new Status(IStatus.ERROR,
					MitraDebugPlugin.PLUGIN_ID,
					"No debuggable interpreter prepared."));
		}

		RuleDeclaration decl = debugable.getCalledRule();

		if (decl == null) {
			throw new CoreException(new Status(IStatus.ERROR,
					MitraDebugPlugin.PLUGIN_ID, "No rule selected."));
		}
		IDebugTarget debugTarget = new MitraDebugTarget(launch,
				new MitraDebugProxy(debugable), decl.eResource().getURI()
						.toFileString());

		Display display = Display.getCurrent();
		if (display == null) { // start in normal thread
			if (log.isLoggable(Level.INFO)) {
				log.info("Start mitra interpreter via new thread");
			}

			Thread interpreterThread = new Thread(debugable);
			if (mode.equals(ILaunchManager.DEBUG_MODE)) {
				debugable.enableDebug(true);
				interpreterThread.setName("MitraInterpreter");
				interpreterThread.start();
				launch.addDebugTarget(debugTarget);
			} else {
				interpreterThread.start();
			}
		} else { // start via display
			if (log.isLoggable(Level.INFO)) {
				log.info("Start mitra interpreter via display.asyncExec");
			}

			if (mode.equals(ILaunchManager.DEBUG_MODE)) {
				debugable.enableDebug(true);
				display.asyncExec(debugable);
				launch.addDebugTarget(debugTarget);
			} else {
				display.asyncExec(debugable);
			}
		}

	}

	/**
	 * @see org.eclipse.debug.core.model.LaunchConfigurationDelegate#saveBeforeLaunch(org.eclipse.debug.core.ILaunchConfiguration,
	 *      java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected boolean saveBeforeLaunch(ILaunchConfiguration i_configuration,
			String i_mode, IProgressMonitor i_monitor) throws CoreException {
		i_monitor.beginTask("", 1); //$NON-NLS-1$
		try {
			return true;
		} finally {
			i_monitor.done();
		}
	}

}
