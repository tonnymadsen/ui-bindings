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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.navigator.INavigatorDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorModelPackage;
import com.rcpcompany.uibindings.navigator.views.INavigatorBaseViewAdvisor;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Navigator Descriptor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.navigator.internal.NavigatorDescriptorImpl#getId <em>Id
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.navigator.internal.NavigatorDescriptorImpl#getAdvisor <em>
 * Advisor</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class NavigatorDescriptorImpl extends EObjectImpl implements INavigatorDescriptor {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAdvisor() <em>Advisor</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAdvisor()
	 * @generated
	 * @ordered
	 */
	protected CEObjectHolder<INavigatorBaseViewAdvisor> advisor;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected NavigatorDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return INavigatorModelPackage.Literals.NAVIGATOR_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		final String oldId = id;
		id = newId;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, INavigatorModelPackage.NAVIGATOR_DESCRIPTOR__ID,
					oldId, id));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public CEObjectHolder<INavigatorBaseViewAdvisor> getAdvisor() {
		return advisor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setAdvisor(CEObjectHolder<INavigatorBaseViewAdvisor> newAdvisor) {
		final CEObjectHolder<INavigatorBaseViewAdvisor> oldAdvisor = advisor;
		advisor = newAdvisor;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, INavigatorModelPackage.NAVIGATOR_DESCRIPTOR__ADVISOR,
					oldAdvisor, advisor));
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
		case INavigatorModelPackage.NAVIGATOR_DESCRIPTOR__ID:
			return getId();
		case INavigatorModelPackage.NAVIGATOR_DESCRIPTOR__ADVISOR:
			return getAdvisor();
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
		case INavigatorModelPackage.NAVIGATOR_DESCRIPTOR__ID:
			setId((String) newValue);
			return;
		case INavigatorModelPackage.NAVIGATOR_DESCRIPTOR__ADVISOR:
			setAdvisor((CEObjectHolder<INavigatorBaseViewAdvisor>) newValue);
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
		case INavigatorModelPackage.NAVIGATOR_DESCRIPTOR__ID:
			setId(ID_EDEFAULT);
			return;
		case INavigatorModelPackage.NAVIGATOR_DESCRIPTOR__ADVISOR:
			setAdvisor((CEObjectHolder<INavigatorBaseViewAdvisor>) null);
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
		case INavigatorModelPackage.NAVIGATOR_DESCRIPTOR__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case INavigatorModelPackage.NAVIGATOR_DESCRIPTOR__ADVISOR:
			return advisor != null;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", advisor: ");
		result.append(advisor);
		result.append(')');
		return result.toString();
	}

} // NavigatorDescriptorImpl
