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

package de.jevopi.mitra2.nativeoperations.collections;

import static java.util.Collections.singleton;

import java.util.List;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.engine.interpreter.Interpreter;
import de.jevopi.mitra2.metamodel.CollectionMetamodel;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.metamodel.mitracollections.MitraCollection;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.CollectionTypeSpec;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.VarDeclaration;
import de.jevopi.mitra2.nativeoperations.AbstractNativeOperation;
import de.jevopi.mitra2.nativeoperations.INativeOperation.InvocationType;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 6, 2012
 */
public abstract class AbstractCollectionOperationWithIteratorExpression extends
		AbstractNativeOperation {

	protected static class ProcessResult {
		MObject result;
		boolean doBreak;

		public ProcessResult(MObject i_result, boolean i_doBreak) {
			result = i_result;
			doBreak = i_doBreak;
		}
	}

	public AbstractCollectionOperationWithIteratorExpression(
			ProjectContext i_projectContext) {
		super(i_projectContext);
	}

	/**
	 * @see de.jevopi.mitra2.nativeoperations.AbstractNativeOperation#getSignature(de.jevopi.mitra2.mitra.Type)
	 * @since Feb 6, 2012
	 */
	@Override
	public String getSignature(Type i_receiverType) {
		StringBuilder strb = new StringBuilder();
		strb.append(getName());
		strb.append("( v | iterator-expression-with-v )");
		return strb.toString();
	}

	
	@Override
	public InvocationType getInvocationType() {
		return InvocationType.ITERATOR;
	}
	
	/**
	 * {@link #acceptReceiver(Type) Receiver must be accepted} and argumentTypes
	 * must contain one type.
	 */
	@Override
	public boolean acceptArgumentCallTypes(Type i_receiverType,
			List<Type> i_argumentOrIteratorExpTypes) {
		return false;
	}

	@Override
	public boolean acceptIteratorExpressionTypes(Type receiverType,
			Type loopVariableType, Type iteratorExpressionType) {
		return true;
	}

	/**
	 * Returns a collection type, the element type is the type of the iterator
	 * expression.
	 */
	@Override
	public Type getTypeFromArgumentCall(Type i_receiverType,
			List<Type> argumentOrIteratorExpTypes) {
		throw new IllegalArgumentException("Argument call not supported");
	}
	
	/** 
	 * Default implementation for iterators over collection returns
	 * collection of expression type, e.g., as in collect.
	 */
	@Override
	public Type getTypeFromIteratorExpressionCall(Type receiverType,
			Type iteratorVariableType, Type expressionType) {
		boolean ordered = true;
		if (receiverType instanceof CollectionType) {
			CollectionType receiverCollectionType =
				(CollectionType) receiverType;
			ordered =
				receiverCollectionType.getCollectionType() == CollectionTypeSpec.ORDERED_SET
					|| receiverCollectionType.getCollectionType() == CollectionTypeSpec.SEQUENCE;
		}

		Type resultType =
			CollectionMetamodel.createCollectionType(false, ordered, expressionType);
		return resultType;
	}
	
	@Override
	public MObject
			invokeWithArguments(MObject receiver, List<MObject> arguments) {
		throw new IllegalArgumentException("Argument call not supported");
	}

	@Override
	public MObject invokeWithIterator(MObject i_receiver,
			IteratorExpression i_iteratorExpression) {
		Iterable<MObject> collection;
		if (i_receiver.getValue() instanceof MitraCollection) {
			collection = (MitraCollection) i_receiver.getValue();
		} else {
			collection = singleton(i_receiver);
		}

		Interpreter interpreter = projectContext.getInterpreter();
		ProcessResult processResult =
			new ProcessResult(initResult(i_receiver, i_iteratorExpression),
				false);

		VarDeclaration loopVarDecl =
			i_iteratorExpression.getVariable().getVardecl();
		interpreter.enterBlock();
		interpreter.currentStackFrame().declareVariable(loopVarDecl);

		Type loopVariableType =
			projectContext.getTypeResolver().getType(
					i_iteratorExpression.getVariable().getVardecl());

		MetamodelManager metamodelManager = getMetamodelManager();
		for (MObject v : collection) {
			if (metamodelManager.isSubType(v.getActualType(), loopVariableType)) {
				interpreter.currentStackFrame().setValue(loopVarDecl, v);
				MObject evalWithV = interpreter.visit(i_iteratorExpression)[0];
				process(v, evalWithV, processResult);
				if (processResult.doBreak) break;
			}
		}
		interpreter.leaveBlock();

		return processResult.result;
	}

	/**
	 * Called by {@link #invoke(MObject, List, IteratorExpression)} before the
	 * first element of the collection is processed. This basically initializes
	 * the result of the operation, and could even be the final result in case
	 * of an empty collection.
	 */
	protected abstract MObject initResult(MObject i_receiver,
			IteratorExpression iteratorExpression);

	/**
	 * @param v the element v 
	 * @param i_evalWithV
	 * @param io_processResult
	 */
	protected abstract void process(MObject v, MObject i_evalWithV,
			ProcessResult io_processResult);

}
