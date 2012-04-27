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
package de.jevopi.mitra2.metamodel;

import java.util.Comparator;

import de.jevopi.mitra2.mitra.PrimitiveType;
import de.jevopi.mitra2.mitra.ReferenceType;
import de.jevopi.mitra2.mitra.Type;

/**
 * TypeComparator There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 */
public class TypeComparator implements Comparator<Type> {

	MetamodelManager manager;

	/**
	 * @param manager
	 */
	public TypeComparator(MetamodelManager manager) {
		super();
		this.manager = manager;
	}

	/**
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Type o1, Type o2) {
		// shortcut
		if (o1 == o2) {
			return 0;
		}

		// if (o1.isMany()!=o2.isMany()) {
		// if (!o1.isMany())
		// return -1;
		// else
		// return 1;
		// }

		if (o1 instanceof PrimitiveType && !(o2 instanceof PrimitiveType)) {
			return -1;
		}
		if (o2 instanceof PrimitiveType && !(o1 instanceof PrimitiveType)) {
			return 1;
		}
		IMetamodel metamodel = manager.getMetamodel(o1);
		if (metamodel.equals(o1, o2)) {
			return 0;
		}
		if (o1 instanceof ReferenceType) { // && o2 instanceof ReferenceType)
			ReferenceType r1 = (ReferenceType) o1;
			ReferenceType r2 = (ReferenceType) o2;
			int mmc = r1.getMetamodelDeclaration().getName()
					.compareTo(r2.getMetamodelDeclaration().getName());
			if (mmc == 0) {
				mmc = r1.getEClassifier().getName()
						.compareTo(r2.getEClassifier().getName());
			}
			return mmc;
		}
		// both primitive:
		PrimitiveType p1 = (PrimitiveType) o1;
		PrimitiveType p2 = (PrimitiveType) o2;
		return p1.getPrimitiveType().compareTo(p2.getPrimitiveType());
	}

}
