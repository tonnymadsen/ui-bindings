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
package com.rcpcompany.uibindings.navigator;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> This interface contains the information known about the available editors
 * for a specific model type or tree item ID. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.navigator.IEditorInformation#getEditors <em>Editors</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.navigator.IEditorInformation#getPreferredEditor <em>
 * Preferred Editor</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.navigator.IEditorInformation#getModelType <em>Model Type
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.navigator.IEditorInformation#getTreeItemID <em>Tree Item ID
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getEditorInformation()
 * @generated
 */
public interface IEditorInformation extends EObject {
	/**
	 * Returns the value of the '<em><b>Editors</b></em>' reference list. The list contents are of
	 * type {@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor}. <!-- begin-user-doc
	 * -->
	 * <p>
	 * This is the editors that have been found for the specified model type or tree item ID.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Editors</em>' reference list.
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getEditorInformation_Editors()
	 * @generated
	 */
	EList<IEditorPartDescriptor> getEditors();

	/**
	 * Returns a list of all enabled editors at the time of the call.
	 * 
	 * @return the list of enabled editors - possibly empty
	 */
	List<IEditorPartDescriptor> getEnabledEditors();

	/**
	 * Returns the value of the '<em><b>Preferred Editor</b></em>' reference. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Preferred Editor</em>' reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Preferred Editor</em>' reference.
	 * @see #setPreferredEditor(IEditorPartDescriptor)
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getEditorInformation_PreferredEditor()
	 * @generated
	 */
	IEditorPartDescriptor getPreferredEditor();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorInformation#getPreferredEditor
	 * <em>Preferred Editor</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Preferred Editor</em>' reference.
	 * @see #getPreferredEditor()
	 * @generated
	 */
	void setPreferredEditor(IEditorPartDescriptor value);

	/**
	 * Returns the value of the '<em><b>Model Type</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * The model type for this editor information object. Can be <code>null</code>.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Type</em>' attribute.
	 * @see #setModelType(String)
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getEditorInformation_ModelType()
	 * @generated
	 */
	String getModelType();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorInformation#getModelType
	 * <em>Model Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Model Type</em>' attribute.
	 * @see #getModelType()
	 * @generated
	 */
	void setModelType(String value);

	/**
	 * Returns the value of the '<em><b>Tree Item ID</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * The tree item ID for this editor information object. Can be <code>null</code>.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Tree Item ID</em>' attribute.
	 * @see #setTreeItemID(String)
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getEditorInformation_TreeItemID()
	 * @generated
	 */
	String getTreeItemID();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorInformation#getTreeItemID
	 * <em>Tree Item ID</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Tree Item ID</em>' attribute.
	 * @see #getTreeItemID()
	 * @generated
	 */
	void setTreeItemID(String value);
} // IEditiorModelType
