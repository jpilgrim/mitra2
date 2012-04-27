/**
 * (C) 2012 Jens von Pilgrim
 */
package de.jevopi.mitra2.traces;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.traces.Trace#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link de.jevopi.mitra2.traces.Trace#getRuleName <em>Rule Name</em>}</li>
 *   <li>{@link de.jevopi.mitra2.traces.Trace#getElements <em>Elements</em>}</li>
 *   <li>{@link de.jevopi.mitra2.traces.Trace#getRuleInfo <em>Rule Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.traces.TracesPackage#getTrace()
 * @model
 * @generated
 */
public interface Trace extends EObject {
	/**
	 * Returns the value of the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timestamp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timestamp</em>' attribute.
	 * @see #setTimestamp(long)
	 * @see de.jevopi.mitra2.traces.TracesPackage#getTrace_Timestamp()
	 * @model
	 * @generated
	 */
	long getTimestamp();

	/**
	 * Sets the value of the '{@link de.jevopi.mitra2.traces.Trace#getTimestamp <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp</em>' attribute.
	 * @see #getTimestamp()
	 * @generated
	 */
	void setTimestamp(long value);

	/**
	 * Returns the value of the '<em><b>Rule Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Name</em>' attribute.
	 * @see #setRuleName(String)
	 * @see de.jevopi.mitra2.traces.TracesPackage#getTrace_RuleName()
	 * @model
	 * @generated
	 */
	String getRuleName();

	/**
	 * Sets the value of the '{@link de.jevopi.mitra2.traces.Trace#getRuleName <em>Rule Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Name</em>' attribute.
	 * @see #getRuleName()
	 * @generated
	 */
	void setRuleName(String value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link de.jevopi.mitra2.traces.TraceElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see de.jevopi.mitra2.traces.TracesPackage#getTrace_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<TraceElement> getElements();

	/**
	 * Returns the value of the '<em><b>Rule Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Info</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Info</em>' attribute.
	 * @see #setRuleInfo(String)
	 * @see de.jevopi.mitra2.traces.TracesPackage#getTrace_RuleInfo()
	 * @model
	 * @generated
	 */
	String getRuleInfo();

	/**
	 * Sets the value of the '{@link de.jevopi.mitra2.traces.Trace#getRuleInfo <em>Rule Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Info</em>' attribute.
	 * @see #getRuleInfo()
	 * @generated
	 */
	void setRuleInfo(String value);

} // Trace
