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

package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.PrimitiveType;
import de.jevopi.mitra2.mitra.ReferenceType;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Jan 23, 2012
 */
public class CompareTo {

	
	public static int hashCode(PrimitiveType type) {
		if (type==null) return 0;
		return type.getPrimitiveType().hashCode();
	}
	
	public static boolean equals(PrimitiveType typeA, Object other) {
		return compareTo(typeA, other)==0;
	}
	
	public static int compareTo(PrimitiveType typeA, Object other) {
		if (typeA==other) return 0;
		if (other==null) return -1;
		if (other instanceof PrimitiveType) {
			return typeA.getPrimitiveType().compareTo(((PrimitiveType) other).getPrimitiveType());
		}
		return typeA.getClass().getName().compareTo(other.getClass().getName());
	}
	
	
	
	public static int hashCode(ReferenceType type) {
		return System.identityHashCode(type);
		/*
		if (type==null) return 0;
		
		if (type.eIsProxy()) {
			throw new IllegalStateException("Cannot create hashCode for proxy");
		}
		
		EClassifier eClassifier = ((ReferenceTypeImpl)type).basicGetEClassifier();
		if (eClassifier.eIsProxy()) {
			throw new IllegalStateException("Cannot create hashCode for ReferenceType with unresolved classifier");
		}
		
		return // 31* type.getMetamodelDeclaration().getName().hashCode() +
			type.getEClassifier().getName().hashCode();
		*/
	}
	
	public static boolean equals(ReferenceType typeA, Object other) {
		return compareTo(typeA, other)==0;
	}
	
	public static int compareTo(ReferenceType typeA, Object other) {
		if (typeA==other) return 0;
		if (other==null) return -1;
		if (other instanceof ReferenceType) {
			ReferenceTypeImpl rt = (ReferenceTypeImpl) typeA;
			ReferenceTypeImpl rtOther = (ReferenceTypeImpl) other;
			
			if (rt.eIsProxy() || rtOther.eIsProxy() ||
					rt.basicGetEClassifier().eIsProxy() || rt.basicGetMetamodelDeclaration().eIsProxy()
			|| rtOther.basicGetEClassifier().eIsProxy() || rtOther.basicGetMetamodelDeclaration().eIsProxy()
			) {
				throw new IllegalStateException("Cannot compare unresolved type");
			}
			
			if (typeA.getMetamodelDeclaration().getName().equals(rtOther.getMetamodelDeclaration().getName())) {
				return typeA.getEClassifier().getName().compareTo(rtOther.getEClassifier().getName());
			}
		}
		return typeA.getClass().getName().compareTo(other.getClass().getName());
	}
	
	
	
}
