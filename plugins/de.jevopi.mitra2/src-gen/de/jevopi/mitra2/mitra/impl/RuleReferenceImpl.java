/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.RuleDeclaration;
import de.jevopi.mitra2.mitra.RuleReference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.RuleReferenceImpl#getRuleDeclaration <em>Rule Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleReferenceImpl extends MinimalEObjectImpl.Container implements RuleReference
{
  /**
   * The cached value of the '{@link #getRuleDeclaration() <em>Rule Declaration</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRuleDeclaration()
   * @generated
   * @ordered
   */
  protected RuleDeclaration ruleDeclaration;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RuleReferenceImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MitraPackage.Literals.RULE_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleDeclaration getRuleDeclaration()
  {
    if (ruleDeclaration != null && ruleDeclaration.eIsProxy())
    {
      InternalEObject oldRuleDeclaration = (InternalEObject)ruleDeclaration;
      ruleDeclaration = (RuleDeclaration)eResolveProxy(oldRuleDeclaration);
      if (ruleDeclaration != oldRuleDeclaration)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MitraPackage.RULE_REFERENCE__RULE_DECLARATION, oldRuleDeclaration, ruleDeclaration));
      }
    }
    return ruleDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleDeclaration basicGetRuleDeclaration()
  {
    return ruleDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRuleDeclaration(RuleDeclaration newRuleDeclaration)
  {
    RuleDeclaration oldRuleDeclaration = ruleDeclaration;
    ruleDeclaration = newRuleDeclaration;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.RULE_REFERENCE__RULE_DECLARATION, oldRuleDeclaration, ruleDeclaration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MitraPackage.RULE_REFERENCE__RULE_DECLARATION:
        if (resolve) return getRuleDeclaration();
        return basicGetRuleDeclaration();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MitraPackage.RULE_REFERENCE__RULE_DECLARATION:
        setRuleDeclaration((RuleDeclaration)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MitraPackage.RULE_REFERENCE__RULE_DECLARATION:
        setRuleDeclaration((RuleDeclaration)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MitraPackage.RULE_REFERENCE__RULE_DECLARATION:
        return ruleDeclaration != null;
    }
    return super.eIsSet(featureID);
  }

} //RuleReferenceImpl
