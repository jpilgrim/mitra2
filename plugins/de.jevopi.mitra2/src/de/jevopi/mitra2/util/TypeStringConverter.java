/*******************************************************************************
 * Copyright (c) 2012 Jens von Pilgrim
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 **************************************************************************** */
package de.jevopi.mitra2.util;

import de.jevopi.mitra2.metamodel.IMetamodel;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.CollectionTypeSpec;
import de.jevopi.mitra2.mitra.MitraFactory;
import de.jevopi.mitra2.mitra.PrimitiveType;
import de.jevopi.mitra2.mitra.PrimitiveTypeSpec;
import de.jevopi.mitra2.mitra.Type;

/**
 * Helper class converting types and bounds to strings (emit) and vice versa
 * (parse). This class is used by metamodel managers and toString methods of
 * actualtype implementations.
 * 
 * @author Jens von Pilgrim
 */
public class TypeStringConverter {

	public static final String METAMODEL_TYPE_SEPARATOR = "::";

	/**
	 * Parses a string and creates a actualtype. Warning: The created actualtype
	 * refers to no metamodel declaration. Instead of calling this method
	 * directly, better use
	 * {@link de.jevopi.mitra2.mitra.metamodel.IMetamodelManager#getTypeForName(String)}
	 * 
	 * @param s
	 * @return
	 * @throws TypeParseException
	 */
	public static Type parseType(String s, MetamodelManager metamodelManager)
			throws TypeParseException {

		if (s.contains(METAMODEL_TYPE_SEPARATOR)) {
			return parseReferenceType(s, metamodelManager);
		}
		return createBuiltInType(s);

	}

	private static Type parseReferenceType(String s,
			MetamodelManager metamodelManager) {
		int split = s.indexOf(METAMODEL_TYPE_SEPARATOR);
		String metamodel = s.substring(0, split);
		String type = s.substring(split + METAMODEL_TYPE_SEPARATOR.length());
		return createReferenceType(metamodel, type, metamodelManager);
	}

	private static Type createBuiltInType(String builtInTypeName)
			throws IllegalArgumentException {

		PrimitiveTypeSpec spec = PrimitiveTypeSpec.getByName(builtInTypeName);
		if (spec != null) {
			PrimitiveType pt = MitraFactory.eINSTANCE.createPrimitiveType();
			pt.setPrimitiveType(spec);
			return pt;
		}

		CollectionTypeSpec cspec =
			CollectionTypeSpec.getByName(builtInTypeName);
		if (cspec != null) {
			CollectionType ct = MitraFactory.eINSTANCE.createCollectionType();
			ct.setCollectionType(cspec);
			return ct;
		}

		throw new IllegalArgumentException("No built in type "
			+ builtInTypeName);

	}

	/**
	 * @param strMetamodel
	 * @param s
	 * @param from
	 * @param to
	 * @return
	 */
	private static Type createReferenceType(String nameOfMetamodel,
			String nameOfType, MetamodelManager metamodelManager) {
		IMetamodel metamodel = metamodelManager.getMetamodel(nameOfMetamodel);
		if (metamodel == null) {
			throw new IllegalArgumentException(
				"Did not found metamodel with name " + nameOfMetamodel);
		}

		Type t = metamodel.getTypeForName(nameOfType);
		return t;

	}

}
