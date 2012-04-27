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

import java.util.List;
import java.util.Map;

import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.engine.VariableScopeHelper;
import de.jevopi.mitra2.mitra.LocalVariableDeclaration;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.VarDeclaration;
import de.jevopi.mitra2.mitra.VariableAccess;
import de.jevopi.mitra2.visitors.Collector;

/**
 * FlowValidator
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 7, 2012
 */
public class FlowValidator extends AbstractValidator {

	

	public FlowValidator(ProjectContext projectContext,
			ValidationMessageAcceptor acceptor) {
		super(projectContext, acceptor);
	}

	public void validateLocalVariable(
			LocalVariableDeclaration localVariableDeclaration) {

		RuleDeclaration rule =
			MitraUtils.retrieveContainingRule(localVariableDeclaration);

		final VarDeclaration varDeclaration =
			localVariableDeclaration.getVardecl();
		String varName = varDeclaration.getName();

		Map<String, VarDeclaration> visibleVariables =
			VariableScopeHelper.getVisibleVariablesAtLocation(
					localVariableDeclaration, getMetamodelManager());

		VarDeclaration firstDeclaration = visibleVariables.get(varName);
		if (firstDeclaration != varDeclaration) {
			error("Duplicate local variable " + varName, varDeclaration,
					varDeclaration.eContainingFeature(), -1);
			return; // no more validation
		}

		List<? extends VariableAccess> variableAccess =
			Collector.collectByTypeAfterMarker(rule, localVariableDeclaration,
					VariableAccess.class,
					new Collector.Condition<VariableAccess>() {
						@Override
						public boolean accept(VariableAccess variableAccess) {
							return variableAccess.getVariable() == varDeclaration;
						}
					});

		if (variableAccess.isEmpty()) {
			warning("The local variable " + varName + " is never read",
					varDeclaration, varDeclaration.eContainingFeature(), -1);
			return;
		}

		if (localVariableDeclaration.getExpression() == null) {

		}
	}

}
