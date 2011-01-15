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
package com.rcpcompany.uibindings.scripting;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.moao.IMOAOFacet;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Script</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.scripting.IFeatureScript#getFeature <em>Feature</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.scripting.IFeatureScript#getLanguage <em>Language</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.scripting.IFeatureScript#getScript <em>Script</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.scripting.IFeatureScript#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.scripting.IScriptingPackage#getFeatureScript()
 * @generated
 */
public interface IFeatureScript extends IMOAOFacet, IDisposable {
	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(EStructuralFeature)
	 * @see com.rcpcompany.uibindings.scripting.IScriptingPackage#getFeatureScript_Feature()
	 * @generated
	 */
	EStructuralFeature getFeature();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.scripting.IFeatureScript#getFeature <em>Feature</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see #setLanguage(String)
	 * @see com.rcpcompany.uibindings.scripting.IScriptingPackage#getFeatureScript_Language()
	 * @generated
	 */
	String getLanguage();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.scripting.IFeatureScript#getLanguage <em>Language</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Script</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Script</em>' attribute.
	 * @see #setScript(String)
	 * @see com.rcpcompany.uibindings.scripting.IScriptingPackage#getFeatureScript_Script()
	 * @generated
	 */
	String getScript();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.scripting.IFeatureScript#getScript <em>Script</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Script</em>' attribute.
	 * @see #getScript()
	 * @generated
	 */
	void setScript(String value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Expression</em>' reference.
	 * @see #setExpression(IScriptExpression)
	 * @see com.rcpcompany.uibindings.scripting.IScriptingPackage#getFeatureScript_Expression()
	 * @generated
	 */
	IScriptExpression getExpression();

	/**
	 * Sets the value of the ' {@link com.rcpcompany.uibindings.scripting.IFeatureScript#getExpression
	 * <em>Expression</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Expression</em>' reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(IScriptExpression value);

} // IScript
