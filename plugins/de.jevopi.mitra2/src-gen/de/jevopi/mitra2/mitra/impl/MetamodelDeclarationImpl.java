/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.MetamodelDeclaration;
import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.Property;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metamodel Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.MetamodelDeclarationImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.MetamodelDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.MetamodelDeclarationImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.MetamodelDeclarationImpl#getReplaces <em>Replaces</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetamodelDeclarationImpl extends MinimalEObjectImpl.Container implements MetamodelDeclaration
{
  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EList<Property> properties;

  /**
   * The cached value of the '{@link #getReplaces() <em>Replaces</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReplaces()
   * @generated
   * @ordered
   */
  protected EList<String> replaces;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MetamodelDeclarationImpl()
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
    return MitraPackage.Literals.METAMODEL_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(String newType)
  {
    String oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.METAMODEL_DECLARATION__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.METAMODEL_DECLARATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Property> getProperties()
  {
    if (properties == null)
    {
      properties = new EObjectContainmentEList<Property>(Property.class, this, MitraPackage.METAMODEL_DECLARATION__PROPERTIES);
    }
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getReplaces()
  {
    if (replaces == null)
    {
      replaces = new EDataTypeEList<String>(String.class, this, MitraPackage.METAMODEL_DECLARATION__REPLACES);
    }
    return replaces;
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
      case MitraPackage.METAMODEL_DECLARATION__PROPERTIES:
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
      case MitraPackage.METAMODEL_DECLARATION__TYPE:
        return getType();
      case MitraPackage.METAMODEL_DECLARATION__NAME:
        return getName();
      case MitraPackage.METAMODEL_DECLARATION__PROPERTIES:
        return getProperties();
      case MitraPackage.METAMODEL_DECLARATION__REPLACES:
        return getReplaces();
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
      case MitraPackage.METAMODEL_DECLARATION__TYPE:
        setType((String)newValue);
        return;
      case MitraPackage.METAMODEL_DECLARATION__NAME:
        setName((String)newValue);
        return;
      case MitraPackage.METAMODEL_DECLARATION__PROPERTIES:
        getProperties().clear();
        getProperties().addAll((Collection<? extends Property>)newValue);
        return;
      case MitraPackage.METAMODEL_DECLARATION__REPLACES:
        getReplaces().clear();
        getReplaces().addAll((Collection<? extends String>)newValue);
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
      case MitraPackage.METAMODEL_DECLARATION__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case MitraPackage.METAMODEL_DECLARATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MitraPackage.METAMODEL_DECLARATION__PROPERTIES:
        getProperties().clear();
        return;
      case MitraPackage.METAMODEL_DECLARATION__REPLACES:
        getReplaces().clear();
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
      case MitraPackage.METAMODEL_DECLARATION__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case MitraPackage.METAMODEL_DECLARATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MitraPackage.METAMODEL_DECLARATION__PROPERTIES:
        return properties != null && !properties.isEmpty();
      case MitraPackage.METAMODEL_DECLARATION__REPLACES:
        return replaces != null && !replaces.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MetamodelDeclarationImpl
