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
package de.jevopi.mitra2.engine;

import static de.jevopi.mitra2.MitraUtils.fqn;
import static de.jevopi.mitra2.MitraUtils.isFqnRulename;
import static de.jevopi.mitra2.MitraUtils.retrieveVisibleRules;
import static de.jevopi.utils.FilteredIterable.select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import de.jevopi.mitra2.MitraError;
import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.message.AbstractMessenger;
import de.jevopi.mitra2.message.IMessageAcceptor;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.utils.Filter;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Jan 20, 2012
 */
public class RuleResolver extends AbstractMessenger {

	protected ProjectContext projectContext;

	/**
	 * @param context must not be null
	 * @param typeResolver must not be null
	 */
	public RuleResolver(ProjectContext projectContext) {
		this.projectContext = projectContext;
	}

	@Override
	protected IMessageAcceptor getMessageAcceptor() {
		return projectContext.getMessageAcceptor();
	}

	protected MetamodelManager getMetamodelManager() {
		return projectContext.getMetamodelManager();
	}

	/**
	 * Retrieve all rules visible to a referrer matching the given rule name and
	 * argument types. This method is called by the scope provider for static
	 * rule binding. If all argument types are provided, for each unique name a
	 * best matching rule is selected.
	 * 
	 * @param referrer must not be null
	 * @param ruleName matching rule name, may be null
	 * @param argumentTypes matching rule types, array or elements may be null
	 * @return
	 */
	public Iterable<RuleDeclaration> resolveVisibleRules(EObject referrer,
			final String ruleName, final Type[] argumentTypes) {

		/* referrer must not be null */
		if (referrer == null) {
			throw new NullPointerException("Argument referer must not be null");
		}

		Iterable<RuleDeclaration> rules = retrieveVisibleRules(referrer);

		rules = filterRulesByName(ruleName, rules);

		if (argumentTypes != null) {
			ArgumentTypeFilter argumentTypeFilter =
				new ArgumentTypeFilter(projectContext, argumentTypes);
			rules = select(rules, argumentTypeFilter);

			// filter by argument types
			// if are all argument type specified
			if (argumentTypeFilter.areAllArgumentTypesSpecified()
				&& rules.iterator().hasNext()) {

				Map<String, List<RuleDeclaration>> rulesByNameMap =
					organizeRulesByName(rules);

				List<RuleDeclaration> uniqueNamesRules =
					flattenAndFilterOutOverloadedRules(rulesByNameMap,
							argumentTypes);

				return uniqueNamesRules;
			}
		}

		return rules;

	}

	/**
	 * @param ruleName
	 * @param rules
	 * @return
	 */
	private Iterable<RuleDeclaration> filterRulesByName(final String ruleName,
			Iterable<RuleDeclaration> rules) {
		// filter rules by name, if name is specified
		if (ruleName != null && !ruleName.isEmpty()) {
			if (isFqnRulename(ruleName)) {
				rules = select(rules, new Filter<RuleDeclaration>() {
					@Override
					public FilterResult apply(RuleDeclaration element) {
						return FilterResult.accept(ruleName
							.equals(fqn(element)));
					}
				});
			} else {
				rules = select(rules, new Filter<RuleDeclaration>() {
					@Override
					public FilterResult apply(RuleDeclaration element) {
						return FilterResult.accept(ruleName.equals(element
							.getName()));
					}
				});
			}
		}
		return rules;
	}

	/**
	 * @param rulesByNameMap
	 * @param argumentTypes
	 * @return
	 */
	private List<RuleDeclaration> flattenAndFilterOutOverloadedRules(
			Map<String, List<RuleDeclaration>> rulesByNameMap,
			final Type[] argumentTypes) {
		List<RuleDeclaration> uniqueNamesRules =
			new ArrayList<RuleDeclaration>();
		TypeMatcher matcher =
			new TypeMatcherType(projectContext, argumentTypes);
		for (List<RuleDeclaration> namedRules : rulesByNameMap.values()) {
			if (namedRules.size() > 1) {
				RuleDeclaration bestMatch =
					findBestMatchingRule(namedRules, matcher);
				uniqueNamesRules.add(bestMatch);
			} else {
				uniqueNamesRules.add(namedRules.get(0));
			}
		}
		return uniqueNamesRules;
	}

	/**
	 * @param rules
	 * @return
	 */
	private Map<String, List<RuleDeclaration>> organizeRulesByName(
			Iterable<RuleDeclaration> rules) {
		Map<String, List<RuleDeclaration>> rulesByNameMap =
			new HashMap<String, List<RuleDeclaration>>();
		for (RuleDeclaration rule : rules) {
			String fqn = fqn(rule);
			List<RuleDeclaration> namedRules = rulesByNameMap.get(fqn);
			if (namedRules == null) {
				namedRules = new ArrayList<RuleDeclaration>(3);
				rulesByNameMap.put(fqn, namedRules);
			}
			namedRules.add(rule);
		}
		return rulesByNameMap;
	}

	/**
	 * Returns best matching rules in given list, or null, if no such rule
	 * matches. If more than one rule matches "best", a compile error is thrown.
	 * 
	 * @param candidateRules
	 * @param matcher
	 * @return
	 */
	protected RuleDeclaration findBestMatchingRule(
			Iterable<RuleDeclaration> candidateRules, TypeMatcher matcher) {

		RuleDeclaration bestMatchingRule = null;
		float bestMatching = -1;
		float highestRating = matcher.calcBestMatch();
		for (RuleDeclaration decl : candidateRules) {
			if (decl.getFormalParameters().size() == matcher
				.getNumberOfArguments()) {
				if (bestMatchingRule != decl) {
					float matching =
						matcher.match(decl.getFormalParameters(),
								decl.getReturnParameters());
					if (matching >= 0) {
						if (matching > bestMatching) {
							bestMatchingRule = decl;
							bestMatching = matching;
						} else if (matching == bestMatching) {
							// bestMatchingRule must be set, otherwise bastMatching is -1
							String s1 = String.valueOf(decl);
							if (matching == highestRating) {
								if (fqn(decl).equals(fqn(bestMatchingRule))) {
									runtimeError("Duplicate rule " + s1, decl);
									throw new MitraError();
								}
								break;
							}

							String s2 = String.valueOf(bestMatchingRule);
							runtimeError("The rules " + s1 + " and " + s2
								+ " are ambiguous.", decl);
							throw new MitraError();
						}
					}
				}
			}
		}

		return bestMatchingRule;
	}
	
	/**
	 * @param i_fqnRuleToExecute
	 * @param i_wrappedArguments ordered arguments
	 * @return
	 */
	public RuleDeclaration findBestMatchingRule(String fqnRuleToExecute,
			MObject[] wrappedArguments) {
		Iterable<RuleDeclaration> overloadedRules =
			projectContext.getAllRulesByName(fqnRuleToExecute);
		return findBestMatchingRule(overloadedRules, new TypeMatcherMObject(
			projectContext, wrappedArguments));
	}

	/**
	 * @param i_fqnRuleToExecute
	 * @param i_wrappedArguments arguments by name
	 * @return
	 */
	public RuleDeclaration findBestMatchingRule(String fqnRuleToExecute,
			Map<String, MObject> wrappedArguments) {
		Iterable<RuleDeclaration> overloadedRules =
			projectContext.getAllRulesByName(fqnRuleToExecute);

		RuleDeclaration bestMatchingRule = null;
		float bestMatching = -1;
		float highestRating = -1;
		String ambigious = "";

		for (RuleDeclaration rule : overloadedRules) {
			if (rule.getFormalParameters().size() == wrappedArguments.size()) {
				MObject[] args = new MObject[wrappedArguments.size()];
				for (int i = 0; i < args.length; i++) {
					String name =
						rule.getFormalParameters().get(i).getVardecl()
							.getName();
					MObject mobject = wrappedArguments.get(name);
					if (mobject == null) {
						args = null;
						break;
					} else {
						args[i] = mobject;
					}
				}
				if (args != null) {
					TypeMatcherMObject matcher =
						new TypeMatcherMObject(projectContext, args);
					if (highestRating < 0)
						highestRating = matcher.calcBestMatch();

					float matching =
						matcher.match(rule.getFormalParameters(),
								rule.getReturnParameters());
					if (matching >= 0) {
						if (matching > bestMatching) {
							bestMatchingRule = rule;
							bestMatching = matching;
							ambigious = "";
						} else if (matching == bestMatching) {
							// bestMatchingRule must be set, otherwise bastMatching is -1
							String s1 = String.valueOf(rule);
							if (matching == highestRating) {
								runtimeError("Duplicate rule " + s1, rule);
								throw new MitraError();
							}

							String s2 = String.valueOf(bestMatchingRule);
							ambigious =
								"The rules " + s1 + " and " + s2
									+ " are ambiguous.";
						}
					}

				}
			}
		}

		if (!ambigious.isEmpty()) {
			runtimeError(ambigious, bestMatchingRule);
			throw new MitraError();
		}

		return bestMatchingRule;

	}

}
