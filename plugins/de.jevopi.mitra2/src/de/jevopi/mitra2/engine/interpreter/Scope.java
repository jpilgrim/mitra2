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
package de.jevopi.mitra2.engine.interpreter;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.mitra.VarDeclaration;

/**
 * Scope There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @since Mitra 1
 */
public class Scope {
	
	Map<VarDeclaration, Variable> vars = null;

	int iEmptyCounter = 0;

	/**
	 * Defines a new scope on top of this scope.
	 */
	void pushEmptyScope() {
		iEmptyCounter++;
	}

	/**
	 * Returns true if this scope has to be removed from the stack, too.
	 * 
	 * @return
	 */
	boolean popEmptyScope() {
		iEmptyCounter--;
		return iEmptyCounter < 0;
	}

	boolean isEmptyScope() {
		return iEmptyCounter > 0;
	}

	void init() {
		vars = new LinkedHashMap<VarDeclaration, Variable>();

	}

	public void addInstance(VarDeclaration decl) {
		if (vars == null) {
			init();
		}
		vars.put(decl, new Variable(decl, MObject.NOT_INITIALIZED));
	}

	/**
	 * @param decl
	 * @param value
	 * @return true, if value was not initialized before
	 */
	public boolean setValue(VarDeclaration decl, MObject value) {
		Variable var = (vars != null) ? vars.get(decl) : null;
		if (var == null) {
			throw new IllegalArgumentException("Variable " + decl
					+ " not declared");
		}
		boolean initialized = var.getValue()==MObject.NOT_INITIALIZED;
		var.setValue(value);
		return initialized;
	}

	/**
	 * @see de.feu.mitra.engine.collections.IScope#getValue(de.feu.mitra.VariableDeclaration)
	 */
	public MObject getValue(VarDeclaration decl) {
		Variable var = (vars != null) ? vars.get(decl) : null;
		if (var == null) {
			throw new IllegalArgumentException("Variable " + decl
					+ " not declared");
		}
		return var.getValue();
	}

	/**
	 * Returns all variables in current scope.
	 * 
	 * @return
	 */
	public Collection<Variable> getVariables() {
		if (vars != null) {
			return vars.values();
		} else {
			return Collections.emptyList();
		}
	}

	/**
	 * @see de.feu.mitra.engine.collections.IScope#containsInstance(de.feu.mitra.VariableDeclaration)
	 */
	public boolean containsInstance(VarDeclaration decl) {
		if (vars == null) {
			return false;
		}
		return vars.containsKey(decl);
	}

	public VarDeclaration findInstance(String name) {
		if (vars == null) {
			return null;
		}
		for (VarDeclaration vardecl : vars.keySet()) {
			if (vardecl.getName().equals(name)) {
				return vardecl;
			}
		}
		return null;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer strb = new StringBuffer();

		try {
			if (vars != null) {
				for (VarDeclaration decl : vars.keySet()) {
					if (strb.length() > 0) {
						strb.append("\n");
					}
					strb.append(String.format("%1$10s %2$10s = %3$s", decl
							.getType(), decl.getName(), vars.get(decl)
							.getValue()));
				}
			}
		} catch (Exception ex) {
			return "Error dumping scope: " + ex;
		}

		return strb.toString();
	}

}
