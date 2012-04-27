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

import org.eclipse.emf.ecore.EObject;

import de.jevopi.mitra2.mitra.Expression;
import de.jevopi.mitra2.mitra.StaticAccess;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.VariableAccess;

/**
 * List of feature path items. This is quite similar to a {@link VariableAccess}
 * or {@link StaticAccess}, however instead of {@link Expression}, method calls
 * contains elements of type T. .
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @param <T> During editing, T is of type {@link Type}, during execution of
 *            type {@link MObject}
 * @since Jan 18, 2012
 */
public abstract class FeatureAccessPath<T> extends
		ArrayList<FeaturePathItem<T>> {

	private static final long serialVersionUID = -6025078473834801040L;

	/**
	 * 
	 */
	public FeatureAccessPath() {
		super(1);
	}

	/**
	 * Returns the type of the variable or the static type.
	 * 
	 * @return
	 */
	public abstract Type getReceiverType();

	/**
	 * Only for error messages in order to locate error in source code.
	 * 
	 * @return location, may be null
	 */
	public abstract EObject getLocation();
	
	/**
	 * Returns last feature path item or null, if path contains no items.
	 * @return
	 */
	public FeaturePathItem<T> last() {
		if (size()>0) return get(size()-1);
		return null;
	}

}
