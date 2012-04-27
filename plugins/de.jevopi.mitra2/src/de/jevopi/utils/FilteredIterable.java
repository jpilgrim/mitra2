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

import java.util.Iterator;
import java.util.NoSuchElementException;

import de.jevopi.utils.Filter.FilterResult;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Jan 26, 2012
 */
public class FilteredIterable<T> implements Iterable<T> {

	/**
	 * @param <ET>
	 * @param from
	 * @param filter
	 * @return
	 */
	public static <ET> FilteredIterable<ET> select(Iterable<ET> from,
			Filter<ET> filter) {
		return new FilteredIterable<ET>(from, filter);
	}

	final Iterable<T> from;
	final Filter<T> filter;

	public class FilteredIterator implements Iterator<T> {

		Iterator<T> fromIterator;
		T next;
		boolean hasNext;

		public FilteredIterator(Iterator<T> i_fromIterator) {
			fromIterator = i_fromIterator;
			next = null;
			hasNext = true;
			findNext();
		}

		private void findNext() {
			if (fromIterator != null) {
				while (fromIterator.hasNext()) {
					next = fromIterator.next();
					switch (filter(next)) {
					case ACCEPT:
						return;
					case SKIP_AND_STOP:
						hasNext = false;
						fromIterator = null;
						return;
					case ACCEPT_AND_STOP:
						fromIterator = null;
						return;
					case SKIP:
					default:
						// continue with loop
					}
				}
			}
			hasNext = false;
		}

		@Override
		public boolean hasNext() {
			return hasNext;
		}

		/**
		 * @see java.util.Iterator#next()
		 */
		@Override
		public T next() {
			if (!hasNext) throw new NoSuchElementException();
			T returnedElement = next;
			findNext();
			return returnedElement;
		}

		/**
		 * @see java.util.Iterator#remove()
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	/**
	 * Use {@link FilteredIterable#select(Iterable, Filter)} to create a
	 * filtered iterable.
	 */
	protected FilteredIterable(Iterable<T> i_from, Filter<T> i_filter) {
		from = i_from;
		filter = i_filter;
	}

	/**
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<T> iterator() {
		return new FilteredIterator(from.iterator());
	}

	public FilterResult filter(T element) {
		return filter.apply(element);
	}

}
