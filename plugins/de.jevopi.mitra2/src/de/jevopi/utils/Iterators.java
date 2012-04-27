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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Utilities for iterators.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 */
public class Iterators {

	@SuppressWarnings("rawtypes")
	public final static Iterator<?> EMPTY_ITERATOR = new Iterator() {

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public Object next() {
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			throw new NoSuchElementException();
		}
	};
	
	

	/**
	 * Returns the number of elements traversed by the given iterator. Note that
	 * the iterator has no more elements after calling this method.
	 * 
	 * @param io_iter
	 * @return
	 */
	public static int count(Iterator<?> io_iter) {
		int c = 0;
		while (io_iter.hasNext()) {
			io_iter.next();
			c++;
		}
		return c;
	}

	/**
	 * Iterates over all elements and creates a list with these elements. Note
	 * that the iterator has no more elements after calling this method.
	 * 
	 * @param <T>
	 * @param io_iter
	 * @return
	 */
	public static <T> List<T> toList(Iterator<T> io_iter) {
		ArrayList<T> list = new ArrayList<T>();
		while (io_iter.hasNext()) {
			list.add(io_iter.next());
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public static <T> Iterator<T> emptyIterator() {
		return (Iterator<T>) EMPTY_ITERATOR;
	}

	/**
	 * Iterates over all elements and creates a set with these elements. Note
	 * that the iterator has no more elements after calling this method.
	 * 
	 * @param io_iter
	 * @return
	 */
	public static <T> Set<T> toSet(
			Iterator<T> io_iter) {
		Set<T> set = new HashSet<T>();
		while (io_iter.hasNext()) {
			set.add(io_iter.next());
		}
		return set;
	}
	
}
