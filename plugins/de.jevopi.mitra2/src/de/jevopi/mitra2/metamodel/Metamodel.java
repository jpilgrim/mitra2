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

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;

import de.jevopi.mitra2.MitraError;
import de.jevopi.mitra2.MitraUtils;
import de.jevopi.mitra2.engine.TypeResolver;
import de.jevopi.mitra2.message.AbstractMessenger;
import de.jevopi.mitra2.message.IMessageAcceptor;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.Feature;
import de.jevopi.mitra2.mitra.MetamodelDeclaration;
import de.jevopi.mitra2.mitra.NativeOperationInvocation;
import de.jevopi.mitra2.mitra.PrimitiveType;
import de.jevopi.mitra2.mitra.PrimitiveTypeSpec;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.nativeoperations.INativeOperation;
import de.jevopi.mitra2.nativeoperations.NativeOperationResolver;

/**
 * Metamodel There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @since Mitra 1
 */
public abstract class Metamodel extends AbstractMessenger implements IMetamodel {

	public static boolean isAny(Type type) {
		return PrimitiveMetamodel.ANY.equals(type);
	}

	public static boolean isVoid(Type type) {
		return PrimitiveMetamodel.VOID.equals(type);
	}

	private MetamodelManager metamodelManager = null;

	protected MetamodelDeclaration metamodelDeclaration;

	protected NativeOperationResolver nativeOperationResolver = null;

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#getMetamodelDeclaration()
	 */
	@Override
	public MetamodelDeclaration getMetamodelDeclaration() {
		return metamodelDeclaration;
	}

	@Override
	protected IMessageAcceptor getMessageAcceptor() {
		return metamodelManager.getMessageAcceptor();
	}

	/**
	 * @return the nativeOperationResolver
	 */
	public synchronized NativeOperationResolver getNativeOperationResolver() {
		if (nativeOperationResolver == null) {
			nativeOperationResolver =
				new NativeOperationResolver(getMetamodelManager()
					.getProjectContext());
		}

		return nativeOperationResolver;
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#setMetamodelDeclaration(de.jevopi.mitra2.mitra.MetamodelDeclaration)
	 */
	@Override
	public void setMetamodelDeclaration(
			MetamodelDeclaration i_metamodelDeclaration) {
		if (i_metamodelDeclaration == null) {
			throw new NullPointerException(
				"i_metamodelDeclaration must not be null");
		}

		metamodelDeclaration = i_metamodelDeclaration;
	}

	@Override
	public boolean isInitializied() {
		return metamodelManager != null;
	}

	/**
	 * Sets the metamodel manager, called by subclasses in overriding init
	 * method.
	 * 
	 * @param i_metamodelManager must not be null
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#init(de.jevopi.mitra2.mitra.metamodel.MetamodelManager)
	 */
	@Override
	public void init(MetamodelManager i_metamodelManager) {
		if (i_metamodelManager == null) {
			throw new NullPointerException(
				"i_metamodelManagerProvider must not be null");
		}
		metamodelManager = i_metamodelManager;
	}

	public MetamodelManager getMetamodelManager() {
		if (metamodelManager == null) {
			throw new IllegalStateException("Metamodel not initialized yet.");
		}
		return metamodelManager;
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#createInstance(java.lang.String)
	 */
	@Override
	public MObject createInstance(Type type) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#isInstance(de.jevopi.mitra2.mitra.metamodel.MObject,
	 *      java.lang.String)
	 */
	@Override
	public boolean isInstance(MObject i_obj, String i_strTypeName) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#setProperty(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void setProperty(String i_name, String i_value) {
		throw new UnsupportedOperationException();

	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#equals(de.jevopi.mitra2.mitra.Type,
	 *      de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	public boolean equals(Type type1, Type type2) {
		return typeDistance(type1, type2) == 0;
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#typeDistance(de.jevopi.mitra2.mitra.Type,
	 *      de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	public int typeDistance(Type typeFrom, Type typeTo) {

		// shortcut
		if (typeTo.equals(typeFrom)) {
			return 0;
		}

		if (typeTo instanceof PrimitiveType
			&& ((PrimitiveType) typeTo).getPrimitiveType() == PrimitiveTypeSpec.ANY) {
			return 1000;
		}

		return doTypeDistance(typeFrom, typeTo);

	}

	protected abstract int doTypeDistance(Type typeFrom, Type typeTo);

	/**
	 * {@inheritDoc} Returns true if actualtype to is ANY or String, calls
	 * {@link #doAutoCastable(Type, Type)} in other cases.
	 * 
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#isAutoCastable(de.jevopi.mitra2.mitra.Type,
	 *      de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	public boolean isAutoCastable(Type i_typeFrom, Type i_typeTo) {
		if (i_typeFrom == i_typeTo) {
			return true;
		}

		if (i_typeTo instanceof PrimitiveType) {
			PrimitiveType pt = (PrimitiveType) i_typeTo;
			if (pt.getPrimitiveType() == PrimitiveTypeSpec.ANY
				|| pt.getPrimitiveType() == PrimitiveTypeSpec.STRING) {
				return true;
			}
		}
		return doAutoCastable(i_typeFrom, i_typeTo);
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#wrap(java.lang.Object,
	 *      de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	public abstract MObject wrap(Object i_obj);

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#castToBoolean(de.jevopi.mitra2.mitra.metamodel.MObject)
	 */
	@Override
	public boolean castToBoolean(MObject i_mobj) {

		Object val = i_mobj.getValue();

		if (val == null) {
			return false;
		}

		if (val instanceof Number) {
			return ((Number) val).intValue() != 0;
		}
		if (val instanceof Boolean) {
			return ((Boolean) val).booleanValue();
		}
		if (val instanceof Collection) {
			return !((Collection<?>) val).isEmpty();
		}

		throw new ClassCastException("Cannot cast " + i_mobj + " to boolean");

	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#castToInteger(de.jevopi.mitra2.mitra.metamodel.MObject)
	 */
	@Override
	public int castToInteger(MObject i_mobj) {
		Object val = i_mobj.getValue();

		if (val == null) {
			return 0;
		}

		if (val instanceof Number) {
			return ((Number) val).intValue();
		}
		if (val instanceof Boolean) {
			return (((Boolean) val).booleanValue()) ? 1 : 0;
		}

		throw new ClassCastException("Cannot cast " + i_mobj + " to integer");

	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#castToReal(de.jevopi.mitra2.mitra.metamodel.MObject)
	 */
	@Override
	public float castToReal(MObject i_mobj) {
		Object val = i_mobj.getValue();

		if (val == null) {
			return 0;
		}

		if (val instanceof Number) {
			return ((Number) val).floatValue();
		}
		if (val instanceof Boolean) {
			return (((Boolean) val).booleanValue()) ? 1 : 0;
		}

		throw new ClassCastException("Cannot cast " + i_mobj + " to real");

	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#castToString(de.jevopi.mitra2.mitra.metamodel.MObject)
	 */
	@Override
	public String castToString(MObject i_mobj) {
		Object val = i_mobj.getValue();

		if (val == null) {
			return "";
		}
		return val.toString();

	}

	/**
	 * @param i_typeFrom
	 * @param i_typeTo
	 * @return
	 */
	protected abstract boolean doAutoCastable(Type i_typeFrom, Type i_typeTo);

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getAllClassifiers()
	 */
	@Override
	public List<EClassifier> getAllClassifiers() {
		return Collections.emptyList();
	}

	@Override
	public FeatureDescription evalFeature(Type i_receiverType,
			Feature i_feature, List<Type> argumentOrIteratorExpTypes,
			Type iteratorLoopType) {
		if (i_feature instanceof NativeOperationInvocation) {
			return evalNativeOperationInvocation(i_receiverType,
					(NativeOperationInvocation) i_feature,
					argumentOrIteratorExpTypes, iteratorLoopType);
		}
		error("Only native operation call allowed here", i_feature,
				i_feature.eContainingFeature(), -1);
		throw new MitraError();
	}

	protected FeatureDescription evalNativeOperationInvocation(
			Type i_receiverType,
			NativeOperationInvocation nativeOperationInvocation,
			List<Type> argumentOrIteratorExpTypes, Type iteratorLoopVarType) {
		INativeOperation nativeOperation =
			getNativeOperationResolver().getNativeOperations().get(
					nativeOperationInvocation.getName());

		Type type;
		Type[] parTypes;

		if (NativeOperationResolver
			.containsIteratorExpression(nativeOperationInvocation)) {
			type =
				nativeOperation.getTypeFromIteratorExpressionCall(
						i_receiverType, iteratorLoopVarType,
						argumentOrIteratorExpTypes.get(0));
			parTypes = new Type[0];
		} else { // call with arguments:
			type =
				nativeOperation.getTypeFromArgumentCall(i_receiverType,
						argumentOrIteratorExpTypes);
			List<? extends Type> parTypesList =
				nativeOperation.getParameterTypes(i_receiverType);
			parTypes = new Type[parTypesList.size()];
			parTypesList.toArray(parTypes);
		}

		if (type instanceof CollectionType) {
			CollectionType collectionType = (CollectionType) type;
			return new FeatureNativeOperationDescription(
				nativeOperation.getName(), type, 0, -1,
				CollectionMetamodel.isUnique(collectionType),
				CollectionMetamodel.isOrdered(collectionType), parTypes,
				iteratorLoopVarType);
		}

		return new FeatureNativeOperationDescription(nativeOperation.getName(),
			type, 0, 1, false, false, parTypes, iteratorLoopVarType);

	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getFeature(de.jevopi.mitra2.metamodel.MInstance,
	 *      de.jevopi.mitra2.metamodel.FeaturePathItem)
	 */
	@Override
	public MInstance getFeature(MInstance i_var,
			FeaturePathItem<MObject> i_pathItem) {
		FeatureDescription featureDescription =
			i_pathItem.getFeatureDescription();

		if (featureDescription instanceof FeatureNativeOperationDescription) {
			return getNativeOperationFeature(i_var, i_pathItem);
		}

		runtimeError("Bug: Cannot handle non-native feature here",
				i_pathItem.getFeature());
		throw new MitraError();
	}

	protected MInstance getNativeOperationFeature(MInstance i_var,
			FeaturePathItem<MObject> i_pathItem) {
		FeatureNativeOperationDescription description =
			(FeatureNativeOperationDescription) i_pathItem
				.getFeatureDescription();
		INativeOperation nativeOperation =
			getNativeOperationResolver().getNativeOperations().get(
					description.getName());

		Type receiverType = i_var.getActualType();
		if (!nativeOperation.acceptReceiver(receiverType)) {
			runtimeError("Operation " + nativeOperation.getName()
				+ " does not support receiver of type " + receiverType,
					i_pathItem.getFeature());
			throw new MitraError();
		}

		MObject receiver = i_var.getMObject();
		Type declaredType;

		TypeResolver typeResolver =
			getMetamodelManager().getProjectContext().getTypeResolver();

		MObject result;
		if (description.isIteratorExpression()) {
			result =
				nativeOperation.invokeWithIterator(receiver,
						i_pathItem.getIteratorExpression());
			Type innerIteratorExpressionType =
				typeResolver.visitSingleton(i_pathItem.getIteratorExpression()
					.getExpression());
			declaredType =
				nativeOperation.getTypeFromIteratorExpressionCall(receiverType,
						description.iteratorLoopVarType,
						innerIteratorExpressionType);
		} else { // argument call
			result =
				nativeOperation.invokeWithArguments(receiver,
						i_pathItem.getArguments());
			List<Type> argumentOrIteratorExpTypes =
				MitraUtils.getTypes(i_pathItem.getArguments());
			declaredType =
				nativeOperation.getTypeFromArgumentCall(receiverType,
						argumentOrIteratorExpTypes);
		}
		if (result == null && ! isVoid(declaredType)) {
			runtimeError("native operation " + nativeOperation.getName()
				+ " returned null", i_pathItem.getFeature());
			throw new MitraError();
		}
		if (result == null) result = MObject.NOT_INITIALIZED;

		return new MInstance(result, declaredType);
	}

	@SuppressWarnings({
		"rawtypes", "unchecked"
	})
	@Override
	public int compareTo(MObject mObject1, MObject mObject2) {
		Comparable obj1 = (Comparable) mObject1.getValue();
		Comparable obj2 = (Comparable) mObject1.getValue();
		return obj1.compareTo(obj2);
	}

}
