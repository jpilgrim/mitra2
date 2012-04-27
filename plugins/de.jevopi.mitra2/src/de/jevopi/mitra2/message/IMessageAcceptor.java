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
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 10, 2012
 */
public interface IMessageAcceptor {

	public final static IMessageAcceptor EMPTY = new IMessageAcceptor() {

		@Override
		public void message(Level level, String message, EObject astElement,
				EStructuralFeature structuralFeature, int index, Throwable ex,
				String code, String... issueData) {}

	};

	public final static IMessageAcceptor JDK_LOGGING_ACCEPTOR =
		new JDKLoggingAcceptor();

	public enum Level {
		ERROR("Error", java.util.logging.Level.SEVERE), //
		RUNTIME_ERROR("Runtime error", java.util.logging.Level.SEVERE), //
		WARNING("Warning", java.util.logging.Level.WARNING), //
		RUNTIME_WARNING("Runtime warning", java.util.logging.Level.WARNING), //
		INFO("Info", java.util.logging.Level.INFO), //
		DEBUG("Debug", java.util.logging.Level.FINER); //

		private String message;
		private java.util.logging.Level jdkLevel;

		private Level(String message, java.util.logging.Level jdkLevel) {
			this.message = message;
			this.jdkLevel = jdkLevel;
		}

		public String message() {
			return message;
		}

		public java.util.logging.Level jdkLevel() {
			return jdkLevel;
		}

	}

	/**
	 * @param level also used for JDK logging
	 * @param message the message
	 * @param astElement location in the abstract syntax tree
	 * @param structuralFeature the structural feature, use either
	 *            {@link EObject#eContainmentFeature()} or the generated
	 *            EPackage.Literals class to retrieve feature
	 * @param index the index if the value is a list, -1 if all value are wrong.
	 *            Ignored if feature is not a collection.
	 * @param ex exception, use this only if a real "unknown" excpetion occured
	 *            as this is presented to the user, may be null
	 * @param code the error code, used for quickfixes, may be null
	 * @param issueData issue data, used for quickfixes or client code, details
	 *            depend on code, may be null
	 */
	void message(Level level, String message, EObject astElement,
			EStructuralFeature structuralFeature, int index, Throwable ex,
			String code, String... issueData);

}
