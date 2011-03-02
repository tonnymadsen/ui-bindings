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
package com.rcpcompany.uibindings.internal;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EClass;

import com.rcpcompany.uibindings.IContainerBinding;
import com.rcpcompany.uibindings.IUIBindingsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Container Binding</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.ContainerBindingImpl#getSingleSelection <em>Single
 * Selection</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class ContainerBindingImpl extends BindingImpl implements IContainerBinding {
	/**
	 * The default value of the '{@link #getSingleSelection() <em>Single Selection</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSingleSelection()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableValue SINGLE_SELECTION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSingleSelection() <em>Single Selection</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSingleSelection()
	 * @generated
	 * @ordered
	 */
	protected IObservableValue singleSelection = SINGLE_SELECTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ContainerBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.CONTAINER_BINDING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IObservableValue getSingleSelection() {
		return singleSelection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IUIBindingsPackage.CONTAINER_BINDING__SINGLE_SELECTION:
			return getSingleSelection();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case IUIBindingsPackage.CONTAINER_BINDING__SINGLE_SELECTION:
			return SINGLE_SELECTION_EDEFAULT == null ? singleSelection != null : !SINGLE_SELECTION_EDEFAULT
					.equals(singleSelection);
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
		result.append(" (singleSelection: "); //$NON-NLS-1$
		result.append(singleSelection);
		result.append(')');
		return result.toString();
	}

} // ContainerBindingImpl
