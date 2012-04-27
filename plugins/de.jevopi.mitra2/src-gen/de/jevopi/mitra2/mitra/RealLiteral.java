/**
 */
package de.jevopi.mitra2.mitra;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Real Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.RealLiteral#getFloatValue <em>Float Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getRealLiteral()
 * @model
 * @generated
 */
public interface RealLiteral extends Literal
{
  /**
   * Returns the value of the '<em><b>Float Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Float Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Float Value</em>' attribute.
   * @see #setFloatValue(String)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRealLiteral_FloatValue()
   * @model
   * @generated
   */
  String getFloatValue();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.RealLiteral#getFloatValue <em>Float Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Float Value</em>' attribute.
   * @see #getFloatValue()
   * @generated
   */
  void setFloatValue(String value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (eIsProxy()) return super.toString();\nreturn ToString.valueOf(this);'"
   * @generated
   */
  String toString();

} // RealLiteral
