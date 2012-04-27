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
import java.util.Iterator;
import java.util.List;

import de.jevopi.mitra2.metamodel.MObject;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 17, 2012
 */
public class MitraSequenceImpl extends MitraSequence {
	
	final List<MObject> mObjects;
	
	public MitraSequenceImpl() {
		mObjects = new ArrayList<MObject>();
	}
	
	public MitraSequenceImpl(MitraCollection from) {
		mObjects = new ArrayList<MObject>(from.size());
		addAll(from);
	}
	

	public MitraSequenceImpl(int i) {
		mObjects = new ArrayList<MObject>(i);
	}

	public MitraSequenceImpl(MObject i_receiver) {
		mObjects = new ArrayList<MObject>(1);
		mObjects.add(i_receiver);
	}
	
	@Override
	public boolean contains(MObject object) {
		return mObjects.contains(object);
	}

	@Override
	public MObject at(int index) {
		return mObjects.get(index);
	}

	@Override
	public int size() {
		return mObjects.size();
	}

	@Override
	public boolean add(int index, MObject mObject) {
		mObjects.add(index, mObject);
		return true;
	}

	@Override
	public void set(int index, MObject mObject) {
		mObjects.set(index, mObject);
	}

	@Override
	public void remove(int index) {
		mObjects.remove(index);
	}
	
	@Override
	public boolean remove(MObject mObject) {
		return mObjects.remove(mObject);
	}
	
	@Override
	public Iterator<MObject> iterator() {
		return mObjects.iterator();
	}

}
