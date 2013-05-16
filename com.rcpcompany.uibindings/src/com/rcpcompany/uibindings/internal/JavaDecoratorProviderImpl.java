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
package com.rcpcompany.uibindings.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;

import com.rcpcompany.uibindings.IJavaDecoratorProvider;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Java Decorator Provider</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class JavaDecoratorProviderImpl extends DecoratorProviderImpl implements IJavaDecoratorProvider {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JavaDecoratorProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.JAVA_DECORATOR_PROVIDER;
	}

	@Override
	public IUIBindingDecorator getDecorator() {
		try {
			return (IUIBindingDecorator) getChildCE().createExecutableExtension(InternalConstants.CLASS_TAG);
		} catch (final CoreException ex) {
			LogUtils.error(getChildCE(), ex);
		}
		return null;
	}
} // JavaDecoratorProviderImpl
