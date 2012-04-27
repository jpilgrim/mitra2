/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Catch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.Catch#getFormalParameter <em>Formal Parameter</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.Catch#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getCatch()
 * @model
 * @generated
 */
public interface Catch extends EObject
{
  /**
   * Returns the value of the '<em><b>Formal Parameter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formal Parameter</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formal Parameter</em>' containment reference.
   * @see #setFormalParameter(FormalParameter)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getCatch_FormalParameter()
   * @model containment="true"
   * @generated
   */
  FormalParameter getFormalParameter();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.Catch#getFormalParameter <em>Formal Parameter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formal Parameter</em>' containment reference.
   * @see #getFormalParameter()
   * @generated
   */
  void setFormalParameter(FormalParameter value);

  /**
   * Returns the value of the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Block</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Block</em>' containment reference.
   * @see #setBlock(Block)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getCatch_Block()
   * @model containment="true"
   * @generated
   */
  Block getBlock();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.Catch#getBlock <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block</em>' containment reference.
   * @see #getBlock()
   * @generated
   */
  void setBlock(Block value);

} // Catch
