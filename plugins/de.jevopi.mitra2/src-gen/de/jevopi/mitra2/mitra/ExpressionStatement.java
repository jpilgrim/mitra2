/**
 */
package de.jevopi.mitra2.mitra;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.ExpressionStatement#getStatementExpression <em>Statement Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getExpressionStatement()
 * @model
 * @generated
 */
public interface ExpressionStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Statement Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statement Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statement Expression</em>' containment reference.
   * @see #setStatementExpression(StatementExpression)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getExpressionStatement_StatementExpression()
   * @model containment="true"
   * @generated
   */
  StatementExpression getStatementExpression();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.ExpressionStatement#getStatementExpression <em>Statement Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Statement Expression</em>' containment reference.
   * @see #getStatementExpression()
   * @generated
   */
  void setStatementExpression(StatementExpression value);

} // ExpressionStatement
