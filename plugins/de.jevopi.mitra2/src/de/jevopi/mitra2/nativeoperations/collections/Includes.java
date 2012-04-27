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

import static de.jevopi.mitra2.metamodel.PrimitiveMetamodel.BOOLEAN;

import java.util.List;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.mitracollections.MitraCollection;
import de.jevopi.mitra2.metamodel.mitracollections.MitraOrderedCollection;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.nativeoperations.AbstractNativeOperation;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 1, 2012
 */
public class Includes extends AbstractNativeOperation {

	public static final String DESCRIPTION =
		"Returns true if the receiver contains the given argument. "
			+ "This is also true if the receiver is a simple object and equals the argument.";

	/**
	 * @param i_metamodelManager
	 */
	public Includes(ProjectContext projectContext) {
		super(projectContext);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public Type getTypeFromArgumentCall(Type i_receiverType, List<Type> i_argumentTypes) {
		return BOOLEAN;
	}

	/**
	 * Returns true if receiver is accepted and if argument list contains
	 * exactly one element. The element type is not checked, as any type is
	 * accepted.
	 */
	@Override
	public boolean acceptArgumentCallTypes(Type i_receiverType,
			List<Type> i_argumentTypes) {
		return acceptReceiver(i_receiverType)
			&& i_argumentTypes.size() == 1;
	}

	@Override
	public MObject invokeWithArguments(MObject i_receiver, List<MObject> i_arguments) {
		MObject argument = i_arguments.get(0);
		boolean rawValue = computeRawValue(i_receiver, argument);
		MObject returnValue = new MObject(BOOLEAN, rawValue);
		return returnValue;
	}

	protected boolean computeRawValue(MObject i_receiver, MObject i_argument) {

		Type receiverType = i_receiver.getActualType();
		if (receiverType instanceof CollectionType) {
			if (!(i_receiver.getValue() instanceof MitraCollection)) {
				throw new IllegalArgumentException(
					"Cannot apply include on non-collections");
			}
			MitraCollection collection = (MitraCollection) i_receiver.getValue();
			return collection.contains(i_argument);
		}
		// simple object:
		return i_receiver.equals(i_argument);

	}

}
