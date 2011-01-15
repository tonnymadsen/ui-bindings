/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.scripting;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.rcpcompany.uibindings.scripting.IScriptDependency;
import com.rcpcompany.uibindings.scripting.IScriptEnginePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>EObject To Script Dependency List Map Entry</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.scripting.EObjectToScriptDependencyListMapEntryImpl#getTypedKey
 * <em>Key</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.scripting.EObjectToScriptDependencyListMapEntryImpl#getTypedValue
 * <em>Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EObjectToScriptDependencyListMapEntryImpl extends EObjectImpl implements
		BasicEMap.Entry<EObject, EList<IScriptDependency>> {
	/**
	 * The cached value of the '{@link #getTypedKey() <em>Key</em>}' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getTypedKey()
	 * @generated
	 * @ordered
	 */
	protected EObject key;

	/**
	 * The cached value of the '{@link #getTypedValue() <em>Value</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTypedValue()
	 * @generated
	 * @ordered
	 */
	protected EList<IScriptDependency> value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EObjectToScriptDependencyListMapEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IScriptEnginePackage.Literals.EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject getTypedKey() {
		if (key != null && key.eIsProxy()) {
			final InternalEObject oldKey = (InternalEObject) key;
			key = eResolveProxy(oldKey);
			if (key != oldKey) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							IScriptEnginePackage.EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY__KEY, oldKey, key));
				}
			}
		}
		return key;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject basicGetTypedKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTypedKey(EObject newKey) {
		final EObject oldKey = key;
		key = newKey;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IScriptEnginePackage.EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY__KEY, oldKey, key));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<IScriptDependency> getTypedValue() {
		if (value == null) {
			value = new EObjectResolvingEList<IScriptDependency>(IScriptDependency.class, this,
					IScriptEnginePackage.EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IScriptEnginePackage.EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY__KEY:
			if (resolve) return getTypedKey();
			return basicGetTypedKey();
		case IScriptEnginePackage.EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY__VALUE:
			return getTypedValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case IScriptEnginePackage.EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY__KEY:
			setTypedKey((EObject) newValue);
			return;
		case IScriptEnginePackage.EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY__VALUE:
			getTypedValue().clear();
			getTypedValue().addAll((Collection<? extends IScriptDependency>) newValue);
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
		case IScriptEnginePackage.EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY__KEY:
			setTypedKey((EObject) null);
			return;
		case IScriptEnginePackage.EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY__VALUE:
			getTypedValue().clear();
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
		case IScriptEnginePackage.EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY__KEY:
			return key != null;
		case IScriptEnginePackage.EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY__VALUE:
			return value != null && !value.isEmpty();
		}
		return super.eIsSet(featureID);
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
	public EObject getKey() {
		return getTypedKey();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setKey(EObject key) {
		setTypedKey(key);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IScriptDependency> getValue() {
		return getTypedValue();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IScriptDependency> setValue(EList<IScriptDependency> value) {
		final EList<IScriptDependency> oldValue = getValue();
		getTypedValue().clear();
		getTypedValue().addAll(value);
		return oldValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<EObject, EList<IScriptDependency>> getEMap() {
		final EObject container = eContainer();
		return container == null ? null : (EMap<EObject, EList<IScriptDependency>>) container
				.eGet(eContainmentFeature());
	}

} // EObjectToScriptDependencyListMapEntryImpl
