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
package com.rcpcompany.uibindings.internal.scripting;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.rcpcompany.uibindings.scripting.IScriptDependency;
import com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor;
import com.rcpcompany.uibindings.scripting.IScriptEngineFactory;
import com.rcpcompany.uibindings.scripting.IScriptEnginePackage;
import com.rcpcompany.uibindings.scripting.IScriptEvaluationContext;
import com.rcpcompany.uibindings.scripting.IScriptExpression;
import com.rcpcompany.uibindings.scripting.IScriptManager;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ScriptEngineFactoryImpl extends EFactoryImpl implements IScriptEngineFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static IScriptEngineFactory init() {
		try {
			final IScriptEngineFactory theScriptEngineFactory = (IScriptEngineFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://rcp-company.com/schemas/uibindings/scriptEngine.ecore");
			if (theScriptEngineFactory != null) return theScriptEngineFactory;
		} catch (final Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ScriptEngineFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ScriptEngineFactoryImpl() {
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
		case IScriptEnginePackage.SCRIPT_MANAGER:
			return createScriptManager();
		case IScriptEnginePackage.SCRIPT_ENGINE_DESCRIPTOR:
			return createScriptEngineDescriptor();
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT:
			return createScriptEvaluationContext();
		case IScriptEnginePackage.SCRIPT_EXPRESSION:
			return createScriptExpression();
		case IScriptEnginePackage.SCRIPT_DEPENDENCY:
			return createScriptDependency();
		case IScriptEnginePackage.STRING_TO_SCRIPT_ENGINE_MAP_ENTRY:
			return (EObject) createStringToScriptEngineMapEntry();
		case IScriptEnginePackage.EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY:
			return (EObject) createEObjectToScriptDependencyListMapEntry();
		case IScriptEnginePackage.EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY:
			return (EObject) createEObjectToScriptEngineMapEntry();
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
	public IScriptManager createScriptManager() {
		final ScriptManagerImpl scriptManager = new ScriptManagerImpl();
		return scriptManager;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IScriptEngineDescriptor createScriptEngineDescriptor() {
		final ScriptEngineDescriptorImpl scriptEngineDescriptor = new ScriptEngineDescriptorImpl();
		return scriptEngineDescriptor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IScriptEvaluationContext createScriptEvaluationContext() {
		final ScriptEvaluationContextImpl scriptEvaluationContext = new ScriptEvaluationContextImpl();
		return scriptEvaluationContext;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IScriptExpression createScriptExpression() {
		final ScriptExpressionImpl scriptExpression = new ScriptExpressionImpl();
		return scriptExpression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IScriptDependency createScriptDependency() {
		final ScriptDependencyImpl scriptDependency = new ScriptDependencyImpl();
		return scriptDependency;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Map.Entry<String, IScriptEngineDescriptor> createStringToScriptEngineMapEntry() {
		final StringToScriptEngineMapEntryImpl stringToScriptEngineMapEntry = new StringToScriptEngineMapEntryImpl();
		return stringToScriptEngineMapEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Map.Entry<EObject, EList<IScriptDependency>> createEObjectToScriptDependencyListMapEntry() {
		final EObjectToScriptDependencyListMapEntryImpl eObjectToScriptDependencyListMapEntry = new EObjectToScriptDependencyListMapEntryImpl();
		return eObjectToScriptDependencyListMapEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Map.Entry<EObject, IScriptEvaluationContext> createEObjectToScriptEngineMapEntry() {
		final EObjectToScriptEngineMapEntryImpl eObjectToScriptEngineMapEntry = new EObjectToScriptEngineMapEntryImpl();
		return eObjectToScriptEngineMapEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IScriptEnginePackage getScriptEnginePackage() {
		return (IScriptEnginePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IScriptEnginePackage getPackage() {
		return IScriptEnginePackage.eINSTANCE;
	}

} // ScriptEngineFactoryImpl
