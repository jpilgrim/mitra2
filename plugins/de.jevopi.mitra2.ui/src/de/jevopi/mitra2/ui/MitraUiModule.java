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
package de.jevopi.mitra2.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import de.jevopi.mitra2.ui.linking.MitraLinkingDiagnosticMessageProvider;
import de.jevopi.mitra2.ui.resources.MitraResourceSetProvider;
import de.jevopi.mitra2.ui.sourceViewer.MitraSourceViewerConfiguration;

/**
 * Use this class to register components to be used within the IDE.
 */
public class MitraUiModule extends de.jevopi.mitra2.ui.AbstractMitraUiModule {
	public MitraUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	public Class<? extends ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider() {
		return MitraLinkingDiagnosticMessageProvider.class;
	}

	public Class<? extends XtextSourceViewerConfiguration>
			bindSourceViewerConfiguration() {
		return MitraSourceViewerConfiguration.class;
	}
	
	public Class<? extends IResourceSetProvider> bindIResourceSetProvider() {
		return MitraResourceSetProvider.class;
	}
}
