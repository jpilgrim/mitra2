/*******************************************************************************
 * Copyright (c) 2012 Jens von Pilgrim
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 **************************************************************************** */

package de.jevopi.mitra2.formatting;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;

import de.jevopi.mitra2.services.MitraGrammarAccess;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an
 * example
 */
public class MitraFormatter extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {
		MitraGrammarAccess f = (MitraGrammarAccess) getGrammarAccess();

		// general settings for all language constructs:

		c.setLinewrap(0, 1, 2).before(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).before(f.getML_COMMENTRule());
		c.setLinewrap(0, 1, 2).after(f.getML_COMMENTRule());

		// find common keywords an specify formatting for them
		for (Pair<Keyword, Keyword> pair : f.findKeywordPairs("(", ")")) {
			if (pair.getFirst()!=f.getRuleDeclarationAccess().getLeftParenthesisKeyword_10_1())
				c.setNoSpace().before(pair.getFirst());
			c.setNoSpace().after(pair.getFirst());
			c.setNoSpace().before(pair.getSecond());
		}
		for (Keyword comma : f.findKeywords(";", ",", ":", "|")) {
			c.setNoSpace().before(comma);
		}
		for (Keyword comma : f.findKeywords("@", "$")) {
			c.setNoSpace().after(comma);
		}
		for (Keyword comma : f.findKeywords(".", "::", "->")) {
			c.setNoSpace().before(comma);
			c.setNoSpace().after(comma);
		}

		for (Keyword keyword : f.findKeywords( "trigger", 
				"overrides", "implements", "import", "annotation")) {
			c.setLinewrap().before(keyword);
		}
		
		for (Keyword keyword : f.findKeywords("{", "(")) {
			c.setIndentationIncrement().after(keyword);
		}
		for (Keyword keyword : f.findKeywords("}", ")")) {
			c.setIndentationDecrement().before(keyword);
		}
		

		// Annotation Declarations
		c.setLinewrap(2,2,2).before(f.getAnnotationDeclRule());
		c.setLinewrap().after(f.getAnnotationDeclAccess().getLeftCurlyBracketKeyword_3());
		c.setLinewrap().before(f.getAnnotationDeclAccess().getRightCurlyBracketKeyword_5());
		c.setLinewrap().before(f.getAnnotationPropertyDeclRule());
		
		
		// Module header
		// gap between package and module declaration, but no lines before module
		// when no package is defined:
		c.setLinewrap(2,2,2).between(f.getModuleAccess().getSemicolonKeyword_0_2(), f.getModuleAccess().getModuleKeyword_1());
		// always a gap after module
		c.setLinewrap(2).after(f.getModuleAccess().getSemicolonKeyword_3());
		
		// imports
		// gap between module declaration and import section
		c.setLinewrap(2,2,2).between(f.getModuleAccess().getSemicolonKeyword_3(), f.getModuleAccess().getImportKeyword_4_0());
		// no gap between imports
		c.setLinewrap(1,1,2).between(f.getModuleAccess().getSemicolonKeyword_4_2(), f.getModuleAccess().getImportKeyword_4_0());
				
		// metamodule
		// gap between module declaration and metamodel section
		c.setLinewrap(2,2,2).between(f.getModuleAccess().getSemicolonKeyword_3(), f.getMetamodelDeclarationRule());
		// gap between imports and metamodel section
		c.setLinewrap(2,2,2).between(f.getModuleAccess().getSemicolonKeyword_4_2(), f.getMetamodelDeclarationRule());
		// no gaps between metamodel declarations
		c.setLinewrap(1,1,2).between(f.getModuleAccess().getSemicolonKeyword_5_1(), f.getMetamodelDeclarationRule());
		
		// Rule header
		// gap before rule
		c.setLinewrap(2, 2, 3).before(f.getRuleDeclarationRule());
		c.setLinewrap().after(f.getRuleDeclarationRule());
		
		// return parameters in new line with indent
		c.setLinewrap(1,1,1).after(f.getRuleDeclarationAccess().getColonKeyword_10_0());
		c.setLinewrap(1,1,1).after(f.getRuleDeclarationAccess().getLeftParenthesisKeyword_10_1());
		c.setLinewrap().before(f.getRuleDeclarationAccess().getReturnParametersAssignment_10_2());
		c.setLinewrap().before(f.getRuleDeclarationAccess().getReturnParametersAssignment_10_3_1());
		
		c.setIndentationIncrement().before(f.getRuleDeclarationAccess().getLeftParenthesisKeyword_10_1());
		c.setIndentationDecrement().after(f.getRuleDeclarationAccess().getRightParenthesisKeyword_10_4());
		
		c.setLinewrap().before(f.getRuleDeclarationAccess().getBodyAssignment_15_2());
		c.setIndentationIncrement().after(f.getRuleDeclarationAccess().getNameAssignment_6());
		c.setIndentationDecrement().before(f.getRuleDeclarationAccess().getBodyAssignment_15_2());
		c.setIndentationIncrement().after(f.getRuleDeclarationAccess().getBodyAssignment_15_2());
		c.setIndentationDecrement().after(f.getRuleDeclarationRule());
		
		
		
		// override and implement in new lines with indent		
		c.setLinewrap().before(f.getRuleDeclarationAccess().getOverridesKeyword_12_0());
		c.setLinewrap().before(f.getRuleDeclarationAccess().getImplementsKeyword_11_0());
		c.setLinewrap().after(f.getRuleReferenceRule());
		c.setLinewrap().after(f.getSimpleRuleReferenceRule());
		bigIndentElement(c, f.getRuleReferenceRule());
		
		// Rule body
		c.setLinewrap().before(f.getBlockStatementRule());
		c.setLinewrap().after(f.getBlockStatementRule());
		
		
	}

	void bigIndentElement(FormattingConfig c, EObject e) {
		indentElement(c, e);
		indentElement(c, e);
	}

	void indentElement(FormattingConfig c, EObject e) {
		c.setIndentationIncrement().before(e);
		c.setIndentationDecrement().after(e);
	}

	void unIndentElement(FormattingConfig c, EObject e) {
		c.setIndentationDecrement().before(e);
		c.setIndentationIncrement().after(e);
	}

}
