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

import java.util.List;

import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.nativeoperations.collections.Add;
import de.jevopi.mitra2.nativeoperations.collections.AddAll;
import de.jevopi.mitra2.nativeoperations.collections.AsSequence;
import de.jevopi.mitra2.nativeoperations.collections.AsSet;
import de.jevopi.mitra2.nativeoperations.collections.Collect;
import de.jevopi.mitra2.nativeoperations.collections.Count;
import de.jevopi.mitra2.nativeoperations.collections.Excludes;
import de.jevopi.mitra2.nativeoperations.collections.ExcludesAll;
import de.jevopi.mitra2.nativeoperations.collections.Exists;
import de.jevopi.mitra2.nativeoperations.collections.Flatten;
import de.jevopi.mitra2.nativeoperations.collections.ForAll;
import de.jevopi.mitra2.nativeoperations.collections.Includes;
import de.jevopi.mitra2.nativeoperations.collections.IncludesAll;
import de.jevopi.mitra2.nativeoperations.collections.IsEmpty;
import de.jevopi.mitra2.nativeoperations.collections.NotEmpty;
import de.jevopi.mitra2.nativeoperations.collections.Reject;
import de.jevopi.mitra2.nativeoperations.collections.Remove;
import de.jevopi.mitra2.nativeoperations.collections.RemoveAll;
import de.jevopi.mitra2.nativeoperations.collections.Select;
import de.jevopi.mitra2.nativeoperations.collections.Size;
import de.jevopi.mitra2.nativeoperations.collections.ordered.At;
import de.jevopi.mitra2.nativeoperations.collections.ordered.First;
import de.jevopi.mitra2.nativeoperations.collections.ordered.Last;
import de.jevopi.mitra2.nativeoperations.strings.FirstToUpper;

/**
 * Interface for all native operations, i.e., operations called via "->".
 * 
 * <h3>Some remarks on types and native operations</h3>
 * 
 * For a given native operation invocation on a variable v, such as
 * 
 * <pre>
 * v->native(arg1, arg2, ...)
 * </pre>
 * <ol>
 * <li>the receiver type is the type of v</li>
 * <li>the argument types is a list of the types of the given arguments. If no
 * arguments are passed, this list is to be empty (and not null!)</li>
 * <li>the type of the native operation is the evaluated type returned by the
 * operation (for the given receiver and argument types).</li>
 * </ol>
 * 
 * In case of iterator expressions, such as
 * 
 * <pre>
 * v->nativeWithIter(e|expresssion-with-e)
 * </pre>
 * <ol>
 * <li>the receiver type is the type of v</li>
 * <li>the argument types contains a single type, which is to be the evaluated
 * type of the iterator expression (expression-with-e)</li>
 * <li>the type of the native operation is the evaluated type returned by the
 * operation (for the given receiver and the iterator expression type).</li>
 * </ol>
 * The type of the iterator variable e is always the type of the receiver's
 * elements (if the receiver is a collection), or of the receiver itself (if the
 * receiver is no collection). This is true for all native operations, thus it
 * is assured before calling the native operation methods. The type of variable
 * e is never passed to the native operation, as it is of no importance -- only
 * the type of the iterator expression is important (which may be evaluated to
 * the type of the iterator, e.g., in case of the select operation).
 * <p>
 * In both caes, the return type of the native operation may vary depending on
 * the receiver and argument/iterator expression types.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 1, 2012
 */
public interface INativeOperation {

	public final static Class<?>[] NATIVE_OPERATION_CLASSES = {
		// OCL iterator operations
		Collect.class,
		Select.class, Reject.class,
		Exists.class, ForAll.class,

		// collections
		// non OCL:
		Add.class, Remove.class,
		AddAll.class, RemoveAll.class,
		// OCL:
		AsSequence.class, AsSet.class, 
		Count.class, Excludes.class,
		ExcludesAll.class, Flatten.class, Includes.class, IncludesAll.class,
		IsEmpty.class, NotEmpty.class, Size.class,

		// ordered collections (sequence, orderedSet)
		// OCL:
		At.class, First.class, Last.class,
		
		// String:
		FirstToUpper.class

	};
	
	public static enum InvocationType {
		ARGUMENTS, ITERATOR
	}

	/**
	 * Returns the name of this native operation. This name is to be unique,
	 * that is two different native operation cannot have the same name. If
	 * different functionality is to be provided with the same name, this
	 * functionality is to be implemented in a single method.
	 * 
	 * @return
	 */
	String getName();

	String getSignature(Type receiverType);
	
	InvocationType getInvocationType();

	String getDescription();

	/**
	 * Returns true if this native operation can be called with the given
	 * receiver type.
	 * 
	 * @param receiverType
	 * @return
	 */
	boolean acceptReceiver(Type receiverType);

	/**
	 * Returns true if this native operation can be called with the given
	 * receiver and argument types. This is the only method in which the
	 * argument types are actually checked, calls to
	 * {@link #getType(Type, List)} or even {@link #invoke(MObject, List)}
	 * ignore the arguments and their types if possible.
	 * <p>
	 * In case of iterator expressions, the argument type is the type of the
	 * iterator expression.
	 * 
	 * @param i_receiverType
	 * @param i_argumentTypes must not be null, use empty list for no arguments
	 * @return true if types are accepted
	 */
	boolean acceptArgumentCallTypes(Type i_receiverType,
			List<Type> i_argumentTypes);

	/**
	 * Returns true if this native operation accepts an iterator expression.
	 * This is only the case for very few operations, such as select, reject, or
	 * collect.
	 * 
	 * @param iteratorExpression
	 */
	boolean acceptIteratorExpressionTypes(Type receiverType,
			Type loopVariableType, Type iteratorExpressionType);

	/**
	 * Returns the expected parameter types for a given receiver type. This
	 * method is usually only used for content assist.
	 * 
	 * @param receiverType
	 * @return list of types or empty list, does not return null
	 */
	List<? extends Type> getParameterTypes(Type receiverType);

	/**
	 * Returns the type of the result when calling this method on the given
	 * receiver with the given argument types. If possible, argument types are
	 * to be ignored, that is, no exception is thrown even if the argument types
	 * do not match the method signature. In order to determine the correct
	 * types, call {@link #acceptArgumentCallTypes(Type, List)}.
	 * 
	 * In case of iterator expressions, the argument type is the type of the
	 * iterator expression.
	 * 
	 * @return the calculated receiver type, or null, if arguments do not match
	 * @throws IllegalArgumentException if operation does not support this kind
	 *             of call
	 */
	Type getTypeFromArgumentCall(Type i_receiverType, List<Type> i_argTypes);

	/**
	 * Called if the argument passed to the native method is an iterator
	 * expression. In this case, the returned type (as the type of the iterator
	 * expression) depends on the semantics of the operation. E.g., in case of
	 * collect, the returned typs equals the type of the expression of the
	 * iterator expression, while in case of select the type equals the type of
	 * the loop variable (the iterator expression type is to be boolean).
	 * 
	 * @param i_receiverType
	 * @param i_iteratorLoopVariableType
	 * @param innerIteratorExpressionType type of the expression in the iterator
	 *            expression
	 * @return
	 * @throws IllegalArgumentException if operation does not support this kind
	 *             of call
	 */
	Type getTypeFromIteratorExpressionCall(Type i_receiverType,
			Type i_iteratorLoopVariableType, Type innerIteratorExpressionType);

	/**
	 * Invokes this method on the given receiver and with the given arguments.
	 * 
	 * @param receiver
	 * @param arguments
	 * @return the result or null, if method is void.
	 */
	MObject invokeWithArguments(MObject receiver, List<MObject> arguments);
	
	MObject invokeWithIterator(MObject receiver, IteratorExpression iteratorExpression);
}
