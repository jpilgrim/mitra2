package de.jevopi.xtext.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.inject.Inject;

public class XtextUtils {

	static XtextUtils INSTANCE = new XtextUtils();
	
	@Inject
	IXtextAdapter adapter = new XtextAdapter();
	
	private XtextUtils() {
	}
	
	
	public static int getStartLine(EObject eobj) {
		return INSTANCE.adapter.getStartLine(eobj);
	}
	
	public static int getEndLine(EObject eobj) {
		return INSTANCE.adapter.getEndLine(eobj);
	}
	
	
	public static String model2Text(EObject eobj) {
		return INSTANCE.adapter.model2Text(eobj);
	}
	
	public static CancelIndicator getCancelIndicator() {
		return INSTANCE.adapter.getCancelIndicator();
	}
}
