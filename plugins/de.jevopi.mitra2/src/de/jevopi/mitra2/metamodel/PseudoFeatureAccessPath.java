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

import org.eclipse.emf.ecore.EObject;

import de.jevopi.mitra2.mitra.Type;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 1, 2012
 */
public class PseudoFeatureAccessPath<T> extends FeatureAccessPath<T> {

	private static final long serialVersionUID = 7804094297439806933L;

	Type receiverType;

	/**
	 * @param i_receiverType must not be null
	 */
	public PseudoFeatureAccessPath(Type i_receiverType) {
		/* i_receiverType must not be null */
		if (i_receiverType == null) {
			throw new NullPointerException(
				"Argument i_receiverType must not be null");
		}
		receiverType = i_receiverType;
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.FeatureAccessPath#getReceiverType()
	 * @since Feb 1, 2012
	 */
	@Override
	public Type getReceiverType() {
		return receiverType;
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.FeatureAccessPath#getLocation()
	 * @since Feb 1, 2012
	 */
	@Override
	public EObject getLocation() {
		return null;
	}

}
