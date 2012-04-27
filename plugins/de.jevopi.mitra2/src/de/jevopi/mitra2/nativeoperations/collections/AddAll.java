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
import de.jevopi.mitra2.nativeoperations.AbstractNativeOperation;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 6, 2012
 */
public class AddAll extends AbstractNativeOperation {
	/**
	 * Logger for this class
	 */
	// @SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger log = Logger.getLogger(AddAll.class.getName());

	public AddAll(ProjectContext projectContext) {
		super(projectContext);
	}

	public final static String DESCRIPTION =
		"Adds the given argument to this collection, similar to the Java "
			+ "Collection.addAll() method. If you want to create a copy and leave this "
			+ "collection unmodified, use union(Collection<T> obj).";

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

	@Override
	public boolean acceptArgumentCallTypes(Type i_receiverType,
			List<Type> i_argumentTypes) {
		if (!acceptReceiver(i_receiverType)) return false;
		CollectionType ct = (CollectionType) i_receiverType;
		Type parType = ct.getTypePar();

		for (Type t : i_argumentTypes) {
			if (t instanceof CollectionType) {
				CollectionType ctp = (CollectionType) t;
				if (!getMetamodelManager().isSubType(ctp.getTypePar(), parType)) {
					return false;
				}
			} else {
				if (!getMetamodelManager().isSubType(t, parType)) {
					return false;
				}
			}
		}

		return true;
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

		boolean success = true;
		for (MObject obj : i_arguments) {
			if (obj.getValue() instanceof MitraCollection) {
				MitraCollection argCollection =
					(MitraCollection) obj.getValue();
				for (MObject contained : argCollection) {
					success &= collection.add(contained);
				}
			} else {
				success &= collection.add(obj);
			}
		}

		if (!success) {
			projectContext.runtimeWarning("Add all element failed",
					projectContext.getCurrentInterpreterLocation());
		}

		validatePost(collection, i_arguments);

		return null;
	}

	/**
	 * @param collection
	 * @param obj
	 */
	protected void validatePost(MitraCollection collection,
			List<MObject> i_arguments) {
		for (MObject obj : i_arguments) {
			if (obj.getValue() instanceof MitraCollection) {
				MitraCollection argCollection =
					(MitraCollection) obj.getValue();
				for (MObject contained : argCollection) {
					if (!validatePost(collection, contained)) return;
				}
			} else {
				if (!validatePost(collection, obj)) return;
			}
		}
	}

	protected boolean validatePost(MitraCollection collection, MObject obj) {
		if (obj.getValue() instanceof EObject) {
			EObject eobj = (EObject) obj.getValue();
			EObject container = eobj.eContainer();

			if (container == null && eobj.eContainmentFeature() != null) {
				projectContext.runtimeWarning(
						"Added referenced to uncontained element",
						projectContext.getCurrentInterpreterLocation());
				return false;
			}
			try {
				if (container != null) {
					String name = getNameFeature(eobj);
					if (name != null) {
						for (EObject child : container.eContents()) {

							String other = getNameFeature(child);
							if (child != eobj && name.equals(other)) {
								projectContext
									.runtimeWarning(
											"Found another element with name "
												+ name
												+ " in container, may cause problems during serialization",
											projectContext
												.getCurrentInterpreterLocation());
								return false;
							}
						}

					}

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		return true;
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
