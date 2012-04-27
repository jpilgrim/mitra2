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
package de.jevopi.mitra2.ui.contentassist;

import static de.jevopi.mitra2.ui.MitraUIUtils.computeVariablenameFromType;
import static de.jevopi.utils.FilteredIterable.select;
import static java.util.Arrays.fill;
import static java.util.Collections.emptyList;

import java.io.File;
import java.io.FileFilter;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.FeatureDescription;
import de.jevopi.mitra2.metamodel.FeatureDescription.FeatureType;
import de.jevopi.mitra2.metamodel.IMetamodel;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.mitra.MetamodelDeclaration;
import de.jevopi.mitra2.mitra.Parameter;
import de.jevopi.mitra2.mitra.Property;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.VarDeclaration;
import de.jevopi.mitra2.nativeoperations.INativeOperation;
import de.jevopi.mitra2.nativeoperations.NativeOperationResolver;
import de.jevopi.utils.FileUtils;
import de.jevopi.utils.Filter;
import de.jevopi.utils.StringUtils;

/**
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on
 * how to customize content assistant
 */
public class MitraProposalProvider extends AbstractMitraProposalProvider {
	/**
	 * Logger for this class
	 */
	// @SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger log = Logger
		.getLogger(MitraProposalProvider.class.getName());

	@Override
	public void completeFeatureField_Name(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		doCompleteFeatureInvocation_Name(model, assignment, context, acceptor,
				FeatureType.FIELD);
	}

	@Override
	public void completeNativeOperationInvocation_Name(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {

		ProjectContext projectContext = ProjectContext.getProjectContext(model);
		if (projectContext == null) return;

		/*Xtext 1.x AbstractNode */
		/*Xtext 2.x */INode lastNode = context.getLastCompleteNode();
		if (!checkText(lastNode, "->")) return;
		Type type =
			MitraProposalUtils.findReceiverTypeBefore(lastNode, projectContext);
		if (type == null) return;

		NativeOperationResolver nativeOperationResolver =
			projectContext.getNativeOperationResolver();

		Collection<INativeOperation> nativeOperations =
			nativeOperationResolver.findMatchingNativeOperations(type);
		createNativeOperationsProposals(nativeOperations, context, acceptor);
		return;

	}

	private void
			createNativeOperationsProposals(
					Collection<INativeOperation> i_nativeOperations,
					ContentAssistContext context,
					ICompletionProposalAcceptor o_acceptor) {

		for (INativeOperation nativeOperation : i_nativeOperations) {
			ICompletionProposal completionProposal =
				createCompletionProposal(nativeOperation.getName(),
						new StyledString(nativeOperation.toString()),
						getLabelProvider().getImage(nativeOperation), 100,
						context.getPrefix(), context);
			o_acceptor.accept(completionProposal);
		}
	}

	@Override
	public void completeFeatureMethodInvocation_Name(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		doCompleteFeatureInvocation_Name(model, assignment, context, acceptor,
				FeatureType.METHOD);
	}

	protected void doCompleteFeatureInvocation_Name(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor, FeatureType featureType) {

		ProjectContext projectContext = ProjectContext.getProjectContext(model);
		if (projectContext == null) return;
		/*Xtext 1.x AbstractNode */
		/*Xtext 2.x */INode lastNode = context.getLastCompleteNode();
		if (!checkText(lastNode, ".")) return;
		Type type =
			MitraProposalUtils.findReceiverTypeBefore(lastNode, projectContext);
		if (type == null) return;

		createProposalsFeatureMethodsOrFields(context, acceptor,
				projectContext, context.getPrefix(), type, featureType);

		log.info("End completeFeatureField_Name");

	}

	private boolean checkText(/*Xtext 1.x AbstractNode */
	/*Xtext 2.x */INode node, String text) {
		if (node instanceof LeafNode) {
			return text.equals(((LeafNode) node).getText());
		}

		/* Xtext 2.x */
		LeafNode leafNode =
			(LeafNode) NodeModelUtils.findLeafNodeAtOffset(node,
					node.getOffset());
		/* Xtext 1.x
		(LeafNode) NodeUtil.findLeafNodeAtOffset((CompositeNode) node, node.getOffset());
		*/
		return text.equals(leafNode.getText());

	}

	/**
	 * @param context
	 * @param acceptor
	 * @param mitraContext
	 * @param namePrefix must not be null
	 * @param type, may be null (in this case, method returns immediately)
	 */
	protected void createProposalsFeatureMethodsOrFields(
			ContentAssistContext context, ICompletionProposalAcceptor acceptor,
			ProjectContext mitraContext, String namePrefix, Type type,
			FeatureType featureType) {

		MetamodelManager manager = mitraContext.getMetamodelManager();
		IMetamodel metamodel = manager.getMetamodel(type);

		List<? extends FeatureDescription> featureDescriptions;
		switch (featureType) {
		case FIELD:
			featureDescriptions =
				metamodel.getAllFeatureFieldsDescriptions(type, false, false);
			break;
		case METHOD:
			featureDescriptions =
				metamodel.getMethodDescriptions(type, null, null, false);
			break;
		case NATIVE:
		default:
			featureDescriptions = emptyList();
		}

		createProposalsForFeatureDescriptions(context, acceptor, namePrefix,
				type, metamodel, featureDescriptions);
	}

	private void createProposalsForFeatureDescriptions(
			ContentAssistContext context, ICompletionProposalAcceptor acceptor,
			String namePrefix, Type type, IMetamodel metamodel,
			List<? extends FeatureDescription> featureDescriptions) {
		for (FeatureDescription feature : featureDescriptions) {
			if (feature.getName().startsWith(namePrefix)) {
				int priority = getPriorityHelper().getDefaultPriority() + 300;
				int distance =
					metamodel.typeDistance(type, feature.getDeclaredType());
				priority -= 10 * distance;

				ICompletionProposal completionProposal =
					createCompletionProposal(
							// context.getPrefix() +
							feature.getName(),
							new StyledString(feature.getName() + " - "
								+ feature.getDescription()), getLabelProvider()
								.getImage(feature), priority,
							context.getPrefix(), context);
				// register the proposal, the acceptor handles null-values
				// gracefully
				acceptor.accept(completionProposal);
			}
		}
	}

	/**
	 * @see de.jevopi.mitra2.ui.contentassist.AbstractMitraProposalProvider#completeMetamodelDeclaration_Type(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.xtext.Assignment,
	 *      org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeMetamodelDeclaration_Type(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {

		ICompletionProposal completionProposal =
			createCompletionProposal("ecore", new StyledString(
				"ecore - EMF based metamodel"), null, 100, context.getPrefix(),
					context);
		acceptor.accept(completionProposal);
		completionProposal =
			createCompletionProposal("uml2", new StyledString(
				"uml2  -- UML2 metamodel"), null, 100, context.getPrefix(),
					context);
		acceptor.accept(completionProposal);

		// super.completeMetamodelDeclaration_Type(i_model, i_assignment,
		// i_context, i_acceptor);
	}

	/**
	 * @see de.jevopi.mitra2.ui.contentassist.AbstractMitraProposalProvider#completeProperty_Name(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.xtext.Assignment,
	 *      org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeProperty_Name(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {

		if (model instanceof MetamodelDeclaration) {
			MetamodelDeclaration metamodelDeclaration =
				(MetamodelDeclaration) model;
			String mmtype = metamodelDeclaration.getType();
			if ("ecore".equals(mmtype)) {
				ICompletionProposal completionProposal =
					createCompletionProposal("ecoreFile", new StyledString(
						"ecoreFile - load metamodel from ecore file"), null,
							200, context.getPrefix(), context);
				acceptor.accept(completionProposal);
				completionProposal =
					createCompletionProposal("nsUri", new StyledString(
						"nsUri - load metamodel by namespace uri"), null, 100,
							context.getPrefix(), context);
				acceptor.accept(completionProposal);
			}
		}
	}

	/**
	 * @see de.jevopi.mitra2.ui.contentassist.AbstractMitraProposalProvider#completeProperty_Value(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.xtext.Assignment,
	 *      org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 */
	@Override
	public void completeProperty_Value(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (model instanceof Property) {
			Property property = (Property) model;
			String propertyName = property.getName();
			if ("ecoreFile".equals(propertyName)) {
				// ProjectContext mitraContext =
				// ProjectContext.getProjectContext(model);
				File baseFolder = new File("."); // TODO replace with project
													// context method
				// mitraContext.getMetamodelManager().getBasePath());
				for (String name : FileUtils.collectPathNames(baseFolder,
						new FileFilter() {

							@Override
							public boolean accept(File f) {
								return f.isFile() && !f.isHidden()
									&& f.getName().endsWith(".ecore");
							}
						}, true)) {
					ICompletionProposal completionProposal =
						createCompletionProposal("\"" + name + "\"",
								new StyledString("\"" + name + "\""), null,
								200, context.getPrefix(), context);
					acceptor.accept(completionProposal);
				}
			} else if ("nsUri".equals(propertyName)) {
				Registry registry = EPackage.Registry.INSTANCE;
				for (String name : registry.keySet()) {
					ICompletionProposal completionProposal =
						createCompletionProposal("\"" + name + "\"",
								new StyledString("\"" + name + "\""), null,
								200, context.getPrefix(), context);
					acceptor.accept(completionProposal);
				}
			}
		}
	}

	/**
	 * @see de.jevopi.mitra2.ui.contentassist.AbstractMitraProposalProvider#completeVarDeclaration_Name(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.xtext.Assignment,
	 *      org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext,
	 *      org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor)
	 * @since Feb 3, 2012
	 */
	@Override
	public void completeTypedVarDeclaration_Name(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {

		if (!(model instanceof VarDeclaration)) return;

		VarDeclaration varDeclaration = (VarDeclaration) model;
		Type type = varDeclaration.getType();
		if (type == null) return;

		String nameProposal = "";
		nameProposal = computeVariablenameFromType(type);

		ICompletionProposal completionProposal =
			createCompletionProposal(nameProposal, new StyledString(
				nameProposal), null, 20000, context.getPrefix(), context);
		acceptor.accept(completionProposal);

	}

	@Override
	public void completeRuleDeclaration_OverriddenRule(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {

		if (!(model instanceof RuleDeclaration)) return;

		RuleDeclaration ruleDeclaration = (RuleDeclaration) model;
		// cannot override without parameters
		if (ruleDeclaration.getFormalParameters().isEmpty()) return;

		ProjectContext projectContext =
			ProjectContext.getProjectContext(ruleDeclaration);
		MetamodelManager metamodelManager =
			projectContext.getMetamodelManager();

		Iterable<RuleDeclaration> visibleRules =
			projectContext.getRuleResolver().resolveVisibleRules(model, null,
					null);

		for (RuleDeclaration superRule : select(visibleRules,
				new Filter<RuleDeclaration>() {
					@Override
					public FilterResult apply(RuleDeclaration t) {
						return FilterResult.accept(t.isVirtual());
					}
				})) {
			String possibleOverride =
				computePossibleOverride(superRule, ruleDeclaration,
						metamodelManager);
			if (!possibleOverride.isEmpty()) {
				int priority =
					20000
						+ possibleOverride.length()
						- 10
						* StringUtils.getLevenshteinDistance(
								superRule.getName(), ruleDeclaration.getName());
				ICompletionProposal completionProposal =
					createCompletionProposal(possibleOverride,
							new StyledString(possibleOverride), null, priority,
							context.getPrefix(), context);
				acceptor.accept(completionProposal);
			}
		}
	}

	private String computePossibleOverride(RuleDeclaration superRule,
			RuleDeclaration subRule, MetamodelManager metamodelManager) {

		// cannot override due to missing return parameters
		if (subRule.getReturnParameters().isEmpty() != superRule
			.getReturnParameters().isEmpty()) return "";

		StringBuilder strb = new StringBuilder();
		strb.append(superRule.getName()).append('(');

		if (!appendMatchingParameters(strb, subRule.getFormalParameters(),
				superRule.getFormalParameters(), metamodelManager)) {
			return "";
		}
		strb.append(')');
		if (!subRule.getReturnParameters().isEmpty()) {
			strb.append(": (");
			if (!appendMatchingParameters(strb, subRule.getReturnParameters(),
					superRule.getReturnParameters(), metamodelManager)) {
				return "";
			}
			strb.append(')');
		}
		return strb.toString();
	}

	private boolean appendMatchingParameters(StringBuilder o_strb,
			List<? extends Parameter> subParameters,
			Iterable<? extends Parameter> superParameters,
			MetamodelManager metamodelManager) {
		boolean[] used = new boolean[subParameters.size()];
		fill(used, false);
		boolean first = true;
		for (Parameter par : superParameters) {
			Type type = par.getVardecl().getType();
			int matchingIndex = -1;
			for (int i = 0; i < subParameters.size(); i++) {
				if (metamodelManager.isSubType(subParameters.get(i)
					.getVardecl().getType(), type)) {
					matchingIndex = i;
					if (!used[i]) {
						used[i] = true;
						break;
					}
				}
			}
			if (matchingIndex < 0) return false;
			if (!first) {
				o_strb.append(", ");
			} else {
				first = false;
			}
			o_strb
				.append(type.toString())
				.append(' ')
				.append(subParameters.get(matchingIndex).getVardecl().getName());
		}
		return true;
	}
}
