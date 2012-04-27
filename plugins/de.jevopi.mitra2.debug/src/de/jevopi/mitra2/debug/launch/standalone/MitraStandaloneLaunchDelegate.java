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
package de.jevopi.mitra2.debug.launch.standalone;

import java.io.IOException;
import java.io.PrintStream;
import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import de.jevopi.mitra2.debug.MitraDebugPlugin;
import de.jevopi.mitra2.debug.core.MitraDebugProxy;
import de.jevopi.mitra2.debug.launch.MitraLaunchConfigurationAdapter;
import de.jevopi.mitra2.debug.model.MitraDebugTarget;
import de.jevopi.mitra2.engine.debug.DebugEventType;
import de.jevopi.mitra2.engine.debug.IDebugableListener;
import de.jevopi.mitra2.engine.debug.IDebuggable;
import de.jevopi.mitra2.exec.StandaloneExecutor;
import de.jevopi.mitra2.mitra.Module;
import de.jevopi.mitra2.mitra.RuleDeclaration;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Jan 31, 2012
 */
public class MitraStandaloneLaunchDelegate extends LaunchConfigurationDelegate {

	public final static String INPUT_MODEL_ = "INPUT_MODEL_";

	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger
		.getLogger(MitraStandaloneLaunchDelegate.class.getName());

	private ILaunch launch;

	private MessageConsole console = null;

	private void cleanup() {

		ILaunch[] allLaunches =
			DebugPlugin.getDefault().getLaunchManager().getLaunches();
		if (allLaunches != null) {
			for (int i = 0; i < allLaunches.length; i++) {
				if (launch != allLaunches[i]) {
					DebugPlugin.getDefault().getLaunchManager()
						.removeLaunch(allLaunches[i]);
				}
			}
		}
	}

	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		try {
			this.launch = launch;
			cleanup();

			final MitraLaunchConfigurationAdapter configAdapter =
				new MitraLaunchConfigurationAdapter(configuration);

			String consoleName =
				"Mitra Interpreter [" + configAdapter.getName() + "] " + mode;
			console = findConsole(consoleName);
			console.activate();
			initConsoleStream();

			clearConsole();

			final StandaloneExecutor executor =
				MitraStandaloneLaunchFactory.createExecutor(configAdapter);
			executor.getProjectContext().setMessageAcceptor(
					new ConsoleMessageAcceptor(console));

			console.addPatternMatchListener(new MitraConsoleTracker(executor
				.getProjectContext()));

			executor.getProjectContext().out =
				new PrintStream(createMessageStream(SWT.COLOR_BLACK));

			PrintStream err =
				new PrintStream(createMessageStream(SWT.COLOR_RED));
			executor.getProjectContext().err = err;

			executor.getProjectContext().log =
				new PrintStream(createMessageStream(SWT.COLOR_BLUE));

			try {
				executor.prepareInterpreter();
			} catch (Exception ex) {
				throw new CoreException(
					new Status(
						IStatus.ERROR,
						MitraDebugPlugin.PLUGIN_ID,
						"Error preparing Mitra interpreter: " + ex.getMessage(),
						ex));
			}

			executor.getDebugable().addInterpreterListener(
					new IDebugableListener() {

						@Override
						public void terminated() {

							out("Mitra interpreter terminated.");
							try {
								for (String fileName : configAdapter
									.getOutputModelFilenames().values()) {
									URI uri = URI.createFileURI(fileName);
									refreshPath(uri);

								}
								for (String fileName : configAdapter
									.getInputModelFilenames().values()) {
									URI uri = URI.createFileURI(fileName);
									refreshPath(uri);

								}
								if (configAdapter.isSaveTraces()) {
									URI uri =
										URI.createFileURI(configAdapter
											.getTraceModelFilename());
									refreshPath(uri);
								}
							} catch (CoreException ex) {
								out("Error refreshing project path: " + ex);
							}

						}

						@Override
						public void processDebugableEvent(
								DebugEventType eventType) {
							// not interested in
						}

						@Override
						public void suspended() {
							// not interested in
						}

					});

			ResourceSet rs = executor.getProjectContext().getResourceSet();
			int errorCount = 0;
			int warningCount = 0;
			int moduleCount = 0;
			// iterate over copy, as new resources may be 
			// added while resolving proxies
			List<Resource> resources =
				new ArrayList<Resource>(rs.getResources());
			for (Resource resource : resources) {
				errorCount += resource.getErrors().size();
				warningCount += resource.getWarnings().size();

				if (resource.getContents().size() > 0) {
					for (EObject model : resource.getContents()) {

						if (model instanceof Module) {
							moduleCount++;
						}
						Diagnostic diagnostic =
							Diagnostician.INSTANCE.validate(model);
						for (Diagnostic child : diagnostic.getChildren()) {
							switch (child.getSeverity()) {
							case Diagnostic.ERROR:
								if (!(model instanceof Module)) {
									err.println(model.eResource().getURI()
										+ ": " + child.getMessage());
								}
								errorCount++;
								break;
							case Diagnostic.WARNING:
								warningCount++;
							}
						}

					}
				}

			}

			MessageFormat form = new MessageFormat("Loaded {0}{1}, {2}.");
			double[] limits = {
				0, 1, 2
			};
			String[] moduleparts = {
				"no module", "1 module", "{0,number} modules"
			};
			ChoiceFormat moduleform = new ChoiceFormat(limits, moduleparts);
			form.setFormatByArgumentIndex(0, moduleform);
			String[] errorparts = {
				" successfully: 0 errors", ": 1 error", ": {1,number} errors"
			};
			ChoiceFormat errorform = new ChoiceFormat(limits, errorparts);
			form.setFormatByArgumentIndex(1, errorform);
			String[] warningparts = {
				"0 warnings", "1 warning", "{2,number} warnings"
			};
			ChoiceFormat warningform = new ChoiceFormat(limits, warningparts);
			form.setFormatByArgumentIndex(2, warningform);

			String msg = form.format(new Object[] {
				moduleCount, errorCount, warningCount
			});
			if (errorCount > 0) {
				msg += " Cannot start Mitra intpreter.";
			}
			out(msg);
			if (errorCount > 0 || moduleCount == 0) {
				throw new CoreException(new Status(IStatus.ERROR,
					MitraDebugPlugin.PLUGIN_ID, msg));
			}

			IDebuggable debugable = executor.getDebugable(); // debugable
																// supports
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
			IDebugTarget debugTarget =
				new MitraDebugTarget(launch, new MitraDebugProxy(debugable),
					decl.eResource().getURI().toFileString());

			Display display = Display.getCurrent();
			if (display == null) { // start in normal thread
				if (log.isLoggable(Level.INFO)) {
					log.info("Start mitra interpreter via new thread");
				}
				out("Start Mitra interpreter on new thread");

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
				out("Start Mitra interpreter on display thread");

				if (mode.equals(ILaunchManager.DEBUG_MODE)) {
					debugable.enableDebug(true);
					display.asyncExec(debugable);
					// interpreterThread.setName("MitraInterpreter");
					// interpreterThread.start();
					launch.addDebugTarget(debugTarget);
				} else {
					display.asyncExec(debugable);
				}
			}
			out("Interpreter running...");
		} finally {
			console = null;
		}
	}

	/**
	 * @param uri
	 * @return
	 */
	protected void refreshPath(URI uri) {
		try {
			if (uri.isFile()) {
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				IPath path = Path.fromOSString(uri.toFileString());
				IFile file = workspace.getRoot().getFileForLocation(path);
				file.refreshLocal(IResource.DEPTH_INFINITE,
						new NullProgressMonitor());
			}
		} catch (Exception ex) {
			out("Error refreshing project path " + uri + ": " + ex);
		}
	}

	private void clearConsole() {
		console.clearConsole();
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

	private MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++)
			if (name.equals(existing[i].getName()))
				return (MessageConsole) existing[i];
		// no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(name, null);

		conMan.addConsoles(new IConsole[] {
			myConsole
		});
		return myConsole;
	}

	MessageConsoleStream out = null;

	private void initConsoleStream() {
		if (out == null) {
			out = createMessageStream(SWT.COLOR_GRAY);
		}
	}

	MessageConsoleStream createMessageStream(final int color) {
		final MessageConsoleStream stream = console.newMessageStream();
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				stream.setColor(PlatformUI.getWorkbench().getDisplay()
					.getSystemColor(color));
			}
		});
		return stream;
	}

	private void out(String msg) {

		out.println(msg);
		try {
			out.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
