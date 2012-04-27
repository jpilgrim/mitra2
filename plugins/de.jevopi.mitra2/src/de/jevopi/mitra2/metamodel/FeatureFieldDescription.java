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

import de.jevopi.mitra2.mitra.Type;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Jan 20, 2012
 */
public class FeatureFieldDescription extends FeatureDescription {
	/**
	 * @param i_name
	 * @param i_type
	 * @param i_declaredType
	 */
	public FeatureFieldDescription(String i_name, Type i_type, int lowerBound,
			int upperBound, boolean unique, boolean ordered,
			boolean changeable, Type i_declaredType) {
		super(i_name, i_type, lowerBound, upperBound, unique, ordered,
				i_declaredType);
		this.changeable = changeable;
	}

	protected boolean changeable;
	
	/** 
	 * @see de.jevopi.mitra2.metamodel.FeatureDescription#getFeatureType()
	 */
	@Override
	public FeatureType getFeatureType() {
		return FeatureType.FIELD;
	}

	/**
	 * Returns description string including type, fqn, bounds and constraints.
	 * 
	 * @return
	 */
	@Override
	public String getDescription() {
		StringBuilder res = new StringBuilder();
		res.append(getType().toString());
		res.append(" ").append(getDeclaredType().toString()).append(".")
				.append(getName());
		res.append(boundToString());
		String strConstraints = constraintsToString();
		if (!strConstraints.isEmpty()) {
			res.append(' ').append(strConstraints);
		}
		return res.toString();
	}

	/**
	 * @return the isChangeable
	 */
	@Override
	public boolean isChangeable() {
		return changeable;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getDescription();
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.FeatureDescription#isField()
	 * @since Feb 1, 2012
	 */
	@Override
	public boolean isField() {
		return true;
	}

}
