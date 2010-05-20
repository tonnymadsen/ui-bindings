/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.internal;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.IUIBindingsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>String To IConfiguration Element Map Entry</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.StringToIConfigurationElementMapEntryImpl#getTypedKey <em>Key</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.StringToIConfigurationElementMapEntryImpl#getTypedValue <em>Value</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class StringToIConfigurationElementMapEntryImpl extends EObjectImpl implements
		BasicEMap.Entry<String, IConfigurationElement> {
	/**
	 * The default value of the '{@link #getTypedKey() <em>Key</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTypedKey()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypedKey() <em>Key</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTypedKey()
	 * @generated
	 * @ordered
	 */
	protected String key = KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypedValue() <em>Value</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTypedValue()
	 * @generated
	 * @ordered
	 */
	protected static final IConfigurationElement VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypedValue() <em>Value</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTypedValue()
	 * @generated
	 * @ordered
	 */
	protected IConfigurationElement value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StringToIConfigurationElementMapEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getTypedKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTypedKey(String newKey) {
		final String oldKey = key;
		key = newKey;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY__KEY, oldKey, key));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IConfigurationElement getTypedValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTypedValue(IConfigurationElement newValue) {
		final IConfigurationElement oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY__VALUE, oldValue, value));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IUIBindingsPackage.STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY__KEY:
			return getTypedKey();
		case IUIBindingsPackage.STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY__VALUE:
			return getTypedValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case IUIBindingsPackage.STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY__KEY:
			setTypedKey((String) newValue);
			return;
		case IUIBindingsPackage.STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY__VALUE:
			setTypedValue((IConfigurationElement) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case IUIBindingsPackage.STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY__KEY:
			setTypedKey(KEY_EDEFAULT);
			return;
		case IUIBindingsPackage.STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY__VALUE:
			setTypedValue(VALUE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case IUIBindingsPackage.STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY__KEY:
			return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
		case IUIBindingsPackage.STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY__VALUE:
			return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (key: "); //$NON-NLS-1$
		result.append(key);
		result.append(", value: "); //$NON-NLS-1$
		result.append(value);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected int hash = -1;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getHash() {
		if (hash == -1) {
			final Object theKey = getKey();
			hash = (theKey == null ? 0 : theKey.hashCode());
		}
		return hash;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setHash(int hash) {
		this.hash = hash;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getKey() {
		return getTypedKey();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setKey(String key) {
		setTypedKey(key);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IConfigurationElement getValue() {
		return getTypedValue();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IConfigurationElement setValue(IConfigurationElement value) {
		final IConfigurationElement oldValue = getValue();
		setTypedValue(value);
		return oldValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<String, IConfigurationElement> getEMap() {
		final EObject container = eContainer();
		return container == null ? null : (EMap<String, IConfigurationElement>) container.eGet(eContainmentFeature());
	}

} // StringToIConfigurationElementMapEntryImpl
