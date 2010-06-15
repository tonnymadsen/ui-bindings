/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.internal;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.IModelInfo;
import com.rcpcompany.uibindings.IUIBindingsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Model Info</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.ModelInfoImpl#getDeclaredArguments <em>Declared
 * Arguments</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ModelInfoImpl extends EObjectImpl implements IModelInfo {
	/**
	 * The cached value of the '{@link #getDeclaredArguments() <em>Declared Arguments</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDeclaredArguments()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Object> declaredArguments;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.MODEL_INFO;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EMap<String, Object> getDeclaredArguments() {
		if (declaredArguments == null) {
			declaredArguments = new EcoreEMap<String, Object>(IUIBindingsPackage.Literals.STRING_TO_OBJECT_MAP_ENTRY,
					StringToObjectMapEntryImpl.class, this, IUIBindingsPackage.MODEL_INFO__DECLARED_ARGUMENTS);
		}
		return declaredArguments;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case IUIBindingsPackage.MODEL_INFO__DECLARED_ARGUMENTS:
			return ((InternalEList<?>) getDeclaredArguments()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IUIBindingsPackage.MODEL_INFO__DECLARED_ARGUMENTS:
			if (coreType)
				return getDeclaredArguments();
			else
				return getDeclaredArguments().map();
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
		case IUIBindingsPackage.MODEL_INFO__DECLARED_ARGUMENTS:
			((EStructuralFeature.Setting) getDeclaredArguments()).set(newValue);
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
		case IUIBindingsPackage.MODEL_INFO__DECLARED_ARGUMENTS:
			getDeclaredArguments().clear();
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
		case IUIBindingsPackage.MODEL_INFO__DECLARED_ARGUMENTS:
			return declaredArguments != null && !declaredArguments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ModelInfoImpl
