/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.CollectionType;
import de.jevopi.mitra2.mitra.CollectionTypeSpec;
import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.Type;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.CollectionTypeImpl#getCollectionType <em>Collection Type</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.CollectionTypeImpl#getTypePar <em>Type Par</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionTypeImpl extends TypeImpl implements CollectionType
{
  /**
   * The default value of the '{@link #getCollectionType() <em>Collection Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCollectionType()
   * @generated
   * @ordered
   */
  protected static final CollectionTypeSpec COLLECTION_TYPE_EDEFAULT = CollectionTypeSpec.COLLECTION;

  /**
   * The cached value of the '{@link #getCollectionType() <em>Collection Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCollectionType()
   * @generated
   * @ordered
   */
  protected CollectionTypeSpec collectionType = COLLECTION_TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getTypePar() <em>Type Par</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypePar()
   * @generated
   * @ordered
   */
  protected Type typePar;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CollectionTypeImpl()
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
    return MitraPackage.Literals.COLLECTION_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionTypeSpec getCollectionType()
  {
    return collectionType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCollectionType(CollectionTypeSpec newCollectionType)
  {
    CollectionTypeSpec oldCollectionType = collectionType;
    collectionType = newCollectionType == null ? COLLECTION_TYPE_EDEFAULT : newCollectionType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.COLLECTION_TYPE__COLLECTION_TYPE, oldCollectionType, collectionType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getTypePar()
  {
    return typePar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypePar(Type newTypePar, NotificationChain msgs)
  {
    Type oldTypePar = typePar;
    typePar = newTypePar;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.COLLECTION_TYPE__TYPE_PAR, oldTypePar, newTypePar);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypePar(Type newTypePar)
  {
    if (newTypePar != typePar)
    {
      NotificationChain msgs = null;
      if (typePar != null)
        msgs = ((InternalEObject)typePar).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.COLLECTION_TYPE__TYPE_PAR, null, msgs);
      if (newTypePar != null)
        msgs = ((InternalEObject)newTypePar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.COLLECTION_TYPE__TYPE_PAR, null, msgs);
      msgs = basicSetTypePar(newTypePar, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.COLLECTION_TYPE__TYPE_PAR, newTypePar, newTypePar));
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
      case MitraPackage.COLLECTION_TYPE__TYPE_PAR:
        return basicSetTypePar(null, msgs);
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
      case MitraPackage.COLLECTION_TYPE__COLLECTION_TYPE:
        return getCollectionType();
      case MitraPackage.COLLECTION_TYPE__TYPE_PAR:
        return getTypePar();
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
      case MitraPackage.COLLECTION_TYPE__COLLECTION_TYPE:
        setCollectionType((CollectionTypeSpec)newValue);
        return;
      case MitraPackage.COLLECTION_TYPE__TYPE_PAR:
        setTypePar((Type)newValue);
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
      case MitraPackage.COLLECTION_TYPE__COLLECTION_TYPE:
        setCollectionType(COLLECTION_TYPE_EDEFAULT);
        return;
      case MitraPackage.COLLECTION_TYPE__TYPE_PAR:
        setTypePar((Type)null);
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
      case MitraPackage.COLLECTION_TYPE__COLLECTION_TYPE:
        return collectionType != COLLECTION_TYPE_EDEFAULT;
      case MitraPackage.COLLECTION_TYPE__TYPE_PAR:
        return typePar != null;
    }
    return super.eIsSet(featureID);
  }

} //CollectionTypeImpl
