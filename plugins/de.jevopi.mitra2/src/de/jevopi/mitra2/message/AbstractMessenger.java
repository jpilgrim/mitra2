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

import static de.jevopi.mitra2.message.IMessageAcceptor.Level.DEBUG;
import static de.jevopi.mitra2.message.IMessageAcceptor.Level.ERROR;
import static de.jevopi.mitra2.message.IMessageAcceptor.Level.INFO;
import static de.jevopi.mitra2.message.IMessageAcceptor.Level.RUNTIME_ERROR;
import static de.jevopi.mitra2.message.IMessageAcceptor.Level.RUNTIME_WARNING;
import static de.jevopi.mitra2.message.IMessageAcceptor.Level.WARNING;

import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 10, 2012
 */
public abstract class AbstractMessenger implements IMessenger {

	/**
	 * Logger for this class
	 */
	// @SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger log = Logger.getLogger(AbstractMessenger.class
		.getName());

	protected abstract IMessageAcceptor getMessageAcceptor();

	public void message(IMessageAcceptor.Level level, String message,
			EObject astElement, EStructuralFeature structuralFeature,
			int index, Throwable ex, String code, String... issueData) {
		if (ex != null) {
			System.out.println("Stacktrace (AbstractMessenger)");
			ex.printStackTrace();
			System.out.println("end of Stacktrace (AbstractMessenger)");
		}
		try {
			getMessageAcceptor().message(level, message, astElement,
					structuralFeature, index, ex, code, issueData);
		} catch (Throwable t) {
			log.warning("Error writing message: " + String.valueOf(message)
				+ ". Error: " + t);
		}
	}

	@Override
	public final void error(String message, EObject astElement,
			EStructuralFeature structuralFeature, int index, Throwable ex,
			String code, String... issueData) {
		message(ERROR, message, astElement, structuralFeature, index, ex, code,
				issueData);
	}

	@Override
	public final void error(String message, EObject astElement,
			EStructuralFeature structuralFeature, int index, String code,
			String... issueData) {
		message(ERROR, message, astElement, structuralFeature, index, null,
				code, issueData);
	}

	@Override
	public final void error(String message, EObject astElement,
			EStructuralFeature structuralFeature, int index) {
		message(ERROR, message, astElement, structuralFeature, index, null,
				null);
	}

	@Override
	public void error(String message, EObject astElement) {
		message(ERROR, message, astElement, astElement.eContainingFeature(),
				-1, null, null);
	}

	@Override
	public void warning(String message, EObject astElement) {
		message(WARNING, message, astElement, astElement.eContainingFeature(),
				-1, null, null);
	}

	@Override
	public final void warning(String message, EObject astElement,
			EStructuralFeature structuralFeature, int index, Throwable ex,
			String code, String... issueData) {
		message(WARNING, message, astElement, structuralFeature, index, ex,
				code, issueData);
	}

	@Override
	public final void warning(String message, EObject astElement,
			EStructuralFeature structuralFeature, int index, String code) {
		message(WARNING, message, astElement, structuralFeature, index, null,
				code);
	}

	@Override
	public final void warning(String message, EObject astElement,
			EStructuralFeature structuralFeature, int index) {
		message(WARNING, message, astElement, structuralFeature, index, null,
				null);
	}

	@Override
	public final void info(String message, EObject astElement, Throwable ex) {
		message(INFO, message, astElement, null, -1, ex, null);
	}

	@Override
	public final void info(String message, EObject astElement) {
		message(INFO, message, astElement, null, -1, null, null);
	}

	@Override
	public final void info(String message) {
		message(INFO, message, null, null, -1, null, null);
	}

	@Override
	public final void debug(String message, EObject astElement) {
		message(DEBUG, message, astElement, null, -1, null, null);
	}

	@Override
	public final void debug(String message) {
		message(DEBUG, message, null, null, -1, null, null);
	}

	@Override
	public final void runtimeError(String message, EObject astElement,
			Throwable ex, String code, String... issueData) {
		message(RUNTIME_ERROR, message, astElement, null, -1, ex, code,
				issueData);
	}

	@Override
	public final void runtimeError(String message, EObject astElement,
			String code, String... issueData) {
		message(RUNTIME_ERROR, message, astElement, null, -1, null, code,
				issueData);
	}

	@Override
	public final void runtimeError(String message, EObject astElement,
			Throwable ex) {
		message(RUNTIME_ERROR, message, astElement, null, -1, ex, null);
	}

	@Override
	public final void runtimeError(String message, EObject astElement) {
		message(RUNTIME_ERROR, message, astElement, null, -1, null, null);
	}

	@Override
	public final void runtimeWarning(String message, EObject astElement,
			Throwable ex, String code, String... issueData) {
		message(RUNTIME_WARNING, message, astElement, null, -1, ex, code,
				issueData);
	}

	@Override
	public final void runtimeWarning(String message, EObject astElement,
			String code, String... issueData) {
		message(RUNTIME_WARNING, message, astElement, null, -1, null, code,
				issueData);
	}

	@Override
	public final void runtimeWarning(String message, EObject astElement) {
		message(RUNTIME_WARNING, message, astElement, null, -1, null, null);
	}

}
