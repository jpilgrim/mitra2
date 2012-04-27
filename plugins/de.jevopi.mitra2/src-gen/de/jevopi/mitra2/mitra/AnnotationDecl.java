/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.AnnotationDecl#getName <em>Name</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.AnnotationDecl#getTargets <em>Targets</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.AnnotationDecl#getValuetype <em>Valuetype</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.AnnotationDecl#isMany <em>Many</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.AnnotationDecl#isRequired <em>Required</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.AnnotationDecl#getDefault <em>Default</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.AnnotationDecl#getPropertyDecls <em>Property Decls</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationDecl()
 * @model
 * @generated
 */
public interface AnnotationDecl extends EObject
{
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
   * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationDecl_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.AnnotationDecl#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Targets</b></em>' attribute list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.AnnotationTargetSpec}.
   * The literals are from the enumeration {@link de.jevopi.mitra2.mitra.AnnotationTargetSpec}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Targets</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Targets</em>' attribute list.
   * @see de.jevopi.mitra2.mitra.AnnotationTargetSpec
   * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationDecl_Targets()
   * @model unique="false"
   * @generated
   */
  EList<AnnotationTargetSpec> getTargets();

  /**
   * Returns the value of the '<em><b>Valuetype</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Valuetype</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Valuetype</em>' containment reference.
   * @see #setValuetype(PrimitiveType)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationDecl_Valuetype()
   * @model containment="true"
   * @generated
   */
  PrimitiveType getValuetype();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.AnnotationDecl#getValuetype <em>Valuetype</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Valuetype</em>' containment reference.
   * @see #getValuetype()
   * @generated
   */
  void setValuetype(PrimitiveType value);

  /**
   * Returns the value of the '<em><b>Many</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Many</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Many</em>' attribute.
   * @see #setMany(boolean)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationDecl_Many()
   * @model
   * @generated
   */
  boolean isMany();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.AnnotationDecl#isMany <em>Many</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Many</em>' attribute.
   * @see #isMany()
   * @generated
   */
  void setMany(boolean value);

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
   * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationDecl_Required()
   * @model
   * @generated
   */
  boolean isRequired();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.AnnotationDecl#isRequired <em>Required</em>}' attribute.
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
   * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationDecl_Default()
   * @model containment="true"
   * @generated
   */
  Literal getDefault();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.AnnotationDecl#getDefault <em>Default</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default</em>' containment reference.
   * @see #getDefault()
   * @generated
   */
  void setDefault(Literal value);

  /**
   * Returns the value of the '<em><b>Property Decls</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.AnnotationPropertyDecl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Decls</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Decls</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getAnnotationDecl_PropertyDecls()
   * @model containment="true"
   * @generated
   */
  EList<AnnotationPropertyDecl> getPropertyDecls();

} // AnnotationDecl
