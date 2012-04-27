/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.Block;
import de.jevopi.mitra2.mitra.Expression;
import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.QualifiedRuleReference;
import de.jevopi.mitra2.mitra.Trigger;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.TriggerImpl#getTriggerRules <em>Trigger Rules</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.TriggerImpl#getWith <em>With</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.TriggerImpl#getWhen <em>When</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TriggerImpl extends MinimalEObjectImpl.Container implements Trigger
{
  /**
   * The cached value of the '{@link #getTriggerRules() <em>Trigger Rules</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTriggerRules()
   * @generated
   * @ordered
   */
  protected EList<QualifiedRuleReference> triggerRules;

  /**
   * The cached value of the '{@link #getWith() <em>With</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWith()
   * @generated
   * @ordered
   */
  protected Block with;

  /**
   * The cached value of the '{@link #getWhen() <em>When</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWhen()
   * @generated
   * @ordered
   */
  protected Expression when;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TriggerImpl()
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
    return MitraPackage.Literals.TRIGGER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<QualifiedRuleReference> getTriggerRules()
  {
    if (triggerRules == null)
    {
      triggerRules = new EObjectContainmentEList<QualifiedRuleReference>(QualifiedRuleReference.class, this, MitraPackage.TRIGGER__TRIGGER_RULES);
    }
    return triggerRules;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block getWith()
  {
    return with;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetWith(Block newWith, NotificationChain msgs)
  {
    Block oldWith = with;
    with = newWith;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.TRIGGER__WITH, oldWith, newWith);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWith(Block newWith)
  {
    if (newWith != with)
    {
      NotificationChain msgs = null;
      if (with != null)
        msgs = ((InternalEObject)with).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.TRIGGER__WITH, null, msgs);
      if (newWith != null)
        msgs = ((InternalEObject)newWith).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.TRIGGER__WITH, null, msgs);
      msgs = basicSetWith(newWith, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.TRIGGER__WITH, newWith, newWith));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getWhen()
  {
    return when;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetWhen(Expression newWhen, NotificationChain msgs)
  {
    Expression oldWhen = when;
    when = newWhen;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.TRIGGER__WHEN, oldWhen, newWhen);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWhen(Expression newWhen)
  {
    if (newWhen != when)
    {
      NotificationChain msgs = null;
      if (when != null)
        msgs = ((InternalEObject)when).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.TRIGGER__WHEN, null, msgs);
      if (newWhen != null)
        msgs = ((InternalEObject)newWhen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.TRIGGER__WHEN, null, msgs);
      msgs = basicSetWhen(newWhen, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.TRIGGER__WHEN, newWhen, newWhen));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MitraPackage.TRIGGER__TRIGGER_RULES:
        return ((InternalEList<?>)getTriggerRules()).basicRemove(otherEnd, msgs);
      case MitraPackage.TRIGGER__WITH:
        return basicSetWith(null, msgs);
      case MitraPackage.TRIGGER__WHEN:
        return basicSetWhen(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case MitraPackage.TRIGGER__TRIGGER_RULES:
        return getTriggerRules();
      case MitraPackage.TRIGGER__WITH:
        return getWith();
      case MitraPackage.TRIGGER__WHEN:
        return getWhen();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MitraPackage.TRIGGER__TRIGGER_RULES:
        getTriggerRules().clear();
        getTriggerRules().addAll((Collection<? extends QualifiedRuleReference>)newValue);
        return;
      case MitraPackage.TRIGGER__WITH:
        setWith((Block)newValue);
        return;
      case MitraPackage.TRIGGER__WHEN:
        setWhen((Expression)newValue);
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
      case MitraPackage.TRIGGER__TRIGGER_RULES:
        getTriggerRules().clear();
        return;
      case MitraPackage.TRIGGER__WITH:
        setWith((Block)null);
        return;
      case MitraPackage.TRIGGER__WHEN:
        setWhen((Expression)null);
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
      case MitraPackage.TRIGGER__TRIGGER_RULES:
        return triggerRules != null && !triggerRules.isEmpty();
      case MitraPackage.TRIGGER__WITH:
        return with != null;
      case MitraPackage.TRIGGER__WHEN:
        return when != null;
    }
    return super.eIsSet(featureID);
  }

} //TriggerImpl
