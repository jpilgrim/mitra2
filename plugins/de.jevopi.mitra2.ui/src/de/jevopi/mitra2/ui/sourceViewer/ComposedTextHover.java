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

import java.util.logging.Logger;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;

import de.jevopi.utils.StringUtils;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Feb 5, 2012
 */
public class ComposedTextHover implements ITextHover {
	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger log = Logger.getLogger(ComposedTextHover.class.getName());

	ITextHover[] containedHovers;

	/**
	 * 
	 */
	public ComposedTextHover(ITextHover... i_containedHovers) {
		containedHovers = i_containedHovers;
	}

	/**
	 * @see org.eclipse.jface.text.ITextHover#getHoverInfo(org.eclipse.jface.text.ITextViewer,
	 *      org.eclipse.jface.text.IRegion)
	 * @since Feb 5, 2012
	 */
	@SuppressWarnings("deprecation")
	@Override
	public String getHoverInfo(ITextViewer i_textViewer, IRegion i_hoverRegion) {
		StringBuilder strb = new StringBuilder();
		for (ITextHover hover : containedHovers) {
			try {
				String message =
					hover.getHoverInfo(i_textViewer, i_hoverRegion);
				if (message != null) {
					if (strb.length() > 0) {
						strb.append("\n"
							+ "_______________________________________________" +
									"_________________________________\n\n");
					}
					strb.append(message);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if (strb.length() == 0) return null;
		return StringUtils.wrapByWord(strb.toString(), 80, 4, "-*");
	}

	/**
	 * @see org.eclipse.jface.text.ITextHover#getHoverRegion(org.eclipse.jface.text.ITextViewer,
	 *      int)
	 * @since Feb 5, 2012
	 */
	@Override
	public IRegion getHoverRegion(ITextViewer i_textViewer, int i_offset) {
		return new Region(i_offset, 0);
	}

}
