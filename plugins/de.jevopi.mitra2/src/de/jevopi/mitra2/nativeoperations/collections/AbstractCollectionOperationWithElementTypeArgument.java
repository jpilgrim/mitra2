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
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.nativeoperations.AbstractNativeOperation;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 6, 2012
 */
public abstract class AbstractCollectionOperationWithElementTypeArgument extends
		AbstractNativeOperation {

	public AbstractCollectionOperationWithElementTypeArgument(
			ProjectContext projectContext) {
		super(projectContext);
	}

	/**
	 * Returns true if receiver is accepted and the argument list contains
	 * exactly one element. The type of the one argument must match the argument
	 * of the receiver elements (or the receiver itself, if the receiver is not
	 * a collection).
	 * 
	 * @param i_receiverType checked via {@link #acceptReceiver(Type)}
	 * @param i_argumentOrIteratorExpTypes one argument with type of receiver's
	 *            elements.
	 * 
	 * @see de.jevopi.mitra2.nativeoperations.AbstractNativeOperation#acceptArgumentCallTypes(de.jevopi.mitra2.mitra.Type,
	 *      java.util.List)
	 * @since Feb 5, 2012
	 */
	@Override
	public boolean acceptArgumentCallTypes(Type i_receiverType,
			List<Type> i_argumentOrIteratorExpTypes) {
		if (acceptReceiver(i_receiverType)
			&& i_argumentOrIteratorExpTypes.size() == 1) {
			Type argType = i_argumentOrIteratorExpTypes.get(0);
			if (i_receiverType instanceof CollectionType) {
				return getMetamodelManager().isSubType(argType,
						((CollectionType) i_receiverType).getTypePar());
			} else {
				return getMetamodelManager().isSubType(argType, i_receiverType);
			}
		}
		return false;
	}
}
