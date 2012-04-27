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
package de.jevopi.mitra2.api;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.engine.interpreter.ExecutionStack;
import de.jevopi.mitra2.engine.interpreter.StackFrame;
import de.jevopi.mitra2.message.MessageFormatter;

/**
 * IMitraContext There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 */
public interface IMitraContext {

	/**
	 * Returns the current stack frame, which contains all visible variables at
	 * this position.
	 * 
	 * @return
	 */
	StackFrame getStackFrame();

	/**
	 * Returns the project context, {@link ProjectContext#getPathHandler() paths
	 * to modules etc.}, {@link ProjectContext#getAllRules() cached rules} and
	 * other project related information.
	 * 
	 * @return
	 */
	ProjectContext getProjectContext();

	/**
	 * Returns the rule stack frame, it contains all rules. This is not as
	 * exactly as the element stack, as it only contains the rules and not the
	 * exact elements.
	 * 
	 * @return
	 */
	ExecutionStack getExecutionStack();

	/**
	 * Returns a list of all semantic elements, i.e. Mitra AST elements. The
	 * first element in the list is usually a dummy, and the last element is the
	 * current element processed by the interpreter (which usually causes a Java
	 * rule to be called. These elements can be used to retrieve the
	 * {@link MessageFormatter location} in the source code.
	 * 
	 * @return
	 */
	List<EObject> getElementStack();
}
