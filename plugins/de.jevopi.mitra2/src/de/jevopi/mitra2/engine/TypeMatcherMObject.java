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

package de.jevopi.mitra2.engine;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.mitra.Type;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 4, 2012
 */
public class TypeMatcherMObject extends TypeMatcher {
	MObject[] args;

	public TypeMatcherMObject(ProjectContext projectContext, MObject[] args) {
		super(projectContext);
		this.args = args;
	}

	@Override
	public Type getTypeOfArgument(int index) {
		return args[index].getActualType();
	}

	@Override
	public int getNumberOfArguments() {
		return args.length;
	}

	@Override
	public Type getTypeOfRetArg(int index) {
		throw new IndexOutOfBoundsException("No return types are handled here");
	}
}