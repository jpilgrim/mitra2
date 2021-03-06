/*
* generated by Xtext
*/
package de.jevopi.mitra2.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import de.jevopi.mitra2.services.MitraGrammarAccess;

public class MitraParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private MitraGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected de.jevopi.mitra2.parser.antlr.internal.InternalMitraParser createParser(XtextTokenStream stream) {
		return new de.jevopi.mitra2.parser.antlr.internal.InternalMitraParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Module";
	}
	
	public MitraGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(MitraGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
