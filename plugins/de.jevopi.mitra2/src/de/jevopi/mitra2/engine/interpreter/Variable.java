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

import java.util.ArrayList;
import java.util.List;

import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.mitra.VarDeclaration;

/**
 * Variable There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 */
public class Variable implements Comparable<Variable> {

	VarDeclaration variableDeclaration;

	MObject value;

	List<VariableListener> listeners;

	/**
	 * @param value
	 * @param variableDeclaration
	 */
	public Variable(VarDeclaration variableDeclaration, MObject value) {
		super();
		this.value = value;
		this.variableDeclaration = variableDeclaration;
	}

	public void addListener(VariableListener listener) {
		if (listeners == null) {
			listeners = new ArrayList<VariableListener>();
		}
		listeners.add(listener);
	}

	public void removeListener(VariableListener listener) {
		if (listeners != null) {
			listeners.remove(listener);
		}
	}

	private void fireVariableChanged() {
		if (listeners != null) {
			for (VariableListener listener : listeners) {
				listener.variableChanged(this);
			}
		}
	}

	public void setValue(MObject value) {
		this.value = value;
		fireVariableChanged();
	}

	/**
	 * @return the variableDeclaration
	 */
	public VarDeclaration getVariableDeclaration() {
		return variableDeclaration;
	}

	/**
	 * @return the value
	 */
	public MObject getValue() {
		return value;
	}

	/**
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Variable o) {
		return variableDeclaration.getName().compareTo(
				o.getVariableDeclaration().getName());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj==this) return true;
		if (!(obj instanceof Variable)) return false;
		return compareTo((Variable) obj)==0;
	}
	
	@Override
	public int hashCode() {
		return variableDeclaration.getName().hashCode();
	}

}
