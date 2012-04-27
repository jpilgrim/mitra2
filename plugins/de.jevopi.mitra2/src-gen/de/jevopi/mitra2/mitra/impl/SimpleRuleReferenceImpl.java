/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.SimpleParameterReference;
import de.jevopi.mitra2.mitra.SimpleRuleReference;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Rule Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.SimpleRuleReferenceImpl#getParameterReferences <em>Parameter References</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.SimpleRuleReferenceImpl#getReturnReferences <em>Return References</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleRuleReferenceImpl extends RuleReferenceImpl implements SimpleRuleReference
{
  /**
   * The cached value of the '{@link #getParameterReferences() <em>Parameter References</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterReferences()
   * @generated
   * @ordered
   */
  protected EList<SimpleParameterReference> parameterReferences;

  /**
   * The cached value of the '{@link #getReturnReferences() <em>Return References</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturnReferences()
   * @generated
   * @ordered
   */
  protected EList<SimpleParameterReference> returnReferences;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SimpleRuleReferenceImpl()
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
    return MitraPackage.Literals.SIMPLE_RULE_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SimpleParameterReference> getParameterReferences()
  {
    if (parameterReferences == null)
    {
      parameterReferences = new EObjectContainmentEList<SimpleParameterReference>(SimpleParameterReference.class, this, MitraPackage.SIMPLE_RULE_REFERENCE__PARAMETER_REFERENCES);
    }
    return parameterReferences;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SimpleParameterReference> getReturnReferences()
  {
    if (returnReferences == null)
    {
      returnReferences = new EObjectContainmentEList<SimpleParameterReference>(SimpleParameterReference.class, this, MitraPackage.SIMPLE_RULE_REFERENCE__RETURN_REFERENCES);
    }
    return returnReferences;
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
      case MitraPackage.SIMPLE_RULE_REFERENCE__PARAMETER_REFERENCES:
        return ((InternalEList<?>)getParameterReferences()).basicRemove(otherEnd, msgs);
      case MitraPackage.SIMPLE_RULE_REFERENCE__RETURN_REFERENCES:
        return ((InternalEList<?>)getReturnReferences()).basicRemove(otherEnd, msgs);
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
      case MitraPackage.SIMPLE_RULE_REFERENCE__PARAMETER_REFERENCES:
        return getParameterReferences();
      case MitraPackage.SIMPLE_RULE_REFERENCE__RETURN_REFERENCES:
        return getReturnReferences();
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
      case MitraPackage.SIMPLE_RULE_REFERENCE__PARAMETER_REFERENCES:
        getParameterReferences().clear();
        getParameterReferences().addAll((Collection<? extends SimpleParameterReference>)newValue);
        return;
      case MitraPackage.SIMPLE_RULE_REFERENCE__RETURN_REFERENCES:
        getReturnReferences().clear();
        getReturnReferences().addAll((Collection<? extends SimpleParameterReference>)newValue);
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
      case MitraPackage.SIMPLE_RULE_REFERENCE__PARAMETER_REFERENCES:
        getParameterReferences().clear();
        return;
      case MitraPackage.SIMPLE_RULE_REFERENCE__RETURN_REFERENCES:
        getReturnReferences().clear();
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
      case MitraPackage.SIMPLE_RULE_REFERENCE__PARAMETER_REFERENCES:
        return parameterReferences != null && !parameterReferences.isEmpty();
      case MitraPackage.SIMPLE_RULE_REFERENCE__RETURN_REFERENCES:
        return returnReferences != null && !returnReferences.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SimpleRuleReferenceImpl
