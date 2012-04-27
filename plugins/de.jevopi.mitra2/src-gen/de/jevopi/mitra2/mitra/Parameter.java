/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.Parameter#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.Parameter#getModifier <em>Modifier</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.Parameter#getVardecl <em>Vardecl</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getParameter()
 * @model
 * @generated
 */
public interface Parameter extends EObject
{
  /**
   * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.Annotation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotations</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getParameter_Annotations()
   * @model containment="true"
   * @generated
   */
  EList<Annotation> getAnnotations();

  /**
   * Returns the value of the '<em><b>Modifier</b></em>' attribute.
   * The literals are from the enumeration {@link de.jevopi.mitra2.mitra.ParameterModifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Modifier</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modifier</em>' attribute.
   * @see de.jevopi.mitra2.mitra.ParameterModifier
   * @see #setModifier(ParameterModifier)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getParameter_Modifier()
   * @model
   * @generated
   */
  ParameterModifier getModifier();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.Parameter#getModifier <em>Modifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modifier</em>' attribute.
   * @see de.jevopi.mitra2.mitra.ParameterModifier
   * @see #getModifier()
   * @generated
   */
  void setModifier(ParameterModifier value);

  /**
   * Returns the value of the '<em><b>Vardecl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vardecl</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vardecl</em>' containment reference.
   * @see #setVardecl(TypedVarDeclaration)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getParameter_Vardecl()
   * @model containment="true"
   * @generated
   */
  TypedVarDeclaration getVardecl();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.Parameter#getVardecl <em>Vardecl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Vardecl</em>' containment reference.
   * @see #getVardecl()
   * @generated
   */
  void setVardecl(TypedVarDeclaration value);

} // Parameter
