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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.swt.widgets.Control;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IBindingMessageTarget;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.utils.basic.ClassUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Binding Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.BindingMessageImpl#getBinding <em>Binding</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.BindingMessageImpl#getMessage <em>Message</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.BindingMessageImpl#getSeverity <em>Severity</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.BindingMessageImpl#getMessageType <em>Message Type
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.BindingMessageImpl#getPrefix <em>Prefix</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.BindingMessageImpl#getTargets <em>Targets</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.BindingMessageImpl#getData <em>Data</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.BindingMessageImpl#getSource <em>Source</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.BindingMessageImpl#getCode <em>Code</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.BindingMessageImpl#getDetails <em>Details</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class BindingMessageImpl extends EObjectImpl implements IBindingMessage {
	/**
	 * The cached value of the '{@link #getBinding() <em>Binding</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBinding()
	 * @generated
	 * @ordered
	 */
	protected IValueBinding binding;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final BindingMessageSeverity SEVERITY_EDEFAULT = BindingMessageSeverity.NONE;

	/**
	 * The default value of the '{@link #getMessageType() <em>Message Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMessageType()
	 * @generated
	 * @ordered
	 */
	protected static final int MESSAGE_TYPE_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargets() <em>Targets</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<IBindingMessageTarget> targets;

	/**
	 * The default value of the '{@link #getData() <em>Data</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected static final Object DATA_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSource() <em>Source</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getCode() <em>Code</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected static final int CODE_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getDetails() <em>Details</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDetails()
	 * @generated
	 * @ordered
	 */
	protected static final String DETAILS_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BindingMessageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.BINDING_MESSAGE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IValueBinding getBinding() {
		return binding;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setBinding(IValueBinding newBinding) {
		final IValueBinding oldBinding = binding;
		binding = newBinding;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.BINDING_MESSAGE__BINDING,
					oldBinding, binding));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getPrefix() {
		return ""; //$NON-NLS-1$
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IBindingMessageTarget> getTargets() {
		if (targets == null) {
			targets = new EObjectEList<IBindingMessageTarget>(IBindingMessageTarget.class, this,
					IUIBindingsPackage.BINDING_MESSAGE__TARGETS);
		}
		return targets;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object getData() {
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getSource() {
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public int getCode() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getDetails() {
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IUIBindingsPackage.BINDING_MESSAGE__BINDING:
			return getBinding();
		case IUIBindingsPackage.BINDING_MESSAGE__MESSAGE:
			return getMessage();
		case IUIBindingsPackage.BINDING_MESSAGE__SEVERITY:
			return getSeverity();
		case IUIBindingsPackage.BINDING_MESSAGE__MESSAGE_TYPE:
			return getMessageType();
		case IUIBindingsPackage.BINDING_MESSAGE__PREFIX:
			return getPrefix();
		case IUIBindingsPackage.BINDING_MESSAGE__TARGETS:
			return getTargets();
		case IUIBindingsPackage.BINDING_MESSAGE__DATA:
			return getData();
		case IUIBindingsPackage.BINDING_MESSAGE__SOURCE:
			return getSource();
		case IUIBindingsPackage.BINDING_MESSAGE__CODE:
			return getCode();
		case IUIBindingsPackage.BINDING_MESSAGE__DETAILS:
			return getDetails();
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
		case IUIBindingsPackage.BINDING_MESSAGE__BINDING:
			setBinding((IValueBinding) newValue);
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
		case IUIBindingsPackage.BINDING_MESSAGE__BINDING:
			setBinding((IValueBinding) null);
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
		case IUIBindingsPackage.BINDING_MESSAGE__BINDING:
			return binding != null;
		case IUIBindingsPackage.BINDING_MESSAGE__MESSAGE:
			return MESSAGE_EDEFAULT == null ? getMessage() != null : !MESSAGE_EDEFAULT.equals(getMessage());
		case IUIBindingsPackage.BINDING_MESSAGE__SEVERITY:
			return getSeverity() != SEVERITY_EDEFAULT;
		case IUIBindingsPackage.BINDING_MESSAGE__MESSAGE_TYPE:
			return getMessageType() != MESSAGE_TYPE_EDEFAULT;
		case IUIBindingsPackage.BINDING_MESSAGE__PREFIX:
			return PREFIX_EDEFAULT == null ? getPrefix() != null : !PREFIX_EDEFAULT.equals(getPrefix());
		case IUIBindingsPackage.BINDING_MESSAGE__TARGETS:
			return targets != null && !targets.isEmpty();
		case IUIBindingsPackage.BINDING_MESSAGE__DATA:
			return DATA_EDEFAULT == null ? getData() != null : !DATA_EDEFAULT.equals(getData());
		case IUIBindingsPackage.BINDING_MESSAGE__SOURCE:
			return SOURCE_EDEFAULT == null ? getSource() != null : !SOURCE_EDEFAULT.equals(getSource());
		case IUIBindingsPackage.BINDING_MESSAGE__CODE:
			return getCode() != CODE_EDEFAULT;
		case IUIBindingsPackage.BINDING_MESSAGE__DETAILS:
			return DETAILS_EDEFAULT == null ? getDetails() != null : !DETAILS_EDEFAULT.equals(getDetails());
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean supersedes(IBindingMessage otherMessage) {
		return false;
	}

	@Override
	public boolean matches(EObject obj, EStructuralFeature feature, Object key, FeatureMatchingAlgorithm algorithm) {
		if (!eIsSet(IUIBindingsPackage.Literals.BINDING_MESSAGE__TARGETS)) return false;
		for (final IBindingMessageTarget target : getTargets()) {
			if (target.getModelObject() != obj) {
				continue;
			}
			switch (algorithm) {
			case IGNORE:
				return true;
			case EXACT_OR_NULL:
				if (target.getModelFeature() == null) return true;
				//$FALL-THROUGH$
			case EXACT:
				/*
				 * If we match against a specific key, then test for at match in the targets;
				 * otherwise ignore the key
				 */
				if (key != null && target.getModelKey() != key) {
					continue;
				}
				if (target.getModelFeature() == feature) return true;
			}
		}
		return false;
	}

	@Override
	public Control getControl() {
		return null;
	}

	@Override
	public Object getKey() {
		return null;
	}

	@Override
	public String getMessage() {
		return null;
	}

	@Override
	public final int getMessageType() {
		return getSeverity().getValue();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NONE
	 */
	@Override
	public BindingMessageSeverity getSeverity() {
		return BindingMessageSeverity.NONE;
	}

	@Override
	public String toString() {
		return ClassUtils.getLastClassName(this) + "[" + getSeverity().getLiteral() + ": " + getMessage() + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
} // BindingMessageImpl
