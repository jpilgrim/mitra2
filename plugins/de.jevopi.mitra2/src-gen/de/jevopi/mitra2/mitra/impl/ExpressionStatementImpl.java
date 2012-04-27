/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.ExpressionStatement;
import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.StatementExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ExpressionStatementImpl#getStatementExpression <em>Statement Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionStatementImpl extends StatementImpl implements ExpressionStatement
{
  /**
   * The cached value of the '{@link #getStatementExpression() <em>Statement Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatementExpression()
   * @generated
   * @ordered
   */
  protected StatementExpression statementExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExpressionStatementImpl()
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
    return MitraPackage.Literals.EXPRESSION_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatementExpression getStatementExpression()
  {
    return statementExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStatementExpression(StatementExpression newStatementExpression, NotificationChain msgs)
  {
    StatementExpression oldStatementExpression = statementExpression;
    statementExpression = newStatementExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.EXPRESSION_STATEMENT__STATEMENT_EXPRESSION, oldStatementExpression, newStatementExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatementExpression(StatementExpression newStatementExpression)
  {
    if (newStatementExpression != statementExpression)
    {
      NotificationChain msgs = null;
      if (statementExpression != null)
        msgs = ((InternalEObject)statementExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.EXPRESSION_STATEMENT__STATEMENT_EXPRESSION, null, msgs);
      if (newStatementExpression != null)
        msgs = ((InternalEObject)newStatementExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.EXPRESSION_STATEMENT__STATEMENT_EXPRESSION, null, msgs);
      msgs = basicSetStatementExpression(newStatementExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.EXPRESSION_STATEMENT__STATEMENT_EXPRESSION, newStatementExpression, newStatementExpression));
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
      case MitraPackage.EXPRESSION_STATEMENT__STATEMENT_EXPRESSION:
        return basicSetStatementExpression(null, msgs);
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
      case MitraPackage.EXPRESSION_STATEMENT__STATEMENT_EXPRESSION:
        return getStatementExpression();
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
      case MitraPackage.EXPRESSION_STATEMENT__STATEMENT_EXPRESSION:
        setStatementExpression((StatementExpression)newValue);
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
      case MitraPackage.EXPRESSION_STATEMENT__STATEMENT_EXPRESSION:
        setStatementExpression((StatementExpression)null);
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
      case MitraPackage.EXPRESSION_STATEMENT__STATEMENT_EXPRESSION:
        return statementExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //ExpressionStatementImpl
