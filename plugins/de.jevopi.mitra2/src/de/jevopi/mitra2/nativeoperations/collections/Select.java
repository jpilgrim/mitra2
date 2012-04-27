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

import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.CollectionMetamodel;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.mitracollections.MitraCollection;
import de.jevopi.mitra2.metamodel.mitracollections.MitraSequenceImpl;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.CollectionTypeSpec;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.Type;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 24, 2012
 */
public class Select extends AbstractCollectionOperationWithIteratorExpression {

	public final static String DESCRIPTION = "Returns a sub-collection "
		+ "with all elements for which the given expression is true.";

	public Select(ProjectContext i_projectContext) {
		super(i_projectContext);
	}

	/**
	 * @see de.jevopi.mitra2.nativeoperations.INativeOperation#getDescription()
	 */
	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
	
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
			CollectionMetamodel.createCollectionType(false, ordered, iteratorVariableType);
		return resultType;
	}

	/**
	 * @see de.jevopi.mitra2.nativeoperations.collections.AbstractCollectionOperationWithIteratorExpression#initResult(de.jevopi.mitra2.metamodel.MObject,
	 *      de.jevopi.mitra2.mitra.IteratorExpression)
	 */
	@Override
	protected MObject initResult(MObject i_receiver,
			IteratorExpression i_iteratorExpression) {

		Type receiverType = i_receiver.getActualType();
		Type typePar;

		// bag settings by default:
		boolean ordered = false;
		boolean unique = false;

		if (receiverType instanceof CollectionType) {
			typePar = ((CollectionType) receiverType).getTypePar();
			MitraCollection collection =
				(MitraCollection) i_receiver.getValue();
			ordered = collection.isOrdered();
			unique = collection.isUnique();
		} else {
			typePar = receiverType;
		}

		MObject result =
			CollectionMetamodel.createCollectionMObject(unique, ordered,
					typePar);

		return result;
	}

	/**
	 * @see de.jevopi.mitra2.nativeoperations.collections.AbstractCollectionOperationWithIteratorExpression#process(de.jevopi.mitra2.metamodel.MObject,
	 *      de.jevopi.mitra2.nativeoperations.collections.AbstractCollectionOperationWithIteratorExpression.ProcessResult)
	 */
	@Override
	protected void process(MObject v, MObject i_evalWithV, ProcessResult io_processResult) {
		boolean doSelect = (Boolean) i_evalWithV.getValue();
		if (doSelect)
			((MitraCollection) io_processResult.result.getValue()).add(v);
	}

}
