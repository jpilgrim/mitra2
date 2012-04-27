/**
 * (C) 2012 Jens von Pilgrim
 */
package de.jevopi.mitra2.traces;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.traces.Model#getUriModel <em>Uri Model</em>}</li>
 *   <li>{@link de.jevopi.mitra2.traces.Model#getModelRoot <em>Model Root</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.traces.TracesPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Uri Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri Model</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri Model</em>' attribute.
	 * @see #setUriModel(String)
	 * @see de.jevopi.mitra2.traces.TracesPackage#getModel_UriModel()
	 * @model
	 * @generated
	 */
	String getUriModel();

	/**
	 * Sets the value of the '{@link de.jevopi.mitra2.traces.Model#getUriModel <em>Uri Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri Model</em>' attribute.
	 * @see #getUriModel()
	 * @generated
	 */
	void setUriModel(String value);

	/**
	 * Returns the value of the '<em><b>Model Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Root</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Root</em>' reference.
	 * @see #setModelRoot(EObject)
	 * @see de.jevopi.mitra2.traces.TracesPackage#getModel_ModelRoot()
	 * @model required="true"
	 * @generated
	 */
	EObject getModelRoot();

	/**
	 * Sets the value of the '{@link de.jevopi.mitra2.traces.Model#getModelRoot <em>Model Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Root</em>' reference.
	 * @see #getModelRoot()
	 * @generated
	 */
	void setModelRoot(EObject value);

} // Model
