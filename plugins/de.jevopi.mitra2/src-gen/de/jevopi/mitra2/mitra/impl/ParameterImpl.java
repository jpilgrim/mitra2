/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.Annotation;
import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.Parameter;
import de.jevopi.mitra2.mitra.ParameterModifier;
import de.jevopi.mitra2.mitra.TypedVarDeclaration;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ParameterImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ParameterImpl#getModifier <em>Modifier</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ParameterImpl#getVardecl <em>Vardecl</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterImpl extends MinimalEObjectImpl.Container implements Parameter
{
  /**
   * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotations()
   * @generated
   * @ordered
   */
  protected EList<Annotation> annotations;

  /**
   * The default value of the '{@link #getModifier() <em>Modifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModifier()
   * @generated
   * @ordered
   */
  protected static final ParameterModifier MODIFIER_EDEFAULT = ParameterModifier.USE;

  /**
   * The cached value of the '{@link #getModifier() <em>Modifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModifier()
   * @generated
   * @ordered
   */
  protected ParameterModifier modifier = MODIFIER_EDEFAULT;

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
  protected ParameterImpl()
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
    return MitraPackage.Literals.PARAMETER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Annotation> getAnnotations()
  {
    if (annotations == null)
    {
      annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, MitraPackage.PARAMETER__ANNOTATIONS);
    }
    return annotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterModifier getModifier()
  {
    return modifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModifier(ParameterModifier newModifier)
  {
    ParameterModifier oldModifier = modifier;
    modifier = newModifier == null ? MODIFIER_EDEFAULT : newModifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.PARAMETER__MODIFIER, oldModifier, modifier));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.PARAMETER__VARDECL, oldVardecl, newVardecl);
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
        msgs = ((InternalEObject)vardecl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.PARAMETER__VARDECL, null, msgs);
      if (newVardecl != null)
        msgs = ((InternalEObject)newVardecl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.PARAMETER__VARDECL, null, msgs);
      msgs = basicSetVardecl(newVardecl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.PARAMETER__VARDECL, newVardecl, newVardecl));
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
      case MitraPackage.PARAMETER__ANNOTATIONS:
        return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
      case MitraPackage.PARAMETER__VARDECL:
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
      case MitraPackage.PARAMETER__ANNOTATIONS:
        return getAnnotations();
      case MitraPackage.PARAMETER__MODIFIER:
        return getModifier();
      case MitraPackage.PARAMETER__VARDECL:
        return getVardecl();
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
      case MitraPackage.PARAMETER__ANNOTATIONS:
        getAnnotations().clear();
        getAnnotations().addAll((Collection<? extends Annotation>)newValue);
        return;
      case MitraPackage.PARAMETER__MODIFIER:
        setModifier((ParameterModifier)newValue);
        return;
      case MitraPackage.PARAMETER__VARDECL:
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
      case MitraPackage.PARAMETER__ANNOTATIONS:
        getAnnotations().clear();
        return;
      case MitraPackage.PARAMETER__MODIFIER:
        setModifier(MODIFIER_EDEFAULT);
        return;
      case MitraPackage.PARAMETER__VARDECL:
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
      case MitraPackage.PARAMETER__ANNOTATIONS:
        return annotations != null && !annotations.isEmpty();
      case MitraPackage.PARAMETER__MODIFIER:
        return modifier != MODIFIER_EDEFAULT;
      case MitraPackage.PARAMETER__VARDECL:
        return vardecl != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (modifier: ");
    result.append(modifier);
    result.append(')');
    return result.toString();
  }

} //ParameterImpl
