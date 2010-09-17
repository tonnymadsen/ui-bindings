/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
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
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Number Decorator Provider</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.INumberDecoratorProvider#getFormat <em>Format</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getNumberDecoratorProvider()
 * @generated
 */
public interface INumberDecoratorProvider extends IDecoratorProvider {
	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see #setFormat(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getNumberDecoratorProvider_Format()
	 * @generated
	 */
	String getFormat();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.INumberDecoratorProvider#getFormat
	 * <em>Format</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(String value);

} // INumberDecoratorProvider
