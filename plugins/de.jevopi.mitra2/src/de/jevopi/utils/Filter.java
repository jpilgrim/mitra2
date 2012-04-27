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

package de.jevopi.utils;

public interface Filter<T> {
	
	public static enum FilterResult {
		ACCEPT, SKIP, ACCEPT_AND_STOP, SKIP_AND_STOP;

		public static FilterResult
				accept(boolean equals) {
			return equals ? ACCEPT : SKIP;
		}
	}
	
	public FilterResult apply(T t);	
}