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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.jevopi.ecore.utils.EMFUtil;
import de.jevopi.mitra2.metamodel.MetamodelManager.MetamodelNotFoundException;
import de.jevopi.mitra2.mitra.PrimitiveType;
import de.jevopi.mitra2.mitra.ReferenceType;
import de.jevopi.mitra2.mitra.Type;

/**
 * Wrapper around instances of a metamodel, known as objects. Just as Java class
 * return their meta actualtype (Object{@link #getClass()}, mitra objects can
 * return their meta actualtype.
 * <p>
 * MObjects usually wrap an actual object created by a {@link IMetamodel}
 * together with a reference to the actual actualtype (a {@link Class} or
 * {@link EClass}) of the meta model and the {@link IMetamodel}.
 * <p>
 * 
 * @author Jens von Pilgrim
 */
public class MObject {

	public final static MObject NOT_INITIALIZED = new MObject(
			PrimitiveMetamodel.ANY, null) {
		@Override
		public String toString() {
			return "NOT_INITIALIZED";
		}
	};

	public final static MObject NULL = new MObject(PrimitiveMetamodel.ANY, null) {
		@Override
		public String toString() {
			return "NULL";
		}

	};

	public final static MObject TRUE = new MObject(PrimitiveMetamodel.BOOLEAN,
			Boolean.TRUE) {
		@Override
		public String toString() {
			return "TRUE";
		}
	};

	public final static MObject FALSE = new MObject(PrimitiveMetamodel.BOOLEAN,
			Boolean.FALSE) {
		@Override
		public String toString() {
			return "FALSE";
		}
	};

	// public final static MObject VOID = new MObject(
	// PrimitiveMetamodel.RETURNS, ReturnList.VOIDLIST) {
	// @Override
	// public String toString() {
	// return "VOID";
	// }
	// };

	Type actualtype;

	Object value;

	/**
	 * @param i_type
	 * @param i_value
	 */
	public MObject(Type i_type, Object i_value) {
		if (i_type == null) {
			throw new NullPointerException("actualtype must not be null");
		}

		actualtype = i_type;
		value = i_value;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @since Feb 6, 2012
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (!(o instanceof MObject)) {
			return false;
		}
		MObject mobj = (MObject) o;
		if (value == null) {
			return mobj.getValue() == null;
		}
		return mobj.getValue().equals(value);
	}

	/**
	 * @see java.lang.Object#hashCode()
	 * @since Feb 6, 2012
	 */
	@Override
	public int hashCode() {
		return 42 + (value != null ? value.hashCode() : 0);
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @return the actualtype
	 */
	public Type getActualType() {
		return actualtype;
	}

	/**
	 * @return
	 * @throws MetamodelNotFoundException
	 */
	public boolean castToBoolean(MetamodelManager mmprovider)
			throws MetamodelNotFoundException {
		return getMetamodel(mmprovider).castToBoolean(this);
	}

	/**
	 * @return
	 * @throws MetamodelNotFoundException
	 */
	public String castToString(MetamodelManager mmprovider)
			throws MetamodelNotFoundException {
		return getMetamodel(mmprovider).castToString(this);
	}

	/**
	 * @return
	 * @throws MetamodelNotFoundException
	 */
	public Integer castToInteger(MetamodelManager mmprovider)
			throws MetamodelNotFoundException {
		return getMetamodel(mmprovider).castToInteger(this);
	}

	/**
	 * @return
	 * @throws MetamodelNotFoundException
	 */
	public Float castToReal(MetamodelManager mmprovider)
			throws MetamodelNotFoundException {
		return getMetamodel(mmprovider).castToReal(this);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return toString(false);
	}

	/**
	 * @see java.lang.Object#toString()
	 */

	public String toString(boolean bSuppressPrimitiveTypeName) {
		StringBuilder strb = new StringBuilder();

		if (actualtype == null) {
			strb.append("?: ");
		} else {
			if (!bSuppressPrimitiveTypeName // || actualtype.isMany()
					|| !(actualtype instanceof PrimitiveType)) {
				strb.append(String.valueOf(actualtype));
				strb.append(": ");
			}
		}

		if (value == null) {
			strb.append("null");
		} else {
			if (value instanceof EObject) {
				strb.append(EMFUtil.toHRString((EObject) value));
			} else {
				strb.append(value.toString());
			}
		}
		return strb.toString();
	}

	protected IMetamodel getMetamodel(MetamodelManager metamodelManager) {
		if (getActualType() instanceof PrimitiveType) {
			return metamodelManager.getPrimitiveMetamodel();
		} else { // ReferenceType
			return metamodelManager
					.getMetamodel(((ReferenceType) getActualType())
							.getMetamodelDeclaration());

		}
	}
}
