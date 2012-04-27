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

import java.util.List;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.MObject;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 1, 2012
 */
public class ExcludesAll extends IncludesAll {

	public static final String DESCRIPTION =
		"Returns true if the receiver contains none of the elements of the given argument (collection). "
			+ "This can also be evaluated for simple objects (both receiver or argument).";

	public ExcludesAll(ProjectContext projectContext) {
		super(projectContext);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	protected boolean computeRawValue(MObject i_receiver, List<MObject> i_arguments) {
		return ! super.computeRawValue(i_receiver, i_arguments);
	}

}
