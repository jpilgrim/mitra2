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

import java.util.Collections;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

import de.jevopi.mitra2.metamodel.FeatureFieldDescription;
import de.jevopi.mitra2.metamodel.FeaturePathItem;
import de.jevopi.mitra2.metamodel.IMetamodel;
import de.jevopi.mitra2.metamodel.MObject;
import de.jevopi.mitra2.metamodel.MetamodelManager;
import de.jevopi.mitra2.metamodel.PseudoFeatureAccessPath;
import de.jevopi.mitra2.metamodel.mitracollections.MitraCollection;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.Type;

/**
 * MitraValue
 *
 * @author 	Jens von Pilgrim (developer@jevopi.de)
 * @since Mitra 1
 */	
public class MitraValue extends MitraDebugElement implements IValue {

	private MObject interpreterValue;

	private String value;

	private MitraVariable variable;

	public MitraValue(MitraDebugTarget target, MitraVariable var,
			MObject interpreterValue) {
		super(target);

		String valueString = "not initialized";
		if (interpreterValue != null) {
			Object valObject = interpreterValue.getValue();
			if (valObject != null) {
				valueString = valObject.toString();
			}
		}
		variable = var;
		value = valueString;
		this.interpreterValue = interpreterValue;
	}

	public MitraValue(MitraDebugTarget target, String value, MitraVariable var) {
		super(target);
		variable = var;
		this.value = value;
	}

	protected List<FeatureFieldDescription> getFieldDescriptors() {
		if (interpreterValue == null || interpreterValue.getValue() == null) {
			return Collections.emptyList();
		}

		MetamodelManager manager = ((MitraDebugTarget) getDebugTarget())
				.getMetamodelManager();

		IMetamodel metamodel = manager.getMetamodel(interpreterValue
				.getActualType());
		return metamodel.getAllFeatureFieldsDescriptions(
				interpreterValue.getActualType(), true, false);
	}

	/** 
	 * @see org.eclipse.debug.core.model.IValue#getReferenceTypeName()
	 */
	@Override
	public String getReferenceTypeName() throws DebugException {
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return "text";
		}
		return "integer";
	}

	public MObject getValue() {
		return interpreterValue;

	}

	/** 
	 * @see org.eclipse.debug.core.model.IValue#getValueString()
	 */
	@Override
	public String getValueString() throws DebugException {
		if (interpreterValue != null) {
			return interpreterValue.toString(true);
		}
		return value;
	}

	/** 
	 * @see org.eclipse.debug.core.model.IValue#getVariables()
	 */
	@Override
	public IVariable[] getVariables() throws DebugException {

		if (interpreterValue.getValue() == null) {
			return null;
		}
		if (interpreterValue.getActualType() instanceof CollectionType) {
			return getElements();
		} else {
			return getFields();
		}
	}

	protected IVariable[] getElements() throws DebugException {
		MitraStackFrame stackFrame = variable.getStackFrame();
		MitraCollection oclCollection = (MitraCollection) interpreterValue
				.getValue();
		IVariable[] variables = new IVariable[oclCollection.size()];
		int index = 0;
		for (MObject element : oclCollection) {
			String name = "[" + index + "]";
			MitraVariable mitraVariable = new MitraVariable(stackFrame, name);
			MitraValue mitraValue = new MitraValue(
					(MitraDebugTarget) getDebugTarget(), mitraVariable, element);
			mitraVariable.setValue(mitraValue);

			variables[index] = mitraVariable;
			index++;
		}
		return variables;
	}

	protected IVariable[] getFields() throws DebugException {
		List<FeatureFieldDescription> features = getFieldDescriptors();
		if (features.size() == 0) {
			return null;
		}

		IVariable[] variables = new IVariable[features.size()];
		MitraStackFrame stackFrame = variable.getStackFrame();
		MetamodelManager manager = ((MitraDebugTarget) getDebugTarget())
				.getMetamodelManager();
		PseudoFeatureAccessPath<MObject> path;
		Type actualType = interpreterValue.getActualType();
		for (int i = 0; i < variables.length; i++) {

			FeatureFieldDescription featureDescription = features.get(i);

			path = new PseudoFeatureAccessPath<MObject>(actualType);
			path.add(new FeaturePathItem<MObject>(null, featureDescription));

			String strName = featureDescription.getName();

			MObject value = manager.getFeature(interpreterValue, path);
			MitraVariable mitraVariable = new MitraVariable(stackFrame, strName);
			MitraValue mitraValue = new MitraValue(
					(MitraDebugTarget) getDebugTarget(), mitraVariable, value);
			mitraVariable.setValue(mitraValue);

			variables[i] = mitraVariable;

		}
		return variables;
	}

	/** 
	 * @see org.eclipse.debug.core.model.IValue#hasVariables()
	 */
	@Override
	public boolean hasVariables() throws DebugException {
		if (interpreterValue.getValue() == null) {
			return false;
		}
		if (interpreterValue.getActualType() instanceof CollectionType) {
			return !((MitraCollection) interpreterValue.getValue()).isEmpty();
		} else {
			return getFieldDescriptors().size() > 0;
		}
	}

	/** 
	 * @see org.eclipse.debug.core.model.IValue#isAllocated()
	 */
	@Override
	public boolean isAllocated() throws DebugException {
		return true;
	}

	@Override
	public String toString() {
		return "MitraValue " + String.valueOf(interpreterValue);
	}

}
