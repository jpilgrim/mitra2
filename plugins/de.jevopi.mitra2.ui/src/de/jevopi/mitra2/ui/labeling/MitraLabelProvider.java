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
package de.jevopi.mitra2.ui.labeling;

import java.util.logging.Logger;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;

import de.jevopi.mitra2.metamodel.FeatureFieldDescription;
import de.jevopi.mitra2.metamodel.FeatureMethodDescription;
import de.jevopi.mitra2.metamodel.FeatureNativeOperationDescription;
import de.jevopi.mitra2.mitra.FeatureField;
import de.jevopi.mitra2.mitra.FeatureMethodInvocation;
import de.jevopi.mitra2.mitra.MetamodelDeclaration;
import de.jevopi.mitra2.mitra.Module;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.nativeoperations.INativeOperation;

/**
 * Provides labels for a EObjects.
 * 
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class MitraLabelProvider extends DefaultEObjectLabelProvider {
	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger log = Logger.getLogger(MitraLabelProvider.class.getName());
	
	@Inject
	public MitraLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}
	
	String text(RuleDeclaration rule) {
		return rule.toString();
	}
	
	String text(MetamodelDeclaration metamodelDeclaration) {
		return metamodelDeclaration.getType() + " " + metamodelDeclaration.getName();
	}

	String image(FeatureField field) {
		return "icon_field.png";
	}

	String image(FeatureFieldDescription fieldDescription) {
		return "icon_field.png";
	}

	String image(FeatureMethodInvocation methodInvocation) {
		return "icon_method.png";
	}

	String image(FeatureMethodDescription methodDescription) {
		return "icon_method.png";
	}
	
	String image(FeatureNativeOperationDescription nativeOperationDescription) {
		return "icon_native.png";
	}
	
	String image(INativeOperation nativeOperation) {
		return "icon_native.png";
	}

	String image(Module module) {
		return "icon_module.png";
	}

	String image(RuleDeclaration rule) {
		if (rule.eIsProxy()) {
			EcoreUtil.resolve(rule, rule.eResource());
		}
		String s = "icon_rule_" + rule.getExec().getName() + ".png";
		return s;
	}
	
	String image(MetamodelDeclaration metamodelDeclaration) {
		return "icon_metamodel.png";
	}

	/*
		//Labels and icons can be computed like this:
		
		String text(MyModel ele) {
		  return "my "+ele.getName();
		}
		 
	    String image(MyModel ele) {
	      return "MyModel.gif";
	    }
	*/
}
