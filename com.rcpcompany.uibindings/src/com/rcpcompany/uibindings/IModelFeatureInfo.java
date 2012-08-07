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
package com.rcpcompany.uibindings;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Model Feature Info</b></em>
 * '. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IModelFeatureInfo#getFeatureName <em>Feature Name</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IModelFeatureInfo#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getModelFeatureInfo()
 * @generated
 */
public interface IModelFeatureInfo extends IModelInfo {
	/**
	 * Returns the value of the '<em><b>Feature Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Feature Name</em>' attribute.
	 * @see #setFeatureName(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getModelFeatureInfo_FeatureName()
	 * @generated
	 */
	String getFeatureName();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IModelFeatureInfo#getFeatureName
	 * <em>Feature Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Feature Name</em>' attribute.
	 * @see #getFeatureName()
	 * @generated
	 */
	void setFeatureName(String value);

	/**
	 * Returns the value of the '<em><b>Class</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' container reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Class</em>' reference.
	 * @see #setClass(IModelClassInfo)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getModelFeatureInfo_Class()
	 * @generated
	 */
	IModelClassInfo getClass_();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IModelFeatureInfo#getClass_
	 * <em>Class</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Class</em>' reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(IModelClassInfo value);

} // IModelFeatureInfo
