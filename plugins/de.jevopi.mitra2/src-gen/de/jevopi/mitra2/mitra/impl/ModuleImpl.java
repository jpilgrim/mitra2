/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.AnnotationsDefinition;
import de.jevopi.mitra2.mitra.MetamodelDeclaration;
import de.jevopi.mitra2.mitra.MitraPackage;
import de.jevopi.mitra2.mitra.Module;
import de.jevopi.mitra2.mitra.ModuleReference;
import de.jevopi.mitra2.mitra.RuleDeclaration;

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
 * An implementation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ModuleImpl#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ModuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ModuleImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ModuleImpl#getMetamodelDeclarations <em>Metamodel Declarations</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ModuleImpl#getAnnotationDefinitions <em>Annotation Definitions</em>}</li>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.ModuleImpl#getRuleDeclarations <em>Rule Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModuleImpl extends MinimalEObjectImpl.Container implements Module
{
  /**
   * The default value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackageName()
   * @generated
   * @ordered
   */
  protected static final String PACKAGE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackageName()
   * @generated
   * @ordered
   */
  protected String packageName = PACKAGE_NAME_EDEFAULT;

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
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<ModuleReference> imports;

  /**
   * The cached value of the '{@link #getMetamodelDeclarations() <em>Metamodel Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetamodelDeclarations()
   * @generated
   * @ordered
   */
  protected EList<MetamodelDeclaration> metamodelDeclarations;

  /**
   * The cached value of the '{@link #getAnnotationDefinitions() <em>Annotation Definitions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotationDefinitions()
   * @generated
   * @ordered
   */
  protected EList<AnnotationsDefinition> annotationDefinitions;

  /**
   * The cached value of the '{@link #getRuleDeclarations() <em>Rule Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRuleDeclarations()
   * @generated
   * @ordered
   */
  protected EList<RuleDeclaration> ruleDeclarations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModuleImpl()
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
    return MitraPackage.Literals.MODULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPackageName()
  {
    return packageName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPackageName(String newPackageName)
  {
    String oldPackageName = packageName;
    packageName = newPackageName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.MODULE__PACKAGE_NAME, oldPackageName, packageName));
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
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.MODULE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ModuleReference> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<ModuleReference>(ModuleReference.class, this, MitraPackage.MODULE__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MetamodelDeclaration> getMetamodelDeclarations()
  {
    if (metamodelDeclarations == null)
    {
      metamodelDeclarations = new EObjectContainmentEList<MetamodelDeclaration>(MetamodelDeclaration.class, this, MitraPackage.MODULE__METAMODEL_DECLARATIONS);
    }
    return metamodelDeclarations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AnnotationsDefinition> getAnnotationDefinitions()
  {
    if (annotationDefinitions == null)
    {
      annotationDefinitions = new EObjectContainmentEList<AnnotationsDefinition>(AnnotationsDefinition.class, this, MitraPackage.MODULE__ANNOTATION_DEFINITIONS);
    }
    return annotationDefinitions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RuleDeclaration> getRuleDeclarations()
  {
    if (ruleDeclarations == null)
    {
      ruleDeclarations = new EObjectContainmentEList<RuleDeclaration>(RuleDeclaration.class, this, MitraPackage.MODULE__RULE_DECLARATIONS);
    }
    return ruleDeclarations;
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
      case MitraPackage.MODULE__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case MitraPackage.MODULE__METAMODEL_DECLARATIONS:
        return ((InternalEList<?>)getMetamodelDeclarations()).basicRemove(otherEnd, msgs);
      case MitraPackage.MODULE__ANNOTATION_DEFINITIONS:
        return ((InternalEList<?>)getAnnotationDefinitions()).basicRemove(otherEnd, msgs);
      case MitraPackage.MODULE__RULE_DECLARATIONS:
        return ((InternalEList<?>)getRuleDeclarations()).basicRemove(otherEnd, msgs);
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
      case MitraPackage.MODULE__PACKAGE_NAME:
        return getPackageName();
      case MitraPackage.MODULE__NAME:
        return getName();
      case MitraPackage.MODULE__IMPORTS:
        return getImports();
      case MitraPackage.MODULE__METAMODEL_DECLARATIONS:
        return getMetamodelDeclarations();
      case MitraPackage.MODULE__ANNOTATION_DEFINITIONS:
        return getAnnotationDefinitions();
      case MitraPackage.MODULE__RULE_DECLARATIONS:
        return getRuleDeclarations();
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
      case MitraPackage.MODULE__PACKAGE_NAME:
        setPackageName((String)newValue);
        return;
      case MitraPackage.MODULE__NAME:
        setName((String)newValue);
        return;
      case MitraPackage.MODULE__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends ModuleReference>)newValue);
        return;
      case MitraPackage.MODULE__METAMODEL_DECLARATIONS:
        getMetamodelDeclarations().clear();
        getMetamodelDeclarations().addAll((Collection<? extends MetamodelDeclaration>)newValue);
        return;
      case MitraPackage.MODULE__ANNOTATION_DEFINITIONS:
        getAnnotationDefinitions().clear();
        getAnnotationDefinitions().addAll((Collection<? extends AnnotationsDefinition>)newValue);
        return;
      case MitraPackage.MODULE__RULE_DECLARATIONS:
        getRuleDeclarations().clear();
        getRuleDeclarations().addAll((Collection<? extends RuleDeclaration>)newValue);
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
      case MitraPackage.MODULE__PACKAGE_NAME:
        setPackageName(PACKAGE_NAME_EDEFAULT);
        return;
      case MitraPackage.MODULE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MitraPackage.MODULE__IMPORTS:
        getImports().clear();
        return;
      case MitraPackage.MODULE__METAMODEL_DECLARATIONS:
        getMetamodelDeclarations().clear();
        return;
      case MitraPackage.MODULE__ANNOTATION_DEFINITIONS:
        getAnnotationDefinitions().clear();
        return;
      case MitraPackage.MODULE__RULE_DECLARATIONS:
        getRuleDeclarations().clear();
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
      case MitraPackage.MODULE__PACKAGE_NAME:
        return PACKAGE_NAME_EDEFAULT == null ? packageName != null : !PACKAGE_NAME_EDEFAULT.equals(packageName);
      case MitraPackage.MODULE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MitraPackage.MODULE__IMPORTS:
        return imports != null && !imports.isEmpty();
      case MitraPackage.MODULE__METAMODEL_DECLARATIONS:
        return metamodelDeclarations != null && !metamodelDeclarations.isEmpty();
      case MitraPackage.MODULE__ANNOTATION_DEFINITIONS:
        return annotationDefinitions != null && !annotationDefinitions.isEmpty();
      case MitraPackage.MODULE__RULE_DECLARATIONS:
        return ruleDeclarations != null && !ruleDeclarations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ModuleImpl
