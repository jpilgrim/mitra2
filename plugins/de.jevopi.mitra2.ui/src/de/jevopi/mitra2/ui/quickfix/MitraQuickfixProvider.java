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
package de.jevopi.mitra2.ui.quickfix;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EContentsEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;

import de.jevopi.ecore.utils.DynEcoreUtil;
import de.jevopi.mitra2.MitraIssueCodes;
import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.engine.TypeResolver;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.FeatureField;
import de.jevopi.mitra2.mitra.FormalParameter;
import de.jevopi.mitra2.mitra.MetamodelDeclaration;
import de.jevopi.mitra2.mitra.MitraFactory;
import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.Module;
import de.jevopi.mitra2.mitra.ParameterModifier;
import de.jevopi.mitra2.mitra.PrimitiveType;
import de.jevopi.mitra2.mitra.ReferenceType;
import de.jevopi.mitra2.mitra.ReturnParameter;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.RuleInvocation;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.TypedVarDeclaration;
import de.jevopi.mitra2.mitra.util.MitraSwitch;
import de.jevopi.mitra2.ui.MitraUIUtils;
import de.jevopi.mitra2.ui.linking.MitraLinkingDiagnosticMessageProvider;

public class MitraQuickfixProvider extends DefaultQuickfixProvider {

	//	@Fix(MyJavaValidator.INVALID_NAME)
	//	public void capitalizeName(final Issue issue, IssueResolutionAcceptor acceptor) {
	//		acceptor.accept(issue, "Capitalize name", "Capitalize the name.", "upcase.png", new IModification() {
	//			public void apply(IModificationContext context) throws BadLocationException {
	//				IXtextDocument xtextDocument = context.getXtextDocument();
	//				String firstLetter = xtextDocument.get(issue.getOffset(), 1);
	//				xtextDocument.replace(issue.getOffset(), 1, firstLetter.toUpperCase());
	//			}
	//		});
	//	}

	@Fix(MitraIssueCodes.FEATURE_FIELD_NOT_FOUND)
	public void changeFieldName(final Issue issue,
			IssueResolutionAcceptor acceptor) {

		final String missingFieldName = issue.getData()[0];
		for (int i = 1; i < issue.getData().length; i++) {
			final String fieldName = issue.getData()[i];
			acceptor.accept(issue, "Change to " + fieldName, "Change "
				+ missingFieldName + " to " + fieldName, null,
					new ISemanticModification() {

						@Override
						public void apply(EObject i_element,
								IModificationContext i_context)
								throws Exception {
							FeatureField featureField =
								(FeatureField) i_element;
							featureField.setName(fieldName);
							//							
							//							SelectorExpression varRef = (SelectorExpression) i_element;
							//							KindDecl kindDecl = varRef.getReceiver().getDecl().getKind().getDecl();
							//							
							//							// RuleSet ruleSet = (RuleSet) kindDecl.eContainer();
							//							PropertyDecl propertyDecl = varRef.getProperty().getDecl();
							//							PropertyRefWithAnnotation newProperty = RefacolaFactory.eINSTANCE.createPropertyRefWithAnnotation();
							//							newProperty.setDecl(propertyDecl);
							//							kindDecl.getProperties().add(newProperty);

						}
					});
		}
	}

	@Fix(MitraLinkingDiagnosticMessageProvider.MISSING_RULE)
	public void createRule(final Issue issue, IssueResolutionAcceptor acceptor) {
		final String linkText = issue.getData()[0];
		acceptor.accept(issue, "Create rule '" + linkText + "'",
				"Create rule '" + linkText + "'", null,
				new ISemanticModification() {
					public void apply(final EObject element,
							IModificationContext context) {
						createRule(element, linkText);
					}
				});
		createLinkingIssueResolutions(issue, acceptor);
	}

	private void createRule(EObject element, String linkText) {
		ProjectContext projectContext =
			ProjectContext.getProjectContext(element);
		RuleDeclaration sibling = MitraUtils.retrieveContainingRule(element);
		Type[] types = new Type[0];
		final TypeResolver typeResolver = projectContext.getTypeResolver();

		if (element instanceof RuleInvocation) {
			RuleInvocation ruleInvocation = (RuleInvocation) element;
			types =
				projectContext.getTypeResolver().visitList(
						ruleInvocation.getArguments());
		}

		Type[] returnTypes =
			typeResolver.computeTypeOfRuleInvocationAtPosition(element
				.eContainer());

		String[] parNames = new String[types.length];
		String[] retNames = new String[returnTypes.length];

		computeRuleParameterNames(types, returnTypes, parNames, retNames);

		MitraFactory f = MitraFactory.eINSTANCE;

		RuleDeclaration ruleDeclaration = f.createRuleDeclaration();
		ruleDeclaration.setName(linkText);
		ruleDeclaration.setBody(f.createBlock());

		Module module = MitraUtils.retrieveModule(element);
		EList<RuleDeclaration> rules = module.getRuleDeclarations();
		int index = rules.indexOf(sibling) + 1;
		rules.add(index, ruleDeclaration);

		for (int i = 0; i < parNames.length; i++) {
			FormalParameter formalParameter = f.createFormalParameter();
			ruleDeclaration.getFormalParameters().add(formalParameter);
			try {

				TypedVarDeclaration typedVarDeclaration =
					f.createTypedVarDeclaration();
				formalParameter.setVardecl(typedVarDeclaration);

				typedVarDeclaration.setName(parNames[i]);
				//setType(typedVarDeclaration, types[i]);
				typedVarDeclaration.setType(EcoreUtil.copy(types[i]));
				unresolve(typedVarDeclaration);

			} catch (Exception ex) {
				ruleDeclaration.getFormalParameters().remove(formalParameter);
			}
		}

		for (int i = 0; i < retNames.length; i++) {
			ReturnParameter returnParameter = f.createReturnParameter();
			ruleDeclaration.getReturnParameters().add(returnParameter);
			try {

				TypedVarDeclaration typedVarDeclaration =
					f.createTypedVarDeclaration();
				returnParameter.setVardecl(typedVarDeclaration);

				typedVarDeclaration.setName(retNames[i]);
				typedVarDeclaration.setType(EcoreUtil.copy(returnTypes[i]));

				if (retNames.length == 1
					&& typedVarDeclaration.getType() instanceof ReferenceType) {
					returnParameter.setModifier(ParameterModifier.CREATE);
				}

				unresolve(typedVarDeclaration);

			} catch (Exception ex) {
				ruleDeclaration.getReturnParameters().remove(returnParameter);
			}
		}

	}

	/**
	 * @param types
	 * @param returnTypes
	 * @param uniqueNames
	 * @param parNames
	 * @param retNames
	 */
	private void computeRuleParameterNames(Type[] types, Type[] returnTypes,
			String[] parNames, String[] retNames) {
		Set<String> uniqueNames = new HashSet<String>();
		String s0, s;
		for (int i = 0; i < types.length; i++) {
			s0 = MitraUIUtils.computeVariablenameFromType(types[i]);
			s = s0;
			int j = 0;
			while (!uniqueNames.add(s)) {
				s = s0 + (++j);
			}
			parNames[i] = s;
		}

		for (int i = 0; i < returnTypes.length; i++) {
			s0 = MitraUIUtils.computeVariablenameFromType(returnTypes[i]);
			s = s0;
			int j = 0;
			while (!uniqueNames.add(s)) {
				s = s0 + (++j);
			}
			retNames[i] = s;
		}
	}

	@Inject
	private IScopeProvider scopeProvider;

	private void unresolve(EObject eObject) {
		for (EContentsEList.FeatureIterator featureIterator =
			(EContentsEList.FeatureIterator) eObject.eCrossReferences()
				.iterator(); featureIterator.hasNext();) {
			EObject obj = (EObject) featureIterator.next();
			EReference eReference = (EReference) featureIterator.feature();

			IScope scope = scopeProvider.getScope(eObject, eReference);
			String name = (String) DynEcoreUtil.xeval(obj, "name");
			// TODO seems odd, stems from 1.x -> 2.x adaptation
			QualifiedName qualifiedName = QualifiedName.create(name);
			IEObjectDescription descr = scope.getSingleElement(qualifiedName);
			EObject newValue = descr.getEObjectOrProxy();
			eObject.eSet(eReference, newValue);
		}

		for (EObject child : eObject.eContents()) {
			unresolve(child);
		}

	}

	public void
			setType(final TypedVarDeclaration typedVarDeclaration, Type src) {
		Type type = new MitraSwitch<Type>() {
			@Override
			public Type casePrimitiveType(PrimitiveType pType) {
				PrimitiveType t = MitraFactory.eINSTANCE.createPrimitiveType();
				t.setPrimitiveType(pType.getPrimitiveType());
				return t;
			};

			@Override
			public Type caseCollectionType(CollectionType ctype) {
				CollectionType t =
					MitraFactory.eINSTANCE.createCollectionType();
				t.setCollectionType(ctype.getCollectionType());
				// TODO setProxy(t, MitraPackage.eINSTANCE.getCollectionType_TypePar())
				return t;
			};

			@Override
			public Type caseReferenceType(ReferenceType rtype) {
				ReferenceType t = MitraFactory.eINSTANCE.createReferenceType();
				typedVarDeclaration.setType(t);
				EReference eReference =
					MitraPackage.eINSTANCE
						.getReferenceType_MetamodelDeclaration();
				IScope scope = scopeProvider.getScope(t, eReference);

				//				IEObjectDescription descr =
				//					scope.getContentByName(rtype.getMetamodelDeclaration()
				//						.getName());
				// TODO seems odd, stems from 1.x -> 2.x adaptation
				QualifiedName qualifiedName =
					QualifiedName.create(rtype.getMetamodelDeclaration()
						.getName());
				IEObjectDescription descr =
					scope.getSingleElement(qualifiedName);
				t.setMetamodelDeclaration((MetamodelDeclaration) descr
					.getEObjectOrProxy());
				scope =
					scopeProvider.getScope(t, MitraPackage.eINSTANCE
						.getReferenceType_EClassifier());
				// TODO seems odd, stems from 1.x -> 2.x adaptation
				qualifiedName =
					QualifiedName.create(rtype.getEClassifier().getName());
				descr = scope.getSingleElement(qualifiedName);
//				descr =
//					scope.getContentByName(rtype.getEClassifier().getName());
				t.setEClassifier((EClassifier) descr.getEObjectOrProxy());
				return t;
			};

		}.doSwitch(src);

	}

}
