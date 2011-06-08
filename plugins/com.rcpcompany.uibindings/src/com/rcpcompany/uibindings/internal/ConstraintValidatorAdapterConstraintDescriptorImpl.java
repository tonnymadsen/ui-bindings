/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.internal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.IConstraintValidatorAdapterConstraintDescriptor;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.validators.IConstraintValidatorAdapterConstraintProvider;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Constraint Validator Adapter Constraint Descriptor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.ConstraintValidatorAdapterConstraintDescriptorImpl#getPriority
 * <em>Priority</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.ConstraintValidatorAdapterConstraintDescriptorImpl#getProvider
 * <em>Provider</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ConstraintValidatorAdapterConstraintDescriptorImpl extends EObjectImpl implements
		IConstraintValidatorAdapterConstraintDescriptor {
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
	 * The cached value of the '{@link #getProvider() <em>Provider</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected CEObjectHolder<IConstraintValidatorAdapterConstraintProvider> provider;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConstraintValidatorAdapterConstraintDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.CONSTRAINT_VALIDATOR_ADAPTER_CONSTRAINT_DESCRIPTOR;
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
					IUIBindingsPackage.CONSTRAINT_VALIDATOR_ADAPTER_CONSTRAINT_DESCRIPTOR__PRIORITY, oldPriority,
					priority));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public CEObjectHolder<IConstraintValidatorAdapterConstraintProvider> getProvider() {
		return provider;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setProvider(CEObjectHolder<IConstraintValidatorAdapterConstraintProvider> newProvider) {
		final CEObjectHolder<IConstraintValidatorAdapterConstraintProvider> oldProvider = provider;
		provider = newProvider;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.CONSTRAINT_VALIDATOR_ADAPTER_CONSTRAINT_DESCRIPTOR__PROVIDER, oldProvider,
					provider));
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
		case IUIBindingsPackage.CONSTRAINT_VALIDATOR_ADAPTER_CONSTRAINT_DESCRIPTOR__PRIORITY:
			return getPriority();
		case IUIBindingsPackage.CONSTRAINT_VALIDATOR_ADAPTER_CONSTRAINT_DESCRIPTOR__PROVIDER:
			return getProvider();
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
		case IUIBindingsPackage.CONSTRAINT_VALIDATOR_ADAPTER_CONSTRAINT_DESCRIPTOR__PRIORITY:
			setPriority((Integer) newValue);
			return;
		case IUIBindingsPackage.CONSTRAINT_VALIDATOR_ADAPTER_CONSTRAINT_DESCRIPTOR__PROVIDER:
			setProvider((CEObjectHolder<IConstraintValidatorAdapterConstraintProvider>) newValue);
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
		case IUIBindingsPackage.CONSTRAINT_VALIDATOR_ADAPTER_CONSTRAINT_DESCRIPTOR__PRIORITY:
			setPriority(PRIORITY_EDEFAULT);
			return;
		case IUIBindingsPackage.CONSTRAINT_VALIDATOR_ADAPTER_CONSTRAINT_DESCRIPTOR__PROVIDER:
			setProvider((CEObjectHolder<IConstraintValidatorAdapterConstraintProvider>) null);
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
		case IUIBindingsPackage.CONSTRAINT_VALIDATOR_ADAPTER_CONSTRAINT_DESCRIPTOR__PRIORITY:
			return priority != PRIORITY_EDEFAULT;
		case IUIBindingsPackage.CONSTRAINT_VALIDATOR_ADAPTER_CONSTRAINT_DESCRIPTOR__PROVIDER:
			return provider != null;
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
		result.append(", provider: "); //$NON-NLS-1$
		result.append(provider);
		result.append(')');
		return result.toString();
	}

} // ConstraintValidatorAdapterConstraintDescriptorImpl
