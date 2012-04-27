/**
 * (C) 2012 Jens von Pilgrim
 */
package de.jevopi.mitra2.traces.impl;

import de.jevopi.mitra2.traces.ParameterType;
import de.jevopi.mitra2.traces.TraceElement;
import de.jevopi.mitra2.traces.TracesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.traces.impl.TraceElementImpl#getTraceType <em>Trace Type</em>}</li>
 *   <li>{@link de.jevopi.mitra2.traces.impl.TraceElementImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.jevopi.mitra2.traces.impl.TraceElementImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link de.jevopi.mitra2.traces.impl.TraceElementImpl#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceElementImpl extends EObjectImpl implements TraceElement {
	/**
	 * The default value of the '{@link #getTraceType() <em>Trace Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceType()
	 * @generated
	 * @ordered
	 */
	protected static final ParameterType TRACE_TYPE_EDEFAULT = ParameterType.SOURCE;

	/**
	 * The cached value of the '{@link #getTraceType() <em>Trace Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceType()
	 * @generated
	 * @ordered
	 */
	protected ParameterType traceType = TRACE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected String typeName = TYPE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected EObject element;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracesPackage.Literals.TRACE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterType getTraceType() {
		return traceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceType(ParameterType newTraceType) {
		ParameterType oldTraceType = traceType;
		traceType = newTraceType == null ? TRACE_TYPE_EDEFAULT : newTraceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracesPackage.TRACE_ELEMENT__TRACE_TYPE, oldTraceType, traceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracesPackage.TRACE_ELEMENT__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeName(String newTypeName) {
		String oldTypeName = typeName;
		typeName = newTypeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracesPackage.TRACE_ELEMENT__TYPE_NAME, oldTypeName, typeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getElement() {
		if (element != null && element.eIsProxy()) {
			InternalEObject oldElement = (InternalEObject)element;
			element = eResolveProxy(oldElement);
			if (element != oldElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TracesPackage.TRACE_ELEMENT__ELEMENT, oldElement, element));
			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(EObject newElement) {
		EObject oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracesPackage.TRACE_ELEMENT__ELEMENT, oldElement, element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TracesPackage.TRACE_ELEMENT__TRACE_TYPE:
				return getTraceType();
			case TracesPackage.TRACE_ELEMENT__VALUE:
				return getValue();
			case TracesPackage.TRACE_ELEMENT__TYPE_NAME:
				return getTypeName();
			case TracesPackage.TRACE_ELEMENT__ELEMENT:
				if (resolve) return getElement();
				return basicGetElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TracesPackage.TRACE_ELEMENT__TRACE_TYPE:
				setTraceType((ParameterType)newValue);
				return;
			case TracesPackage.TRACE_ELEMENT__VALUE:
				setValue((String)newValue);
				return;
			case TracesPackage.TRACE_ELEMENT__TYPE_NAME:
				setTypeName((String)newValue);
				return;
			case TracesPackage.TRACE_ELEMENT__ELEMENT:
				setElement((EObject)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TracesPackage.TRACE_ELEMENT__TRACE_TYPE:
				setTraceType(TRACE_TYPE_EDEFAULT);
				return;
			case TracesPackage.TRACE_ELEMENT__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case TracesPackage.TRACE_ELEMENT__TYPE_NAME:
				setTypeName(TYPE_NAME_EDEFAULT);
				return;
			case TracesPackage.TRACE_ELEMENT__ELEMENT:
				setElement((EObject)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TracesPackage.TRACE_ELEMENT__TRACE_TYPE:
				return traceType != TRACE_TYPE_EDEFAULT;
			case TracesPackage.TRACE_ELEMENT__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case TracesPackage.TRACE_ELEMENT__TYPE_NAME:
				return TYPE_NAME_EDEFAULT == null ? typeName != null : !TYPE_NAME_EDEFAULT.equals(typeName);
			case TracesPackage.TRACE_ELEMENT__ELEMENT:
				return element != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated_NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder();
		// result.append(traceType);
		// result.append(' ');
		// result.append(typeName);
		// result.append('=');
		if (getValue() != null) {
			result.append('"');
			result.append(getValue());
			result.append('"');
		} else if (getElement() != null) {
			EObject eobj = getElement();
			EStructuralFeature feature = eobj.eClass().getEStructuralFeature(
					"name");
			if (feature == null)
				feature = eobj.eClass().getEStructuralFeature("title");
			if (feature != null) {
				result.append(eobj.eGet(feature));
			} else {
				result.append("#");
				result.append(eobj.eClass().getName());
				
			}
			result.append('#');
			result.append(eobj.hashCode());

		} else {
			result.append("NULL");
		}

		// result.append(getValueOrElement());
		return result.toString();
	}
	
	


} //TraceElementImpl
