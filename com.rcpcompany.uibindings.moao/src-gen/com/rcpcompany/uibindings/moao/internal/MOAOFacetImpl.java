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
package com.rcpcompany.uibindings.moao.internal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.rcpcompany.uibindings.moao.IMOAO;
import com.rcpcompany.uibindings.moao.IMOAOFacet;
import com.rcpcompany.uibindings.moao.IMOAOPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Facet</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.moao.internal.MOAOFacetImpl#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MOAOFacetImpl extends MOAOImpl implements IMOAOFacet {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MOAOFacetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IMOAOPackage.Literals.MOAO_FACET;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IMOAO getObject() {
		if (eContainerFeatureID() != IMOAOPackage.MOAO_FACET__OBJECT) return null;
		return (IMOAO) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetObject(IMOAO newObject, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newObject, IMOAOPackage.MOAO_FACET__OBJECT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setObject(IMOAO newObject) {
		if (newObject != eInternalContainer()
				|| (eContainerFeatureID() != IMOAOPackage.MOAO_FACET__OBJECT && newObject != null)) {
			if (EcoreUtil.isAncestor(this, newObject))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
			if (newObject != null)
				msgs = ((InternalEObject) newObject).eInverseAdd(this, IMOAOPackage.MOAO__FACETS, IMOAO.class, msgs);
			msgs = basicSetObject(newObject, msgs);
			if (msgs != null) msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IMOAOPackage.MOAO_FACET__OBJECT, newObject, newObject));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case IMOAOPackage.MOAO_FACET__OBJECT:
			if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
			return basicSetObject((IMOAO) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case IMOAOPackage.MOAO_FACET__OBJECT:
			return basicSetObject(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case IMOAOPackage.MOAO_FACET__OBJECT:
			return eInternalContainer().eInverseRemove(this, IMOAOPackage.MOAO__FACETS, IMOAO.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IMOAOPackage.MOAO_FACET__OBJECT:
			return getObject();
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
		case IMOAOPackage.MOAO_FACET__OBJECT:
			setObject((IMOAO) newValue);
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
		case IMOAOPackage.MOAO_FACET__OBJECT:
			setObject((IMOAO) null);
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
		case IMOAOPackage.MOAO_FACET__OBJECT:
			return getObject() != null;
		}
		return super.eIsSet(featureID);
	}

} // MOAOFacetImpl
