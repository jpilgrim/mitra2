/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.Expression;
import de.jevopi.mitra2.mitra.ForInit;
import de.jevopi.mitra2.mitra.ForStatement;
import de.jevopi.mitra2.mitra.ForUpdate;
import de.jevopi.mitra2.mitra.LoopVariable;
import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.Statement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ForStatementImpl#getLoopVariable <em>Loop Variable</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ForStatementImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ForStatementImpl#getForInit <em>For Init</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ForStatementImpl#getForUpdate <em>For Update</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ForStatementImpl#getStatement <em>Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForStatementImpl extends StatementImpl implements ForStatement
{
  /**
   * The cached value of the '{@link #getLoopVariable() <em>Loop Variable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoopVariable()
   * @generated
   * @ordered
   */
  protected LoopVariable loopVariable;

  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected Expression expression;

  /**
   * The cached value of the '{@link #getForInit() <em>For Init</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getForInit()
   * @generated
   * @ordered
   */
  protected ForInit forInit;

  /**
   * The cached value of the '{@link #getForUpdate() <em>For Update</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getForUpdate()
   * @generated
   * @ordered
   */
  protected ForUpdate forUpdate;

  /**
   * The cached value of the '{@link #getStatement() <em>Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatement()
   * @generated
   * @ordered
   */
  protected Statement statement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ForStatementImpl()
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
    return MitraPackage.Literals.FOR_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoopVariable getLoopVariable()
  {
    return loopVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLoopVariable(LoopVariable newLoopVariable, NotificationChain msgs)
  {
    LoopVariable oldLoopVariable = loopVariable;
    loopVariable = newLoopVariable;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.FOR_STATEMENT__LOOP_VARIABLE, oldLoopVariable, newLoopVariable);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLoopVariable(LoopVariable newLoopVariable)
  {
    if (newLoopVariable != loopVariable)
    {
      NotificationChain msgs = null;
      if (loopVariable != null)
        msgs = ((InternalEObject)loopVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.FOR_STATEMENT__LOOP_VARIABLE, null, msgs);
      if (newLoopVariable != null)
        msgs = ((InternalEObject)newLoopVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.FOR_STATEMENT__LOOP_VARIABLE, null, msgs);
      msgs = basicSetLoopVariable(newLoopVariable, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.FOR_STATEMENT__LOOP_VARIABLE, newLoopVariable, newLoopVariable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs)
  {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.FOR_STATEMENT__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(Expression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.FOR_STATEMENT__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.FOR_STATEMENT__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.FOR_STATEMENT__EXPRESSION, newExpression, newExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForInit getForInit()
  {
    return forInit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetForInit(ForInit newForInit, NotificationChain msgs)
  {
    ForInit oldForInit = forInit;
    forInit = newForInit;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.FOR_STATEMENT__FOR_INIT, oldForInit, newForInit);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setForInit(ForInit newForInit)
  {
    if (newForInit != forInit)
    {
      NotificationChain msgs = null;
      if (forInit != null)
        msgs = ((InternalEObject)forInit).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.FOR_STATEMENT__FOR_INIT, null, msgs);
      if (newForInit != null)
        msgs = ((InternalEObject)newForInit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.FOR_STATEMENT__FOR_INIT, null, msgs);
      msgs = basicSetForInit(newForInit, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.FOR_STATEMENT__FOR_INIT, newForInit, newForInit));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForUpdate getForUpdate()
  {
    return forUpdate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetForUpdate(ForUpdate newForUpdate, NotificationChain msgs)
  {
    ForUpdate oldForUpdate = forUpdate;
    forUpdate = newForUpdate;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.FOR_STATEMENT__FOR_UPDATE, oldForUpdate, newForUpdate);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setForUpdate(ForUpdate newForUpdate)
  {
    if (newForUpdate != forUpdate)
    {
      NotificationChain msgs = null;
      if (forUpdate != null)
        msgs = ((InternalEObject)forUpdate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.FOR_STATEMENT__FOR_UPDATE, null, msgs);
      if (newForUpdate != null)
        msgs = ((InternalEObject)newForUpdate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.FOR_STATEMENT__FOR_UPDATE, null, msgs);
      msgs = basicSetForUpdate(newForUpdate, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.FOR_STATEMENT__FOR_UPDATE, newForUpdate, newForUpdate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement getStatement()
  {
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStatement(Statement newStatement, NotificationChain msgs)
  {
    Statement oldStatement = statement;
    statement = newStatement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.FOR_STATEMENT__STATEMENT, oldStatement, newStatement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatement(Statement newStatement)
  {
    if (newStatement != statement)
    {
      NotificationChain msgs = null;
      if (statement != null)
        msgs = ((InternalEObject)statement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.FOR_STATEMENT__STATEMENT, null, msgs);
      if (newStatement != null)
        msgs = ((InternalEObject)newStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.FOR_STATEMENT__STATEMENT, null, msgs);
      msgs = basicSetStatement(newStatement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.FOR_STATEMENT__STATEMENT, newStatement, newStatement));
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
      case MitraPackage.FOR_STATEMENT__LOOP_VARIABLE:
        return basicSetLoopVariable(null, msgs);
      case MitraPackage.FOR_STATEMENT__EXPRESSION:
        return basicSetExpression(null, msgs);
      case MitraPackage.FOR_STATEMENT__FOR_INIT:
        return basicSetForInit(null, msgs);
      case MitraPackage.FOR_STATEMENT__FOR_UPDATE:
        return basicSetForUpdate(null, msgs);
      case MitraPackage.FOR_STATEMENT__STATEMENT:
        return basicSetStatement(null, msgs);
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
      case MitraPackage.FOR_STATEMENT__LOOP_VARIABLE:
        return getLoopVariable();
      case MitraPackage.FOR_STATEMENT__EXPRESSION:
        return getExpression();
      case MitraPackage.FOR_STATEMENT__FOR_INIT:
        return getForInit();
      case MitraPackage.FOR_STATEMENT__FOR_UPDATE:
        return getForUpdate();
      case MitraPackage.FOR_STATEMENT__STATEMENT:
        return getStatement();
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
      case MitraPackage.FOR_STATEMENT__LOOP_VARIABLE:
        setLoopVariable((LoopVariable)newValue);
        return;
      case MitraPackage.FOR_STATEMENT__EXPRESSION:
        setExpression((Expression)newValue);
        return;
      case MitraPackage.FOR_STATEMENT__FOR_INIT:
        setForInit((ForInit)newValue);
        return;
      case MitraPackage.FOR_STATEMENT__FOR_UPDATE:
        setForUpdate((ForUpdate)newValue);
        return;
      case MitraPackage.FOR_STATEMENT__STATEMENT:
        setStatement((Statement)newValue);
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
      case MitraPackage.FOR_STATEMENT__LOOP_VARIABLE:
        setLoopVariable((LoopVariable)null);
        return;
      case MitraPackage.FOR_STATEMENT__EXPRESSION:
        setExpression((Expression)null);
        return;
      case MitraPackage.FOR_STATEMENT__FOR_INIT:
        setForInit((ForInit)null);
        return;
      case MitraPackage.FOR_STATEMENT__FOR_UPDATE:
        setForUpdate((ForUpdate)null);
        return;
      case MitraPackage.FOR_STATEMENT__STATEMENT:
        setStatement((Statement)null);
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
      case MitraPackage.FOR_STATEMENT__LOOP_VARIABLE:
        return loopVariable != null;
      case MitraPackage.FOR_STATEMENT__EXPRESSION:
        return expression != null;
      case MitraPackage.FOR_STATEMENT__FOR_INIT:
        return forInit != null;
      case MitraPackage.FOR_STATEMENT__FOR_UPDATE:
        return forUpdate != null;
      case MitraPackage.FOR_STATEMENT__STATEMENT:
        return statement != null;
    }
    return super.eIsSet(featureID);
  }

} //ForStatementImpl
