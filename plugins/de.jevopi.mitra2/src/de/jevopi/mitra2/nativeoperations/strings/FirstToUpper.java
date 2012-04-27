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

package de.jevopi.mitra2.nativeoperations.strings;

import static de.jevopi.mitra2.metamodel.PrimitiveMetamodel.INT;
import static de.jevopi.mitra2.metamodel.PrimitiveMetamodel.STRING;
import static de.jevopi.mitra2.metamodel.PrimitiveMetamodel.isString;

import java.util.List;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.PrimitiveMetamodel;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.nativeoperations.AbstractNativeOperation;
import de.jevopi.utils.StringUtils;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Mar 9, 2012
 */
public class FirstToUpper extends AbstractNativeOperation {

	public FirstToUpper(ProjectContext projectContext) {
		super(projectContext);
	}

	/**
	 * @return
	 */
	@Override
	public String getDescription() {
		return "returns the string with the first letter changed to upper case if necessary";
	}
	
	@Override
	public boolean acceptReceiver(Type i_receiverType) {
		return isString(i_receiverType);
	}
	
	@Override
	public Type getTypeFromArgumentCall(Type i_receiverType,
			List<Type> argumentOrIteratorExpTypes) {
		return STRING;
	}

	/**
	 * @param receiver
	 * @param arguments
	 * @return
	 */
	@Override
	public MObject
			invokeWithArguments(MObject receiver, List<MObject> arguments) {
		String s = (String) receiver.getValue();
		String result = StringUtils.firstToUpper(s);
		MObject returnValue = new MObject(STRING, result);
		return returnValue;
	}

}
