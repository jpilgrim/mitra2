/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleReference#getRuleDeclaration <em>Rule Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleReference()
 * @model
 * @generated
 */
public interface RuleReference extends EObject
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
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleReference_RuleDeclaration()
   * @model
   * @generated
   */
  RuleDeclaration getRuleDeclaration();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.RuleReference#getRuleDeclaration <em>Rule Declaration</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rule Declaration</em>' reference.
   * @see #getRuleDeclaration()
   * @generated
   */
  void setRuleDeclaration(RuleDeclaration value);

} // RuleReference
