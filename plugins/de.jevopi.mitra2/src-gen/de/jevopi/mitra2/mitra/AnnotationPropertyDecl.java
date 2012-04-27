/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation Property Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.AnnotationPropertyDecl#getType <em>Type</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.AnnotationPropertyDecl#getName <em>Name</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.AnnotationPropertyDecl#isRequired <em>Required</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.AnnotationPropertyDecl#getDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationPropertyDecl()
 * @model
 * @generated
 */
public interface AnnotationPropertyDecl extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(PrimitiveType)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationPropertyDecl_Type()
   * @model containment="true"
   * @generated
   */
  PrimitiveType getType();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.AnnotationPropertyDecl#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(PrimitiveType value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationPropertyDecl_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.AnnotationPropertyDecl#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Required</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Required</em>' attribute.
   * @see #setRequired(boolean)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationPropertyDecl_Required()
   * @model
   * @generated
   */
  boolean isRequired();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.AnnotationPropertyDecl#isRequired <em>Required</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Required</em>' attribute.
   * @see #isRequired()
   * @generated
   */
  void setRequired(boolean value);

  /**
   * Returns the value of the '<em><b>Default</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default</em>' containment reference.
   * @see #setDefault(Literal)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationPropertyDecl_Default()
   * @model containment="true"
   * @generated
   */
  Literal getDefault();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.AnnotationPropertyDecl#getDefault <em>Default</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default</em>' containment reference.
   * @see #getDefault()
   * @generated
   */
  void setDefault(Literal value);

} // AnnotationPropertyDecl
