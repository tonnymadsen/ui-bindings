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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.IEnumDecoratorProviderEntry;
import com.rcpcompany.uibindings.IUIBindingsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Enum Decorator Provider Entry</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.EnumDecoratorProviderEntryImpl#getModel <em>Model
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.EnumDecoratorProviderEntryImpl#getUi <em>Ui</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EnumDecoratorProviderEntryImpl extends EObjectImpl implements IEnumDecoratorProviderEntry {
	/**
	 * The default value of the '{@link #getModel() <em>Model</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected String model = MODEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getUi() <em>Ui</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getUi()
	 * @generated
	 * @ordered
	 */
	protected static final String UI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUi() <em>Ui</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getUi()
	 * @generated
	 * @ordered
	 */
	protected String ui = UI_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EnumDecoratorProviderEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.ENUM_DECORATOR_PROVIDER_ENTRY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setModel(String newModel) {
		final String oldModel = model;
		model = newModel;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.ENUM_DECORATOR_PROVIDER_ENTRY__MODEL, oldModel, model));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getUi() {
		return ui;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setUi(String newUi) {
		final String oldUi = ui;
		ui = newUi;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.ENUM_DECORATOR_PROVIDER_ENTRY__UI,
					oldUi, ui));
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
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER_ENTRY__MODEL:
			return getModel();
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER_ENTRY__UI:
			return getUi();
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
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER_ENTRY__MODEL:
			setModel((String) newValue);
			return;
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER_ENTRY__UI:
			setUi((String) newValue);
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
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER_ENTRY__MODEL:
			setModel(MODEL_EDEFAULT);
			return;
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER_ENTRY__UI:
			setUi(UI_EDEFAULT);
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
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER_ENTRY__MODEL:
			return MODEL_EDEFAULT == null ? model != null : !MODEL_EDEFAULT.equals(model);
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER_ENTRY__UI:
			return UI_EDEFAULT == null ? ui != null : !UI_EDEFAULT.equals(ui);
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
		result.append(" (model: "); //$NON-NLS-1$
		result.append(model);
		result.append(", ui: "); //$NON-NLS-1$
		result.append(ui);
		result.append(')');
		return result.toString();
	}

} // EnumDecoratorProviderEntryImpl
