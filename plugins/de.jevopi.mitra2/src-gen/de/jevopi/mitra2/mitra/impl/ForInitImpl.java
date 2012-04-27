/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.ForInit;
import de.jevopi.mitra2.mitra.LocalVariableDeclaration;
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
 * An implementation of the model object '<em><b>For Init</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ForInitImpl#getStatementExpressions <em>Statement Expressions</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ForInitImpl#getVarDeclarations <em>Var Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForInitImpl extends MinimalEObjectImpl.Container implements ForInit
{
  /**
   * The cached value of the '{@link #getStatementExpressions() <em>Statement Expressions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatementExpressions()
   * @generated
   * @ordered
   */
  protected EList<StatementExpression> statementExpressions;

  /**
   * The cached value of the '{@link #getVarDeclarations() <em>Var Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVarDeclarations()
   * @generated
   * @ordered
   */
  protected EList<LocalVariableDeclaration> varDeclarations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ForInitImpl()
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
    return MitraPackage.Literals.FOR_INIT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StatementExpression> getStatementExpressions()
  {
    if (statementExpressions == null)
    {
      statementExpressions = new EObjectContainmentEList<StatementExpression>(StatementExpression.class, this, MitraPackage.FOR_INIT__STATEMENT_EXPRESSIONS);
    }
    return statementExpressions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LocalVariableDeclaration> getVarDeclarations()
  {
    if (varDeclarations == null)
    {
      varDeclarations = new EObjectContainmentEList<LocalVariableDeclaration>(LocalVariableDeclaration.class, this, MitraPackage.FOR_INIT__VAR_DECLARATIONS);
    }
    return varDeclarations;
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
      case MitraPackage.FOR_INIT__STATEMENT_EXPRESSIONS:
        return ((InternalEList<?>)getStatementExpressions()).basicRemove(otherEnd, msgs);
      case MitraPackage.FOR_INIT__VAR_DECLARATIONS:
        return ((InternalEList<?>)getVarDeclarations()).basicRemove(otherEnd, msgs);
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
      case MitraPackage.FOR_INIT__STATEMENT_EXPRESSIONS:
        return getStatementExpressions();
      case MitraPackage.FOR_INIT__VAR_DECLARATIONS:
        return getVarDeclarations();
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
      case MitraPackage.FOR_INIT__STATEMENT_EXPRESSIONS:
        getStatementExpressions().clear();
        getStatementExpressions().addAll((Collection<? extends StatementExpression>)newValue);
        return;
      case MitraPackage.FOR_INIT__VAR_DECLARATIONS:
        getVarDeclarations().clear();
        getVarDeclarations().addAll((Collection<? extends LocalVariableDeclaration>)newValue);
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
      case MitraPackage.FOR_INIT__STATEMENT_EXPRESSIONS:
        getStatementExpressions().clear();
        return;
      case MitraPackage.FOR_INIT__VAR_DECLARATIONS:
        getVarDeclarations().clear();
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
      case MitraPackage.FOR_INIT__STATEMENT_EXPRESSIONS:
        return statementExpressions != null && !statementExpressions.isEmpty();
      case MitraPackage.FOR_INIT__VAR_DECLARATIONS:
        return varDeclarations != null && !varDeclarations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ForInitImpl
