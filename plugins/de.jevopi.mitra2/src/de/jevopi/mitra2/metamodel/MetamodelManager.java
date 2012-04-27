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

import static de.jevopi.mitra2.metamodel.PrimitiveMetamodel.ANY;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import de.jevopi.mitra2.MitraError;
import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.message.AbstractMessenger;
import de.jevopi.mitra2.message.IMessageAcceptor;
import de.jevopi.mitra2.mitra.AssignmentOperator;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.Feature;
import de.jevopi.mitra2.mitra.MetamodelDeclaration;
import de.jevopi.mitra2.mitra.MitraFactory;
import de.jevopi.mitra2.mitra.PrimitiveType;
import de.jevopi.mitra2.mitra.Property;
import de.jevopi.mitra2.mitra.ReferenceType;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.util.TypeStringConverter;

/**
 * Container for {@link IMetamodel}s
 * 
 * @todo Find meta models in "metamodelPath"
 * @author Jens von Pilgrim
 */
public class MetamodelManager extends AbstractMessenger {
	/**
	 * Logger for this class
	 */
	@SuppressWarnings("unused") //$NON-NLS-1$
	private static final Logger log = Logger.getLogger(MetamodelManager.class.getName());

	private static final String METAMODEL_TYPE_UML2 = "uml2";

	private static final String METAMODEL_TYPE_ECORE = "ecore";

	public static int RATING_EQUAL = 8;

	public static int RATING_SUPER = 4;

	public static int RATING_LEFTCAST = 2;

	public static int RATING_CASTABLE = 1;

	public static int RATING_NOMATCH = 0;

	public static class MetamodelNotFoundException extends RuntimeException {

		private static final long serialVersionUID = 9142412072665945197L;

		public MetamodelNotFoundException(MetamodelDeclaration mmdecl) {
			super("Metamodel not found: " + String.valueOf(mmdecl));
		}

	}

	protected Map<MetamodelDeclaration, IMetamodel> metamodels;
	protected Map<EPackage, EMFMetamodel> emfMetamodels;

	protected PrimitiveMetamodel primitiveMetamodel;

	protected CollectionMetamodel collectionMetamodel;

	private ProjectContext projectContext;

	public MetamodelManager(ProjectContext projectContext) {
		this.projectContext = projectContext;
		reset();
	}

	@Override
	protected IMessageAcceptor getMessageAcceptor() {
		return projectContext.getMessageAcceptor();
	}

	public final void reset() {
		metamodels =
			Collections
				.synchronizedMap(new HashMap<MetamodelDeclaration, IMetamodel>());
		emfMetamodels =
			Collections.synchronizedMap(new HashMap<EPackage, EMFMetamodel>());

		primitiveMetamodel = new PrimitiveMetamodel();
		primitiveMetamodel
			.setMetamodelDeclaration(PrimitiveMetamodel.PrimitiveMetamodelDeclaration);
		primitiveMetamodel.init(this);
		metamodels.put(primitiveMetamodel.getMetamodelDeclaration(),
				primitiveMetamodel);

		collectionMetamodel = new CollectionMetamodel();
		collectionMetamodel
			.setMetamodelDeclaration(CollectionMetamodel.CollectionMetamodelDeclaration);
		collectionMetamodel.init(this);
		metamodels.put(collectionMetamodel.getMetamodelDeclaration(),
				collectionMetamodel);

	}

	/**
	 * Adds a new metamodel according to given declaration. If a similar
	 * metamodel already exists, the new declaration points to the same
	 * metamodel.
	 * 
	 * @param metamodelDeclaration, must not be null, its declaration must be
	 *            set
	 */
	private void addMetamodel(MetamodelDeclaration metamodelDeclaration) {
		if (metamodelDeclaration == null) {
			throw new NullPointerException("metamodelDecl must not be null");
		}

		if (!isMetamodelRegistered(metamodelDeclaration)) {
			IMetamodel metamodel = null;

			if (METAMODEL_TYPE_ECORE.equals(metamodelDeclaration.getType())) {
				metamodel = new EMFMetamodel();
				// requires property ecoreFile
			} else if (METAMODEL_TYPE_UML2.equals(metamodelDeclaration
				.getType())) {
				metamodel = new UML2Metamodel();
			}
			if (metamodel == null) {
				runtimeError("Cannot handle metamodels of type "
					+ metamodelDeclaration.getType(), metamodelDeclaration);
				throw new MitraError();
			}
			for (Property prop : metamodelDeclaration.getProperties()) {
				metamodel.setProperty(prop.getName(), prop.getValue());
			}

			metamodel.setMetamodelDeclaration(metamodelDeclaration);
			metamodel.init(this);

			for (IMetamodel existing : metamodels.values()) {
				if (existing.equalsImplementation(metamodel)) {
					metamodel = existing;
					break;
				}
			}

			metamodels.put(metamodelDeclaration, metamodel);
			if (metamodel instanceof EMFMetamodel) {
				EMFMetamodel emfMetamodel = (EMFMetamodel) metamodel;
				emfMetamodels.put(emfMetamodel.epackage, emfMetamodel);
			}

		}

	}

	/**
	 * This method is used for setting the meta model, this method should not be
	 * called afterwards for actualtype checking or execution to avoid overhead.
	 * 
	 * @param mmdecl
	 * @return
	 */
	public boolean isMetamodelRegistered(MetamodelDeclaration mmdecl) {
		return metamodels.containsKey(mmdecl);
	}

	/**
	 * Returns meta model for given meta model declaration
	 * 
	 * @param mmdecl
	 * @return meta model
	 */
	public IMetamodel getMetamodel(MetamodelDeclaration mmdecl)
			throws MetamodelNotFoundException {
		IMetamodel metamodel = metamodels.get(mmdecl);
		if (metamodel == null) {
			addMetamodel(mmdecl);
			metamodel = metamodels.get(mmdecl);

			if (metamodel == null) {
				throw new MetamodelNotFoundException(mmdecl);
			}
		}
		return metamodel;
	}

	public IMetamodel getMetamodel(String metamodelName) {
		for (IMetamodel metamodel : metamodels.values()) {
			if (metamodelName.equals(metamodel.getMetamodelDeclaration()
				.getName())) {
				return metamodel;
			}
		}
		return null;
	}

	public PrimitiveMetamodel getPrimitiveMetamodel() {
		return primitiveMetamodel;
	}

	/**
	 * @return the collectionMetamodel
	 */
	public CollectionMetamodel getCollectionMetamodel() {
		return collectionMetamodel;
	}

	/**
	 * Returns meta model for given meta model declaration
	 * 
	 * @param mmdecl
	 * @return meta model
	 */
	public IMetamodel getMetamodel(Type i_type)
			throws MetamodelNotFoundException {
		if (i_type instanceof PrimitiveType) {
			return primitiveMetamodel;
		}
		if (i_type instanceof CollectionType) {
			return collectionMetamodel;
		} else {
			ReferenceType rt = (ReferenceType) i_type;
			return getMetamodel(rt.getMetamodelDeclaration());
		}
	}

	/**
	 * @throws MetamodelNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public <CT> Class<CT> getJavaClassForType(Type type)
			throws MetamodelNotFoundException {
		IMetamodel metamodel = getMetamodel(type);
		return (Class<CT>) metamodel.getJavaClassForType(type);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws MetamodelNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public <CT> List<Class<CT>> getJavaClassesForTypes(List<Type> types)
			throws MetamodelNotFoundException {
		if (types == null || types.size() == 0) {
			return Collections.emptyList();
		}
		List<Class<CT>> list = new ArrayList<Class<CT>>(types.size());
		for (Type type : types) {
			list.add((Class<CT>) getJavaClassForType(type));
		}
		return list;
	}

	/**
	 * @param strTypeName Full name of type, i.e. with preceeding metamodel name
	 * @return
	 */
	public Type getTypeForName(String strTypeName) {
		Type t = TypeStringConverter.parseType(strTypeName, this);
		return t;
	}

	public List<String> getTypeNames(String strMetamodelName) {
		IMetamodel metamodel = findMetamodelByName(strMetamodelName);
		if (metamodel == null) {
			return Collections.emptyList();
		}
		List<String> names = metamodel.getAllTypename();
		return names;
	}

	/**
	 * Only if no metamodel declaration is available, e.g., in content assist
	 * (since metamodels' key is {@link MetamodelDeclaration}
	 * 
	 * @param strMetamodelname
	 * @return the metamodel or null, if no such metamodel is registered with
	 *         that name
	 */
	protected IMetamodel findMetamodelByName(String strMetamodelname) {
		for (IMetamodel metamodel : metamodels.values()) {
			if (metamodel.getMetamodelDeclaration().getName()
				.equals(strMetamodelname)) {
				return metamodel;
			}
		}
		return null;
	}

	/**
	 * Casts an object into an MObject. Internal this method calls
	 * {@link IMetamodel#wrap(Object)}.
	 * 
	 * @param the mobject, its type != any!
	 * @return null, if object cannot be wrapped by any metamodel.
	 */
	public MObject wrap(Object i_object) {
		if (i_object == null) {
			return MObject.NULL;
		}

		MObject result = null;
		if (i_object instanceof Collection) {
			result = getCollectionMetamodel().wrap(i_object);
			if (result != null) return result;
		}

		if (i_object instanceof EObject) {
			EPackage ePackage = ((EObject) i_object).eClass().getEPackage();
			EMFMetamodel metamodel = emfMetamodels.get(ePackage);
			if (metamodel != null) {
				result = metamodel.wrap(i_object);
				if (result != null) return result;
			}
		}

		result = getPrimitiveMetamodel().wrap(i_object);
		
		
		if (result == null) {
			// try all metamodels, usually object is an enum literal
			for (IMetamodel metamodel : metamodels.values()) {
				result = metamodel.wrap(i_object);
				if (result != null) {
					break;
				}

			}
		}

		return result;
	}

	public MObject wrap(String typeName, Object value) {
		Type type = getTypeForName(typeName);
		IMetamodel metamodel = getMetamodel(type);
		MObject result = metamodel.wrap(type, value);
		return result;
	}

	public MObject wrapCollection(Collection<? extends Object> objects,
			CollectionType declaredCollectionType) {

		MObject mCollection =
			CollectionMetamodel.createCollectionMObject(declaredCollectionType,
					objects, this);

		return mCollection;
	}

	/**
	 * Converts a given object into a given actualtype, typically strings are
	 * parsed into objects.
	 * 
	 * @param from
	 * @param targetType
	 * @return {@link MObject#NULL}, if value cannot be parsed
	 */
	public MObject parse(MObject i_value, Type i_targetType) {
		if (i_value == MObject.NULL || i_value == MObject.NOT_INITIALIZED) {
			return MObject.NULL;
		}

		IMetamodel metamodelTo = getMetamodel(i_targetType);
		MObject result = metamodelTo.parse(i_value, i_targetType);

		// try String
		if (result == null) {
			if (i_value.getValue() != null) {
				MObject stringValue =
					getPrimitiveMetamodel().wrapString(
							i_value.getValue().toString());
				result = metamodelTo.parse(stringValue, i_targetType);
			}
		}

		if (result == null) {
			return MObject.NULL;
		} else {
			return result;
		}
	}

	/**
	 * Returns true, if {@link #parse(MObject, Type)} can be applied to given
	 * actualtype
	 * 
	 * @param i_type
	 * @return
	 */
	public MObject canParse(Type i_targetType) {
		IMetamodel metamodelTo = getMetamodel(i_targetType);
		return metamodelTo.canParse(i_targetType);
	}

	/**
	 * Returns a actualtype for a given classifier. This classifier may be
	 * meta-metamodel specific, ecore eclassifiers are recognized, and
	 * referenced metamodels are loaded on demand. Note that only ecore
	 * metamodels can be dynamically loaded if they are referenced by their
	 * NSURI. If upperBound indicates a many type, then a {@link CollectionType}
	 * is created.
	 * 
	 * @param eClassifier
	 * @param ordered
	 * @param unique
	 * @param upperBound
	 * @param lowerBound
	 */
	public Type getTypeForClass(EClassifier eClassifier, int lowerBound,
			int upperBound, boolean unique, boolean ordered) {
		Type type = getTypeForClassSimple(eClassifier);
		if (upperBound < 0 || upperBound > 1) {
			type =
				CollectionMetamodel.createCollectionType(unique, ordered, type);
		}
		return type;

	}

	public Type getTypeForClassSimple(EClassifier eClassifier) {
		if (eClassifier == null) {
			return PrimitiveMetamodel.VOID;
		}
		String nsUri = eClassifier.getEPackage().getNsURI();
		IMetamodel metamodel = retrieveMetamodelByProperty("nsUri", nsUri);
		if (metamodel == null && nsUri != null) {
			metamodel = loadEcoreOnDemand(nsUri);
		}
		if (metamodel == null) {
			return null;
		}
		Type type = metamodel.getTypeForClass(eClassifier);
		return type;

	}

	/**
	 * @param i_nsUri
	 * @return
	 */
	private IMetamodel loadEcoreOnDemand(String i_nsUri) {
		EMFMetamodel emfMetamodel = new EMFMetamodel();
		emfMetamodel.setProperty("nsUri", i_nsUri);
		emfMetamodel.init(this);

		MetamodelDeclaration mmdecl =
			MitraFactory.eINSTANCE.createMetamodelDeclaration();
		mmdecl.setName(i_nsUri);
		mmdecl.setType(METAMODEL_TYPE_ECORE);
		Property property = MitraFactory.eINSTANCE.createProperty();
		property.setName("nsUri");
		property.setValue(i_nsUri);
		mmdecl.getProperties().add(property);
		emfMetamodel.setMetamodelDeclaration(mmdecl);
		metamodels.put(mmdecl, emfMetamodel);
		emfMetamodels.put(emfMetamodel.epackage, emfMetamodel);

		return emfMetamodel;

	}

	/**
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 */
	private IMetamodel retrieveMetamodelByProperty(String propertyName,
			String propertyValue) {
		if (propertyValue == null) {
			return null;
		}
		for (IMetamodel metamodel : metamodels.values()) {
			if (propertyValue.equals(metamodel.getProperty(propertyName))) {
				return metamodel;
			}
		}
		return null;
	}

	public FeatureDescription evalFeature(Type receiverType, Feature feature,
			List<Type> argumentOrIteratorExpTypes, Type iteratorLoopVarType) {
		FeatureDescription featureDescription = null;

		IMetamodel metamodel = getMetamodel(receiverType);
		featureDescription =
			metamodel.evalFeature(receiverType, feature,
					argumentOrIteratorExpTypes, iteratorLoopVarType);

		return featureDescription;
	}

	/**
	 * Sets a given feature of a given object.
	 * <p>
	 * Internal note: this method was refactored from Metamodel, as different
	 * metamodels may be used within a path.
	 * </p>
	 * 
	 * @param i_var the variable which is to be changed
	 * @param i_featurePath the path to the feature
	 * @param i_newValue the new value of the feature
	 * @param i_op SET or ADD
	 * @return
	 */
	public MObject setFeature(MObject i_var,
			VariableAccessPath<MObject> i_featurePath, MObject i_newValue,
			AssignmentOperator i_op) {

		boolean addOrSub =
			i_op == AssignmentOperator.ADD || i_op == AssignmentOperator.SUB;

		if (i_featurePath.size() == 0 && !addOrSub) {
			return i_var; // nothing to do
		}

		MInstance xvalue =
			new MInstance(i_var, i_featurePath.getReceiverType());
		IMetamodel metamodel = null;
		FeaturePathItem<MObject> pathItem = null;

		try {

			int iIndex = 0;
			int iGetFront = i_featurePath.size() - 1;
			if (addOrSub) {
				iGetFront++;
			}
			for (; iIndex < iGetFront; iIndex++) {
				pathItem = i_featurePath.get(iIndex);
				metamodel =
					getMetamodelForFeaturePath(xvalue.getActualType(), pathItem);
				xvalue = metamodel.getFeature(xvalue, pathItem);
			}
			MObject value = xvalue.getMObject();

			if (value == MObject.NULL || value == MObject.NOT_INITIALIZED) {
				runtimeError(String.valueOf(i_featurePath.getLocation())
					+ " is "
					+ (value == MObject.NULL ? "null" : "not initialized"),
						i_featurePath.getLocation());
				throw new MitraError();
			}

			if (addOrSub) {
				metamodel = getPrimitiveMetamodel();
				value = metamodel.setFeature(value, null, i_newValue, i_op);

			} else { // SET
				pathItem = i_featurePath.get(iIndex);
				metamodel =
					getMetamodelForFeaturePath(value.getActualType(), pathItem);

				value = metamodel.setFeature(value, pathItem, i_newValue, i_op);
			}

			return value;
		} catch (Exception ex) {
			runtimeError(
					"Error setting "
						+ MitraUtils.getTypeName(i_featurePath
							.getReceiverType())
						+ ", "
						+ String.valueOf(xvalue)
						+ " "
						+ ((pathItem == null) ? "" : "(" + pathItem.toString()
							+ ")") + ": " + ex.getMessage(),
					i_featurePath.getLocation(), ex);
			throw new MitraError();

		}

	}

	/**
	 * Returns a feature of a given object.
	 * <p>
	 * Internal note: this method was refactored from Metamodel, as different
	 * metamodels may be used within a path.
	 * </p>
	 * 
	 * @param i_var the variable which is to be changed
	 * @param i_featurePath the path to the feature
	 * @return
	 */
	public MObject getFeature(MObject i_var,
			FeatureAccessPath<MObject> i_featurePath) {
		MInstance value = new MInstance(i_var, i_featurePath.getReceiverType());
		IMetamodel metamodel;
		FeaturePathItem<MObject> pathItem = null;

		try {

			for (Iterator<FeaturePathItem<MObject>> iter =
				i_featurePath.iterator(); iter.hasNext();) {
				pathItem = iter.next();
				// collections are always handled by primitive metamodel
				metamodel =
					getMetamodelForFeaturePath(value.getActualType(), pathItem);
				value = metamodel.getFeature(value, pathItem);
			}
		} catch (Exception ex) {
			runtimeError(
					"Error getting "
						+ MitraUtils.getTypeName(i_featurePath
							.getReceiverType())
						+ ", "
						+ String.valueOf(value)
						+ " "
						+ ((pathItem == null) ? "" : "(" + pathItem.toString()
							+ ")") + ": " + ex.getMessage(),
					i_featurePath.getLocation(), ex);
			throw new MitraError();
		}

		return value.getMObject();
	}

	/**
	 * Returns a static feature of a actualtype (actualtype is defined in
	 * {@link StaticAccessPath#getType()}
	 * 
	 * @param i_staticPath
	 * @return
	 */
	public MObject getStaticFeature(StaticAccessPath<MObject> i_staticPath) {

		if (i_staticPath.size() == 0) {
			return new MObject(PrimitiveMetamodel.TYPE,
				i_staticPath.getReceiverType());
		}

		MInstance value =
			new MInstance(getPrimitiveMetamodel().wrapType(
					i_staticPath.getReceiverType()), PrimitiveMetamodel.TYPE);
		IMetamodel metamodel = null;
		FeaturePathItem<MObject> pathItem = null;

		try {
			for (Iterator<FeaturePathItem<MObject>> iter =
				i_staticPath.iterator(); iter.hasNext();) {
				pathItem = iter.next();
				metamodel =
					getMetamodelForFeaturePath(value.getActualType(), pathItem);
				value = metamodel.getFeature(value, pathItem);
			}
		} catch (Exception ex) {
			runtimeError("Error getting " + i_staticPath.getStaticAccess()
				+ ": " + ex.getMessage(), i_staticPath.getLocation(), ex);
			throw new MitraError();
		}

		return value.getMObject();
	}

	/**
	 * @param actualtype
	 * @param pathItem may be null
	 * @return
	 */
	private IMetamodel getMetamodelForFeaturePath(Type type,
			FeaturePathItem<?> pathItem) {
		return getMetamodel(type);

	}

	/**
	 * Returns the length of the generalization path or -1 if typeTo is no super
	 * type of typeFrom. That is, if the returns value is greater 0, then typeTo
	 * is super type of typeFrom. If the distance is greater or equal 0, the
	 * following (down-) cast will work
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
	 * @param typeFrom expected sub type
	 * @param typeTo expected super type
	 * @return
	 */
	public int calcTypeDistance(Type i_typeFromSub, Type i_typeToSuper) {
		/* i_typeFrom must not be null */
		if (i_typeFromSub == null) {
			throw new NullPointerException(
				"Argument i_typeFrom must not be null");
		}
		/* i_typeTo must not be null */
		if (i_typeToSuper == null) {
			throw new NullPointerException("Argument i_typeTo must not be null");
		}

		return getMetamodel(i_typeFromSub).typeDistance(i_typeFromSub,
				i_typeToSuper);
	}

	public boolean isSubType(Type subType, Type superType) {
		return calcTypeDistance(subType, superType) >= 0;
	}

	public static boolean equals(Type t1, Type t2) {
		if (t1 == t2) {
			return true;
		}
		if (t1 == null || t2 == null) {
			return false;
		}
		if (t1.getClass() != t2.getClass()) {
			return false;
		}

		if (t1 instanceof PrimitiveType) {
			return ((PrimitiveType) t1).getPrimitiveType().equals(
					((PrimitiveType) t2).getPrimitiveType());

		} else if (t1 instanceof ReferenceType) {
			ReferenceType r1 = (ReferenceType) t1;
			ReferenceType r2 = (ReferenceType) t2;
			return EMFMetamodel.sameEClassifier(r1.getEClassifier(),
					r2.getEClassifier());

		} else if (t1 instanceof CollectionType) {
			CollectionType c1 = (CollectionType) t1;
			CollectionType c2 = (CollectionType) t2;
			return c1.getCollectionType().equals(c2.getCollectionType())
				&& equals(c1.getTypePar(), c2.getTypePar());

		}
		return false;
	}

	/**
	 * @return
	 * @since Feb 6, 2012
	 */
	public ProjectContext getProjectContext() {
		return projectContext;
	}

	@Override
	public String toString() {
		StringBuilder strb = new StringBuilder();
		strb.append("MetamodelMangager (").append(projectContext)
			.append(") with:");
		for (IMetamodel metamodel : metamodels.values()) {
			if (metamodel != primitiveMetamodel
				&& metamodel != collectionMetamodel)
				strb.append("\n  - ").append(metamodel.toString());
		}
		return strb.toString();
	}

	public boolean isCompatible(Type t1, Type t2) {
		if (ANY.equals(t1) || ANY.equals(t2)) {
			return true;
		}
		return isSubType(t1, t2) || isSubType(t2, t1);
	}

	public boolean isComparable(Type type1, Type type2) {
		IMetamodel m1 = getMetamodel(type1);
		IMetamodel m2 = getMetamodel(type2);

		if (m1.isComparable(type1, type2)) return true;
		if (m1 != m2) return m2.isComparable(type2, type1);
		return false;
	}

	public int compareTo(MObject mObject1, MObject mObject2) {
		Type type1 = mObject1.getActualType();
		Type type2 = mObject2.getActualType();

		IMetamodel m1 = getMetamodel(type1);
		IMetamodel m2 = getMetamodel(type2);

		if (m1.isComparable(type1, type2))
			return m1.compareTo(mObject1, mObject2);
		return m2.compareTo(mObject1, mObject2);
	}

}
