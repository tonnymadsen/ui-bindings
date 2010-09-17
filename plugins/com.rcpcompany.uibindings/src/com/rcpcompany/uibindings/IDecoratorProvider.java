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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Decorator Provider</b></em>
 * '. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IDecoratorProvider#getManager <em>Manager</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IDecoratorProvider#getId <em>Id</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IDecoratorProvider#getType <em>Type</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IDecoratorProvider#getModelTypes <em>Model Types</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IDecoratorProvider#getUiTypes <em>Ui Types</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IDecoratorProvider#getProviderCE <em>Provider CE</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IDecoratorProvider#getChildCE <em>Child CE</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IDecoratorProvider#getDecorator <em>Decorator</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IDecoratorProvider#isExactModelTypeMatch <em>Exact Model
 * Type Match</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getDecoratorProvider()
 * @generated
 */
public interface IDecoratorProvider extends EObject, IArgumentProvider {
	/**
	 * Returns the value of the '<em><b>Manager</b></em>' container reference. It is bidirectional
	 * and its opposite is '{@link com.rcpcompany.uibindings.IManager#getProviders
	 * <em>Providers</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manager</em>' container reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Manager</em>' container reference.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getDecoratorProvider_Manager()
	 * @see com.rcpcompany.uibindings.IManager#getProviders
	 * @generated
	 */
	IManager getManager();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getDecoratorProvider_Id()
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IDecoratorProvider#getId <em>Id</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getDecoratorProvider_Type()
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IDecoratorProvider#getType
	 * <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Model Types</b></em>' attribute list. The list contents are
	 * of type {@link java.lang.String}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Types</em>' attribute list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Types</em>' attribute list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getDecoratorProvider_ModelTypes()
	 * @generated
	 */
	EList<String> getModelTypes();

	/**
	 * Returns the value of the '<em><b>Ui Types</b></em>' attribute list. The list contents are of
	 * type {@link java.lang.String}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ui Types</em>' attribute list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Ui Types</em>' attribute list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getDecoratorProvider_UiTypes()
	 * @generated
	 */
	EList<String> getUiTypes();

	/**
	 * Returns the value of the '<em><b>Provider CE</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider CE</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Provider CE</em>' attribute.
	 * @see #setProviderCE(IConfigurationElement)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getDecoratorProvider_ProviderCE()
	 * @generated
	 */
	IConfigurationElement getProviderCE();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IDecoratorProvider#getProviderCE
	 * <em>Provider CE</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Provider CE</em>' attribute.
	 * @see #getProviderCE()
	 * @generated
	 */
	void setProviderCE(IConfigurationElement value);

	/**
	 * Returns the value of the '<em><b>Child CE</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child CE</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Child CE</em>' attribute.
	 * @see #setChildCE(IConfigurationElement)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getDecoratorProvider_ChildCE()
	 * @generated
	 */
	IConfigurationElement getChildCE();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IDecoratorProvider#getChildCE
	 * <em>Child CE</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Child CE</em>' attribute.
	 * @see #getChildCE()
	 * @generated
	 */
	void setChildCE(IConfigurationElement value);

	/**
	 * Returns the value of the '<em><b>Decorator</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decorator</em>' reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Decorator</em>' reference.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getDecoratorProvider_Decorator()
	 * @generated
	 */
	IUIBindingDecorator getDecorator();

	/**
	 * Returns the value of the '<em><b>Exact Model Type Match</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exact Model Type Match</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Exact Model Type Match</em>' attribute.
	 * @see #setExactModelTypeMatch(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getDecoratorProvider_ExactModelTypeMatch()
	 * @generated
	 */
	boolean isExactModelTypeMatch();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IDecoratorProvider#isExactModelTypeMatch
	 * <em>Exact Model Type Match</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Exact Model Type Match</em>' attribute.
	 * @see #isExactModelTypeMatch()
	 * @generated
	 */
	void setExactModelTypeMatch(boolean value);

	/**
	 * "Reads" the information about the provider from the extensiion register.
	 * 
	 * @param id the ID of the provider
	 * @param providerCE the configuration element of the provider
	 * @param childCE the child configuration element with the provider specific configuration
	 */
	void providerReader(String id, IConfigurationElement providerCE, IConfigurationElement childCE);

} // IDecoratorProvider
