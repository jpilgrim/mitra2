/**
 */
package de.jevopi.mitra2.mitra;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Parameter Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.QualifiedParameterReference#getVardecl <em>Vardecl</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getQualifiedParameterReference()
 * @model
 * @generated
 */
public interface QualifiedParameterReference extends ParameterReference
{
  /**
   * Returns the value of the '<em><b>Vardecl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vardecl</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vardecl</em>' containment reference.
   * @see #setVardecl(TypedVarDeclaration)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getQualifiedParameterReference_Vardecl()
   * @model containment="true"
   * @generated
   */
  TypedVarDeclaration getVardecl();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.QualifiedParameterReference#getVardecl <em>Vardecl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Vardecl</em>' containment reference.
   * @see #getVardecl()
   * @generated
   */
  void setVardecl(TypedVarDeclaration value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (eIsProxy()) return super.toString();\nreturn ToString.valueOf(this);'"
   * @generated
   */
  String toString();

} // QualifiedParameterReference
