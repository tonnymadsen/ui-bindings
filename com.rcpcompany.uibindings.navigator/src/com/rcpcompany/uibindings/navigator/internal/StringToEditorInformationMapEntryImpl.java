/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.navigator.internal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.navigator.IEditorInformation;
import com.rcpcompany.uibindings.navigator.INavigatorModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>String To Editor Information Map Entry</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link com.rcpcompany.uibindings.navigator.internal.StringToEditorInformationMapEntryImpl#getTypedKey
 * <em>Key</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.navigator.internal.StringToEditorInformationMapEntryImpl#getTypedValue
 * <em>Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class StringToEditorInformationMapEntryImpl extends EObjectImpl implements
		BasicEMap.Entry<String, IEditorInformation> {
	/**
	 * The default value of the '{@link #getTypedKey() <em>Key</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getTypedKey()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypedKey() <em>Key</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getTypedKey()
	 * @generated
	 * @ordered
	 */
	protected String key = KEY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTypedValue() <em>Value</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTypedValue()
	 * @generated
	 * @ordered
	 */
	protected IEditorInformation value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StringToEditorInformationMapEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return INavigatorModelPackage.Literals.STRING_TO_EDITOR_INFORMATION_MAP_ENTRY;
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
					INavigatorModelPackage.STRING_TO_EDITOR_INFORMATION_MAP_ENTRY__KEY, oldKey, key));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IEditorInformation getTypedValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTypedValue(IEditorInformation newValue) {
		final IEditorInformation oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					INavigatorModelPackage.STRING_TO_EDITOR_INFORMATION_MAP_ENTRY__VALUE, oldValue, value));
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
		case INavigatorModelPackage.STRING_TO_EDITOR_INFORMATION_MAP_ENTRY__KEY:
			return getTypedKey();
		case INavigatorModelPackage.STRING_TO_EDITOR_INFORMATION_MAP_ENTRY__VALUE:
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
		case INavigatorModelPackage.STRING_TO_EDITOR_INFORMATION_MAP_ENTRY__KEY:
			setTypedKey((String) newValue);
			return;
		case INavigatorModelPackage.STRING_TO_EDITOR_INFORMATION_MAP_ENTRY__VALUE:
			setTypedValue((IEditorInformation) newValue);
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
		case INavigatorModelPackage.STRING_TO_EDITOR_INFORMATION_MAP_ENTRY__KEY:
			setTypedKey(KEY_EDEFAULT);
			return;
		case INavigatorModelPackage.STRING_TO_EDITOR_INFORMATION_MAP_ENTRY__VALUE:
			setTypedValue((IEditorInformation) null);
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
		case INavigatorModelPackage.STRING_TO_EDITOR_INFORMATION_MAP_ENTRY__KEY:
			return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
		case INavigatorModelPackage.STRING_TO_EDITOR_INFORMATION_MAP_ENTRY__VALUE:
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
		if (eIsProxy()) return super.toString();

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (key: ");
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
	@Override
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
	@Override
	public void setHash(int hash) {
		this.hash = hash;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getKey() {
		return getTypedKey();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setKey(String key) {
		setTypedKey(key);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IEditorInformation getValue() {
		return getTypedValue();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IEditorInformation setValue(IEditorInformation value) {
		final IEditorInformation oldValue = getValue();
		setTypedValue(value);
		return oldValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<String, IEditorInformation> getEMap() {
		final EObject container = eContainer();
		return container == null ? null : (EMap<String, IEditorInformation>) container.eGet(eContainmentFeature());
	}

} // StringToEditorInformationMapEntryImpl
