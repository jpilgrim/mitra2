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
package de.jevopi.mitra2.metamodel;

import java.util.LinkedHashMap;
import java.util.Map;

import de.jevopi.mitra2.mitra.VarDeclaration;

/**
 * ReturnList There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 */
public class ReturnList extends LinkedHashMap<VarDeclaration, MObject> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4330524445744255514L;

	public static ReturnList VOIDLIST = new ReturnList() {

		/**
		 * 
		 */
		private static final long serialVersionUID = -7261844021718377655L;

		/**
		 * @see java.util.LinkedHashMap#clear()
		 */
		@Override
		public void clear() {
			throw new UnsupportedOperationException(
					"VOIDLIST must not be modified");
		}

		/**
		 * @see java.util.LinkedHashMap#removeEldestEntry(java.util.Map.Entry)
		 */
		@Override
		protected boolean removeEldestEntry(
				java.util.Map.Entry<VarDeclaration, MObject> i_eldest) {
			throw new UnsupportedOperationException(
					"VOIDLIST must not be modified");
		}

		/**
		 * @see java.util.HashMap#put(java.lang.Object, java.lang.Object)
		 */
		@Override
		public MObject put(VarDeclaration i_key, MObject i_value) {
			throw new UnsupportedOperationException(
					"VOIDLIST must not be modified");
		}

		/**
		 * @see java.util.HashMap#putAll(java.util.Map)
		 */
		@Override
		public void putAll(Map<? extends VarDeclaration, ? extends MObject> i_m) {
			throw new UnsupportedOperationException(
					"VOIDLIST must not be modified");
		}

		/**
		 * @see java.util.HashMap#remove(java.lang.Object)
		 */
		@Override
		public MObject remove(Object i_key) {
			throw new UnsupportedOperationException(
					"VOIDLIST must not be modified");
		}

	};

	/**
	 * 
	 */
	public ReturnList() {
		super();
	}

	/**
	 * @param i_initialCapacity
	 */
	public ReturnList(int i_initialCapacity) {
		super(i_initialCapacity);
	}

}
