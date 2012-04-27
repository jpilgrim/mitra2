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

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.jevopi.mitra2.api.IMitraContext;
import de.jevopi.mitra2.context.ProjectContext;

/**
 * MitraAPIContext There should really be more documentation here.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Mitra 1
 */
public class InterpreterMitraContext implements IMitraContext {

	Interpreter interpreter;
	
	public InterpreterMitraContext(Interpreter interpreter) {
		this.interpreter = interpreter;
	}

	@Override
	public StackFrame getStackFrame() {
		return interpreter.currentStackFrame();
	}

	@Override
	public ProjectContext getProjectContext() {
		return interpreter.getProjectContext();
	}

	@Override
	public ExecutionStack getExecutionStack() {
		return interpreter.executionStack;
	}

	@Override
	public List<EObject> getElementStack() {
		return interpreter.getElementStack();
	}

	
	
	
}
