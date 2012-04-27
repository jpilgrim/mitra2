/*******************************************************************************
 * Copyright (c) 2012 Jens von Pilgrim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/
package de.jevopi.mitra2.validation;

import static de.jevopi.mitra2.message.ValidationMessageAcceptorAdapter.toStringArray;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.message.AbstractMessenger;
import de.jevopi.mitra2.message.IMessageAcceptor;
import de.jevopi.mitra2.message.IMessageAcceptor.Level;
import de.jevopi.mitra2.metamodel.MetamodelManager;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 9, 2012
 */
public abstract class AbstractValidator extends AbstractMessenger {

	protected ValidationMessageAcceptor acceptor;
	protected ProjectContext projectContext;

	/**
	 * @param projectContext
	 * @param acceptor
	 */
	public AbstractValidator(ProjectContext projectContext,
			ValidationMessageAcceptor acceptor) {
		this.projectContext = projectContext;
		this.acceptor = acceptor;
	}

	/**
	 * Convenience method, returns {@link ProjectContext#getMetamodelManager()
	 * project cointext's metamodel manager}.
	 */
	protected MetamodelManager getMetamodelManager() {
		return projectContext.getMetamodelManager();
	}
	
	@Override
	protected IMessageAcceptor getMessageAcceptor() {
		return projectContext.getMessageAcceptor();
	}

	@Override
	public void message(Level level, String message, EObject astElement,
			EStructuralFeature structuralFeature, int index, Throwable ex, String code, String... issueData) {
		super.message(level, message, astElement, structuralFeature, index, ex, code,
				issueData);
		if (acceptor != null) {
			switch (level) {
			case ERROR:
			case RUNTIME_ERROR:
				acceptor.acceptError(message, astElement, structuralFeature,index, code,
						toStringArray(issueData));
				break;
			case WARNING:
			case RUNTIME_WARNING:
				acceptor.acceptWarning(message, astElement, structuralFeature, index, code,
						toStringArray(issueData));
			}
		}
	}

}
