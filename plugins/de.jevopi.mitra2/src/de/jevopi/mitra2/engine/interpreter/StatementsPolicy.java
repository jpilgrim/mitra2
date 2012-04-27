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

import java.util.Collections;
import java.util.ConcurrentModificationException;

import de.jevopi.mitra2.MitraError;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.metamodel.MetamodelManager.MetamodelNotFoundException;
import de.jevopi.mitra2.metamodel.mitracollections.MitraCollection;
import de.jevopi.mitra2.mitra.DoStatement;
import de.jevopi.mitra2.mitra.Expression;
import de.jevopi.mitra2.mitra.ForInit;
import de.jevopi.mitra2.mitra.ForStatement;
import de.jevopi.mitra2.mitra.ForUpdate;
import de.jevopi.mitra2.mitra.IfStatement;
import de.jevopi.mitra2.mitra.Statement;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.VarDeclaration;
import de.jevopi.mitra2.mitra.WhileStatement;

/**
 * StatementsPolicy There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @since Mitra 1
 */
public class StatementsPolicy extends ExecutionPolicy {

	/**
	 * @param host
	 */
	public StatementsPolicy(Interpreter context) {
		super(context);
	}

	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseIfStatement(IfStatement)
	 */
	public MObject[] caseIfStatement(IfStatement ifStatement) {

		if (evalBool(ifStatement.getExpression())) {
			host.visit(ifStatement.getTrueStatement());
		} else {
			if (ifStatement.getElseStatement() != null) {
				host.visit(ifStatement.getElseStatement());
			}
		}

		return host.getDefaultReturnValue();
	}

	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseDoStatement(DoStatement)
	 */
	public MObject[] caseDoStatement(DoStatement doStatement) {
		return evalLoop(null, // no init
				null, // no update
				doStatement.getExpression(), doStatement.getStatement(), true);
	}

	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseWhileStatement(WhileStatement)
	 */
	public MObject[] caseWhileStatement(WhileStatement whileStatement) {
		return evalLoop(
				null, // no init
				null, // no update
				whileStatement.getExpression(), whileStatement.getStatement(),
				false);
	}

	/**
	 * <pre>
	 * ForStatement: "for" "("
	 * 	(
	 * 		(loopVariable=LoopVariable ":" expression=Expression)
	 * 		|
	 * 		( 	(forInit=ForInit)? ";" (expression=Expression)? ";" 
	 * 			(forUpdate=ForUpdate)? 
	 * 		)
	 * 	)
	 * 	")" statement=Statement;
	 * </pre>
	 * 
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseForStatement(ForStatement)
	 */
	public MObject[] caseForStatement(ForStatement forStatement) {
		host.enterBlock();
		MObject[] result;
		if (forStatement.getLoopVariable() != null) {
			result = evalForEachLoop(forStatement);
		} else {
			result = evalForLoop(forStatement);
		}
		host.leaveBlock();
		return result;
	}

	protected MObject[] evalForEachLoop(ForStatement forStatement) {

		MObject mlist = visitSingleton(forStatement.getExpression());

		Iterable<MObject> collection = null;
		if (mlist.getValue() instanceof MitraCollection) {
			collection = (MitraCollection) mlist.getValue();
		} else {
			collection = Collections.singleton((MObject) mlist.getValue());
		}

		MObject[] retValues = host.getDefaultReturnValue();
		StackFrame currentStackFrame = host.currentStackFrame();
		VarDeclaration loopVar = forStatement.getLoopVariable().getVardecl();
		currentStackFrame.declareVariable(loopVar);

		Type loopVariableType = getTypeResolver().getType(loopVar);
		MetamodelManager metamodelManager = getMetamodelManager();

		try {
			for (MObject melement : collection) {
				// implicit type filtering
				if (metamodelManager.isSubType(melement.getActualType(),
						loopVariableType)) {

					currentStackFrame.setValue(loopVar, melement);
					if (!(host.bBreak || host.bReturn)) {
						retValues = host.visit(forStatement.getStatement());
					}
					if (host.bBreak || host.bReturn) {
						break;
					}
				}
			}
			host.bBreak = false;
		} catch (ConcurrentModificationException ex) {
			runtimeError("Collection has been modified in loop (hint: iterate over copy)",
					forStatement, ex);
			throw new MitraError();
		}

		return retValues;
	}

	private MObject[] evalForLoop(ForStatement forStatement) {
		MObject[] loopResults =
			evalLoop(forStatement.getForInit(), forStatement.getForUpdate(),
					forStatement.getExpression(), forStatement.getStatement(),
					false);

		return loopResults;
	}

	private MObject[] evalLoop(ForInit forInit, ForUpdate forUpdate,
			Expression expression, Statement statement, boolean bIsDo) {
		host.bBreak = false;
		MObject[] retValues = host.getDefaultReturnValue();
		if (bIsDo) {
			retValues = host.visit(statement);
		}
		if (!(host.bBreak || host.bReturn)) {
			if (forInit != null) {
				host.visit(forInit);
			}
			while (evalBool(expression)) {
				retValues = host.visit(statement);
				if (host.bBreak || host.bReturn) {
					break;
				}
				if (forUpdate != null) {
					host.visit(forUpdate);
				}
			}
		}
		host.bBreak = false;
		return retValues;
	}

	/**
	 * Called by loops (and others) for evaluating a boolean expression.
	 * 
	 * @param expression
	 * @return
	 * @throws MetamodelNotFoundException
	 */
	private boolean evalBool(Expression expression)
			throws MetamodelNotFoundException {
		MObject[] value = host.visit(expression);
		if (value.length != 1) {
			return false;
		}
		return host.getMetamodel(value[0].getActualType()).castToBoolean(
				value[0]);
	}

}
