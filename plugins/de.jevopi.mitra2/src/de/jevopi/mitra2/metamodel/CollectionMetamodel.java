/*******************************************************************************
 * Copyright (c) 2012 FernUniversitaet in Hagen
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jens von Pilgrim - initial API and implementation
 ******************************************************************************/

package de.jevopi.mitra2.metamodel;

import static java.util.Collections.emptyList;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;

import de.jevopi.mitra2.metamodel.mitracollections.DelegatingMitraBag;
import de.jevopi.mitra2.metamodel.mitracollections.DelegatingMitraOrderedSet;
import de.jevopi.mitra2.metamodel.mitracollections.DelegatingMitraSequence;
import de.jevopi.mitra2.metamodel.mitracollections.DelegatingMitraSet;
import de.jevopi.mitra2.metamodel.mitracollections.MitraBag;
import de.jevopi.mitra2.metamodel.mitracollections.MitraBagImpl;
import de.jevopi.mitra2.metamodel.mitracollections.MitraCollection;
import de.jevopi.mitra2.metamodel.mitracollections.MitraOrderedSet;
import de.jevopi.mitra2.metamodel.mitracollections.MitraOrderedSetImpl;
import de.jevopi.mitra2.metamodel.mitracollections.MitraSequence;
import de.jevopi.mitra2.metamodel.mitracollections.MitraSequenceImpl;
import de.jevopi.mitra2.metamodel.mitracollections.MitraSet;
import de.jevopi.mitra2.metamodel.mitracollections.MitraSetImpl;
import de.jevopi.mitra2.mitra.AssignmentOperator;
import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.CollectionTypeSpec;
import de.jevopi.mitra2.mitra.MetamodelDeclaration;
import de.jevopi.mitra2.mitra.MitraFactory;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.weak.WeakMitraFactory;

/**
 * @author Jens von Pilgrim (developer@jevopi.de)
 * @since Jan 18, 2012
 */
public class CollectionMetamodel extends Metamodel implements IMetamodel {

	public static final MetamodelDeclaration CollectionMetamodelDeclaration;

	static {
		CollectionMetamodelDeclaration =
			MitraFactory.eINSTANCE.createMetamodelDeclaration();
		CollectionMetamodelDeclaration.setName("#CollectionMetamodel#");
		CollectionMetamodelDeclaration.setType("mitra");

	}

	public static boolean isUnique(CollectionType collectionType) {
		switch (collectionType.getCollectionType()) {
		case BAG:
			return false;
		case SEQUENCE:
			return false;
		case SET:
			return true;
		case ORDERED_SET:
			return true;
		default:
			return false;
		}
	}

	public static boolean isOrdered(CollectionType collectionType) {
		switch (collectionType.getCollectionType()) {
		case BAG:
			return false;
		case SEQUENCE:
			return true;
		case SET:
			return false;
		case ORDERED_SET:
			return true;
		default:
			return false;
		}
	}

	public static CollectionType createCollectionType(boolean unique,
			boolean ordered, Type i_typePar) {
		CollectionType type = WeakMitraFactory.createCollectionType();
		if (unique) {
			if (ordered) {
				type.setCollectionType(CollectionTypeSpec.ORDERED_SET);
			} else {
				type.setCollectionType(CollectionTypeSpec.SET);
			}
		} else {
			if (ordered) {
				type.setCollectionType(CollectionTypeSpec.SEQUENCE);
			} else {
				type.setCollectionType(CollectionTypeSpec.BAG);
			}
		}
		type.setTypePar(i_typePar);
		return type;
	}

	public static MitraCollection createCollection(boolean unique,
			boolean ordered) {
		if (unique) {
			if (ordered) return new MitraOrderedSetImpl();
			return new MitraSetImpl();
		}
		if (ordered) return new MitraSequenceImpl();
		return new MitraBagImpl();

	}

	public static MitraCollection createCollection(
			CollectionType i_collectionType) {
		switch (i_collectionType.getCollectionType()) {
		case SEQUENCE:
			return new MitraSequenceImpl();
		case SET:
			return new MitraSetImpl();
		case ORDERED_SET:
			return new MitraOrderedSetImpl();
		case BAG:
		case COLLECTION:
		default:
			return new MitraBagImpl();
		}
	}

	public static MObject createCollectionMObject(boolean unique,
			boolean ordered, Type i_typePar) {
		Type collType = createCollectionType(unique, ordered, i_typePar);
		MitraCollection oclCollection = createCollection(unique, ordered);
		MObject mObject = new MObject(collType, oclCollection);
		return mObject;
	}

	@SuppressWarnings({
		"rawtypes", "unchecked"
	})
	public static MObject createCollectionMObject(
			CollectionType collectionType, Collection<? extends Object> raws,
			MetamodelManager metamodelManager) {

		MitraCollection mitraCollection = null;
		switch (collectionType.getCollectionType()) {
		case SEQUENCE:
			if (!(raws instanceof List)) {
				throw new IllegalArgumentException(
					"Ordered collection must of be type List");
			}
			mitraCollection =
				new DelegatingMitraSequence((List) raws, metamodelManager);
			break;
		case SET:
			if (!(raws instanceof Set)) {
				throw new IllegalArgumentException(
					"Unique collection must of be type Set");
			}
			mitraCollection =
				new DelegatingMitraSet((Set) raws, metamodelManager);
			break;
		case ORDERED_SET:
			if (!(raws instanceof List)) {
				throw new IllegalArgumentException(
					"Unique ordered collection must of be type Set");
			}
			mitraCollection =
				new DelegatingMitraOrderedSet((List) raws, metamodelManager);
			break;
		case BAG:
		case COLLECTION:
		default:
			mitraCollection = new DelegatingMitraBag(raws, metamodelManager);
		}

		MObject mObject = new MObject(collectionType, mitraCollection);
		return mObject;
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getJavaClassForType(de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	public Class<?> getJavaClassForType(Type i_type) {
		if (!(i_type instanceof CollectionType)) {
			throw new IllegalStateException(
				"Can only handle collection types, was " + i_type);
		}
		CollectionType ct = (CollectionType) i_type;
		CollectionTypeSpec cts = ct.getCollectionType();
		return getJavaClassForCollectionTypeSpec(cts);
	}

	/**
	 * @param cts
	 * @return
	 */
	protected Class<?>
			getJavaClassForCollectionTypeSpec(CollectionTypeSpec cts) {
		if (cts == null) {
			return null;
		}
		switch (cts) {
		case COLLECTION:
			return MitraCollection.class;
		case BAG:
			return MitraBag.class;
		case SEQUENCE:
			return MitraSequence.class;
		case SET:
			return MitraSet.class;
		case ORDERED_SET:
			return MitraOrderedSet.class;
		default:
			throw new IllegalStateException("unknown collection type");

		}
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getProperty(java.lang.String)
	 */
	@Override
	public String getProperty(String i_name) {
		return "";
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getTypeForObject(java.lang.Object)
	 */
	@Override
	public Type getTypeForObject(Object i_obj) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getTypeForClass(org.eclipse.emf.ecore.EClassifier)
	 */
	@Override
	public Type getTypeForClass(EClassifier i_eClassifier) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#equalsImplementation(de.jevopi.mitra2.metamodel.IMetamodel)
	 */
	@Override
	public boolean equalsImplementation(IMetamodel i_metamodel) {
		return i_metamodel instanceof CollectionMetamodel;
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getAllFeatureFieldsDescriptions(de.jevopi.mitra2.mitra.Type,
	 *      boolean, boolean)
	 */
	@Override
	public List<FeatureFieldDescription> getAllFeatureFieldsDescriptions(
			Type i_type, boolean i_bFilterUnchangeable,
			boolean i_bFilterInherited) {
		return emptyList();
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getFeatureFieldDescription(de.jevopi.mitra2.mitra.Type,
	 *      java.lang.String)
	 */
	@Override
	public FeatureFieldDescription getFeatureFieldDescription(Type i_type,
			String i_featureName) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getMethodDescriptions(de.jevopi.mitra2.mitra.Type,
	 *      java.lang.String, de.jevopi.mitra2.mitra.Type[], boolean)
	 */
	@Override
	public List<FeatureMethodDescription> getMethodDescriptions(
			Type i_receiverType, String i_matchingName,
			Type[] i_matchingArgumentTypes, boolean i_bFilterDerived) {
		return emptyList();
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getStaticFeature(de.jevopi.mitra2.mitra.Type,
	 *      de.jevopi.mitra2.metamodel.FeaturePathItem)
	 */
	@Override
	public MInstance getStaticFeature(Type i_type,
			FeaturePathItem<MObject> i_pathItem) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#setFeature(de.jevopi.mitra2.metamodel.MObject,
	 *      de.jevopi.mitra2.metamodel.FeaturePathItem,
	 *      de.jevopi.mitra2.metamodel.MObject,
	 *      de.jevopi.mitra2.mitra.AssignmentOperator)
	 */
	@Override
	public MObject setFeature(MObject i_var,
			FeaturePathItem<MObject> i_pathItem, MObject i_newValue,
			AssignmentOperator i_op) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getAllTypename()
	 */
	@Override
	public List<String> getAllTypename() {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#parse(de.jevopi.mitra2.metamodel.MObject,
	 *      de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	public MObject parse(MObject i_value, Type i_targetType) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#canParse(de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	public MObject canParse(Type i_targetType) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.Metamodel#doTypeDistance(de.jevopi.mitra2.mitra.Type,
	 *      de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	protected int doTypeDistance(Type i_typeFrom, Type i_typeTo) {
		if (!(i_typeFrom instanceof CollectionType)) {
			throw new IllegalArgumentException(
				"CollectionMetamodel can only handle collection types");
		}
		if (!(i_typeTo instanceof CollectionType)) {
			return -1;
		}

		CollectionType ctFrom = (CollectionType) i_typeFrom;
		CollectionType ctTo = (CollectionType) i_typeTo;

		int elementTypeDistance =
			getMetamodelManager().calcTypeDistance(ctFrom.getTypePar(),
					ctTo.getTypePar());
		if (elementTypeDistance < 0) return -1;

		int baseDistance = 0;
		if (ctTo.getCollectionType() != ctFrom.getCollectionType()) {
			if (ctTo.getCollectionType() == CollectionTypeSpec.COLLECTION) {
				baseDistance = 10000;
			} else {
				return -1;
			}
		}
		return baseDistance+elementTypeDistance;
	}

	/**
	 * Returns null, collections are to be wrapped by manager.
	 * 
	 * @see de.jevopi.mitra2.metamodel.Metamodel#wrap(java.lang.Object)
	 */
	@Override
	public MObject wrap(Object i_obj) {
		return null;
	}

	@Override
	public MObject wrap(Type type, Object value) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.Metamodel#doAutoCastable(de.jevopi.mitra2.mitra.Type,
	 *      de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	protected boolean doAutoCastable(Type i_typeFrom, Type i_typeTo) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getTypeForName(java.lang.String)
	 */
	@Override
	public Type getTypeForName(String i_nameOfType) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public boolean isComparable(Type type1, Type type2) {
		return false;
	}

	@Override
	public int compareTo(MObject mObject1, MObject mObject2) {
		throw new IllegalStateException("CollectionMetamodel cannot compare");
	}
}
