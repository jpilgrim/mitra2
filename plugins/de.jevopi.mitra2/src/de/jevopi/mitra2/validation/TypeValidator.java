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

import static de.jevopi.mitra2.message.ValidationMessageAcceptorAdapter.toStringArray;
import static de.jevopi.mitra2.metamodel.PrimitiveMetamodel.ANY;
import static de.jevopi.mitra2.metamodel.PrimitiveMetamodel.ANY_NULL;
import static java.util.Arrays.asList;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.engine.TypeResolver;
import de.jevopi.mitra2.message.IMessageAcceptor.Level;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.mitra.Assignment;
import de.jevopi.mitra2.mitra.AssignmentOperator;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.EqualityExpression;
import de.jevopi.mitra2.mitra.Expression;
import de.jevopi.mitra2.mitra.ForStatement;
import de.jevopi.mitra2.mitra.InferredVarDeclaration;
import de.jevopi.mitra2.mitra.InstanceOfExpression;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.LocalVariableDeclaration;
import de.jevopi.mitra2.mitra.LoopVariable;
import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.NativeOperationInvocation;
import de.jevopi.mitra2.mitra.RelationalExpression;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.VariableAccess;
import de.jevopi.mitra2.nativeoperations.INativeOperation;
import de.jevopi.mitra2.nativeoperations.INativeOperation.InvocationType;

/**
 * Type Validator
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 7, 2012
 */
public class TypeValidator extends TypeResolver {

	protected ValidationMessageAcceptor acceptor;

	/**
	 * @param i_context
	 * @param i_validate
	 */
	public TypeValidator(ProjectContext projectContext,
			ValidationMessageAcceptor acceptor) {
		super(projectContext);
		this.acceptor = acceptor;
	}

	@Override
	public void message(Level level, String message, EObject astElement,
			EStructuralFeature structuralFeature, int index, Throwable ex,
			String code, String... issueData) {
		super.message(level, message, astElement, structuralFeature, index, ex,
				code, issueData);
		if (acceptor != null) {
			switch (level) {
			case ERROR:
			case RUNTIME_ERROR:
				acceptor.acceptError(message, astElement, structuralFeature,
						index, code, toStringArray(issueData));
				break;
			case WARNING:
			case RUNTIME_WARNING:
				acceptor.acceptWarning(message, astElement, structuralFeature,
						index, code, toStringArray(issueData));
			}
		}
	}

	/**
	 * @see de.jevopi.mitra2.engine.TypeResolver#caseAssignment(de.jevopi.mitra2.mitra.Assignment)
	 */
	@Override
	public Type[] caseAssignment(Assignment assignment) {

		Type[] typesRight = visit(assignment.getExpression());

		Type[] typesLeft = new Type[assignment.getLhs().size()];
		int i = 0;
		Type[] types;
		for (VariableAccess variableAccess : assignment.getLhs()) {
			types = visit(variableAccess);
			if (types.length != 1) {
				error("Expected feature access returning one object (i.e. actualtype), found "
					+ types.length,
						assignment.getLhs().get(i),
						assignment.eClass().getEStructuralFeature(
								MitraPackage.ASSIGNMENT__LHS), i);
			}
			if (types[0] == null) {
				VariableAccess fa = assignment.getLhs().get(i);
				String strType = String.valueOf(fa);
				error("Type of " + strType + " could not be determined.",
						assignment.getLhs().get(i),
						assignment.eClass().getEStructuralFeature(
								MitraPackage.ASSIGNMENT__LHS), i);
			}
			typesLeft[i] = types[0];
			i++;
		}

		validateAssignment(typesRight, typesLeft, assignment.getOperator(),
				assignment, MitraPackage.ASSIGNMENT__EXPRESSION);

		return typesRight;

	}

	protected void validateAssignment(Type[] typesRight, Type[] typesLeft,
			AssignmentOperator i_assignmentOperator, EObject location,
			int featureID) {

		if (typesLeft.length != typesRight.length) {
			error("Cannot assign " + typesRight.length + " values to "
				+ typesLeft.length + " variables", location, location.eClass()
				.getEStructuralFeature(featureID), -1);
		}

		MetamodelManager metamodelManager = getMetamodelManager();
		for (int j = 0; j < typesRight.length; j++) {
			Type typeLeft = typesLeft[j];
			Type typeRight = typesRight[j];

			if (!( //
			((typeRight == ANY_NULL && i_assignmentOperator == AssignmentOperator.SET) // 
			|| metamodelManager.isSubType(typeRight, typeLeft)))) {
				error("Type mismatch: cannot convert from " + typeRight
					+ " to " + typeLeft, location, location.eClass()
					.getEStructuralFeature(featureID), -1);
			}
		}
	}

	@Override
	public Type[] caseInferredVarDeclaration(
			InferredVarDeclaration inferredVarDeclaration) {
		Type type = inferredVarDeclaration.getType();

		LoopVariable loopVariable =
			(LoopVariable) inferredVarDeclaration.eContainer();

		if (type == null
			&& !(loopVariable.eContainer() instanceof ForStatement)
			&& !(loopVariable.eContainer() instanceof IteratorExpression)) {
			error("Type specification of a variable declaration can only be omitted in for statements and iterator expressions",
					inferredVarDeclaration);
		}

		Type inferredType = inferType(loopVariable);

		if (type != null
			&& !getMetamodelManager().isSubType(type, inferredType)) {
			warning("Declared iterator type " + type + " is no subtype of "
				+ inferredType, inferredVarDeclaration);
		}

		if (type == null) type = inferredType;

		return new Type[] {
			type
		};
	}

	@Override
	protected Type resolveTypeOfNativeOperation(Type receiverType,
			NativeOperationInvocation nativeOperationInvocation) {

		INativeOperation nativeOperation =
			getNativeOperationResolver().getNativeOperations().get(
					nativeOperationInvocation.getName());
		if (nativeOperation == null) {
			error("No native operation " + nativeOperationInvocation.getName()
				+ " found", nativeOperationInvocation);
			return ANY;
		}
		if (!nativeOperation.acceptReceiver(receiverType)) {
			error("Native operation " + nativeOperationInvocation.getName()
				+ " not defined for receiver type " + receiverType,
					nativeOperationInvocation);
			return ANY;
		}

		return super.resolveTypeOfNativeOperation(receiverType,
				nativeOperationInvocation);
	}

	@Override
	protected Type resolveTypeOfNativeOperationWithIteratorExpression(
			INativeOperation nativeOperation, Type receiverType,
			IteratorExpression iteratorExpression) {

		if (nativeOperation.getInvocationType() != InvocationType.ITERATOR) {
			error("Native operation " + nativeOperation.getName()
				+ " does not support iterator expressions.",
					iteratorExpression);
			return ANY;
		}

		Type loopVarType =
			visitSingleton(iteratorExpression.getVariable().getVardecl());
		Type iteratorExpressionType =
			visitSingleton(iteratorExpression.getExpression());

		if (!nativeOperation.acceptIteratorExpressionTypes(receiverType,
				loopVarType, iteratorExpressionType)) {
			error("Native operation " + nativeOperation.getName()
				+ " not compatible to " + receiverType + " with loop variable "
				+ loopVarType + " and expression type "
				+ iteratorExpressionType, iteratorExpression);
			return ANY;
		}

		return super.resolveTypeOfNativeOperationWithIteratorExpression(
				nativeOperation, receiverType, iteratorExpression);
	}

	@Override
	protected Type resolveTypeOfNativeOperationWithArguments(
			INativeOperation nativeOperation, Type receiverType,
			EList<Expression> arguments,
			NativeOperationInvocation nativeOperationInvocation) {

		List<Type> argumentTypes = asList(visitList(arguments));
		if (!nativeOperation.acceptArgumentCallTypes(receiverType,
				argumentTypes)) {
			error("Native operation " + nativeOperation.getName()
				+ " does not support receiver type " + receiverType
				+ " and argument types " + argumentTypes,
					nativeOperationInvocation);
			return ANY;
		}

		return super.resolveTypeOfNativeOperationWithArguments(nativeOperation,
				receiverType, arguments, nativeOperationInvocation);
	}

	/**
	 * @see de.jevopi.mitra2.engine.TypeResolver#caseIteratorExpression(de.jevopi.mitra2.mitra.IteratorExpression)
	 */
	@Override
	public Type[]
			caseIteratorExpression(IteratorExpression i_iteratorExpression) {

		if (!(i_iteratorExpression.eContainer() instanceof NativeOperationInvocation)) {
			error("Iterative expressions are only allowed in certain native oparations.",
					i_iteratorExpression);
			return TypeResolver.A_ANY;
		}

		NativeOperationInvocation nativeOperationInvocation =
			(NativeOperationInvocation) i_iteratorExpression.eContainer();
		if (nativeOperationInvocation.getArguments().size() != 1) {
			error("Only one iterator expression allowed", i_iteratorExpression);
		}

		// type of loop variable must equal receiver's element types
		Type receiverType = resolveReceiverType(nativeOperationInvocation);
		Type receiverElementType = receiverType; // default for singletonList
		if (receiverType instanceof CollectionType) {
			receiverElementType = ((CollectionType) receiverType).getTypePar();
		}
		Type loopVariableType =
			caseVarDeclaration(i_iteratorExpression.getVariable().getVardecl())[0];

		if (!getMetamodelManager().isSubType(loopVariableType,
				receiverElementType)) {
			error("Type mismatch: cannot convert from " + receiverElementType
				+ " to " + loopVariableType,
					i_iteratorExpression.getVariable());
		}

		return visit(i_iteratorExpression.getExpression());
	}

	/**
	 * @see de.jevopi.mitra2.engine.TypeResolver#caseLocalVariableDeclaration(de.jevopi.mitra2.mitra.LocalVariableDeclaration)
	 */
	@Override
	public Type[] caseLocalVariableDeclaration(
			LocalVariableDeclaration i_localVariableDeclaration) {

		Type[] typesVarDecl =
			super.caseLocalVariableDeclaration(i_localVariableDeclaration);

		if (i_localVariableDeclaration.getExpression() != null) {
			Type[] typesRight =
				visit(i_localVariableDeclaration.getExpression());
			validateAssignment(typesVarDecl, typesRight,
					AssignmentOperator.SET, i_localVariableDeclaration,
					MitraPackage.LOCAL_VARIABLE_DECLARATION__EXPRESSION);

		}

		return typesVarDecl;
	}

	/**
	 * Left type must be (non-reflexive) super type of right type, otherwise a
	 * warning is emitted because the result will be constantly true or false.
	 * 
	 * @param instanceOfExpression
	 * @return
	 */
	@Override
	public Type[] caseInstanceOfExpression(
			InstanceOfExpression instanceOfExpression) {

		Type[] result = super.caseInstanceOfExpression(instanceOfExpression);
		Type[] typesLeft = visit(instanceOfExpression.getExpression());
		if (typesLeft.length != 1) {
			error("Expression must return one object",
					instanceOfExpression.getExpression());
			return result;
		}

		Type typeLeft = typesLeft[0];
		Type typeRight = instanceOfExpression.getType();

		if (typeLeft.equals(typeRight)) {
			warning("Types are equal, instanceof will always return true",
					instanceOfExpression);
		} else if (getMetamodelManager().isSubType(typeLeft, typeRight)) {
			warning("The expression of type " + typeLeft
				+ " is already an instance of type " + typeRight
				+ ", instanceof will always return true", instanceOfExpression);
		} else if (!getMetamodelManager().isCompatible(typeRight, typeLeft)) {
			warning("Incompatible instanceof operand types " + typeLeft
				+ " and " + typeRight + ", instanceof will always return false",
					instanceOfExpression);
		}

		return result;
	}

	@Override
	public Type[] caseEqualityExpression(EqualityExpression equalityExpression) {
		Type[] result = super.caseEqualityExpression(equalityExpression);
		validateTypeCompatibility(equalityExpression.getLhs(),
				equalityExpression.getRhs(), equalityExpression, false);
		return result;
	}

	@Override
	public Type[] caseRelationalExpression(
			RelationalExpression relationalExpression) {
		Type[] result = super.caseRelationalExpression(relationalExpression);
		validateTypeCompatibility(relationalExpression.getLhs(),
				relationalExpression.getRhs(), relationalExpression, true);
		return result;
	}

	protected boolean validateTypeCompatibility(Expression left,
			Expression right, Expression location,
			boolean typesOrdered) {
		Type[] typesLeft = visit(left);
		Type[] typesRight = visit(right);

		if (typesLeft.length != typesRight.length) {
			error("Cannot compare " + typesLeft.length + " with "
				+ typesRight.length + " arguments", location);
			return false;
		}

		MetamodelManager metamodelManager = getMetamodelManager();
		boolean result = true;
		for (int i = 0; i < typesLeft.length; i++) {
			if (!metamodelManager.isCompatible(typesLeft[i], typesRight[i])) {
				error("Incompatible operand types " + typesLeft[i] + " and "
					+ typesRight[i], location);
				result = false;
			}
			if (typesOrdered
				&& !metamodelManager.isComparable(typesLeft[i], typesRight[i])) {
				error("No total order defined on types " + typesLeft[i]
					+ " and " + typesRight[i], location);
				result = false;
			}
		}

		return result;
	}

}
