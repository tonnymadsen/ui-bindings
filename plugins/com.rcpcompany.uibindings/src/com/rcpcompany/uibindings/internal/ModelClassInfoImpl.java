/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.IModelClassInfo;
import com.rcpcompany.uibindings.IModelFeatureInfo;
import com.rcpcompany.uibindings.IUIBindingsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Model Class Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.ModelClassInfoImpl#getClassName <em>Class Name
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ModelClassInfoImpl#getFeatures <em>Features</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ModelClassInfoImpl#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ModelClassInfoImpl extends ModelInfoImpl implements IModelClassInfo {
	/**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected String className = CLASS_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' map. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, IModelFeatureInfo> features;

	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' map. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, IModelClassInfo> types;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelClassInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.MODEL_CLASS_INFO;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getClassName() {
		return className;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setClassName(String newClassName) {
		final String oldClassName = className;
		className = newClassName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.MODEL_CLASS_INFO__CLASS_NAME,
					oldClassName, className));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EMap<String, IModelFeatureInfo> getFeatures() {
		if (features == null) {
			features = new EcoreEMap<String, IModelFeatureInfo>(
					IUIBindingsPackage.Literals.STRING_TO_MODEL_FEATURE_INFO_MAP_ENTRY,
					StringToModelFeatureInfoMapEntryImpl.class, this, IUIBindingsPackage.MODEL_CLASS_INFO__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EMap<String, IModelClassInfo> getTypes() {
		if (types == null) {
			types = new EcoreEMap<String, IModelClassInfo>(
					IUIBindingsPackage.Literals.STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY,
					StringToModelClassInfoMapEntryImpl.class, this, IUIBindingsPackage.MODEL_CLASS_INFO__TYPES);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case IUIBindingsPackage.MODEL_CLASS_INFO__FEATURES:
			return ((InternalEList<?>) getFeatures()).basicRemove(otherEnd, msgs);
		case IUIBindingsPackage.MODEL_CLASS_INFO__TYPES:
			return ((InternalEList<?>) getTypes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IUIBindingsPackage.MODEL_CLASS_INFO__CLASS_NAME:
			return getClassName();
		case IUIBindingsPackage.MODEL_CLASS_INFO__FEATURES:
			if (coreType)
				return getFeatures();
			else
				return getFeatures().map();
		case IUIBindingsPackage.MODEL_CLASS_INFO__TYPES:
			if (coreType)
				return getTypes();
			else
				return getTypes().map();
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
		case IUIBindingsPackage.MODEL_CLASS_INFO__CLASS_NAME:
			setClassName((String) newValue);
			return;
		case IUIBindingsPackage.MODEL_CLASS_INFO__FEATURES:
			((EStructuralFeature.Setting) getFeatures()).set(newValue);
			return;
		case IUIBindingsPackage.MODEL_CLASS_INFO__TYPES:
			((EStructuralFeature.Setting) getTypes()).set(newValue);
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
		case IUIBindingsPackage.MODEL_CLASS_INFO__CLASS_NAME:
			setClassName(CLASS_NAME_EDEFAULT);
			return;
		case IUIBindingsPackage.MODEL_CLASS_INFO__FEATURES:
			getFeatures().clear();
			return;
		case IUIBindingsPackage.MODEL_CLASS_INFO__TYPES:
			getTypes().clear();
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
		case IUIBindingsPackage.MODEL_CLASS_INFO__CLASS_NAME:
			return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
		case IUIBindingsPackage.MODEL_CLASS_INFO__FEATURES:
			return features != null && !features.isEmpty();
		case IUIBindingsPackage.MODEL_CLASS_INFO__TYPES:
			return types != null && !types.isEmpty();
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
		return getClass().getSimpleName() + "[" + getClassName() + "]";
	}

} // ModelClassInfoImpl
