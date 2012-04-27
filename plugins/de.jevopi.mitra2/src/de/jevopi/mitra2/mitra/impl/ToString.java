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
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.BooleanLiteral;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.ExecutionModifier;
import de.jevopi.mitra2.mitra.Feature;
import de.jevopi.mitra2.mitra.FormalParameter;
import de.jevopi.mitra2.mitra.IntLiteral;
import de.jevopi.mitra2.mitra.MetamodelDeclaration;
import de.jevopi.mitra2.mitra.Module;
import de.jevopi.mitra2.mitra.NativeOperationInvocation;
import de.jevopi.mitra2.mitra.Parameter;
import de.jevopi.mitra2.mitra.ParameterModifier;
import de.jevopi.mitra2.mitra.ParameterReference;
import de.jevopi.mitra2.mitra.PrimitiveType;
import de.jevopi.mitra2.mitra.Property;
import de.jevopi.mitra2.mitra.QualifiedParameterReference;
import de.jevopi.mitra2.mitra.QualifiedRuleReference;
import de.jevopi.mitra2.mitra.RealLiteral;
import de.jevopi.mitra2.mitra.ReferenceType;
import de.jevopi.mitra2.mitra.ReturnParameter;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.RuleInvocation;
import de.jevopi.mitra2.mitra.RuleInvocationSuper;
import de.jevopi.mitra2.mitra.SimpleParameterReference;
import de.jevopi.mitra2.mitra.SimpleRuleReference;
import de.jevopi.mitra2.mitra.StringLiteral;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.VarDeclaration;
import de.jevopi.mitra2.mitra.VariableAccess;
import de.jevopi.mitra2.mitra.VisibilityModifier;

/**
 * ToString There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 */
public class ToString {

	public static String valueOf(String s) {
		return String.valueOf(s);
	}

	public static String valueOf(Module module) {
		StringBuilder strb = new StringBuilder();
		strb.append("Module ");
		if (module.getPackageName()!=null) {
			strb.append(module.getPackageName()).append(':');
		}
		strb.append(valueOf(module.getName()));
		if (module.eResource()!=null) {
			strb.append(" (");
			strb.append(module.eResource().getURI());
			strb.append(")");
		}
		return strb.toString();
	}
	
	public static String valueOf(MetamodelDeclaration md) {
		StringBuilder strb = new StringBuilder();
		strb.append("MetamodelDeclaration ");
		strb.append(md.getType()).append(" ").append(md.getName()).append(md.getProperties());
		return strb.toString();
	}
	
	public static String valueOf(Property property) {
		StringBuilder strb = new StringBuilder();
		strb.append(property.getName()).append('=');
		strb.append('"').append(property.getValue()).append('"');
		return strb.toString();
	}

	public static String valueOf(RuleDeclaration decl) {

		StringBuilder result = new StringBuilder();
		if (decl.getVisibility() != VisibilityModifier.PUBLIC) {
			result.append(decl.getVisibility().getName());
			result.append(" ");
		}
		if (decl.isVirtual()) {
			result.append("virtual ");
		}
		if (decl.getExec() == ExecutionModifier.ABSTRACT) {
			result.append("abstract ");
		}
		result.append(decl.getName());
		result.append("(");
		boolean bFirst = true;
		for (FormalParameter formalParameter : decl.getFormalParameters()) {
			if (!bFirst)
				result.append(", ");
			else
				bFirst = false;
			result.append(formalParameter.getVardecl().getType());
		}
		result.append(")");

		if (decl.getReturnParameters().size() > 0) {

			result.append(":(");
			bFirst = true;
			for (ReturnParameter returnParameter : decl.getReturnParameters()) {
				if (!bFirst)
					result.append(", ");
				else
					bFirst = false;
				result.append(returnParameter.getVardecl().getType());
			}
			result.append(")");
		}

		if (decl.getJavaSpec() != null) {
			result.append(" java");
		}
		return result.toString();
	}

	/**
	 * Emits a type, i.e. creates a string from a type.
	 * 
	 * @param type
	 * @return
	 */
	public static String valueOf(Type type) {
		if (type==null) return "null";
		
		StringBuilder result = new StringBuilder();
		if (type instanceof PrimitiveType) {
			result.append(((PrimitiveType) type).getPrimitiveType().getName());
		} else if (type instanceof ReferenceType) {

			ReferenceTypeImpl rtype = (ReferenceTypeImpl) type;

			if (rtype.basicGetMetamodelDeclaration().eIsProxy()) {
				result.append("??");
			} else {
				result.append(((ReferenceType) type).getMetamodelDeclaration()
					.getName());
			}
			result.append("::");

			if (rtype.basicGetEClassifier().eIsProxy()) {
				result.append("??");
			} else {
				result
					.append(((ReferenceType) type).getEClassifier().getName());
			}
		} else if (type instanceof CollectionType) {
			CollectionType collectionType = (CollectionType) type;
			result.append(collectionType.getCollectionType());
			result.append("(");
			result.append(valueOf(collectionType.getTypePar()));
			result.append(")");
		} else {
			result.append(type.getClass());
		}

		return result.toString();
	}

	/**
	 * Emits a parameter object, i.e. creates a string from bounds.
	 * 
	 * @param type
	 * @return
	 */
	public static String valueOf(Parameter par) {
		StringBuilder result = new StringBuilder();

		result.append(ToString.valueOf(par.getVardecl()));

		return result.toString();
	}

	public static String valueOf(VarDeclaration varDecl) {
		return valueOf(varDecl.getType()) + " " + varDecl.getName();
	}

	/**
	 * Emits a bounds object, i.e. creates a string from bounds.
	 * 
	 * @param type
	 * @return
	 */
	public static String valueOf(FormalParameter par) {
		StringBuilder result = new StringBuilder();

		if (par.getModifier() != null
			&& par.getModifier() != ParameterModifier.USE)
			result.append(par.getModifier()).append(" ");

		result.append(valueOf(par.getVardecl()));

		return result.toString();
	}

	/**
	 * Emits a bounds object, i.e. creates a string from bounds.
	 * 
	 * @param type
	 * @return
	 */
	public static String valueOf(ReturnParameter par) {
		StringBuilder result = new StringBuilder();
		result.append(valueOf(par.getVardecl()));
		return result.toString();
	}

	public static String valueOf(RuleInvocation ruleInvocation) {

		StringBuilder result = new StringBuilder();
		if (!((RuleInvocationImpl) ruleInvocation).basicGetRuleDeclaration()
			.eIsProxy()) {
			result.append(ruleInvocation.getRuleDeclaration().getName())
				.append("(..)");
		} else {
			result.append("?(..)");
		}
		return result.toString();

	}

	public static String valueOf(@SuppressWarnings("unused") RuleInvocationSuper invocationSuper) {
		StringBuilder result = new StringBuilder();
		result.append("super");
		return result.toString();

	}

	/**
	 * Emits a feature access object, i.e. creates a string from
	 * {@link FeatureAccess}.
	 * 
	 * @param variableAccess
	 * @return
	 */
	public static String valueOf(VariableAccess variableAccess) {
		StringBuilder result = new StringBuilder();

		if (variableAccess.getPrefixOperator() != null) {
			result.append(variableAccess.getPrefixOperator().getLiteral());
		}

		result.append(variableAccess.getVariable().getName());

		for (Feature feature : variableAccess.getFeatures()) {

			if (feature instanceof NativeOperationInvocation)
				result.append("->");
			else
				result.append(".");

			if (feature.getName() != null)
				result.append(feature.getName());
			else {
				result.append("<<..>>");
			}

		}

		if (variableAccess.getPostfixOperator() != null) {
			result.append(variableAccess.getPostfixOperator().getLiteral());
		}

		return result.toString();
	}

	/**
	 * Emits a feature object, i.e. creates a string from {@link Feature}.
	 * 
	 * @param feature
	 * @return
	 */
	public static String valueOf(Feature feature) {
		StringBuilder result = new StringBuilder();
		result.append(feature.getName());
		return result.toString();
	}

	public static String valueOf(QualifiedRuleReference ruleReference) {
		StringBuilder result = new StringBuilder();
		if (((QualifiedRuleReferenceImpl) ruleReference)
			.basicGetRuleDeclaration().eIsProxy()) {
			result.append("?");
		} else {
			result.append(ruleReference.getRuleDeclaration().getName());
		}
		result.append("(");
		boolean bFirst = true;
		for (ParameterReference pref : ruleReference.getParameterReferences()) {
			if (!bFirst)
				result.append(", ");
			else
				bFirst = false;
			result.append(ToString.valueOf(pref));
		}
		result.append(")");
		if (!ruleReference.getReturnReferences().isEmpty()) {
			result.append(": (");
			bFirst = true;
			for (ParameterReference pref : ruleReference.getReturnReferences()) {
				if (!bFirst)
					result.append(", ");
				else
					bFirst = false;
				result.append(ToString.valueOf(pref));
			}
			result.append(")");
		}
		return result.toString();
	}

	public static String valueOf(SimpleRuleReference ruleReference) {
		StringBuilder result = new StringBuilder();
		if (((SimpleRuleReferenceImpl) ruleReference).basicGetRuleDeclaration()
			.eIsProxy()) {
			result.append("?");
		} else {
			result.append(ruleReference.getRuleDeclaration().getName());
		}
		result.append("(");
		boolean bFirst = true;
		for (ParameterReference pref : ruleReference.getParameterReferences()) {
			if (!bFirst)
				result.append(", ");
			else
				bFirst = false;
			result.append(ToString.valueOf(pref));
		}
		result.append(")");
		if (!ruleReference.getReturnReferences().isEmpty()) {
			result.append(": (");
			bFirst = true;
			for (ParameterReference pref : ruleReference.getReturnReferences()) {
				if (!bFirst)
					result.append(", ");
				else
					bFirst = false;
				result.append(ToString.valueOf(pref));
			}
			result.append(")");
		}
		return result.toString();
	}

	public static String valueOf(ParameterReference parameterReference) {
		if (parameterReference instanceof QualifiedParameterReference) {
			return valueOf((QualifiedParameterReference) parameterReference);
		} else {
			return valueOf((SimpleParameterReference) parameterReference);
		}
	}

	public static String valueOf(
			QualifiedParameterReference qualifiedParameterReference) {
		StringBuilder result = new StringBuilder();
		result
			.append(ToString.valueOf(qualifiedParameterReference.getVardecl()));
		return result.toString();
	}

	public static String valueOf(
			SimpleParameterReference simpleParameterReference) {
		StringBuilder result = new StringBuilder();
		result.append(ToString.valueOf(simpleParameterReference.getType()));
		if (simpleParameterReference.getName() != null)
			result.append(" ").append(simpleParameterReference.getName());
		return result.toString();
	}

	public static String valueOf(IntLiteral intLiteral) {
		return String.valueOf(intLiteral.getIntValue());
	}

	public static String valueOf(RealLiteral realLiteral) {
		return String.valueOf(realLiteral.getFloatValue()) + "f";
	}

	public static String valueOf(StringLiteral stringLiteral) {
		return '"' + String.valueOf(stringLiteral.getStringValue()) + '"';
	}

	public static String valueOf(BooleanLiteral booleanLiteral) {
		return String.valueOf(booleanLiteral.isBooleanValue());
	}

	
}
