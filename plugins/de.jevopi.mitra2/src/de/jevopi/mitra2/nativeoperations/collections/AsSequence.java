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

import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.CollectionMetamodel;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.mitracollections.MitraCollection;
import de.jevopi.mitra2.metamodel.mitracollections.MitraSequenceImpl;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.nativeoperations.AbstractNativeOperation;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 1, 2012
 */
public class AsSequence extends AbstractNativeOperation {

	public static final String DESCRIPTION =
		"Converts any collection or object into a sequence. The "
			+ "returned sequence is always a copy, even if the original "
			+ "collection is a sequence as well.";

	public AsSequence(ProjectContext projectContext) {
		super(projectContext);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public Type getTypeFromArgumentCall(Type i_receiverType, List<Type> i_argumentTypes) {
		Type typePar;
		if (i_receiverType instanceof CollectionType) {
			typePar = ((CollectionType) i_receiverType).getTypePar();
		} else {
			typePar = i_receiverType;
		}
		return CollectionMetamodel.createCollectionType(false, true, typePar);
	}

	@Override
	public MObject invokeWithArguments(MObject i_receiver, List<MObject> i_arguments) {

		Type type =
			getTypeFromArgumentCall(i_receiver.getActualType(),
					MitraUtils.getTypes(i_arguments));

		if (MObject.NULL.equals(i_receiver)) {
			MObject returnValue = new MObject(type, new MitraSequenceImpl(0));
			return returnValue;
		}

		if (i_receiver.getActualType() instanceof CollectionType) {
			Object value = i_receiver.getValue();
			MObject returnValue =
				new MObject(type, new MitraSequenceImpl((MitraCollection) value));
			return returnValue;
		}

		MObject returnValue = new MObject(type, new MitraSequenceImpl(i_receiver));
		return returnValue;
	}

}
