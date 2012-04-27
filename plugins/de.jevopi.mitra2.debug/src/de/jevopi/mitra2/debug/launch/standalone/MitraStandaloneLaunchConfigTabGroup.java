/*******************************************************************************
 * Copyright (c) 2012 FernUniversitaet in Hagen
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/

package de.jevopi.mitra2.debug.launch.standalone;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.EnvironmentTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.sourcelookup.SourceLookupTab;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Jan 31, 2012
 */
public class MitraStandaloneLaunchConfigTabGroup extends
		AbstractLaunchConfigurationTabGroup {

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTabGroup#createTabs(org.eclipse.debug.ui.ILaunchConfigurationDialog,
	 *      java.lang.String)
	 */
	@Override
	public void createTabs(ILaunchConfigurationDialog i_dialog, String i_mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new EnvironmentTab(), new CommonTab(), new SourceLookupTab() };
		setTabs(tabs);
	}

}
