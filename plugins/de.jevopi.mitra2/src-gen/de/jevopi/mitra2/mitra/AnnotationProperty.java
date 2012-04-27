/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.AnnotationProperty#getDecl <em>Decl</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.AnnotationProperty#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationProperty()
 * @model
 * @generated
 */
public interface AnnotationProperty extends EObject
{
  /**
   * Returns the value of the '<em><b>Decl</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Decl</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decl</em>' reference.
   * @see #setDecl(AnnotationPropertyDecl)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationProperty_Decl()
   * @model
   * @generated
   */
  AnnotationPropertyDecl getDecl();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.AnnotationProperty#getDecl <em>Decl</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Decl</em>' reference.
   * @see #getDecl()
   * @generated
   */
  void setDecl(AnnotationPropertyDecl value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Literal)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationProperty_Value()
   * @model containment="true"
   * @generated
   */
  Literal getValue();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.AnnotationProperty#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Literal value);

} // AnnotationProperty
