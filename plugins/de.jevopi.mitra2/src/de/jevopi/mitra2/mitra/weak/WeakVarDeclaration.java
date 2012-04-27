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
import de.jevopi.mitra2.mitra.impl.VarDeclarationImpl;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 6, 2012
 */
public class WeakVarDeclaration extends VarDeclarationImpl  {

	/** 
	 * @see de.jevopi.mitra2.mitra.impl.VarDeclarationImpl#setType(de.jevopi.mitra2.mitra.Type)
	 * @since Feb 6, 2012
	 */
	@Override
	public void setType(Type newType) {
		Type oldType = type;
		type = newType;
		
		if (eNotificationRequired())
		      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.VAR_DECLARATION__TYPE, oldType, type));
	}
		
}
