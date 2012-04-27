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

import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.traces.TraceRecord;

/**
 * Some look up maps for resolving opposite of unidirectional links and other
 * rule related caches.
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Jan 30, 2012
 */
public class SessionContext {

	protected ProjectContext projectContext;

	protected TraceRegistry traceRegistry;

	protected TraceRecord traceRecord;

	protected TriggerMatcher triggerMatcher;

	/**
	 * 
	 */
	public SessionContext(ProjectContext projectContext, TraceRecord traceRecord) {
		this.projectContext = projectContext;
		traceRegistry = new TraceRegistry(projectContext);
		this.traceRecord = traceRecord;
		traceRegistry.registerTraceRecord(traceRecord);

		triggerMatcher = new TriggerMatcher(traceRegistry);

	}

	/**
	 * @return the traceRecord
	 */
	public TraceRecord getTraceRecord() {
		return traceRecord;
	}

	public TraceRegistry getTraceRegistry() {
		return traceRegistry;
	}

	/**
	 * @return
	 */
	public ProjectContext getProjectContext() {
		return projectContext;
	}

}
