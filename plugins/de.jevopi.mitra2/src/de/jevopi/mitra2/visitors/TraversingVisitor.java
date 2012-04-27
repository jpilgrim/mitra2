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
package de.jevopi.mitra2.visitors;

import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.jevopi.mitra2.mitra.Assignment;
import de.jevopi.mitra2.mitra.Block;
import de.jevopi.mitra2.mitra.BlockStatement;
import de.jevopi.mitra2.mitra.BooleanExpression;
import de.jevopi.mitra2.mitra.BooleanLiteral;
import de.jevopi.mitra2.mitra.BreakStatement;
import de.jevopi.mitra2.mitra.Catch;
import de.jevopi.mitra2.mitra.ClassInstanceCreationExpression;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.DoStatement;
import de.jevopi.mitra2.mitra.EmptyStatement;
import de.jevopi.mitra2.mitra.EqualityExpression;
import de.jevopi.mitra2.mitra.Expression;
import de.jevopi.mitra2.mitra.ExpressionStatement;
import de.jevopi.mitra2.mitra.Feature;
import de.jevopi.mitra2.mitra.FeatureField;
import de.jevopi.mitra2.mitra.FeatureMethodInvocation;
import de.jevopi.mitra2.mitra.ForInit;
import de.jevopi.mitra2.mitra.ForStatement;
import de.jevopi.mitra2.mitra.ForUpdate;
import de.jevopi.mitra2.mitra.FormalParameter;
import de.jevopi.mitra2.mitra.IfStatement;
import de.jevopi.mitra2.mitra.InferredVarDeclaration;
import de.jevopi.mitra2.mitra.InstanceOfExpression;
import de.jevopi.mitra2.mitra.IntLiteral;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.JavaSpec;
import de.jevopi.mitra2.mitra.Literal;
import de.jevopi.mitra2.mitra.LocalVariableDeclaration;
import de.jevopi.mitra2.mitra.LocalVariableDeclarationStatement;
import de.jevopi.mitra2.mitra.LoopVariable;
import de.jevopi.mitra2.mitra.MathExpression;
import de.jevopi.mitra2.mitra.MetamodelDeclaration;
import de.jevopi.mitra2.mitra.MetamodelFeature;
import de.jevopi.mitra2.mitra.MethodInvocation;
import de.jevopi.mitra2.mitra.Module;
import de.jevopi.mitra2.mitra.NativeOperationInvocation;
import de.jevopi.mitra2.mitra.NullLiteral;
import de.jevopi.mitra2.mitra.Parameter;
import de.jevopi.mitra2.mitra.ParameterReference;
import de.jevopi.mitra2.mitra.PrimitiveType;
import de.jevopi.mitra2.mitra.Property;
import de.jevopi.mitra2.mitra.QualifiedParameterReference;
import de.jevopi.mitra2.mitra.QualifiedRuleReference;
import de.jevopi.mitra2.mitra.RealLiteral;
import de.jevopi.mitra2.mitra.ReferenceType;
import de.jevopi.mitra2.mitra.RelationalExpression;
import de.jevopi.mitra2.mitra.ReturnParameter;
import de.jevopi.mitra2.mitra.ReturnStatement;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.RuleInvocation;
import de.jevopi.mitra2.mitra.RuleInvocationSuper;
import de.jevopi.mitra2.mitra.RuleReference;
import de.jevopi.mitra2.mitra.SimpleParameterReference;
import de.jevopi.mitra2.mitra.SimpleRuleReference;
import de.jevopi.mitra2.mitra.Statement;
import de.jevopi.mitra2.mitra.StatementExpression;
import de.jevopi.mitra2.mitra.StaticAccess;
import de.jevopi.mitra2.mitra.StringLiteral;
import de.jevopi.mitra2.mitra.TerminalExpression;
import de.jevopi.mitra2.mitra.ThrowStatement;
import de.jevopi.mitra2.mitra.Trigger;
import de.jevopi.mitra2.mitra.TryStatement;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.TypedVarDeclaration;
import de.jevopi.mitra2.mitra.UnaryBooleanExpression;
import de.jevopi.mitra2.mitra.UnaryCastExpression;
import de.jevopi.mitra2.mitra.UnaryMathExpression;
import de.jevopi.mitra2.mitra.VarDeclaration;
import de.jevopi.mitra2.mitra.VariableAccess;
import de.jevopi.mitra2.mitra.WhileStatement;

/**
 * Traverses through the abstract syntax tree. All elements are traversed,
 * except primitive types (IDs) and enumarations. The children are traversed in
 * the order of their occurrence in the grammar, the tree is traversed
 * depth-first.
 * 
 * @author Jens von Pilgrim
 */
public class TraversingVisitor<RET> extends Visitor<RET> {

	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(TraversingVisitor.class
			.getName());

	private RET defaultReturnValue = null;

	

	/**
	 * @param i_defaultReturnValue the defaultReturnValue to set
	 */
	public TraversingVisitor(RET i_defaultReturnValue) {
		defaultReturnValue = i_defaultReturnValue;
	}

	/**
	 * @return the defaultReturnValue
	 */
	public RET getDefaultReturnValue() {
		return defaultReturnValue;
	}

	/**
	 * @param i_defaultReturnValue the defaultReturnValue to set
	 */
	protected void setDefaultReturnValue(RET i_defaultReturnValue) {
		defaultReturnValue = i_defaultReturnValue;
	}

	/**
	 * @see de.jevopi.mitra2.mitra.engine.visitors.Visitor#visit(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public RET visit(EObject i_element) {
		if (i_element != null) {
			return super.visit(i_element);
		}
		return getDefaultReturnValue();
	}

	public RET visitItems(EList<?> i_list) {
		if (i_list != null) {
			for (Object obj : i_list) {
				if (obj instanceof EObject) {
					visit((EObject) obj);
				}
			}
		}
		return getDefaultReturnValue();
	}


	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseModule(de.jevopi.mitra2.mitra.Module)
	 */
	@Override
	public RET caseModule(Module module) {
		// visit(module.getName());
		visitItems(module.getImports());
		visitItems(module.getMetamodelDeclarations());
		visitItems(module.getRuleDeclarations());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseMetamodelDeclaration(de.jevopi.mitra2.mitra.MetamodelDeclaration)
	 */
	@Override
	public RET caseMetamodelDeclaration(
			MetamodelDeclaration metamodelDeclaration) {
		visitItems(metamodelDeclaration.getProperties());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseProperty(de.jevopi.mitra2.mitra.Property)
	 */
	@Override
	public RET caseProperty(Property property) {
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseRuleDeclaration(de.jevopi.mitra2.mitra.RuleDeclaration)
	 */
	@Override
	public RET caseRuleDeclaration(RuleDeclaration ruleDeclaration) {
		visitItems(ruleDeclaration.getFormalParameters());
		visitItems(ruleDeclaration.getReturnParameters());
		visitItems(ruleDeclaration.getImplementedRules());
		visitItems(ruleDeclaration.getExcludingRules());
		visit(ruleDeclaration.getOverriddenRule());
		visit(ruleDeclaration.getTrigger());
		visit(ruleDeclaration.getJavaSpec());
		visit(ruleDeclaration.getBody());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseTrigger(de.jevopi.mitra2.mitra.Trigger)
	 */
	@Override
	public RET caseTrigger(Trigger trigger) {
		visitItems(trigger.getTriggerRules());
		visit(trigger.getWith());
		visit(trigger.getWhen());
		return getDefaultReturnValue();
	}

	@Override
	public RET caseJavaSpec(JavaSpec javaSpec) {
		visitItems(javaSpec.getProperties());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseFormalParameter(de.jevopi.mitra2.mitra.FormalParameter)
	 */
	@Override
	public RET caseFormalParameter(FormalParameter formalParameter) {
		visit(formalParameter.getVardecl());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseReturnParameter(de.jevopi.mitra2.mitra.ReturnParameter)
	 */
	@Override
	public RET caseReturnParameter(ReturnParameter returnParameter) {
		visit(returnParameter.getVardecl());
		return getDefaultReturnValue();
	}

	/**
	 * Logs a warning, this is a base class, sub class method should be visited
	 * instead.
	 * 
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseType(de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	public RET caseType(Type type) {
		log.warning("base class visited: : " + type); //$NON-NLS-1$
		return getDefaultReturnValue();
	}

	/**
	 * Does nothing.
	 * 
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseReferenceType(de.jevopi.mitra2.mitra.ReferenceType)
	 */
	@Override
	public RET caseReferenceType(ReferenceType referenceType) {
		return getDefaultReturnValue();
	}

	/**
	 * Does nothing.
	 * 
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#casePrimitiveType(de.jevopi.mitra2.mitra.PrimitiveType)
	 */
	@Override
	public RET casePrimitiveType(PrimitiveType primitiveType) {
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseBlock(de.jevopi.mitra2.mitra.Block)
	 */
	@Override
	public RET caseBlock(Block block) {
		visitItems(block.getStatements());
		return getDefaultReturnValue();
	}

	/**
	 * Logs a warning, sub class method should be visited instead.
	 * 
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseBlockStatement(de.jevopi.mitra2.mitra.BlockStatement)
	 */
	@Override
	public RET caseBlockStatement(BlockStatement blockStatement) {
		log.warning("base class visited: : " + blockStatement); //$NON-NLS-1$
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseLocalVariableDeclarationStatement(de.jevopi.mitra2.mitra.LocalVariableDeclarationStatement)
	 */
	@Override
	public RET caseLocalVariableDeclarationStatement(
			LocalVariableDeclarationStatement localVariableDeclarationStatement) {
		visit(localVariableDeclarationStatement.getLocalVariableDeclaration());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseLocalVariableDeclaration(de.jevopi.mitra2.mitra.LocalVariableDeclaration)
	 */
	@Override
	public RET caseLocalVariableDeclaration(
			LocalVariableDeclaration localVariableDeclaration) {
		visit(localVariableDeclaration.getExpression());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseLoopVariable(de.jevopi.mitra2.mitra.LoopVariable)
	 */
	@Override
	public RET caseLoopVariable(LoopVariable loopVariable) {
		visit(loopVariable.getVardecl());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseVarDeclaration(de.jevopi.mitra2.mitra.VarDeclaration)
	 * @since Feb 6, 2012
	 */
	@Override
	public RET caseVarDeclaration(VarDeclaration varDeclaration) {
		log.warning("base class visited: : " + varDeclaration); //$NON-NLS-1$
		if (varDeclaration.getType() != null) {
			visit(varDeclaration.getType());
		}
		return getDefaultReturnValue();
	}

	/**
	 * Logs a warning, sub class method should be visited instead.
	 * 
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseStatement(de.jevopi.mitra2.mitra.Statement)
	 */
	@Override
	public RET caseStatement(Statement statement) {
		log.warning("base class visited: : " + statement); //$NON-NLS-1$	
		return getDefaultReturnValue();
	}

	/**
	 * does nothing
	 * 
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseEmptyStatement(de.jevopi.mitra2.mitra.EmptyStatement)
	 */
	@Override
	public RET caseEmptyStatement(EmptyStatement emptyStatement) {
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseExpressionStatement(de.jevopi.mitra2.mitra.ExpressionStatement)
	 */
	@Override
	public RET caseExpressionStatement(ExpressionStatement expressionStatement) {
		visit(expressionStatement.getStatementExpression());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseReturnStatement(de.jevopi.mitra2.mitra.ReturnStatement)
	 */
	@Override
	public RET caseReturnStatement(ReturnStatement returnStatement) {
		visit(returnStatement.getExpression());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseBreakStatement(de.jevopi.mitra2.mitra.BreakStatement)
	 */
	@Override
	public RET caseBreakStatement(BreakStatement breakStatement) {
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseIfStatement(de.jevopi.mitra2.mitra.IfStatement)
	 */
	@Override
	public RET caseIfStatement(IfStatement ifStatement) {
		visit(ifStatement.getExpression());
		visit(ifStatement.getTrueStatement());
		visit(ifStatement.getElseStatement());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseWhileStatement(de.jevopi.mitra2.mitra.WhileStatement)
	 */
	@Override
	public RET caseWhileStatement(WhileStatement whileStatement) {
		visit(whileStatement.getExpression());
		visit(whileStatement.getStatement());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseDoStatement(de.jevopi.mitra2.mitra.DoStatement)
	 */
	@Override
	public RET caseDoStatement(DoStatement doStatement) {
		visit(doStatement.getStatement());
		visit(doStatement.getExpression());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseForStatement(de.jevopi.mitra2.mitra.ForStatement)
	 */
	@Override
	public RET caseForStatement(ForStatement forStatement) {
		visit(forStatement.getLoopVariable());
		visit(forStatement.getForInit());
		visit(forStatement.getExpression());
		visit(forStatement.getForUpdate());
		visit(forStatement.getStatement());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseForInit(de.jevopi.mitra2.mitra.ForInit)
	 */
	@Override
	public RET caseForInit(ForInit forInit) {
		visitItems(forInit.getVarDeclarations());
		visitItems(forInit.getStatementExpressions());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseForUpdate(de.jevopi.mitra2.mitra.ForUpdate)
	 */
	@Override
	public RET caseForUpdate(ForUpdate forUpdate) {
		visitItems(forUpdate.getStatementExpression());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseThrowStatement(de.jevopi.mitra2.mitra.ThrowStatement)
	 */
	@Override
	public RET caseThrowStatement(ThrowStatement throwStatement) {
		visit(throwStatement.getExpression());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseTryStatement(de.jevopi.mitra2.mitra.TryStatement)
	 */
	@Override
	public RET caseTryStatement(TryStatement tryStatement) {
		visit(tryStatement.getTryBlock());
		visitItems(tryStatement.getCatches());
		visit(tryStatement.getFinallyBlock());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseCatch(de.jevopi.mitra2.mitra.Catch)
	 */
	@Override
	public RET caseCatch(Catch _catch) {
		visit(_catch.getFormalParameter());
		visit(_catch.getBlock());
		return getDefaultReturnValue();
	}

	/**
	 * Logs a warning, sub class method should be visited instead.
	 * 
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseStatementExpression(de.jevopi.mitra2.mitra.StatementExpression)
	 */
	@Override
	public RET caseStatementExpression(StatementExpression statementExpression) {
		log.warning("base class visited: : " + statementExpression); //$NON-NLS-1$
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseAssignment(de.jevopi.mitra2.mitra.Assignment)
	 */
	@Override
	public RET caseAssignment(Assignment assignment) {
		visitItems(assignment.getLhs());
		visit(assignment.getExpression());
		return getDefaultReturnValue();
	}

	/**
	 * Does nothing.
	 * 
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseLiteral(de.jevopi.mitra2.mitra.Literal)
	 */
	@Override
	public RET caseLiteral(Literal literal) {
		log.warning("base class visited: : " + literal); //$NON-NLS-1$
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseIntLiteral(de.jevopi.mitra2.mitra.IntLiteral)
	 */
	@Override
	public RET caseIntLiteral(IntLiteral intLiteral) {
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseRealLiteral(de.jevopi.mitra2.mitra.RealLiteral)
	 */
	@Override
	public RET caseRealLiteral(RealLiteral realLiteral) {
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseStringLiteral(de.jevopi.mitra2.mitra.StringLiteral)
	 */
	@Override
	public RET caseStringLiteral(StringLiteral stringLiteral) {
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseNullLiteral(de.jevopi.mitra2.mitra.NullLiteral)
	 */
	@Override
	public RET caseNullLiteral(NullLiteral nullLiteral) {
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseBooleanLiteral(de.jevopi.mitra2.mitra.BooleanLiteral)
	 */
	@Override
	public RET caseBooleanLiteral(BooleanLiteral booleanLiteral) {
		return getDefaultReturnValue();
	}

	/**
	 * Logs a warning, sub class method should be visited instead.
	 * 
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseExpression(de.jevopi.mitra2.mitra.Expression)
	 */
	@Override
	public RET caseExpression(Expression expression) {
		log.warning("base class visited: : " + expression); //$NON-NLS-1$
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseEqualityExpression(de.jevopi.mitra2.mitra.EqualityExpression)
	 */
	@Override
	public RET caseEqualityExpression(EqualityExpression equalityExpression) {
		visit(equalityExpression.getLhs());
		visit(equalityExpression.getRhs());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseRelationalExpression(de.jevopi.mitra2.mitra.RelationalExpression)
	 */
	@Override
	public RET caseRelationalExpression(
			RelationalExpression relationalExpression) {
		visit(relationalExpression.getLhs());
		visit(relationalExpression.getRhs());
		return getDefaultReturnValue();
	}

	

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseMathExpression(de.jevopi.mitra2.mitra.MathExpression)
	 */
	@Override
	public RET caseMathExpression(MathExpression mathExpression) {
		visit(mathExpression.getLhs());
		visit(mathExpression.getRhs());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseUnaryMathExpression(de.jevopi.mitra2.mitra.UnaryMathExpression)
	 */
	@Override
	public RET caseUnaryMathExpression(UnaryMathExpression unaryMathExpression) {
		visit(unaryMathExpression.getExpression());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseUnaryBooleanExpression(de.jevopi.mitra2.mitra.UnaryBooleanExpression)
	 */
	@Override
	public RET caseUnaryBooleanExpression(
			UnaryBooleanExpression unaryBooleanExpression) {
		visit(unaryBooleanExpression.getExpression());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseUnaryCastExpression(de.jevopi.mitra2.mitra.UnaryCastExpression)
	 */
	@Override
	public RET caseUnaryCastExpression(UnaryCastExpression unaryCastExpression) {
		visit(unaryCastExpression.getType());
		visit(unaryCastExpression.getExpression());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseInstanceOfExpression(de.jevopi.mitra2.mitra.InstanceOfExpression)
	 */
	@Override
	public RET caseInstanceOfExpression(
			InstanceOfExpression instanceOfExpression) {
		visit(instanceOfExpression.getType());
		visit(instanceOfExpression.getExpression());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseClassInstanceCreationExpression(de.jevopi.mitra2.mitra.ClassInstanceCreationExpression)
	 */
	@Override
	public RET caseClassInstanceCreationExpression(
			ClassInstanceCreationExpression classInstanceCreationExpression) {
		visit(classInstanceCreationExpression.getType());
		visitItems(classInstanceCreationExpression.getArguments());
		return getDefaultReturnValue();
	}

	/**
	 * Does nothing. {@inheritDoc}
	 * 
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseRuleInvocation(de.jevopi.mitra2.mitra.RuleInvocation)
	 */
	@Override
	public RET caseRuleInvocation(RuleInvocation ruleInvocation) {
		visitItems(ruleInvocation.getArguments());
		return getDefaultReturnValue();
	}

	/**
	 * Logs a warning, sub class method should be visited instead.
	 * 
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseFeature(de.jevopi.mitra2.mitra.Feature)
	 */
	@Override
	public RET caseFeature(Feature feature) {
		log.warning("base class visited: : " + feature); //$NON-NLS-1$
		return getDefaultReturnValue();
	}

	/**
	 * Does nothing.
	 * 
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseFeatureField(de.jevopi.mitra2.mitra.FeatureField)
	 */
	@Override
	public RET caseFeatureField(FeatureField featureField) {
		visit(featureField.getExpression());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseFeatureMethodInvocation(de.jevopi.mitra2.mitra.FeatureMethodInvocation)
	 */
	@Override
	public RET caseFeatureMethodInvocation(
			FeatureMethodInvocation featureMethodInvocation) {
		visit(featureMethodInvocation.getExpression());
		visitItems(featureMethodInvocation.getArguments());
		return getDefaultReturnValue();
	}

	@Override
	public RET caseNativeOperationInvocation(
			NativeOperationInvocation nativeOperationInvocation) {
		visitItems(nativeOperationInvocation.getArguments());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseVariableAccess(de.jevopi.mitra2.mitra.VariableAccess)
	 */
	@Override
	public RET caseVariableAccess(VariableAccess variableAccess) {
		visitItems(variableAccess.getFeatures());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseBooleanExpression(de.jevopi.mitra2.mitra.BooleanExpression)
	 */
	@Override
	public RET caseBooleanExpression(BooleanExpression booleanExpression) {
		visit(booleanExpression.getLhs());
		visit(booleanExpression.getRhs());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseCollectionType(de.jevopi.mitra2.mitra.CollectionType)
	 */
	@Override
	public RET caseCollectionType(CollectionType collectionType) {
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseIteratorExpression(de.jevopi.mitra2.mitra.IteratorExpression)
	 */
	@Override
	public RET caseIteratorExpression(IteratorExpression iteratorExpression) {
		visit(iteratorExpression.getVariable());
		visit(iteratorExpression.getExpression());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseMetamodelFeature(de.jevopi.mitra2.mitra.MetamodelFeature)
	 */
	@Override
	public RET caseMetamodelFeature(MetamodelFeature metamodelFeature) {
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseMethodInvocation(de.jevopi.mitra2.mitra.MethodInvocation)
	 */
	@Override
	public RET caseMethodInvocation(MethodInvocation methodInvocation) {
		visitItems(methodInvocation.getArguments());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseParameter(de.jevopi.mitra2.mitra.Parameter)
	 */
	@Override
	public RET caseParameter(Parameter parameter) {
		visit(parameter.getVardecl());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseParameterReference(de.jevopi.mitra2.mitra.ParameterReference)
	 */
	@Override
	public RET caseParameterReference(ParameterReference parameterReference) {
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseQualifiedParameterReference(de.jevopi.mitra2.mitra.QualifiedParameterReference)
	 */
	@Override
	public RET caseQualifiedParameterReference(
			QualifiedParameterReference qualifiedParameterReference) {
		visit(qualifiedParameterReference.getVardecl());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseQualifiedRuleReference(de.jevopi.mitra2.mitra.QualifiedRuleReference)
	 */
	@Override
	public RET caseQualifiedRuleReference(
			QualifiedRuleReference qualifiedRuleReference) {
		visitItems(qualifiedRuleReference.getParameterReferences());
		visitItems(qualifiedRuleReference.getReturnReferences());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseRuleReference(de.jevopi.mitra2.mitra.RuleReference)
	 */
	@Override
	public RET caseRuleReference(RuleReference ruleReference) {
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseSimpleParameterReference(de.jevopi.mitra2.mitra.SimpleParameterReference)
	 */
	@Override
	public RET caseSimpleParameterReference(
			SimpleParameterReference simpleParameterReference) {
		visit(simpleParameterReference.getType());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseSimpleRuleReference(de.jevopi.mitra2.mitra.SimpleRuleReference)
	 */
	@Override
	public RET caseSimpleRuleReference(SimpleRuleReference simpleRuleReference) {
		visitItems(simpleRuleReference.getParameterReferences());
		visitItems(simpleRuleReference.getReturnReferences());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseTerminalExpression(de.jevopi.mitra2.mitra.TerminalExpression)
	 */
	@Override
	public RET caseTerminalExpression(TerminalExpression terminalExpression) {
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseTypedVarDeclaration(de.jevopi.mitra2.mitra.TypedVarDeclaration)
	 * @since Feb 6, 2012
	 */
	@Override
	public RET caseTypedVarDeclaration(TypedVarDeclaration typedVarDeclaration) {
		visit(typedVarDeclaration.getType());
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseInferredVarDeclaration(de.jevopi.mitra2.mitra.InferredVarDeclaration)
	 * @since Feb 6, 2012
	 */
	@Override
	public RET caseInferredVarDeclaration(
			InferredVarDeclaration inferredVarDeclaration) {
		if (inferredVarDeclaration.getType() != null) {
			visit(inferredVarDeclaration.getType());
		}
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseRuleInvocationSuper(de.jevopi.mitra2.mitra.RuleInvocationSuper)
	 */
	@Override
	public RET caseRuleInvocationSuper(RuleInvocationSuper ruleInvocationSuper) {
		return getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.util.MitraSwitch#caseStaticAccess(de.jevopi.mitra2.mitra.StaticAccess)
	 */
	@Override
	public RET caseStaticAccess(StaticAccess staticAccess) {
		visit(staticAccess.getExpression());
		visit(staticAccess.getType());
		visitItems(staticAccess.getFeatures());
		return getDefaultReturnValue();
	}
	
	
}
