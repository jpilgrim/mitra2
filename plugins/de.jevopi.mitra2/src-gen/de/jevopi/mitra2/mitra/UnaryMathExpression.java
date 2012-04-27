/**
 */
package de.jevopi.mitra2.mitra;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Math Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.UnaryMathExpression#getOp <em>Op</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.UnaryMathExpression#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getUnaryMathExpression()
 * @model
 * @generated
 */
public interface UnaryMathExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * The literals are from the enumeration {@link de.jevopi.mitra2.mitra.UnaryMathOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see de.jevopi.mitra2.mitra.UnaryMathOperator
   * @see #setOp(UnaryMathOperator)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getUnaryMathExpression_Op()
   * @model
   * @generated
   */
  UnaryMathOperator getOp();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.UnaryMathExpression#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see de.jevopi.mitra2.mitra.UnaryMathOperator
   * @see #getOp()
   * @generated
   */
  void setOp(UnaryMathOperator value);

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
   * @see de.jevopi.mitra2.mitra.MitraPackage#getUnaryMathExpression_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.UnaryMathExpression#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

} // UnaryMathExpression
