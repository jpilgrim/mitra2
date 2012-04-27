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
package de.jevopi.mitra2.context;

import java.util.logging.Level;

import java.util.HashMap;
import java.util.logging.Logger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;


public class MitraResourceSet extends ResourceSetImpl implements IProjectContextProvider {
	/**
	 * Logger for this class
	 */
	// @SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger log = Logger.getLogger(MitraResourceSet.class.getName());

	ProjectContext projectContext;
	
	

	/**
	 * @param projectContext
	 */
	public MitraResourceSet(ProjectContext projectContext) {
		this.projectContext = projectContext;
		setURIResourceMap(new HashMap<URI, Resource>());
	}
	
	
	@Override
	public ProjectContext getProjectContext() {
		return projectContext;
	}

	@Override
	public void eNotify(Notification notification) {
		super.eNotify(notification);
		
		log.info("Notification: " + notification);
	}
	
	@Override
	public Resource createResource(URI uri, String contentType) {
		Resource resource = getURIResourceMap().get(uri);
		if (resource!=null) 
			return resource;
		

		if (log.isLoggable(Level.INFO)) {
			log.info("Create new resource for " + uri); //$NON-NLS-1$
		}
		
		resource = super.createResource(uri, contentType);
		getURIResourceMap().put(uri, resource);
		return resource;
	}
	
}
