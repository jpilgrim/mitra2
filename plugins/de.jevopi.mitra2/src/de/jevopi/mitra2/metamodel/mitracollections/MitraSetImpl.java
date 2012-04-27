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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import de.jevopi.mitra2.metamodel.MObject;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 17, 2012
 */
public class MitraSetImpl extends MitraSet {

	protected final Set<MObject> mObjects;
	
	/**
	 * 
	 */
	public MitraSetImpl() {
		mObjects = new HashSet<MObject>();
	}
	
	public MitraSetImpl(MitraCollection from) {
		mObjects = new HashSet<MObject>();
		addAll(from);
	}
	

	public MitraSetImpl(MObject element) {
		mObjects = new HashSet<MObject>(1);
		mObjects.add(element);
	}

	public void addAll(MitraCollection from) {
		for (MObject fromElement: from) {
			mObjects.add(fromElement);
		}
	}

	@Override
	public boolean contains(MObject mObject) {
		return mObjects.contains(mObject);
	}

	@Override
	public int size() {
		return mObjects.size();
	}

	
	@Override
	public boolean add(MObject mObject) {
		return mObjects.add(mObject);

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
