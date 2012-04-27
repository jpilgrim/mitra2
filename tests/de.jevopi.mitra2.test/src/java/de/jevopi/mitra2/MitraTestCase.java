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

package de.jevopi.mitra2;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import de.jevopi.mitra2.api.IMultiReturn;
import de.jevopi.mitra2.context.PathHandler.ResourceType;
import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.traces.TraceRecord;
import de.jevopi.mitra2.traces.TracesFactory;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 8, 2012
 */
@Ignore
public class MitraTestCase extends TestCase {

	protected ProjectContext projectContext;

	@Before
	public void initContext() {
		projectContext = new ProjectContext();
	}

	@Test
	/**
	 * Execute:
	 * 
	 * main(from simpleER::Schema schema): (create simpleUML:Package package)
	 * 
	 */
	public void sample() {

//		IMultiReturn result =
//			executeMitra(projectContext, "transformation:main", // fqn module and rule 
//					argumentFromFile("schema", "input.xmi"));

	}

	protected Object argumentFromFile(String argumentName, String fileName) throws Exception {
		Object object = MitraUtils.loadModel(projectContext, fileName);
		return object;
	}

	public IMultiReturn executeMitra(String fqnRule, Object... arguments) {
		return executeMitra(fqnRule,
				TracesFactory.eINSTANCE.createTraceRecord(), arguments);
	}

//	public IMultiReturn executeMitra(String fqnRule, TraceRecord traceRecord,
//			Object... arguments) {
//		
//	}

}
