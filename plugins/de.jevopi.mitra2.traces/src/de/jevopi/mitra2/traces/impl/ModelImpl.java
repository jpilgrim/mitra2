/**
 * (C) 2012 Jens von Pilgrim
 */
package de.jevopi.mitra2.traces.impl;

import de.jevopi.mitra2.traces.Model;
import de.jevopi.mitra2.traces.TraceElement;
import de.jevopi.mitra2.traces.TracesPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.traces.impl.ModelImpl#getUriModel <em>Uri Model</em>}</li>
 *   <li>{@link de.jevopi.mitra2.traces.impl.ModelImpl#getModelRoot <em>Model Root</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends EObjectImpl implements Model {
	/**
	 * The default value of the '{@link #getUriModel() <em>Uri Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUriModel()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_MODEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUriModel() <em>Uri Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUriModel()
	 * @generated
	 * @ordered
	 */
	protected String uriModel = URI_MODEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModelRoot() <em>Model Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelRoot()
	 * @generated
	 * @ordered
	 */
	protected EObject modelRoot;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracesPackage.Literals.MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUriModel() {
		return uriModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUriModel(String newUriModel) {
		String oldUriModel = uriModel;
		uriModel = newUriModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracesPackage.MODEL__URI_MODEL, oldUriModel, uriModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getModelRoot() {
		if (modelRoot != null && modelRoot.eIsProxy()) {
			InternalEObject oldModelRoot = (InternalEObject)modelRoot;
			modelRoot = eResolveProxy(oldModelRoot);
			if (modelRoot != oldModelRoot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TracesPackage.MODEL__MODEL_ROOT, oldModelRoot, modelRoot));
			}
		}
		return modelRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetModelRoot() {
		return modelRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelRoot(EObject newModelRoot) {
		EObject oldModelRoot = modelRoot;
		modelRoot = newModelRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracesPackage.MODEL__MODEL_ROOT, oldModelRoot, modelRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TracesPackage.MODEL__URI_MODEL:
				return getUriModel();
			case TracesPackage.MODEL__MODEL_ROOT:
				if (resolve) return getModelRoot();
				return basicGetModelRoot();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TracesPackage.MODEL__URI_MODEL:
				setUriModel((String)newValue);
				return;
			case TracesPackage.MODEL__MODEL_ROOT:
				setModelRoot((EObject)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case TracesPackage.MODEL__URI_MODEL:
				setUriModel(URI_MODEL_EDEFAULT);
				return;
			case TracesPackage.MODEL__MODEL_ROOT:
				setModelRoot((EObject)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TracesPackage.MODEL__URI_MODEL:
				return URI_MODEL_EDEFAULT == null ? uriModel != null : !URI_MODEL_EDEFAULT.equals(uriModel);
			case TracesPackage.MODEL__MODEL_ROOT:
				return modelRoot != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (uriModel: ");
		result.append(uriModel);
		result.append(')');
		return result.toString();
	}

} //ModelImpl
