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
package de.jevopi.ecore.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * EMFUtil There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 */
public class EMFUtil {

	public static String toHRString(EObject eobj) {
		StringBuilder result = new StringBuilder();
		EStructuralFeature feature = eobj.eClass()
				.getEStructuralFeature("name");
		if (feature == null)
			feature = eobj.eClass().getEStructuralFeature("title");
		if (feature != null) {
			result.append(eobj.eGet(feature));
		} else {
			result.append("^");
			result.append(eobj.eClass().getName());

		}
		result.append('#');
		result.append(eobj.hashCode());
		return result.toString();
	}

}
