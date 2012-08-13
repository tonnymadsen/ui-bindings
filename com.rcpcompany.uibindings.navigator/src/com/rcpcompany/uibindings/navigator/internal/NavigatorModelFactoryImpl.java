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
package com.rcpcompany.uibindings.navigator.internal;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.rcpcompany.uibindings.navigator.IEditorInformation;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.INavigatorModelFactory;
import com.rcpcompany.uibindings.navigator.INavigatorModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class NavigatorModelFactoryImpl extends EFactoryImpl implements INavigatorModelFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static INavigatorModelFactory init() {
		try {
			final INavigatorModelFactory theNavigatorModelFactory = (INavigatorModelFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://rcp-company.com/schemas/uibindings/navigator");
			if (theNavigatorModelFactory != null) return theNavigatorModelFactory;
		} catch (final Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NavigatorModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NavigatorModelFactoryImpl() {
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
		case INavigatorModelPackage.NAVIGATOR_MANAGER:
			return createNavigatorManager();
		case INavigatorModelPackage.NAVIGATOR_DESCRIPTOR:
			return createNavigatorDescriptor();
		case INavigatorModelPackage.EDITOR_INFORMATION:
			return createEditorInformation();
		case INavigatorModelPackage.EDITOR_PART_DESCRIPTOR:
			return createEditorPartDescriptor();
		case INavigatorModelPackage.STRING_TO_EDITOR_INFORMATION_MAP_ENTRY:
			return (EObject) createStringToEditorInformationMapEntry();
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
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	private INavigatorManager theManager = null;

	@Override
	public INavigatorManager getManager() {
		if (theManager == null) {
			createNavigatorManager();
		}
		return theManager;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public INavigatorManager createNavigatorManager() {
		final NavigatorManagerImpl navigatorManager = new NavigatorManagerImpl();
		theManager = navigatorManager;
		navigatorManager.init();
		return navigatorManager;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public INavigatorDescriptor createNavigatorDescriptor() {
		final NavigatorDescriptorImpl navigatorDescriptor = new NavigatorDescriptorImpl();
		return navigatorDescriptor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IEditorInformation createEditorInformation() {
		final EditorInformationImpl editorInformation = new EditorInformationImpl();
		return editorInformation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IEditorPartDescriptor createEditorPartDescriptor() {
		final EditorPartDescriptorImpl editorPartDescriptor = new EditorPartDescriptorImpl();
		return editorPartDescriptor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Map.Entry<String, IEditorInformation> createStringToEditorInformationMapEntry() {
		final StringToEditorInformationMapEntryImpl stringToEditorInformationMapEntry = new StringToEditorInformationMapEntryImpl();
		return stringToEditorInformationMapEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public INavigatorModelPackage getNavigatorModelPackage() {
		return (INavigatorModelPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static INavigatorModelPackage getPackage() {
		return INavigatorModelPackage.eINSTANCE;
	}

} // NavigatorModelFactoryImpl
