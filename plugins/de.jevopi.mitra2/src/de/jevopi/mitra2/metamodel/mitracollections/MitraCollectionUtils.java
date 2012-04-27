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

package de.jevopi.mitra2.metamodel.mitracollections;

import de.jevopi.mitra2.metamodel.MObject;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 6, 2012
 */
public class MitraCollectionUtils {

	/**
	 * Helper method for {@link MitraCollection#flatten()} implementations.
	 * 
	 * @param o_flatCopy
	 * @param original
	 * @since Feb 6, 2012
	 */
	public static void doFlatten(MitraCollection o_flatCopy, MitraCollection original) {
		for (MObject element : original) {
			if (element.getValue() instanceof MitraCollection) {
				doFlatten(o_flatCopy, (MitraCollection) element.getValue());
			} else {
				o_flatCopy.add(element);
			}
		}
	}
	


	public static String toString(MitraCollection collection) {
		StringBuilder strb = new StringBuilder("(");
		boolean first = true;
		for (MObject mObject : collection) {
			if (first)
				first = false;
			else
				strb.append(", ");
			strb.append(String.valueOf(mObject.getValue()));

		}
		strb.append(")");
		return strb.toString();
	}


}
