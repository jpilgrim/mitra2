/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.Block;
import de.jevopi.mitra2.mitra.Catch;
import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.TryStatement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Try Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.TryStatementImpl#getTryBlock <em>Try Block</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.TryStatementImpl#getCatches <em>Catches</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.TryStatementImpl#getFinallyBlock <em>Finally Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TryStatementImpl extends StatementImpl implements TryStatement
{
  /**
   * The cached value of the '{@link #getTryBlock() <em>Try Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTryBlock()
   * @generated
   * @ordered
   */
  protected Block tryBlock;

  /**
   * The cached value of the '{@link #getCatches() <em>Catches</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCatches()
   * @generated
   * @ordered
   */
  protected EList<Catch> catches;

  /**
   * The cached value of the '{@link #getFinallyBlock() <em>Finally Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFinallyBlock()
   * @generated
   * @ordered
   */
  protected Block finallyBlock;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TryStatementImpl()
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
    return MitraPackage.Literals.TRY_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block getTryBlock()
  {
    return tryBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTryBlock(Block newTryBlock, NotificationChain msgs)
  {
    Block oldTryBlock = tryBlock;
    tryBlock = newTryBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.TRY_STATEMENT__TRY_BLOCK, oldTryBlock, newTryBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTryBlock(Block newTryBlock)
  {
    if (newTryBlock != tryBlock)
    {
      NotificationChain msgs = null;
      if (tryBlock != null)
        msgs = ((InternalEObject)tryBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.TRY_STATEMENT__TRY_BLOCK, null, msgs);
      if (newTryBlock != null)
        msgs = ((InternalEObject)newTryBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.TRY_STATEMENT__TRY_BLOCK, null, msgs);
      msgs = basicSetTryBlock(newTryBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.TRY_STATEMENT__TRY_BLOCK, newTryBlock, newTryBlock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Catch> getCatches()
  {
    if (catches == null)
    {
      catches = new EObjectContainmentEList<Catch>(Catch.class, this, MitraPackage.TRY_STATEMENT__CATCHES);
    }
    return catches;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block getFinallyBlock()
  {
    return finallyBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFinallyBlock(Block newFinallyBlock, NotificationChain msgs)
  {
    Block oldFinallyBlock = finallyBlock;
    finallyBlock = newFinallyBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.TRY_STATEMENT__FINALLY_BLOCK, oldFinallyBlock, newFinallyBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFinallyBlock(Block newFinallyBlock)
  {
    if (newFinallyBlock != finallyBlock)
    {
      NotificationChain msgs = null;
      if (finallyBlock != null)
        msgs = ((InternalEObject)finallyBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.TRY_STATEMENT__FINALLY_BLOCK, null, msgs);
      if (newFinallyBlock != null)
        msgs = ((InternalEObject)newFinallyBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.TRY_STATEMENT__FINALLY_BLOCK, null, msgs);
      msgs = basicSetFinallyBlock(newFinallyBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.TRY_STATEMENT__FINALLY_BLOCK, newFinallyBlock, newFinallyBlock));
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
      case MitraPackage.TRY_STATEMENT__TRY_BLOCK:
        return basicSetTryBlock(null, msgs);
      case MitraPackage.TRY_STATEMENT__CATCHES:
        return ((InternalEList<?>)getCatches()).basicRemove(otherEnd, msgs);
      case MitraPackage.TRY_STATEMENT__FINALLY_BLOCK:
        return basicSetFinallyBlock(null, msgs);
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
      case MitraPackage.TRY_STATEMENT__TRY_BLOCK:
        return getTryBlock();
      case MitraPackage.TRY_STATEMENT__CATCHES:
        return getCatches();
      case MitraPackage.TRY_STATEMENT__FINALLY_BLOCK:
        return getFinallyBlock();
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
      case MitraPackage.TRY_STATEMENT__TRY_BLOCK:
        setTryBlock((Block)newValue);
        return;
      case MitraPackage.TRY_STATEMENT__CATCHES:
        getCatches().clear();
        getCatches().addAll((Collection<? extends Catch>)newValue);
        return;
      case MitraPackage.TRY_STATEMENT__FINALLY_BLOCK:
        setFinallyBlock((Block)newValue);
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
      case MitraPackage.TRY_STATEMENT__TRY_BLOCK:
        setTryBlock((Block)null);
        return;
      case MitraPackage.TRY_STATEMENT__CATCHES:
        getCatches().clear();
        return;
      case MitraPackage.TRY_STATEMENT__FINALLY_BLOCK:
        setFinallyBlock((Block)null);
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
      case MitraPackage.TRY_STATEMENT__TRY_BLOCK:
        return tryBlock != null;
      case MitraPackage.TRY_STATEMENT__CATCHES:
        return catches != null && !catches.isEmpty();
      case MitraPackage.TRY_STATEMENT__FINALLY_BLOCK:
        return finallyBlock != null;
    }
    return super.eIsSet(featureID);
  }

} //TryStatementImpl
