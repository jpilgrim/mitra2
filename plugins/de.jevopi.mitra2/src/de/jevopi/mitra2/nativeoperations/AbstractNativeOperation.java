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

package de.jevopi.mitra2.nativeoperations;

import static de.jevopi.mitra2.metamodel.PrimitiveMetamodel.VOID;

import java.util.Collections;
import java.util.List;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.metamodel.PrimitiveMetamodel;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.utils.StringUtils;

/**
 * Base implementation to be used for subclasses. This implementation assumes
 * the following signature:
 * 
 * <pre>
 * void NAME()
 * </pre>
 * 
 * That is, {@link #VOID} is returned in {@link #getType(Type, List)}, and
 * {@link #getParameterTypes(Type)} always returns an empty list.
 * {@link #acceptReceiver(Type)} accepts any type except {@link #VOID}.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 1, 2012
 */
public abstract class AbstractNativeOperation implements INativeOperation {

	protected ProjectContext projectContext;

	public AbstractNativeOperation(ProjectContext projectContext) {
		this.projectContext = projectContext;
	}

	/**
	 * Convenience method, returns project context's metamodel manager.
	 */
	protected MetamodelManager getMetamodelManager() {
		return projectContext.getMetamodelManager();
	}

	/**
	 * @see de.jevopi.mitra2.nativeoperations.INativeOperation#getName()
	 */
	@Override
	public String getName() {
		return StringUtils.firstToLower(getClass().getSimpleName());
	}

	/**
	 * @see de.jevopi.mitra2.nativeoperations.INativeOperation#getSignature(de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	public String getSignature(Type i_receiverType) {
		StringBuilder strb = new StringBuilder();
		strb.append(getName());
		strb.append("(");
		List<? extends Type> parameterTypes = getParameterTypes(i_receiverType);
		for (int i = 0; i < parameterTypes.size(); i++) {
			if (i != 0) strb.append(", ");
			strb.append(parameterTypes.get(i));
		}
		strb.append(")");
		return strb.toString();
	}
	
	@Override
	public InvocationType getInvocationType() {
		return InvocationType.ARGUMENTS;
	}

	/**
	 * Default implementation, accept all types except void.
	 */
	@Override
	public boolean acceptReceiver(Type i_receiverType) {
		return !VOID.equals(i_receiverType);
	}

	/**
	 * Helper method to be called by sub classes if method accepts a single
	 * integer argument.
	 * 
	 * @param i_argumentTypes
	 * @return
	 */
	protected boolean firstArgumentIsInteger(List<Type> i_argumentTypes) {
		return i_argumentTypes.size() == 1
			&& getMetamodelManager().isSubType(i_argumentTypes.get(0),
					PrimitiveMetamodel.INT);
	}

	/**
	 * Default implementation for parameterless operations. Receiver type is
	 * checked via {@link #acceptReceiver(Type)}, argumentOrIteratorTypes must
	 * be empty.
	 */
	@Override
	public boolean acceptArgumentCallTypes(Type i_receiverType, List<Type> i_argumentTypes) {
		return acceptReceiver(i_receiverType)
			&& i_argumentTypes.isEmpty();
	}

	@Override
	public boolean acceptIteratorExpressionTypes(Type receiverType,
			Type loopVariableType, Type iteratorExpressionType) {
		return false;
	}

	/**
	 * Returns empty list.
	 */
	@Override
	public List<? extends Type> getParameterTypes(Type i_receiverType) {
		return Collections.emptyList();
	}

	/**
	 * Returns {@link #VOID}
	 */
	@Override
	public Type getTypeFromArgumentCall(Type i_receiverType,
			List<Type> argumentOrIteratorExpTypes) {
		return VOID;
	}
	
	/** 
	 * Default implementation throws an {@link IllegalArgumentException}.
	 */
	@Override
	public Type getTypeFromIteratorExpressionCall(Type i_receiverType,
			Type i_iteratorVariableType, Type expressionType) {
		throw new IllegalArgumentException();
	}
	
	

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	public MObject invokeWithIterator(MObject receiver,
			IteratorExpression iteratorExpression) {
		throw new IllegalArgumentException("Iterator expression not supported");
	}

}
