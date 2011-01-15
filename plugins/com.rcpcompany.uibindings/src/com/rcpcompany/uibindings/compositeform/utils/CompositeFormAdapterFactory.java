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
package com.rcpcompany.uibindings.compositeform.utils;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.compositeform.ICompositeForm;
import com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor;
import com.rcpcompany.uibindings.compositeform.ICompositeFormManager;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPackage;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPart;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage
 * @generated
 */
public class CompositeFormAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ICompositeFormPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CompositeFormAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ICompositeFormPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc
	 * --> This implementation returns <code>true</code> if the object is either the model's package
	 * or is an instance object of the model. <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) return true;
		if (object instanceof EObject) return ((EObject) object).eClass().getEPackage() == modelPackage;
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected CompositeFormSwitch<Adapter> modelSwitch = new CompositeFormSwitch<Adapter>() {
		@Override
		public Adapter caseCompositeFormManager(ICompositeFormManager object) {
			return createCompositeFormManagerAdapter();
		}

		@Override
		public Adapter caseCompositeFormDescriptor(ICompositeFormDescriptor object) {
			return createCompositeFormDescriptorAdapter();
		}

		@Override
		public Adapter caseCompositeFormPartDescriptor(ICompositeFormPartDescriptor object) {
			return createCompositeFormPartDescriptorAdapter();
		}

		@Override
		public Adapter caseCompositeForm(ICompositeForm object) {
			return createCompositeFormAdapter();
		}

		@Override
		public Adapter caseCompositeFormPart(ICompositeFormPart object) {
			return createCompositeFormPartAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormManager <em>Manager</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormManager
	 * @generated
	 */
	public Adapter createCompositeFormManagerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor <em>Descriptor</em>}
	 * '. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor
	 * @generated
	 */
	public Adapter createCompositeFormDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeForm <em>Composite Form</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeForm
	 * @generated
	 */
	public Adapter createCompositeFormAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor
	 * <em>Part Descriptor</em>}'. <!-- begin-user-doc --> This default implementation returns null
	 * so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor
	 * @generated
	 */
	public Adapter createCompositeFormPartDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart <em>Part</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPart
	 * @generated
	 */
	public Adapter createCompositeFormPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case. <!-- begin-user-doc --> This default
	 * implementation returns null. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // CompositeFormAdapterFactory
