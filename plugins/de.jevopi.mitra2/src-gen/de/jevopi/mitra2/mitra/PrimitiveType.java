/**
 */
package de.jevopi.mitra2.mitra;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.PrimitiveType#getPrimitiveType <em>Primitive Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getPrimitiveType()
 * @model
 * @generated
 */
public interface PrimitiveType extends Type
{
  /**
   * Returns the value of the '<em><b>Primitive Type</b></em>' attribute.
   * The literals are from the enumeration {@link de.jevopi.mitra2.mitra.PrimitiveTypeSpec}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Primitive Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Primitive Type</em>' attribute.
   * @see de.jevopi.mitra2.mitra.PrimitiveTypeSpec
   * @see #setPrimitiveType(PrimitiveTypeSpec)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getPrimitiveType_PrimitiveType()
   * @model
   * @generated
   */
  PrimitiveTypeSpec getPrimitiveType();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.PrimitiveType#getPrimitiveType <em>Primitive Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Primitive Type</em>' attribute.
   * @see de.jevopi.mitra2.mitra.PrimitiveTypeSpec
   * @see #getPrimitiveType()
   * @generated
   */
  void setPrimitiveType(PrimitiveTypeSpec value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (eIsProxy()) return super.toString();\nreturn ToString.valueOf(this);'"
   * @generated
   */
  String toString();

} // PrimitiveType
