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

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;

public class DelegatingMitraResourceSet implements IProjectContextProvider, ResourceSet, Adapter {
	
	ResourceSet delegate;
	
	ProjectContext projectContext;
	
	
	/**
	 * @param delegate
	 */
	public DelegatingMitraResourceSet(ProjectContext projectContext, ResourceSet delegate) {
		this.projectContext = projectContext;
		this.setTarget(delegate);
	}
	
	@Override
	public ProjectContext getProjectContext() {
		return projectContext;
	}

	/**
	 * @return
	 * @see org.eclipse.emf.common.notify.Notifier#eAdapters()
	 */
	@Override
	public EList<Adapter> eAdapters() {
		return delegate.eAdapters();
	}

	/**
	 * @return
	 * @see org.eclipse.emf.common.notify.Notifier#eDeliver()
	 */
	@Override
	public boolean eDeliver() {
		return delegate.eDeliver();
	}

	/**
	 * @param deliver
	 * @see org.eclipse.emf.common.notify.Notifier#eSetDeliver(boolean)
	 */
	@Override
	public void eSetDeliver(boolean deliver) {
		delegate.eSetDeliver(deliver);
	}

	/**
	 * @param notification
	 * @see org.eclipse.emf.common.notify.Notifier#eNotify(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void eNotify(Notification notification) {
		delegate.eNotify(notification);
	}

	/**
	 * @return
	 * @see org.eclipse.emf.ecore.resource.ResourceSet#getResources()
	 */
	@Override
	public EList<Resource> getResources() {
		return delegate.getResources();
	}

	/**
	 * @return
	 * @see org.eclipse.emf.ecore.resource.ResourceSet#getAllContents()
	 */
	@Override
	public TreeIterator<Notifier> getAllContents() {
		return delegate.getAllContents();
	}

	/**
	 * @return
	 * @see org.eclipse.emf.ecore.resource.ResourceSet#getAdapterFactories()
	 */
	@Override
	public EList<AdapterFactory> getAdapterFactories() {
		return delegate.getAdapterFactories();
	}

	/**
	 * @return
	 * @see org.eclipse.emf.ecore.resource.ResourceSet#getLoadOptions()
	 */
	@Override
	public Map<Object, Object> getLoadOptions() {
		return delegate.getLoadOptions();
	}

	/**
	 * @param uri
	 * @param loadOnDemand
	 * @return
	 * @see org.eclipse.emf.ecore.resource.ResourceSet#getEObject(org.eclipse.emf.common.util.URI, boolean)
	 */
	@Override
	public EObject getEObject(URI uri, boolean loadOnDemand) {
		return delegate.getEObject(uri, loadOnDemand);
	}

	/**
	 * @param uri
	 * @param loadOnDemand
	 * @return
	 * @see org.eclipse.emf.ecore.resource.ResourceSet#getResource(org.eclipse.emf.common.util.URI, boolean)
	 */
	@Override
	public Resource getResource(URI uri, boolean loadOnDemand) {
		return delegate.getResource(uri, loadOnDemand);
	}

	/**
	 * @param uri
	 * @return
	 * @see org.eclipse.emf.ecore.resource.ResourceSet#createResource(org.eclipse.emf.common.util.URI)
	 */
	@Override
	public Resource createResource(URI uri) {
		return delegate.createResource(uri);
	}

	/**
	 * @param uri
	 * @param contentType
	 * @return
	 * @see org.eclipse.emf.ecore.resource.ResourceSet#createResource(org.eclipse.emf.common.util.URI, java.lang.String)
	 */
	@Override
	public Resource createResource(URI uri, String contentType) {
		return delegate.createResource(uri, contentType);
	}

	/**
	 * @return
	 * @see org.eclipse.emf.ecore.resource.ResourceSet#getResourceFactoryRegistry()
	 */
	@Override
	public Registry getResourceFactoryRegistry() {
		return delegate.getResourceFactoryRegistry();
	}

	/**
	 * @param resourceFactoryRegistry
	 * @see org.eclipse.emf.ecore.resource.ResourceSet#setResourceFactoryRegistry(org.eclipse.emf.ecore.resource.Resource.Factory.Registry)
	 */
	@Override
	public void setResourceFactoryRegistry(Registry resourceFactoryRegistry) {
		delegate.setResourceFactoryRegistry(resourceFactoryRegistry);
	}

	/**
	 * @return
	 * @see org.eclipse.emf.ecore.resource.ResourceSet#getURIConverter()
	 */
	@Override
	public URIConverter getURIConverter() {
		return delegate.getURIConverter();
	}

	/**
	 * @param converter
	 * @see org.eclipse.emf.ecore.resource.ResourceSet#setURIConverter(org.eclipse.emf.ecore.resource.URIConverter)
	 */
	@Override
	public void setURIConverter(URIConverter converter) {
		delegate.setURIConverter(converter);
	}

	/**
	 * @return
	 * @see org.eclipse.emf.ecore.resource.ResourceSet#getPackageRegistry()
	 */
	@Override
	public org.eclipse.emf.ecore.EPackage.Registry getPackageRegistry() {
		return delegate.getPackageRegistry();
	}

	/**
	 * @param packageRegistry
	 * @see org.eclipse.emf.ecore.resource.ResourceSet#setPackageRegistry(org.eclipse.emf.ecore.EPackage.Registry)
	 */
	@Override
	public void setPackageRegistry(
			org.eclipse.emf.ecore.EPackage.Registry packageRegistry) {
		delegate.setPackageRegistry(packageRegistry);
	}

	@Override
	public void notifyChanged(Notification notification) {
	}

	@Override
	public Notifier getTarget() {
		return delegate;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		delegate = (ResourceSet) newTarget;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return false;
	}

	

}
