/**
 * (C) 2012 Jens von Pilgrim
 */
package de.jevopi.mitra2.traces;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.traces.TraceElement#getTraceType <em>Trace Type</em>}</li>
 *   <li>{@link de.jevopi.mitra2.traces.TraceElement#getValue <em>Value</em>}</li>
 *   <li>{@link de.jevopi.mitra2.traces.TraceElement#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link de.jevopi.mitra2.traces.TraceElement#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.traces.TracesPackage#getTraceElement()
 * @model
 * @generated
 */
public interface TraceElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Trace Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.jevopi.mitra2.traces.ParameterType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace Type</em>' attribute.
	 * @see de.jevopi.mitra2.traces.ParameterType
	 * @see #setTraceType(ParameterType)
	 * @see de.jevopi.mitra2.traces.TracesPackage#getTraceElement_TraceType()
	 * @model required="true"
	 * @generated
	 */
	ParameterType getTraceType();

	/**
	 * Sets the value of the '{@link de.jevopi.mitra2.traces.TraceElement#getTraceType <em>Trace Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace Type</em>' attribute.
	 * @see de.jevopi.mitra2.traces.ParameterType
	 * @see #getTraceType()
	 * @generated
	 */
	void setTraceType(ParameterType value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see de.jevopi.mitra2.traces.TracesPackage#getTraceElement_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link de.jevopi.mitra2.traces.TraceElement#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Name</em>' attribute.
	 * @see #setTypeName(String)
	 * @see de.jevopi.mitra2.traces.TracesPackage#getTraceElement_TypeName()
	 * @model required="true"
	 * @generated
	 */
	String getTypeName();

	/**
	 * Sets the value of the '{@link de.jevopi.mitra2.traces.TraceElement#getTypeName <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' attribute.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(String value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EObject)
	 * @see de.jevopi.mitra2.traces.TracesPackage#getTraceElement_Element()
	 * @model
	 * @generated
	 */
	EObject getElement();

	/**
	 * Sets the value of the '{@link de.jevopi.mitra2.traces.TraceElement#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EObject value);
	
	

} // TraceElement
