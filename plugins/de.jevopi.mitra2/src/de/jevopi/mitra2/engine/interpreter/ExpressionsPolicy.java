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

import de.jevopi.mitra2.MitraError;
import de.jevopi.mitra2.metamodel.IMetamodel;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager.MetamodelNotFoundException;
import de.jevopi.mitra2.mitra.BooleanExpression;
import de.jevopi.mitra2.mitra.EqualityExpression;
import de.jevopi.mitra2.mitra.InstanceOfExpression;
import de.jevopi.mitra2.mitra.MathExpression;
import de.jevopi.mitra2.mitra.RelationalExpression;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.UnaryBooleanExpression;
import de.jevopi.mitra2.mitra.UnaryCastExpression;
import de.jevopi.mitra2.mitra.UnaryMathExpression;

/**
 * ExpressionsPolicy There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 */
public class ExpressionsPolicy extends ExecutionPolicy {

	/**
	 * @param host
	 */
	public ExpressionsPolicy(Interpreter host) {
		super(host);
	}

	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseEqualityExpression(EqualityExpression)
	 */
	public MObject[] caseEqualityExpression(
			EqualityExpression equalityExpression) {
		MObject objLeft = visitSingleton(equalityExpression.getLhs());
		MObject objRight = visitSingleton(equalityExpression.getRhs());

		boolean bEqual = (objLeft.getValue() == objRight.getValue()) //
			|| //
			(objLeft.getValue() != null //
			&& objLeft.getValue().equals(objRight.getValue()));

		switch (equalityExpression.getOp()) {
		case NEQ:
			return (bEqual) ? Interpreter.A_FALSE : Interpreter.A_TRUE;
		case EQ:
			return (bEqual) ? Interpreter.A_TRUE : Interpreter.A_FALSE;
		default:
			runtimeError(
					"Unknown equality operator " + equalityExpression.getOp(),
					equalityExpression);
			throw new MitraError();
		}

	} 
	
	


	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseRelationalExpression(RelationalExpression)
	 */
	public MObject[] caseRelationalExpression(
			RelationalExpression relationalExpression) {
		MObject objLeft = visitSingleton(relationalExpression.getLhs());
		MObject objRight = visitSingleton(relationalExpression.getRhs());

		try {
			float iLeft = objLeft.castToReal(host.getMetamodelManager());
			float iRight = objRight.castToReal(host.getMetamodelManager());

			switch (relationalExpression.getOp()) {
			case LT:
				return (iLeft < iRight) ? Interpreter.A_TRUE
					: Interpreter.A_FALSE;
			case GT:
				return (iLeft > iRight) ? Interpreter.A_TRUE
					: Interpreter.A_FALSE;
			case LEQ:
				return (iLeft <= iRight) ? Interpreter.A_TRUE
					: Interpreter.A_FALSE;
			case GEQ:
				return (iLeft >= iRight) ? Interpreter.A_TRUE
					: Interpreter.A_FALSE;
			default:
				runtimeError("Unknown relational operator "
					+ relationalExpression.getOp(), relationalExpression);
				throw new MitraError();
			}
		} catch (Exception ex) {
			runtimeError("Error comparing values", relationalExpression, ex);
			throw new MitraError();
		}

	}

	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseMathExpression(MathExpression)
	 */
	public MObject[] caseMathExpression(MathExpression mathExpression) {
		MObject objLeft = visitSingleton(mathExpression.getLhs());
		MObject objRight = visitSingleton(mathExpression.getRhs());

		MObject[] result =
			host.operations.evalMath(mathExpression, objLeft, objRight);
		return result;
	}

	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseUnaryMathExpression(UnaryMathExpression)
	 */
	public MObject[] caseUnaryMathExpression(
			UnaryMathExpression unaryMathExpression) {
		MObject objOperand =
			visitSingleton(unaryMathExpression.getExpression());

		MObject[] result =
			host.operations.evalUnaryMathOperation(unaryMathExpression,
					objOperand);
		return result;
	}

	public MObject[] caseBooleanExpression(BooleanExpression booleanExpression) {

		MObject objLeft = visitSingleton(booleanExpression.getLhs());

		boolean bLeft;
		try {
			bLeft = objLeft.castToBoolean(host.getMetamodelManager());
		} catch (MetamodelNotFoundException ex) {
			runtimeError("Error casting left hand side argument",
					booleanExpression.getLhs(), ex);
			throw new MitraError();
		}
		switch (booleanExpression.getOp()) {
		case ANDSC:
			if (!bLeft) {
				return Interpreter.A_FALSE;
			}
			break;
		case ORSC:
			if (bLeft) {
				return Interpreter.A_TRUE;
			}
			break;
		}

		MObject objRight = visitSingleton(booleanExpression.getRhs());

		boolean bRight;
		try {
			bRight = objRight.castToBoolean(host.getMetamodelManager());
		} catch (MetamodelNotFoundException ex) {
			runtimeError("Error casting right hand side argument",
					booleanExpression.getRhs(), ex);
			throw new MitraError();
		}

		switch (booleanExpression.getOp()) {
		case ANDSC:
		case AND:
			return (bLeft && bRight) ? Interpreter.A_TRUE : Interpreter.A_FALSE;
		case ORSC:
		case OR:
			return (bLeft || bRight) ? Interpreter.A_TRUE : Interpreter.A_FALSE;
		default:
			runtimeError(
					"Unknown boolean operator: " + booleanExpression.getOp(),
					booleanExpression);
			throw new MitraError();
		}

	}

	/**
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseUnaryBooleanExpression(UnaryBooleanExpression)
	 */
	public MObject[] caseUnaryBooleanExpression(
			UnaryBooleanExpression unaryBooleanExpression) {
		MObject objLeft =
			visitSingleton(unaryBooleanExpression.getExpression());

		return (objLeft.castToBoolean(host.getMetamodelManager()))
			? Interpreter.A_FALSE : Interpreter.A_TRUE;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @todo internally, only actual types are used. That is, we need to
	 *       retrieve the declared type here.
	 * @see de.jevopi.mitra2.visitors.TraversingVisitor#caseUnaryCastExpression(UnaryCastExpression)
	 */
	public MObject[] caseUnaryCastExpression(
			UnaryCastExpression unaryCastExpression) {
		MObject objLeft = visitSingleton(unaryCastExpression.getExpression());

		Type typeLeft = objLeft.getActualType();
		Type typeRight = unaryCastExpression.getType();

		IMetamodel metamodelLeft = host.getMetamodel(typeLeft);
		IMetamodel metamodelRight = host.getMetamodel(typeRight);

		if (metamodelLeft.typeDistance(typeLeft, typeRight) >= 0) {
			// downcast
			return asArray(objLeft);
		}
		if (metamodelRight.typeDistance(typeRight, typeLeft) >= 0) {
			// upcast
			return asArray(objLeft);
		}
		runtimeError(
				"Cannot cast " + typeLeft + " to "
					+ unaryCastExpression.getType(), unaryCastExpression);
		throw new MitraError();
	}

	/**
	 * @param i_instanceOfExpression
	 * @return
	 */
	public MObject[] caseInstanceOfExpression(
			InstanceOfExpression instanceOfExpression) {
		MObject objLeft = visitSingleton(instanceOfExpression.getExpression());
		Type typeRight = instanceOfExpression.getType();

		// MObject wrapped =
		// host.getMetamodelManager().wrap(objLeft[0].getValue());
		// Type wrappedType = wrapped.getType();
		IMetamodel metamodel = host.getMetamodel(objLeft.getActualType());
		if (metamodel.typeDistance(objLeft.getActualType(), typeRight) >= 0) {
			return Interpreter.A_TRUE;
		}

		return Interpreter.A_FALSE;

	}

}
