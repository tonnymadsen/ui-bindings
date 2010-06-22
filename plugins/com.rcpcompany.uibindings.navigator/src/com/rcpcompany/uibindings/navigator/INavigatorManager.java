/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.navigator;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Navigator Manager</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.navigator.INavigatorManager#getModelTypes <em>Model Types
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getNavigatorManager()
 * @generated
 */
public interface INavigatorManager extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Types</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type
	 * {@link com.rcpcompany.uibindings.navigator.IEditiorModelType}, <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Types</em>' map isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Types</em>' map.
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getNavigatorManager_ModelTypes()
	 * @generated
	 */
	EMap<String, IEditiorModelType> getModelTypes();

} // INavigatorManager
