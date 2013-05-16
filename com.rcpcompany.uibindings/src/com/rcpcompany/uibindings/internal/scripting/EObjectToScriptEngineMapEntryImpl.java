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
package com.rcpcompany.uibindings.internal.scripting;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.scripting.IScriptEnginePackage;
import com.rcpcompany.uibindings.scripting.IScriptEvaluationContext;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>EObject To Script Engine Map Entry</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.scripting.EObjectToScriptEngineMapEntryImpl#getTypedKey
 * <em>Key</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.scripting.EObjectToScriptEngineMapEntryImpl#getTypedValue
 * <em>Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EObjectToScriptEngineMapEntryImpl extends EObjectImpl implements
		BasicEMap.Entry<EObject, IScriptEvaluationContext> {
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
	 * The cached value of the '{@link #getTypedValue() <em>Value</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTypedValue()
	 * @generated
	 * @ordered
	 */
	protected IScriptEvaluationContext value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EObjectToScriptEngineMapEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IScriptEnginePackage.Literals.EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject getTypedKey() {
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
					IScriptEnginePackage.EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY__KEY, oldKey, key));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IScriptEvaluationContext getTypedValue() {
		if (value != null && value.eIsProxy()) {
			final InternalEObject oldValue = (InternalEObject) value;
			value = (IScriptEvaluationContext) eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							IScriptEnginePackage.EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY__VALUE, oldValue, value));
				}
			}
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IScriptEvaluationContext basicGetTypedValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTypedValue(IScriptEvaluationContext newValue) {
		final IScriptEvaluationContext oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IScriptEnginePackage.EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY__VALUE, oldValue, value));
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
		case IScriptEnginePackage.EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY__KEY:
			return getTypedKey();
		case IScriptEnginePackage.EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY__VALUE:
			if (resolve) return getTypedValue();
			return basicGetTypedValue();
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
		case IScriptEnginePackage.EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY__KEY:
			setTypedKey((EObject) newValue);
			return;
		case IScriptEnginePackage.EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY__VALUE:
			setTypedValue((IScriptEvaluationContext) newValue);
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
		case IScriptEnginePackage.EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY__KEY:
			setTypedKey((EObject) null);
			return;
		case IScriptEnginePackage.EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY__VALUE:
			setTypedValue((IScriptEvaluationContext) null);
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
		case IScriptEnginePackage.EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY__KEY:
			return key != null;
		case IScriptEnginePackage.EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY__VALUE:
			return value != null;
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
	public IScriptEvaluationContext getValue() {
		return getTypedValue();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IScriptEvaluationContext setValue(IScriptEvaluationContext value) {
		final IScriptEvaluationContext oldValue = getValue();
		setTypedValue(value);
		return oldValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<EObject, IScriptEvaluationContext> getEMap() {
		final EObject container = eContainer();
		return container == null ? null : (EMap<EObject, IScriptEvaluationContext>) container
				.eGet(eContainmentFeature());
	}

} // EObjectToScriptEngineMapEntryImpl
