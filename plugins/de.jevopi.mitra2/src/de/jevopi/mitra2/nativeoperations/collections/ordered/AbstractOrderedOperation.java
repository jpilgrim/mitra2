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

package de.jevopi.mitra2.nativeoperations.collections.ordered;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.CollectionMetamodel;
import de.jevopi.mitra2.metamodel.PrimitiveMetamodel;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.nativeoperations.AbstractNativeOperation;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 5, 2012
 */
public abstract class AbstractOrderedOperation extends AbstractNativeOperation {

	public AbstractOrderedOperation(ProjectContext projectContext) {
		super(projectContext);
	}

	/**
	 * Default implementation, accept all ordered collection and single object
	 * types.
	 * 
	 * @see de.jevopi.mitra2.nativeoperations.INativeOperation#acceptReceiver(de.jevopi.mitra2.mitra.Type)
	 * 
	 */
	@Override
	public boolean acceptReceiver(Type i_receiverType) {
		if (i_receiverType instanceof CollectionType) {
			return CollectionMetamodel
				.isOrdered((CollectionType) i_receiverType);
		}
		return !PrimitiveMetamodel.VOID.equals(i_receiverType);
	}
}
