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

import org.eclipse.emf.ecore.EObject;

import de.jevopi.ecore.utils.EMFUtil;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.Type;

/**
 * Compares an {@link MObject} with declared actualtype info in order to be able
 * to distinguish between actual (=MObject{@link #getType()} and declared
 * actualtype. This actualtype of object is only used internally, as in other
 * cases an {@link MObject} is bound to a variable (or parameter etc.) which
 * defines the declared actualtype.
 * 
 * @author Jens von Pilgrim
 */
public class MInstance {

	MObject mobject;

	Type declaredType;

	/**
	 * @param i_mobj must not be null
	 * @param i_declaredType must not be null
	 */
	public MInstance(MObject i_mobj, Type i_declaredType) {
		if (i_mobj == null) {
			throw new NullPointerException("i_mobj must not be null");
		}
		if (i_declaredType == null) {
			throw new NullPointerException("i_declaredType must not be null");
		}

		if (i_mobj.getActualType() instanceof CollectionType
				&& !(i_declaredType instanceof CollectionType)) {
			throw new IllegalArgumentException(
					"Instance is a collection, but non-collection is declared.");
		}

		mobject = i_mobj;
		declaredType = i_declaredType;
	}

	/**
	 * Returns the declared actualtype, which may be different from the (actual)
	 * actualtype of the mobject.
	 * 
	 * @return
	 */
	public Type getDeclaredType() {
		return declaredType;
	}

	/**
	 * Delegator method, returns {@link MObject#getType()} which is the actual
	 * actualtype of an object.
	 * 
	 * @return
	 */
	public Type getActualType() {
		return mobject.getActualType();
	}

	/**
	 * Delegator method, returns {@link MObject#getValue()}
	 * 
	 * @return
	 */
	public Object getValue() {
		return mobject.getValue();
	}

	public MObject getMObject() {
		return mobject;
	}

	@Override
	public String toString() {

		StringBuilder strb = new StringBuilder();

		if (mobject.actualtype == null) {
			strb.append("?");
		} else {
			strb.append(String.valueOf(mobject.actualtype));
		}
		if (declaredType != mobject.actualtype) {
			strb.append("{").append(String.valueOf(declaredType)).append("}");
		}

		strb.append(": ");

		if (mobject.value == null) {
			strb.append("null");
		} else {
			if (mobject.value instanceof EObject) {
				strb.append(EMFUtil.toHRString((EObject) mobject.value));
			} else {
				strb.append(mobject.value.toString());
			}
		}
		return strb.toString();
	}

}
