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

import static java.util.Collections.singletonList;

import java.util.List;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.PrimitiveMetamodel;
import de.jevopi.mitra2.metamodel.mitracollections.MitraOrderedCollection;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.Type;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 5, 2012
 */
public class At extends AbstractOrderedOperation {

	public At(ProjectContext projectContext) {
		super(projectContext);
	}

	@Override
	public String getDescription() {
		return "Returns the element at the given index (if the receiver is an ordered collection), "
			+ "or the receiver itself if its a simple object (and the index is 0)";
	}

	/**
	 * @param i_receiverType
	 * @param i_argumentOrIteratorTypes
	 * @return
	 */
	@Override
	public boolean acceptArgumentCallTypes(Type i_receiverType, List<Type> i_argumentTypes) {
		return acceptReceiver(i_receiverType)
			&& firstArgumentIsInteger(i_argumentTypes);

	}

	/**
	 * @see de.jevopi.mitra2.nativeoperations.AbstractNativeOperation#getParameterTypes(de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	public List<? extends Type> getParameterTypes(Type i_receiverType) {
		return singletonList(PrimitiveMetamodel.INT);
	}

	/**
	 * @see de.jevopi.mitra2.nativeoperations.AbstractNativeOperation#getType(de.jevopi.mitra2.mitra.Type,
	 *      java.util.List)
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
	 */
	@Override
	public MObject invokeWithArguments(MObject receiver, List<MObject> arguments) {
		Type receiverType = receiver.getActualType();
		int index = arguments.get(0).castToInteger(getMetamodelManager());

		if (receiverType instanceof CollectionType) {
			if (!(receiver.getValue() instanceof MitraOrderedCollection)) {
				throw new IllegalArgumentException(
					"Cannot apply at on non-ordered collections");
			}
			MitraOrderedCollection orderedCollection =
				(MitraOrderedCollection) receiver.getValue();
			return orderedCollection.at(index);
		}

		if (index == 0) return receiver;

		throw new IndexOutOfBoundsException(
			"receiver is no collection, only index 0 is allowed for singletons");

	}

}
