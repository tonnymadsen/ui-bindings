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
package com.rcpcompany.uibindings.navigator.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.services.IEvaluationService;

import com.rcpcompany.uibindings.navigator.IEditorInformation;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorModelPackage;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Editior Model Type</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.navigator.internal.EditorInformationImpl#getEditors <em>
 * Editors</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.navigator.internal.EditorInformationImpl#getPreferredEditor
 * <em>Preferred Editor</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.navigator.internal.EditorInformationImpl#getModelType <em>
 * Model Type</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.navigator.internal.EditorInformationImpl#getTreeItemID <em>
 * Tree Item ID</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EditorInformationImpl extends EObjectImpl implements IEditorInformation {
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
	 * 
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
	 * The default value of the '{@link #getTreeItemID() <em>Tree Item ID</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTreeItemID()
	 * @generated
	 * @ordered
	 */
	protected static final String TREE_ITEM_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTreeItemID() <em>Tree Item ID</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTreeItemID()
	 * @generated
	 * @ordered
	 */
	protected String treeItemID = TREE_ITEM_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EditorInformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return INavigatorModelPackage.Literals.EDITOR_INFORMATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IEditorPartDescriptor> getEditors() {
		if (editors == null) {
			editors = new EObjectEList<IEditorPartDescriptor>(IEditorPartDescriptor.class, this,
					INavigatorModelPackage.EDITOR_INFORMATION__EDITORS);
		}
		return editors;
	}

	@Override
	public List<IEditorPartDescriptor> getEnabledEditors() {
		final List<IEditorPartDescriptor> l = new ArrayList<IEditorPartDescriptor>();

		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IEvaluationService service = (IEvaluationService) window.getService(IEvaluationService.class);

		final IEvaluationContext context = service.getCurrentState();

		for (final IEditorPartDescriptor d : getEditors()) {
			final Expression e = d.getEnabledWhenExpression();
			try {
				if (e == null || e.evaluate(context) == EvaluationResult.TRUE) {
					l.add(d);
					continue;
				}
			} catch (final CoreException ex) {
				LogUtils.error(this, ex);
			}
		}

		return l;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
		String key = getModelType();
		if (key == null) {
			key = getTreeItemID();
		}
		ps.setValue(key, getPreferredEditor().getId());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPreferredEditorGen(IEditorPartDescriptor newPreferredEditor) {
		final IEditorPartDescriptor oldPreferredEditor = preferredEditor;
		preferredEditor = newPreferredEditor;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					INavigatorModelPackage.EDITOR_INFORMATION__PREFERRED_EDITOR, oldPreferredEditor, preferredEditor));
		}
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
					INavigatorModelPackage.EDITOR_INFORMATION__MODEL_TYPE, oldModelType, modelType));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getTreeItemID() {
		return treeItemID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setTreeItemID(String newTreeItemID) {
		final String oldTreeItemID = treeItemID;
		treeItemID = newTreeItemID;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					INavigatorModelPackage.EDITOR_INFORMATION__TREE_ITEM_ID, oldTreeItemID, treeItemID));
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
		case INavigatorModelPackage.EDITOR_INFORMATION__EDITORS:
			return getEditors();
		case INavigatorModelPackage.EDITOR_INFORMATION__PREFERRED_EDITOR:
			return getPreferredEditor();
		case INavigatorModelPackage.EDITOR_INFORMATION__MODEL_TYPE:
			return getModelType();
		case INavigatorModelPackage.EDITOR_INFORMATION__TREE_ITEM_ID:
			return getTreeItemID();
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
		case INavigatorModelPackage.EDITOR_INFORMATION__EDITORS:
			getEditors().clear();
			getEditors().addAll((Collection<? extends IEditorPartDescriptor>) newValue);
			return;
		case INavigatorModelPackage.EDITOR_INFORMATION__PREFERRED_EDITOR:
			setPreferredEditor((IEditorPartDescriptor) newValue);
			return;
		case INavigatorModelPackage.EDITOR_INFORMATION__MODEL_TYPE:
			setModelType((String) newValue);
			return;
		case INavigatorModelPackage.EDITOR_INFORMATION__TREE_ITEM_ID:
			setTreeItemID((String) newValue);
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
		case INavigatorModelPackage.EDITOR_INFORMATION__EDITORS:
			getEditors().clear();
			return;
		case INavigatorModelPackage.EDITOR_INFORMATION__PREFERRED_EDITOR:
			setPreferredEditor((IEditorPartDescriptor) null);
			return;
		case INavigatorModelPackage.EDITOR_INFORMATION__MODEL_TYPE:
			setModelType(MODEL_TYPE_EDEFAULT);
			return;
		case INavigatorModelPackage.EDITOR_INFORMATION__TREE_ITEM_ID:
			setTreeItemID(TREE_ITEM_ID_EDEFAULT);
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
		case INavigatorModelPackage.EDITOR_INFORMATION__EDITORS:
			return editors != null && !editors.isEmpty();
		case INavigatorModelPackage.EDITOR_INFORMATION__PREFERRED_EDITOR:
			return preferredEditor != null;
		case INavigatorModelPackage.EDITOR_INFORMATION__MODEL_TYPE:
			return MODEL_TYPE_EDEFAULT == null ? modelType != null : !MODEL_TYPE_EDEFAULT.equals(modelType);
		case INavigatorModelPackage.EDITOR_INFORMATION__TREE_ITEM_ID:
			return TREE_ITEM_ID_EDEFAULT == null ? treeItemID != null : !TREE_ITEM_ID_EDEFAULT.equals(treeItemID);
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
		result.append(", treeItemID: ");
		result.append(treeItemID);
		result.append(')');
		return result.toString();
	}

} // EditiorModelTypeImpl
