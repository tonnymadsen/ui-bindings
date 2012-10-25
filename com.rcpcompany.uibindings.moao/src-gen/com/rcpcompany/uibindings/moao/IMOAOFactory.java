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
package com.rcpcompany.uibindings.moao;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.rcpcompany.uibindings.moao.IMOAOPackage
 * @generated
 */
public interface IMOAOFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	IMOAOFactory eINSTANCE = com.rcpcompany.uibindings.moao.internal.MOAOFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>MOAO</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>MOAO</em>'.
	 * @generated
	 */
	IMOAO createMOAO();

	/**
	 * Returns a new object of class '<em>Facet</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Facet</em>'.
	 * @generated
	 */
	IMOAOFacet createMOAOFacet();

	/**
	 * Returns a new object of class '<em>Named Object</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Named Object</em>'.
	 * @generated
	 */
	INamedObject createNamedObject();

	/**
	 * Returns a new object of class '<em>Message</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Message</em>'.
	 * @generated
	 */
	IMOAOMessage createMOAOMessage();

	/**
	 * Returns a new '<em>Message</em>'.
	 * 
	 * @return a new object of class '<em>Message</em>'.
	 */
	IMOAOMessage createMOAOMessage(IMOAO moao, EStructuralFeature feature, String owner, Severity severity,
			String description);

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	IMOAOPackage getMOAOPackage();

	/**
	 * Returns a new '<em>Message</em>'.
	 * 
	 * @return a new object of class '<em>Message</em>'.
	 */
	IMOAOMessage createMOAOMessage(IMOAO moao, EStructuralFeature feature, String owner, Severity severity,
			String description, String details);
} // IMOAOFactory
