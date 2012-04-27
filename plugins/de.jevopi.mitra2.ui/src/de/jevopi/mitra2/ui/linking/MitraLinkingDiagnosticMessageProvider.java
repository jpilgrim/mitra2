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
package de.jevopi.mitra2.ui.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;

import de.jevopi.mitra2.mitra.RuleInvocation;
import de.jevopi.mitra2.mitra.util.MitraSwitch;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 16, 2012
 */
public class MitraLinkingDiagnosticMessageProvider extends
		LinkingDiagnosticMessageProvider {

	public final static String MISSING_RULE =
		"de.jevopi.mitra2.ui.linking.MISSING_RULE";
	public final static String MISSING_VARIABLE =
		"de.jevopi.mitra2.ui.linking.MISSING_VARIABLE";

	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(
			final ILinkingDiagnosticContext context) {

		EObject eObject = context.getContext();
		EReference eReference = context.getReference();
		String linkText = context.getLinkText();

		DiagnosticMessage diagnosticMessage =
			new MitraSwitch<DiagnosticMessage>() {
				@Override
				public DiagnosticMessage caseRuleInvocation(
						RuleInvocation ruleInvocation) {
					return new DiagnosticMessage("Missing rule "
							+ context.getLinkText(), Severity.ERROR,
							MISSING_RULE, context.getLinkText());
				};

				

				@Override
				public DiagnosticMessage caseVarDeclaration(
						de.jevopi.mitra2.mitra.VarDeclaration varDeclaration) {
					return new DiagnosticMessage("Missing variable "
						+ context.getLinkText(), Severity.ERROR,
						MISSING_VARIABLE, context.getLinkText());

				};

			}.doSwitch(context.getContext());
		return diagnosticMessage != null ? diagnosticMessage : super
			.getUnresolvedProxyMessage(context);
	}
}
