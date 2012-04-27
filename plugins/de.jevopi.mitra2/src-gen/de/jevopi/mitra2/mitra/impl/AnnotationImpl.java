/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.Annotation;
import de.jevopi.mitra2.mitra.AnnotationDecl;
import de.jevopi.mitra2.mitra.AnnotationProperty;
import de.jevopi.mitra2.mitra.Literal;
import de.jevopi.mitra2.mitra.MitraPackage;

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
 * An implementation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.AnnotationImpl#getDecl <em>Decl</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.AnnotationImpl#getValues <em>Values</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.AnnotationImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotationImpl extends MinimalEObjectImpl.Container implements Annotation
{
  /**
   * The cached value of the '{@link #getDecl() <em>Decl</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDecl()
   * @generated
   * @ordered
   */
  protected AnnotationDecl decl;

  /**
   * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValues()
   * @generated
   * @ordered
   */
  protected EList<Literal> values;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EList<AnnotationProperty> properties;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AnnotationImpl()
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
    return MitraPackage.Literals.ANNOTATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnnotationDecl getDecl()
  {
    if (decl != null && decl.eIsProxy())
    {
      InternalEObject oldDecl = (InternalEObject)decl;
      decl = (AnnotationDecl)eResolveProxy(oldDecl);
      if (decl != oldDecl)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MitraPackage.ANNOTATION__DECL, oldDecl, decl));
      }
    }
    return decl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnnotationDecl basicGetDecl()
  {
    return decl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDecl(AnnotationDecl newDecl)
  {
    AnnotationDecl oldDecl = decl;
    decl = newDecl;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.ANNOTATION__DECL, oldDecl, decl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Literal> getValues()
  {
    if (values == null)
    {
      values = new EObjectContainmentEList<Literal>(Literal.class, this, MitraPackage.ANNOTATION__VALUES);
    }
    return values;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AnnotationProperty> getProperties()
  {
    if (properties == null)
    {
      properties = new EObjectContainmentEList<AnnotationProperty>(AnnotationProperty.class, this, MitraPackage.ANNOTATION__PROPERTIES);
    }
    return properties;
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
      case MitraPackage.ANNOTATION__VALUES:
        return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
      case MitraPackage.ANNOTATION__PROPERTIES:
        return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
      case MitraPackage.ANNOTATION__DECL:
        if (resolve) return getDecl();
        return basicGetDecl();
      case MitraPackage.ANNOTATION__VALUES:
        return getValues();
      case MitraPackage.ANNOTATION__PROPERTIES:
        return getProperties();
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
      case MitraPackage.ANNOTATION__DECL:
        setDecl((AnnotationDecl)newValue);
        return;
      case MitraPackage.ANNOTATION__VALUES:
        getValues().clear();
        getValues().addAll((Collection<? extends Literal>)newValue);
        return;
      case MitraPackage.ANNOTATION__PROPERTIES:
        getProperties().clear();
        getProperties().addAll((Collection<? extends AnnotationProperty>)newValue);
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
      case MitraPackage.ANNOTATION__DECL:
        setDecl((AnnotationDecl)null);
        return;
      case MitraPackage.ANNOTATION__VALUES:
        getValues().clear();
        return;
      case MitraPackage.ANNOTATION__PROPERTIES:
        getProperties().clear();
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
      case MitraPackage.ANNOTATION__DECL:
        return decl != null;
      case MitraPackage.ANNOTATION__VALUES:
        return values != null && !values.isEmpty();
      case MitraPackage.ANNOTATION__PROPERTIES:
        return properties != null && !properties.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AnnotationImpl
