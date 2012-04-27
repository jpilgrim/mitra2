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
package de.jevopi.mitra2;

import de.jevopi.mitra2.message.IMessageAcceptor;

/**
 * Exception to be thrown only to break longer method calls in case of an error.
 * The error description is to be handled by a {@link IMessageAcceptor message
 * acceptor} separately. In
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 10, 2012
 */
public final class MitraError extends Error {

	private static final long serialVersionUID = -2351429202241189081L;

	public static final String DEFAULT_MESSAGE =
		"Error details were sent to message acceptor, e.g., console.";

	public MitraError() {
		super(DEFAULT_MESSAGE);
	}

}
