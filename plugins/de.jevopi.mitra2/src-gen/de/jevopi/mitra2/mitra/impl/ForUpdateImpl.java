/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.ForUpdate;
import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.StatementExpression;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Update</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ForUpdateImpl#getStatementExpression <em>Statement Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForUpdateImpl extends MinimalEObjectImpl.Container implements ForUpdate
{
  /**
   * The cached value of the '{@link #getStatementExpression() <em>Statement Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatementExpression()
   * @generated
   * @ordered
   */
  protected EList<StatementExpression> statementExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ForUpdateImpl()
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
    return MitraPackage.Literals.FOR_UPDATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StatementExpression> getStatementExpression()
  {
    if (statementExpression == null)
    {
      statementExpression = new EObjectContainmentEList<StatementExpression>(StatementExpression.class, this, MitraPackage.FOR_UPDATE__STATEMENT_EXPRESSION);
    }
    return statementExpression;
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
      case MitraPackage.FOR_UPDATE__STATEMENT_EXPRESSION:
        return ((InternalEList<?>)getStatementExpression()).basicRemove(otherEnd, msgs);
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
      case MitraPackage.FOR_UPDATE__STATEMENT_EXPRESSION:
        return getStatementExpression();
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
      case MitraPackage.FOR_UPDATE__STATEMENT_EXPRESSION:
        getStatementExpression().clear();
        getStatementExpression().addAll((Collection<? extends StatementExpression>)newValue);
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
      case MitraPackage.FOR_UPDATE__STATEMENT_EXPRESSION:
        getStatementExpression().clear();
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
      case MitraPackage.FOR_UPDATE__STATEMENT_EXPRESSION:
        return statementExpression != null && !statementExpression.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ForUpdateImpl
