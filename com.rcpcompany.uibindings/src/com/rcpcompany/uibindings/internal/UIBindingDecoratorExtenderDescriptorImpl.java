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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.IUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>UI Binding Decorator Extender Descriptor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.UIBindingDecoratorExtenderDescriptorImpl#getPriority
 * <em>Priority</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.UIBindingDecoratorExtenderDescriptorImpl#getFactory
 * <em>Factory</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class UIBindingDecoratorExtenderDescriptorImpl extends EObjectImpl implements
		IUIBindingDecoratorExtenderDescriptor {
	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFactory() <em>Factory</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFactory()
	 * @generated
	 * @ordered
	 */
	protected CEObjectHolder<IUIBindingDecoratorExtender> factory;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UIBindingDecoratorExtenderDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR;
	}

	private Map<String, Object> myDeclaredArguments = null;

	@Override
	public Map<String, Object> getArguments() {
		if (myDeclaredArguments == null) {
			myDeclaredArguments = new HashMap<String, Object>();
		}
		return myDeclaredArguments;
	}

	@Override
	public boolean hasArguments() {
		return myDeclaredArguments != null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setPriority(int newPriority) {
		final int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__PRIORITY, oldPriority, priority));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public CEObjectHolder<IUIBindingDecoratorExtender> getFactory() {
		return factory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setFactory(CEObjectHolder<IUIBindingDecoratorExtender> newFactory) {
		final CEObjectHolder<IUIBindingDecoratorExtender> oldFactory = factory;
		factory = newFactory;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__FACTORY, oldFactory, factory));
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
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__PRIORITY:
			return getPriority();
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__FACTORY:
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
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__PRIORITY:
			setPriority((Integer) newValue);
			return;
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__FACTORY:
			setFactory((CEObjectHolder<IUIBindingDecoratorExtender>) newValue);
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
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__PRIORITY:
			setPriority(PRIORITY_EDEFAULT);
			return;
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__FACTORY:
			setFactory((CEObjectHolder<IUIBindingDecoratorExtender>) null);
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
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__PRIORITY:
			return priority != PRIORITY_EDEFAULT;
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__FACTORY:
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
		result.append(" (priority: "); //$NON-NLS-1$
		result.append(priority);
		result.append(", factory: "); //$NON-NLS-1$
		result.append(factory);
		result.append(')');
		return result.toString();
	}

} // UIBindingDecoratorExtenderDescriptorImpl
