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

import java.util.Iterator;
import java.util.List;

import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager;

/**
 * Sequence backed by a "real" collection, {@link MObject}s are created on the
 * fly.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 17, 2012
 */
public class DelegatingMitraSequence extends MitraSequence {

	final List<Object> raws;
	final MetamodelManager metamodelManager;
	
	/**
	 * @param raws
	 */
	@SuppressWarnings("unchecked")
	public DelegatingMitraSequence(@SuppressWarnings("rawtypes") List raws,
			MetamodelManager metamodelManager) {
		this.raws = raws;
		this.metamodelManager= metamodelManager;
	}
	
	@Override
	public boolean contains(MObject object) {
		return raws.contains(object.getValue());
	}

	@Override
	public MObject at(int index) {
		MObject mObject = metamodelManager.wrap(raws.get(index));
		return mObject;
	}
	
	@Override
	public int indexOf(MObject obj) {
		int index = 0;
		Object value = obj.getValue();
		for (Object element : raws) {
			if (element==value || element.equals(value)) return index;
			index++;
		}
		return -1;
	}

	@Override
	public int size() {
		return raws.size();
	}

	@Override
	public boolean add(int index, MObject mObject) {
		raws.add(index, mObject.getValue());
		return true;
	}

	@Override
	public void set(int index, MObject mObject) {
		raws.set(index, mObject.getValue());
	}

	@Override
	public void remove(int index) {
		raws.remove(index);
	}
	
	@Override
	public boolean remove(MObject mObject) {
		return raws.remove(mObject);
	}
	
	@Override
	public Iterator<MObject> iterator() {
		return new WrappingIterator(raws.iterator(), metamodelManager);
	}

}
