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
package de.jevopi.mitra2.scoping;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.engine.RuleResolver;
import de.jevopi.mitra2.engine.TypeResolver;
import de.jevopi.mitra2.engine.VariableScopeHelper;
import de.jevopi.mitra2.metamodel.IMetamodel;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.mitra.MetamodelDeclaration;
import de.jevopi.mitra2.mitra.Module;
import de.jevopi.mitra2.mitra.ModuleReference;
import de.jevopi.mitra2.mitra.ReferenceType;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.RuleInvocation;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.VarDeclaration;
import de.jevopi.mitra2.mitra.VariableAccess;

/**
 * This class contains custom scoping description. see :
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on how
 * and when to use it
 */
public class MitraScopeProvider extends AbstractDeclarativeScopeProvider {

	/**
	 * Logger for this class
	 */
	// @SuppressWarnings("unused") //$NON-NLS-1$
	static final Logger log = Logger.getLogger(MitraScopeProvider.class
		.getName());

	/**
	 * @param eobj
	 * @return
	 */
	protected ProjectContext getProjectContext(EObject eobj) {
		return ProjectContext.getProjectContext(eobj);
	}

	IScope scope_ReferenceType_metamodel(ReferenceType referenceType,
			@SuppressWarnings("unused") EReference metamodel) {

		Module module = MitraUtils.retrieveModule(referenceType);
		if (module == null) {
			return null;
		}
		List<MetamodelDeclaration> metamodelDeclarations =
			module.getMetamodelDeclarations();
		return Scopes.scopeFor(metamodelDeclarations);
	}

	IScope scope_ReferenceType_eClassifier(ReferenceType referenceType,
			@SuppressWarnings("unused") EReference ref) {
		try {
			ProjectContext context = getProjectContext(referenceType);
			MetamodelManager metamodelManager = context.getMetamodelManager();
			if (referenceType.getMetamodelDeclaration().eIsProxy()) {
				EcoreUtil.resolve(referenceType.getMetamodelDeclaration(),
						context.getResourceSet());

			}
			IMetamodel metamodel =
				metamodelManager.getMetamodel(referenceType
					.getMetamodelDeclaration());

			return Scopes.scopeFor(metamodel.getAllClassifiers());
		} catch (Throwable ex) {
			ex.printStackTrace();
			return null;

		}
	}

	IScope scope_ModuleReference_module(ModuleReference moduleReference,
			@SuppressWarnings("unused") EReference ref) {
		Module module = MitraUtils.retrieveModule(moduleReference);

		if (module == null) {
			return null;
		}

		ProjectContext projectContext = getProjectContext(moduleReference);
		Map<String, Module> modulesByFQN = projectContext.getAllModules();

		
		
		// Xtext 1.x: uses Strings, Xtext 2.x: uses qualified names
		return Scopes.scopeFor(modulesByFQN.values(),
				new MitraUtils.ModuleToFQNFunction(), IScope.NULLSCOPE);
		
	}

	IScope scope_RuleInvocation_ruleDeclaration(RuleInvocation ruleInvocation,
			@SuppressWarnings("unused") EReference ref) {

		Module module = MitraUtils.retrieveModule(ruleInvocation);

		if (module == null) {
			return null;
		}

		ProjectContext context = getProjectContext(ruleInvocation);

		TypeResolver typeResolver = new TypeResolver(context);
		RuleResolver ruleResolver = new RuleResolver(context);

		// name of rule invocation is not known -- as this is the
		// actually indirectly defined by the referenced rule declaration,
		// which is to be target of the scoping here

		// so, we rely on standard name matching, however only
		// scope entries are provided matching the number and types
		// of arguments and parameters respectively

		// calling ruleInvocation.getRuleDeclaration() will produce an error:
		// Cyclic resolution of lazy links :
		// RuleInvocation.ruleDeclaration->RuleInvocation.ruleDeclaration

		Type[] argTypes = null;
		if (ruleInvocation.getArguments() != null) {
			argTypes = new Type[ruleInvocation.getArguments().size()];
			for (int i = 0; i < argTypes.length; i++) {
				Type[] types =
					typeResolver.visit(ruleInvocation.getArguments().get(i));
				if (types.length == 1) {
					argTypes[i] = types[0];
				}
			}
		}

		Iterable<RuleDeclaration> matchingRules =
			ruleResolver.resolveVisibleRules(ruleInvocation, null, argTypes);

		return Scopes.scopeFor(matchingRules);
	}

	IScope scope_VariableAccess_variable(VariableAccess variableAccess,
			@SuppressWarnings("unused") EReference ref) {
		MetamodelManager metamodelManager =
			getProjectContext(variableAccess).getMetamodelManager();
		Map<String, VarDeclaration> visibleVariablesBeforeLocation =
			VariableScopeHelper.getVisibleVariablesBeforeLocation(
					variableAccess, metamodelManager);

		return Scopes.scopeFor(visibleVariablesBeforeLocation.values());

	}

}
