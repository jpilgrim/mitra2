/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Update</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.ForUpdate#getStatementExpression <em>Statement Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getForUpdate()
 * @model
 * @generated
 */
public interface ForUpdate extends EObject
{
  /**
   * Returns the value of the '<em><b>Statement Expression</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.StatementExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statement Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statement Expression</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getForUpdate_StatementExpression()
   * @model containment="true"
   * @generated
   */
  EList<StatementExpression> getStatementExpression();

} // ForUpdate
