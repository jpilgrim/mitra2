/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.Expression;
import de.jevopi.mitra2.mitra.Feature;
import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.PPOperator;
import de.jevopi.mitra2.mitra.VarDeclaration;
import de.jevopi.mitra2.mitra.VariableAccess;

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
 * An implementation of the model object '<em><b>Variable Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.VariableAccessImpl#getPrefixOperator <em>Prefix Operator</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.VariableAccessImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.VariableAccessImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.VariableAccessImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.VariableAccessImpl#getPostfixOperator <em>Postfix Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableAccessImpl extends StatementExpressionImpl implements VariableAccess
{
  /**
   * The default value of the '{@link #getPrefixOperator() <em>Prefix Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrefixOperator()
   * @generated
   * @ordered
   */
  protected static final PPOperator PREFIX_OPERATOR_EDEFAULT = PPOperator.NULL;

  /**
   * The cached value of the '{@link #getPrefixOperator() <em>Prefix Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrefixOperator()
   * @generated
   * @ordered
   */
  protected PPOperator prefixOperator = PREFIX_OPERATOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariable()
   * @generated
   * @ordered
   */
  protected VarDeclaration variable;

  /**
   * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatures()
   * @generated
   * @ordered
   */
  protected EList<Feature> features;

  /**
   * The cached value of the '{@link #getDefault() <em>Default</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefault()
   * @generated
   * @ordered
   */
  protected Expression default_;

  /**
   * The default value of the '{@link #getPostfixOperator() <em>Postfix Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostfixOperator()
   * @generated
   * @ordered
   */
  protected static final PPOperator POSTFIX_OPERATOR_EDEFAULT = PPOperator.NULL;

  /**
   * The cached value of the '{@link #getPostfixOperator() <em>Postfix Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostfixOperator()
   * @generated
   * @ordered
   */
  protected PPOperator postfixOperator = POSTFIX_OPERATOR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableAccessImpl()
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
    return MitraPackage.Literals.VARIABLE_ACCESS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PPOperator getPrefixOperator()
  {
    return prefixOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrefixOperator(PPOperator newPrefixOperator)
  {
    PPOperator oldPrefixOperator = prefixOperator;
    prefixOperator = newPrefixOperator == null ? PREFIX_OPERATOR_EDEFAULT : newPrefixOperator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.VARIABLE_ACCESS__PREFIX_OPERATOR, oldPrefixOperator, prefixOperator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarDeclaration getVariable()
  {
    if (variable != null && variable.eIsProxy())
    {
      InternalEObject oldVariable = (InternalEObject)variable;
      variable = (VarDeclaration)eResolveProxy(oldVariable);
      if (variable != oldVariable)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MitraPackage.VARIABLE_ACCESS__VARIABLE, oldVariable, variable));
      }
    }
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarDeclaration basicGetVariable()
  {
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariable(VarDeclaration newVariable)
  {
    VarDeclaration oldVariable = variable;
    variable = newVariable;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.VARIABLE_ACCESS__VARIABLE, oldVariable, variable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Feature> getFeatures()
  {
    if (features == null)
    {
      features = new EObjectContainmentEList<Feature>(Feature.class, this, MitraPackage.VARIABLE_ACCESS__FEATURES);
    }
    return features;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getDefault()
  {
    return default_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDefault(Expression newDefault, NotificationChain msgs)
  {
    Expression oldDefault = default_;
    default_ = newDefault;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.VARIABLE_ACCESS__DEFAULT, oldDefault, newDefault);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefault(Expression newDefault)
  {
    if (newDefault != default_)
    {
      NotificationChain msgs = null;
      if (default_ != null)
        msgs = ((InternalEObject)default_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.VARIABLE_ACCESS__DEFAULT, null, msgs);
      if (newDefault != null)
        msgs = ((InternalEObject)newDefault).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.VARIABLE_ACCESS__DEFAULT, null, msgs);
      msgs = basicSetDefault(newDefault, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.VARIABLE_ACCESS__DEFAULT, newDefault, newDefault));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PPOperator getPostfixOperator()
  {
    return postfixOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPostfixOperator(PPOperator newPostfixOperator)
  {
    PPOperator oldPostfixOperator = postfixOperator;
    postfixOperator = newPostfixOperator == null ? POSTFIX_OPERATOR_EDEFAULT : newPostfixOperator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.VARIABLE_ACCESS__POSTFIX_OPERATOR, oldPostfixOperator, postfixOperator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toString()
  {
    if (eIsProxy()) return super.toString();
    return ToString.valueOf(this);
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
      case MitraPackage.VARIABLE_ACCESS__FEATURES:
        return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
      case MitraPackage.VARIABLE_ACCESS__DEFAULT:
        return basicSetDefault(null, msgs);
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
      case MitraPackage.VARIABLE_ACCESS__PREFIX_OPERATOR:
        return getPrefixOperator();
      case MitraPackage.VARIABLE_ACCESS__VARIABLE:
        if (resolve) return getVariable();
        return basicGetVariable();
      case MitraPackage.VARIABLE_ACCESS__FEATURES:
        return getFeatures();
      case MitraPackage.VARIABLE_ACCESS__DEFAULT:
        return getDefault();
      case MitraPackage.VARIABLE_ACCESS__POSTFIX_OPERATOR:
        return getPostfixOperator();
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
      case MitraPackage.VARIABLE_ACCESS__PREFIX_OPERATOR:
        setPrefixOperator((PPOperator)newValue);
        return;
      case MitraPackage.VARIABLE_ACCESS__VARIABLE:
        setVariable((VarDeclaration)newValue);
        return;
      case MitraPackage.VARIABLE_ACCESS__FEATURES:
        getFeatures().clear();
        getFeatures().addAll((Collection<? extends Feature>)newValue);
        return;
      case MitraPackage.VARIABLE_ACCESS__DEFAULT:
        setDefault((Expression)newValue);
        return;
      case MitraPackage.VARIABLE_ACCESS__POSTFIX_OPERATOR:
        setPostfixOperator((PPOperator)newValue);
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
      case MitraPackage.VARIABLE_ACCESS__PREFIX_OPERATOR:
        setPrefixOperator(PREFIX_OPERATOR_EDEFAULT);
        return;
      case MitraPackage.VARIABLE_ACCESS__VARIABLE:
        setVariable((VarDeclaration)null);
        return;
      case MitraPackage.VARIABLE_ACCESS__FEATURES:
        getFeatures().clear();
        return;
      case MitraPackage.VARIABLE_ACCESS__DEFAULT:
        setDefault((Expression)null);
        return;
      case MitraPackage.VARIABLE_ACCESS__POSTFIX_OPERATOR:
        setPostfixOperator(POSTFIX_OPERATOR_EDEFAULT);
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
      case MitraPackage.VARIABLE_ACCESS__PREFIX_OPERATOR:
        return prefixOperator != PREFIX_OPERATOR_EDEFAULT;
      case MitraPackage.VARIABLE_ACCESS__VARIABLE:
        return variable != null;
      case MitraPackage.VARIABLE_ACCESS__FEATURES:
        return features != null && !features.isEmpty();
      case MitraPackage.VARIABLE_ACCESS__DEFAULT:
        return default_ != null;
      case MitraPackage.VARIABLE_ACCESS__POSTFIX_OPERATOR:
        return postfixOperator != POSTFIX_OPERATOR_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

} //VariableAccessImpl
