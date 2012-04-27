/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.VariableAccess#getPrefixOperator <em>Prefix Operator</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.VariableAccess#getVariable <em>Variable</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.VariableAccess#getFeatures <em>Features</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.VariableAccess#getDefault <em>Default</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.VariableAccess#getPostfixOperator <em>Postfix Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getVariableAccess()
 * @model
 * @generated
 */
public interface VariableAccess extends StatementExpression, TerminalExpression
{
  /**
   * Returns the value of the '<em><b>Prefix Operator</b></em>' attribute.
   * The literals are from the enumeration {@link de.jevopi.mitra2.mitra.PPOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Prefix Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Prefix Operator</em>' attribute.
   * @see de.jevopi.mitra2.mitra.PPOperator
   * @see #setPrefixOperator(PPOperator)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getVariableAccess_PrefixOperator()
   * @model
   * @generated
   */
  PPOperator getPrefixOperator();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.VariableAccess#getPrefixOperator <em>Prefix Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Prefix Operator</em>' attribute.
   * @see de.jevopi.mitra2.mitra.PPOperator
   * @see #getPrefixOperator()
   * @generated
   */
  void setPrefixOperator(PPOperator value);

  /**
   * Returns the value of the '<em><b>Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' reference.
   * @see #setVariable(VarDeclaration)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getVariableAccess_Variable()
   * @model
   * @generated
   */
  VarDeclaration getVariable();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.VariableAccess#getVariable <em>Variable</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' reference.
   * @see #getVariable()
   * @generated
   */
  void setVariable(VarDeclaration value);

  /**
   * Returns the value of the '<em><b>Features</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.Feature}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Features</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getVariableAccess_Features()
   * @model containment="true"
   * @generated
   */
  EList<Feature> getFeatures();

  /**
   * Returns the value of the '<em><b>Default</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default</em>' containment reference.
   * @see #setDefault(Expression)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getVariableAccess_Default()
   * @model containment="true"
   * @generated
   */
  Expression getDefault();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.VariableAccess#getDefault <em>Default</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default</em>' containment reference.
   * @see #getDefault()
   * @generated
   */
  void setDefault(Expression value);

  /**
   * Returns the value of the '<em><b>Postfix Operator</b></em>' attribute.
   * The literals are from the enumeration {@link de.jevopi.mitra2.mitra.PPOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Postfix Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Postfix Operator</em>' attribute.
   * @see de.jevopi.mitra2.mitra.PPOperator
   * @see #setPostfixOperator(PPOperator)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getVariableAccess_PostfixOperator()
   * @model
   * @generated
   */
  PPOperator getPostfixOperator();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.VariableAccess#getPostfixOperator <em>Postfix Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Postfix Operator</em>' attribute.
   * @see de.jevopi.mitra2.mitra.PPOperator
   * @see #getPostfixOperator()
   * @generated
   */
  void setPostfixOperator(PPOperator value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (eIsProxy()) return super.toString();\nreturn ToString.valueOf(this);'"
   * @generated
   */
  String toString();

} // VariableAccess
