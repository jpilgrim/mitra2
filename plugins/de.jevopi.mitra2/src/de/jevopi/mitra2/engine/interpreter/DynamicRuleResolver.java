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

package de.jevopi.mitra2.engine.interpreter;

import static de.jevopi.utils.FilteredIterable.select;

import java.util.Set;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.engine.ArgumentTypeFilter;
import de.jevopi.mitra2.engine.RuleResolver;
import de.jevopi.mitra2.engine.TypeMatcherMObject;
import de.jevopi.mitra2.engine.TypeMatcherType;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.RuleInvocation;
import de.jevopi.mitra2.mitra.Type;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Jan 25, 2012
 */
public class DynamicRuleResolver extends RuleResolver {

	/**
	 * @param projectContext
	 */
	public DynamicRuleResolver(ProjectContext projectContext) {
		super(projectContext);
	}

	public RuleDeclaration resolveRuleDynamically(
			RuleInvocation ruleInvocation, MObject[] arguments) {
		if (arguments.length != ruleInvocation.getRuleDeclaration()
			.getFormalParameters().size()) {
			throw new IllegalArgumentException(
				"Number of arguments differs from number of rule parameters");
		}
		RuleDeclaration decl = ruleInvocation.getRuleDeclaration();

		Set<RuleDeclaration> overridingRules =
			projectContext.getOverridingRules(decl);
		return findBestMatchingRule(overridingRules, new TypeMatcherMObject(
			projectContext, arguments));

	}

	public RuleDeclaration resolveRuleDynamically(String fqnRule,
			final Type[] argumentTypes) {

		Iterable<RuleDeclaration> rulesWithName =
			projectContext.getAllRulesByName(fqnRule);
		rulesWithName = select(rulesWithName, new ArgumentTypeFilter(projectContext,
				argumentTypes));
		return findBestMatchingRule(rulesWithName, new TypeMatcherType(
			projectContext, argumentTypes));

	}

}
