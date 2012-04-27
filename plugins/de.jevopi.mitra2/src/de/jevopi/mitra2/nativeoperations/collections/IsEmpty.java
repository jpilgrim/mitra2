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

import static de.jevopi.mitra2.metamodel.PrimitiveMetamodel.BOOLEAN;

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
public class IsEmpty extends AbstractNativeOperation {

	
	public static final String DESCRIPTION =
		"Returns true if the receiver is a collection without any elements, " +
		"or if the receiver is null.";

	public IsEmpty(ProjectContext projectContext) {
		super(projectContext);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public Type getTypeFromArgumentCall(Type i_receiverType, List<Type> i_argumentTypes) {
		return BOOLEAN;
	}

	

	@Override
	public MObject invokeWithArguments(MObject i_receiver, List<MObject> i_arguments) {
		boolean value = computeRawValue(i_receiver, i_arguments);
		MObject returnValue = new MObject(BOOLEAN, value);
		return returnValue;
	}
	
	protected boolean computeRawValue(MObject i_receiver, @SuppressWarnings("unused") List<MObject> i_arguments) {
		Type receiverType = i_receiver.getActualType();
		if (receiverType instanceof CollectionType) {
			MitraCollection collection = (MitraCollection) i_receiver.getValue();
			return collection.isEmpty();
		}
		// simple object:
		return MObject.NULL.equals(i_receiver);
	}

}
