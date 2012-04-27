/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.RealLiteral;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Real Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.RealLiteralImpl#getFloatValue <em>Float Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RealLiteralImpl extends LiteralImpl implements RealLiteral
{
  /**
   * The default value of the '{@link #getFloatValue() <em>Float Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFloatValue()
   * @generated
   * @ordered
   */
  protected static final String FLOAT_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFloatValue() <em>Float Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFloatValue()
   * @generated
   * @ordered
   */
  protected String floatValue = FLOAT_VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RealLiteralImpl()
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
    return MitraPackage.Literals.REAL_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFloatValue()
  {
    return floatValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFloatValue(String newFloatValue)
  {
    String oldFloatValue = floatValue;
    floatValue = newFloatValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.REAL_LITERAL__FLOAT_VALUE, oldFloatValue, floatValue));
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
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MitraPackage.REAL_LITERAL__FLOAT_VALUE:
        return getFloatValue();
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
      case MitraPackage.REAL_LITERAL__FLOAT_VALUE:
        setFloatValue((String)newValue);
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
      case MitraPackage.REAL_LITERAL__FLOAT_VALUE:
        setFloatValue(FLOAT_VALUE_EDEFAULT);
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
      case MitraPackage.REAL_LITERAL__FLOAT_VALUE:
        return FLOAT_VALUE_EDEFAULT == null ? floatValue != null : !FLOAT_VALUE_EDEFAULT.equals(floatValue);
    }
    return super.eIsSet(featureID);
  }

} //RealLiteralImpl
