/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.navigator.editors;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.rcpcompany.uibindings.navigator.editors.IEditorsPackage
 * @generated
 */
public interface IEditorsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	IEditorsFactory eINSTANCE = com.rcpcompany.uibindings.navigator.editors.internal.EditorsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Editor Manager</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Editor Manager</em>'.
	 * @generated
	 */
	IEditorManager createEditorManager();

	/**
	 * Returns the manager.
	 * 
	 * @return the manager
	 */
	IEditorManager getEditorManager();

	/**
	 * Returns a new object of class '<em>Editior Model Type</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Editior Model Type</em>'.
	 * @generated
	 */
	IEditiorModelType createEditiorModelType();

	/**
	 * Returns a new object of class '<em>Editor Descriptor</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Editor Descriptor</em>'.
	 * @generated
	 */
	IEditorDescriptor createEditorDescriptor();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	IEditorsPackage getEditorsPackage();

} // IEditorsFactory
