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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;

import de.jevopi.mitra2.MitraError;
import de.jevopi.mitra2.mitra.AssignmentOperator;
import de.jevopi.mitra2.mitra.MetamodelDeclaration;
import de.jevopi.mitra2.mitra.MitraFactory;
import de.jevopi.mitra2.mitra.PrimitiveType;
import de.jevopi.mitra2.mitra.PrimitiveTypeSpec;
import de.jevopi.mitra2.mitra.Type;
import de.jevopi.mitra2.mitra.impl.PrimitiveTypeImpl;

/**
 * PrimitiveMetamodel There should really be more documentation here.
 * 
 * @author Jens von Pilgrim
 * @since Mitra 1
 */
public class PrimitiveMetamodel extends Metamodel implements IMetamodel {

	public final int TYPE_DISTANCE_ANY = 10000;

	public final static MetamodelDeclaration PrimitiveMetamodelDeclaration;

	public final static PrimitiveType INT;

	public final static PrimitiveType REAL;

	public final static PrimitiveType STRING;

	public final static PrimitiveType BOOLEAN;

	public final static PrimitiveType ANY;

	public final static PrimitiveType ANY_NULL;

	public final static PrimitiveType VOID;

	public final static PrimitiveType TYPE;

	public static boolean isInt(Type t) {
		return t instanceof PrimitiveType
			&& INT.getPrimitiveType() == ((PrimitiveType) t).getPrimitiveType();
	}

	public static boolean isReal(Type t) {
		return t instanceof PrimitiveType
			&& REAL.getPrimitiveType() == ((PrimitiveType) t)
				.getPrimitiveType();
	}

	public static boolean isString(Type t) {
		return t instanceof PrimitiveType
			&& STRING.getPrimitiveType() == ((PrimitiveType) t)
				.getPrimitiveType();
	}

	public static boolean isBoolean(Type t) {
		return t instanceof PrimitiveType
			&& BOOLEAN.getPrimitiveType() == ((PrimitiveType) t)
				.getPrimitiveType();
	}

	public static boolean isAny(Type t) {
		return t instanceof PrimitiveType
			&& ANY.getPrimitiveType() == ((PrimitiveType) t).getPrimitiveType();
	}

	public static boolean isAnyNull(Type t) {
		return ANY_NULL.equals(t);
	}

	public static boolean isVoid(Type t) {
		return t instanceof PrimitiveType
			&& VOID.getPrimitiveType() == ((PrimitiveType) t)
				.getPrimitiveType();
	}

	/**
	 * Immutable actualtype implementation used for constants. Clone returns a
	 * mutable actualtype (with a mutable bounds object).
	 * 
	 * @author Jens von Pilgrim
	 */
	public static class ConstType extends PrimitiveTypeImpl {

		public ConstType(PrimitiveTypeSpec typespec) {
			super.setPrimitiveType(typespec);
		}

		/**
		 * @see de.jevopi.mitra2.mitra.impl.PrimitiveTypeImpl#setPrimitiveType(de.jevopi.mitra2.mitra.PrimitiveTypeSpec)
		 */
		@Override
		public void setPrimitiveType(PrimitiveTypeSpec i_newPrimitiveType) {
			throw new UnsupportedOperationException(
				"Constant actualtype must not be changed");
		}

	}

	static {
		INT = new ConstType(PrimitiveTypeSpec.INT);
		STRING = new ConstType(PrimitiveTypeSpec.STRING);
		BOOLEAN = new ConstType(PrimitiveTypeSpec.BOOLEAN);
		REAL = new ConstType(PrimitiveTypeSpec.REAL);
		ANY = new ConstType(PrimitiveTypeSpec.ANY);
		ANY_NULL = new ConstType(PrimitiveTypeSpec.ANY);
		VOID = new ConstType(PrimitiveTypeSpec.VOID);
		TYPE = new ConstType(PrimitiveTypeSpec.TYPE);

		PrimitiveMetamodelDeclaration =
			MitraFactory.eINSTANCE.createMetamodelDeclaration();
		PrimitiveMetamodelDeclaration.setName("#PrimitiveMetamodel#");
		PrimitiveMetamodelDeclaration.setType("mitra");

	}

	private final static List<String> allTypeNames = Collections
		.unmodifiableList(Arrays.asList(new String[] {
			"all", "boolean", "int", "real", "String", "Type"
		}));

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#wrap(java.lang.Object)
	 */
	@Override
	public MObject wrap(Object obj) {
		if (obj == null) {
			return MObject.NULL;
		}
		if (obj instanceof String) {
			return wrapString(String.valueOf(obj));
		}
		if (obj instanceof Integer || obj instanceof Byte
			|| obj instanceof Long) {
			return wrapInteger(((Number) obj).intValue());
		}
		if (obj instanceof Number) {
			return wrapReal(((Number) obj).floatValue());
		}
		if (obj instanceof Boolean) {
			return wrapBoolean((Boolean) obj);
		}
		if (obj instanceof Type) {
			return wrapType((Type) obj);
		}

		return null;
	}

	public MObject wrapString(String i_string) {
		return new MObject(STRING, i_string);
	}

	public MObject wrapBoolean(Boolean i_obj) {
		return (i_obj.booleanValue()) ? MObject.TRUE : MObject.FALSE;
	}

	public MObject wrapInteger(Integer i_obj) {
		return new MObject(INT, i_obj);
	}

	public MObject wrapReal(Float i_obj) {
		return new MObject(REAL, i_obj);
	}

	public MObject wrapType(Type i_obj) {
		return new MObject(TYPE, i_obj); // do not clone (normalization lost)
	}

	@Override
	public MObject wrap(Type type, Object value) {
		PrimitiveType pt = (PrimitiveType) type;

		if (value instanceof String) {
			String s = (String) value;
			switch (pt.getPrimitiveType()) {
			case ANY:
			case STRING:
				return wrapString(s);
			case INT:
				return wrapInteger(Integer.parseInt(s));
			case REAL:
				return wrapReal(Float.parseFloat(s));
			case BOOLEAN:
				return wrapBoolean(Boolean.parseBoolean(s));
			default:
				throw new IllegalArgumentException("Cannot wrap into type "
					+ type);
			}
		}

		MObject result = wrap(value);
		if (!ANY.equals(type) && !result.getActualType().equals(type)) {

			if (REAL.equals(type) && INT.equals(result.getActualType())
				&& result.getValue() instanceof Integer) {
				return new MObject(type,
					((Integer) result.getValue()).floatValue());
			}

			throw new IllegalArgumentException("Cannot wrap "
				+ result.getActualType() + " into " + type);
		}
		return result;

	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Internally, {@link #createInstance(PrimitiveTypeSpec)} is called, the
	 * later is more performant than this METHOD since no string must be parsed.
	 * 
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#createInstance(java.lang.String)
	 */
	@Override
	public MObject createInstance(Type type) {
		if (type instanceof PrimitiveType) {
			PrimitiveTypeSpec typespec =
				((PrimitiveType) type).getPrimitiveType();
			switch (typespec) {
			case STRING:
				return wrapString("");
			case INT:
				return wrapInteger(0);
			case REAL:
				return wrapReal(0.0f);
			case BOOLEAN:
				return MObject.FALSE;
			case TYPE:
				return wrapType(ANY);
			case ANY:
				return MObject.NULL;
			default:
				throw new IllegalStateException("Typespec " + typespec
					+ " unknown");
			}
		} else {
			throw new IllegalStateException("Cannot handle actualtype "
				+ String.valueOf(type));
		}
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#isInstance(de.jevopi.mitra2.mitra.metamodel.MObject,
	 *      java.lang.String)
	 */
	@Override
	public boolean isInstance(MObject obj, String strTypeName) {
		Object value = obj.getValue();
		if (STRING.getPrimitiveType().getName().equals(strTypeName)) {
			return value instanceof String;
		} else if (INT.getPrimitiveType().getName().equals(strTypeName)) {
			return value instanceof Integer;
		} else if (REAL.getPrimitiveType().getName().equals(strTypeName)) {
			return value instanceof Float;
		} else if (BOOLEAN.getPrimitiveType().getName().equals(strTypeName)) {
			return value instanceof Boolean;
		} else if (TYPE.getPrimitiveType().getName().equals(strTypeName)) {
			return value instanceof Type;
		} else if (ANY.getPrimitiveType().getName().equals(strTypeName)) {
			return true;
		} else {
			throw new IllegalStateException("Type " + strTypeName + " unkown.");
		}
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#setProperty(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void setProperty(String i_name, String i_value) {
		throw new UnsupportedOperationException(
			"Primitive meta model doesn't support properties");
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#castToBoolean(de.jevopi.mitra2.mitra.metamodel.MObject)
	 */
	@Override
	public boolean castToBoolean(MObject i_mobj) {
		if (i_mobj.getValue() == null) {
			return false;
		}

		if (i_mobj.getActualType() == BOOLEAN) {
			return ((Boolean) i_mobj.getValue()).booleanValue();
		} else if (i_mobj.getActualType() == INT) {
			return (Integer) i_mobj.getValue() != 0;
		} else if (i_mobj.getActualType() == REAL) {
			return (Float) i_mobj.getValue() != 0;
		} else if (i_mobj.getActualType() == STRING) {
			return i_mobj.getValue().toString().length() > 0;
		} else if (i_mobj.getActualType() == ANY) {
			throw new IllegalArgumentException("Cannot cast any, value is "
				+ i_mobj.getValue());
		} else if (i_mobj.getActualType() == TYPE) {
			throw new IllegalArgumentException(
				"Cannot cast actualtype, value is " + i_mobj.getValue());
		} else {
			if (!(i_mobj.getActualType() instanceof PrimitiveType)) {
				throw new IllegalArgumentException(
					"Cannot cast mojbect of actualtype "
						+ i_mobj.getActualType());
			}
			throw new IllegalArgumentException(
				"Type of object unknown, object wrongly created, actualtype is "
					+ i_mobj.getActualType());
		}

	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#castToInteger(de.jevopi.mitra2.mitra.metamodel.MObject)
	 */
	@Override
	public int castToInteger(MObject i_mobj) {
		if (i_mobj.getValue() == null) {
			return 0;
		}
		if (i_mobj.getActualType() == BOOLEAN) {
			return (((Boolean) i_mobj.getValue()).booleanValue()) ? 1 : 0;
		} else if (i_mobj.getActualType() == INT) {
			return ((Integer) i_mobj.getValue()).intValue();
		} else if (i_mobj.getActualType() == REAL) {
			return ((Float) i_mobj.getValue()).intValue();
		}

		throw new IllegalArgumentException("Cannot cast "
			+ i_mobj.getActualType() + " to int");
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#castToReal(de.jevopi.mitra2.mitra.metamodel.MObject)
	 */
	@Override
	public float castToReal(MObject i_mobj) {
		if (i_mobj.getValue() == null) {
			return 0.0f;
		}

		if (i_mobj.getActualType() == BOOLEAN) {
			return (((Boolean) i_mobj.getValue()).booleanValue()) ? 1 : 0;
		} else if (i_mobj.getActualType() == INT) {
			return ((Integer) i_mobj.getValue()).intValue();
		} else if (i_mobj.getActualType() == REAL) {
			return ((Float) i_mobj.getValue()).floatValue();
		}
		throw new IllegalArgumentException("Cannot cast "
			+ i_mobj.getActualType() + " to real");

	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#castToString(de.jevopi.mitra2.mitra.metamodel.MObject)
	 */
	@Override
	public String castToString(MObject i_mobj) {
		if (i_mobj.getValue() == null) {
			return "";
		}

		if (i_mobj.getActualType() == TYPE) {
			if (i_mobj.getValue() instanceof PrimitiveType) {
				return ((PrimitiveType) (i_mobj.getValue())).getPrimitiveType()
					.getLiteral();
			} else {
				return i_mobj.getValue().toString();
			}
		}

		if (i_mobj.getActualType().equals(BOOLEAN)
			|| i_mobj.getActualType().equals(INT)
			|| i_mobj.getActualType().equals(REAL)
			|| i_mobj.getActualType().equals(STRING)
			|| i_mobj.getActualType().equals(ANY)) {
			return i_mobj.getValue().toString();
		} else {
			if (!(i_mobj.getActualType() instanceof PrimitiveType)) {
				throw new IllegalArgumentException(
					"Cannot cast mojbect of actualtype "
						+ i_mobj.getActualType());
			}
			throw new IllegalArgumentException(
				"Type of object unknown, object wrongly created, actualtype is "
					+ i_mobj.getActualType());
		}
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#getJavaClassForType(de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	public Class<?> getJavaClassForType(Type i_type) {
		if (!(i_type instanceof PrimitiveType)) {
			throw new IllegalArgumentException(
				"Can only handle primitive types, was " + i_type);
		}
		PrimitiveType pt = (PrimitiveType) i_type;
		switch (pt.getPrimitiveType()) {
		case STRING:
			return String.class;
		case INT:
			return Integer.class;
		case REAL:
			return Float.class;
		case BOOLEAN:
			return Boolean.class;
		case TYPE:
			return Type.class;
		case ANY:
		default:
			return Object.class;
		}
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getTypeForName(java.lang.String)
	 */
	@Override
	public Type getTypeForName(String strName) {

		if ("String".equals(strName)) {
			return STRING;
		}
		if ("int".equals(strName)) {
			return INT;
		}
		if ("real".equals(strName)) {
			return REAL;
		}
		if ("boolean".equals(strName)) {
			return BOOLEAN;
		}
		if ("Type".equals(strName)) {
			return ANY;
		}
		if ("any".equals(strName)) {
			return ANY;
		}
		return null;
	}

	/**
	 * Any actualtype can be converted to ANY, i.e. the distance to ANY is
	 * always positive ({@link #TYPE_DISTANCE_ANY})).
	 * 
	 * @see de.jevopi.mitra2.mitra.metamodel.Metamodel#doTypeDistance(de.jevopi.mitra2.mitra.Type,
	 *      de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	protected int doTypeDistance(Type i_typeFrom, Type i_typeTo) {
		if (!(i_typeFrom instanceof PrimitiveType)) {
			throw new IllegalArgumentException(
				"Can only handle primitive types");
		}

		// Note: type1.equals(type2) is not working!

		// type1 is instance of this metamodel, i.e. is a primitive actualtype
		// this is a precondition
		PrimitiveType ptypeFrom = (PrimitiveType) i_typeFrom;

		if (i_typeTo instanceof PrimitiveType) {
			PrimitiveType ptypeTo = (PrimitiveType) i_typeTo;
			PrimitiveTypeSpec typeSpecTo = ptypeTo.getPrimitiveType();
			PrimitiveTypeSpec typeSpecFrom = ptypeFrom.getPrimitiveType();
			if (typeSpecTo == typeSpecFrom) {
				return 0;
			}

			if (typeSpecTo == PrimitiveTypeSpec.ANY) {
				return TYPE_DISTANCE_ANY;
			}

		}

		return -1;
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.Metamodel#doAutoCastable(de.jevopi.mitra2.mitra.Type,
	 *      de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	protected boolean doAutoCastable(Type i_typeFrom, Type i_typeTo) {
		if (!(i_typeFrom instanceof PrimitiveType)) {
			throw new IllegalArgumentException(
				"Can only handle primitive types");
		}

		if (i_typeTo instanceof PrimitiveType) {
			PrimitiveTypeSpec ptypeFrom =
				((PrimitiveType) i_typeFrom).getPrimitiveType();
			PrimitiveTypeSpec ptypeTo =
				((PrimitiveType) i_typeTo).getPrimitiveType();

			switch (ptypeFrom) {
			case INT:
			case REAL:
				return ptypeTo == PrimitiveTypeSpec.REAL
					|| ptypeTo == PrimitiveTypeSpec.INT;
			}
		}

		return false;

	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#getTypeForObject(java.lang.Object)
	 */
	@Override
	public Type getTypeForObject(Object obj) {
		if (obj instanceof Boolean) {
			return BOOLEAN;
		}
		if (obj instanceof Float) {
			return REAL;
		}
		if (obj instanceof Integer) {
			return INT;
		}
		if (obj instanceof String) {
			return STRING;
		}
		if (obj instanceof Type) {
			return TYPE;
		}
		return ANY;
	}

	/**
	 * Always returns null, primitive metamodel has no properties.
	 * 
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#getProperty(java.lang.String)
	 */
	@Override
	public String getProperty(String i_name) {
		return null;
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#equalsImplementation(de.jevopi.mitra2.mitra.metamodel.IMetamodel)
	 */
	@Override
	public boolean equalsImplementation(IMetamodel i_metamodel) {
		return i_metamodel instanceof PrimitiveMetamodel;
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#getAllTypename()
	 */
	@Override
	public List<String> getAllTypename() {
		return allTypeNames;
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
		if (featureDescription.isnativeOperation()) {
			return super.getFeature(i_var, i_pathItem);
		} else { // field or method
			if (i_var.getActualType() == TYPE) { // static access:
				Type type = (Type) i_var.getValue();
				IMetamodel metamodel = getMetamodelManager().getMetamodel(type);
				return metamodel.getStaticFeature(type, i_pathItem);
			} else {
				runtimeError(
						"Primitive types do only support native operation access ('xx->method()')",
						i_pathItem.getFeature());
				throw new MitraError();
			}
		}
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#getTypeForClass(org.eclipse.emf.ecore.EClassifier,
	 *      boolean)
	 */
	@Override
	public Type getTypeForClass(EClassifier i_eClassifier) {
		return null;
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

		if (i_op == AssignmentOperator.SET) {
			runtimeError("No features of primitive types can be set",
					i_pathItem.getFeature());
			throw new MitraError();
		}

		// operation is ADD or SUB
		if (i_pathItem == null) {
			// we cannot set, but we can return the updated value:
			Object value;
			if (i_var.getActualType() == INT) {
				value = castToInteger(i_var) + castToInteger(i_newValue);
			} else if (i_var.getActualType() == REAL) {
				value = new Float(castToReal(i_var) + castToReal(i_newValue));
			} else if (i_var.getActualType() == STRING) {
				value = castToString(i_var) + castToString(i_newValue);
			} else {
				throw new IllegalArgumentException(
					"Cannot add/sub to actualtype " + i_var.getActualType());
			}
			return new MObject(i_var.getActualType(), value);
		} else {
			runtimeError("No features of primitive types can be set",
					i_pathItem.getFeature());
			throw new MitraError();
		}
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#getStaticFeature(de.jevopi.mitra2.mitra.Type,
	 *      de.jevopi.mitra2.mitra.metamodel.FeaturePathItem)
	 */
	@Override
	public MInstance getStaticFeature(Type i_type,
			FeaturePathItem<MObject> i_pathItem) {
		runtimeError(
				"primitive actualtype have no static members, use '->' for native operation call",
				i_pathItem.getFeature());
		throw new MitraError();
	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#parse(de.jevopi.mitra2.mitra.metamodel.MObject,
	 *      de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	public MObject parse(MObject i_value, Type i_targetType) {
		if (!(i_targetType instanceof PrimitiveType)) {
			throw new IllegalArgumentException(
				"targetType must be PrimitiveType");
		}

		String strValue;
		if (i_value == null || i_value.getValue() == null) {
			strValue = "";
		} else {
			strValue = i_value.getValue().toString();
		}

		switch (((PrimitiveType) i_targetType).getPrimitiveType()) {
		case STRING:
			return wrapString(strValue);
		case BOOLEAN:
			return wrapBoolean(Boolean.parseBoolean(strValue));
		case INT:
			return wrapInteger(Integer.parseInt(strValue));
		case REAL:
			return wrapReal(Float.parseFloat(strValue));
		default:
			return MObject.NULL;
		}

	}

	/**
	 * @see de.jevopi.mitra2.mitra.metamodel.IMetamodel#canParse(de.jevopi.mitra2.mitra.Type)
	 */
	@Override
	public MObject canParse(Type i_targetType) {
		if (!(i_targetType instanceof PrimitiveType)) {
			throw new IllegalArgumentException(
				"targetType must be PrimitiveType");
		}

		switch (((PrimitiveType) i_targetType).getPrimitiveType()) {
		case STRING:
		case BOOLEAN:
		case INT:
		case REAL:
			return MObject.TRUE;
		}

		return MObject.FALSE;

	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getAllFeatureFieldsDescriptions(de.jevopi.mitra2.mitra.Type,
	 *      boolean, boolean)
	 */
	@Override
	public List<FeatureFieldDescription> getAllFeatureFieldsDescriptions(
			Type i_type, boolean i_bFilterUnchangeable,
			boolean i_bFilterInherited) {
		return Collections.emptyList();
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getFeatureFieldDescription(de.jevopi.mitra2.mitra.Type,
	 *      java.lang.String)
	 */
	@Override
	public FeatureFieldDescription getFeatureFieldDescription(Type i_type,
			String i_featureName) {
		return null;
	}

	/**
	 * @see de.jevopi.mitra2.metamodel.IMetamodel#getMethodDescriptions(de.jevopi.mitra2.mitra.Type,
	 *      java.lang.String, de.jevopi.mitra2.mitra.Type[], boolean)
	 */
	@Override
	public List<FeatureMethodDescription> getMethodDescriptions(
			Type i_receiverType, String i_matchingName,
			Type[] i_matchingArgumentTypes, boolean i_bFilterDerived) {
		return Collections.emptyList();
	}

	public static boolean isNumeric(Type t) {
		return t instanceof PrimitiveType && (INT.equals(t) || REAL.equals(t));
	}

	@Override
	public boolean isComparable(Type type1, Type type2) {
		return ((isNumeric(type1) && isNumeric(type2)) || (isString(type1) && isString(type2)));
	}

	@Override
	public int compareTo(MObject mObject1, MObject mObject2) {
		if (isString(mObject1.getActualType())) {
			return castToString(mObject1).compareTo(castToString(mObject2));
		}
		if (isNumeric(mObject1.getActualType())) {
			float diff = castToReal(mObject1) - castToReal(mObject2);
			return diff < 0 ? -1 : diff > 0 ? 1 : 0;
		}
		throw new IllegalArgumentException("Cannot compare " + mObject1
			+ " with " + mObject2);
	}

}
