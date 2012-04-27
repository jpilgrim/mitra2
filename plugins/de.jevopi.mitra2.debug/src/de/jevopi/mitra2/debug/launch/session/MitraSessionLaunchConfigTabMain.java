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
package de.jevopi.mitra2.debug.launch.session;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

/**
 * MitraSessionLaunchConfigTabMain
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Mitra 1
 */
public class MitraSessionLaunchConfigTabMain extends
		AbstractLaunchConfigurationTab {

	private ModifyListener fBasicModifyListener = new ModifyListener() {
		@Override
		public void modifyText(ModifyEvent evt) {
			// Object data = evt.data;
			updateLaunchConfigurationDialog();
		}
	};

	private Button fileDialogButton;

	private Button selectOAWFileButton;

	private Text selectOAWFileText;

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {

		Group group = new Group(parent, SWT.BORDER);
		setControl(group);
		group.setText("Mitra Module File");
		group.setSize(300, 100);
		group.setLayout(new GridLayout(3, false));
		GridData gd = new GridData();
		gd.widthHint = 400;
		selectOAWFileButton = createRadioButton(group,
				"Use this MitraEngine File");
		selectOAWFileButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				boolean selection = selectOAWFileButton.getSelection();
				fileDialogButton.setEnabled(selection);
				selectOAWFileText.setEnabled(selection);
				selectOAWFileButton.setSelection(true);
			}
		});

		selectOAWFileText = new Text(group, SWT.BORDER);
		selectOAWFileText.setLayoutData(gd);
		selectOAWFileText.addModifyListener(fBasicModifyListener);
		fileDialogButton = createPushButton(group, "Browse", null);
		fileDialogButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				handleFileSelection();
			}
		});
		selectOAWFileText.setEnabled(false);
		fileDialogButton.setEnabled(false);

	}

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	@Override
	public String getName() {
		return "Main";
	}

	private void handleFileSelection() {

		FileDialog fileDialog = new FileDialog(getShell());
		String dslFilter = "*.de.feu.mitra";
		String[] filterExtensions = { dslFilter };
		fileDialog.setFilterExtensions(filterExtensions);
		fileDialog.open();
		String mitraFile = fileDialog.getFilterPath() + "/"
				+ fileDialog.getFileName();
		selectOAWFileText.setText(mitraFile);

	}

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
	}

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
	}

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

}
