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

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Facet</b></em>'. <!--
 * end-user-doc -->
 * 
 * <!-- begin-model-doc --> *
 * <p>
 * A facet of an MOAO.
 * <p>
 * Should be extended in sub-classes. <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.moao.IMOAOFacet#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAOFacet()
 * @generated
 */
public interface IMOAOFacet extends IMOAO {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' container reference. It is bidirectional
	 * and its opposite is '{@link com.rcpcompany.uibindings.moao.IMOAO#getFacets <em>Facets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' container reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> *
	 * <p>
	 * The parent object of this facet. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Object</em>' container reference.
	 * @see #setObject(IMOAO)
	 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAOFacet_Object()
	 * @see com.rcpcompany.uibindings.moao.IMOAO#getFacets
	 * @generated
	 */
	IMOAO getObject();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.moao.IMOAOFacet#getObject
	 * <em>Object</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Object</em>' container reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(IMOAO value);

} // IMOAOFacet
