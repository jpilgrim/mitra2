/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.ReferenceType#getMetamodelDeclaration <em>Metamodel Declaration</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.ReferenceType#getEClassifier <em>EClassifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getReferenceType()
 * @model
 * @generated
 */
public interface ReferenceType extends Type
{
  /**
   * Returns the value of the '<em><b>Metamodel Declaration</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Metamodel Declaration</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metamodel Declaration</em>' reference.
   * @see #setMetamodelDeclaration(MetamodelDeclaration)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getReferenceType_MetamodelDeclaration()
   * @model
   * @generated
   */
  MetamodelDeclaration getMetamodelDeclaration();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.ReferenceType#getMetamodelDeclaration <em>Metamodel Declaration</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metamodel Declaration</em>' reference.
   * @see #getMetamodelDeclaration()
   * @generated
   */
  void setMetamodelDeclaration(MetamodelDeclaration value);

  /**
   * Returns the value of the '<em><b>EClassifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>EClassifier</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>EClassifier</em>' reference.
   * @see #setEClassifier(EClassifier)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getReferenceType_EClassifier()
   * @model
   * @generated
   */
  EClassifier getEClassifier();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.ReferenceType#getEClassifier <em>EClassifier</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>EClassifier</em>' reference.
   * @see #getEClassifier()
   * @generated
   */
  void setEClassifier(EClassifier value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (eIsProxy()) return super.toString();\nreturn ToString.valueOf(this);'"
   * @generated
   */
  String toString();

} // ReferenceType
