/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.AnnotationDecl;
import de.jevopi.mitra2.mitra.AnnotationPropertyDecl;
import de.jevopi.mitra2.mitra.AnnotationTargetSpec;
import de.jevopi.mitra2.mitra.Literal;
import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.PrimitiveType;

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
 * An implementation of the model object '<em><b>Annotation Decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.AnnotationDeclImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.AnnotationDeclImpl#getTargets <em>Targets</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.AnnotationDeclImpl#getValuetype <em>Valuetype</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.AnnotationDeclImpl#isMany <em>Many</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.AnnotationDeclImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.AnnotationDeclImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.AnnotationDeclImpl#getPropertyDecls <em>Property Decls</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotationDeclImpl extends MinimalEObjectImpl.Container implements AnnotationDecl
{
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
   * The cached value of the '{@link #getTargets() <em>Targets</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargets()
   * @generated
   * @ordered
   */
  protected EList<AnnotationTargetSpec> targets;

  /**
   * The cached value of the '{@link #getValuetype() <em>Valuetype</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValuetype()
   * @generated
   * @ordered
   */
  protected PrimitiveType valuetype;

  /**
   * The default value of the '{@link #isMany() <em>Many</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMany()
   * @generated
   * @ordered
   */
  protected static final boolean MANY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMany() <em>Many</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMany()
   * @generated
   * @ordered
   */
  protected boolean many = MANY_EDEFAULT;

  /**
   * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRequired()
   * @generated
   * @ordered
   */
  protected static final boolean REQUIRED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isRequired() <em>Required</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRequired()
   * @generated
   * @ordered
   */
  protected boolean required = REQUIRED_EDEFAULT;

  /**
   * The cached value of the '{@link #getDefault() <em>Default</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefault()
   * @generated
   * @ordered
   */
  protected Literal default_;

  /**
   * The cached value of the '{@link #getPropertyDecls() <em>Property Decls</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertyDecls()
   * @generated
   * @ordered
   */
  protected EList<AnnotationPropertyDecl> propertyDecls;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AnnotationDeclImpl()
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
    return MitraPackage.Literals.ANNOTATION_DECL;
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
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.ANNOTATION_DECL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AnnotationTargetSpec> getTargets()
  {
    if (targets == null)
    {
      targets = new EDataTypeEList<AnnotationTargetSpec>(AnnotationTargetSpec.class, this, MitraPackage.ANNOTATION_DECL__TARGETS);
    }
    return targets;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitiveType getValuetype()
  {
    return valuetype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValuetype(PrimitiveType newValuetype, NotificationChain msgs)
  {
    PrimitiveType oldValuetype = valuetype;
    valuetype = newValuetype;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.ANNOTATION_DECL__VALUETYPE, oldValuetype, newValuetype);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValuetype(PrimitiveType newValuetype)
  {
    if (newValuetype != valuetype)
    {
      NotificationChain msgs = null;
      if (valuetype != null)
        msgs = ((InternalEObject)valuetype).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.ANNOTATION_DECL__VALUETYPE, null, msgs);
      if (newValuetype != null)
        msgs = ((InternalEObject)newValuetype).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.ANNOTATION_DECL__VALUETYPE, null, msgs);
      msgs = basicSetValuetype(newValuetype, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.ANNOTATION_DECL__VALUETYPE, newValuetype, newValuetype));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isMany()
  {
    return many;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMany(boolean newMany)
  {
    boolean oldMany = many;
    many = newMany;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.ANNOTATION_DECL__MANY, oldMany, many));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isRequired()
  {
    return required;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRequired(boolean newRequired)
  {
    boolean oldRequired = required;
    required = newRequired;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.ANNOTATION_DECL__REQUIRED, oldRequired, required));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal getDefault()
  {
    return default_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDefault(Literal newDefault, NotificationChain msgs)
  {
    Literal oldDefault = default_;
    default_ = newDefault;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.ANNOTATION_DECL__DEFAULT, oldDefault, newDefault);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefault(Literal newDefault)
  {
    if (newDefault != default_)
    {
      NotificationChain msgs = null;
      if (default_ != null)
        msgs = ((InternalEObject)default_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.ANNOTATION_DECL__DEFAULT, null, msgs);
      if (newDefault != null)
        msgs = ((InternalEObject)newDefault).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.ANNOTATION_DECL__DEFAULT, null, msgs);
      msgs = basicSetDefault(newDefault, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.ANNOTATION_DECL__DEFAULT, newDefault, newDefault));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AnnotationPropertyDecl> getPropertyDecls()
  {
    if (propertyDecls == null)
    {
      propertyDecls = new EObjectContainmentEList<AnnotationPropertyDecl>(AnnotationPropertyDecl.class, this, MitraPackage.ANNOTATION_DECL__PROPERTY_DECLS);
    }
    return propertyDecls;
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
      case MitraPackage.ANNOTATION_DECL__VALUETYPE:
        return basicSetValuetype(null, msgs);
      case MitraPackage.ANNOTATION_DECL__DEFAULT:
        return basicSetDefault(null, msgs);
      case MitraPackage.ANNOTATION_DECL__PROPERTY_DECLS:
        return ((InternalEList<?>)getPropertyDecls()).basicRemove(otherEnd, msgs);
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
      case MitraPackage.ANNOTATION_DECL__NAME:
        return getName();
      case MitraPackage.ANNOTATION_DECL__TARGETS:
        return getTargets();
      case MitraPackage.ANNOTATION_DECL__VALUETYPE:
        return getValuetype();
      case MitraPackage.ANNOTATION_DECL__MANY:
        return isMany();
      case MitraPackage.ANNOTATION_DECL__REQUIRED:
        return isRequired();
      case MitraPackage.ANNOTATION_DECL__DEFAULT:
        return getDefault();
      case MitraPackage.ANNOTATION_DECL__PROPERTY_DECLS:
        return getPropertyDecls();
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
      case MitraPackage.ANNOTATION_DECL__NAME:
        setName((String)newValue);
        return;
      case MitraPackage.ANNOTATION_DECL__TARGETS:
        getTargets().clear();
        getTargets().addAll((Collection<? extends AnnotationTargetSpec>)newValue);
        return;
      case MitraPackage.ANNOTATION_DECL__VALUETYPE:
        setValuetype((PrimitiveType)newValue);
        return;
      case MitraPackage.ANNOTATION_DECL__MANY:
        setMany((Boolean)newValue);
        return;
      case MitraPackage.ANNOTATION_DECL__REQUIRED:
        setRequired((Boolean)newValue);
        return;
      case MitraPackage.ANNOTATION_DECL__DEFAULT:
        setDefault((Literal)newValue);
        return;
      case MitraPackage.ANNOTATION_DECL__PROPERTY_DECLS:
        getPropertyDecls().clear();
        getPropertyDecls().addAll((Collection<? extends AnnotationPropertyDecl>)newValue);
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
      case MitraPackage.ANNOTATION_DECL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MitraPackage.ANNOTATION_DECL__TARGETS:
        getTargets().clear();
        return;
      case MitraPackage.ANNOTATION_DECL__VALUETYPE:
        setValuetype((PrimitiveType)null);
        return;
      case MitraPackage.ANNOTATION_DECL__MANY:
        setMany(MANY_EDEFAULT);
        return;
      case MitraPackage.ANNOTATION_DECL__REQUIRED:
        setRequired(REQUIRED_EDEFAULT);
        return;
      case MitraPackage.ANNOTATION_DECL__DEFAULT:
        setDefault((Literal)null);
        return;
      case MitraPackage.ANNOTATION_DECL__PROPERTY_DECLS:
        getPropertyDecls().clear();
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
      case MitraPackage.ANNOTATION_DECL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MitraPackage.ANNOTATION_DECL__TARGETS:
        return targets != null && !targets.isEmpty();
      case MitraPackage.ANNOTATION_DECL__VALUETYPE:
        return valuetype != null;
      case MitraPackage.ANNOTATION_DECL__MANY:
        return many != MANY_EDEFAULT;
      case MitraPackage.ANNOTATION_DECL__REQUIRED:
        return required != REQUIRED_EDEFAULT;
      case MitraPackage.ANNOTATION_DECL__DEFAULT:
        return default_ != null;
      case MitraPackage.ANNOTATION_DECL__PROPERTY_DECLS:
        return propertyDecls != null && !propertyDecls.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(", targets: ");
    result.append(targets);
    result.append(", many: ");
    result.append(many);
    result.append(", required: ");
    result.append(required);
    result.append(')');
    return result.toString();
  }

} //AnnotationDeclImpl
