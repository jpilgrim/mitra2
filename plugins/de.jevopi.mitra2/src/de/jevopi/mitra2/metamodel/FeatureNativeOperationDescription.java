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

import static de.jevopi.mitra2.metamodel.PrimitiveMetamodel.isVoid;
import de.jevopi.mitra2.mitra.Type;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 1, 2012
 */
public class FeatureNativeOperationDescription extends FeatureMethodDescription {
	
	Type iteratorLoopVarType;

	/**
	 * @param i_name
	 * @param i_type
	 * @param i_lowerBound
	 * @param i_upperBound
	 * @param i_parameterTypes
	 * @param i_declaredType
	 */
	public FeatureNativeOperationDescription(String i_name, Type i_type,
			int i_lowerBound, int i_upperBound, boolean unique,
			boolean ordered, Type[] i_parameterTypes, Type iteratorLoopVarType) {
		super(i_name, i_type, i_lowerBound, i_upperBound, unique, ordered,
				i_parameterTypes, null);
		this.iteratorLoopVarType = iteratorLoopVarType;
	}
	
	public boolean isIteratorExpression() {
		return ! isVoid(iteratorLoopVarType);
	}
	
	/** 
	 * @see de.jevopi.mitra2.metamodel.FeatureDescription#getFeatureType()
	 */
	@Override
	public FeatureType getFeatureType() {
		return FeatureType.NATIVE;
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.FeatureMethodDescription#isMethod()
	 * @since Feb 1, 2012
	 */
	@Override
	public boolean isMethod() {
		return false;
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.FeatureDescription#isnativeOperation()
	 * @since Feb 1, 2012
	 */
	@Override
	public boolean isnativeOperation() {
		return true;
	}

}
