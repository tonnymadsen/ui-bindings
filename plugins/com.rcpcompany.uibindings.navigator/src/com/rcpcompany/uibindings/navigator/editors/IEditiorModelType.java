/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.navigator.editors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Editior Model Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.rcpcompany.uibindings.navigator.editors.IEditiorModelType#getEditors <em>Editors</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.navigator.editors.IEditiorModelType#getModelType <em>Model Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.rcpcompany.uibindings.navigator.editors.IEditorsPackage#getEditiorModelType()
 * @generated
 */
public interface IEditiorModelType extends EObject {
	/**
	 * Returns the value of the '<em><b>Editors</b></em>' reference list.
	 * The list contents are of type {@link com.rcpcompany.uibindings.navigator.editors.IEditorDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editors</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editors</em>' reference list.
	 * @see com.rcpcompany.uibindings.navigator.editors.IEditorsPackage#getEditiorModelType_Editors()
	 * @generated
	 */
	EList<IEditorDescriptor> getEditors();

	/**
	 * Returns the value of the '<em><b>Model Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Type</em>' attribute.
	 * @see #setModelType(String)
	 * @see com.rcpcompany.uibindings.navigator.editors.IEditorsPackage#getEditiorModelType_ModelType()
	 * @generated
	 */
	String getModelType();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.navigator.editors.IEditiorModelType#getModelType <em>Model Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Type</em>' attribute.
	 * @see #getModelType()
	 * @generated
	 */
	void setModelType(String value);

} // IEditiorModelType
