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

import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>UI Binding Decorator Extender Descriptor</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor#getPriority <em>
 * Priority</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor#getFactory <em>Factory
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIBindingDecoratorExtenderDescriptor()
 * @generated
 */
public interface IUIBindingDecoratorExtenderDescriptor extends EObject, IArgumentProvider {
	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * The higher number, the higher priority, and the later in the process is the extender run.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIBindingDecoratorExtenderDescriptor_Priority()
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor#getPriority
	 * <em>Priority</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Factory</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * In this context the factory is a {@link IUIBindingDecoratorExtender} factory.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Factory</em>' attribute.
	 * @see #setFactory(CEObjectHolder)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIBindingDecoratorExtenderDescriptor_Factory()
	 * @generated
	 */
	CEObjectHolder<IUIBindingDecoratorExtender> getFactory();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor#getFactory
	 * <em>Factory</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Factory</em>' attribute.
	 * @see #getFactory()
	 * @generated
	 */
	void setFactory(CEObjectHolder<IUIBindingDecoratorExtender> value);

} // IUIBindingDecoratorExtenderDescriptor
