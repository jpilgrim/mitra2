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

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.osgi.framework.Bundle;

import de.jevopi.mitra2.MitraError;
import de.jevopi.mitra2.context.ProjectContext;
import de.jevopi.mitra2.metamodel.MetamodelManager.MetamodelNotFoundException;
import de.jevopi.mitra2.mitra.AssignmentOperator;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.Feature;
import de.jevopi.mitra2.mitra.FeatureField;
import de.jevopi.mitra2.mitra.MitraFactory;
import de.jevopi.mitra2.mitra.NativeOperationInvocation;
import de.jevopi.mitra2.mitra.ReferenceType;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.utils.JavaUtils;

/**
 * Manages an EMF metamodel, i.e. a model based on ecore. This manager accepts
 * two properties:
 * <ul>
 * <li>nsUri---URI of model, used to retrieve root package from EMF registry</li>
 * <li>ecoreFile---ecore filename, only evaluated if model cannot be retrieved
 * from registry</li>
 * </ul>
 * 
 * @todo remove all usages of Object as actualtype info is lost (e.g. set)
 * @todo add handling of unchangeble types
 * @todo general: add console view
 * @author Jens von Pilgrim
 * @since Mitra 1
 */
public class EMFMetamodel extends Metamodel implements IMetamodel {

	public static final String NS_URI = "nsUri";

	public static final String ECORE_FILE = "ecoreFile";

	private static final Logger log = Logger.getLogger(EMFMetamodel.class
		.getName());

	/**
	 * File name of model file (*.ecore).
	 */
	String fileName;

	/**
	 * URI, e.g. http://feu.de/simpleER
	 */
	String nsUri;

	protected ResourceSet resourceSet = new ResourceSetImpl();

	protected EPackage epackage;

	private Map<String, EClassifier> classifierMap;

	private Map<EClassifier, Type> typecacheSingle;

	/**
	 * @throws IOException
	 * @see StandaloneSetup#addRegisterEcoreFile(String)
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#init(de.jevopi.mitra2.mitra.metamodel.MetamodelManager)
	 */
	@Override
	public void init(MetamodelManager i_metamodelManager) {
		super.init(i_metamodelManager);

		if (nsUri != null) { // preferred way: load from registry
			Object obj = EPackage.Registry.INSTANCE.get(nsUri);
			// this is the case if package had been loaded before:
			epackage = retrievePackage(obj);
			if (epackage == null) {
				// try to load bundle:
				epackage = lookupExtension(nsUri);
			}
			if (epackage == null) {
				throw new IllegalArgumentException("No model with  nsUri "
					+ nsUri + " found in EPackage.Registry.INSTANCE "
					+ "(typo or forgotten standalone setup?)");
			}
		} else {

			if (fileName == null) {
				throw new IllegalArgumentException("Neither " + NS_URI
					+ " nor " + ECORE_FILE + " defined.");
			}

			ProjectContext projectContext =
				getMetamodelManager().getProjectContext();
			Resource res = projectContext.getMetamodelResource(fileName, true);

			if (!projectContext.getPathHandler().existsModel(res.getURI())) {
				throw new IllegalArgumentException("Metamodel not found at "
					+ res.getURI());
			}

			if (!res.isLoaded()) {
				try {
					res.load(null);
				} catch (IOException ex) {
					throw new IllegalStateException(
						"Couldn't initialize metamodel manager", ex);
				}
			}
			EcoreUtil.resolveAll(res);
			List<EObject> result = res.getContents();

			for (EObject object : result) {
				if (object instanceof EPackage) {
					epackage = (EPackage) object;
					nsUri = epackage.getNsURI();
					Object oldPackage = EPackage.Registry.INSTANCE.get(nsUri);

					if (oldPackage instanceof EPackage) {
						// already registered, use old one
						epackage = (EPackage) oldPackage;
					} else { // register new one:
						EPackage.Registry.INSTANCE.put(nsUri, epackage);
						log.info("Adding dynamic EPackage '" + nsUri
							+ "' from '" + fileName + "'");
						break;
					}
				}
			}

			if (epackage == null) {
				throw new IllegalArgumentException(
					"Cannot retrieve epackage, no epackage found in " + res);
			}

		}

	}

	/**
	 * For a list of all supported properties, see class description.
	 * 
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#setProperty(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void setProperty(String name, String value) {
		if (ECORE_FILE.equals(name)) {
			fileName = value;
			return;
		}
		if (NS_URI.equals(name)) {
			nsUri = value;
			return;
		}

		if (log.isLoggable(Level.WARNING)) {
			log.warning("Property \"" + name + "\" not recognized");
		}
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.Metamodel#createInstance(java.lang.String)
	 */
	@Override
	public MObject createInstance(Type type) {
		if (!(type instanceof ReferenceType)) { // precondition
			throw new IllegalArgumentException("PrimitiveType " + type
				+ " not found in metamodel");
		}

		String strName = ((ReferenceType) type).getEClassifier().getName();

		EClassifier eClassifier = findEClassifier(strName);
		if (eClassifier == null) {
			throw new IllegalArgumentException("Type " + type
				+ " not found in metamodel");
		}

		EFactory efactory = epackage.getEFactoryInstance();

		Object obj;
		if (eClassifier instanceof EClass) {
			obj = efactory.create((EClass) eClassifier);
		} else if (eClassifier instanceof EEnum) {
			EEnum eEnum = (EEnum) eClassifier;
			Enumerator enumerator = (Enumerator) eEnum.getDefaultValue();
			return wrap(enumerator);
		} else {
			Class<?> clazz = eClassifier.getInstanceClass();
			try {
				obj = clazz.newInstance();
			} catch (Exception ex) {
				throw new IllegalArgumentException("Error creating instance",
					ex);
			}

		}

		return new MObject(getTypeForClass(eClassifier /* , false */), obj);

	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.Metamodel#isInstance(de.jevopi.mitra2.mitra.metamodel.MObject,
	 *      java.lang.String)
	 */
	@Override
	public boolean isInstance(MObject obj, String strTypeName) {
		EClassifier eclass = findEClassifier(strTypeName);
		if (eclass == null) {
			throw new IllegalArgumentException("Type " + strTypeName
				+ " not found in metamodel");
		}

		return eclass.isInstance(obj.getValue());
	}

	/**
	 * Called by {@link #evalType(VariableAccessPath, ReferenceType)}
	 * 
	 * @param eParameters
	 * @param argTypes
	 * @return -1 if types do not match, else the rating (higher is better)
	 * @throws MetamodelNotFoundException
	 */
	int rateOperationTypes(List<Type> argTypes, EList<EParameter> eParameters)
			throws MetamodelNotFoundException {

		int iSize = argTypes.size();
		if (eParameters.size() == iSize) {
			if (iSize == 0) {
				return 0;
			}

			Type[] parTypes = getTypesForEParameters(eParameters);
			int iRating = 0;
			int iDistance;
			for (int i = 0; i < iSize; i++) {
				iDistance = typeDistance(argTypes.get(i), parTypes[i]);
				if (iDistance < 0) {
					// TODO handle casting, e.g. to ANY
					return -1;
				}
				iRating += 1 / (iDistance + 1);
			}
			return iRating;
		}

		return -1;
	}

	/**
	 * Called by {@link #doGetFeature(MObject, VariableAccessPath, int)} must
	 * not return null.
	 * 
	 * @param i_val
	 * @param i_strStructuralFeature
	 * @param i_arguments, maybe null
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private MInstance evalMethodCall(MInstance mobjectx,
			String i_strStructuralFeature, List<MObject> i_arguments)
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {

		EObject eobj = (EObject) mobjectx.getValue();

		int iArgCount = i_arguments.size();

		Class<?> parTypes[] = new Class[iArgCount];
		Object args[] = new Object[iArgCount];
		List<Type> argTypes = new ArrayList<Type>(iArgCount);
		for (int i = 0; i < iArgCount; i++) {
			args[i] = i_arguments.get(i).getValue();
			parTypes[i] = (args[i] != null) ? args[i].getClass() : Object.class;
			argTypes.set(i, i_arguments.get(i).getActualType());
		}
		// TODO handle null arguments

		Method method =
			eobj.getClass().getMethod(i_strStructuralFeature, parTypes);
		EOperation operation =
			findOperation(eobj.eClass(), i_strStructuralFeature, argTypes);

		Type declaredType = null;
		if (operation != null) {
			declaredType = getTypeForEOperation(operation);
		} else {
			throw new IllegalArgumentException("Operation "
				+ i_strStructuralFeature + " unkown for " + eobj.eClass());
		}

		Object val = method.invoke(eobj, args);

		MInstance result = null;

		if (val instanceof Collection) {
			if (!operation.isMany()) {
				log.warning("Retrieved list but feature is not many, "
					+ operation);
			}
			@SuppressWarnings("unchecked")
			MObject mobj =
				getMetamodelManager().wrapCollection(
						(Collection<? extends Object>) val,
						(CollectionType) declaredType);
			result = new MInstance(mobj, mobj.getActualType());
		} else {
			MObject mobj = getMetamodelManager().wrap(val);
			result = new MInstance(mobj, declaredType);
		}

		return result;

	}

	private EClassifier findEClassifier(String i_strTypeName) {
		if (classifierMap == null) {
			classifierMap =
				Collections.synchronizedMap(new HashMap<String, EClassifier>());
			for (EObject eobj : epackage.eContents()) {
				if (eobj instanceof EClassifier) {
					EClassifier eclass = (EClassifier) eobj;
					classifierMap.put(eclass.getName(), eclass);
				}
			}
		}
		return classifierMap.get(i_strTypeName);
	}

	private Type findInCache(EClassifier eClassifier) {

		Type type;
		if (typecacheSingle == null) {
			typecacheSingle =
				Collections.synchronizedMap(new HashMap<EClassifier, Type>());
		}
		type = typecacheSingle.get(eClassifier);

		if (type == null) {
			EPackage p = eClassifier.getEPackage();
			if (sameEPackage(p, epackage)) {
				ReferenceType rtype =
					MitraFactory.eINSTANCE.createReferenceType();
				rtype.setEClassifier(eClassifier);
				rtype.setMetamodelDeclaration(getMetamodelDeclaration());

				typecacheSingle.put(eClassifier, rtype);
				type = rtype;
			}
		}
		return type;
	}

	protected static boolean sameEPackage(EPackage p1, EPackage p2) {
		return p1 == p2 || p1.getNsURI().equals(p2.getNsURI());
	}

	protected static boolean sameEClassifier(EClassifier classifierSuperType,
			EClassifier classifierType) {
		return classifierSuperType == classifierType
			|| (sameEPackage(classifierSuperType.getEPackage(),
					classifierType.getEPackage()) && classifierSuperType
				.getName().equals(classifierType.getName()));
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#getAllTypename()
	 */
	@Override
	public List<String> getAllTypename() {
		List<String> typenames = new ArrayList<String>();
		for (EClassifier eClassifier : epackage.getEClassifiers()) {
			typenames.add(eClassifier.getName());
		}
		return typenames;
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.Metamodel#wrap(java.lang.Object)
	 */
	@Override
	public MObject wrap(Object obj) {

		if (obj.getClass().isEnum()) { // generated metamodel
			String enumName = obj.getClass().getSimpleName();
			Type type = getTypeForName(enumName);
			if (type != null) {
				return new MObject(type, obj);
			}
			return null;
		}

		if (obj instanceof EEnumLiteral) { // dynamic EMF:
			EEnumLiteral enumLiteral = (EEnumLiteral) obj;
			Type type = getTypeForClass(enumLiteral.eClass());
			if (type != null) {
				return new MObject(type, obj);
			}
			return null;
		}

		if (!(obj instanceof EObject)) return null;

		EObject eObject = (EObject) obj;
		EClass eClass = eObject.eClass();
		if (!epackage.equals(eClass.getEPackage())) return null;

		Type objType = getTypeForClass(eClass);
		if (objType == null) { // cannot wrap this actual type
			log.warning("Cannot wrap type " + eClass);
			return null;
		}
		return new MObject(objType, obj);

	}

	@Override
	public MObject wrap(Type type, Object value) {
		MObject result = wrap(value);
		if (!getMetamodelManager().isSubType(result.getActualType(), type)) {
			throw new IllegalArgumentException("Cannot wrap "
				+ result.getActualType() + " into " + type);
		}
		return result;
	}

	@Override
	public String toString() {
		if (fileName == null && nsUri == null) {
			return ("no ecore file or nsURI defined yet, manager not initialized");
		}

		if (nsUri != null) {
			return "Ecore: " + nsUri;
		}

		if (fileName != null) {
			int iBeginIndex = fileName.lastIndexOf(File.separator) + 1;

			if (fileName.endsWith(".ecore")) {
				return fileName.substring(iBeginIndex, fileName.length()
					- ".ecore".length());
			}
			return fileName;
		}
		return "EMFMetamodel, no properties set";
	}

	/**
	 * Called from {@link #typeDistance(Type, Type)}.
	 * 
	 * @param typeFrom precondition:
	 *            <code>{@link MetamodelManager#getMetamodel(Type)}==this</code>
	 * @param typeTo
	 * @return
	 * @see de.jevopi.mitra2.metamodel.Metamodel#doTypeDistance(de.jevopi.mitra2.mitra.Type,
	 *      de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	protected int doTypeDistance(Type typeFrom, Type typeTo) {

		if (!(typeTo instanceof ReferenceType)) {
			return -1;
		}

		ReferenceType rtypeFrom = (ReferenceType) typeFrom;
		ReferenceType rtypeTo = (ReferenceType) typeTo;

		try {
			IMetamodel metamodelTo = getMetamodelManager().getMetamodel(typeTo);

			if (metamodelTo == this
				&& rtypeFrom.getEClassifier().getName()
					.equals(rtypeTo.getEClassifier().getName())) {
				return 0;
			}

			if (metamodelTo instanceof EMFMetamodel) {
				EClassifier classifierTo =
					((EMFMetamodel) metamodelTo).findEClassifier(rtypeTo
						.getEClassifier().getName());
				EClassifier classifierFrom =
					findEClassifier(rtypeFrom.getEClassifier().getName());
				int iTypeDist = typeDistance(classifierFrom, classifierTo);
				if (iTypeDist >= 0) {
					return iTypeDist;
				}
			}
			{
				Class<?> classFrom = getJavaClassForType(rtypeFrom);
				Class<?> classTo = metamodelTo.getJavaClassForType(rtypeTo);
				int iTypeDist = typeDistance(classFrom, classTo);
				return iTypeDist;
			}

		} catch (MetamodelNotFoundException ex) {
			log.warning("exception: " + ex); //$NON-NLS-1$ 
		}
		return -1;
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.Metamodel#doAutoCastable(de.jevopi.mitra2.mitra.Type,
	 *      de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	protected boolean doAutoCastable(Type i_typeFrom, Type i_typeTo) {
		if (!(i_typeFrom instanceof ReferenceType)) {
			throw new IllegalArgumentException(
				"Can only handle from reference tyes");
		}
		return false;

	}

	/**
	 * Let <code><pre>
	 * actualtype extends superType
	 * </pre></code> Then we get <code><pre>
	 * typeDistance(actualtype, actualtype) = 0
	 * typeDistance(actualtype, superType) = 1 
	 * typeDistance(superType, actualtype) = -1
	 * </pre></code> A parameter (the declaration) must be equal or super
	 * actualtype of the argument, i.e. the actual instance.
	 * 
	 * @param classifierSuperType
	 * @param classifierType
	 * @return
	 */
	private int typeDistance(EClassifier classifierType,
			EClassifier classifierSuperType) {
		if (sameEClassifier(classifierSuperType, classifierType)) {
			return 0;
		}

		if (classifierSuperType instanceof EClass
			&& classifierType instanceof EClass) {
			EClass classType = (EClass) classifierType;
			int iMinDist = Integer.MAX_VALUE;
			int iDist;
			for (EClassifier fromSuperType : classType.getESuperTypes()) {
				iDist = typeDistance(fromSuperType, classifierSuperType);
				if (iDist >= 0 && iDist < iMinDist) {
					iMinDist = iDist;
					if (iMinDist == 0) {
						break;
					}
				}
			}
			return (iMinDist == Integer.MAX_VALUE) ? -1 : iMinDist + 1;
		}
		return -1;
	}

	private int typeDistance(Class<?> classType, Class<?> classSuperType) {
		if (classType == null || classSuperType == null) {
			return -1;
		}
		if (classSuperType == classType) {
			return 0;
		}

		int iMinDist = Integer.MAX_VALUE;

		int iDist = typeDistance(classType.getSuperclass(), classSuperType);
		if (iDist == 0) {
			return 1; // iDist + 1
		}

		for (Class<?> fromSuperType : classType.getInterfaces()) {
			iDist = typeDistance(fromSuperType, classSuperType);
			if (iDist >= 0 && iDist < iMinDist) {
				iMinDist = iDist;
				if (iMinDist == 0) {
					break;
				}
			}
		}
		return (iMinDist == Integer.MAX_VALUE) ? -1 : iMinDist + 1;
	}

	/**
	 * Retrieves the {@link EPackage} from an {@link Object}, the later is the
	 * result of a registry lookup. If the package has been loaded before, the
	 * object returned by the registry is the actual package, otherwise a
	 * descriptor is returned by the registry and the package has to be
	 * retrieved from that descriptor.
	 * 
	 * @param obj
	 * @return EPackage or null
	 */
	private EPackage retrievePackage(Object obj) {
		if (obj == null) {
			return null;
		}
		if (obj instanceof EPackage) {
			return (EPackage) obj;
		}
		// this is the case if package has not been loaded before:
		if (obj instanceof EPackage.Descriptor) {
			return ((EPackage.Descriptor) obj).getEPackage();
		}
		return null;
	}

	/**
	 * Search model plugin and force loading of model implementation. Extensions
	 * registered at "org.eclipse.emf.ecore.generated_package" are searched.
	 * <extension point="org.eclipse.emf.ecore.generated_package"> <package
	 * uri="http://feu.de/simpleER" class="simpleER.SimpleERPackage"/>
	 * </extension>
	 * 
	 * @param nsUri
	 */
	private EPackage lookupExtension(String nsUri) {

		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point =
			registry
				.getExtensionPoint("org.eclipse.emf.ecore.generated_package");
		if (point == null) {
			return null;
		}
		IExtension[] extensions = point.getExtensions();

		for (IExtension extension : extensions) {
			String strContributorName = extension.getContributor().getName();

			IConfigurationElement[] ices = extension.getConfigurationElements();
			String strUri, strClassname;
			for (IConfigurationElement element : ices) {
				if (element.getName().equals("package")) {
					strUri = element.getAttribute("uri");
					if (nsUri.equals(strUri)) {
						strClassname = element.getAttribute("class");
						// load bundle:
						Bundle bundle = Platform.getBundle(strContributorName);
						// create package:
						try {
							Class<?> clazz = bundle.loadClass(strClassname);
							if (EPackage.class.isAssignableFrom(clazz)) {

								// load via registry, class name is usually
								// an interface!
								Object obj =
									EPackage.Registry.INSTANCE.get(nsUri);
								return retrievePackage(obj);
							}
						} catch (ClassNotFoundException ex) {
							log.warning("Cannot load package " //$NON-NLS-1$
								+ strClassname + ", ex=" + ex); //$NON-NLS-1$
						}

					}
				}
			}
		}
		return null;
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#getProperty(java.lang.String)
	 */
	@Override
	public String getProperty(String i_name) {
		if (NS_URI.equals(i_name)) {
			return nsUri;
		}
		if (ECORE_FILE.equals(i_name)) {
			return fileName;
		}
		return null;
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#equalsImplementation(de.jevopi.mitra2.mitra.metamodel.IMetamodel)
	 */
	@Override
	public boolean equalsImplementation(IMetamodel i_metamodel) {
		if (i_metamodel == this) return true;
		if (i_metamodel == null || !(i_metamodel instanceof EMFMetamodel))
			return false;

		EMFMetamodel other = (EMFMetamodel) i_metamodel;

		if (other.epackage == null || epackage == null) {
			throw new IllegalStateException(
				"Cannot compare uninitialized metamodels");
		}

		return epackage.equals(other.epackage);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.jevopi.mitra2.metamodel.Metamodel#evalFeature(de.jevopi.mitra2.mitra.Type,
	 *      de.jevopi.mitra2.mitra.Feature, java.util.List)
	 * @since Feb 7, 2012
	 */
	@Override
	public FeatureDescription evalFeature(Type receiverType, Feature feature,
			List<Type> arguments, Type iteratorLoopVarType) {

		if (feature instanceof NativeOperationInvocation) {
			return evalNativeOperationInvocation(receiverType,
					(NativeOperationInvocation) feature, arguments,
					iteratorLoopVarType);
		}

		// precondition: actualtype is reference actualtype and managed by this
		// metamodel
		// and actualtype is not many, pathitem.type is field or method

		ReferenceType rtype = (ReferenceType) receiverType;

		EClassifier eClassifier =
			findEClassifier(rtype.getEClassifier().getName());
		if (eClassifier == null) {
			runtimeError("No meta class found for "
				+ rtype.getEClassifier().getName(), feature);
			throw new MitraError();
		}

		if (eClassifier instanceof EClass) {
			EClass eClass = (EClass) eClassifier;

			if (feature instanceof FeatureField) {
				EStructuralFeature sf =
					eClass.getEStructuralFeature(feature.getName());
				if (sf == null) {
					runtimeError("Type " + eClass + " has no feature "
						+ feature, feature);
					throw new MitraError();
				}

				Type featureType = getTypeForEStructuralFeature(sf);
				Type declaredType =
					getMetamodelManager().getTypeForClassSimple(
							sf.getEContainingClass());

				FeatureFieldDescription fieldDescription =
					new FeatureFieldDescription(sf.getName(), featureType,
						sf.getLowerBound(), sf.getUpperBound(), sf.isUnique(),
						sf.isOrdered(), sf.isChangeable(), declaredType);
				return fieldDescription;

			}
			// method

			EOperation bestOp =
				findOperation(eClass, feature.getName(), arguments);

			if (bestOp == null) {
				runtimeError("Operation " + feature.getName()
					+ " not found (or argument types don't match).", feature);
				throw new MitraError();
			}

			Type featureType = getTypeForEOperation(bestOp);
			Type declaredType =
				getMetamodelManager().getTypeForClassSimple(
						bestOp.getEContainingClass());

			Type[] parameterTypes =
				getTypesForEParameters(bestOp.getEParameters());

			FeatureMethodDescription methodDescription =
				new FeatureMethodDescription(bestOp.getName(), featureType,
					bestOp.getLowerBound(), bestOp.getUpperBound(),
					bestOp.isUnique(), bestOp.isOrdered(), parameterTypes,
					declaredType);
			return methodDescription;

		} else if (eClassifier instanceof EEnum) {
			EEnum eEnum = (EEnum) eClassifier;

			if (!(feature instanceof FeatureField)) {
				runtimeError("Cannot handle access actualtype " + feature,
						feature);
				throw new MitraError();
			}
			if (eEnum.getEEnumLiteral(feature.getName()) == null) {
				runtimeError("Enumeration actualtype " + eEnum
					+ " has no literal '" + feature.getName() + "'.", feature);
				throw new MitraError();
			}

			FeatureFieldDescription fieldDescription =
				new FeatureFieldDescription(feature.getName(), rtype, 1, 1,
					false, false, false, rtype);
			return fieldDescription;

		}

		// no EClass
		runtimeError("Cannot handle " + eClassifier + " types yet", feature);
		throw new MitraError();

	}

	private EOperation findOperation(EClass eClass, String strName,
			List<Type> arguments) {
		EOperation bestOp = null;

		int iBestMatch = -1;
		int iErrorAtRating = -2;
		int iRating;
		int numberOfArguments = arguments.size();

		for (EOperation eOperation : eClass.getEAllOperations()) {
			if (eOperation.getETypeParameters().size() == numberOfArguments
				&& eOperation.getName().equals(strName)) {
				try {
					iRating =
						rateOperationTypes(arguments,
								eOperation.getEParameters());
				} catch (MetamodelNotFoundException ex) {
					throw new IllegalArgumentException(
						"Cannot handle argument actualtype", ex);
				}
				if (iRating > iBestMatch) {
					iBestMatch = iRating;
					bestOp = eOperation;
				} else if (iRating > 0 && iRating == iBestMatch) {
					iErrorAtRating = iRating;
				}
			}
		}
		if (bestOp == null) {
			// all EMF objects are EObjects, too!
			for (EOperation eOperation : EcorePackage.eINSTANCE.getEObject()
				.getEAllOperations()) {
				if (eOperation.getETypeParameters().size() == numberOfArguments
					&& eOperation.getName().equals(strName)) {
					try {
						iRating =
							rateOperationTypes(arguments,
									eOperation.getEParameters());
					} catch (MetamodelNotFoundException ex) {
						throw new IllegalArgumentException(
							"Cannot handle argument actualtype", ex);
					}
					if (iRating > iBestMatch) {
						iBestMatch = iRating;
						bestOp = eOperation;
					} else if (iRating > 0 && iRating == iBestMatch) {
						iErrorAtRating = iRating;
					}
				}
			}

		}
		if (iBestMatch == iErrorAtRating) {
			throw new IllegalArgumentException("Operation " + strName
				+ " ambigious for argument types");
		}
		return bestOp;
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#getFeature(de.jevopi.mitra2.mitra.metamodel.MObject,
	 *      de.jevopi.mitra2.mitra.metamodel.FeaturePathItem)
	 */
	@Override
	public MInstance getFeature(MInstance i_var,
			FeaturePathItem<MObject> i_pathItem) {

		FeatureDescription featureDescription =
			i_pathItem.getFeatureDescription();

		if (featureDescription instanceof NativeOperationInvocation) {
			return getNativeOperationFeature(i_var, i_pathItem);
		}

		MInstance result = null;
		String strFeatureNameName = featureDescription.getName();

		if (featureDescription.isField()) {

			EObject eobj = (EObject) i_var.getValue();
			EStructuralFeature sfeature =
				eobj.eClass().getEStructuralFeature(strFeatureNameName);
			Type declaredType = getTypeForEStructuralFeature(sfeature);

			Object val = eobj.eGet(sfeature);

			if (val instanceof Collection) {
				if (!featureDescription.isMany()) {
					log.warning("Retrieved list but feature is not many, "
						+ featureDescription);
				}
				@SuppressWarnings("unchecked")
				MObject mobj =
					getMetamodelManager().wrapCollection(
							(Collection<? extends Object>) val,
							(CollectionType) declaredType);
				result = new MInstance(mobj, mobj.getActualType());
			} else {
				MObject mobj = getMetamodelManager().wrap(val);
				result = new MInstance(mobj, declaredType);
			}

		} else if (featureDescription.isMethod()) {
			try {
				result =
					evalMethodCall(i_var, strFeatureNameName,
							i_pathItem.getArguments());
			} catch (Exception ex) {
				runtimeError("Error invoking operation " + strFeatureNameName,
						i_pathItem.getFeature(), ex);
				throw new MitraError();
			}
		} else {
			runtimeError("Wrong metamodel", i_pathItem.getFeature());
		}

		return result;

	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#getStaticFeature(de.jevopi.mitra2.mitra.Type,
	 *      de.jevopi.mitra2.mitra.metamodel.FeaturePathItem)
	 */
	@Override
	public MInstance getStaticFeature(Type i_type,
			FeaturePathItem<MObject> i_pathItem) {
		if (!(i_type instanceof ReferenceType)) {
			throw new IllegalArgumentException(
				"can only handle reference actualtype");
		}

		EClassifier eClassifier =
			findEClassifier(((ReferenceType) i_type).getEClassifier().getName());
		if (eClassifier == null) {
			runtimeError("Cannot find EClass for actualtype" + i_type,
					i_pathItem.getFeature());
			throw new MitraError();
		}

		MInstance result = null;
		FeatureDescription featureDescription =
			i_pathItem.getFeatureDescription();

		if (eClassifier instanceof EEnum && featureDescription.isField()) {
			EEnum eEnum = (EEnum) eClassifier;
			// try by literal:
			EEnumLiteral literal =
				eEnum.getEEnumLiteralByLiteral(featureDescription.getName());
			// try by name:
			if (literal == null) {
				literal = eEnum.getEEnumLiteral(featureDescription.getName());
			}
			if (literal != null) {
				Enumerator enumerator = literal.getInstance();
				Type declaredType = getTypeForClass(eClassifier); // , false);
				MObject mobj = getMetamodelManager().wrap(enumerator);
				result = new MInstance(mobj, declaredType);
			}
		}

		if (result == null) {

			Class<?> clazz = eClassifier.getInstanceClass();
			if (featureDescription.isField()) {
				try {
					Field field = clazz.getField(featureDescription.getName());
					// field.getInt(null);
					Object val = field.get(null);
					
					result =
						createMInstance(eClassifier, featureDescription, val);
					

				} catch (Exception ex) {
					throw new IllegalArgumentException(
						"Error statically accessing field "
							+ featureDescription.getName() + ": "
							+ ex.getMessage());
				}
			} else if (featureDescription.isMethod()) {
				try {
					int iArgCount = i_pathItem.getArguments().size();
					Class<?> argJavaTypes[] = new Class[iArgCount];
					Object args[] = new Object[iArgCount];
					List<Type> argTypes = new ArrayList<Type>(iArgCount);
					for (int i = 0; i < iArgCount; i++) {
						args[i] = i_pathItem.getArguments().get(i).getValue();
						argJavaTypes[i] =
							(args[i] != null) ? args[i].getClass()
								: Object.class;
						argTypes.set(i, i_pathItem.getArguments().get(i)
							.getActualType());
					}

					Method method =
						JavaUtils.findBestMatchingJavaMethod(clazz,
								featureDescription.getName(), argJavaTypes);
					Object val = method.invoke(null, args);
					
					result =
						createMInstance(eClassifier, featureDescription, val);
					

				} catch (Exception ex) {
					throw new IllegalArgumentException(
						"Error statically accessing method "
							+ featureDescription.getName() + ": "
							+ ex.getMessage());
				}

			} else { // native
				runtimeError("Wrong metamodel", i_pathItem.getFeature());
				throw new MitraError();
			}

		}

		return result;

	}

	/**
	 * @param eClassifier
	 * @param featureDescription
	 * @param val
	 * @return
	 */
	private MInstance createMInstance(EClassifier eClassifier,
			FeatureDescription featureDescription, Object val) {
		MInstance result;
		Type declaredType = null;
		if (eClassifier instanceof EClass) {
			EClass eClass = (EClass) eClassifier;
			EStructuralFeature sfeature =
				eClass.getEStructuralFeature(featureDescription
					.getName());
			declaredType = getTypeForEStructuralFeature(sfeature);
		}

		if (val instanceof Collection) {
			if (!featureDescription.isMany()) {
				log.warning("Retrieved list but feature is not many, "
					+ featureDescription);
			}
			@SuppressWarnings("unchecked")
			MObject mobj =
				getMetamodelManager().wrapCollection(
						(Collection<? extends Object>) val,
						(CollectionType) featureDescription
							.getDeclaredType());
			result = new MInstance(mobj, mobj.getActualType());
		} else {
			MObject mobj = getMetamodelManager().wrap(val);
			result = new MInstance(mobj, declaredType);
		}
		return result;
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#setFeature(de.jevopi.mitra2.mitra.metamodel.MObject,
	 *      de.jevopi.mitra2.mitra.metamodel.FeaturePathItem,
	 *      de.jevopi.mitra2.mitra.metamodel.MObject,
	 *      de.jevopi.mitra2.mitra.AssignmentOperator)
	 */
	@Override
	public MObject setFeature(MObject i_var,
			FeaturePathItem<MObject> i_pathItem, MObject i_newValue,
			AssignmentOperator i_op) {

		if (i_var.getValue() instanceof EEnumLiteral
			|| i_var.getValue() instanceof Enumerator) {
			runtimeError("Cannot change literal", i_pathItem.getFeature());
			throw new MitraError();
		}

		FeatureDescription featureDescription =
			i_pathItem.getFeatureDescription();

		if (!featureDescription.isField()) {
			runtimeError("Wrong metamodel, can only set fields",
					i_pathItem.getFeature());
			throw new MitraError();
		}
		if (i_op != AssignmentOperator.SET) {
			runtimeError("Wrong operator, can only set values",
					i_pathItem.getFeature());
			throw new MitraError();
		}

		if (!(i_var.getValue() instanceof EObject)) {
			runtimeError("Cannot set non-eobject, was: " + i_var.getValue(),
					i_pathItem.getFeature());
			throw new MitraError();
		}

		// b.c=v is translated into b.setC(v)
		EObject eobj = (EObject) i_var.getValue();
		EStructuralFeature feature =
			eobj.eClass().getEStructuralFeature(featureDescription.getName());
		if (!feature.isChangeable()) {
			runtimeError("Feature " + featureDescription.getName()
				+ " is not changeable", i_pathItem.getFeature());
			throw new MitraError();
		}

		Object oldValue = eobj.eGet(feature);
		Object newValue = i_newValue.getValue();

		EObject oldValueOldContainer =
			(oldValue instanceof EObject) ? ((EObject) oldValue).eContainer()
				: null;
		EObject newValueOldContainer =
			(newValue instanceof EObject) ? ((EObject) newValue).eContainer()
				: null;

		eobj.eSet(feature, i_newValue.getValue());

		//		Object setValue = eobj.eGet(feature);

		EObject oldValueNewContainer =
			(oldValue instanceof EObject) ? ((EObject) oldValue).eContainer()
				: null;
		EObject newValueNewContainer =
			(newValue instanceof EObject) ? ((EObject) newValue).eContainer()
				: null;

		if (oldValueOldContainer != null
			&& oldValueOldContainer != oldValueNewContainer) {
			runtimeWarning("Changed container of old value when setting "
				+ featureDescription.getName(), i_pathItem.getFeature());
		}
		if (newValueOldContainer != null
			&& newValueOldContainer != newValueNewContainer) {
			runtimeWarning("Changed container of new value when setting "
				+ featureDescription.getName(), i_pathItem.getFeature());
		}

		return i_newValue;

	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#parse(de.jevopi.mitra2.mitra.metamodel.MObject,
	 *      de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	public MObject parse(MObject i_value, Type i_targetType) {
		// precond: metmodel manages target actualtype

		ReferenceType refType = (ReferenceType) i_targetType;
		EClassifier eClassifier =
			findEClassifier(refType.getEClassifier().getName());

		if (eClassifier instanceof EEnum) {
			String strValue;
			if (i_value == null || i_value.getValue() == null) {
				strValue = "";
			} else {
				strValue = i_value.getValue().toString();
			}

			EEnum eEnum = (EEnum) eClassifier;
			EEnumLiteral literal = eEnum.getEEnumLiteralByLiteral(strValue);
			// try by name:
			if (literal == null) {
				literal = eEnum.getEEnumLiteral(strValue);
			}
			if (literal != null) {
				Enumerator enumerator = literal.getInstance();
				MObject mobj = wrap(enumerator);
				return mobj;
			}
		}

		return null;

	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#canParse(de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	public MObject canParse(Type i_targetType) {
		ReferenceType refType = (ReferenceType) i_targetType;
		EClassifier eClassifier =
			findEClassifier(refType.getEClassifier().getName());

		if (eClassifier instanceof EEnum) {
			return MObject.TRUE;
		}
		return MObject.FALSE;
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.Metamodel#getAllClassifiers()
	 */
	@Override
	public List<EClassifier> getAllClassifiers() {
		return epackage.getEClassifiers();
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getAllFeatureFieldsDescriptions(de.jevopi.mitra2.mitra.Type,
	 *      boolean, boolean)
	 */
	@Override
	public List<FeatureFieldDescription> getAllFeatureFieldsDescriptions(
			Type type, boolean bFilterUnchangeable, boolean bFilterInherited) {
		if (type == null) {
			throw new NullPointerException("actualtype must not be null");
		}

		ReferenceType referenceType = (ReferenceType) type;
		EClassifier eClassifier = referenceType.getEClassifier();
		if (eClassifier == null) {
			throw new IllegalArgumentException("Wrong metamodel for " + type);
		}

		if (eClassifier instanceof EClass) {
			EClass eClass = (EClass) eClassifier;
			EList<EStructuralFeature> structFeatures =
				eClass.getEAllStructuralFeatures();
			List<FeatureFieldDescription> featureInfos =
				new ArrayList<FeatureFieldDescription>(structFeatures.size());
			boolean bInherited;
			for (EStructuralFeature sf : structFeatures) {
				bInherited = sf.getEContainingClass() != eClass;
				if ((!bFilterUnchangeable || sf.isChangeable())
					&& (!bInherited || !bFilterInherited)) {
					Type fieldType = getTypeForEStructuralFeature(sf);
					Type declaredType =
						getMetamodelManager().getTypeForClassSimple(
								sf.getEContainingClass());

					if (fieldType != null) {
						FeatureFieldDescription featureInfo =
							new FeatureFieldDescription(sf.getName(),
								fieldType, sf.getLowerBound(),
								sf.getUpperBound(), sf.isChangeable(),
								sf.isUnique(), sf.isOrdered(), declaredType);
						featureInfos.add(featureInfo);
					} else {
						log.warning("Error, cannot retrieve actualtype for "
							+ sf);
					}
				}
			}
			return featureInfos;
		} else {
			// TODO add Java Metamodel, add Enums
			return Collections.emptyList();
		}

	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getFeatureFieldDescription(de.jevopi.mitra2.mitra.Type,
	 *      java.lang.String)
	 */
	@Override
	public FeatureFieldDescription getFeatureFieldDescription(Type type,
			String featureName) {
		if (type == null) {
			throw new NullPointerException("actualtype must not be null");
		}

		if (type instanceof ReferenceType) {
			EClassifier eClassifier = ((ReferenceType) type).getEClassifier();
			if (eClassifier != null) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					EStructuralFeature sf =
						eClass.getEStructuralFeature(featureName);
					if (sf == null) {
						return null; // no such feature
					}

					// boolean bInherited = sf.getEContainingClass() != eClass;

					Type fieldType = getTypeForEStructuralFeature(sf);
					Type declaredType =
						getMetamodelManager().getTypeForClassSimple(
								sf.getEContainingClass());

					if (fieldType != null) {
						FeatureFieldDescription featureInfo =
							new FeatureFieldDescription(sf.getName(),
								fieldType, sf.getLowerBound(),
								sf.getUpperBound(), sf.isChangeable(),
								sf.isUnique(), sf.isOrdered(), declaredType);
						return featureInfo;
					} else {
						log.warning("Error, cannot retrieve actualtype for "
							+ sf);
					}
				}
			}
		}
		return null;
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getMethodDescriptions(de.jevopi.mitra2.mitra.Type,
	 *      java.lang.String, de.jevopi.mitra2.mitra.Type[], boolean)
	 */
	@Override
	public List<FeatureMethodDescription> getMethodDescriptions(Type type,
			String matchingName, Type[] matchingArgumentTypes,
			boolean bFilterDerived) {
		if (type == null) {
			throw new NullPointerException("actualtype must not be null");
		}

		if (type instanceof ReferenceType) {
			EClassifier eClassifier = ((ReferenceType) type).getEClassifier();
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				EList<EOperation> allOperations =
					bFilterDerived ? eClass.getEOperations() : eClass
						.getEAllOperations();
				List<FeatureMethodDescription> featureMethodDescriptions =
					new ArrayList<FeatureMethodDescription>(
						allOperations.size());
				for (EOperation op : allOperations) {

					if ((matchingName == null || matchingName.equals(op
						.getName()))
						&& (matchingArgumentTypes == null || matchingArgumentTypes.length == op
							.getEParameters().size())) {

						Type[] parameterTypes =
							new Type[op.getEParameters().size()];
						for (int i = 0; i < parameterTypes.length; i++) {
							parameterTypes[i] =
								getTypeForEParameter(op.getEParameters().get(i));
							if (matchingArgumentTypes != null
								&& getMetamodelManager().calcTypeDistance(
										matchingArgumentTypes[i],
										parameterTypes[i]) < 0) {
								parameterTypes = null;
								break;
							}
						}

						if (parameterTypes != null) {
							FeatureMethodDescription featureMethodDescription =
								new FeatureMethodDescription(op.getName(),
									getTypeForEOperation(op),
									op.getLowerBound(), op.getUpperBound(),
									op.isUnique(), op.isOrdered(),
									parameterTypes, getMetamodelManager()
										.getTypeForClassSimple(
												op.getEContainingClass()));
							featureMethodDescriptions
								.add(featureMethodDescription);
						}
					}

				}
				return featureMethodDescriptions;
			}
			// TODO Java metamodel
		}

		return Collections.emptyList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getJavaClassForType(de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	public Class<?> getJavaClassForType(Type i_type) {
		if (!(i_type instanceof ReferenceType)) {
			throw new IllegalArgumentException(
				"Can only hande reference types, was " + i_type);
		}

		ReferenceType rt = (ReferenceType) i_type;
		// TODO
		// return EObject.class;

		EClassifier classifierTo =
			epackage.getEClassifier(rt.getEClassifier().getName());
		return classifierTo.getInstanceClass();

	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#getTypeForName(java.lang.String,
	 *      boolean)
	 */
	@Override
	public Type getTypeForName(String strName) {
		EClassifier eclassifier = epackage.getEClassifier(strName);
		if (eclassifier != null) {
			return getTypeForClass(eclassifier);
		}
		return null;
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#getTypeForObject(java.lang.Object)
	 */
	@Override
	public Type getTypeForObject(Object obj) {

		if (obj instanceof EObject) {
			Type type = getTypeForClass(((EObject) obj).eClass()); // , false);
			if (type == null) {
				type =
					getMetamodelManager().getTypeForClassSimple(
							((EObject) obj).eClass());
			}
			return type;
		} else if (obj instanceof EcoreEList) {

			EcoreEList<?> elist = (EcoreEList<?>) obj;
			EStructuralFeature sf = elist.getEStructuralFeature();
			return getTypeForEStructuralFeature(sf);

			// MObject mObject = getMetamodelManager().wrapCollection(elist,
			// sf.isUnique(), sf.isOrdered(),
			// getMetamodelManager().getTypeForClassSimple(sf.getEType());

		} else {
			return getMetamodelManager().getPrimitiveMetamodel()
				.getTypeForObject(obj);
		}
	}

	@Override
	public Type getTypeForClass(EClassifier classifier) {
		if (classifier instanceof EDataType) {
			String cname = classifier.getName();
			String instanceClassName = classifier.getInstanceClassName();
			// may be null!
			if ("EString".equals(cname) || "EChar".equals(cname)
				|| "java.lang.String".equals(instanceClassName)) {
				return PrimitiveMetamodel.STRING;
			}
			if ("EInt".equals(cname) || "EShort".equals(cname)
				|| "ELong".equals(cname)
				|| "java.lang.Integer".equals(instanceClassName)) {
				return PrimitiveMetamodel.INT;
			}
			if ("EFloat".equals(cname) || "EDouble".equals(cname)
				|| "java.lang.Float".equals(instanceClassName)) {
				return PrimitiveMetamodel.REAL;
			}
			if ("EBoolean".equals(cname)
				|| "java.lang.Boolean".equals(instanceClassName)) {
				return PrimitiveMetamodel.BOOLEAN;
			}
		}

		Type type = findInCache(classifier);
		return type;
	}

	/**
	 * @param structuralFeature
	 * @return
	 * @since Feb 4, 2012
	 */
	protected Type getTypeForEStructuralFeature(
			EStructuralFeature structuralFeature) {
		Type featureType =
			getMetamodelManager()
				.getTypeForClass(structuralFeature.getEType(),
						structuralFeature.getLowerBound(),
						structuralFeature.getUpperBound(),
						structuralFeature.isUnique(),
						structuralFeature.isOrdered());
		return featureType;
	}

	private Type getTypeForEOperation(EOperation operation) {
		Type declaredType;
		declaredType =
			getMetamodelManager().getTypeForClass(operation.getEType(),
					operation.getLowerBound(), operation.getUpperBound(),
					operation.isUnique(), operation.isOrdered());
		return declaredType;
	}

	private Type[] getTypesForEParameters(EList<EParameter> eParameters) {
		Type[] parameterTypes = new Type[eParameters.size()];
		for (int i = 0; i < parameterTypes.length; i++) {
			Type type = getTypeForEParameter(eParameters.get(i));
			parameterTypes[i] = type;

		}
		return parameterTypes;

	}

	private Type getTypeForEParameter(EParameter eParameter) {
		return getMetamodelManager().getTypeForClass(eParameter.getEType(),
				eParameter.getLowerBound(), eParameter.getUpperBound(),
				eParameter.isUnique(), eParameter.isOrdered());
	}

	@Override
	public boolean isComparable(Type type1, Type type2) {

		if (!(type2 instanceof ReferenceType)) return false;
		ReferenceType rt1 = (ReferenceType) type1;
		ReferenceType rt2 = (ReferenceType) type2;

		if (Comparable.class.isAssignableFrom(rt1.getEClassifier()
			.getInstanceClass())
			&& Comparable.class.isAssignableFrom(rt2.getEClassifier()
				.getInstanceClass())) {
			return getMetamodelManager().isCompatible(rt1, rt2);
		}

		return false;
	}
}
