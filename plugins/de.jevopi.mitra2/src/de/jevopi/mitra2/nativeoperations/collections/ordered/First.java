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

import java.util.List;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.mitracollections.MitraOrderedCollection;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.Type;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 5, 2012
 */
public class First extends AbstractOrderedOperation {

	public First(ProjectContext projectContext) {
		super(projectContext);
	}

	/**
	 * @see de.jevopi.mitra2.nativeoperations.INativeOperation#getDescription()
	 * @since Feb 5, 2012
	 */
	@Override
	public String getDescription() {
		return "Returns the first element (if the receiver is an ordered collection), "
			+ "or the receiver itself if its a simple object";
	}

	/**
	 * @see de.jevopi.mitra2.nativeoperations.AbstractNativeOperation#getType(de.jevopi.mitra2.mitra.Type,
	 *      java.util.List)
	 * @since Feb 5, 2012
	 */
	@Override
	public Type getTypeFromArgumentCall(Type i_receiverType,
			List<Type> i_argumentTypes) {
		if (i_receiverType instanceof CollectionType) {
			return ((CollectionType) i_receiverType).getTypePar();
		}
		return i_receiverType;
	}

	/**
	 * @see de.jevopi.mitra2.nativeoperations.INativeOperation#invoke(de.jevopi.mitra2.metamodel.MObject,
	 *      java.util.List)
	 * @since Feb 5, 2012
	 */
	@Override
	public MObject invokeWithArguments(MObject receiver, List<MObject> arguments) {
		Type receiverType = receiver.getActualType();

		if (receiverType instanceof CollectionType) {
			MitraOrderedCollection orderedCollection =
				(MitraOrderedCollection) receiver.getValue();
			return orderedCollection.first();
		}

		return receiver;
	}

}
