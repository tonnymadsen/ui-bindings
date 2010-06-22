/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.navigator.internal;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectEList;

import com.rcpcompany.uibindings.navigator.IEditiorModelType;
import com.rcpcompany.uibindings.navigator.IEditorDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Editior Model Type</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.navigator.internal.EditiorModelTypeImpl#getEditors <em>
 * Editors</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.navigator.internal.EditiorModelTypeImpl#getModelType <em>
 * Model Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EditiorModelTypeImpl extends EObjectImpl implements IEditiorModelType {
	/**
	 * The cached value of the '{@link #getEditors() <em>Editors</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEditors()
	 * @generated
	 * @ordered
	 */
	protected EList<IEditorDescriptor> editors;

	/**
	 * The default value of the '{@link #getModelType() <em>Model Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelType()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelType() <em>Model Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelType()
	 * @generated
	 * @ordered
	 */
	protected String modelType = MODEL_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EditiorModelTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return INavigatorModelPackage.Literals.EDITIOR_MODEL_TYPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IEditorDescriptor> getEditors() {
		if (editors == null) {
			editors = new EObjectEList<IEditorDescriptor>(IEditorDescriptor.class, this,
					INavigatorModelPackage.EDITIOR_MODEL_TYPE__EDITORS);
		}
		return editors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getModelType() {
		return modelType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setModelType(String newModelType) {
		final String oldModelType = modelType;
		modelType = newModelType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					INavigatorModelPackage.EDITIOR_MODEL_TYPE__MODEL_TYPE, oldModelType, modelType));
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
		case INavigatorModelPackage.EDITIOR_MODEL_TYPE__EDITORS:
			return getEditors();
		case INavigatorModelPackage.EDITIOR_MODEL_TYPE__MODEL_TYPE:
			return getModelType();
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
		case INavigatorModelPackage.EDITIOR_MODEL_TYPE__EDITORS:
			getEditors().clear();
			getEditors().addAll((Collection<? extends IEditorDescriptor>) newValue);
			return;
		case INavigatorModelPackage.EDITIOR_MODEL_TYPE__MODEL_TYPE:
			setModelType((String) newValue);
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
		case INavigatorModelPackage.EDITIOR_MODEL_TYPE__EDITORS:
			getEditors().clear();
			return;
		case INavigatorModelPackage.EDITIOR_MODEL_TYPE__MODEL_TYPE:
			setModelType(MODEL_TYPE_EDEFAULT);
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
		case INavigatorModelPackage.EDITIOR_MODEL_TYPE__EDITORS:
			return editors != null && !editors.isEmpty();
		case INavigatorModelPackage.EDITIOR_MODEL_TYPE__MODEL_TYPE:
			return MODEL_TYPE_EDEFAULT == null ? modelType != null : !MODEL_TYPE_EDEFAULT.equals(modelType);
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
		result.append(" (modelType: ");
		result.append(modelType);
		result.append(')');
		return result.toString();
	}

} // EditiorModelTypeImpl
