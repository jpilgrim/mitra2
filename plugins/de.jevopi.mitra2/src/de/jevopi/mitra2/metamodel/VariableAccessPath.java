/*******************************************************************************
 * Copyright (c) 2012 Jens von Pilgrim
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 **************************************************************************** */
package de.jevopi.mitra2.metamodel;

import org.eclipse.emf.ecore.EObject;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.VariableAccess;

/**
 * Encapsulates a path to a feature of a model actualtype instance. It contains
 * the variable declaration and a possible index. The path does not contain the
 * variable instance itself. E.g. the following line
 * 
 * <pre>
 * a.b.c
 * </pre>
 * 
 * consists of an access to the variable <i>a</i> and a feature path <i>b.c</i>.
 * Thus the feature path contains the variable declaration of <i>a</i> and two
 * {@link FeaturePathItem}s [<i>b</i>, <i>c</i>]. </p> Relationship
 * {@link VariableAccess} and {@link VariableAccessPath}: A feature path is a
 * feature access with resolved index and METHOD argument expressions.
 * <p>
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @param <T> This generic is usually used with types {@link MObject} (during
 *            execution) or {@link Type} during resolving of invocations.
 */
public class VariableAccessPath<T> extends FeatureAccessPath<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6159720686890978163L;

	/**
	 * The original feature access.
	 */
	VariableAccess variableAccess;

	private ProjectContext projectContext;

	/**
	 * @param variableAccess must not be null
	 */
	public VariableAccessPath(ProjectContext projectContext,
			VariableAccess variableAccess) {
		/* variableAccess must not be null */
		if (variableAccess == null) {
			throw new NullPointerException(
					"Argument variableAccess must not be null");
		}
		this.projectContext = projectContext;
		this.variableAccess = variableAccess;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder strb = new StringBuilder();

		if (getLocation() == null) {
			strb.append('?');
		} else {
			strb.append(getVariableAccess().getVariable().getName());
		}

		for (FeaturePathItem<?> item : this) {
			if (item.getFeatureDescription().isnativeOperation()) {
				strb.append("->");
			} else { // field or method
				strb.append(".");
			}
			strb.append(item.toString());
		}

		return strb.toString();

	}

	/**
	 * @see de.jevopi.mitra2.metamodel.FeatureAccessPath#getReceiverType()
	 */
	@Override
	public Type getReceiverType() {
		return projectContext.getTypeResolver().getType(
				variableAccess.getVariable());
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.FeatureAccessPath#getLocation()
	 * @since Feb 1, 2012
	 */
	@Override
	public EObject getLocation() {
		return variableAccess;
	}

	public VariableAccess getVariableAccess() {
		return variableAccess;
	}
	
	
}
