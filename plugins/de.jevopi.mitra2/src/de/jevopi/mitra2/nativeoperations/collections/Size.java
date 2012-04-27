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

import static de.jevopi.mitra2.metamodel.PrimitiveMetamodel.INT;

import java.util.Collection;
import java.util.List;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.mitracollections.MitraCollection;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.nativeoperations.AbstractNativeOperation;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 1, 2012
 */
public class Size extends AbstractNativeOperation {

	public static final String DESCRIPTION =
		"Returns the size of the receiver, interpreted as a collection. "
			+ "That is, for a collection, its size is returned. "
			+ "If the receiver is null, 0 is returned. "
			+ "For simple objects, 1 is returned.";

	public Size(ProjectContext projectContext) {
		super(projectContext);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public Type getTypeFromArgumentCall(Type i_receiverType,
			List<Type> i_argumentTypes) {
		return INT;
	}

	@Override
	public MObject invokeWithArguments(MObject i_receiver,
			List<MObject> i_arguments) {

		if (MObject.NULL.equals(i_receiver)) {
			MObject returnValue = new MObject(INT, 0);
			return returnValue;
		}

		Type receiverType = i_receiver.getActualType();
		if (receiverType instanceof CollectionType) {

			MitraCollection collection = (MitraCollection) i_receiver.getValue();
			MObject returnValue = new MObject(INT, collection.size());
			return returnValue;

		}
	
		MObject returnValue = new MObject(INT, 1);
		return returnValue;
	}

}
