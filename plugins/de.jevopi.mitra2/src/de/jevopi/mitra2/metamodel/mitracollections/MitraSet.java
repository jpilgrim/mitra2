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
 * @since Feb 1, 2012
 */
public abstract class MitraSet implements MitraUniqueCollection {

	@Override
	public abstract boolean add(MObject mObject);

	public abstract boolean remove(MObject mObject);

	@Override
	public boolean isOrdered() {
		return false;
	}

	@Override
	public boolean isUnique() {
		return true;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int count(MObject i_object) {
		return contains(i_object) ? 1 : 0;
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.mitracollections.MitraCollection#appendToCopy(de.jevopi.mitra2.metamodel.MObject)
	 */
	@Override
	public MitraSet appendToCopy(MObject object) {
		MitraSet copy = (MitraSet) clone();
		copy.add(object);
		return copy;
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.mitracollections.MitraCollection#flatten()
	 */
	@Override
	public MitraSet flatten() {
		MitraSet flatCopy = new MitraSetImpl();
		MitraCollectionUtils.doFlatten(flatCopy, this);
		return flatCopy;
	}

	@Override
	public MitraSet clone() {
		return new MitraSetImpl(this);
	}

	@Override
	public String toString() {
		return MitraCollectionUtils.toString(this);
	}
}
