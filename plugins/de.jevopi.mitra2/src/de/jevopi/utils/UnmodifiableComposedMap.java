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
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 */
public class UnmodifiableComposedMap<K, V> implements Map<K, V> {

	protected final static String STD_ERR_MSG = "Composed map is unmodifiable";

	List<Map<K, V>> nestedMaps;

	/**
	 * 
	 */
	public UnmodifiableComposedMap() {
		nestedMaps = new ArrayList<Map<K, V>>();
	}
	
	public void nestMap(Map<K,V> nestedMap) {
		if (nestedMaps.contains(nestedMap))
			return;
		nestedMaps.add(nestedMap);
	}

	/**
	 * @see java.util.Map#size()
	 * @since May 2, 2011
	 */
	@Override
	public int size() {
		int s = 0;
		for (Map<K, V> nestedMap : nestedMaps) {
			s += nestedMap.size();
		}
		return s;
	}

	/**
	 * @see java.util.Map#isEmpty()
	 * @since May 2, 2011
	 */
	@Override
	public boolean isEmpty() {
		for (Map<K, V> nestedMap : nestedMaps) {
			if (!nestedMap.isEmpty()) return false;
		}
		;
		return true;
	}

	/**
	 * @see java.util.Map#containsKey(java.lang.Object)
	 * @since May 2, 2011
	 */
	@Override
	public boolean containsKey(Object i_key) {
		for (Map<K, V> nestedMap : nestedMaps) {
			if (!nestedMap.containsKey(i_key)) return true;
		}
		;
		return false;
	}

	/**
	 * @see java.util.Map#containsValue(java.lang.Object)
	 * @since May 2, 2011
	 */
	@Override
	public boolean containsValue(Object i_value) {
		for (Map<K, V> nestedMap : nestedMaps) {
			if (!nestedMap.containsValue(i_value)) return true;
		}
		;
		return false;
	}

	/**
	 * @see java.util.Map#get(java.lang.Object)
	 * @since May 2, 2011
	 */
	@Override
	public V get(Object i_key) {
		V value = null;
		for (Map<K, V> nestedMap : nestedMaps) {
			value = nestedMap.get(i_key);
			if (value != null) {
				break;
			}
		}
		;
		return value;
	}

	/**
	 * @see java.util.Map#keySet()
	 * @since May 2, 2011
	 */
	@Override
	public Set<K> keySet() {
		UnmodifiableComposedSet<K> keys = new UnmodifiableComposedSet<K>();
		for (Map<K, V> nestedMap : nestedMaps) {
			keys.nestCollection(nestedMap.keySet());
		}
		return keys;
	}

	/**
	 * @see java.util.Map#values()
	 * @since May 2, 2011
	 */
	@Override
	public Collection<V> values() {
		UnmodifiableComposedCollection<Collection<V>, V> values =
			new UnmodifiableComposedCollection<Collection<V>, V>();
		for (Map<K, V> nestedMap : nestedMaps) {
			values.nestCollection(nestedMap.values());
		}
		return values;
	}

	/**
	 * @see java.util.Map#entrySet()
	 * @since May 2, 2011
	 */
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		UnmodifiableComposedSet<java.util.Map.Entry<K, V>> entries = new UnmodifiableComposedSet<Map.Entry<K,V>>();
		for (Map<K, V> nestedMap : nestedMaps) {
			entries.nestCollection(nestedMap.entrySet());
		}
		return entries;
	}

	/**
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 * @since May 2, 2011
	 */
	@Override
	public V put(K i_key, V i_value) {
		throw new UnsupportedOperationException(STD_ERR_MSG);
	}

	/**
	 * @see java.util.Map#remove(java.lang.Object)
	 * @since May 2, 2011
	 */
	@Override
	public V remove(Object i_key) {
		throw new UnsupportedOperationException(STD_ERR_MSG);
	}

	/**
	 * @see java.util.Map#putAll(java.util.Map)
	 * @since May 2, 2011
	 */
	@Override
	public void putAll(Map<? extends K, ? extends V> i_m) {
		throw new UnsupportedOperationException(STD_ERR_MSG);
	}

	/**
	 * @see java.util.Map#clear()
	 * @since May 2, 2011
	 */
	@Override
	public void clear() {
		throw new UnsupportedOperationException(STD_ERR_MSG);
	}

}
