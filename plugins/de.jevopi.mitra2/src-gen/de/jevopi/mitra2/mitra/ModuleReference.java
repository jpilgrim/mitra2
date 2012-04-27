/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.ModuleReference#getModule <em>Module</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getModuleReference()
 * @model
 * @generated
 */
public interface ModuleReference extends EObject
{
  /**
   * Returns the value of the '<em><b>Module</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Module</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Module</em>' reference.
   * @see #setModule(Module)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getModuleReference_Module()
   * @model
   * @generated
   */
  Module getModule();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.ModuleReference#getModule <em>Module</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Module</em>' reference.
   * @see #getModule()
   * @generated
   */
  void setModule(Module value);

} // ModuleReference
