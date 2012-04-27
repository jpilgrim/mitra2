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
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 */
public class UnmodifiableComposedCollection<CT extends Collection<E>, E> implements
		Collection<E> {

	protected final static String STD_ERR_MSG =
		"Composed collection is unmodifiable";

	protected final List<CT> 
		nestedCollections = new ArrayList<CT>();
	
	
	
	protected class ComposedIterator implements Iterator<E> {

		/**
		 * 
		 */
		Iterator<? extends Iterable<E>> iterableIter;
		Iterator<E> currentIter = null;
		
		
		

		/**
		 * @param i_unmodifiableCollection TODO
		 * 
		 */
		ComposedIterator() {
			iterableIter = nestedCollections.iterator();
			nextIter();
		}

		private void nextIter() {
			while (iterableIter.hasNext()) {
				currentIter = iterableIter.next().iterator();
				if (currentIter.hasNext()) return;
			}
			currentIter = null;
		}

		@Override
		public boolean hasNext() {
			return currentIter != null;
		}

		@Override
		public E next() {
			if (currentIter == null) {
				throw new NoSuchElementException();
			}
			E next = currentIter.next();
			if (!currentIter.hasNext()) {
				nextIter();
			}
			return next;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	/**
	 * 
	 */
	public UnmodifiableComposedCollection() {
	}
	

	public void nestCollection(CT i_nestedCollection) {
		nestedCollections.add(i_nestedCollection);
	}

	/**
	 * @see java.util.Collection#size()
	 * @since May 2, 2011
	 */
	@Override
	public int size() {
		int s = 0;
		for (CT nestedCollection : nestedCollections) {
			s += nestedCollection.size();
		}
		return s;
	}

	/**
	 * @see java.util.Collection#isEmpty()
	 * @since May 2, 2011
	 */
	@Override
	public boolean isEmpty() {
		for (CT nestedCollection : nestedCollections) {
			if (!nestedCollection.isEmpty()) return false;
		}
		return true;
	}

	/**
	 * @see java.util.Collection#contains(java.lang.Object)
	 * @since May 2, 2011
	 */
	@Override
	public boolean contains(Object i_o) {
		for (CT nestedCollection : nestedCollections) {
			if (nestedCollection.contains(i_o)) return true;
		}
		return false;
	}

	/**
	 * @see java.util.Collection#containsAll(java.util.Collection)
	 * @since May 2, 2011
	 */
	@Override
	public boolean containsAll(Collection<?> i_c) {
		boolean elementFound;
		for (Object obj : i_c) {
			elementFound = false;
			for (CT nestedCollection : nestedCollections) {
				if (nestedCollection.contains(obj)) {
					elementFound = true;
					break;
				}
			}
			if (! elementFound) return false;
		}
		return true;
	}

	/**
	 * @see java.util.Collection#iterator()
	 * @since May 2, 2011
	 */
	@SuppressWarnings({
		"unchecked", "rawtypes"
	})
	@Override
	public Iterator<E> iterator() {
		return new UnmodifiableComposedCollection.ComposedIterator();
	}

	/**
	 * @see java.util.Collection#toArray()
	 * @since May 2, 2011
	 */
	@Override
	public Object[] toArray() {
		Object[] array = new Object[size()];
		int i = 0;
		for (Object obj : this) {
			array[i] = obj;
			i++;
		}
		return array;
	}

	/**
	 * @see java.util.Collection#toArray(T[])
	 * @since May 2, 2011
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] io_a) {
		int size = size();
		T[] array =
			io_a.length >= size ? io_a : (T[]) java.lang.reflect.Array
				.newInstance(io_a.getClass().getComponentType(), size);
		int i = 0;
		for (E obj : this) {
			array[i] = (T) obj;
			i++;
		}
		return array;
	}

	/**
	 * @see java.util.Collection#add(java.lang.Object)
	 * @since May 2, 2011
	 */
	@Override
	public boolean add(E i_e) {
		throw new UnsupportedOperationException(STD_ERR_MSG);
	}

	/**
	 * @see java.util.Collection#remove(java.lang.Object)
	 * @since May 2, 2011
	 */
	@Override
	public boolean remove(Object i_o) {
		throw new UnsupportedOperationException(STD_ERR_MSG);
	}

	/**
	 * @see java.util.Collection#addAll(java.util.Collection)
	 * @since May 2, 2011
	 */
	@Override
	public boolean addAll(Collection<? extends E> i_c) {
		throw new UnsupportedOperationException(STD_ERR_MSG);
	}

	/**
	 * @see java.util.Collection#removeAll(java.util.Collection)
	 * @since May 2, 2011
	 */
	@Override
	public boolean removeAll(Collection<?> i_c) {
		throw new UnsupportedOperationException(STD_ERR_MSG);
	}

	/**
	 * @see java.util.Collection#retainAll(java.util.Collection)
	 * @since May 2, 2011
	 */
	@Override
	public boolean retainAll(Collection<?> i_c) {
		throw new UnsupportedOperationException(STD_ERR_MSG);
	}

	/**
	 * @see java.util.Collection#clear()
	 * @since May 2, 2011
	 */
	@Override
	public void clear() {
		throw new UnsupportedOperationException(STD_ERR_MSG);
	}

}
