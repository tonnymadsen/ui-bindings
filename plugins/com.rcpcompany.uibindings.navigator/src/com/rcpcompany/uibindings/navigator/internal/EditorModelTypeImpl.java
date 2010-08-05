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
import org.eclipse.jface.preference.IPreferenceStore;

import com.rcpcompany.uibindings.navigator.IEditorModelType;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Editior Model Type</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.rcpcompany.uibindings.navigator.internal.EditorModelTypeImpl#getEditors <em>Editors</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.navigator.internal.EditorModelTypeImpl#getPreferredEditor <em>Preferred Editor</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.navigator.internal.EditorModelTypeImpl#getModelType <em>Model Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EditorModelTypeImpl extends EObjectImpl implements IEditorModelType {
	/**
	 * The cached value of the '{@link #getEditors() <em>Editors</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEditors()
	 * @generated
	 * @ordered
	 */
	protected EList<IEditorPartDescriptor> editors;

	/**
	 * The cached value of the '{@link #getPreferredEditor() <em>Preferred Editor</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPreferredEditor()
	 * @generated
	 * @ordered
	 */
	protected IEditorPartDescriptor preferredEditor;

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
	 * @generated
	 */
	protected EditorModelTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return INavigatorModelPackage.Literals.EDITOR_MODEL_TYPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IEditorPartDescriptor> getEditors() {
		if (editors == null) {
			editors = new EObjectEList<IEditorPartDescriptor>(IEditorPartDescriptor.class, this, INavigatorModelPackage.EDITOR_MODEL_TYPE__EDITORS);
		}
		return editors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IEditorPartDescriptor getPreferredEditor() {
		return preferredEditor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setPreferredEditor(IEditorPartDescriptor newPreferredEditor) {
		if (newPreferredEditor == null && getEditors().size() > 0) {
			newPreferredEditor = getEditors().get(0);
		}
		setPreferredEditorGen(newPreferredEditor);

		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setValue(getModelType(), getPreferredEditor().getId());
	}

	public void setPreferredEditorGen(IEditorPartDescriptor newPreferredEditor) {
		final IEditorPartDescriptor oldPreferredEditor = preferredEditor;
		preferredEditor = newPreferredEditor;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					INavigatorModelPackage.EDITOR_MODEL_TYPE__PREFERRED_EDITOR, oldPreferredEditor, preferredEditor));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getModelType() {
		return modelType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelType(String newModelType) {
		String oldModelType = modelType;
		modelType = newModelType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, INavigatorModelPackage.EDITOR_MODEL_TYPE__MODEL_TYPE, oldModelType, modelType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case INavigatorModelPackage.EDITOR_MODEL_TYPE__EDITORS:
				return getEditors();
			case INavigatorModelPackage.EDITOR_MODEL_TYPE__PREFERRED_EDITOR:
				return getPreferredEditor();
			case INavigatorModelPackage.EDITOR_MODEL_TYPE__MODEL_TYPE:
				return getModelType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case INavigatorModelPackage.EDITOR_MODEL_TYPE__EDITORS:
				getEditors().clear();
				getEditors().addAll((Collection<? extends IEditorPartDescriptor>)newValue);
				return;
			case INavigatorModelPackage.EDITOR_MODEL_TYPE__PREFERRED_EDITOR:
				setPreferredEditor((IEditorPartDescriptor)newValue);
				return;
			case INavigatorModelPackage.EDITOR_MODEL_TYPE__MODEL_TYPE:
				setModelType((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case INavigatorModelPackage.EDITOR_MODEL_TYPE__EDITORS:
				getEditors().clear();
				return;
			case INavigatorModelPackage.EDITOR_MODEL_TYPE__PREFERRED_EDITOR:
				setPreferredEditor((IEditorPartDescriptor)null);
				return;
			case INavigatorModelPackage.EDITOR_MODEL_TYPE__MODEL_TYPE:
				setModelType(MODEL_TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case INavigatorModelPackage.EDITOR_MODEL_TYPE__EDITORS:
				return editors != null && !editors.isEmpty();
			case INavigatorModelPackage.EDITOR_MODEL_TYPE__PREFERRED_EDITOR:
				return preferredEditor != null;
			case INavigatorModelPackage.EDITOR_MODEL_TYPE__MODEL_TYPE:
				return MODEL_TYPE_EDEFAULT == null ? modelType != null : !MODEL_TYPE_EDEFAULT.equals(modelType);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (modelType: ");
		result.append(modelType);
		result.append(')');
		return result.toString();
	}

} // EditiorModelTypeImpl
