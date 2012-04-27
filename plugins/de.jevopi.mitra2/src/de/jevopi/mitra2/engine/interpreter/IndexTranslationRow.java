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
package de.jevopi.mitra2.engine.interpreter;

/**
 * List of integer pairs, that is this class is very similar to a list declared
 * as <code>List&lt;int[2]></code>. These integer pairs can be indexes of two
 * lists or arrays.
 * <p>
 * This table is used by {@link TriggerMatcher} in order to map the parameters
 * of a rule reference to the reference parameter values.
 * </p>
 * 
 * @author Jens von Pilgrim
 * @since Jan 7, 2009
 */
public class IndexTranslationRow {

	private int[] pairs;

	private int size2 = 0;

	/**
	 * Creates a new table with an initial capacity of 10.
	 */
	public IndexTranslationRow() {
		pairs = new int[20]; // 10 pairs
	}

	/**
	 * Creates a new table with the given initial capacity.
	 * 
	 * @param initialCapacity the initial capacity.
	 */
	public IndexTranslationRow(int initialCapacity) {
		pairs = new int[initialCapacity * 2];
	}

	/**
	 * Adds a new index pair.
	 * 
	 * @param fromIndex
	 * @param toIndex
	 */
	public void put(int fromIndex, int toIndex) {
		if (size2 == pairs.length) {
			int[] newPairs = new int[pairs.length * 2];
			System.arraycopy(pairs, 0, newPairs, 0, pairs.length);
			pairs = newPairs;
		}
		pairs[size2] = fromIndex;
		pairs[size2 + 1] = toIndex;
		size2 += 2;
	}

	/**
	 * Seals this mapper, i.e. the internal array used for storing the index
	 * pairs is resized to required size.
	 */
	public void seal() {
		if (size2 != pairs.length) {
			int[] newPairs = new int[size2];
			System.arraycopy(pairs, 0, newPairs, 0, size2);
			pairs = newPairs;
		}
	}

	/**
	 * Returns the from index at given index.
	 * 
	 * @param index
	 * @return
	 */
	public int getFromIndex(int index) {
		int index2 = index * 2;
		if (index2 >= size2) {
			throw new IndexOutOfBoundsException(index + ">=" + size());
		}
		return pairs[index2];
	}

	/**
	 * Returns the to index at given index.
	 * 
	 * @param index
	 * @return
	 */
	public int getToIndex(int index) {
		int index2 = index * 2;
		if (index2 >= size2) {
			throw new IndexOutOfBoundsException(index + ">=" + size());
		}
		return pairs[index2 + 1];
	}

	/**
	 * Returns the number of pairs in this mapper.
	 * 
	 * @return
	 */
	public int size() {
		return size2 / 2;
	}

	/**
	 * Returns the capacity of this mapper, i.e. the internal used size. If the
	 * mapper is sealed, the capacity equals the actual size.
	 * <p>
	 * Used for testing purposes.
	 * </p>
	 * 
	 * @return
	 */
	protected int capacity() {
		return pairs.length / 2;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer strb = new StringBuffer();
		strb.append("(");
		for (int i = 0; i < size(); i++) {
			if (i > 0) {
				strb.append(", ");
			}
			strb.append(getFromIndex(i));
			strb.append("->");
			strb.append(getToIndex(i));
		}
		strb.append(")");
		return strb.toString();
	}

}
