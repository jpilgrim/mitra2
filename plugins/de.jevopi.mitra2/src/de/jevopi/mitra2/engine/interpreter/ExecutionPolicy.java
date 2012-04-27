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

import de.jevopi.mitra2.MitraError;
import de.jevopi.mitra2.engine.TypeResolver;
import de.jevopi.mitra2.message.AbstractMessenger;
import de.jevopi.mitra2.message.IMessageAcceptor;
import de.jevopi.mitra2.metamodel.IMetamodel;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.mitra.Expression;
import de.jevopi.mitra2.mitra.Type;

/**
 * ExecutionPolicy There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @since Mitra 1
 */
public abstract class ExecutionPolicy extends AbstractMessenger {

	Interpreter host;

	/**
	 * @param host
	 */
	public ExecutionPolicy(Interpreter host) {
		this.host = host;
	}
	
	@Override
	protected IMessageAcceptor getMessageAcceptor() {
		return host.getMessageAcceptor();
	}
	
	
	protected final IMetamodel getMetamodel(Type type) {
		return getMetamodelManager().getMetamodel(type);
	}


	protected final MetamodelManager getMetamodelManager() {
		return host.getMetamodelManager();
	}
	
	protected final TypeResolver getTypeResolver() {
		return host.getTypeResolver();
	}
	
	/**
	 * Ensures array of {@link MObject} to contain exactly one element,
	 * otherwise a runtime error is emitted.
	 * @param expression the expression to evaluated by the host
	 * @return
	 */
	protected MObject visitSingleton(Expression expression) {
		MObject[] mObjects = host.visit(expression);
		if (mObjects.length!=1) {
			runtimeError(
					"Expected one argument, received "
						+ mObjects.length, expression);
			throw new MitraError();
		}
		return mObjects[0];
	}
	
	protected MObject[] asArray(MObject mObject) {
		return new MObject[] { mObject };
	}

}
