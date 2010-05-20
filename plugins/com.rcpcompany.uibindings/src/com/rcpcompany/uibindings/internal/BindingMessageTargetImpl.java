/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.internal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.IBindingMessageTarget;
import com.rcpcompany.uibindings.IUIBindingsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Binding Message Target</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.BindingMessageTargetImpl#getModelObject <em>Model Object</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.BindingMessageTargetImpl#getModelFeature <em>Model Feature</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.BindingMessageTargetImpl#getModelKey <em>Model Key</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class BindingMessageTargetImpl extends EObjectImpl implements IBindingMessageTarget {
	/**
	 * The cached value of the '{@link #getModelObject() <em>Model Object</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getModelObject()
	 * @generated
	 * @ordered
	 */
	protected EObject modelObject;

	/**
	 * The cached value of the '{@link #getModelFeature() <em>Model Feature</em>}' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getModelFeature()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature modelFeature;

	/**
	 * The default value of the '{@link #getModelKey() <em>Model Key</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getModelKey()
	 * @generated
	 * @ordered
	 */
	protected static final Object MODEL_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelKey() <em>Model Key</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getModelKey()
	 * @generated
	 * @ordered
	 */
	protected Object modelKey = MODEL_KEY_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BindingMessageTargetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.BINDING_MESSAGE_TARGET;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject getModelObject() {
		return modelObject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setModelObject(EObject newModelObject) {
		final EObject oldModelObject = modelObject;
		modelObject = newModelObject;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.BINDING_MESSAGE_TARGET__MODEL_OBJECT, oldModelObject, modelObject));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EStructuralFeature getModelFeature() {
		return modelFeature;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setModelFeature(EStructuralFeature newModelFeature) {
		final EStructuralFeature oldModelFeature = modelFeature;
		modelFeature = newModelFeature;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.BINDING_MESSAGE_TARGET__MODEL_FEATURE, oldModelFeature, modelFeature));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object getModelKey() {
		return modelKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setModelKey(Object newModelKey) {
		final Object oldModelKey = modelKey;
		modelKey = newModelKey;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.BINDING_MESSAGE_TARGET__MODEL_KEY,
					oldModelKey, modelKey));
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
		case IUIBindingsPackage.BINDING_MESSAGE_TARGET__MODEL_OBJECT:
			return getModelObject();
		case IUIBindingsPackage.BINDING_MESSAGE_TARGET__MODEL_FEATURE:
			return getModelFeature();
		case IUIBindingsPackage.BINDING_MESSAGE_TARGET__MODEL_KEY:
			return getModelKey();
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
		case IUIBindingsPackage.BINDING_MESSAGE_TARGET__MODEL_OBJECT:
			setModelObject((EObject) newValue);
			return;
		case IUIBindingsPackage.BINDING_MESSAGE_TARGET__MODEL_FEATURE:
			setModelFeature((EStructuralFeature) newValue);
			return;
		case IUIBindingsPackage.BINDING_MESSAGE_TARGET__MODEL_KEY:
			setModelKey(newValue);
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
		case IUIBindingsPackage.BINDING_MESSAGE_TARGET__MODEL_OBJECT:
			setModelObject((EObject) null);
			return;
		case IUIBindingsPackage.BINDING_MESSAGE_TARGET__MODEL_FEATURE:
			setModelFeature((EStructuralFeature) null);
			return;
		case IUIBindingsPackage.BINDING_MESSAGE_TARGET__MODEL_KEY:
			setModelKey(MODEL_KEY_EDEFAULT);
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
		case IUIBindingsPackage.BINDING_MESSAGE_TARGET__MODEL_OBJECT:
			return modelObject != null;
		case IUIBindingsPackage.BINDING_MESSAGE_TARGET__MODEL_FEATURE:
			return modelFeature != null;
		case IUIBindingsPackage.BINDING_MESSAGE_TARGET__MODEL_KEY:
			return MODEL_KEY_EDEFAULT == null ? modelKey != null : !MODEL_KEY_EDEFAULT.equals(modelKey);
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
		if (eIsProxy()) {
			return super.toString();
		}

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (modelKey: "); //$NON-NLS-1$
		result.append(modelKey);
		result.append(')');
		return result.toString();
	}

} // BindingMessageTargetImpl
