/*
* generated by Xtext
*/
package de.jevopi.mitra2.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class MitraAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("de/jevopi/mitra2/parser/antlr/internal/InternalMitraParser.tokens");
	}
}
