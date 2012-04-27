package de.jevopi.mitra2.metamodel.mitracollections;

import java.util.Collection;
import java.util.Iterator;

import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager;

public class DelegatingMitraBag extends MitraBag {
	
	final Collection<Object> raws;
	final MetamodelManager metamodelManager;
	
	/**
	 * @param raws
	 */
	@SuppressWarnings("unchecked")
	public DelegatingMitraBag(@SuppressWarnings("rawtypes") Collection raws,
			MetamodelManager metamodelManager) {
		this.raws = raws;
		this.metamodelManager= metamodelManager;
	}
	
	@Override
	public boolean contains(MObject object) {
		return raws.contains(object.getValue());
	}

	@Override
	public int size() {
		return raws.size();
	}

	@Override
	public boolean add(MObject mObject) {
		return raws.add(mObject.getValue());
	}

	@Override
	public Iterator<MObject> iterator() {
		return new WrappingIterator(raws.iterator(), metamodelManager);
	}

	@Override
	public int count(MObject mObject) {
		Object value = mObject.getValue();
		int count=0;
		for (Object raw: raws) {
			// null is allowed
			if (raw==value || raw.equals(value)) count++;
		}
		return count;
	}

	@Override
	public boolean remove(MObject mObject) {
		Object value = mObject.getValue();
		
		for (Iterator<Object> iter=raws.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (element==value || element.equals(value)) {
				iter.remove();
				return true;
			}
		}
		
		return false;
	}


}
