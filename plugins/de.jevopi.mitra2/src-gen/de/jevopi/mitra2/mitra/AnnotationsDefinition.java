/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotations Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.AnnotationsDefinition#getAnnotationDecls <em>Annotation Decls</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationsDefinition()
 * @model
 * @generated
 */
public interface AnnotationsDefinition extends EObject
{
  /**
   * Returns the value of the '<em><b>Annotation Decls</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.AnnotationDecl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotation Decls</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotation Decls</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationsDefinition_AnnotationDecls()
   * @model containment="true"
   * @generated
   */
  EList<AnnotationDecl> getAnnotationDecls();

} // AnnotationsDefinition
