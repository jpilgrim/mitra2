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

import java.util.ArrayList;
import java.util.List;

import de.jevopi.mitra2.mitra.Type;

/**
 * Used for content assists
 * 
 * @author Jens von Pilgrim
 */
public abstract class FeatureDescription {
	
	public static enum FeatureType {
		FIELD, METHOD, NATIVE
	}

	public static String[] names(
			List<? extends FeatureDescription> featureDescriptions) {
		String[] names = new String[featureDescriptions.size()];
		for (int i = 0; i < names.length; i++) {
			names[i] = featureDescriptions.get(i).getName();
		}
		return names;
	}

	private String name;

	private Type type;

	private Type declaredType;

	private int lowerBound;

	private int upperBound;

	private boolean unique;

	private boolean ordered;
	
	
	/**
	 * Constructor for field
	 * 
	 * @param i_name must not be null
	 * @param i_type must not be null
	 * @param i_isChangeable
	 * @param i_declaredTypeName
	 * @param i_declarationDistance must be greater or equal 0
	 */
	protected FeatureDescription(String i_name, Type i_type, int lowerBound,
			int upperBound, boolean unique, boolean ordered, Type i_declaredType) {
		if (i_type == null) {
			throw new NullPointerException("i_type must not be null");
		}
		if (i_name == null) {
			throw new NullPointerException("i_name must not be null");
		}
		name = i_name;
		type = i_type;
		declaredType = i_declaredType;
		if (lowerBound < 0) {
			throw new IllegalArgumentException(
					"lower bound must not be less 0, was " + lowerBound);
		}
		if (upperBound >= 0 && upperBound < lowerBound) {
			throw new IllegalArgumentException("upper bound (" + upperBound
					+ ") must be greater or equal lower bound (" + lowerBound
					+ ")");
		}
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.unique = unique;
		this.ordered = ordered;
	}

	public abstract FeatureType getFeatureType();
	
	public abstract String getDescription();

	public abstract boolean isChangeable();

	public Type getType() {
		return type;
	}

	/**
	 * @return the ordered
	 */
	public boolean isOrdered() {
		return ordered;
	}

	/**
	 * @return the unique
	 */
	public boolean isUnique() {
		return unique;
	}

	public boolean isMany() {
		return upperBound > 1 || upperBound < 0;
	}

	/**
	 * @return the lowerBound
	 */
	public int getLowerBound() {
		return lowerBound;
	}

	/**
	 * @return the upperBound
	 */
	public int getUpperBound() {
		return upperBound;
	}

	public String boundToString() {
		if (upperBound == 1) {
			return "";
		}
		StringBuilder strb = new StringBuilder();
		strb.append("[");
		if (lowerBound != upperBound && (lowerBound != 0 || upperBound > 0)) {
			strb.append(lowerBound).append("..");
		}
		if (upperBound < 0) {
			strb.append("*");
		} else {
			strb.append(upperBound);
		}
		strb.append("]");
		return strb.toString();
	}

	/**
	 * @return
	 * @since Feb 5, 2012
	 */
	public String constraintsToString() {
		if (!isMany() && isChangeable()) {
			return "";
		}

		List<String> constraintStrings = new ArrayList<String>(3);
		if (!isChangeable()) {
			constraintStrings.add("readOnly");
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
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the declaredType
	 */
	public Type getDeclaredType() {
		return declaredType;
	}

	public boolean isField() {
		return false;
	}

	public boolean isMethod() {
		return false;
	}

	public boolean isnativeOperation() {
		return false;
	}

	/**
	 * Returns brief description including (simple) name, type, and constraints
	 * 
	 * @return
	 * @since Feb 5, 2012
	 */
	public String getBriefDescription() {
		StringBuilder res = new StringBuilder();
		res.append(getName());
		res.append(": ");
		res.append(getType().toString());
		String strConstraints = constraintsToString();
		if (!strConstraints.isEmpty()) {
			res.append(' ').append(strConstraints);
		}
		return res.toString();
	}

}
