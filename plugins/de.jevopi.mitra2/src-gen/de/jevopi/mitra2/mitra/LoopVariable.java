/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.LoopVariable#getVardecl <em>Vardecl</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getLoopVariable()
 * @model
 * @generated
 */
public interface LoopVariable extends EObject
{
  /**
   * Returns the value of the '<em><b>Vardecl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vardecl</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vardecl</em>' containment reference.
   * @see #setVardecl(VarDeclaration)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getLoopVariable_Vardecl()
   * @model containment="true"
   * @generated
   */
  VarDeclaration getVardecl();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.LoopVariable#getVardecl <em>Vardecl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Vardecl</em>' containment reference.
   * @see #getVardecl()
   * @generated
   */
  void setVardecl(VarDeclaration value);

} // LoopVariable
