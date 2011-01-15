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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>UI Attribute Factory Descriptor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeFactoryDescriptorImpl#getTypeName <em>
 * Type Name</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeFactoryDescriptorImpl#getAttribute <em>
 * Attribute</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.UIAttributeFactoryDescriptorImpl#getFactory <em>
 * Factory</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class UIAttributeFactoryDescriptorImpl extends EObjectImpl implements IUIAttributeFactoryDescriptor {
	/**
	 * The default value of the '{@link #getTypeName() <em>Type Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected String typeName = TYPE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttribute() <em>Attribute</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected String attribute = ATTRIBUTE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFactory() <em>Factory</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFactory()
	 * @generated
	 * @ordered
	 */
	protected CEObjectHolder<IUIAttributeFactory> factory;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UIAttributeFactoryDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.UI_ATTRIBUTE_FACTORY_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getTypeName() {
		return typeName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setTypeName(String newTypeName) {
		final String oldTypeName = typeName;
		typeName = newTypeName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.UI_ATTRIBUTE_FACTORY_DESCRIPTOR__TYPE_NAME, oldTypeName, typeName));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getAttribute() {
		return attribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setAttribute(String newAttribute) {
		final String oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.UI_ATTRIBUTE_FACTORY_DESCRIPTOR__ATTRIBUTE, oldAttribute, attribute));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public CEObjectHolder<IUIAttributeFactory> getFactory() {
		return factory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setFactory(CEObjectHolder<IUIAttributeFactory> newFactory) {
		final CEObjectHolder<IUIAttributeFactory> oldFactory = factory;
		factory = newFactory;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.UI_ATTRIBUTE_FACTORY_DESCRIPTOR__FACTORY, oldFactory, factory));
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
		case IUIBindingsPackage.UI_ATTRIBUTE_FACTORY_DESCRIPTOR__TYPE_NAME:
			return getTypeName();
		case IUIBindingsPackage.UI_ATTRIBUTE_FACTORY_DESCRIPTOR__ATTRIBUTE:
			return getAttribute();
		case IUIBindingsPackage.UI_ATTRIBUTE_FACTORY_DESCRIPTOR__FACTORY:
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
		case IUIBindingsPackage.UI_ATTRIBUTE_FACTORY_DESCRIPTOR__TYPE_NAME:
			setTypeName((String) newValue);
			return;
		case IUIBindingsPackage.UI_ATTRIBUTE_FACTORY_DESCRIPTOR__ATTRIBUTE:
			setAttribute((String) newValue);
			return;
		case IUIBindingsPackage.UI_ATTRIBUTE_FACTORY_DESCRIPTOR__FACTORY:
			setFactory((CEObjectHolder<IUIAttributeFactory>) newValue);
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
		case IUIBindingsPackage.UI_ATTRIBUTE_FACTORY_DESCRIPTOR__TYPE_NAME:
			setTypeName(TYPE_NAME_EDEFAULT);
			return;
		case IUIBindingsPackage.UI_ATTRIBUTE_FACTORY_DESCRIPTOR__ATTRIBUTE:
			setAttribute(ATTRIBUTE_EDEFAULT);
			return;
		case IUIBindingsPackage.UI_ATTRIBUTE_FACTORY_DESCRIPTOR__FACTORY:
			setFactory((CEObjectHolder<IUIAttributeFactory>) null);
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
		case IUIBindingsPackage.UI_ATTRIBUTE_FACTORY_DESCRIPTOR__TYPE_NAME:
			return TYPE_NAME_EDEFAULT == null ? typeName != null : !TYPE_NAME_EDEFAULT.equals(typeName);
		case IUIBindingsPackage.UI_ATTRIBUTE_FACTORY_DESCRIPTOR__ATTRIBUTE:
			return ATTRIBUTE_EDEFAULT == null ? attribute != null : !ATTRIBUTE_EDEFAULT.equals(attribute);
		case IUIBindingsPackage.UI_ATTRIBUTE_FACTORY_DESCRIPTOR__FACTORY:
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
		result.append(" (typeName: "); //$NON-NLS-1$
		result.append(typeName);
		result.append(", attribute: "); //$NON-NLS-1$
		result.append(attribute);
		result.append(", factory: "); //$NON-NLS-1$
		result.append(factory);
		result.append(')');
		return result.toString();
	}

} // UIAttributeFactoryDescriptorImpl
