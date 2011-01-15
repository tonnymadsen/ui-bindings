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
package com.rcpcompany.uibindings.scripting.utils;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.scripting.IScriptDependency;
import com.rcpcompany.uibindings.scripting.IScriptEngine;
import com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor;
import com.rcpcompany.uibindings.scripting.IScriptEnginePackage;
import com.rcpcompany.uibindings.scripting.IScriptEvaluationContext;
import com.rcpcompany.uibindings.scripting.IScriptExpression;
import com.rcpcompany.uibindings.scripting.IScriptManager;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage
 * @generated
 */
public class ScriptEngineAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static IScriptEnginePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ScriptEngineAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = IScriptEnginePackage.eINSTANCE;
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
	protected ScriptEngineSwitch<Adapter> modelSwitch = new ScriptEngineSwitch<Adapter>() {
		@Override
		public Adapter caseScriptManager(IScriptManager object) {
			return createScriptManagerAdapter();
		}

		@Override
		public Adapter caseScriptEngineDescriptor(IScriptEngineDescriptor object) {
			return createScriptEngineDescriptorAdapter();
		}

		@Override
		public Adapter caseScriptEngine(IScriptEngine object) {
			return createScriptEngineAdapter();
		}

		@Override
		public Adapter caseScriptEvaluationContext(IScriptEvaluationContext object) {
			return createScriptEvaluationContextAdapter();
		}

		@Override
		public Adapter caseScriptExpression(IScriptExpression object) {
			return createScriptExpressionAdapter();
		}

		@Override
		public Adapter caseScriptDependency(IScriptDependency object) {
			return createScriptDependencyAdapter();
		}

		@Override
		public Adapter caseStringToScriptEngineMapEntry(Map.Entry<String, IScriptEngineDescriptor> object) {
			return createStringToScriptEngineMapEntryAdapter();
		}

		@Override
		public Adapter caseEObjectToScriptDependencyListMapEntry(Map.Entry<EObject, EList<IScriptDependency>> object) {
			return createEObjectToScriptDependencyListMapEntryAdapter();
		}

		@Override
		public Adapter caseEObjectToScriptEngineMapEntry(Map.Entry<EObject, IScriptEvaluationContext> object) {
			return createEObjectToScriptEngineMapEntryAdapter();
		}

		@Override
		public Adapter caseIDisposable(IDisposable object) {
			return createIDisposableAdapter();
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
	 * {@link com.rcpcompany.uibindings.scripting.IScriptManager <em>Script Manager</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.scripting.IScriptManager
	 * @generated
	 */
	public Adapter createScriptManagerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor
	 * @generated
	 */
	public Adapter createScriptEngineDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.scripting.IScriptEngine <em>Script Engine</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEngine
	 * @generated
	 */
	public Adapter createScriptEngineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.scripting.IScriptEvaluationContext
	 * <em>Script Evaluation Context</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEvaluationContext
	 * @generated
	 */
	public Adapter createScriptEvaluationContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.scripting.IScriptExpression <em>Script Expression</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.scripting.IScriptExpression
	 * @generated
	 */
	public Adapter createScriptExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.scripting.IScriptDependency <em>Script Dependency</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.scripting.IScriptDependency
	 * @generated
	 */
	public Adapter createScriptDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry
	 * <em>String To Script Engine Map Entry</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createStringToScriptEngineMapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry
	 * <em>EObject To Script Dependency List Map Entry</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createEObjectToScriptDependencyListMapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry
	 * <em>EObject To Script Engine Map Entry</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createEObjectToScriptEngineMapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.rcpcompany.uibindings.IDisposable
	 * <em>IDisposable</em>}'. <!-- begin-user-doc --> This default implementation returns null so
	 * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
	 * the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.IDisposable
	 * @generated
	 */
	public Adapter createIDisposableAdapter() {
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

} // ScriptEngineAdapterFactory
