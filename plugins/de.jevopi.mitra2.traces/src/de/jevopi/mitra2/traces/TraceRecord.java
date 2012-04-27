/**
 * (C) 2012 Jens von Pilgrim
 */
package de.jevopi.mitra2.traces;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Record</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.traces.TraceRecord#getName <em>Name</em>}</li>
 *   <li>{@link de.jevopi.mitra2.traces.TraceRecord#getTraces <em>Traces</em>}</li>
 *   <li>{@link de.jevopi.mitra2.traces.TraceRecord#getModels <em>Models</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.traces.TracesPackage#getTraceRecord()
 * @model
 * @generated
 */
public interface TraceRecord extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.jevopi.mitra2.traces.TracesPackage#getTraceRecord_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.jevopi.mitra2.traces.TraceRecord#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Traces</b></em>' containment reference list.
	 * The list contents are of type {@link de.jevopi.mitra2.traces.Trace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traces</em>' containment reference list.
	 * @see de.jevopi.mitra2.traces.TracesPackage#getTraceRecord_Traces()
	 * @model containment="true"
	 * @generated
	 */
	EList<Trace> getTraces();

	/**
	 * Returns the value of the '<em><b>Models</b></em>' containment reference list.
	 * The list contents are of type {@link de.jevopi.mitra2.traces.Model}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Models</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Models</em>' containment reference list.
	 * @see de.jevopi.mitra2.traces.TracesPackage#getTraceRecord_Models()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Model> getModels();

} // TraceRecord
