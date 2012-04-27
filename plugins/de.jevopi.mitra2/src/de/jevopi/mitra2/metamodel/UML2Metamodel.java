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
package de.jevopi.mitra2.metamodel;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;

import de.jevopi.mitra2.mitra.Type;

/**
 * Manager for UML2 metamodel. This manager is based on EMF, the following
 * properties are recognized:
 * <ul>
 * <li>version---UML2 version number, default: "3.0.0", others: "2.0.0"</li>
 * </ul>
 * The nsURI is automatically set to "http://www.eclipse.org/uml2/3.0.0/UML" (or
 * "http://www.eclipse.org/uml2/2.0.0/UML" resp.).
 * 
 * @author Jens von Pilgrim
 */
public class UML2Metamodel extends EMFMetamodel {
	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(UML2Metamodel.class
		.getName());

	String strVersion;

	/**
	 * 
	 */
	public UML2Metamodel() {
		strVersion = "3.0.0";
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.EMFMetamodel#init(de.jevopi.mitra2.mitra.metamodel.MetamodelManager)
	 */
	@Override
	public void init(MetamodelManager manager) {
		if ("2.0.0".equals(strVersion)) {
			super.setProperty(NS_URI, "http://www.eclipse.org/uml2/2.0.0/UML");
		} else if ("2.1.0".equals(strVersion)) {
			super.setProperty(NS_URI, "http://www.eclipse.org/uml2/2.1.0/UML");
		} else if ("3.0.0".equals(strVersion)) {
			super.setProperty(NS_URI, "http://www.eclipse.org/uml2/3.0.0/UML");
		} else {
			String nsuri = "http://www.eclipse.org/uml2/" + strVersion + "/UML";
			log.info("UML version " + strVersion + " unknown, trying " + nsuri);
			super.setProperty(NS_URI, nsuri);
		}
		super.init(manager);
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.EMFMetamodel#setProperty(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void setProperty(String name, String value) {
		if (name.equals("version")) {
			strVersion = value;
		}
		if (log.isLoggable(Level.WARNING)) {
			log.warning("Property \"" + name + "\" not recognized");
		}
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.EMFMetamodel#doGetTypeForClass(org.eclipse.emf.ecore.EClassifier,
	 *      boolean)
	 */
	@Override
	public Type getTypeForClass(EClassifier classifier) {
		if (classifier instanceof EDataType) {
			String cname = classifier.getName();
			if ("Boolean".equals(cname)
				|| classifier.getInstanceClassName().equals("boolean")) {
				return PrimitiveMetamodel.BOOLEAN;
			}
		}

		return super.getTypeForClass(classifier);
	}

}
