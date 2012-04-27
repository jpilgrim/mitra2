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
import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.message.AbstractMessenger;
import de.jevopi.mitra2.message.IMessageAcceptor;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.metamodel.MetamodelManager.MetamodelNotFoundException;
import de.jevopi.mitra2.metamodel.PrimitiveMetamodel;
import de.jevopi.mitra2.mitra.AssignmentOperator;
import de.jevopi.mitra2.mitra.MathExpression;
import de.jevopi.mitra2.mitra.MathOperator;
import de.jevopi.mitra2.mitra.PPOperator;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.UnaryMathExpression;
import de.jevopi.mitra2.mitra.UnaryMathOperator;

/**
 * Helper class for static binding and execution encapsulating all native
 * operations such as addition. Checks operations preconditions (during static
 * binding) and evaluates operations (during execution).
 * 
 * @author Jens von Pilgrim
 */
public class OperationsPolicy extends AbstractMessenger {

	// protected MetamodelManager metmodelManager;
	public static final Type[] A_INT = new Type[] {
		PrimitiveMetamodel.INT
	};

	private ProjectContext projectContext;

	public OperationsPolicy(Interpreter host) {
		projectContext = host.getProjectContext();
	}

	protected MetamodelManager getMetamodelManager() {
		return projectContext.getMetamodelManager();
	}

	@Override
	protected IMessageAcceptor getMessageAcceptor() {
		return projectContext.getMessageAcceptor();
	}

	public MObject[] evalUnaryMathOperation(
			UnaryMathExpression unaryMathExpression, MObject operand) {
		UnaryMathOperator op = unaryMathExpression.getOp();

		int iValue = toInt(operand);
		switch (op) {
		case PLUS:
			break;
		case MINUS:
			iValue = -iValue;
			break;
		}
		return new MObject[] {
			getMetamodelManager().wrap(iValue)
		};
	}

	/**
	 * Used for evaluating pre- and postfix operations (++ or --). This method
	 * should be called twice for a feature access: Firstly for the prefix
	 * operation, the result of this operation is to be returned by the caller
	 * later, and secondly for the postfix operation, which only changes the
	 * value of the variable but not of the return value.
	 * 
	 * @param featureAccess not accessed here, only used for locating error
	 *            messages
	 * @param op the operator, i.e. the prefix or postfix operator of the
	 *            featurea access
	 * @param operand the object to be modified
	 * @return
	 */
	public MObject evalPrePostfixOperation(PPOperator op, MObject operand) {
		if (op == PPOperator.NULL) {
			return operand;
		}
		int iValue = toInt(operand);

		switch (op) {
		case DEC:
			iValue--;
			break;
		case INC:
			iValue++;
			break;
		}
		return getMetamodelManager().wrap(iValue);
	}

	public MObject[] evalMath(MathExpression mathExpression, MObject left,
			MObject right) {
		MathOperator op = mathExpression.getOp();
		Type typeLeft = left.getActualType();
		Type typeRight = right.getActualType();

		if (op == MathOperator.ADD) {
			if (isReal(typeLeft) && isReal(typeRight)) {
				return new MObject[] {
					getMetamodelManager().wrap(toReal(left) + toReal(right))
				};
			}
			if (isInt(typeLeft) && isInt(typeRight)) {
				return new MObject[] {
					getMetamodelManager().wrap(toInt(left) + toInt(right))
				};
			}
			if (isString(typeLeft) || isString(typeRight)) {
				StringBuilder strb = new StringBuilder(toString(left));
				strb.append(toString(right));
				return new MObject[] {
					getMetamodelManager().wrap(strb.toString())
				};
			}
			runtimeError("Cannot add " + left + " to " + right, mathExpression);
			throw new MitraError();
		}
		// sub, mul, div
		if (isReal(typeLeft) && isReal(typeRight)) {
			float fLeft = toReal(left);
			float fRight = toReal(right);
			switch (op) {
			case SUB:
				return new MObject[] {
					getMetamodelManager().wrap(fLeft - fRight)
				};
			case MUL:
				return new MObject[] {
					getMetamodelManager().wrap(fLeft * fRight)
				};
			case DIV:
				if (fRight == 0) {
					runtimeError("Division by zero", mathExpression);
					throw new MitraError();
				}
				return new MObject[] {
					getMetamodelManager().wrap(fLeft / fRight)
				};

			}
		} else if (isInt(typeLeft) && isInt(typeRight)) {
			int iLeft = toInt(left);
			int iRight = toInt(right);
			switch (op) {
			case SUB:
				return new MObject[] {
					getMetamodelManager().wrap(iLeft - iRight)
				};
			case MUL:
				return new MObject[] {
					getMetamodelManager().wrap(iLeft * iRight)
				};
			case DIV:
				if (iRight == 0) {
					runtimeError("Division by zero", mathExpression);
					throw new MitraError();
				}
				return new MObject[] {
					getMetamodelManager().wrap(iLeft / iRight)
				};

			}
		}

		runtimeError("Cannot " + op.getName() + " " + left.getActualType()
			+ " with " + right.getActualType(), mathExpression);
		throw new MitraError();
	}

	/**
	 * Handles addition, subtraction or concatenation in assignment expression.
	 * 
	 * @param i_operator ( +=, -= )
	 * @param item, isMany() == false
	 * @param value, isMany() == false
	 * @return
	 * @throws MetamodelNotFoundException
	 */
	public MObject evalMath(AssignmentOperator i_operator, MObject left,
			MObject right) {
		Type typeLeft = left.getActualType();
		Type typeRight = right.getActualType();

		if (isInt(typeLeft)) {
			int iLeft = (Integer) left.getValue();
			int iRight = right.castToInteger(getMetamodelManager());
			switch (i_operator) {
			case ADD:
				return getMetamodelManager().wrap(iLeft + iRight);
			case SUB:
				return getMetamodelManager().wrap(iLeft - iRight);
			}
		} else if (isReal(typeLeft)) {
			float fLeft = (Float) left.getValue();
			float fRight = right.castToReal(getMetamodelManager());
			switch (i_operator) {
			case ADD:
				return getMetamodelManager().wrap(fLeft + fRight);
			case SUB:
				return getMetamodelManager().wrap(fLeft - fRight);
			}
		} else if (isString(typeLeft)) {
			String strRight = right.castToString(getMetamodelManager());
			String strLeft = (String) left.getValue();
			if (i_operator == AssignmentOperator.ADD) {
				String strNewValue =
					new StringBuffer(strLeft).append(strRight).toString();
				return getMetamodelManager().wrap(strNewValue);
			}
		}

		throw new IllegalArgumentException("Cannot apply operator "
			+ i_operator + " on types " + typeLeft + " and " + typeRight);
	}

	private String toString(MObject mobj) {
		return mobj.castToString(getMetamodelManager());
	}

	private int toInt(MObject mobj) {
		return mobj.castToInteger(getMetamodelManager());
	}

	private float toReal(MObject mobj) {
		return mobj.castToReal(getMetamodelManager());
	}

	protected boolean isString(Type type) throws MetamodelNotFoundException {
		return getMetamodelManager().getMetamodel(type).typeDistance(type,
				PrimitiveMetamodel.STRING) >= 0;
	}

	protected boolean isInt(Type type) throws MetamodelNotFoundException {
		return getMetamodelManager().getMetamodel(type).typeDistance(type,
				PrimitiveMetamodel.INT) >= 0;
	}

	protected boolean isReal(Type type) throws MetamodelNotFoundException {
		return getMetamodelManager().getMetamodel(type).typeDistance(type,
				PrimitiveMetamodel.REAL) >= 0;
	}

}
