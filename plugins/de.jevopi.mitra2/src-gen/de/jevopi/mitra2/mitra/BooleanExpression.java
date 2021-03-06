/**
 */
package de.jevopi.mitra2.mitra;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.BooleanExpression#getLhs <em>Lhs</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.BooleanExpression#getOp <em>Op</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.BooleanExpression#getRhs <em>Rhs</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getBooleanExpression()
 * @model
 * @generated
 */
public interface BooleanExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lhs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lhs</em>' containment reference.
   * @see #setLhs(Expression)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getBooleanExpression_Lhs()
   * @model containment="true"
   * @generated
   */
  Expression getLhs();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.BooleanExpression#getLhs <em>Lhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lhs</em>' containment reference.
   * @see #getLhs()
   * @generated
   */
  void setLhs(Expression value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * The literals are from the enumeration {@link de.jevopi.mitra2.mitra.BooleanOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see de.jevopi.mitra2.mitra.BooleanOperator
   * @see #setOp(BooleanOperator)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getBooleanExpression_Op()
   * @model
   * @generated
   */
  BooleanOperator getOp();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.BooleanExpression#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see de.jevopi.mitra2.mitra.BooleanOperator
   * @see #getOp()
   * @generated
   */
  void setOp(BooleanOperator value);

  /**
   * Returns the value of the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rhs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rhs</em>' containment reference.
   * @see #setRhs(Expression)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getBooleanExpression_Rhs()
   * @model containment="true"
   * @generated
   */
  Expression getRhs();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.BooleanExpression#getRhs <em>Rhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rhs</em>' containment reference.
   * @see #getRhs()
   * @generated
   */
  void setRhs(Expression value);

} // BooleanExpression
