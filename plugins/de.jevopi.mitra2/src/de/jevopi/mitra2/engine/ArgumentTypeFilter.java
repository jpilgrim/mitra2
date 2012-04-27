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

import static de.jevopi.utils.Filter.FilterResult.ACCEPT;
import static de.jevopi.utils.Filter.FilterResult.SKIP;
import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.mitra.InferredVarDeclaration;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.VarDeclaration;
import de.jevopi.utils.Filter;

public class ArgumentTypeFilter implements Filter<RuleDeclaration> {

	final Type[] argumentTypes;
	final ProjectContext projectContext;
	Boolean allArgumentTypesSpecified;

	public ArgumentTypeFilter(ProjectContext projectContext,
			Type[] argumentTypes) {
		this.argumentTypes = argumentTypes;
		this.projectContext = projectContext;
		allArgumentTypesSpecified = null;
	}

	public boolean areAllArgumentTypesSpecified() {
		if (allArgumentTypesSpecified == null) {
			allArgumentTypesSpecified = true;
			for (int i = 0; i < argumentTypes.length; i++) {
				if (argumentTypes[i] == null) {
					allArgumentTypesSpecified = false;
					break;
				}
			}
		}
		return allArgumentTypesSpecified;
	}

	/**
	 * Convenience method, as {@link VarDeclaration#getType()} may return null
	 * in case of {@link InferredVarDeclaration}.
	 * 
	 * @param varDeclaration
	 * @return
	 */
	protected Type getType(VarDeclaration varDeclaration) {
		Type type = varDeclaration.getType();
		if (type == null) {
			type =
				projectContext.getTypeResolver().caseVarDeclaration(
						varDeclaration)[0];
		}
		return type;
	}

	@Override
	public FilterResult apply(RuleDeclaration element) {
		if (element.getFormalParameters().size() != argumentTypes.length) {
			return SKIP;
		}

		for (int i = 0; i < argumentTypes.length; i++) {
			if (argumentTypes[i] != null) {

				Type parType =
					getType(element.getFormalParameters().get(i).getVardecl());

				if (projectContext.getMetamodelManager().calcTypeDistance(
						argumentTypes[i], parType) < 0) {
					return SKIP;
				}

			}
		}
		return ACCEPT;
	}
}