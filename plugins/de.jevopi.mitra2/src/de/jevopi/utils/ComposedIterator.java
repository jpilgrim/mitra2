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
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator composed of other iterators. Note that the iterator can only be
 * visited once, and all nested iterators must not be used otherwise.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @param <E>
 */
public class ComposedIterator<E> implements Iterator<E> {
	
	

	Iterator<Iterator<E>> nestedIteratorIter = null;
	Iterator<E> currentIter = null;
	E nextElement = null;
	
	/**
	 * @param i_unmodifiableCollection TODO
	 * 
	 */
	public ComposedIterator(Collection<Iterator<E>> nestedIterators) {
		nestedIteratorIter = new ArrayList<Iterator<E>>(nestedIterators).iterator();
		if (nestedIteratorIter.hasNext()) {
			currentIter = nestedIteratorIter.next();
		}
		findNext();
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
		return currentIter!=null;
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
	public E next() {
		if (currentIter==null) {
			throw new NoSuchElementException();
		}
		E element = nextElement;
		findNext();
		return element;
	}

	protected void findNext() {
		while (currentIter != null) {
			if (currentIter.hasNext()) {
				nextElement = currentIter.next();
				return;
			} else {
				if (nestedIteratorIter.hasNext())
					currentIter = nestedIteratorIter.next();
				else
					currentIter = null;
			}
		}
	}

	/**
	 * @see java.util.Iterator#remove()
	 * @since Apr 1, 2011
	 */
	@Override
	public void remove() {
		currentIter.remove();
	}

}