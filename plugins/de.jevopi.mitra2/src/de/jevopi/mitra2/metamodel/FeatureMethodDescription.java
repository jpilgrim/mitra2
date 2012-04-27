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

package de.jevopi.mitra2.metamodel;

import java.util.ArrayList;
import java.util.List;

import de.jevopi.mitra2.mitra.Type;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Jan 20, 2012
 */
public class FeatureMethodDescription extends FeatureDescription {

	Type[] parameterTypes;

	/**
	 * @param i_name
	 * @param i_type
	 * @param i_declaredType
	 */
	public FeatureMethodDescription(String i_name, Type i_type, int lowerBound,
			int upperBound, boolean unique, boolean ordered,
			Type[] parameterTypes, Type i_declaredType) {
		super(i_name, i_type, lowerBound, upperBound, unique, ordered,
				i_declaredType);
		this.parameterTypes = parameterTypes;
	}
	
	/** 
	 * @see de.jevopi.mitra2.metamodel.FeatureDescription#getFeatureType()
	 */
	@Override
	public FeatureType getFeatureType() {
		return FeatureType.METHOD;
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.FeatureDescription#getDescription()
	 */
	@Override
	public String getDescription() {
		StringBuilder res = new StringBuilder();
		res.append(getName()).append("(..) : ");
		res.append(getType().toString());
		res.append(" - ").append(getDeclaredType().toString());

		return res.toString();
	}

	/**
	 * Returns brief description including (simple) name, type, and constraints
	 * 
	 * @return
	 * @since Feb 5, 2012
	 */
	@Override
	public String getBriefDescription() {
		StringBuilder res = new StringBuilder();
		res.append(getName());
		res.append('(');
		for (int i = 0; i < parameterTypes.length; i++) {
			if (i != 0) {
				res.append(", ");
			}
			res.append(parameterTypes[i]);
		}
		res.append(')');
		res.append(": ");
		res.append(getType().toString());
		String strConstraints = constraintsToString();
		if (!strConstraints.isEmpty()) {
			res.append(' ').append(strConstraints);
		}
		return res.toString();
	}

	/**
	 * @return
	 * @since Feb 5, 2012
	 */
	@Override
	public String constraintsToString() {
		if (!isMany() && !isChangeable()) {
			return "";
		}

		List<String> constraintStrings = new ArrayList<String>(3);
		if (isChangeable()) {
			constraintStrings.add("writeable");
		}
		if (isMany()) {
			if (isUnique()) {
				constraintStrings.add("unique");
			}
			if (isOrdered()) {
				constraintStrings.add("ordered");
			}
		}

		StringBuilder strb = new StringBuilder();
		strb.append('{');
		for (int i = 0; i < constraintStrings.size(); i++) {
			if (i > 0) {
				strb.append(", ");
			}
			strb.append(constraintStrings.get(i));
		}
		strb.append('}');
		return strb.toString();
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.FeatureDescription#isChangeable()
	 */
	@Override
	public boolean isChangeable() {
		return false;
	}

	public Type[] getParameterTypes() {
		return parameterTypes;
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.FeatureDescription#isMethod()
	 * @since Feb 1, 2012
	 */
	@Override
	public boolean isMethod() {
		return true;
	}

}
