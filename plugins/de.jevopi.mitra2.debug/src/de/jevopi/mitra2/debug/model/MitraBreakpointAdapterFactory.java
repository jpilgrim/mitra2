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
package de.jevopi.mitra2.debug.model;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * Creates a line breakpoint adapter for the generated mitra editor.
 * 
 * @since Mitra 1
 */
public class MitraBreakpointAdapterFactory implements IAdapterFactory {

	/**
	 * Returns the breakpoint adapter
	 * 
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object,
	 *      java.lang.Class)
	 */
	@Override
	public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes") Class adapterType) {

		if (adaptableObject instanceof XtextEditor) {
			XtextEditor xtextEditor = (XtextEditor) adaptableObject;
			if ("de.jevopi.mitra2.Mitra".equals(xtextEditor.getLanguageName())) {
				ITextEditor editorPart = (ITextEditor) adaptableObject;
				IResource resource = (IResource) editorPart.getEditorInput()
						.getAdapter(IResource.class);
				if (resource != null) {
					String extension = resource.getFileExtension();
					if (extension != null && extension.equals("mitra")) {
						return new MitraLineBreakpointAdapter();
					}
				}
			}
		}
		return null;
	}

	/**
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Class[] getAdapterList() {
		return new Class[] { IToggleBreakpointsTarget.class };
	}
}
