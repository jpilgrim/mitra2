/*******************************************************************************
 * Copyright (c) 2012 Jens von Pilgrim
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package de.jevopi.mitra2.message;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Convenience interface, not really used by clients, but instead used to
 * indicate classes using a {@link IMessageAcceptor message acceptor} for
 * providing error information.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 10, 2012
 */
public interface IMessenger {

	public void error(String message, EObject astElement, EStructuralFeature structuralFeature, int index, 
			Throwable ex, String code, String... issueData);

	public void error(String message, EObject astElement, EStructuralFeature structuralFeature, int index,
			String code, String... issueData);

	public void error(String message, EObject astElement, EStructuralFeature structuralFeature, int index);

	public void error(String message, EObject astElement);
	
	public void warning(String message, EObject astElement, EStructuralFeature structuralFeature, int index,
			Throwable ex, String code, String... issueData);

	public void warning(String message, EObject astElement, EStructuralFeature structuralFeature, int index,
			String code);

	public void warning(String message, EObject astElement, EStructuralFeature structuralFeature, int index);
	
	public void warning(String message, EObject astElement);

	public void info(String message, EObject astElement, Throwable ex);

	public void info(String message, EObject astElement);

	public void info(String message);

	public void debug(String message, EObject astElement);

	public void debug(String message);

	public void runtimeError(String message, EObject astElement, Throwable ex,
			String code, String... issueData);

	public void runtimeError(String message, EObject astElement, String code,
			String... issueData);

	public void runtimeError(String message, EObject astElement,
			Throwable ex);

	public void runtimeError(String message, EObject astElement);

	public void runtimeWarning(String message, EObject astElement,
			Throwable ex, String code, String... issueData);

	public void runtimeWarning(String message, EObject astElement, String code,
			String... issueData);

	public void runtimeWarning(String message, EObject astElement);

}
