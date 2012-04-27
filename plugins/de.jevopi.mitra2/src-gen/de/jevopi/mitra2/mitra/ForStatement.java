/**
 */
package de.jevopi.mitra2.mitra;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.ForStatement#getLoopVariable <em>Loop Variable</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.ForStatement#getExpression <em>Expression</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.ForStatement#getForInit <em>For Init</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.ForStatement#getForUpdate <em>For Update</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.ForStatement#getStatement <em>Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getForStatement()
 * @model
 * @generated
 */
public interface ForStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Loop Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Loop Variable</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Loop Variable</em>' containment reference.
   * @see #setLoopVariable(LoopVariable)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getForStatement_LoopVariable()
   * @model containment="true"
   * @generated
   */
  LoopVariable getLoopVariable();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.ForStatement#getLoopVariable <em>Loop Variable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Loop Variable</em>' containment reference.
   * @see #getLoopVariable()
   * @generated
   */
  void setLoopVariable(LoopVariable value);

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
   * @see de.jevopi.mitra2.mitra.MitraPackage#getForStatement_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.ForStatement#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

  /**
   * Returns the value of the '<em><b>For Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>For Init</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>For Init</em>' containment reference.
   * @see #setForInit(ForInit)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getForStatement_ForInit()
   * @model containment="true"
   * @generated
   */
  ForInit getForInit();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.ForStatement#getForInit <em>For Init</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>For Init</em>' containment reference.
   * @see #getForInit()
   * @generated
   */
  void setForInit(ForInit value);

  /**
   * Returns the value of the '<em><b>For Update</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>For Update</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>For Update</em>' containment reference.
   * @see #setForUpdate(ForUpdate)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getForStatement_ForUpdate()
   * @model containment="true"
   * @generated
   */
  ForUpdate getForUpdate();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.ForStatement#getForUpdate <em>For Update</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>For Update</em>' containment reference.
   * @see #getForUpdate()
   * @generated
   */
  void setForUpdate(ForUpdate value);

  /**
   * Returns the value of the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statement</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statement</em>' containment reference.
   * @see #setStatement(Statement)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getForStatement_Statement()
   * @model containment="true"
   * @generated
   */
  Statement getStatement();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.ForStatement#getStatement <em>Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Statement</em>' containment reference.
   * @see #getStatement()
   * @generated
   */
  void setStatement(Statement value);

} // ForStatement
