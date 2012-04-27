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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.mitra.Module;
import de.jevopi.mitra2.mitra.RuleDeclaration;

/**
 * ExecutionContext of a transformation, container for all used models
 * (metamodels via managers, models via loaders, and traces via registry), and
 * currently set arguments and result for micro transformation execution.
 * 
 * @author Jens von Pilgrim
 * @since Sep 30, 2008
 */
public class ExecutionContext {

	RuleDeclaration invokedRule;

	/** Arguments, i.e. values of formal parameters */
	List<MObject> arguments;

	Map<String, MObject> results;

	/**
	 * @param i_invokedRule
	 * @param i_arguments
	 * @param i_results
	 * @param i_projectContext
	 */
	public ExecutionContext(RuleDeclaration i_invokedRule,
			List<MObject> i_arguments) {
		invokedRule = i_invokedRule;
		arguments = i_arguments;
		results = new HashMap<String, MObject>();
	}

	public RuleDeclaration getInvokedRule() {
		return invokedRule;
	}

	Module getInvokedModule() {
		return MitraUtils.retrieveModule(invokedRule);
	}

	/**
	 * @return
	 */
	public List<MObject> getArguments() {
		return arguments;
	}

	public Map<String, MObject> getResults() {
		return results;
	}

}
