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
package de.jevopi.mitra2.exec;

import java.util.Collections;
import java.util.Map;

/**
 * IResultProcessor There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 */
public interface IResultProcessor {

	/**
	 * Simple result transfer object. Ensures all collections are not null.
	 * 
	 * @author Jens von Pilgrim
	 * @version $Revision: 961 $
	 * @since May 8, 2010
	 */
	public static class Result {
		public Map<String, Object> returnedObjects;

		/**
		 * @param i_returnedObjects
		 * @param i_errors
		 * @param i_warnings
		 */
		public Result(Map<String, Object> i_returnedObjects) {
			super();
			if (i_returnedObjects != null) {
				returnedObjects = i_returnedObjects;
			} else {
				returnedObjects = Collections.emptyMap();
			}

		}
	}

	/**
	 * Called when new result is available
	 * 
	 * @param i_plainResult
	 */
	void resultArrived(Result i_result);

}
