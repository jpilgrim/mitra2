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

import java.util.Collection;
import java.util.List;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.PrimitiveMetamodel;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.nativeoperations.AbstractNativeOperation;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 1, 2012
 */
public class IncludesAll extends AbstractNativeOperation {

	public final static Type TYPE = PrimitiveMetamodel.BOOLEAN;
	public static final String DESCRIPTION =
		"Returns true if the receiver contains the all elements of the given argument (collection). "
			+ "This can also be evaluated for simple objects (both receiver or argument).";

	public IncludesAll(ProjectContext projectContext) {
		super(projectContext);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public Type getTypeFromArgumentCall(Type i_receiverType,
			List<Type> i_argumentTypes) {
		return TYPE;
	}

	/**
	 * Returns true if receiver is accepted and if argument list contains
	 * exactly one element. The element type is not checked, as any type is
	 * accepted.
	 */
	@Override
	public boolean acceptArgumentCallTypes(Type i_receiverType,
			List<Type> i_argumentTypes) {
		return acceptReceiver(i_receiverType) && i_argumentTypes.size() == 1;
	}

	@Override
	public MObject invokeWithArguments(MObject i_receiver,
			List<MObject> i_arguments) {
		boolean rawValue = computeRawValue(i_receiver, i_arguments);
		MObject returnValue = new MObject(TYPE, rawValue);
		return returnValue;
	}

	protected boolean computeRawValue(MObject i_receiver,
			List<MObject> i_arguments) {

		Type receiverType = i_receiver.getActualType();
		Type argumentType = i_arguments.get(0).getActualType();
		Object argument = i_arguments.get(0).getValue();

		if (receiverType instanceof CollectionType) {
			Collection<?> receiverCollection =
				(Collection<?>) i_receiver.getValue();
			if (argumentType instanceof CollectionType) {
				Collection<?> argumentCollection = (Collection<?>) argument;
				return receiverCollection.containsAll(argumentCollection);
			}

			return receiverCollection.contains(argument);

		}

		// simple object:
		Object thisObject = i_receiver.getValue();
		if (argumentType instanceof CollectionType) {
			Collection<?> argumentCollection = (Collection<?>) argument;
			return argumentCollection.contains(thisObject);
		}

		if (argument == null) {
			return argument == thisObject;
		}
		return argument.equals(thisObject);

	}

}
