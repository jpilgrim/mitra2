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

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.sourcelookup.ISourceContainerType;
import org.eclipse.debug.core.sourcelookup.containers.AbstractSourceContainer;
import org.eclipse.debug.core.sourcelookup.containers.DirectorySourceContainer;

/**
 * DelegateSourceContainer There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @since Mitra 1
 */
public class DelegateSourceContainer extends AbstractSourceContainer {

	private IWorkspace workspace;

	public DelegateSourceContainer(IWorkspace workspace) {
		this.workspace = workspace;
	}

	/**
	 * @see org.eclipse.debug.core.sourcelookup.ISourceContainer#findSourceElements(java.lang.String)
	 */
	@Override
	public Object[] findSourceElements(String name) throws CoreException {
		return new Object[] { workspace.getRoot().getFileForLocation(
				new Path(name)) };
	}

	/**
	 * @see org.eclipse.debug.core.sourcelookup.ISourceContainer#getName()
	 */
	@Override
	public String getName() {
		return "Delegate";
	}

	/**
	 * @see org.eclipse.debug.core.sourcelookup.ISourceContainer#getType()
	 */
	@Override
	public ISourceContainerType getType() {
		return getSourceContainerType(DirectorySourceContainer.TYPE_ID);
	}

}
