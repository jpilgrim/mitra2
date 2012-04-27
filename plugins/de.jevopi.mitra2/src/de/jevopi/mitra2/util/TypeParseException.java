/*******************************************************************************
 * Copyright (c) 2012 Jens von Pilgrim
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 **************************************************************************** */
package de.jevopi.mitra2.util;

/**
 * TypeParseException There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 */
public class TypeParseException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6887995999859337746L;

	/**
	 * @param s
	 */
	public TypeParseException(String s, String message) {
		super("Error parsing \"" + s + "\": " + message);
	}

}
