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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import de.jevopi.mitra2.metamodel.MObject;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 17, 2012
 */
public class MitraOrderedSetImpl extends MitraOrderedSet {

	protected final Set<MObject> mObjectSet;
	protected final List<MObject> mObjectList;

	/**
	 * 
	 */
	public MitraOrderedSetImpl() {
		mObjectSet = new HashSet<MObject>();
		mObjectList = new ArrayList<MObject>();
	}

	public MitraOrderedSetImpl(MitraCollection from) {
		mObjectSet = new HashSet<MObject>();
		mObjectList = new ArrayList<MObject>();
		addAll(from);
	}

	public void addAll(MitraCollection from) {
		for (MObject mObject : from) {
			add(mObject);
		}
	}

	@Override
	public boolean contains(MObject mObject) {
		return mObjectSet.contains(mObject);
	}

	@Override
	public int size() {
		return mObjectSet.size();
	}

	@Override
	public boolean remove(MObject mObject) {
		if (mObjectSet.remove(mObject)) {
			return mObjectList.remove(mObject);
		}
		return false;
	}

	@Override
	public Iterator<MObject> iterator() {
		return mObjectList.iterator();
	}

	@Override
	public MObject at(int index) {
		return mObjectList.get(index);
	}

	@Override
	public int indexOf(MObject obj) {
		return mObjectList.indexOf(obj);
	}

	@Override
	public boolean add(int index, MObject mObject) {
		if (mObjectSet.add(mObject)) {
			try {
				mObjectList.add(index, mObject);
			} catch (RuntimeException ex) {
				mObjectSet.remove(mObject);
				throw ex;
			}
			return true;
		}
		return false;
	}

	@Override
	public void set(int index, MObject mObject) {
		MObject old = at(index);
		if (old.equals(mObject)) return;
		if (mObjectSet.add(mObject)) {
			try {
				mObjectList.set(index, mObject);
			} catch (RuntimeException ex) {
				mObjectSet.remove(mObject);
				throw ex;
			}
			mObjectSet.remove(old);
		}
	}

	@Override
	public void remove(int index) {
		remove(at(index));
	}

}
