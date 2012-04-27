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

import static java.util.Collections.emptyList;

import java.util.List;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.CollectionMetamodel;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.mitracollections.MitraCollection;
import de.jevopi.mitra2.metamodel.mitracollections.MitraCollectionUtils;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.weak.WeakCollectionType;
import de.jevopi.mitra2.nativeoperations.AbstractNativeOperation;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 1, 2012
 */
public class Flatten extends AbstractNativeOperation {

	public static final String DESCRIPTION =
		"Returns a new collection containing all elements contained by this "
			+ "collection. If this collection contains collections itself, the "
			+ "contained collections are (recursively) flattened as well. The type of the returned collection equals the type of the receiver, however the type parameter is the type of the contained elements.";

	/**
	 * @param i_metamodelManager
	 */
	public Flatten(ProjectContext projectContext) {
		super(projectContext);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public CollectionType getTypeFromArgumentCall(Type i_receiverType,
			List<Type> i_argumentTypes) {
		if (i_receiverType instanceof CollectionType) {
			CollectionType collectionType = (CollectionType) i_receiverType;
			Type typePar = collectionType.getTypePar();
			while (typePar instanceof CollectionType) {
				typePar = ((CollectionType) typePar).getTypePar();
			}
			CollectionType returnType = new WeakCollectionType();
			returnType.setCollectionType(collectionType.getCollectionType());
			returnType.setTypePar(typePar);

			return returnType;
		}

		// simple object:
		return CollectionMetamodel.createCollectionType(true, true,
				i_receiverType);

	}

	@Override
	public MObject invokeWithArguments(MObject i_receiver,
			List<MObject> i_arguments) {

		List<Type> noArgTypes = emptyList();
		CollectionType type =
			getTypeFromArgumentCall(i_receiver.getActualType(), noArgTypes);

		MitraCollection collection = CollectionMetamodel.createCollection(type);
		
		if (i_receiver.getActualType() instanceof CollectionType) {
			MitraCollection original = (MitraCollection) i_receiver.getValue();
			MitraCollectionUtils.doFlatten(collection, original);
		} else {
			collection.add(i_receiver);
		}	
		
		MObject returnValue = new MObject(type, collection);
		return returnValue;
		
	}

}
