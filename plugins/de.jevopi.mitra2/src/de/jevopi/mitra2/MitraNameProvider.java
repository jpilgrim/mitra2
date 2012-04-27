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
package de.jevopi.mitra2;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

import com.google.inject.Inject;

import de.jevopi.mitra2.mitra.MetamodelDeclaration;
import de.jevopi.mitra2.mitra.Module;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.util.MitraSwitch;

/**
 * Name provider for fully qualified Mitra rules.
 * 
 * Qualified names are only available for rules and modules:
 * <ul>
 * <li>fqnrule: <code>fqnmodulename ":" rulen ame</code>
 * <li>fqnmodulename: <code>fqnpackage ":" module name</code>
 * <li>fqnpackage: <code>package name</code>
 * </ul>
 * 
 * Features are dot separated, and "::" is used to separate metamodel from type
 * in reference types---however, these separations are no qualified names.
 * 
 * 
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Jan 17, 2012
 */
public class MitraNameProvider extends MitraSwitch<QualifiedName> implements
		IQualifiedNameProvider {
	
	public final static MitraNameProvider INSTANCE = new MitraNameProvider();
	

	@Inject
	IQualifiedNameConverter qualifiedNameConverter = new MitraQualifiedNameConverter();
	

	@Override
	public QualifiedName apply(EObject from) {
		return getFullyQualifiedName(from);
	}

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		return doSwitch(obj);
	}

	@Override
	public QualifiedName defaultCase(EObject object) {
		return null;
//		
//		if (object == null) return QualifiedName.EMPTY;
//
//		EStructuralFeature structuralFeature =
//			object.eClass().getEStructuralFeature("name");
//		if (structuralFeature != null) {
//			String name = (String) object.eGet(structuralFeature);
//			if (name != null && !name.isEmpty()) {
//				return QualifiedName.create(name);
//			}
//		}
//		return QualifiedName.EMPTY;

	}

	@Override
	public QualifiedName caseRuleDeclaration(RuleDeclaration object) {
		if (object == null) return MitraQualifiedName.EMPTY;
		return caseModule(MitraUtils.retrieveModule(object)).append(
				object.getName());
	}

	@Override
	public QualifiedName caseModule(Module object) {
		if (object == null) return MitraQualifiedName.EMPTY;
		if (object.getPackageName() == null
			|| object.getPackageName().isEmpty()) {
			return qualifiedNameConverter.toQualifiedName(object.getName());
		}

		return qualifiedNameConverter.toQualifiedName(object.getPackageName())
			.append(object.getName());
	}
	
	@Override
	public QualifiedName caseMetamodelDeclaration(MetamodelDeclaration object) {
		return QualifiedName.create(object.getName());
	}

}
