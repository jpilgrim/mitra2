/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Init</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.ForInit#getStatementExpressions <em>Statement Expressions</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.ForInit#getVarDeclarations <em>Var Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getForInit()
 * @model
 * @generated
 */
public interface ForInit extends EObject
{
  /**
   * Returns the value of the '<em><b>Statement Expressions</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.StatementExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statement Expressions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statement Expressions</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getForInit_StatementExpressions()
   * @model containment="true"
   * @generated
   */
  EList<StatementExpression> getStatementExpressions();

  /**
   * Returns the value of the '<em><b>Var Declarations</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.LocalVariableDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var Declarations</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getForInit_VarDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<LocalVariableDeclaration> getVarDeclarations();

} // ForInit
