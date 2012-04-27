package de.jevopi.xtext.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Apr 3, 2012
 */
public interface IXtextAdapter {

	int getStartLine(EObject eobj);
	int getEndLine(EObject eobj);
	
	String model2Text(EObject eobj);
	CancelIndicator getCancelIndicator();
	
	
}
	
	
