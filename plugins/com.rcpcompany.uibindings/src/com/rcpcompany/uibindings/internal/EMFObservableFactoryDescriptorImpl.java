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

import com.rcpcompany.uibindings.IEMFObservableFactory;
import com.rcpcompany.uibindings.IEMFObservableFactoryDescriptor;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>EMF Observable Factory Descriptor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.EMFObservableFactoryDescriptorImpl#getPackagePrefix
 * <em>Package Prefix</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.EMFObservableFactoryDescriptorImpl#getFactory <em>
 * Factory</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EMFObservableFactoryDescriptorImpl extends EObjectImpl implements IEMFObservableFactoryDescriptor {
	/**
	 * The default value of the '{@link #getPackagePrefix() <em>Package Prefix</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPackagePrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackagePrefix() <em>Package Prefix</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPackagePrefix()
	 * @generated
	 * @ordered
	 */
	protected String packagePrefix = PACKAGE_PREFIX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFactory() <em>Factory</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFactory()
	 * @generated
	 * @ordered
	 */
	protected CEObjectHolder<IEMFObservableFactory> factory;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EMFObservableFactoryDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.EMF_OBSERVABLE_FACTORY_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getPackagePrefix() {
		return packagePrefix;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setPackagePrefix(String newPackagePrefix) {
		final String oldPackagePrefix = packagePrefix;
		packagePrefix = newPackagePrefix;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.EMF_OBSERVABLE_FACTORY_DESCRIPTOR__PACKAGE_PREFIX, oldPackagePrefix,
					packagePrefix));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public CEObjectHolder<IEMFObservableFactory> getFactory() {
		return factory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setFactory(CEObjectHolder<IEMFObservableFactory> newFactory) {
		final CEObjectHolder<IEMFObservableFactory> oldFactory = factory;
		factory = newFactory;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.EMF_OBSERVABLE_FACTORY_DESCRIPTOR__FACTORY, oldFactory, factory));
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
		case IUIBindingsPackage.EMF_OBSERVABLE_FACTORY_DESCRIPTOR__PACKAGE_PREFIX:
			return getPackagePrefix();
		case IUIBindingsPackage.EMF_OBSERVABLE_FACTORY_DESCRIPTOR__FACTORY:
			return getFactory();
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
		case IUIBindingsPackage.EMF_OBSERVABLE_FACTORY_DESCRIPTOR__PACKAGE_PREFIX:
			setPackagePrefix((String) newValue);
			return;
		case IUIBindingsPackage.EMF_OBSERVABLE_FACTORY_DESCRIPTOR__FACTORY:
			setFactory((CEObjectHolder<IEMFObservableFactory>) newValue);
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
		case IUIBindingsPackage.EMF_OBSERVABLE_FACTORY_DESCRIPTOR__PACKAGE_PREFIX:
			setPackagePrefix(PACKAGE_PREFIX_EDEFAULT);
			return;
		case IUIBindingsPackage.EMF_OBSERVABLE_FACTORY_DESCRIPTOR__FACTORY:
			setFactory((CEObjectHolder<IEMFObservableFactory>) null);
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
		case IUIBindingsPackage.EMF_OBSERVABLE_FACTORY_DESCRIPTOR__PACKAGE_PREFIX:
			return PACKAGE_PREFIX_EDEFAULT == null ? packagePrefix != null : !PACKAGE_PREFIX_EDEFAULT
					.equals(packagePrefix);
		case IUIBindingsPackage.EMF_OBSERVABLE_FACTORY_DESCRIPTOR__FACTORY:
			return factory != null;
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
		result.append(" (packagePrefix: "); //$NON-NLS-1$
		result.append(packagePrefix);
		result.append(", factory: "); //$NON-NLS-1$
		result.append(factory);
		result.append(')');
		return result.toString();
	}

} // EMFObservableFactoryDescriptorImpl
