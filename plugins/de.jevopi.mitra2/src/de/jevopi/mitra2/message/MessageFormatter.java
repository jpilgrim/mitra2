package de.jevopi.mitra2.message;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.message.IMessageAcceptor.Level;
import de.jevopi.mitra2.mitra.Module;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.xtext.utils.XtextUtils;

public class MessageFormatter {

	public String format(Level level, String message, EObject ASTElement,
			EStructuralFeature structuralFeature, int index, Throwable ex, String code) {

		StringBuilder strb = new StringBuilder();
		strb.append(level.message());

		if (message != null && !message.isEmpty()) {
			strb.append(": ");
			strb.append(message);
		} else if (ex != null) {
			strb.append(": ");
			String s = ex.getMessage();
			if (s != null && !s.isEmpty()) {
				strb.append(s);
			} else {
				strb.append(ex);
			}
			ex.printStackTrace();

		}
		strb.append(" ");
		strb.append(stackTraceLikeLocation(ASTElement));
		return strb.toString();
	}

	public static String stackTraceLikeLocation(EObject semanticElement) {
		StringBuilder strb = new StringBuilder();

		try {
			Module module = MitraUtils.retrieveModule(semanticElement);

			if (module != null) {
				strb.append("at ");
				if (module.getPackageName() != null) {
					strb.append(module.getPackageName()).append(':');
				}
				strb.append(module.getName());
			}
			RuleDeclaration rule =
				MitraUtils.retrieveContainingRule(semanticElement);
			if (rule != null) {
				strb.append(':');
				strb.append(rule.getName());
			}
			strb.append(simpleLocationInParentheses(semanticElement));
		} catch (Exception ex) {
			strb.append("#").append(ex.getMessage()).append('#');
		}
		return strb.toString();
	}

	public static String simpleLocationInParentheses(EObject semanticElement) {
		if (semanticElement == null) return "";
		if (semanticElement.eResource() == null) return "(Unknown Source)";

		StringBuilder strb = new StringBuilder();
		strb.append("(");
		try {
			Resource res = semanticElement.eResource();
			URI uri = res.getURI();
			if (uri!=null) {
				strb.append(uri.lastSegment());
			}

			int lineNumber = XtextUtils.getStartLine(semanticElement);
			if (lineNumber>0) {
				strb.append(":");
				strb.append(lineNumber);
			}

		} catch (Exception ex) {
			strb.append("#").append(ex.getMessage()).append('#');
		}
		strb.append(")");
		return strb.toString();
	}

}
