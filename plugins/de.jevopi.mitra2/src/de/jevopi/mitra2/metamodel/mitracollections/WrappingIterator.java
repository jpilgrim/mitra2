package de.jevopi.mitra2.metamodel.mitracollections;

import java.util.Iterator;

import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager;

public class WrappingIterator implements Iterator<MObject> {

	Iterator<Object> rawIterator;
	MetamodelManager metamodelManager;

	public WrappingIterator(Iterator<Object> rawIterator,
			MetamodelManager metamodelManager) {
		/* rawIterator must not be null */
		if (rawIterator == null) {
			throw new NullPointerException(
				"Argument rawIterator must not be null");
		}
		/* metamodelManager must not be null */
		if (metamodelManager == null) {
			throw new NullPointerException(
				"Argument metamodelManager must not be null");
		}
		this.rawIterator = rawIterator;
		this.metamodelManager = metamodelManager;
	}

	@Override
	public boolean hasNext() {
		return rawIterator.hasNext();
	}

	@Override
	public MObject next() {
		return metamodelManager.wrap(rawIterator.next());
	}

	@Override
	public void remove() {
		rawIterator.remove();
	}

}
