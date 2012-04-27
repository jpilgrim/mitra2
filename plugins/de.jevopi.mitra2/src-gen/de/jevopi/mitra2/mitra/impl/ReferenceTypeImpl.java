/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.MetamodelDeclaration;
import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.ReferenceType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ReferenceTypeImpl#getMetamodelDeclaration <em>Metamodel Declaration</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ReferenceTypeImpl#getEClassifier <em>EClassifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceTypeImpl extends TypeImpl implements ReferenceType
{
  /**
   * The cached value of the '{@link #getMetamodelDeclaration() <em>Metamodel Declaration</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetamodelDeclaration()
   * @generated
   * @ordered
   */
  protected MetamodelDeclaration metamodelDeclaration;

  /**
   * The cached value of the '{@link #getEClassifier() <em>EClassifier</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEClassifier()
   * @generated
   * @ordered
   */
  protected EClassifier eClassifier;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReferenceTypeImpl()
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
    return MitraPackage.Literals.REFERENCE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetamodelDeclaration getMetamodelDeclaration()
  {
    if (metamodelDeclaration != null && metamodelDeclaration.eIsProxy())
    {
      InternalEObject oldMetamodelDeclaration = (InternalEObject)metamodelDeclaration;
      metamodelDeclaration = (MetamodelDeclaration)eResolveProxy(oldMetamodelDeclaration);
      if (metamodelDeclaration != oldMetamodelDeclaration)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MitraPackage.REFERENCE_TYPE__METAMODEL_DECLARATION, oldMetamodelDeclaration, metamodelDeclaration));
      }
    }
    return metamodelDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetamodelDeclaration basicGetMetamodelDeclaration()
  {
    return metamodelDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMetamodelDeclaration(MetamodelDeclaration newMetamodelDeclaration)
  {
    MetamodelDeclaration oldMetamodelDeclaration = metamodelDeclaration;
    metamodelDeclaration = newMetamodelDeclaration;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.REFERENCE_TYPE__METAMODEL_DECLARATION, oldMetamodelDeclaration, metamodelDeclaration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClassifier getEClassifier()
  {
    if (eClassifier != null && eClassifier.eIsProxy())
    {
      InternalEObject oldEClassifier = (InternalEObject)eClassifier;
      eClassifier = (EClassifier)eResolveProxy(oldEClassifier);
      if (eClassifier != oldEClassifier)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MitraPackage.REFERENCE_TYPE__ECLASSIFIER, oldEClassifier, eClassifier));
      }
    }
    return eClassifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClassifier basicGetEClassifier()
  {
    return eClassifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEClassifier(EClassifier newEClassifier)
  {
    EClassifier oldEClassifier = eClassifier;
    eClassifier = newEClassifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.REFERENCE_TYPE__ECLASSIFIER, oldEClassifier, eClassifier));
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
      case MitraPackage.REFERENCE_TYPE__METAMODEL_DECLARATION:
        if (resolve) return getMetamodelDeclaration();
        return basicGetMetamodelDeclaration();
      case MitraPackage.REFERENCE_TYPE__ECLASSIFIER:
        if (resolve) return getEClassifier();
        return basicGetEClassifier();
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
      case MitraPackage.REFERENCE_TYPE__METAMODEL_DECLARATION:
        setMetamodelDeclaration((MetamodelDeclaration)newValue);
        return;
      case MitraPackage.REFERENCE_TYPE__ECLASSIFIER:
        setEClassifier((EClassifier)newValue);
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
      case MitraPackage.REFERENCE_TYPE__METAMODEL_DECLARATION:
        setMetamodelDeclaration((MetamodelDeclaration)null);
        return;
      case MitraPackage.REFERENCE_TYPE__ECLASSIFIER:
        setEClassifier((EClassifier)null);
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
      case MitraPackage.REFERENCE_TYPE__METAMODEL_DECLARATION:
        return metamodelDeclaration != null;
      case MitraPackage.REFERENCE_TYPE__ECLASSIFIER:
        return eClassifier != null;
    }
    return super.eIsSet(featureID);
  }

} //ReferenceTypeImpl
