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

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.CollectionMetamodel;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.mitracollections.MitraCollection;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.Type;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 6, 2012
 */
public class Collect extends AbstractCollectionOperationWithIteratorExpression {

	public final static String DESCRIPTION = "Returns a collection "
		+ "with all results of iterater expression."
		+ "If the receiver collection is ordered (or a singleton), "
		+ "then a Sequence is returned, otherwise a Bag.";

	public Collect(ProjectContext i_projectContext) {
		super(i_projectContext);
	}

	/**
	 * @see de.jevopi.mitra2.nativeoperations.INativeOperation#getDescription()
	 */
	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
	
	/**
	 * @see de.jevopi.mitra2.nativeoperations.collections.AbstractCollectionOperationWithIteratorExpression#initResult(de.jevopi.mitra2.metamodel.MObject,
	 *      de.jevopi.mitra2.mitra.IteratorExpression)
	 */
	@Override
	protected MObject initResult(MObject i_receiver,
			IteratorExpression i_iteratorExpression) {
		Type typePar =
			projectContext.getTypeResolver().visitSingleton(i_iteratorExpression.getExpression());

		boolean ordered = true;
		if (i_receiver.getActualType() instanceof CollectionType) {
			MitraCollection receiverCollection =
				(MitraCollection) i_receiver.getValue();
			ordered = receiverCollection.isOrdered();
		}

		MObject result =
			CollectionMetamodel
				.createCollectionMObject(false, ordered, typePar);

		return result;
	}

	/**
	 * @see de.jevopi.mitra2.nativeoperations.collections.AbstractCollectionOperationWithIteratorExpression#process(de.jevopi.mitra2.metamodel.MObject,
	 *      de.jevopi.mitra2.nativeoperations.collections.AbstractCollectionOperationWithIteratorExpression.ProcessResult)
	 */
	@Override
	protected void process(MObject v, MObject i_evalWithV, ProcessResult io_processResult) {
		((MitraCollection)io_processResult.result.getValue()).add(i_evalWithV);
	}

}
