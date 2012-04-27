/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.Trigger#getTriggerRules <em>Trigger Rules</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.Trigger#getWith <em>With</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.Trigger#getWhen <em>When</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getTrigger()
 * @model
 * @generated
 */
public interface Trigger extends EObject
{
  /**
   * Returns the value of the '<em><b>Trigger Rules</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.QualifiedRuleReference}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trigger Rules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trigger Rules</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getTrigger_TriggerRules()
   * @model containment="true"
   * @generated
   */
  EList<QualifiedRuleReference> getTriggerRules();

  /**
   * Returns the value of the '<em><b>With</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>With</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>With</em>' containment reference.
   * @see #setWith(Block)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getTrigger_With()
   * @model containment="true"
   * @generated
   */
  Block getWith();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.Trigger#getWith <em>With</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>With</em>' containment reference.
   * @see #getWith()
   * @generated
   */
  void setWith(Block value);

  /**
   * Returns the value of the '<em><b>When</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>When</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>When</em>' containment reference.
   * @see #setWhen(Expression)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getTrigger_When()
   * @model containment="true"
   * @generated
   */
  Expression getWhen();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.Trigger#getWhen <em>When</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>When</em>' containment reference.
   * @see #getWhen()
   * @generated
   */
  void setWhen(Expression value);

} // Trigger
