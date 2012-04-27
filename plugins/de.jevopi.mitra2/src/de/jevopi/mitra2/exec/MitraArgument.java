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

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 8, 2012
 */
public abstract class MitraArgument {

	/**
	 * Argument name of the trace model. The trace model is similarly handled as
	 * other arguments, its name is set to {@value #TRACE_MODEL_ARGNAME}. Since
	 * this name is not a valid Mitra identifier, it cannot be conflict with
	 * real arguments.
	 */
	public final static String TRACE_MODEL_ARGNAME = "#TRACES#";

	private final String name;

	/**
	 * @param i_name
	 */
	public MitraArgument(String i_name) {
		name = i_name;
	}

	/**
	 * Called before the Mitra interpreter is executed in order to load
	 * resources or initialize the argument otherwise. The default
	 * implementation does nothing.
	 * 
	 * @param projectContext the project context (used for paths, resource set
	 *            etc.)
	 * @param isReturnParameter
	 */
	public void init(ProjectContext projectContext, boolean isReturnParameter)
			throws Exception {}

	/**
	 * Called when the Mitra interpreter has terminated without errors.
	 */
	public void save() {}

	public abstract Object getRawValue();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public MObject getMitraObject(MetamodelManager metamodelManager) {
		return metamodelManager.wrap(getRawValue());
	}

}
