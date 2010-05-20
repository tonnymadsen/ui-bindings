/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.internal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.IModelClassInfo;
import com.rcpcompany.uibindings.IUIBindingsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>String To Model Class Info Map Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.StringToModelClassInfoMapEntryImpl#getTypedKey <em>Key</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.StringToModelClassInfoMapEntryImpl#getTypedValue <em>Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class StringToModelClassInfoMapEntryImpl extends EObjectImpl implements BasicEMap.Entry<String, IModelClassInfo> {
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
	 * The cached value of the '{@link #getTypedValue() <em>Value</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTypedValue()
	 * @generated
	 * @ordered
	 */
	protected IModelClassInfo value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StringToModelClassInfoMapEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY;
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
					IUIBindingsPackage.STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY__KEY, oldKey, key));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IModelClassInfo getTypedValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTypedValue(IModelClassInfo newValue) {
		final IModelClassInfo oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY__VALUE, oldValue, value));
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
		case IUIBindingsPackage.STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY__KEY:
			return getTypedKey();
		case IUIBindingsPackage.STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY__VALUE:
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
		case IUIBindingsPackage.STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY__KEY:
			setTypedKey((String) newValue);
			return;
		case IUIBindingsPackage.STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY__VALUE:
			setTypedValue((IModelClassInfo) newValue);
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
		case IUIBindingsPackage.STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY__KEY:
			setTypedKey(KEY_EDEFAULT);
			return;
		case IUIBindingsPackage.STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY__VALUE:
			setTypedValue((IModelClassInfo) null);
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
		case IUIBindingsPackage.STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY__KEY:
			return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
		case IUIBindingsPackage.STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY__VALUE:
			return value != null;
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
	public IModelClassInfo getValue() {
		return getTypedValue();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IModelClassInfo setValue(IModelClassInfo value) {
		final IModelClassInfo oldValue = getValue();
		setTypedValue(value);
		return oldValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<String, IModelClassInfo> getEMap() {
		final EObject container = eContainer();
		return container == null ? null : (EMap<String, IModelClassInfo>) container.eGet(eContainmentFeature());
	}

} // StringToModelClassInfoMapEntryImpl
