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
package de.jevopi.utils;

import java.util.Set;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 */
public class UnmodifiableComposedSet<E> extends
		UnmodifiableComposedCollection<Set<E>, E> implements Set<E> {

	/**
	 * Adds given set to nested sets without checking for duplicates. This call
	 * is equivalent to {@link #nestCollection(Set, boolean) nestCollection(Set,
	 * true)}
	 * 
	 * @see de.feu.ps.refacola.api.util.UnmodifiableCollection#nestCollection(java.util.Collection)
	 * @since May 2, 2011
	 */
	@Override
	public void nestCollection(Set<E> i_nestedCollection) {
		nestCollection(i_nestedCollection, true);
	}

	public void nestCollection(Set<E> i_nestedCollection,
			boolean bSkipUniqueTest) {
		if (nestedCollections.contains(i_nestedCollection)) return;

		if (!bSkipUniqueTest) {
			for (E e : this) {
				if (i_nestedCollection.contains(e)) {
					throw new IllegalArgumentException("At least one element ("
						+ e + ") is already contained in another nested set.");
				}
			}
		}

		super.nestCollection(i_nestedCollection);

	}

}
