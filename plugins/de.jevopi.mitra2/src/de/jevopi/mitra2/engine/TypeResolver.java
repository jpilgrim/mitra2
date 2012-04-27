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

import static de.jevopi.mitra2.MitraIssueCodes.FEATURE_FIELD_NOT_FOUND;
import static de.jevopi.mitra2.MitraIssueCodes.FEATURE_METHOD_NOT_FOUND;
import static de.jevopi.mitra2.metamodel.PrimitiveMetamodel.ANY;
import static de.jevopi.mitra2.metamodel.PrimitiveMetamodel.isString;
import static de.jevopi.mitra2.mitra.MitraPackage.FEATURE_METHOD_INVOCATION__ARGUMENTS;
import static de.jevopi.mitra2.mitra.MitraPackage.UNARY_MATH_EXPRESSION__OP;
import static de.jevopi.utils.Filter.FilterResult.ACCEPT;
import static de.jevopi.utils.Filter.FilterResult.ACCEPT_AND_STOP;
import static de.jevopi.utils.Filter.FilterResult.SKIP_AND_STOP;
import static de.jevopi.utils.FilteredIterable.select;
import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.context.ContextAwareTraversingVisitor;
import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.engine.interpreter.MObjectAccessPolicy;
import de.jevopi.mitra2.metamodel.FeatureDescription;
import de.jevopi.mitra2.metamodel.FeatureFieldDescription;
import de.jevopi.mitra2.metamodel.FeatureMethodDescription;
import de.jevopi.mitra2.metamodel.IMetamodel;
import de.jevopi.mitra2.metamodel.MetamodelManager.MetamodelNotFoundException;
import de.jevopi.mitra2.metamodel.PrimitiveMetamodel;
import de.jevopi.mitra2.mitra.Assignment;
import de.jevopi.mitra2.mitra.Block;
import de.jevopi.mitra2.mitra.BooleanExpression;
import de.jevopi.mitra2.mitra.BooleanLiteral;
import de.jevopi.mitra2.mitra.ClassInstanceCreationExpression;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.DoStatement;
import de.jevopi.mitra2.mitra.EqualityExpression;
import de.jevopi.mitra2.mitra.Expression;
import de.jevopi.mitra2.mitra.Feature;
import de.jevopi.mitra2.mitra.FeatureField;
import de.jevopi.mitra2.mitra.FeatureMethodInvocation;
import de.jevopi.mitra2.mitra.ForStatement;
import de.jevopi.mitra2.mitra.IfStatement;
import de.jevopi.mitra2.mitra.InferredVarDeclaration;
import de.jevopi.mitra2.mitra.InstanceOfExpression;
import de.jevopi.mitra2.mitra.IntLiteral;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.LocalVariableDeclaration;
import de.jevopi.mitra2.mitra.LoopVariable;
import de.jevopi.mitra2.mitra.MathExpression;
import de.jevopi.mitra2.mitra.MethodInvocation;
import de.jevopi.mitra2.mitra.NativeOperationInvocation;
import de.jevopi.mitra2.mitra.NullLiteral;
import de.jevopi.mitra2.mitra.PrimitiveType;
import de.jevopi.mitra2.mitra.RealLiteral;
import de.jevopi.mitra2.mitra.RelationalExpression;
import de.jevopi.mitra2.mitra.ReturnStatement;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.RuleInvocationSuper;
import de.jevopi.mitra2.mitra.StaticAccess;
import de.jevopi.mitra2.mitra.StringLiteral;
import de.jevopi.mitra2.mitra.Trigger;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.TypedVarDeclaration;
import de.jevopi.mitra2.mitra.UnaryBooleanExpression;
import de.jevopi.mitra2.mitra.UnaryCastExpression;
import de.jevopi.mitra2.mitra.UnaryMathExpression;
import de.jevopi.mitra2.mitra.VarDeclaration;
import de.jevopi.mitra2.mitra.VariableAccess;
import de.jevopi.mitra2.mitra.WhileStatement;
import de.jevopi.mitra2.mitra.util.MitraSwitch;
import de.jevopi.mitra2.nativeoperations.INativeOperation;
import de.jevopi.mitra2.nativeoperations.NativeOperationResolver;
import de.jevopi.utils.Filter;
import de.jevopi.utils.Filter.FilterResult;
import de.jevopi.utils.StringUtils;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 */
public class TypeResolver extends ContextAwareTraversingVisitor<Type[]> {
	/**
	 * Logger for this class
	 */
	// @SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger log = Logger.getLogger(TypeResolver.class
		.getName());

	/**
	 * This switch is to be called with the container of a rule invocation to
	 * compute the type required by the rule invocation, see
	 * {@link TypeResolver#computeTypeOfRuleInvocationAtPosition(EObject)}.
	 */
	public static class ReturnTypeOfRuleSwitch extends MitraSwitch<Type[]> {
		TypeResolver typeResolver;

		public ReturnTypeOfRuleSwitch(TypeResolver typeResolver) {
			this.typeResolver = typeResolver;
		}

		@Override
		public Type[] defaultCase(EObject object) {
			return new Type[0];
		}

		@Override
		public Type[] caseAssignment(Assignment object) {
			return typeResolver.visitList(object.getLhs());
		}

		@Override
		public Type[] caseLocalVariableDeclaration(
				LocalVariableDeclaration object) {
			return typeResolver.visit(object.getVardecl());
		}

		@Override
		public Type[] caseIfStatement(IfStatement object) {
			return A_BOOLEAN;
		}

		@Override
		public Type[] caseDoStatement(DoStatement object) {
			return A_BOOLEAN;
		}

		@Override
		public Type[] caseWhileStatement(WhileStatement object) {
			return A_BOOLEAN;
		}

		@Override
		public Type[] caseReturnStatement(ReturnStatement object) {
			return typeResolver.visitList(MitraUtils.retrieveContainingRule(
					object).getReturnParameters());
		}
	}

	/**
	 * Used when evaluating variable access with native operation calls.
	 * Instance is lazily created in {@link #getnativeOperationResolver()}.
	 */
	protected NativeOperationResolver nativeOperationResolver = null;

	protected final static Type[] A_VOID = new Type[] {
		PrimitiveMetamodel.VOID
	};

	protected final static Type[] A_BOOLEAN = new Type[] {
		PrimitiveMetamodel.BOOLEAN
	};

	protected final static Type[] A_REAL = new Type[] {
		PrimitiveMetamodel.REAL
	};

	protected final static Type[] A_INT = new Type[] {
		PrimitiveMetamodel.INT
	};

	protected final static Type[] A_STRING = new Type[] {
		PrimitiveMetamodel.STRING
	};

	protected final static Type[] A_ANY = new Type[] {
		PrimitiveMetamodel.ANY
	};

	protected final static Type[] A_NULL = new Type[] {
		PrimitiveMetamodel.ANY_NULL
	};

	public TypeResolver(ProjectContext projectContext) {
		super(projectContext, A_VOID);
	}

	/**
	 * Convenience method, as {@link VarDeclaration#getType()} may return null
	 * in case of {@link InferredVarDeclaration}.
	 * 
	 * @param varDeclaration
	 * @return
	 */
	public Type getType(VarDeclaration varDeclaration) {
		Type type = varDeclaration.getType();
		if (type == null && varDeclaration instanceof InferredVarDeclaration) {
			type =
				caseInferredVarDeclaration((InferredVarDeclaration) varDeclaration)[0];
		}
		return type;
	}

	/**
	 * Evaluates a list of eobjects, typically arguments. This method is not
	 * 
	 */
	public Type[] visitList(List<? extends EObject> eobjects) {
		Type[] argumentTypes = new Type[eobjects.size()];
		int i = 0;
		for (EObject argument : eobjects) {
			Type[] argType = visit(argument);
			if (argType.length != 1) {
				error("Each argument must contain one object, were "
					+ argType.length, argument, argument.eContainingFeature(),
						i);
				if (argType.length > 1) {
					argumentTypes[i] = argType[0];
				} else {
					argumentTypes[i] = PrimitiveMetamodel.ANY;
				}
			} else {
				argumentTypes[i] = argType[0];
			}
			i++;
		}
		return argumentTypes;
	}

	/**
	 * Similar to {@link #visit(EObject)}, expecting only one element to be
	 * returned.
	 * 
	 * @param eobject
	 * @return
	 */
	public Type visitSingleton(EObject eobject) {
		Type[] types = visit(eobject);
		if (types.length != 1) {
			error("Expected one object returned, retrieved " + types.length,
					eobject);
		}
		return types[0];
	}

	/**
	 * Blocks are ignored, as they do not return anything
	 * 
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseBlock(de.feu.mitra.Block)
	 */
	@Override
	public Type[] caseBlock(Block block) {
		return getDefaultReturnValue();
	}

	/**
	 * {@inheritDoc} Sets rule declaration matching the name and types specified
	 * in the invocation. This declaration may be an overloaded, i.e. during
	 * execution, an overloading rule is actually called.
	 * 
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseRuleInvocationByName(de.feu.mitra.RuleInvocationByName)
	 */
	@Override
	public Type[] caseRuleInvocation(
			de.jevopi.mitra2.mitra.RuleInvocation ruleInvocation) {
		Type[] argTypes = new Type[ruleInvocation.getArguments().size()];

		// resolve argument types
		for (int i = 0; i < argTypes.length; i++) {
			Expression argumentExpression =
				ruleInvocation.getArguments().get(i);
			Type[] types = visit(argumentExpression);
			if (types == A_VOID) {
				warning("Cannot use void expression in rule " + ruleInvocation,
						argumentExpression,
						argumentExpression.eContainingFeature(), i);
			}
			if (types.length != 1) {
				error("Argument contains "
					+ types.length
					+ " objects (probably a rule invocation), can handle only a single object",
						argumentExpression,
						argumentExpression.eContainingFeature(), i);
				return A_VOID;
			}
			argTypes[i] = types[0];
		}

		RuleDeclaration decl = ruleInvocation.getRuleDeclaration();

		if (decl == null) {
			StringBuilder tr = new StringBuilder();
			for (Type type : argTypes) {
				if (tr.length() != 0) {
					tr.append(", ");
				}
				tr.append(String.valueOf(type));
			}
			error("Cannot resolve rule " + ruleInvocation + " for types "
				+ tr.toString(), ruleInvocation);
			return A_VOID;
		}

		if (decl.getReturnParameters().size() == 0) {
			return A_VOID;
		}

		Type[] returnTypes = new Type[decl.getReturnParameters().size()];
		for (int i = 0; i < returnTypes.length; i++) {
			returnTypes[i] =
				getType(decl.getReturnParameters().get(i).getVardecl());
		}
		return returnTypes;
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseRuleInvocationSuper(de.feu.mitra.RuleInvocationSuper)
	 */
	@Override
	public Type[] caseRuleInvocationSuper(
			RuleInvocationSuper ruleInvocationSuper) {
		RuleDeclaration decl =
			MitraUtils.retrieveContainingRule(ruleInvocationSuper);

		if (decl == null) {
			error("Cannot retrieve rule declaration for super invocation",
					ruleInvocationSuper);
			return A_VOID;
		}

		RuleDeclaration superDecl =
			decl.getOverriddenRule().getRuleDeclaration();
		if (superDecl == null) {
			error("Cannot call super rule, rule is not overriding a rule",
					ruleInvocationSuper);
			return A_VOID;
		}

		if (superDecl.getReturnParameters().size() == 0) {
			return A_VOID;
		}
		Type[] returnTypes = new Type[superDecl.getReturnParameters().size()];
		for (int i = 0; i < returnTypes.length; i++) {
			returnTypes[i] =
				getType(decl.getReturnParameters().get(i).getVardecl());
		}
		return returnTypes;

	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseAssignment(de.feu.mitra.Assignment)
	 */
	@Override
	public Type[] caseAssignment(Assignment assignment) {
		Type[] typesRight = visit(assignment.getExpression());
		return typesRight;
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseLocalVariableDeclaration(de.feu.mitra.LocalVariableDeclaration)
	 */
	@Override
	public Type[] caseLocalVariableDeclaration(
			LocalVariableDeclaration localVariableDeclaration) {
		return visit(localVariableDeclaration.getVardecl());
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseVarDeclaration(de.jevopi.mitra2.mitra.VarDeclaration)
	 * @since Feb 6, 2012
	 */
	@Override
	public Type[] caseVarDeclaration(VarDeclaration varDeclaration) {
		return new Type[] {
			getType(varDeclaration)
		};
	}

	/**
	 * {@inheritDoc} Only inside a loop variable, which is defined either in
	 * (for-each styled) for statement, or iterator expression.
	 * 
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseInferredVarDeclaration(de.jevopi.mitra2.mitra.InferredVarDeclaration)
	 */
	@Override
	public Type[] caseInferredVarDeclaration(
			InferredVarDeclaration inferredVarDeclaration) {
		Type type = inferredVarDeclaration.getType();
		if (type == null) {
			LoopVariable loopVariable =
				(LoopVariable) inferredVarDeclaration.eContainer();
			type = inferType(loopVariable);
		}
		return new Type[] {
			type
		};
	}

	/**
	 * @param loopVariable
	 * @return inferred type or ANY, if type cannot be inferred
	 */
	protected Type inferType(LoopVariable loopVariable) {
		Type inferredType = ANY;
		if (loopVariable.eContainer() instanceof ForStatement) {
			Expression expression =
				((ForStatement) loopVariable.eContainer()).getExpression();
			inferredType = visit(expression)[0];
		} else if (loopVariable.eContainer() instanceof IteratorExpression) {
			IteratorExpression iteratorExpression =
				(IteratorExpression) loopVariable.eContainer();
			if (iteratorExpression.eContainer() instanceof NativeOperationInvocation) {

				// iterator expressions are only allowed in native operations,
				// we need the receiver type of the invocation:
				NativeOperationInvocation nativeOperationInvocation =
					(NativeOperationInvocation) loopVariable.eContainer()
						.eContainer();

				Type receiverType =
					resolveReceiverType(nativeOperationInvocation);
				if (receiverType instanceof CollectionType) {
					inferredType = ((CollectionType) receiverType).getTypePar();
				} else {
					inferredType = receiverType;
				}
			}

		} else {
			log.warning("Inferred variable declaration in unknown context: "
				+ loopVariable.eContainer());
		}

		if (inferredType instanceof CollectionType) {
			inferredType = ((CollectionType) inferredType).getTypePar();
		}
		return inferredType;
	}

	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseTypedVarDeclaration(de.jevopi.mitra2.mitra.TypedVarDeclaration)
	 */
	@Override
	public Type[] caseTypedVarDeclaration(
			TypedVarDeclaration typedVarDeclaration) {
		return new Type[] {
			typedVarDeclaration.getType()
		};
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseEqualityExpression(de.feu.mitra.EqualityExpression)
	 */
	@Override
	public Type[] caseEqualityExpression(EqualityExpression equalityExpression) {
		return A_BOOLEAN;
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseMathExpression(de.feu.mitra.MathExpression)
	 */
	@Override
	public Type[] caseMathExpression(MathExpression mathExpression) {
		Type typeLeft = visitSingleton(mathExpression.getLhs());
		Type typeRight = visitSingleton(mathExpression.getRhs());

		if (typeLeft == null && typeRight == null) {
			return A_INT;
		}

		// for type resolving, we can savely set null to the other type
		if (typeLeft == null) typeLeft = typeRight;
		if (typeRight == null) typeRight = typeLeft;

		if (typeLeft instanceof PrimitiveType
			&& typeRight instanceof PrimitiveType
			&& (isString(typeLeft) || isString(typeRight))) {
			return A_STRING;
		}

		if (isIntCompatible(typeRight)) {
			if (!isIntCompatible(typeLeft)) {
				error("Cannot convert from " + typeLeft + " to " + typeRight,
						mathExpression.getRhs());
			}
		} else if (isStringCompatible(typeRight)) {
			if (!isStringCompatible(typeLeft)) {
				error("Cannot convert from " + typeLeft + " to " + typeRight,
						mathExpression.getRhs());
			}
		} else {
			error("Cannot add " + typeLeft + " with " + typeRight,
					mathExpression.getRhs());
		}

		return new Type[] {
			typeRight
		};
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseRelationalExpression(de.feu.mitra.RelationalExpression)
	 */
	@Override
	public Type[] caseRelationalExpression(
			RelationalExpression relationalExpression) {
		return A_BOOLEAN;
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseUnaryMathExpression(de.feu.mitra.UnaryMathExpression)
	 */
	@Override
	public Type[] caseUnaryMathExpression(
			UnaryMathExpression unaryMathExpression) {
		Type[] types = visit(unaryMathExpression.getExpression());
		try {
			if (types.length != 1) {
				error("Unary math expression requires one object, were "
					+ types.length, unaryMathExpression);
				return A_INT;
			}

			if (!isIntCompatible(types[0])) {
				error("Cannot apply operator "
					+ unaryMathExpression.getOp().getLiteral()
					+ " on actual type " + types[0],
						unaryMathExpression,
						unaryMathExpression.eClass().getEStructuralFeature(
								UNARY_MATH_EXPRESSION__OP), -1);
				return A_INT;
			}
		} catch (MetamodelNotFoundException ex) {
			error(ex.getMessage(), unaryMathExpression);
			return A_INT;
		}
		return types;
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseUnaryBooleanExpression(de.feu.mitra.UnaryBooleanExpression)
	 */
	@Override
	public Type[] caseUnaryBooleanExpression(
			UnaryBooleanExpression unaryBooleanExpression) {
		return A_BOOLEAN;
	}

	/**
	 * {@inheritDoc} Note: This is usually an up-cast, i.e. we have to test both
	 * direction.
	 * 
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseUnaryCastExpression(de.feu.mitra.UnaryCastExpression)
	 */
	@Override
	public Type[] caseUnaryCastExpression(
			UnaryCastExpression unaryCastExpression) {
		return new Type[] {
			unaryCastExpression.getType()
		};
		// TODO validate
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseInstanceOfExpression(de.feu.mitra.InstanceOfExpression)
	 */
	@Override
	public Type[] caseInstanceOfExpression(
			InstanceOfExpression i_instanceOfExpression) {
		return A_BOOLEAN;
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseFeatureAccess(de.feu.mitra.FeatureAccess)
	 * @see MObjectAccessPolicy#evaluateToFeaturePath(FeatureAccess,
	 *      de.feu.mitra.VariableDeclaration)
	 */
	@Override
	public Type[] caseVariableAccess(VariableAccess variableAccess) {
		Type receiverType = getType(variableAccess.getVariable());

		if (receiverType == null) {
			error("Variable type not found", variableAccess);
			return A_ANY;
		}

		return resolveTypeOfFeatureAccess(receiverType,
				variableAccess.getFeatures());
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseStaticAccess(de.feu.mitra.StaticAccess)
	 */
	@Override
	public Type[] caseStaticAccess(StaticAccess staticAccess) {

		Type receiverType = null;
		if (staticAccess.getExpression() != null) {
			if (staticAccess.getType() != null) {
				error("Internal error, static access with type must not provide reflective expression. Ignore expression.",
						staticAccess.getExpression());
			} else {
				Type[] types = visit(staticAccess.getExpression());
				if (types.length != 1) {
					error("Expression in reflective static access must return one element",
							staticAccess.getExpression());
					return A_ANY;
				}
				receiverType = types[0];
			}
		} else {
			receiverType = staticAccess.getType();
		}
		return resolveTypeOfFeatureAccess(receiverType,
				staticAccess.getFeatures());
	}

	private Type[] resolveTypeOfFeatureAccess(final Type receiverType,
			Iterable<Feature> features) {

		Type type = receiverType;
		for (Feature feature : features) {
			if (type == ANY) break;

			if (feature.getName() == null) {
				// reflective call, no name given
				type = PrimitiveMetamodel.ANY;
			}

			if (feature instanceof FeatureField) {
				type = resolveTypeOfField(type, (FeatureField) feature);
			} else if (feature instanceof NativeOperationInvocation) {
				type =
					resolveTypeOfNativeOperation(type,
							(NativeOperationInvocation) feature);
			} else if (feature instanceof MethodInvocation) {
				type = resolveTypeOfMethod(type, (MethodInvocation) feature);

			}
		}
		return new Type[] {
			type
		};
	}

	/**
	 * @param receiverType
	 * @param feature
	 * @return
	 */
	protected Type resolveTypeOfMethod(Type receiverType,
			MethodInvocation feature) {
		IMetamodel metamodel = getMetamodelManager().getMetamodel(receiverType);
		List<FeatureMethodDescription> methodDescriptions =
			metamodel.getMethodDescriptions(receiverType, feature.getName(),
					null, false);
		if (methodDescriptions.size() == 0) {
			errorMethodNotFoundInType(metamodel, receiverType, feature);
			return ANY;
		}

		if (methodDescriptions.size() == 1) {
			return methodDescriptions.get(0).getType();
		}

		List<Expression> arguments = feature.getArguments();
		int numberOfArguments = arguments.size();
		List<FeatureMethodDescription> methodDescriptionsWithMatchingArgnumber =
			new ArrayList<FeatureMethodDescription>();
		for (FeatureMethodDescription methodDescription : methodDescriptions) {
			if (methodDescription.getParameterTypes().length == numberOfArguments) {
				methodDescriptionsWithMatchingArgnumber.add(methodDescription);
			}
		}
		if (methodDescriptionsWithMatchingArgnumber.size() == 0) {
			error("No method " + feature.getName() + " with "
				+ numberOfArguments + " found in type " + receiverType,
					feature,
					feature.eClass().getEStructuralFeature(
							FEATURE_METHOD_INVOCATION__ARGUMENTS), -1);
			return ANY;
		}

		if (methodDescriptionsWithMatchingArgnumber.size() == 1) {
			return methodDescriptionsWithMatchingArgnumber.get(0).getType();
		}

		Type[] argumentTypes = visitList(arguments);
		methodDescriptions =
			metamodel.getMethodDescriptions(receiverType, feature.getName(),
					argumentTypes, false);

		if (methodDescriptions.size() == 0) {
			error("No method " + feature.getName() + " found in type "
				+ receiverType + " matching types "
				+ Arrays.toString(argumentTypes), feature);
			return ANY;
		}

		if (methodDescriptions.size() == 1) {
			return methodDescriptions.get(0).getType();
		}

		error("Ambigous method  call to " + feature.getName() + " in type "
			+ receiverType + " matching types with "
			+ Arrays.toString(argumentTypes), feature);
		return ANY;
	}

	/**
	 * @param receiverType
	 * @param nativeOperationInvocation
	 * @return
	 */
	protected Type resolveTypeOfNativeOperation(Type receiverType,
			NativeOperationInvocation nativeOperationInvocation) {

		INativeOperation nativeOperation =
			getNativeOperationResolver().getNativeOperations().get(
					nativeOperationInvocation.getName());
		if (nativeOperation == null) {
			error("Native operation " + nativeOperationInvocation.getName()
				+ " not defined", nativeOperationInvocation);
			return ANY;
		}

		if (nativeOperationInvocation.getArguments().size() == 1
			&& (nativeOperationInvocation.getArguments().get(0) instanceof IteratorExpression)) {
			return resolveTypeOfNativeOperationWithIteratorExpression(
					nativeOperation, receiverType,
					(IteratorExpression) nativeOperationInvocation
						.getArguments().get(0));
		}

		return resolveTypeOfNativeOperationWithArguments(nativeOperation,
				receiverType, nativeOperationInvocation.getArguments(),
				nativeOperationInvocation);
	}

	protected Type resolveTypeOfNativeOperationWithIteratorExpression(
			INativeOperation nativeOperation, Type receiverType,
			IteratorExpression iteratorExpression) {
		Type loopVarType =
			getType(iteratorExpression.getVariable().getVardecl());
		Type innerIteratorExpressionType =
			visitSingleton(iteratorExpression.getExpression());
		try {
			return nativeOperation.getTypeFromIteratorExpressionCall(
					receiverType, loopVarType, innerIteratorExpressionType);
		} catch (Exception ex) {
			error("Native operation " + nativeOperation.getName()
				+ " not defined for receiver type " + receiverType
				+ " iteratoring over an " + loopVarType + " returning "
				+ innerIteratorExpressionType, iteratorExpression);
			return ANY;
		}

	}

	protected Type resolveTypeOfNativeOperationWithArguments(
			INativeOperation nativeOperation, Type receiverType,
			EList<Expression> arguments,
			NativeOperationInvocation nativeOperationInvocation) {
		List<Type> argumentTypes = asList(visitList(arguments));
		try {
			return nativeOperation.getTypeFromArgumentCall(receiverType,
					argumentTypes);
		} catch (Exception ex) {
			error("Native operation " + nativeOperation.getName()
				+ " not defined for receiver type " + receiverType
				+ " and argument types " + argumentTypes,
					nativeOperationInvocation);
			return ANY;
		}
	}

	/**
	 * @param receiverType
	 * @param feature
	 * @return
	 */
	protected Type resolveTypeOfField(Type receiverType, FeatureField feature) {
		IMetamodel metamodel = getMetamodelManager().getMetamodel(receiverType);
		FeatureFieldDescription featureFieldDescription =
			metamodel.getFeatureFieldDescription(receiverType,
					feature.getName());
		if (featureFieldDescription == null) {
			errorFieldNotFoundInType(metamodel, receiverType, feature);
			return ANY;
		}

		return featureFieldDescription.getType();
	}

	/**
	 * @param metamodel
	 * @param receiverType
	 * @param feature
	 * @since Feb 4, 2012
	 */
	protected void errorMethodNotFoundInType(IMetamodel metamodel,
			Type receiverType, Feature feature) {
		String[] issue_data =
			computeAlternativeNames(feature, metamodel.getMethodDescriptions(
					receiverType, null, null, false));
		error("Method " + feature.getName() + " not found in type "
			+ receiverType, feature, feature.eContainingFeature(), -1,
				FEATURE_METHOD_NOT_FOUND, issue_data);
	}

	/**
	 * @param metamodel
	 * @param receiverType
	 * @param feature
	 * @since Feb 4, 2012
	 */
	protected void errorFieldNotFoundInType(IMetamodel metamodel,
			Type receiverType, Feature feature) {
		String[] issue_data =
			computeAlternativeNames(feature,
					metamodel.getAllFeatureFieldsDescriptions(receiverType,
							false, false));
		error("Field " + feature.getName() + " not found in type "
			+ receiverType, feature, feature.eContainingFeature(), -1,
				FEATURE_FIELD_NOT_FOUND, issue_data);
	}

	/**
	 * @param i_receiverType
	 * @param i_feature
	 * @return
	 */
	private String[] computeAlternativeNames(Feature feature,
			List<? extends FeatureDescription> featureDescriptions) {
		final String name = feature.getName();
		String[] alternativeNames =
			FeatureDescription.names(featureDescriptions);
		String[] issue_data;
		if (alternativeNames.length > 4) {
			List<String> filteredNames = new ArrayList<String>(5);
			filteredNames.add(name);
			for (String alternativeName : alternativeNames) {
				if (StringUtils.getLevenshteinDistanceWithMinLength(name,
						alternativeName) < 5) {
					filteredNames.add(alternativeName);
				}
			}
			issue_data = new String[filteredNames.size()];
			filteredNames.toArray(issue_data);
		} else {
			issue_data = new String[alternativeNames.length + 1];
			issue_data[0] = name;
			System.arraycopy(alternativeNames, 0, issue_data, 1,
					alternativeNames.length);
		}
		return issue_data;

	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseBooleanLiteral(de.feu.mitra.BooleanLiteral)
	 */
	@Override
	public Type[] caseBooleanLiteral(BooleanLiteral booleanLiteral) {
		return A_BOOLEAN;
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseIntLiteral(de.feu.mitra.IntLiteral)
	 */
	@Override
	public Type[] caseIntLiteral(IntLiteral inLiteral) {
		return A_INT;
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseRealLiteral(de.feu.mitra.RealLiteral)
	 */
	@Override
	public Type[] caseRealLiteral(RealLiteral realLitral) {
		return A_REAL;
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseNullLiteral(de.feu.mitra.NullLiteral)
	 */
	@Override
	public Type[] caseNullLiteral(NullLiteral i_nullLiteral) {
		return A_NULL;
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseStringLiteral(de.feu.mitra.StringLiteral)
	 */
	@Override
	public Type[] caseStringLiteral(StringLiteral stringLiteral) {
		return A_STRING;
	}

	/**
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseClassInstanceCreationExpression(de.feu.mitra.ClassInstanceCreationExpression)
	 */
	@Override
	public Type[] caseClassInstanceCreationExpression(
			ClassInstanceCreationExpression classInstanceCreationExpression) {
		return new Type[] {
			classInstanceCreationExpression.getType()
		};
	}

	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseFeature(de.jevopi.mitra2.mitra.Feature)
	 */
	@Override
	public Type[] caseFeature(final Feature i_feature) {
		return resolveTypeOfFeatureOrReceiver(i_feature, true);
	}

	public Type resolveReceiverType(final Feature i_feature) {
		return resolveTypeOfFeatureOrReceiver(i_feature, false)[0];
	}

	private Type[] resolveTypeOfFeatureOrReceiver(final Feature i_feature,
			boolean returnFeature) {

		final List<Feature> allFeatures = getAllFeaturesOfContainer(i_feature);
		Type receiverType = getMainReceiverType(i_feature);
		final FilterResult returnedResultForFeature =
			returnFeature ? ACCEPT_AND_STOP : SKIP_AND_STOP;

		Iterable<Feature> preceedingFeatures =
			select(allFeatures, new Filter<Feature>() {
				@Override
				public FilterResult apply(Feature element) {
					if (i_feature == element) {
						return returnedResultForFeature;
					}
					return ACCEPT;
				}
			});

		return resolveTypeOfFeatureAccess(receiverType, preceedingFeatures);
	}

	protected List<Feature> getAllFeaturesOfContainer(final Feature i_feature) {
		if (i_feature.eContainer() instanceof VariableAccess) {
			VariableAccess variableAccess =
				(VariableAccess) i_feature.eContainer();
			return variableAccess.getFeatures();
		}

		// static access
		StaticAccess staticAccess = (StaticAccess) i_feature.eContainer();
		return staticAccess.getFeatures();
	}

	protected Type getMainReceiverType(final Feature i_feature) {
		if (i_feature.eContainer() instanceof VariableAccess) {
			VariableAccess variableAccess =
				(VariableAccess) i_feature.eContainer();
			return getType(variableAccess.getVariable());
		}
		// static access
		StaticAccess staticAccess = (StaticAccess) i_feature.eContainer();
		return staticAccess.getType();
	}

	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseFeatureField(de.jevopi.mitra2.mitra.FeatureField)
	 */
	@Override
	public Type[] caseFeatureField(FeatureField i_featureField) {
		if (i_featureField.getName() == null) {
			return getDefaultReturnValue();
		}
		return caseFeature(i_featureField);
	}

	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseFeatureMethodInvocation(de.jevopi.mitra2.mitra.FeatureMethodInvocation)
	 */
	@Override
	public Type[] caseFeatureMethodInvocation(
			FeatureMethodInvocation i_featureMethodInvocation) {
		if (i_featureMethodInvocation.getName() == null) {
			return getDefaultReturnValue();
		}
		return caseFeature(i_featureMethodInvocation);
	}

	@Override
	public Type[] caseNativeOperationInvocation(
			NativeOperationInvocation i_nativeOperationInvocation) {
		return caseFeature(i_nativeOperationInvocation);
	}

	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseLoopVariable(de.jevopi.mitra2.mitra.LoopVariable)
	 * @since Feb 6, 2012
	 */
	@Override
	public Type[] caseLoopVariable(LoopVariable i_loopVariable) {
		return caseVarDeclaration(i_loopVariable.getVardecl());
	}

	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseIteratorExpression(de.jevopi.mitra2.mitra.IteratorExpression)
	 */
	@Override
	public Type[]
			caseIteratorExpression(IteratorExpression i_iteratorExpression) {
		throw new IllegalStateException(
			"Internal error, do not resolve type of iterator expression, but type of iteratorExpression.expression");
	}

	/**
	 * Binds trigger by setting triggeredRule attribute of rule specified by
	 * this trigger.
	 * 
	 * @see de.feu.mitra.engine.visitors.TraversingVisitor#caseTrigger(de.feu.mitra.Trigger)
	 */
	@Override
	public Type[] caseTrigger(Trigger trigger) {
		return A_VOID;
	}

	protected boolean isStringCompatible(Type type)
			throws MetamodelNotFoundException {
		return getMetamodelManager().getMetamodel(type).typeDistance(type,
				PrimitiveMetamodel.STRING) >= 0;
	}

	protected boolean isIntCompatible(Type type)
			throws MetamodelNotFoundException {
		return getMetamodelManager().getMetamodel(type).typeDistance(type,
				PrimitiveMetamodel.INT) >= 0;
	}

	public Type[] computeTypeOfRuleInvocationAtPosition(
			EObject containerOfRuleInvocation) {
		return new ReturnTypeOfRuleSwitch(this)
			.doSwitch(containerOfRuleInvocation);
	}

	@Override
	public Type[] caseBooleanExpression(BooleanExpression booleanExpression) {
		return A_BOOLEAN;
	}

}
