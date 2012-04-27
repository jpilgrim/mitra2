package de.jevopi.mitra2;

import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;

public class MitraQualifiedName extends QualifiedName {
	
	public final static MitraQualifiedName EMPTY = new MitraQualifiedName();

	protected final static IQualifiedNameConverter converter =
		new MitraQualifiedNameConverter();

	public MitraQualifiedName(String... segments) {
		super(segments);
	}

	@Override
	public String toString() {
		return getConverter().toString(this);
	}

	IQualifiedNameConverter getConverter() {
		return converter;
	}
	
	@Override
	public QualifiedName append(String segment) {
		String[] newSegments = new String[getSegmentCount() + 1];
		getSegments().toArray(newSegments);
		newSegments[newSegments.length-1] = segment;
		return new MitraQualifiedName(newSegments);
	}
	

}
