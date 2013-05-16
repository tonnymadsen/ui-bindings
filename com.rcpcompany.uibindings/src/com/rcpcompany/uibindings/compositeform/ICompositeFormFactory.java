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
package com.rcpcompany.uibindings.compositeform;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage
 * @generated
 */
public interface ICompositeFormFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ICompositeFormFactory eINSTANCE = com.rcpcompany.uibindings.internal.compositeform.CompositeFormFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Manager</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Manager</em>'.
	 * @generated
	 */
	ICompositeFormManager createCompositeFormManager();

	/**
	 * Returns a new object of class '<em>Descriptor</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Descriptor</em>'.
	 * @generated
	 */
	ICompositeFormDescriptor createCompositeFormDescriptor();

	/**
	 * Returns a new object of class '<em>Composite Form</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Composite Form</em>'.
	 * @generated
	 */
	ICompositeForm createCompositeForm();

	/**
	 * Returns a new object of class '<em>Part Descriptor</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Part Descriptor</em>'.
	 * @generated
	 */
	ICompositeFormPartDescriptor createCompositeFormPartDescriptor();

	/**
	 * Returns a new object of class '<em>Part</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Part</em>'.
	 * @generated
	 */
	ICompositeFormPart createCompositeFormPart();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	ICompositeFormPackage getCompositeFormPackage();

} // ICompositeFormFactory
