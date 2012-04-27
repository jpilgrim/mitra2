/**
 * (C) 2012 Jens von Pilgrim
 */
package de.jevopi.mitra2.traces.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.jevopi.mitra2.traces.Trace;
import de.jevopi.mitra2.traces.TraceElement;
import de.jevopi.mitra2.traces.TracesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.jevopi.mitra2.traces.impl.TraceImpl#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link de.jevopi.mitra2.traces.impl.TraceImpl#getRuleName <em>Rule Name</em>}</li>
 *   <li>{@link de.jevopi.mitra2.traces.impl.TraceImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link de.jevopi.mitra2.traces.impl.TraceImpl#getRuleInfo <em>Rule Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceImpl extends EObjectImpl implements Trace {
	/**
	 * The default value of the '{@link #getTimestamp() <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected static final long TIMESTAMP_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTimestamp() <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected long timestamp = TIMESTAMP_EDEFAULT;

	/**
	 * The default value of the '{@link #getRuleName() <em>Rule Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleName()
	 * @generated
	 * @ordered
	 */
	protected static final String RULE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRuleName() <em>Rule Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleName()
	 * @generated
	 * @ordered
	 */
	protected String ruleName = RULE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TraceElement> elements;

	/**
	 * The default value of the '{@link #getRuleInfo() <em>Rule Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleInfo()
	 * @generated
	 * @ordered
	 */
	protected static final String RULE_INFO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRuleInfo() <em>Rule Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleInfo()
	 * @generated
	 * @ordered
	 */
	protected String ruleInfo = RULE_INFO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracesPackage.Literals.TRACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimestamp(long newTimestamp) {
		long oldTimestamp = timestamp;
		timestamp = newTimestamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracesPackage.TRACE__TIMESTAMP, oldTimestamp, timestamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRuleName() {
		return ruleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuleName(String newRuleName) {
		String oldRuleName = ruleName;
		ruleName = newRuleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracesPackage.TRACE__RULE_NAME, oldRuleName, ruleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TraceElement> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<TraceElement>(TraceElement.class, this, TracesPackage.TRACE__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRuleInfo() {
		return ruleInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuleInfo(String newRuleInfo) {
		String oldRuleInfo = ruleInfo;
		ruleInfo = newRuleInfo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracesPackage.TRACE__RULE_INFO, oldRuleInfo, ruleInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracesPackage.TRACE__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TracesPackage.TRACE__TIMESTAMP:
				return getTimestamp();
			case TracesPackage.TRACE__RULE_NAME:
				return getRuleName();
			case TracesPackage.TRACE__ELEMENTS:
				return getElements();
			case TracesPackage.TRACE__RULE_INFO:
				return getRuleInfo();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TracesPackage.TRACE__TIMESTAMP:
				setTimestamp((Long)newValue);
				return;
			case TracesPackage.TRACE__RULE_NAME:
				setRuleName((String)newValue);
				return;
			case TracesPackage.TRACE__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends TraceElement>)newValue);
				return;
			case TracesPackage.TRACE__RULE_INFO:
				setRuleInfo((String)newValue);
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
			case TracesPackage.TRACE__TIMESTAMP:
				setTimestamp(TIMESTAMP_EDEFAULT);
				return;
			case TracesPackage.TRACE__RULE_NAME:
				setRuleName(RULE_NAME_EDEFAULT);
				return;
			case TracesPackage.TRACE__ELEMENTS:
				getElements().clear();
				return;
			case TracesPackage.TRACE__RULE_INFO:
				setRuleInfo(RULE_INFO_EDEFAULT);
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
			case TracesPackage.TRACE__TIMESTAMP:
				return timestamp != TIMESTAMP_EDEFAULT;
			case TracesPackage.TRACE__RULE_NAME:
				return RULE_NAME_EDEFAULT == null ? ruleName != null : !RULE_NAME_EDEFAULT.equals(ruleName);
			case TracesPackage.TRACE__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case TracesPackage.TRACE__RULE_INFO:
				return RULE_INFO_EDEFAULT == null ? ruleInfo != null : !RULE_INFO_EDEFAULT.equals(ruleInfo);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated_not
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (timestamp: ");
		result.append(timestamp);
		result.append(", ruleName: ");
		result.append(ruleName);
		result.append(", ruleInfo: ");
		result.append(ruleInfo);
		result.append(", elements: ");
		result.append(getElements().toString());
		result.append(')');
		return result.toString();
	}

} //TraceImpl
