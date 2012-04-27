/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Invocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleInvocation#getRuleDeclaration <em>Rule Declaration</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleInvocation#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleInvocation()
 * @model
 * @generated
 */
public interface RuleInvocation extends StatementExpression, TerminalExpression
{
  /**
   * Returns the value of the '<em><b>Rule Declaration</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rule Declaration</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rule Declaration</em>' reference.
   * @see #setRuleDeclaration(RuleDeclaration)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleInvocation_RuleDeclaration()
   * @model
   * @generated
   */
  RuleDeclaration getRuleDeclaration();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.RuleInvocation#getRuleDeclaration <em>Rule Declaration</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rule Declaration</em>' reference.
   * @see #getRuleDeclaration()
   * @generated
   */
  void setRuleDeclaration(RuleDeclaration value);

  /**
   * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arguments</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleInvocation_Arguments()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getArguments();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (eIsProxy()) return super.toString();\nreturn ToString.valueOf(this);'"
   * @generated
   */
  String toString();

} // RuleInvocation
