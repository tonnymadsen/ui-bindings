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
package com.rcpcompany.uibindings;

import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.internal.sourceProviders.BindingSourceProvider;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>UI Binding Decorator Extender</b></em>'. <!-- end-user-doc -->
 * 
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIBindingDecoratorExtender()
 * @generated
 */
public interface IUIBindingDecoratorExtender extends EObject, IDisposable {
	/**
	 * Returns whether this extender is enabled for the specified binding.
	 * <p>
	 * This method is always invoked before {@link #extend(IUIBindingDecoratorExtenderContext)}.
	 * 
	 * @param binding the binding
	 * @return <code>true</code> if this extender is enabled
	 */
	boolean isEnabled(IValueBinding binding);

	/**
	 * Extends the specified binding context.
	 * <p>
	 * Only invoked if {@link #isEnabled(IValueBinding)} returns <code>true</code>.
	 * 
	 * @param context the context to extend
	 */
	void extend(IUIBindingDecoratorExtenderContext context);

	/**
	 * Updates the specified state for this binding. Used in {@link BindingSourceProvider}.
	 * <p>
	 * All available state variables are found in {@link Constants} -
	 * {@link Constants#SOURCES_ACTIVE_BINDING}.
	 * 
	 * @param binding the binding in question
	 * @param context TODO
	 */
	void updateSourceProviderState(IValueBinding binding, ISourceProviderStateContext context);
} // IUIBindingDecoratorExtender
