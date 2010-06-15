/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Binding Message Target</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IBindingMessageTarget#getModelObject <em>Model Object</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingMessageTarget#getModelFeature <em>Model Feature
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingMessageTarget#getModelKey <em>Model Key</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingMessageTarget()
 * @generated
 */
public interface IBindingMessageTarget extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Object</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Object</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Object</em>' reference.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingMessageTarget_ModelObject()
	 * @generated
	 */
	EObject getModelObject();

	/**
	 * Returns the value of the '<em><b>Model Feature</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Feature</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Feature</em>' reference.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingMessageTarget_ModelFeature()
	 * @generated
	 */
	EStructuralFeature getModelFeature();

	/**
	 * Returns the value of the '<em><b>Model Key</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Key</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Key</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingMessageTarget_ModelKey()
	 * @generated
	 */
	Object getModelKey();

} // IBindingMessageTarget
