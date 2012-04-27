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

package de.jevopi.mitra2.nativeoperations;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.internal.resources.VariableDescription;

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.mitra.IteratorExpression;
import de.jevopi.mitra2.mitra.NativeOperationInvocation;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.VarDeclaration;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 4, 2012
 */
public class NativeOperationResolver {
	protected Map<String, INativeOperation> nativeOperations = null;

	ProjectContext projectContext;

	public static boolean containsIteratorExpression(
			NativeOperationInvocation nativeOperationInvocation) {
		return nativeOperationInvocation.getArguments().size() == 1
			&& nativeOperationInvocation.getArguments().get(0) instanceof IteratorExpression;
	}

	public static VarDeclaration getIteratorExpressionLoopVariable(
			NativeOperationInvocation nativeOperationInvocation) {
		return ((IteratorExpression) nativeOperationInvocation.getArguments()
			.get(0)).getVariable().getVardecl();
	}

	/**
	 * @param i_metamodelManager
	 */
	public NativeOperationResolver(ProjectContext projectContext) {
		this.projectContext = projectContext;
	}

	public synchronized Map<String, INativeOperation> getNativeOperations() {
		if (nativeOperations == null) {
			nativeOperations = new HashMap<String, INativeOperation>();
			try {
				for (Class<?> clazz : INativeOperation.NATIVE_OPERATION_CLASSES) {
					INativeOperation nativeOperation;
					@SuppressWarnings("unchecked")
					Constructor<INativeOperation> constructor =
						(Constructor<INativeOperation>) clazz.getConstructors()[0];
					nativeOperation = constructor.newInstance(projectContext);
					nativeOperations.put(nativeOperation.getName(),
							nativeOperation);
				}
			} catch (Exception ex) {
				throw new IllegalStateException("Cannot load native classes",
					ex);
			}
		}
		return nativeOperations;
	}

	public List<INativeOperation>
			findMatchingNativeOperations(Type receiverType) {
		List<INativeOperation> matchingMethods =
			new ArrayList<INativeOperation>();
		for (INativeOperation nativeOperation : getNativeOperations().values()) {
			if (nativeOperation.acceptReceiver(receiverType)) {
				matchingMethods.add(nativeOperation);
			}
		}
		return matchingMethods;
	}

}
