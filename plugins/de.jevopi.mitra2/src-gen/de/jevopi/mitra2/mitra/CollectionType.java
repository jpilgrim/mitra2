/**
 */
package de.jevopi.mitra2.mitra;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.CollectionType#getCollectionType <em>Collection Type</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.CollectionType#getTypePar <em>Type Par</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getCollectionType()
 * @model
 * @generated
 */
public interface CollectionType extends Type
{
  /**
   * Returns the value of the '<em><b>Collection Type</b></em>' attribute.
   * The literals are from the enumeration {@link de.jevopi.mitra2.mitra.CollectionTypeSpec}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Collection Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Collection Type</em>' attribute.
   * @see de.jevopi.mitra2.mitra.CollectionTypeSpec
   * @see #setCollectionType(CollectionTypeSpec)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getCollectionType_CollectionType()
   * @model
   * @generated
   */
  CollectionTypeSpec getCollectionType();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.CollectionType#getCollectionType <em>Collection Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Collection Type</em>' attribute.
   * @see de.jevopi.mitra2.mitra.CollectionTypeSpec
   * @see #getCollectionType()
   * @generated
   */
  void setCollectionType(CollectionTypeSpec value);

  /**
   * Returns the value of the '<em><b>Type Par</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Par</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Par</em>' containment reference.
   * @see #setTypePar(Type)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getCollectionType_TypePar()
   * @model containment="true"
   * @generated
   */
  Type getTypePar();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.CollectionType#getTypePar <em>Type Par</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Par</em>' containment reference.
   * @see #getTypePar()
   * @generated
   */
  void setTypePar(Type value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (eIsProxy()) return super.toString();\nreturn ToString.valueOf(this);'"
   * @generated
   */
  String toString();

} // CollectionType
