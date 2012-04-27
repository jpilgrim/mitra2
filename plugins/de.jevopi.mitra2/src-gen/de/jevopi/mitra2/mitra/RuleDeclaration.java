/**
 */
package de.jevopi.mitra2.mitra;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleDeclaration#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleDeclaration#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleDeclaration#getExec <em>Exec</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleDeclaration#isTraced <em>Traced</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleDeclaration#isStealth <em>Stealth</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleDeclaration#isVirtual <em>Virtual</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleDeclaration#isMulti <em>Multi</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleDeclaration#getFormalParameters <em>Formal Parameters</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleDeclaration#getReturnParameters <em>Return Parameters</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleDeclaration#getImplementedRules <em>Implemented Rules</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleDeclaration#getOverriddenRule <em>Overridden Rule</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleDeclaration#getExcludingRules <em>Excluding Rules</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleDeclaration#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleDeclaration#getJavaSpec <em>Java Spec</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.RuleDeclaration#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleDeclaration()
 * @model
 * @generated
 */
public interface RuleDeclaration extends EObject
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
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleDeclaration_Annotations()
   * @model containment="true"
   * @generated
   */
  EList<Annotation> getAnnotations();

  /**
   * Returns the value of the '<em><b>Visibility</b></em>' attribute.
   * The literals are from the enumeration {@link de.jevopi.mitra2.mitra.VisibilityModifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visibility</em>' attribute.
   * @see de.jevopi.mitra2.mitra.VisibilityModifier
   * @see #setVisibility(VisibilityModifier)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleDeclaration_Visibility()
   * @model
   * @generated
   */
  VisibilityModifier getVisibility();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getVisibility <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility</em>' attribute.
   * @see de.jevopi.mitra2.mitra.VisibilityModifier
   * @see #getVisibility()
   * @generated
   */
  void setVisibility(VisibilityModifier value);

  /**
   * Returns the value of the '<em><b>Exec</b></em>' attribute.
   * The literals are from the enumeration {@link de.jevopi.mitra2.mitra.ExecutionModifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exec</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exec</em>' attribute.
   * @see de.jevopi.mitra2.mitra.ExecutionModifier
   * @see #setExec(ExecutionModifier)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleDeclaration_Exec()
   * @model
   * @generated
   */
  ExecutionModifier getExec();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getExec <em>Exec</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exec</em>' attribute.
   * @see de.jevopi.mitra2.mitra.ExecutionModifier
   * @see #getExec()
   * @generated
   */
  void setExec(ExecutionModifier value);

  /**
   * Returns the value of the '<em><b>Traced</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Traced</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Traced</em>' attribute.
   * @see #setTraced(boolean)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleDeclaration_Traced()
   * @model
   * @generated
   */
  boolean isTraced();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.RuleDeclaration#isTraced <em>Traced</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Traced</em>' attribute.
   * @see #isTraced()
   * @generated
   */
  void setTraced(boolean value);

  /**
   * Returns the value of the '<em><b>Stealth</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stealth</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stealth</em>' attribute.
   * @see #setStealth(boolean)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleDeclaration_Stealth()
   * @model
   * @generated
   */
  boolean isStealth();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.RuleDeclaration#isStealth <em>Stealth</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stealth</em>' attribute.
   * @see #isStealth()
   * @generated
   */
  void setStealth(boolean value);

  /**
   * Returns the value of the '<em><b>Virtual</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Virtual</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Virtual</em>' attribute.
   * @see #setVirtual(boolean)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleDeclaration_Virtual()
   * @model
   * @generated
   */
  boolean isVirtual();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.RuleDeclaration#isVirtual <em>Virtual</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Virtual</em>' attribute.
   * @see #isVirtual()
   * @generated
   */
  void setVirtual(boolean value);

  /**
   * Returns the value of the '<em><b>Multi</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multi</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multi</em>' attribute.
   * @see #setMulti(boolean)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleDeclaration_Multi()
   * @model
   * @generated
   */
  boolean isMulti();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.RuleDeclaration#isMulti <em>Multi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multi</em>' attribute.
   * @see #isMulti()
   * @generated
   */
  void setMulti(boolean value);

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
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleDeclaration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Formal Parameters</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.FormalParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formal Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formal Parameters</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleDeclaration_FormalParameters()
   * @model containment="true"
   * @generated
   */
  EList<FormalParameter> getFormalParameters();

  /**
   * Returns the value of the '<em><b>Return Parameters</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.ReturnParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Return Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Return Parameters</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleDeclaration_ReturnParameters()
   * @model containment="true"
   * @generated
   */
  EList<ReturnParameter> getReturnParameters();

  /**
   * Returns the value of the '<em><b>Implemented Rules</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.SimpleRuleReference}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Implemented Rules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Implemented Rules</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleDeclaration_ImplementedRules()
   * @model containment="true"
   * @generated
   */
  EList<SimpleRuleReference> getImplementedRules();

  /**
   * Returns the value of the '<em><b>Overridden Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Overridden Rule</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Overridden Rule</em>' containment reference.
   * @see #setOverriddenRule(SimpleRuleReference)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleDeclaration_OverriddenRule()
   * @model containment="true"
   * @generated
   */
  SimpleRuleReference getOverriddenRule();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getOverriddenRule <em>Overridden Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Overridden Rule</em>' containment reference.
   * @see #getOverriddenRule()
   * @generated
   */
  void setOverriddenRule(SimpleRuleReference value);

  /**
   * Returns the value of the '<em><b>Excluding Rules</b></em>' containment reference list.
   * The list contents are of type {@link de.jevopi.mitra2.mitra.SimpleRuleReference}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Excluding Rules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Excluding Rules</em>' containment reference list.
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleDeclaration_ExcludingRules()
   * @model containment="true"
   * @generated
   */
  EList<SimpleRuleReference> getExcludingRules();

  /**
   * Returns the value of the '<em><b>Trigger</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trigger</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trigger</em>' containment reference.
   * @see #setTrigger(Trigger)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleDeclaration_Trigger()
   * @model containment="true"
   * @generated
   */
  Trigger getTrigger();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getTrigger <em>Trigger</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trigger</em>' containment reference.
   * @see #getTrigger()
   * @generated
   */
  void setTrigger(Trigger value);

  /**
   * Returns the value of the '<em><b>Java Spec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Java Spec</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Java Spec</em>' containment reference.
   * @see #setJavaSpec(JavaSpec)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleDeclaration_JavaSpec()
   * @model containment="true"
   * @generated
   */
  JavaSpec getJavaSpec();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getJavaSpec <em>Java Spec</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Java Spec</em>' containment reference.
   * @see #getJavaSpec()
   * @generated
   */
  void setJavaSpec(JavaSpec value);

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(Block)
   * @see de.jevopi.mitra2.mitra.MitraPackage#getRuleDeclaration_Body()
   * @model containment="true"
   * @generated
   */
  Block getBody();

  /**
   * Sets the value of the '{@link de.jevopi.mitra2.mitra.RuleDeclaration#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(Block value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (eIsProxy()) return super.toString();\nreturn ToString.valueOf(this);'"
   * @generated
   */
  String toString();

} // RuleDeclaration
