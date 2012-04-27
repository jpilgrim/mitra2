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

import java.util.List;

import de.jevopi.mitra2.metamodel.MObject;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 6, 2012
 */
public interface MitraOrderedCollection extends MitraCollection {

	MObject at(int index);

	int indexOf(MObject obj);

	MObject first();

	MObject last();

	/**
	 * Creates a copy if this collection and inserts the given object at the
	 * specified index. This side-effect free method is similar to the OCL
	 * insertAt method. The copy is created via {@link #clone()}, thus it is a
	 * shallow copy.
	 * <p>
	 * Note that not all subclasses provide Java {@link List#add(int, Object)}
	 * methods!
	 * 
	 * @param index
	 * @param obj
	 * @return
	 */
	MitraOrderedCollection insertAtCopy(int index, MObject obj);

}
