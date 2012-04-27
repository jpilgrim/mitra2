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

package de.jevopi.mitra2.nativeoperations.collections;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.MObject;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 1, 2012
 */
public class Excludes extends Includes {

	public static final String DESCRIPTION =
		"Returns true if the receiver does not contain the given argument. "
			+ "This is also true if the receiver is a simple object and if it does not equal the argument.";

	public Excludes(ProjectContext projectContext) {
		super(projectContext);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}


	/** 
	 * @see de.jevopi.mitra2.nativeoperations.collections.Includes#computeRawValue(de.jevopi.mitra2.metamodel.MObject, java.lang.Object)
	 * @since Feb 6, 2012
	 */
	@Override
	protected boolean computeRawValue(MObject i_receiver, MObject i_argument) {
		return ! super.computeRawValue(i_receiver, i_argument);
	}

}
