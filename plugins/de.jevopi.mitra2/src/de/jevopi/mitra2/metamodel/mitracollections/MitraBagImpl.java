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
public class MitraBagImpl extends MitraBag {
	
	final List<MObject> mObjects;
	
	public MitraBagImpl() {
		mObjects = new ArrayList<MObject>();
	}
	
	public MitraBagImpl(MitraBag from) {
		mObjects = new ArrayList<MObject>(from.size());
		addAll(from);
	}
	
	@Override
	public boolean contains(MObject object) {
		return mObjects.contains(object);
	}
	

	public void addAll(MitraBag from) {
		for (MObject fromElement: from) {
			mObjects.add(fromElement);
		}
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
		for (Iterator<MObject> iter=mObjects.iterator(); iter.hasNext();) {
			MObject element = iter.next();
			if (element.equals(mObject)) {
				iter.remove();
				return true; // remove only one occurrence
			}
		}
		return false;
	}
	
	@Override
	public Iterator<MObject> iterator() {
		return mObjects.iterator();
	}

	@Override
	public int count(MObject object) {
		int count=0;
		for (MObject mObject: mObjects) {
			if (mObject.equals(object)) count++;
		}
		return count;
	}

	

}
