/**
 */
package de.jevopi.mitra2.mitra.impl;

import de.jevopi.mitra2.mitra.LocalVariableDeclaration;
import de.jevopi.mitra2.mitra.LocalVariableDeclarationStatement;
import de.jevopi.mitra2.mitra.MitraPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Variable Declaration Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.mitra.impl.LocalVariableDeclarationStatementImpl#getLocalVariableDeclaration <em>Local Variable Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocalVariableDeclarationStatementImpl extends BlockStatementImpl implements LocalVariableDeclarationStatement
{
  /**
   * The cached value of the '{@link #getLocalVariableDeclaration() <em>Local Variable Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocalVariableDeclaration()
   * @generated
   * @ordered
   */
  protected LocalVariableDeclaration localVariableDeclaration;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LocalVariableDeclarationStatementImpl()
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
    return MitraPackage.Literals.LOCAL_VARIABLE_DECLARATION_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocalVariableDeclaration getLocalVariableDeclaration()
  {
    return localVariableDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLocalVariableDeclaration(LocalVariableDeclaration newLocalVariableDeclaration, NotificationChain msgs)
  {
    LocalVariableDeclaration oldLocalVariableDeclaration = localVariableDeclaration;
    localVariableDeclaration = newLocalVariableDeclaration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MitraPackage.LOCAL_VARIABLE_DECLARATION_STATEMENT__LOCAL_VARIABLE_DECLARATION, oldLocalVariableDeclaration, newLocalVariableDeclaration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLocalVariableDeclaration(LocalVariableDeclaration newLocalVariableDeclaration)
  {
    if (newLocalVariableDeclaration != localVariableDeclaration)
    {
      NotificationChain msgs = null;
      if (localVariableDeclaration != null)
        msgs = ((InternalEObject)localVariableDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MitraPackage.LOCAL_VARIABLE_DECLARATION_STATEMENT__LOCAL_VARIABLE_DECLARATION, null, msgs);
      if (newLocalVariableDeclaration != null)
        msgs = ((InternalEObject)newLocalVariableDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MitraPackage.LOCAL_VARIABLE_DECLARATION_STATEMENT__LOCAL_VARIABLE_DECLARATION, null, msgs);
      msgs = basicSetLocalVariableDeclaration(newLocalVariableDeclaration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MitraPackage.LOCAL_VARIABLE_DECLARATION_STATEMENT__LOCAL_VARIABLE_DECLARATION, newLocalVariableDeclaration, newLocalVariableDeclaration));
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
      case MitraPackage.LOCAL_VARIABLE_DECLARATION_STATEMENT__LOCAL_VARIABLE_DECLARATION:
        return basicSetLocalVariableDeclaration(null, msgs);
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
      case MitraPackage.LOCAL_VARIABLE_DECLARATION_STATEMENT__LOCAL_VARIABLE_DECLARATION:
        return getLocalVariableDeclaration();
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
      case MitraPackage.LOCAL_VARIABLE_DECLARATION_STATEMENT__LOCAL_VARIABLE_DECLARATION:
        setLocalVariableDeclaration((LocalVariableDeclaration)newValue);
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
      case MitraPackage.LOCAL_VARIABLE_DECLARATION_STATEMENT__LOCAL_VARIABLE_DECLARATION:
        setLocalVariableDeclaration((LocalVariableDeclaration)null);
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
      case MitraPackage.LOCAL_VARIABLE_DECLARATION_STATEMENT__LOCAL_VARIABLE_DECLARATION:
        return localVariableDeclaration != null;
    }
    return super.eIsSet(featureID);
  }

} //LocalVariableDeclarationStatementImpl
