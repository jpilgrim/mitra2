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
public interface MitraCollection extends Iterable<MObject> {

	boolean isOrdered();

	boolean isUnique();
	
	boolean contains(MObject object);

	int count(MObject object);

	/**
	 * Creates a new collection (of same type as this collection) and appends
	 * the given object to this new collection. This side-effect free methods is
	 * similar to the OCL append method. If you want to append an element to
	 * this collection, use the Java collection method {@link #add(MObject)}.
	 * The new collection is usually created via {@link #clone()}, thus it is a
	 * shallow copy of this collection.
	 * 
	 * @param object
	 * @return
	 */
	MitraCollection appendToCopy(MObject object);

	/**
	 * Returns a new collection containing all elements contained by this
	 * collection. If this collection contains collections itself, the contained
	 * collections are flattened as well. That is, the resulting collection does
	 * not contain any collections, but all elements previously contained in all
	 * transitively contained collection.
	 * 
	 * @return flattened copy of this collection
	 */
	MitraCollection flatten();

	boolean isEmpty();

	int size();
	
	MitraCollection clone();
	
	/**
	 * @param mObject
	 * @return @return true if collection was modified
	 */
	boolean add(MObject mObject);
	
	/**
	 * Removes ONE occurrence of given object from the collection.
	 * @param mObject
	 * @return true if collection was modified
	 */
	boolean remove(MObject mObject);

}
