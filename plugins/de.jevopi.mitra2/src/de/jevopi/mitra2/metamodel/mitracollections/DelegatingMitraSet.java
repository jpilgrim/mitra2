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
import java.util.Set;

import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 17, 2012
 */
public class DelegatingMitraSet extends MitraSet {
	
	final Set<Object> raws;
	final MetamodelManager metamodelManager;
	
	

	/**
	 * @param raws
	 * @param metamodelManager
	 */
	public DelegatingMitraSet(Set<Object> raws,
			MetamodelManager metamodelManager) {
		this.raws = raws;
		this.metamodelManager = metamodelManager;
	}

	/** 
	 * @param mObject
	 * @return
	 */
	@Override
	public boolean contains(MObject mObject) {
		return raws.contains(mObject.getValue());
	}

	/** 
	 * @return
	 */
	@Override
	public int size() {
		return raws.size();
	}

	/** 
	 * @return
	 */
	@Override
	public Iterator<MObject> iterator() {
		return new WrappingIterator(raws.iterator(), metamodelManager);
	}

	/** 
	 * @param mObject
	 * @return
	 */
	@Override
	public boolean add(MObject mObject) {
		return raws.add(mObject.getValue());
	}

	/** 
	 * @param mObject
	 * @return
	 */
	@Override
	public boolean remove(MObject mObject) {
		return raws.remove(mObject.getValue());
	}

}
