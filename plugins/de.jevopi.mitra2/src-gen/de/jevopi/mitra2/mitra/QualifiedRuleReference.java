/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Rule Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.QualifiedRuleReference#getParameterReferences <em>Parameter References</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.QualifiedRuleReference#getReturnReferences <em>Return References</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getQualifiedRuleReference()
 * @model
 * @generated
 */
public interface QualifiedRuleReference extends RuleReference
{
  /**
   * Returns the value of the '<em><b>Parameter References</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.QualifiedParameterReference}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter References</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter References</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getQualifiedRuleReference_ParameterReferences()
   * @model containment="true"
   * @generated
   */
  EList<QualifiedParameterReference> getParameterReferences();

  /**
   * Returns the value of the '<em><b>Return References</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.QualifiedParameterReference}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Return References</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Return References</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getQualifiedRuleReference_ReturnReferences()
   * @model containment="true"
   * @generated
   */
  EList<QualifiedParameterReference> getReturnReferences();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (eIsProxy()) return super.toString();\nreturn ToString.valueOf(this);'"
   * @generated
   */
  String toString();

} // QualifiedRuleReference
