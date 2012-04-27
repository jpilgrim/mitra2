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
import de.jevopi.mitra2.mitra.Type;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 4, 2012
 */
public class TypeMatcherType extends TypeMatcher {
	Type[] argTypes;

	Type[] retTypes;

	/**
	 * @param argTypes
	 */
	public TypeMatcherType(ProjectContext projectContext, Type[] argTypes) {
		super(projectContext);
		this.argTypes = argTypes;
		retTypes = null;
	}

	/**
	 * @param argTypes
	 * @param retTypes return types
	 */
	public TypeMatcherType(ProjectContext projectContext, Type[] argTypes,
			Type[] retTypes) {
		super(projectContext);
		this.argTypes = argTypes;
		this.retTypes = retTypes;
	}

	/**
	 * @see de.feu.mitra.engine.RuleResolver.TypeMatcher#getTypeOfArgument(int)
	 */
	@Override
	public Type getTypeOfArgument(int index) {
		return argTypes[index];
	}

	/**
	 * @see de.feu.mitra.engine.RuleResolver.TypeMatcher#getNumberOfArguments()
	 */
	@Override
	public int getNumberOfArguments() {
		return argTypes.length;
	}

	/**
	 * @see de.feu.mitra.engine.RuleResolver.TypeMatcher#getNumberOfRetArgs()
	 */
	@Override
	public int getNumberOfRetArgs() {
		return (retTypes != null) ? retTypes.length : -1;
	}

	/**
	 * @see de.feu.mitra.engine.RuleResolver.TypeMatcher#getTypeOfRetArg(int)
	 */
	@Override
	public Type getTypeOfRetArg(int i_index) {
		return retTypes[i_index];
	}
}