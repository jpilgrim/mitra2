/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.Module#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.Module#getName <em>Name</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.Module#getImports <em>Imports</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.Module#getMetamodelDeclarations <em>Metamodel Declarations</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.Module#getAnnotationDefinitions <em>Annotation Definitions</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.Module#getRuleDeclarations <em>Rule Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getModule()
 * @model
 * @generated
 */
public interface Module extends EObject
{
  /**
   * Returns the value of the '<em><b>Package Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Package Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Package Name</em>' attribute.
   * @see #setPackageName(String)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getModule_PackageName()
   * @model
   * @generated
   */
  String getPackageName();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.Module#getPackageName <em>Package Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package Name</em>' attribute.
   * @see #getPackageName()
   * @generated
   */
  void setPackageName(String value);

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
   * @see de.jevopi.mitra2.mitra.MitraPackage#getModule_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.Module#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.ModuleReference}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getModule_Imports()
   * @model containment="true"
   * @generated
   */
  EList<ModuleReference> getImports();

  /**
   * Returns the value of the '<em><b>Metamodel Declarations</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.MetamodelDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Metamodel Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metamodel Declarations</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getModule_MetamodelDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<MetamodelDeclaration> getMetamodelDeclarations();

  /**
   * Returns the value of the '<em><b>Annotation Definitions</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.AnnotationsDefinition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotation Definitions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotation Definitions</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getModule_AnnotationDefinitions()
   * @model containment="true"
   * @generated
   */
  EList<AnnotationsDefinition> getAnnotationDefinitions();

  /**
   * Returns the value of the '<em><b>Rule Declarations</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.RuleDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rule Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rule Declarations</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getModule_RuleDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<RuleDeclaration> getRuleDeclarations();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (eIsProxy()) return super.toString();\nreturn ToString.valueOf(this);'"
   * @generated
   */
  String toString();

} // Module
