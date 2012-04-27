/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.Annotation#getDecl <em>Decl</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.Annotation#getValues <em>Values</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.Annotation#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation extends EObject
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
   * @see #setDecl(AnnotationDecl)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotation_Decl()
   * @model
   * @generated
   */
  AnnotationDecl getDecl();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.Annotation#getDecl <em>Decl</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Decl</em>' reference.
   * @see #getDecl()
   * @generated
   */
  void setDecl(AnnotationDecl value);

  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.Literal}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotation_Values()
   * @model containment="true"
   * @generated
   */
  EList<Literal> getValues();

  /**
   * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.AnnotationProperty}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotation_Properties()
   * @model containment="true"
   * @generated
   */
  EList<AnnotationProperty> getProperties();

} // Annotation
