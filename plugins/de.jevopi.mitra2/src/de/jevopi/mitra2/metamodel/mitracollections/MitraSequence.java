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
public abstract class MitraSequence implements MitraOrderedCollection {


	public abstract boolean add(int index, MObject mObject);

	public abstract void set(int index, MObject mObject);

	public abstract void remove(int index);


	public MitraSequence() {}

	@Override
	public boolean isOrdered() {
		return true;
	}

	@Override
	public boolean isUnique() {
		return false;
	}
	
	@Override
	public boolean isEmpty() {
		return size()==0;
	}

	/**
	 * Iterates through the collection, rather expensive!
	 * 
	 * @see de.jevopi.mitra2.metamodel.mitracollections.MitraCollection#count(de.jevopi.mitra2.metamodel.MObject)
	 */
	@Override
	public int count(MObject i_object) {
		int count = 0;
		for (MObject element : this) {
			if (element.equals(i_object)) count++;
		}
		return count;
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
	public boolean add(MObject mObject) {
		return add(size(), mObject);
	}

	public void addAll(MitraCollection from) {
		for (MObject fromElement : from) {
			add(fromElement);
		}
	}

	@Override
	public int indexOf(MObject mObject) {
		int index = 0;
		for (MObject element : this) {
			if (element.equals(mObject)) return index;
			index++;
		}
		return -1;
	}

	
	/**
	 * @see de.jevopi.mitra2.metamodel.mitracollections.MitraCollection#appendToCopy(de.jevopi.mitra2.metamodel.MObject)
	 */
	@Override
	public MitraSequence appendToCopy(MObject obj) {
		MitraSequence copy = clone();
		copy.add(obj);
		return copy;
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.mitracollections.MitraOrderedCollection#insertAtCopy(int,
	 *      de.jevopi.mitra2.metamodel.MObject)
	 * @since Feb 6, 2012
	 */
	@Override
	public MitraOrderedCollection insertAtCopy(int index, MObject obj) {
		if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
		MitraSequence copy = (MitraSequence) clone();
		copy.add(index, obj);
		return copy;
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.mitracollections.MitraCollection#flatten()
	 */
	@Override
	public MitraSequence flatten() {
		MitraSequence flatCopy = new MitraSequenceImpl();
		MitraCollectionUtils.doFlatten(flatCopy, this);
		return flatCopy;
	}

	@Override
	public MitraSequence clone() {
		return new MitraSequenceImpl(this);
	}
	
	@Override
	public String toString() {
		return MitraCollectionUtils.toString(this);
	}
}
