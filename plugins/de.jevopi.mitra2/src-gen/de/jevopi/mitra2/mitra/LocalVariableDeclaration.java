/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.LocalVariableDeclaration#getVardecl <em>Vardecl</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.LocalVariableDeclaration#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getLocalVariableDeclaration()
 * @model
 * @generated
 */
public interface LocalVariableDeclaration extends EObject
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
   * @see #setVardecl(TypedVarDeclaration)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getLocalVariableDeclaration_Vardecl()
   * @model containment="true"
   * @generated
   */
  TypedVarDeclaration getVardecl();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.LocalVariableDeclaration#getVardecl <em>Vardecl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Vardecl</em>' containment reference.
   * @see #getVardecl()
   * @generated
   */
  void setVardecl(TypedVarDeclaration value);

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(Expression)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getLocalVariableDeclaration_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.LocalVariableDeclaration#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

} // LocalVariableDeclaration
