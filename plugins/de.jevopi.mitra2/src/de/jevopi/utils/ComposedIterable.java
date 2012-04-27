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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 */
public class ComposedIterable<T> implements Iterable<T> {
	
	@SuppressWarnings("unchecked")
	public static <ET> ComposedIterable<? extends ET> compose(Iterable<? extends ET>... iterables) {
		return new ComposedIterable<ET>((Iterable<ET>[]) iterables);
	}
	
	
	final List<Iterable<T>> containedIterables = new ArrayList<Iterable<T>>();

	final class ComposedIterator implements Iterator<T> {

		Iterator<Iterable<T>> iterableIter;
		Iterator<T> currentIter = null;

		/**
		 * 
		 */
		public ComposedIterator() {
			iterableIter = containedIterables.iterator();
			nextIter();
		}
		
		/**
		 * 
		 * @since Apr 1, 2011
		 */
		private void nextIter() {
			while (iterableIter.hasNext()) {
				currentIter = iterableIter.next().iterator();
				if (currentIter.hasNext()) return;
			}
			currentIter = null;
		}

		/**
		 * {@inheritDoc}
		 * <p>
		 * </p>
		 * 
		 * @see java.util.Iterator#hasNext()
		 * @since Apr 1, 2011
		 */
		@Override
		public boolean hasNext() {
			return currentIter != null;
		}

		/**
		 * {@inheritDoc}
		 * <p>
		 * </p>
		 * 
		 * @see java.util.Iterator#next()
		 * @since Apr 1, 2011
		 */
		@Override
		public T next() {
			if (currentIter == null) {
				throw new NoSuchElementException();
			}
			T next = currentIter.next();
			if (!currentIter.hasNext()) {
				nextIter();
			}
			return next;
		}

		/**
		 * Not supported.
		 * 
		 * @see java.util.Iterator#remove()
		 * @since Apr 1, 2011
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	/**
	 * Empty constructor, nested iterables are to be added via
	 * {@link ComposedIterable#addIterable(Iterable)}.
	 */
	public ComposedIterable() {}

	/**
	 * 
	 */
	public ComposedIterable(Iterable<T>... iterables) {
		containedIterables.addAll(Arrays.asList(iterables));
	}

	/**
	 * Adds a new iterable to this composed iterable.
	 * 
	 * @param iterable must not be null
	 * @since Apr 1, 2011
	 */
	public void addIterable(Iterable<T> iterable) {
		/* iterable must not be null */
		if (iterable == null) {
			throw new NullPointerException("Argument iterable must not be null");
		}
		containedIterables.add(iterable);
	}

	/**
	 * Returns true if this iterable contains any nested iterables. This does
	 * not mean that it contains any elements, as all nested iterables may be
	 * empty.
	 * 
	 * @return
	 * @since Apr 3, 2011
	 */
	public boolean containsIterables() {
		return !containedIterables.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * </p>
	 * 
	 * @see java.lang.Iterable#iterator()
	 * @since Apr 1, 2011
	 */
	@Override
	public Iterator<T> iterator() {
		switch (containedIterables.size()) {
		case 0:
			return Iterators.emptyIterator();
		case 1:
			return containedIterables.get(0).iterator();
		default:
			return new ComposedIterator();
		} // end switch
	}
	
	public void clear() {
		containedIterables.clear();
	}

}
