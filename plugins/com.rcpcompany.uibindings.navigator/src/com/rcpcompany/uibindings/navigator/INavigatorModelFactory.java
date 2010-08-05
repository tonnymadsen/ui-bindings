/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.navigator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage
 * @generated
 */
public interface INavigatorModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	INavigatorModelFactory eINSTANCE = com.rcpcompany.uibindings.navigator.internal.NavigatorModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Navigator Manager</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Navigator Manager</em>'.
	 * @generated
	 */
	INavigatorManager createNavigatorManager();

	/**
	 * Returns a new object of class '<em>Editor Model Type</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Editor Model Type</em>'.
	 * @generated
	 */
	IEditorModelType createEditorModelType();

	/**
	 * Returns the manager.
	 * 
	 * @return the manager
	 */
	INavigatorManager getManager();

	/**
	 * Returns a new object of class '<em>Editor Part Descriptor</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Editor Part Descriptor</em>'.
	 * @generated
	 */
	IEditorPartDescriptor createEditorPartDescriptor();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	INavigatorModelPackage getNavigatorModelPackage();

} // INavigatorModelFactory
