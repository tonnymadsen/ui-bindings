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

import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>MOAO</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.moao.IMOAO#getFacets <em>Facets</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAO()
 * @generated
 */
public interface IMOAO extends EObject, IAdaptable {
	/**
	 * Returns the value of the '<em><b>Facets</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.moao.IMOAOFacet}. It is bidirectional
	 * and its opposite is '{@link com.rcpcompany.uibindings.moao.IMOAOFacet#getObject
	 * <em>Object</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facets</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Facets</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAO_Facets()
	 * @see com.rcpcompany.uibindings.moao.IMOAOFacet#getObject
	 * @generated
	 */
	EList<IMOAOFacet> getFacets();

	/**
	 * Removes all messages from this object and all contained objects (using reflection) given by
	 * the specified owner.
	 * 
	 * @param owner the owner
	 */
	void removeMessagesByOwner(String owner);

	/**
	 * Checks that this object has a valid state and returns any result in the specified
	 * {@link DiagnosticChain}.
	 * 
	 * @param diagnostic the retun chain
	 * @param context context - not used
	 * @return <code>true</code> if valid, <code>false</code> otherwise
	 */
	boolean isValid(DiagnosticChain diagnostic, Map<Object, Object> context);
} // IMOAO
