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

package de.jevopi.mitra2.exec;

import static java.util.Collections.emptyMap;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.traces.TracesPackage;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 8, 2012
 */
public class MitraArgumentResource extends MitraArgument {

	public static MitraArgumentResource createTraceModelArgumentResource(
			URI i_uriOfTraceModel) {
		return new MitraArgumentResource(TRACE_MODEL_ARGNAME,
			i_uriOfTraceModel, TracesPackage.eINSTANCE.getTraceRecord());
	}

	protected URI modelURI;
	protected EClass expectedContentType;

	protected EObject content;

	public MitraArgumentResource(String i_name, URI i_modelURI) {
		this(i_name, i_modelURI, null);
	}

	public MitraArgumentResource(String i_name, URI i_uriOfResource,
			EClass i_expectedContentType) {
		super(i_name);
		modelURI = i_uriOfResource;
		expectedContentType = i_expectedContentType;
	}

	/**
	 * Loads the resource at the URI specified in the constructor. The the
	 * resource is loaded using the resource set found in the project context (
	 * {@link ProjectContext#getModelResourceSet()}) in order to enable trace
	 * models to link to elements. The resource is expected to contain exactly
	 * one content element. If the expectedContentType is specified, it is
	 * checked against the type of the content object (via
	 * {@link EClass#isInstance(Object)}.
	 * 
	 * @see de.jevopi.mitra2.exec.MitraArgument#init(de.jevopi.mitra2.context.ProjectContext)
	 */
	@Override
	public void init(ProjectContext i_projectContext, boolean isReturnParameter) throws IOException {
		ResourceSet resourceSet = i_projectContext.getResourceSet();
		Resource resource = resourceSet.createResource(modelURI);
		
		if (!(isReturnParameter || i_projectContext.getPathHandler().existsModel(modelURI))) {
			throw new FileNotFoundException("No model found at " + modelURI);
		}
		
		if (!resource.isLoaded()) {
			resource.load(emptyMap());
		}

		if (resource.getContents().size() != 1) {
			throw new IllegalArgumentException(
				"Resource must contains only one content element, " + resource
					+ " contained " + resource.getContents().size());
		}

		content = resource.getContents().get(0);

		if (expectedContentType != null) {
			if (!expectedContentType.isInstance(content)) {
				content = null;
				throw new IllegalArgumentException(
					"Resource is expected to contain type "
						+ expectedContentType );
			}
		}
	}
	
	@Override
	public void save() {
		
	}

	/**
	 * Returns the content object of the resource found in the URI specified in
	 * the constructor. The content is actually loaded in
	 * {@link #init(ProjectContext)}.
	 * 
	 * @see de.jevopi.mitra2.exec.MitraArgument#getRawValue()
	 */
	@Override
	public Object getRawValue() {
		return content;
	}

}
