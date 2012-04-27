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
public abstract class MitraBag implements MitraCollection {

	private static final long serialVersionUID = 4207432872951780452L;

	/**
	 * @see de.jevopi.mitra2.metamodel.mitracollections.MitraCollection#isOrdered()
	 * @since Feb 6, 2012
	 */
	@Override
	public boolean isOrdered() {
		return false;
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.mitracollections.MitraCollection#isUnique()
	 * @since Feb 6, 2012
	 */
	@Override
	public boolean isUnique() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	

	/**
	 * @see de.jevopi.mitra2.metamodel.mitracollections.MitraCollection#appendToCopy(de.jevopi.mitra2.metamodel.MObject)
	 */
	@Override
	public MitraBag appendToCopy(MObject object) {
		MitraBag copy = (MitraBag) clone();
		copy.add(object);
		return copy;
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.mitracollections.MitraCollection#flatten()
	 */
	@Override
	public MitraBag flatten() {
		MitraBag flatCopy = new MitraBagImpl();
		MitraCollectionUtils.doFlatten(flatCopy, this);
		return flatCopy;
	}

	@Override
	public MitraBag clone() {
		return new MitraBagImpl(this);
	}
	
	@Override
	public String toString() {
		return MitraCollectionUtils.toString(this);
	}
}
