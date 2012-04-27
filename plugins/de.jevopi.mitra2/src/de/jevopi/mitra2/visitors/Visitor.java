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
package de.jevopi.mitra2.visitors;

import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;

import de.jevopi.mitra2.mitra.util.MitraSwitch;

/**
 * Switch based visitor with warning and error handling.
 * 
 * @author Jens von Pilgrim
 */
public class Visitor<RET> extends MessengerMitraSwitch<RET> {

	

	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(Visitor.class.getName());

	/**
	 * Return value for case methods. If null is returned, switch tries to call
	 * super actualtype methods.
	 */
	public static final String BREAK = "break";

	/**
	 * Returned by case METHOD if case for super actualtype should be called.
	 */
	public static final Object CONTINUE = null;

	protected MitraSwitch<RET> delegator;

	/**
	 * 
	 */
	public Visitor() {
		delegator = this;
	}

	public void setDelegator(MitraSwitch<RET> i_delegator) {
		if (i_delegator == null) {
			throw new NullPointerException("delegator must not be null");
		}
		delegator = i_delegator;
	}

	/**
	 * This method should be used instead of {@link #doSwitch(EObject)} in order
	 * to get delegator called, if a delegator is registered.
	 * 
	 * @param element
	 * @return
	 */
	public RET visit(EObject element) {
		return delegator.doSwitch(element);
	}

	/**
	 * @see de.feu.mitra.util.MitraSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public RET defaultCase(EObject obj) {

		String strVisitor = this.getClass().getSimpleName();
		String strType = obj.getClass().getSimpleName();
		if (strType.endsWith("Impl")) {
			strType = strType.substring(0, strType.length() - "Impl".length());
		}
		String strPar = strType.substring(0, 1).toLowerCase()
				+ strType.substring(1);
		String strMethodName = "case" + strType;

		Exception ex = new Exception();
		StackTraceElement[] ste = ex.getStackTrace();

		StackTraceElement el;

		String strTest = "no test";
		for (int i = ste.length - 1; i > 0; i--) {
			el = ste[i];
			if (el.getClassName().startsWith("de.feu")) {
				String strC = el.getClassName().substring(
						el.getClassName().lastIndexOf(".") + 1);
				strTest = "{@link " + strC + "#" + el.getMethodName() + "()}";
				break;
			}
		}
		String strCaller = "not called yet";

		for (int i = 0; i < ste.length; i++) {
			el = ste[i];

			if (el.getMethodName().startsWith("case")) {
				String strX = el.getMethodName().substring("case".length());
				String strC = el.getClassName().substring(
						el.getClassName().lastIndexOf(".") + 1);

				strCaller = "{@link " + strC + "#" + el.getMethodName() + "("
						+ strX + ")}";
				break;
			}
		}

		log.warning("Implement the following METHOD in " + strVisitor);

		StringBuffer strb = new StringBuffer();
		strb.append("\n/**");
		strb.append("\n * {@inheritDoc}");
		strb.append("\n * <br/>Indirectly called by ").append(strCaller);
		strb.append("\n * <br/>test case ").append(strTest);
		strb.append("\n * @see mitra.util.MitraSwitch#").append(strMethodName)
				.append("(mitra.").append(strType).append(")");
		strb.append("\n */");
		strb.append("\n@Override");
		strb.append("\npublic Object ").append(strMethodName).append("(")
				.append(strType).append(" ").append(strPar).append(") {");
		strb.append("\n\treturn null;\n}");

		log.warning(strb.toString());

		return super.defaultCase(obj);
	}

	

}
