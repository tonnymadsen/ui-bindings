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
package com.rcpcompany.uibindings.internal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.rcpcompany.uibindings.IModelClassInfo;
import com.rcpcompany.uibindings.IModelFeatureInfo;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.utils.basic.ClassUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Model Feature Info</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.ModelFeatureInfoImpl#getFeatureName <em>Feature
 * Name</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ModelFeatureInfoImpl#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ModelFeatureInfoImpl extends ModelInfoImpl implements IModelFeatureInfo {
	/**
	 * The default value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected String featureName = FEATURE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected IModelClassInfo class_;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelFeatureInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.MODEL_FEATURE_INFO;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getFeatureName() {
		return featureName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setFeatureName(String newFeatureName) {
		final String oldFeatureName = featureName;
		featureName = newFeatureName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.MODEL_FEATURE_INFO__FEATURE_NAME,
					oldFeatureName, featureName));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IModelClassInfo getClass_() {
		if (class_ != null && class_.eIsProxy()) {
			final InternalEObject oldClass = (InternalEObject) class_;
			class_ = (IModelClassInfo) eResolveProxy(oldClass);
			if (class_ != oldClass) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							IUIBindingsPackage.MODEL_FEATURE_INFO__CLASS, oldClass, class_));
				}
			}
		}
		return class_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IModelClassInfo basicGetClass() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setClass(IModelClassInfo newClass) {
		final IModelClassInfo oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.MODEL_FEATURE_INFO__CLASS,
					oldClass, class_));
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
		case IUIBindingsPackage.MODEL_FEATURE_INFO__FEATURE_NAME:
			return getFeatureName();
		case IUIBindingsPackage.MODEL_FEATURE_INFO__CLASS:
			if (resolve) return getClass_();
			return basicGetClass();
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
		case IUIBindingsPackage.MODEL_FEATURE_INFO__FEATURE_NAME:
			setFeatureName((String) newValue);
			return;
		case IUIBindingsPackage.MODEL_FEATURE_INFO__CLASS:
			setClass((IModelClassInfo) newValue);
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
		case IUIBindingsPackage.MODEL_FEATURE_INFO__FEATURE_NAME:
			setFeatureName(FEATURE_NAME_EDEFAULT);
			return;
		case IUIBindingsPackage.MODEL_FEATURE_INFO__CLASS:
			setClass((IModelClassInfo) null);
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
		case IUIBindingsPackage.MODEL_FEATURE_INFO__FEATURE_NAME:
			return FEATURE_NAME_EDEFAULT == null ? featureName != null : !FEATURE_NAME_EDEFAULT.equals(featureName);
		case IUIBindingsPackage.MODEL_FEATURE_INFO__CLASS:
			return class_ != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		final String cinfo = getClass_() != null ? getClass_().getClassName() : "<no class>";
		return ClassUtils.getLastClassName(this)
				+ "[" + cinfo + "." + getFeatureName() + "]#" + System.identityHashCode(this); //$NON-NLS-1$ //$NON-NLS-2$
	}

} // ModelFeatureInfoImpl
