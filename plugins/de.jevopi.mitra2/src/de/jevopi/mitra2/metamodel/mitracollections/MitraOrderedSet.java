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

import java.util.NoSuchElementException;

import de.jevopi.mitra2.metamodel.MObject;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 1, 2012
 */
public abstract class MitraOrderedSet  implements
		MitraOrderedCollection, MitraUniqueCollection {

	public abstract boolean remove(MObject mObject);
	
	public abstract boolean add(int index, MObject mObject);

	public abstract void set(int index, MObject mObject);

	public abstract void remove(int index);
	
	
	@Override
	public boolean isOrdered() {
		return true;
	}

	@Override
	public boolean isUnique() {
		return true;
	}
	
	@Override
	public boolean isEmpty() {
		return size()==0;
	}
	
	@Override
	public boolean add(MObject mObject) {
		return add(size(), mObject);
	}

	@Override
	public int count(MObject i_object) {
		return contains(i_object) ? 1 : 0;
	}
	
	@Override
	public boolean contains(MObject mObject) {
		return indexOf(mObject)>=0;
	}
	

	@Override
	public MObject first() {
		if (size() > 0) return at(0);
		throw new NoSuchElementException();
	}

	@Override
	public MObject last() {
		if (size() > 0) return at(size() - 1);
		throw new NoSuchElementException();
	}

	@Override
	public MitraOrderedCollection insertAtCopy(int index, MObject obj) {
		// TODO Implement method MitraOrderedCollection#insertAtCopy
		return null;
	}

	@Override
	public MitraCollection appendToCopy(MObject object) {
		MitraOrderedSet copy = clone();
		copy.add(object);
		return copy;
	}

	@Override
	public MitraCollection flatten() {
		MitraOrderedSet flatCopy = new MitraOrderedSetImpl();
		MitraCollectionUtils.doFlatten(flatCopy, this);
		return flatCopy;
	}

	

	
	@Override
	public MitraOrderedSet clone() {
		MitraOrderedSet copy = new MitraOrderedSetImpl(this);
		return copy;
	}

	@Override
	public String toString() {
		return MitraCollectionUtils.toString(this);
	}
	
}
