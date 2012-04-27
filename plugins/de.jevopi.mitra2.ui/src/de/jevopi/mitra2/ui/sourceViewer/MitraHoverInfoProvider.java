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
package de.jevopi.mitra2.ui.sourceViewer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.engine.RuleResolver;
import de.jevopi.mitra2.engine.TypeResolver;
import de.jevopi.mitra2.metamodel.FeatureDescription;
import de.jevopi.mitra2.metamodel.FeatureFieldDescription;
import de.jevopi.mitra2.metamodel.FeatureMethodDescription;
import de.jevopi.mitra2.metamodel.IMetamodel;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.FeatureField;
import de.jevopi.mitra2.mitra.FeatureMethodInvocation;
import de.jevopi.mitra2.mitra.NativeOperationInvocation;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.RuleInvocation;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.VarDeclaration;
import de.jevopi.mitra2.mitra.VariableAccess;
import de.jevopi.mitra2.mitra.util.MitraSwitch;
import de.jevopi.mitra2.nativeoperations.INativeOperation;
import de.jevopi.mitra2.nativeoperations.NativeOperationResolver;

/**
 * Returns information about given model elements, basically used for hover
 * information messages.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 5, 2012
 * @see MitraTextHover
 */
public class MitraHoverInfoProvider extends MitraSwitch<String> {

	/**
	 * @author Jens von Pilgrim (developer@jevopi.de)
	 * @since Feb 5, 2012
	 */
	private final class OwnedOverNameComparator implements
			Comparator<FeatureDescription> {
		/**
		 * 
		 */
		private final Type m_type;

		/**
		 * @param i_type
		 */
		private OwnedOverNameComparator(Type i_type) {
			m_type = i_type;
		}

		@Override
		public int compare(FeatureDescription f1, FeatureDescription f2) {
			if (f1 == f2) return 0;
			// owned - name
			int typeDist1 =
				getMetamodelManager().calcTypeDistance(m_type,
						f1.getDeclaredType());
			int typeDist2 =
				getMetamodelManager().calcTypeDistance(m_type,
						f2.getDeclaredType());
			if (typeDist1 == typeDist2) {
				return f1.getName().compareTo(f2.getName());
			}
			return typeDist1 - typeDist2;
		}
	}

	/**
	 * Set in constructor.
	 */
	protected ProjectContext projectContext;

	/**
	 * @param i_metamodelManager
	 */
	public MitraHoverInfoProvider(ProjectContext projectContext) {
		this.projectContext = projectContext;
	}

	/**
	 * @return
	 * @see de.jevopi.mitra2.context.ProjectContext#getMetamodelManager()
	 */
	protected MetamodelManager getMetamodelManager() {
		return projectContext.getMetamodelManager();
	}

	/**
	 * @return
	 * @see de.jevopi.mitra2.context.ProjectContext#getTypeResolver()
	 */
	protected TypeResolver getTypeResolver() {
		return projectContext.getTypeResolver();
	}

	/**
	 * @return
	 * @see de.jevopi.mitra2.context.ProjectContext#getRuleResolver()
	 */
	protected RuleResolver getRuleResolver() {
		return projectContext.getRuleResolver();
	}

	protected NativeOperationResolver getNativeOperationResolver() {
		return projectContext.getNativeOperationResolver();
	}

	@Override
	public String caseType(final Type type) {
		StringBuilder strb = new StringBuilder();
		strb.append(type.toString());
		appendTypeDescription(type, strb);
		return strb.toString();
	}

	@Override
	public String caseRuleInvocation(RuleInvocation ruleInvocation) {
		RuleDeclaration ruleDeclaration = ruleInvocation.getRuleDeclaration();
		if (ruleDeclaration == null) return "declaration not found";

		StringBuilder strb = new StringBuilder();
		strb.append(MitraUtils.fqn(ruleDeclaration)).append("\n\n")
			.append(ruleDeclaration.toString());
		return strb.toString();

	}

	@Override
	public String caseVarDeclaration(VarDeclaration varDeclaration) {
		String s = caseType(getTypeResolver().getType(varDeclaration));
		if (varDeclaration.getType() == null) {
			s = "Inferred type " + s;
		}
		return s;
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseVariableAccess(de.jevopi.mitra2.mitra.VariableAccess)
	 * @since Feb 5, 2012
	 */
	@Override
	public String caseVariableAccess(VariableAccess variableAccess) {
		return caseVarDeclaration(variableAccess.getVariable());
	}

	@Override
	public String caseFeatureField(FeatureField featureField) {

		Type receiver = getTypeResolver().resolveReceiverType(featureField);
		final Type type = getTypeResolver().caseFeatureField(featureField)[0];
		IMetamodel metamodel = getMetamodelManager().getMetamodel(receiver);
		FeatureFieldDescription fieldDescription =
			metamodel.getFeatureFieldDescription(receiver,
					featureField.getName());

		StringBuilder strb = new StringBuilder();
		strb.append(fieldDescription.getDescription());
		appendTypeDescription(type, strb);

		return strb.toString();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseFeatureMethodInvocation(de.jevopi.mitra2.mitra.FeatureMethodInvocation)
	 * @since Feb 5, 2012
	 */
	@Override
	public String caseFeatureMethodInvocation(
			FeatureMethodInvocation featureMethodInvocation) {
		Type receiver =
			getTypeResolver().resolveReceiverType(featureMethodInvocation);
		final Type type =
			getTypeResolver().caseFeatureMethodInvocation(
					featureMethodInvocation)[0];
		IMetamodel metamodel = getMetamodelManager().getMetamodel(receiver);

		List<FeatureMethodDescription> methodDescriptions =
			metamodel.getMethodDescriptions(
					receiver,
					featureMethodInvocation.getName(),
					getTypeResolver().visitList(
							featureMethodInvocation.getArguments()), false);

		StringBuilder strb = new StringBuilder();
		
		for (int i = 0; i < methodDescriptions.size(); i++) {
			if (i != 0) {
				strb.append("\n or ");
			}
			strb.append(methodDescriptions.get(i).getDescription());
			
		}
		appendTypeDescription(type, strb);

		return strb.toString();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseNativeOperationInvocation(de.jevopi.mitra2.mitra.NativeOperationInvocation)
	 * @since Feb 5, 2012
	 */
	@Override
	public String caseNativeOperationInvocation(
			NativeOperationInvocation nativeOperationInvocation) {
		INativeOperation nativeOperation =
			getNativeOperationResolver().getNativeOperations().get(
					nativeOperationInvocation.getName());
		
		if (nativeOperation==null) {
			return "";
		}
		
		Type receiverType =
			getTypeResolver().resolveReceiverType(nativeOperationInvocation);
		Type type =
			getTypeResolver().caseNativeOperationInvocation(
					nativeOperationInvocation)[0];

		StringBuilder strb = new StringBuilder();
		strb.append(nativeOperation.getSignature(receiverType));
		strb.append(": ").append(type);

		strb.append("\n\n").append(nativeOperation.getDescription());

		appendTypeDescription(type, strb);

		return strb.toString();

	}

	/**
	 * @param type
	 * @param strb
	 */
	protected void appendTypeDescription(final Type type, StringBuilder strb) {
		final IMetamodel metamodel = getMetamodelManager().getMetamodel(type);

		List<? extends FeatureDescription> allFeatureFieldsDescriptions =
			metamodel.getAllFeatureFieldsDescriptions(type, false, false);
		Collections.sort(allFeatureFieldsDescriptions,
				new OwnedOverNameComparator(type));
		if (!allFeatureFieldsDescriptions.isEmpty()) {
			strb.append("\n\nFields:");
		}
		Type currentType = type;
		for (FeatureDescription f : allFeatureFieldsDescriptions) {
			if (!MetamodelManager.equals(currentType, f.getDeclaredType())) {
				currentType = f.getDeclaredType();
				strb.append("\n\n  Fields inherited from  ")
					.append(currentType);
			}
			strb.append("\n  - ").append(f.getBriefDescription());

		}

		List<? extends FeatureDescription> allFeatureMethodDescriptions =
			metamodel.getMethodDescriptions(type, null, null, false);
		Collections.sort(allFeatureMethodDescriptions,
				new OwnedOverNameComparator(type));
		if (!allFeatureMethodDescriptions.isEmpty()) {
			strb.append("\n\nMethods:");
		}
		currentType = type;
		for (FeatureDescription f : allFeatureMethodDescriptions) {
			if (!MetamodelManager.equals(currentType, f.getDeclaredType())) {
				currentType = f.getDeclaredType();
				strb.append("\n\n  Methods inherited from  ").append(
						currentType);
			}
			strb.append("\n  - ").append(f.getBriefDescription());
		}

		if (type instanceof CollectionType) {
			CollectionType collectionType = (CollectionType) type;
			strb.append("\n\nMembers of element type ").append(
					collectionType.getTypePar());
			appendTypeDescription(collectionType.getTypePar(), strb);
		}

	}
}
