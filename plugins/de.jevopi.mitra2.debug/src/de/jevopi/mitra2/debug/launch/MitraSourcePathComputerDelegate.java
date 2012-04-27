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
package de.jevopi.mitra2.debug.launch;

//import java.net.URI;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.sourcelookup.ISourceContainer;
import org.eclipse.debug.core.sourcelookup.ISourcePathComputerDelegate;

/**
 * MitraSourcePathComputerDelegate There should really be more documentation
 * here.
 * 
 * @author Jens von Pilgrim
 * @since Mitra 1
 */
public class MitraSourcePathComputerDelegate implements
		ISourcePathComputerDelegate {

	/**
	 * @see org.eclipse.debug.core.sourcelookup.ISourcePathComputerDelegate#computeSourceContainers(org.eclipse.debug.core.ILaunchConfiguration,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public ISourceContainer[] computeSourceContainers(
			ILaunchConfiguration configuration, IProgressMonitor monitor)
			throws CoreException {

		return new ISourceContainer[] { new DelegateSourceContainer(
				ResourcesPlugin.getWorkspace()) };
		//
		// List list = configuration.getAttribute("modulePath",
		// Collections.emptyList());
		// ISourceContainer sourceContainer = null;
		// if (list != null) {
		// List<URI> modulePath = (List<URI>) list;
		// for (URI uri : modulePath) {
		// IPath relativePath = this.getWorkspaceRelativePath(uri);
		// IResource resource = ResourcesPlugin.getWorkspace().getRoot()
		// .findMember(relativePath);
		// if (resource != null) {
		// IContainer container = resource.getParent();
		// if (container.getType() == IResource.PROJECT) {
		// sourceContainer = new ProjectSourceContainer(
		// (IProject) container, false);
		// } else if (container.getType() == IResource.FOLDER) {
		// sourceContainer = new FolderSourceContainer(container,
		// false);
		// }
		// }
		// }
		// }
		// if (sourceContainer == null) {
		// sourceContainer = new WorkspaceSourceContainer();
		// }
		// return new ISourceContainer[] { sourceContainer };
	}

}
