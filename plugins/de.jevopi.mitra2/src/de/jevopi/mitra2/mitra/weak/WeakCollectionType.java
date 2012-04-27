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

package de.jevopi.mitra2.mitra.weak;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.impl.CollectionTypeImpl;

/**
 * Used for temporarily created collection type instances, e.g., during
 * resolving or evaluation. The field {@link #typePar} is not contained in this
 * variant, as it is in the default implementation {@link CollectionTypeImpl}.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 5, 2012
 */
public class WeakCollectionType extends CollectionTypeImpl  {

	/** 
	 * @see de.jevopi.mitra2.mitra.impl.CollectionTypeImpl#setTypePar(de.jevopi.mitra2.mitra.Type)
	 * @since Feb 6, 2012
	 */
	@Override
	public void setTypePar(Type newTypePar) {
		Type oldTypePar = typePar;
		typePar = newTypePar;
		if (eNotificationRequired())
		      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.COLLECTION_TYPE__TYPE_PAR, oldTypePar, typePar));
	}
	
}
