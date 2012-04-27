/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.AnnotationDecl;
import de.jevopi.mitra2.mitra.AnnotationsDefinition;
import de.jevopi.mitra2.mitra.MitraPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotations Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.AnnotationsDefinitionImpl#getAnnotationDecls <em>Annotation Decls</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotationsDefinitionImpl extends MinimalEObjectImpl.Container implements AnnotationsDefinition
{
  /**
   * The cached value of the '{@link #getAnnotationDecls() <em>Annotation Decls</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotationDecls()
   * @generated
   * @ordered
   */
  protected EList<AnnotationDecl> annotationDecls;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AnnotationsDefinitionImpl()
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
    return MitraPackage.Literals.ANNOTATIONS_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AnnotationDecl> getAnnotationDecls()
  {
    if (annotationDecls == null)
    {
      annotationDecls = new EObjectContainmentEList<AnnotationDecl>(AnnotationDecl.class, this, MitraPackage.ANNOTATIONS_DEFINITION__ANNOTATION_DECLS);
    }
    return annotationDecls;
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
      case MitraPackage.ANNOTATIONS_DEFINITION__ANNOTATION_DECLS:
        return ((InternalEList<?>)getAnnotationDecls()).basicRemove(otherEnd, msgs);
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
      case MitraPackage.ANNOTATIONS_DEFINITION__ANNOTATION_DECLS:
        return getAnnotationDecls();
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
      case MitraPackage.ANNOTATIONS_DEFINITION__ANNOTATION_DECLS:
        getAnnotationDecls().clear();
        getAnnotationDecls().addAll((Collection<? extends AnnotationDecl>)newValue);
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
      case MitraPackage.ANNOTATIONS_DEFINITION__ANNOTATION_DECLS:
        getAnnotationDecls().clear();
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
      case MitraPackage.ANNOTATIONS_DEFINITION__ANNOTATION_DECLS:
        return annotationDecls != null && !annotationDecls.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AnnotationsDefinitionImpl
