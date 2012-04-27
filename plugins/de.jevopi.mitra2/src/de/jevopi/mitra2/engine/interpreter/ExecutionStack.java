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

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import de.jevopi.mitra2.message.MessageFormatter;
import de.jevopi.mitra2.mitra.MitraFactory;
import de.jevopi.mitra2.mitra.RuleDeclaration;

/**
 * ExecutionStack There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 */
public class ExecutionStack {

	public static RuleDeclaration ROOT;
	static {
		ROOT = MitraFactory.eINSTANCE.createRuleDeclaration();
		ROOT.setName("##ROOT##");
	}

	Stack<StackFrame> stack;

	/**
	 * Returns unmodifiable list of stack frames
	 * 
	 * @return
	 */
	public List<StackFrame> getStackFrames() {
		return Collections.unmodifiableList(stack);
	}

	/**
	 * 
	 */
	public ExecutionStack() {
		stack = new Stack<StackFrame>();
	}

	public void push(StackFrame stackFrame) {
		stack.push(stackFrame);
	}

	/**
	 * Removes the top rule invocation and its scope at the top of this stack
	 * and returns it.
	 * 
	 * @return
	 */
	public StackFrame pop() {
		return stack.pop();
	}

	/**
	 * Returns the top rule invocation and its scope at the top of this stack
	 * without removing it.
	 * 
	 * @return
	 */
	public StackFrame peek() {
		return stack.peek();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer strb = new StringBuffer();
		RuleDeclaration decl;
		int count = 50;
		for (int i=stack.size()-1; i>=0 && count>=0; i--,count--) { 
			StackFrame stackFrame = stack.get(i);
			decl = stackFrame.getRuleDeclaration();
			strb.append("\n  ");
			if (decl == null) {
				strb.append("#ROOT#");
			} else {
				strb.append(MessageFormatter.stackTraceLikeLocation(decl));
			}
		}
		return strb.toString();
	}

}
