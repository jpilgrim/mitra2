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

import static de.jevopi.mitra2.metamodel.PrimitiveMetamodel.VOID;

import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.mitracollections.MitraCollection;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.Type;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 27, 2012
 */
public class Remove extends AbstractCollectionOperationWithElementTypeArgument {
	/**
	 * Logger for this class
	 */
	// @SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger log = Logger.getLogger(Remove.class.getName());

	public Remove(ProjectContext projectContext) {
		super(projectContext);
	}

	public final static String DESCRIPTION =
		"Removess the given argument to this collection, similar to the Java "
			+ "Collection.remove() method. If you want to create a copy and leave this "
			+ "collection unmodified, use excluding(T obj).";

	/**
	 * @see de.jevopi.mitra2.nativeoperations.INativeOperation#getDescription()
	 * @since Feb 6, 2012
	 */
	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	/**
	 * @see de.jevopi.mitra2.nativeoperations.AbstractNativeOperation#getType(de.jevopi.mitra2.mitra.Type,
	 *      java.util.List)
	 * @since Feb 6, 2012
	 */
	@Override
	public Type getTypeFromArgumentCall(Type i_receiverType,
			List<Type> i_argumentTypes) {
		return VOID;
	}

	/**
	 * @see de.jevopi.mitra2.nativeoperations.AbstractNativeOperation#acceptReceiver(de.jevopi.mitra2.mitra.Type)
	 * @since Feb 6, 2012
	 */
	@Override
	public boolean acceptReceiver(Type i_receiverType) {
		return i_receiverType instanceof CollectionType;
	}

	/**
	 * @see de.jevopi.mitra2.nativeoperations.INativeOperation#invoke(de.jevopi.mitra2.metamodel.MObject,
	 *      java.util.List)
	 * @since Feb 6, 2012
	 */
	@Override
	public MObject invokeWithArguments(MObject receiver,
			List<MObject> i_arguments) {
		MitraCollection collection = (MitraCollection) receiver.getValue();
		MObject obj = i_arguments.get(0);

		boolean success = collection.remove(obj);

		if (!success) {
			projectContext.runtimeWarning("Remove element failed",
					projectContext.getCurrentInterpreterLocation());
		}

		return null;
	}

	/**
	 * @param eobj
	 * @return
	 */
	private String getNameFeature(EObject eobj) {
		EStructuralFeature feature =
			eobj.eClass().getEStructuralFeature("name");
		if (feature != null) {
			Object val = eobj.eGet(feature);
			if (val != null) return val.toString();
		}
		return null;
	}
}
