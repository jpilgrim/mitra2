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
import de.jevopi.mitra2.metamodel.mitracollections.MitraCollection;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 24, 2012
 */
public class Reject extends Select {

	public final static String DESCRIPTION = "Returns a sub-collection "
		+ "with all elements for which the given expression is false.";

	
	public Reject(ProjectContext i_projectContext) {
		super(i_projectContext);
	}
	
	/**
	 * @see de.jevopi.mitra2.nativeoperations.INativeOperation#getDescription()
	 */
	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
	
	/**
	 * @see de.jevopi.mitra2.nativeoperations.collections.AbstractCollectionOperationWithIteratorExpression#process(de.jevopi.mitra2.metamodel.MObject,
	 *      de.jevopi.mitra2.nativeoperations.collections.AbstractCollectionOperationWithIteratorExpression.ProcessResult)
	 */
	@Override
	protected void process(MObject v, MObject i_evalWithV, ProcessResult io_processResult) {
		boolean doSelect = (Boolean) i_evalWithV.getValue();
		if (! doSelect)
			((MitraCollection) io_processResult.result.getValue()).add(v);
	}

}
