/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.QualifiedParameterReference;
import de.jevopi.mitra2.mitra.QualifiedRuleReference;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Rule Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.QualifiedRuleReferenceImpl#getParameterReferences <em>Parameter References</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.QualifiedRuleReferenceImpl#getReturnReferences <em>Return References</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualifiedRuleReferenceImpl extends RuleReferenceImpl implements QualifiedRuleReference
{
  /**
   * The cached value of the '{@link #getParameterReferences() <em>Parameter References</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterReferences()
   * @generated
   * @ordered
   */
  protected EList<QualifiedParameterReference> parameterReferences;

  /**
   * The cached value of the '{@link #getReturnReferences() <em>Return References</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturnReferences()
   * @generated
   * @ordered
   */
  protected EList<QualifiedParameterReference> returnReferences;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QualifiedRuleReferenceImpl()
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
    return MitraPackage.Literals.QUALIFIED_RULE_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<QualifiedParameterReference> getParameterReferences()
  {
    if (parameterReferences == null)
    {
      parameterReferences = new EObjectContainmentEList<QualifiedParameterReference>(QualifiedParameterReference.class, this, MitraPackage.QUALIFIED_RULE_REFERENCE__PARAMETER_REFERENCES);
    }
    return parameterReferences;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<QualifiedParameterReference> getReturnReferences()
  {
    if (returnReferences == null)
    {
      returnReferences = new EObjectContainmentEList<QualifiedParameterReference>(QualifiedParameterReference.class, this, MitraPackage.QUALIFIED_RULE_REFERENCE__RETURN_REFERENCES);
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
      case MitraPackage.QUALIFIED_RULE_REFERENCE__PARAMETER_REFERENCES:
        return ((InternalEList<?>)getParameterReferences()).basicRemove(otherEnd, msgs);
      case MitraPackage.QUALIFIED_RULE_REFERENCE__RETURN_REFERENCES:
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
      case MitraPackage.QUALIFIED_RULE_REFERENCE__PARAMETER_REFERENCES:
        return getParameterReferences();
      case MitraPackage.QUALIFIED_RULE_REFERENCE__RETURN_REFERENCES:
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
      case MitraPackage.QUALIFIED_RULE_REFERENCE__PARAMETER_REFERENCES:
        getParameterReferences().clear();
        getParameterReferences().addAll((Collection<? extends QualifiedParameterReference>)newValue);
        return;
      case MitraPackage.QUALIFIED_RULE_REFERENCE__RETURN_REFERENCES:
        getReturnReferences().clear();
        getReturnReferences().addAll((Collection<? extends QualifiedParameterReference>)newValue);
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
      case MitraPackage.QUALIFIED_RULE_REFERENCE__PARAMETER_REFERENCES:
        getParameterReferences().clear();
        return;
      case MitraPackage.QUALIFIED_RULE_REFERENCE__RETURN_REFERENCES:
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
      case MitraPackage.QUALIFIED_RULE_REFERENCE__PARAMETER_REFERENCES:
        return parameterReferences != null && !parameterReferences.isEmpty();
      case MitraPackage.QUALIFIED_RULE_REFERENCE__RETURN_REFERENCES:
        return returnReferences != null && !returnReferences.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //QualifiedRuleReferenceImpl
