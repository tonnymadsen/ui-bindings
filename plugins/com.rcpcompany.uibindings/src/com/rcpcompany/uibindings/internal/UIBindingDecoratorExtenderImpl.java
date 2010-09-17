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
package com.rcpcompany.uibindings.internal;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.ISourceProviderStateContext;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>UI Binding Decorator Extender</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public abstract class UIBindingDecoratorExtenderImpl extends EObjectImpl implements IUIBindingDecoratorExtender {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UIBindingDecoratorExtenderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.UI_BINDING_DECORATOR_EXTENDER;
	}

	@Override
	public void dispose() {
		// Do nothing
	}

	@Override
	public abstract void extend(IUIBindingDecoratorExtenderContext context);

	@Override
	public boolean isEnabled(IValueBinding binding) {
		return true;
	}

	@Override
	public void updateSourceProviderState(IValueBinding binding, ISourceProviderStateContext context) {
		// Do nothing
	}
} // UIBindingDecoratorExtenderImpl
