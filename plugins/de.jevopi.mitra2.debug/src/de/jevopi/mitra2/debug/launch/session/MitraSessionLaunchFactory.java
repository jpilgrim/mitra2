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

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;

import de.jevopi.mitra2.exec.SessionExecutor;

/**
 * Factory for creating launch configurations to start Mitra programmatically.
 * Further information about launching applications programmatically using
 * Eclipse's launch framework can be found in [Wright03a].
 * <p>
 * The created launch configuration is not intended to be stored, since it
 * contains transient information. That is a session id, which can be used by a
 * launch delegate to retrieve the {@link SessionExecutor}, which contains all
 * data needed to call the Mitra interpreter. A launch configuration only allows
 * Strings to be stored as attributes, but Mitra requires at least the
 * parameters to be passed (by reference). Hence the executor is made accessible
 * via a session id mechanism. The consequence is that a de.feu.mitra launch
 * configuration must not be persisted or reused.
 * </p>
 * <dl>
 * <dt><a name="Wright03a">[Wright03a]</a></dt>
 * <dd>Darin Wright: Launching Java Applications Programmatically. Eclipse
 * Corner Article, August, 2003, URL: <a href=
 * "http://www.eclipse.org/articles/Article-Java-launch/launching-java.html"
 * >http://www.eclipse.org/articles/Article-Java-launch/launching-java.html</a></dd>
 * </dl>
 * 
 * @author Jens von Pilgrim
 * @since Mitra 1
 */
public class MitraSessionLaunchFactory {

	private static MitraSessionLaunchFactory INSTANCE = new MitraSessionLaunchFactory();

	public static final String SESSIONID = "MitraSessionID";

	public static MitraSessionLaunchFactory instance() {
		return INSTANCE;
	}

	Map<String, SessionExecutor> sessions;

	/**
	 * 
	 */
	public MitraSessionLaunchFactory() {
		sessions = Collections
				.synchronizedMap(new TreeMap<String, SessionExecutor>());
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
	public ILaunchConfiguration createConfiguration(SessionExecutor executor)
			throws CoreException {
		ILaunchConfigurationType type = getConfigurationType(getLaunchManager());

		String sessionID = generateSessionID();

		ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(null,
				"Mitra " + sessionID);

		workingCopy.setAttribute(SESSIONID, sessionID);
		sessions.put(sessionID, executor);

		return workingCopy;

	}

	private synchronized String generateSessionID() {
		return new StringBuilder().append(sessions.size()).append('_') //
				.append(System.currentTimeMillis()).toString();
	}

	private ILaunchConfigurationType getConfigurationType(ILaunchManager manager) {
		ILaunchConfigurationType type = manager
				.getLaunchConfigurationType("mitraInterpreter.launchConfigurationType1");
		return type;
	}

	/**
	 * Returns the executor associated with a given session id. The association
	 * is previously created via {@link #createConfiguration(SessionExecutor)}.
	 * 
	 * @param sessiondID
	 * @return the executor or null, if sessionID is not valid.
	 */
	private SessionExecutor getExecutor(String sessiondID) {
		return sessions.get(sessiondID);
	}

	private ILaunchManager getLaunchManager() {
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		return manager;
	}

	/**
	 * Invalidates a session id, i.e. the executor is internally removed from
	 * the map. The launch configuration using that session id is removed from
	 * the manager's configuration collection.
	 * 
	 * @param sessionID
	 * @throws CoreException
	 */
	private void invalidateSession(String sessionID) throws CoreException {
		sessions.remove(sessionID);

		ILaunchManager manager = getLaunchManager();
		ILaunchConfigurationType type = getConfigurationType(manager);
		ILaunchConfiguration[] configurations = manager
				.getLaunchConfigurations(type);
		for (ILaunchConfiguration configuration : configurations) {
			if (sessionID.equals(configuration.getAttribute(SESSIONID, ""))) {
				configuration.delete();
				break;
			}
		}

	}

	/**
	 * Returns the executor identified by the session id found in the given
	 * configuration and removes the executor and session id from the internal
	 * map.
	 * 
	 * @param configuration
	 * @return
	 * @throws CoreException
	 */
	public SessionExecutor popExecutor(ILaunchConfiguration configuration)
			throws CoreException {
		String sessionID = configuration.getAttribute(SESSIONID, "");
		SessionExecutor executor = getExecutor(sessionID);
		invalidateSession(sessionID);
		return executor;
	}

}
