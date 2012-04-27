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

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;

import de.jevopi.mitra2.mitra.AssignmentOperator;
import de.jevopi.mitra2.mitra.Feature;
import de.jevopi.mitra2.mitra.MetamodelDeclaration;
import de.jevopi.mitra2.mitra.Type;

/**
 * IMetamodel There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 */
public interface IMetamodel {

	/**
	 * Returns true if metamodel has already been intialized.
	 * 
	 * @return
	 */
	public boolean isInitializied();

	/**
	 * Initializes the metamodel. This method must be called after
	 * {@link #setProperty(String, String) setting all properties}, and before
	 * calling any other methods of this metamodel.
	 * <p>
	 * This method is called automatically by the metamodel manager when a new
	 * declaration {@link MetamodelManager#addMetamodel(MetamodelDeclaration) is
	 * registered} to the manager.
	 */
	public void init(MetamodelManager i_metamodelManagerProvider);

	public void setProperty(String name, String value);

	/**
	 * Returns the property or null, if no such property is set.
	 * 
	 * @param name
	 * @return
	 */
	public String getProperty(String name);

	/**
	 * Creates an instance of given actualtype. Tested in InterpreterSimpleTest
	 * 
	 * @param actualtype
	 * @return
	 */
	public MObject createInstance(Type type);

	/**
	 * Wraps an object, this method must only be called from metamodel manager
	 * 
	 * @param obj
	 * @return null, if object could not be wrapped by this metamodel
	 */
	public MObject wrap(Object obj);

	/**
	 * @todo write test for isInstance
	 * @param obj
	 * @param strTypeName
	 * @return
	 */
	public boolean isInstance(MObject obj, String strTypeName);

	/**
	 * Casts given {@link MObject} to String or throws
	 * {@link ClassCastException} if cast is impossible.
	 * <p>
	 * Metamodel managers should try to cast as many as types as possible, if
	 * non-string types are casted, the following rules must hold:
	 * <ol>
	 * <li>null is to be interpreted as empty string ""</li>
	 * </ol>
	 * </p>
	 * 
	 * @param obj
	 * @return
	 */
	public String castToString(MObject mobj);

	/**
	 * Casts given {@link MObject} to integer or throws
	 * {@link ClassCastException} if cast is impossible.
	 * <p>
	 * Metamodel managers should try to cast as many as types as possible, if
	 * non-integer types are casted, the following rules must hold:
	 * <ol>
	 * <li>false is 0, true is 1</li>
	 * <li>null is to be interpreted as 0</li>
	 * </ol>
	 * </p>
	 * 
	 * @param obj
	 * @return
	 */
	public int castToInteger(MObject mobj);

	/**
	 * Casts given {@link MObject} to float or throws {@link ClassCastException}
	 * if cast is impossible.
	 * <p>
	 * Metamodel managers should try to cast as many as types as possible, if
	 * non-integer types are casted, the following rules must hold:
	 * <ol>
	 * <li>false is 0, true is 1</li>
	 * <li>null is to be interpreted as 0</li>
	 * </ol>
	 * </p>
	 * 
	 * @param obj
	 * @return
	 */
	public float castToReal(MObject mobj);

	/**
	 * Casts given {@link MObject} to boolean or throws
	 * {@link ClassCastException} if cast is impossible.
	 * <p>
	 * Metamodel managers should try to cast as many as types as possible, if
	 * non-boolean types are casted, the following rules must hold:
	 * <ol>
	 * <li>zero (0) is to be interpreted as false, all numeric values are true</li>
	 * <li>empty string ("") is to be interpreted as false, all other string
	 * values are true</li>
	 * <li>null is to be interpreted as false</li>
	 * </ol>
	 * </p>
	 * 
	 * @param obj
	 * @return
	 */
	public boolean castToBoolean(MObject mobj);

	/**
	 * @param i_type
	 * @return
	 */
	public Class<?> getJavaClassForType(Type i_type);

	/**
	 * Returns the (Mitra-) actualtype for a given Java object.
	 * 
	 * @param clazz
	 * @return
	 */
	public Type getTypeForObject(Object obj);

	public MetamodelDeclaration getMetamodelDeclaration();

	public void setMetamodelDeclaration(
			MetamodelDeclaration metamodelDeclaration);

	/**
	 * Returns the length of the generalization path or -1 if typeTo is no super
	 * actualtype of typeFrom. That is, if the returns value is greater 0, then
	 * typeTo is super actualtype of typeFrom. If the distance is greater or
	 * equal 0, the following (down-) cast will work
	 * <p>
	 * Cast: <code><pre>
	 * 		typeFrom y;
	 * 		typeTo   x = (typeTo) y;
	 * </pre></code>
	 * </p>
	 * <p>
	 * Also, the following rule call will work: <code><pre>
	 * 		foo() {
	 * 			typeFrom y;
	 * 			rule(y);
	 * 		}
	 * 
	 * 		rule(typeTo p) {
	 * 			...
	 * 		}
	 * </pre></code>
	 * </p>
	 * 
	 * @param typeFrom this actualtype's metamodel must be this metamodel,
	 *            usually the argument actualtype of a rule invocation
	 * @param typeTo any metamodel, usually the parameter actualtype of a rule
	 *            invocation
	 * @return
	 */
	int typeDistance(Type typeFrom, Type typeTo);

	/**
	 * Returns true if typeFrom can automatically be casted to typeTo. This is
	 * used mainly for operators, just as '+' or '>' in order to cast different
	 * types to int, real or string.
	 * 
	 * @param typeFrom this actualtype's metamodel must be this metamodel,
	 *            usually the argument actualtype of a rule invocation
	 * @param typeTo any metamodel, usually the parameter actualtype of a rule
	 *            invocation
	 */
	boolean isAutoCastable(Type typeFrom, Type typeTo);

	/**
	 * Returns true if type1 equals type2, multiplicity is ignored here.
	 * 
	 * @param type1
	 * @param type2
	 * @return
	 */
	public boolean equals(Type type1, Type type2);

	/**
	 * @param i_eClassifier
	 * @param i_many
	 */
	public Type getTypeForClass(EClassifier i_eClassifier); // , boolean
															// i_many);

	/**
	 * Returns true, if the given metamodels has the same implementation as this
	 * metamodel, e.g., if both metamodels are ecore and nsuri equals.
	 * 
	 * @param i_metamodel
	 * @return
	 */
	public boolean equalsImplementation(IMetamodel i_metamodel);

	public FeatureDescription evalFeature(Type receiverType, Feature feature,
			List<Type> arguments, Type iteratorLoopVarType);

	/**
	 * Used for content assist, returns a list of all field and method names of
	 * given actualtype. This list may be empty, but not null.
	 * 
	 * @param actualtype, must not be null
	 * @param bFilterUnchangeable if true, unchangeable fields are omitted
	 * @param bFilterInherited if true, inherited fields are omitted
	 * @return list with names, may be empty, but not null
	 */
	public List<FeatureFieldDescription> getAllFeatureFieldsDescriptions(
			Type type, boolean bFilterUnchangeable, boolean bFilterInherited);

	/**
	 * Used for reflection, returns feature info or null, if actualtype has no
	 * such feature.
	 * 
	 * @param actualtype
	 * @param featureName
	 * @return
	 */
	public FeatureFieldDescription getFeatureFieldDescription(Type type,
			String featureName);

	/**
	 * Used for content assist and type resolving, returns a list of all
	 * operations of given receiver type. This list may be empty, but not null.
	 * 
	 * @param actualtype, must not be null
	 * @return list with names, may be empty, but not null
	 */
	public List<FeatureMethodDescription> getMethodDescriptions(
			Type receiverType, String matchingName,
			Type[] matchingArgumentTypes, boolean bFilterDerived);

	/**
	 * Returns the value of the feature of the given object.
	 * 
	 * @param i_var
	 * @param i_pathItem
	 * @return
	 */
	public MInstance getFeature(MInstance i_var,
			FeaturePathItem<MObject> i_pathItem);

	/**
	 * Returns the value of a static feature of a given actualtype
	 * 
	 * @param i_type
	 * @param i_pathItem
	 * @return
	 */
	public MInstance getStaticFeature(Type i_type,
			FeaturePathItem<MObject> i_pathItem);

	/**
	 * Sets the new value of the feature of the given object.
	 * 
	 * @param i_var
	 * @param i_pathItem may be null
	 * @param i_newValue
	 * @param op
	 * @return
	 */
	public MObject setFeature(MObject i_var,
			FeaturePathItem<MObject> i_pathItem, MObject i_newValue,
			AssignmentOperator op);

	/**
	 * Used for content assist etc.
	 * 
	 * @return
	 */
	public List<String> getAllTypename();

	public List<EClassifier> getAllClassifiers();

	/**
	 * Converts a given object into a given actualtype, typically strings are
	 * parsed into objects.
	 * 
	 * @param from
	 * @param targetType must be managed by this metamodel
	 * @return null, if value could not be parsed
	 */
	public MObject parse(MObject value, Type targetType);

	/**
	 * Returns true, if this metamodel can parse a string into the given
	 * actualtype.
	 * 
	 * @param i_targetType
	 * @return
	 */
	public MObject canParse(Type i_targetType);

	/**
	 * @param i_nameOfType
	 * @return
	 */
	public Type getTypeForName(String i_nameOfType);

	public boolean isComparable(Type type1, Type type2);

	public int compareTo(MObject mObject1, MObject mObject2);

	public MObject wrap(Type type, Object value);

}