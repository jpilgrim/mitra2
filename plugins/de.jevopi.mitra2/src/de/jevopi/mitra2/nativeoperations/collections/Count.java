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

import static de.jevopi.mitra2.metamodel.PrimitiveMetamodel.INT;

import java.util.List;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.mitracollections.MitraCollection;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.nativeoperations.AbstractNativeOperation;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 1, 2012
 */
public class Count extends AbstractNativeOperation {

	public static final String DESCRIPTION =
		"Count the number of times the given arguments is contained in the receiver."
			+ "This can also be evaluated if the receiver is a simple object.";

	public Count(ProjectContext projectContext) {
		super(projectContext);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public Type getTypeFromArgumentCall(Type i_receiverType,
			List<Type> i_argumentTypes) {
		return INT;
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
		MObject argument = i_arguments.get(0);
		int rawValue = computeRawValue(i_receiver, argument);
		MObject returnValue = new MObject(INT, rawValue);
		return returnValue;
	}

	protected int computeRawValue(MObject i_receiver, MObject i_argument) {

		Type receiverType = i_receiver.getActualType();
		if (receiverType instanceof CollectionType) {
			MitraCollection collection =
				(MitraCollection) i_receiver.getValue();
			return collection.count(i_argument);
		}
		// simple object:
		return i_receiver.equals(i_argument) ? 1 : 0;

	}

}
