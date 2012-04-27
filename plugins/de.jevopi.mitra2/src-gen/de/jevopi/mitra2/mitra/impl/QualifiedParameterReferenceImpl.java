/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.QualifiedParameterReference;
import de.jevopi.mitra2.mitra.TypedVarDeclaration;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Parameter Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.QualifiedParameterReferenceImpl#getVardecl <em>Vardecl</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualifiedParameterReferenceImpl extends ParameterReferenceImpl implements QualifiedParameterReference
{
  /**
   * The cached value of the '{@link #getVardecl() <em>Vardecl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVardecl()
   * @generated
   * @ordered
   */
  protected TypedVarDeclaration vardecl;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QualifiedParameterReferenceImpl()
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
    return MitraPackage.Literals.QUALIFIED_PARAMETER_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypedVarDeclaration getVardecl()
  {
    return vardecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVardecl(TypedVarDeclaration newVardecl, NotificationChain msgs)
  {
    TypedVarDeclaration oldVardecl = vardecl;
    vardecl = newVardecl;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.QUALIFIED_PARAMETER_REFERENCE__VARDECL, oldVardecl, newVardecl);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVardecl(TypedVarDeclaration newVardecl)
  {
    if (newVardecl != vardecl)
    {
      NotificationChain msgs = null;
      if (vardecl != null)
        msgs = ((InternalEObject)vardecl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.QUALIFIED_PARAMETER_REFERENCE__VARDECL, null, msgs);
      if (newVardecl != null)
        msgs = ((InternalEObject)newVardecl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.QUALIFIED_PARAMETER_REFERENCE__VARDECL, null, msgs);
      msgs = basicSetVardecl(newVardecl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.QUALIFIED_PARAMETER_REFERENCE__VARDECL, newVardecl, newVardecl));
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
      case MitraPackage.QUALIFIED_PARAMETER_REFERENCE__VARDECL:
        return basicSetVardecl(null, msgs);
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
      case MitraPackage.QUALIFIED_PARAMETER_REFERENCE__VARDECL:
        return getVardecl();
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
      case MitraPackage.QUALIFIED_PARAMETER_REFERENCE__VARDECL:
        setVardecl((TypedVarDeclaration)newValue);
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
      case MitraPackage.QUALIFIED_PARAMETER_REFERENCE__VARDECL:
        setVardecl((TypedVarDeclaration)null);
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
      case MitraPackage.QUALIFIED_PARAMETER_REFERENCE__VARDECL:
        return vardecl != null;
    }
    return super.eIsSet(featureID);
  }

} //QualifiedParameterReferenceImpl
