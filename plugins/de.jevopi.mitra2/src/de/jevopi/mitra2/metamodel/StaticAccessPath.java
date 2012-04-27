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

import de.jevopi.mitra2.mitra.StaticAccess;
import de.jevopi.mitra2.mitra.Type;

/**
 * Encapsulates a path to a class feature of a model actualtype. It contains the
 * actualtype and the static path, for more information see
 * {@link VariableAccessPath}.
 * 
 * @see VariableAccessPath
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @param <T> {@link Type} during editing, {@link MObject} during execution
 * @since Jan 18, 2012
 */
public class StaticAccessPath<T> extends FeatureAccessPath<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7707659562661717842L;

	protected StaticAccess staticAccess;

	protected Type receiverType;

	/**
	 * @param i_staticAccess
	 * @param i_receiverType must be null if staticAccess.type!=null and vice
	 *            versa
	 */
	public StaticAccessPath(StaticAccess i_staticAccess, Type i_receiverType) {
		/* i_staticAccess must not be null */
		if (i_staticAccess == null) {
			throw new NullPointerException(
					"Argument i_staticAccess must not be null");
		}
		staticAccess = i_staticAccess;
		if (i_receiverType == null) {
			receiverType = staticAccess.getType();
		} else {
			if (staticAccess.getType() != null) {
				throw new IllegalArgumentException(
						"Cannot set receiver type twice");
			}
			receiverType = i_receiverType;
		}
		if (receiverType == null) {
			throw new IllegalArgumentException("Receiver type not defined");
		}
	}

	/**
	 * @return the staticAccess
	 */
	public StaticAccess getStaticAccess() {
		return staticAccess;
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.FeatureAccessPath#getReceiverType()
	 */
	@Override
	public Type getReceiverType() {
		return receiverType;
	}

	/**
	 * @see de.feu.mitra.metamodel.FeatureAccessPath#getLocation()
	 */
	@Override
	public EObject getLocation() {
		return staticAccess;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder strb = new StringBuilder();

		if (staticAccess == null) {
			strb.append("'?");
		} else {
			strb.append(staticAccess.getType());
		}

		char sep = '#';

		for (FeaturePathItem<?> item : this) {
			if (item.getFeatureDescription().isnativeOperation()) {
				strb.append("->");
			} else { // field or method
				strb.append(sep);
			}
			sep = '.';
			strb.append(item.toString());
		}

		return strb.toString();

	}

}
