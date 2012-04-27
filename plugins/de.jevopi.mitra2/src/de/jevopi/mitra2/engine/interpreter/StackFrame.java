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
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.mitra.FormalParameter;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.VarDeclaration;

/**
 * StackFrame, contains scope stack and currently called rule.
 * <p>
 * Stack of scopes: Instead of creating a new scope for each block (or
 * whatever), the current scope contains a counter with empty scopes, i.e.
 * scopes with no variable declared. If a new variable is declared, a new scope
 * is created on the fly and the empty scope counter of the (old) current scope
 * is decremented.
 * 
 * @author Jens von Pilgrim
 */
public class StackFrame {

	public final static StackFrame TEST_STUB = new StackFrame(null, null) {};

	RuleDeclaration ruleDeclaration;
	EObject ruleInvocationLocation; // usually the rule invocation

	int id;

	List<Scope> scopes;

	Scope firstScope;

	private static int NEXT_ID = 1;
	
	// used for cycle detection
	int idCode = 0;

	public StackFrame(RuleDeclaration ruleDeclaration, EObject ruleInvocationLocation) {
		this.ruleDeclaration = ruleDeclaration;
		this.ruleInvocationLocation = ruleInvocationLocation;
		scopes = new ArrayList<Scope>();
		firstScope = new Scope();
		scopes.add(firstScope);
		id = NEXT_ID++;
		idCode = ruleDeclaration==null ? 0 : ruleDeclaration.hashCode();
	}

	public int getID() {
		return id;
	}
	
	int getIDCode() {
		return idCode;
	}

	/**
	 * @return the ruleDeclaration
	 */
	public RuleDeclaration getRuleDeclaration() {
		return ruleDeclaration;
	}
	
	public EObject getRuleInvocationLocation() {
		return ruleInvocationLocation;
	}

	public Scope currentScope() {
		return scopes.get(scopes.size() - 1);
	}

	public void enterBlock() {
		currentScope().pushEmptyScope();
	}

	public void leaveBlock() {
		if (currentScope().popEmptyScope()) {
			scopes.remove(scopes.size() - 1);
		}
	}

	
	
	public void declareVariable(VarDeclaration decl) {
		
		Scope currentScope = currentScope();
		if (currentScope.isEmptyScope()) {
			Scope scope = new Scope();
			currentScope.popEmptyScope();
			scopes.add(scope);
			currentScope = scope;
		}
		currentScope.addInstance(decl);
	}

	public boolean isDeclared(VarDeclaration decl) {
		Scope scope;
		for (int i = scopes.size() - 1; i >= 0; i--) {
			scope = scopes.get(i);
			if (scope.containsInstance(decl)) {
				return true;
			}
		}
		return false;
	}

	public VarDeclaration findVariableByName(String name) {
		Scope scope;
		VarDeclaration vardecl = null;
		for (int i = scopes.size() - 1; i >= 0; i--) {
			scope = scopes.get(i);
			vardecl = scope.findInstance(name);
			if (vardecl != null) {
				return vardecl;
			}
		}
		return null;
	}

	public void setValue(VarDeclaration decl, MObject value) {
		Scope scope;
		for (int i = scopes.size() - 1; i >= 0; i--) {
			scope = scopes.get(i);
			if (scope.containsInstance(decl)) {
		
				boolean firstAccess = scope.setValue(decl, value);
				
				if (firstAccess && decl.eContainer() instanceof FormalParameter) {
					idCode = idCode *  31 + decl.getName().hashCode() + value.getValue().hashCode();
				}
				
				return;
			}
		}
		throw new IllegalStateException("Variable not declared");
	}

	public MObject getValue(VarDeclaration decl)
			throws IllegalArgumentException {
		Scope scope;
		for (int i = scopes.size() - 1; i >= 0; i--) {
			scope = scopes.get(i);
			if (scope.containsInstance(decl)) {
				return scope.getValue(decl);
			}
		}

		for (int i = scopes.size() - 1; i >= 0; i--) {
			scope = scopes.get(i);
			if (scope.containsInstance(decl)) {
				return scope.getValue(decl);
			}
		}

		throw new IllegalArgumentException("Variable " + decl + " not declared");
	}

	/**
	 * Returns an unmodifiable list of all currently declared variables.
	 * 
	 * @return
	 */
	public List<Variable> getVariables() {
		List<Variable> allVars = new ArrayList<Variable>();
		for (Scope scope : scopes) {
			allVars.addAll(scope.getVariables());
		}
		return Collections.unmodifiableList(allVars);
	}

	public boolean hasVariables() {
		for (Scope scope : scopes) {
			if (!scope.isEmptyScope()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer strb = new StringBuffer();

		strb.append("Stack for rule " + ruleDeclaration + ":\n");
		for (Scope scope : scopes) {
			strb.append("---------\n");
			strb.append(String.valueOf(scope));
		}

		return strb.toString();
	}

	

}