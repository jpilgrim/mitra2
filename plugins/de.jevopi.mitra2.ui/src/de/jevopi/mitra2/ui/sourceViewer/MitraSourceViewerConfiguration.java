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
package de.jevopi.mitra2.ui.sourceViewer;

import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.hover.ProblemAnnotationHover;

import de.jevopi.mitra2.ui.MitraUiModule;

/**
 * Mitra source viewer for enabling Mitra specific hovers.
 * 
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 4, 2012
 * @see MitraUiModule#bindSourceViewerConfiguration()
 * @see http://www.eclipse.org/forums/index.php/mv/tree/161389/#page_top
 */
public class MitraSourceViewerConfiguration extends
		XtextSourceViewerConfiguration {

	@Override
	public ITextHover getTextHover(ISourceViewer sourceViewer,
			String contentType) {
		return new ComposedTextHover(
				new ProblemAnnotationHover(),
				//Xtext 1.x: new ProblemHover(sourceViewer),
				new MitraTextHover(sourceViewer)
		);
	}

}
