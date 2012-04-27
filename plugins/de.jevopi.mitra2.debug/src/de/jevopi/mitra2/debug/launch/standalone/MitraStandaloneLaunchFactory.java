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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.jevopi.mitra2.debug.MitraDebugPlugin;
import de.jevopi.mitra2.debug.launch.MitraLaunchConfigurationAdapter;
import de.jevopi.mitra2.exec.MitraConfig;
import de.jevopi.mitra2.exec.StandaloneExecutor;

/**
 * Factory for creating launch configurations to start Mitra standalone. Further
 * information about launching applications using Eclipse's launch framework can
 * be found in [Szurszewski03a].
 * <dl class="bib">
 * <dt><a name="Szurszewski03a">[Szurszewski03a]</a></dt>
 * <dd>Joe Szurszewski: We Have Lift-off: The Launching Framework in Eclipse.
 * Eclipse Corner Article, January, 2003, URL: <a
 * href="http://www.eclipse.org/articles/Article-Launch-Framework/launch.html"
 * >http://www.eclipse.org/articles/Article-Launch-Framework/launch.html</a></dd>
 * </dl>
 * </dl>
 * 
 * @author Jens von Pilgrim
 * @since Jan 2012
 */
public class MitraStandaloneLaunchFactory {

	/**
	 * 
	 */
	public static final String LAUNCH_CONFIG_TYPE =
		"de.jevopi.mitra2.debug.launch.standalone.MitraStandaloneLaunch";

	public static StandaloneExecutor createExecutor(
			MitraLaunchConfigurationAdapter configuration) throws CoreException {

		String modulePath = configuration.getModulePath();
		String fqnRule = configuration.getRuleName();

		Map<String, String> inputModelFilenames =
			configuration.getInputModelFilenames();
		Map<String, String> outputModelFilenames =
			configuration.getOutputModelFilenames();

		Map<String, Object> arguments = new HashMap<String, Object>();
		try {
			for (Map.Entry<String, String> entry: inputModelFilenames.entrySet()) {
				arguments.put(entry.getKey(), loadModel(entry.getValue()));
			}
		} catch (IOException ex) {
			throw new CoreException(new Status(IStatus.ERROR,
				MitraDebugPlugin.PLUGIN_ID, "Error loading inputmodels", ex));
		}

		MitraConfig mitraConfiguration = new MitraConfig();
		mitraConfiguration.metamodelPaths.add(modulePath);
		mitraConfiguration.modulePaths.add(modulePath);
		mitraConfiguration.traceModelFilename = configuration.getTraceModelFilename();
		mitraConfiguration.saveTraces = configuration.isSaveTraces();
		mitraConfiguration.overwriteTraces = configuration.isOverwriteTraces();
		
		StandaloneExecutor standaloneExecutor =
			new StandaloneExecutor(fqnRule, arguments, outputModelFilenames,
				mitraConfiguration);

		return standaloneExecutor;
	}

	static <T extends EObject> T loadModel(String filename) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource =
			resourceSet.createResource(URI.createFileURI(filename));

		if (!resource.isLoaded()) {
			resource.load(null);
		}
		@SuppressWarnings("unchecked")
		T content = (T) resource.getContents().get(0);
		return content;

	}


	/**
	 * Creates an {@link ILaunchConfiguration} and sets the attribute
	 * {@link #SESSIONID}. The session ID can then later be used to retrieve the
	 * executor.
	 * 
	 * @param executor
	 * @return
	 * @throws CoreException
	 */
	public ILaunchConfiguration
			createConfiguration(StandaloneExecutor executor)
					throws CoreException {
		ILaunchConfigurationType type =
			getConfigurationType(getLaunchManager());

		ILaunchConfigurationWorkingCopy workingCopy =
			type.newInstance(null, "Mitra " + executor.getDescription());

		return workingCopy;

	}

	/**
	 * @return
	 */
	private ILaunchConfigurationType
			getConfigurationType(ILaunchManager manager) {
		ILaunchConfigurationType type =
			manager.getLaunchConfigurationType(LAUNCH_CONFIG_TYPE);
		return type;
	}

	/**
	 * @return
	 */
	private ILaunchManager getLaunchManager() {
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		return manager;
	}

}
