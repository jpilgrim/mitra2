/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Try Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.TryStatement#getTryBlock <em>Try Block</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.TryStatement#getCatches <em>Catches</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.TryStatement#getFinallyBlock <em>Finally Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getTryStatement()
 * @model
 * @generated
 */
public interface TryStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Try Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Try Block</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Try Block</em>' containment reference.
   * @see #setTryBlock(Block)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getTryStatement_TryBlock()
   * @model containment="true"
   * @generated
   */
  Block getTryBlock();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.TryStatement#getTryBlock <em>Try Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Try Block</em>' containment reference.
   * @see #getTryBlock()
   * @generated
   */
  void setTryBlock(Block value);

  /**
   * Returns the value of the '<em><b>Catches</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.Catch}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Catches</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Catches</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getTryStatement_Catches()
   * @model containment="true"
   * @generated
   */
  EList<Catch> getCatches();

  /**
   * Returns the value of the '<em><b>Finally Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Finally Block</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Finally Block</em>' containment reference.
   * @see #setFinallyBlock(Block)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getTryStatement_FinallyBlock()
   * @model containment="true"
   * @generated
   */
  Block getFinallyBlock();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.TryStatement#getFinallyBlock <em>Finally Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Finally Block</em>' containment reference.
   * @see #getFinallyBlock()
   * @generated
   */
  void setFinallyBlock(Block value);

} // TryStatement
