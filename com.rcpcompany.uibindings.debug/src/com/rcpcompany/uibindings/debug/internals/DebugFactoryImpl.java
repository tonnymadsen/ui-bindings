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
package com.rcpcompany.uibindings.debug.internals;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.rcpcompany.uibindings.debug.IDebugFactory;
import com.rcpcompany.uibindings.debug.IDebugPackage;
import com.rcpcompany.uibindings.debug.IScriptConsoleContext;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class DebugFactoryImpl extends EFactoryImpl implements IDebugFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static IDebugFactory init() {
		try {
			final IDebugFactory theDebugFactory = (IDebugFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://rcp-company.com/schemas/uibindings/debug.ecore");
			if (theDebugFactory != null)
				return theDebugFactory;
		} catch (final Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DebugFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DebugFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT:
			return createScriptConsoleContext();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IScriptConsoleContext createScriptConsoleContext() {
		final ScriptConsoleContextImpl scriptConsoleContext = new ScriptConsoleContextImpl();
		return scriptConsoleContext;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IDebugPackage getDebugPackage() {
		return (IDebugPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IDebugPackage getPackage() {
		return IDebugPackage.eINSTANCE;
	}

} // DebugFactoryImpl
