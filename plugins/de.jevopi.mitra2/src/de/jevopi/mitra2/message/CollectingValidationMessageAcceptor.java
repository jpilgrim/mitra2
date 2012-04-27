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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Jan 27, 2012
 */
public class CollectingValidationMessageAcceptor implements
		ValidationMessageAcceptor {

	public enum ValidationPriority {
		error, warning, info
	}

	public static class ValidationMessage {
		ValidationPriority priority;

		String message;

		EObject object;

		EStructuralFeature structuralFeature;

		int index;

		String code;

		String[] issueData;

		/**
		 * @param i_priority
		 * @param i_message
		 * @param i_object
		 * @param i_feature
		 * @param i_code
		 * @param i_issueData
		 */
		public ValidationMessage(ValidationPriority i_priority,
				String i_message, EObject i_object,
				EStructuralFeature structuralFeature, int index, String i_code,
				String[] i_issueData) {
			priority = i_priority;
			message = i_message;
			object = i_object;
			this.structuralFeature = structuralFeature;
			this.index = index;
			code = i_code;
			issueData = i_issueData;
		}
	}

	List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

	List<ValidationMessage> warnings = new ArrayList<ValidationMessage>();

	List<ValidationMessage> infos = new ArrayList<ValidationMessage>();

	/**
	 * @see org.eclipse.xtext.validation.ValidationMessageAcceptor#acceptError(java.lang.String,
	 *      org.eclipse.emf.ecore.EObject, java.lang.Integer, java.lang.String,
	 *      java.lang.String[])
	 */
	@Override
	public void acceptError(String message, EObject object,
			EStructuralFeature structuralFeature, int index, String code,
			String... issueData) {
		addMessage(ValidationPriority.error, message, object,
				structuralFeature, index, code, issueData);
	}

	/**
	 * @see org.eclipse.xtext.validation.ValidationMessageAcceptor#acceptWarning(java.lang.String,
	 *      org.eclipse.emf.ecore.EObject, java.lang.Integer, java.lang.String,
	 *      java.lang.String[])
	 */
	@Override
	public void acceptWarning(String message, EObject object,
			EStructuralFeature structuralFeature, int index, String code,
			String... issueData) {
		addMessage(ValidationPriority.warning, message, object,
				structuralFeature, index, code, issueData);
	}

	@Override
	public void acceptInfo(String message, EObject object,
			EStructuralFeature structuralFeature, int index, String code,
			String... issueData) {
		addMessage(ValidationPriority.info, message, object, structuralFeature,
				index, code, issueData);
	}

	@Override
	public void acceptError(String message, EObject object, int offset,
			int length, String code, String... issueData) {
		addMessage(ValidationPriority.error, message, object, null, -1, code,
				issueData);
	}

	@Override
	public void acceptWarning(String message, EObject object, int offset,
			int length, String code, String... issueData) {
		addMessage(ValidationPriority.warning, message, object, null, -1, code,
				issueData);
	}

	@Override
	public void acceptInfo(String message, EObject object, int offset,
			int length, String code, String... issueData) {
		addMessage(ValidationPriority.info, message, object, null, -1, code,
				issueData);
	}

	private void addMessage(ValidationPriority priority, String i_message,
			EObject i_object, EStructuralFeature structuralFeature, int index,
			String i_code, String[] i_issueData) {
		messages(priority).add(
				new ValidationMessage(priority, i_message, i_object,
					structuralFeature, index, i_code, i_issueData));
	}

	List<ValidationMessage> messages(ValidationPriority priority) {
		switch (priority) {
		case error:
			return errors;
		case warning:
			return warnings;
		case info:
		default:
			return infos;
		}
	}

}
