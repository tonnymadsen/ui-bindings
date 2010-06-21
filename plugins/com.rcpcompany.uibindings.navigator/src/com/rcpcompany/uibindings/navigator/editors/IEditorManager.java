/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.navigator.editors;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Editor Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.rcpcompany.uibindings.navigator.editors.IEditorManager#getModelTypes <em>Model Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.rcpcompany.uibindings.navigator.editors.IEditorsPackage#getEditorManager()
 * @generated
 */
public interface IEditorManager extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Types</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link com.rcpcompany.uibindings.navigator.editors.IEditiorModelType},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Types</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Types</em>' map.
	 * @see com.rcpcompany.uibindings.navigator.editors.IEditorsPackage#getEditorManager_ModelTypes()
	 * @generated
	 */
	EMap<String, IEditiorModelType> getModelTypes();

} // IEditorManager
