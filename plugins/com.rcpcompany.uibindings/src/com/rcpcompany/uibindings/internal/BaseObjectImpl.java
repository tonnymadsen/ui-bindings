/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.internal;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import com.rcpcompany.uibindings.IBaseObject;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IUIBindingsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Base Object</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.BaseObjectImpl#getServices <em>Services</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class BaseObjectImpl extends EObjectImpl implements IBaseObject {
	/**
	 * The cached value of the '{@link #getServices() <em>Services</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getServices()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> services;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BaseObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.BASE_OBJECT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<Object> getServices() {
		if (services == null) {
			services = new EDataTypeUniqueEList<Object>(Object.class, this, IUIBindingsPackage.BASE_OBJECT__SERVICES);
		}
		return services;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IUIBindingsPackage.BASE_OBJECT__SERVICES:
			return getServices();
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
		case IUIBindingsPackage.BASE_OBJECT__SERVICES:
			getServices().clear();
			getServices().addAll((Collection<? extends Object>) newValue);
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
		case IUIBindingsPackage.BASE_OBJECT__SERVICES:
			getServices().clear();
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
		case IUIBindingsPackage.BASE_OBJECT__SERVICES:
			return services != null && !services.isEmpty();
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
		result.append(" (services: "); //$NON-NLS-1$
		result.append(services);
		result.append(')');
		return result.toString();
	}

	@Override
	public <T> void registerService(T serviceObject) {
		getServices().add(serviceObject);
	};

	@Override
	public <T> void deregisterService(T serviceObject) {
		getServices().remove(serviceObject);
	};

	@Override
	public <T> T getService(Class<T> serviceClass) {
		for (final Object service : getServices()) {
			if (serviceClass.isInstance(service)) return (T) service;
		}
		return null;
	}

	/**
	 * Disposes all services that implements the {@link IDisposable} interface.
	 */
	protected void disposeServices() {
		for (final Object s : getServices().toArray()) {
			if (s instanceof IDisposable) {
				((IDisposable) s).dispose();
			}
		}
	}
} // BaseObjectImpl
