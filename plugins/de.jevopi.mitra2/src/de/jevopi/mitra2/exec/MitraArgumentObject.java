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

package de.jevopi.mitra2.exec;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 8, 2012
 */
public class MitraArgumentObject extends MitraArgument {
	
	Object rawValue;
	
	
	

	/**
	 * @param i_name
	 * @param i_rawValue
	 */
	public MitraArgumentObject(String i_name, Object i_rawValue) {
		super(i_name);
		rawValue = i_rawValue;
	}


	/** 
	 * {@inheritDoc}
	 * @see de.jevopi.mitra2.exec.MitraArgument#getRawValue()
	 */
	@Override
	public Object getRawValue() {
		return rawValue;
	}

}
