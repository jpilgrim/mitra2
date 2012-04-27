package de.jevopi.mitra2;

import java.util.regex.Pattern;

import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;

public class MitraQualifiedNameConverter extends
		IQualifiedNameConverter.DefaultImpl {

	public final String DELIMITER = ":";

	/**
	 * @param delimiter
	 */
	public MitraQualifiedNameConverter() {}

	@Override
	public String getDelimiter() {
		return DELIMITER;
	}
	
	/** 
	 * Overridden to create a {@link MitraQualifiedName}.
	 * @param qualifiedNameAsString
	 * @return
	 */
	@Override
	public QualifiedName toQualifiedName(String qualifiedNameAsString) {
		if (qualifiedNameAsString == null)
			throw new IllegalArgumentException("Qualified name cannot be null");
		if (qualifiedNameAsString.equals(""))
			throw new IllegalArgumentException("Qualified name cannot be empty");
		if (Strings.isEmpty(getDelimiter()))
			return new MitraQualifiedName(qualifiedNameAsString);
		String[] segments = qualifiedNameAsString.split(Pattern.quote(getDelimiter()));
		return new MitraQualifiedName(segments);
	}

}
