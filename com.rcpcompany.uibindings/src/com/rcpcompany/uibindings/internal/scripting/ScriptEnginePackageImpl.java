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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.scripting.IScriptDependency;
import com.rcpcompany.uibindings.scripting.IScriptEngine;
import com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor;
import com.rcpcompany.uibindings.scripting.IScriptEngineFactory;
import com.rcpcompany.uibindings.scripting.IScriptEnginePackage;
import com.rcpcompany.uibindings.scripting.IScriptEvaluationContext;
import com.rcpcompany.uibindings.scripting.IScriptExpression;
import com.rcpcompany.uibindings.scripting.IScriptManager;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ScriptEnginePackageImpl extends EPackageImpl implements IScriptEnginePackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass scriptManagerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass scriptEngineDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass scriptEngineEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass scriptEvaluationContextEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass scriptExpressionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass scriptDependencyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stringToScriptEngineMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass eObjectToScriptDependencyListMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass eObjectToScriptEngineMapEntryEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI
	 * value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init
	 * init()}, which also performs initialization of the package, or returns the registered
	 * package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ScriptEnginePackageImpl() {
		super(eNS_URI, IScriptEngineFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others
	 * upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link IScriptEnginePackage#eINSTANCE} when that field is
	 * accessed. Clients should not invoke it directly. Instead, they should simply access that
	 * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static IScriptEnginePackage init() {
		if (isInited)
			return (IScriptEnginePackage) EPackage.Registry.INSTANCE.getEPackage(IScriptEnginePackage.eNS_URI);

		// Obtain or create and register package
		final ScriptEnginePackageImpl theScriptEnginePackage = (ScriptEnginePackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof ScriptEnginePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
				: new ScriptEnginePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IUIBindingsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theScriptEnginePackage.createPackageContents();

		// Initialize created meta-data
		theScriptEnginePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theScriptEnginePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(IScriptEnginePackage.eNS_URI, theScriptEnginePackage);
		return theScriptEnginePackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getScriptManager() {
		return scriptManagerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getScriptManager_Engines() {
		return (EReference) scriptManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getScriptManager_GlobalEvaluationContext() {
		return (EReference) scriptManagerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getScriptManager_RegisteredEvaluationContexts() {
		return (EReference) scriptManagerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getScriptManager_Dependencies() {
		return (EReference) scriptManagerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getScriptEngineDescriptor() {
		return scriptEngineDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getScriptEngineDescriptor_Language() {
		return (EAttribute) scriptEngineDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getScriptEngineDescriptor_Expressions() {
		return (EReference) scriptEngineDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getScriptEngineDescriptor_Engine() {
		return (EAttribute) scriptEngineDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getScriptEngine() {
		return scriptEngineEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getScriptEvaluationContext() {
		return scriptEvaluationContextEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getScriptEvaluationContext_Parent() {
		return (EReference) scriptEvaluationContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getScriptEvaluationContext_Children() {
		return (EReference) scriptEvaluationContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getScriptEvaluationContext_Variables() {
		return (EReference) scriptEvaluationContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getScriptEvaluationContext_Expressions() {
		return (EReference) scriptEvaluationContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getScriptExpression() {
		return scriptExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getScriptExpression_Engine() {
		return (EReference) scriptExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getScriptExpression_EvaluationContext() {
		return (EReference) scriptExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getScriptExpression_Script() {
		return (EAttribute) scriptExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getScriptExpression_Dependencies() {
		return (EReference) scriptExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getScriptExpression_ExpectedValueClass() {
		return (EAttribute) scriptExpressionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getScriptExpression_CurrentValue() {
		return (EAttribute) scriptExpressionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getScriptExpression_ObservableValue() {
		return (EAttribute) scriptExpressionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getScriptExpression_ErrorMessage() {
		return (EAttribute) scriptExpressionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getScriptDependency() {
		return scriptDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getScriptDependency_Object() {
		return (EReference) scriptDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getScriptDependency_Feature() {
		return (EReference) scriptDependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getScriptDependency_Expressions() {
		return (EReference) scriptDependencyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getScriptDependency_Index() {
		return (EAttribute) scriptDependencyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getScriptDependency_Key() {
		return (EAttribute) scriptDependencyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getStringToScriptEngineMapEntry() {
		return stringToScriptEngineMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStringToScriptEngineMapEntry_Key() {
		return (EAttribute) stringToScriptEngineMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getStringToScriptEngineMapEntry_Value() {
		return (EReference) stringToScriptEngineMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getEObjectToScriptDependencyListMapEntry() {
		return eObjectToScriptDependencyListMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getEObjectToScriptDependencyListMapEntry_Key() {
		return (EReference) eObjectToScriptDependencyListMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getEObjectToScriptDependencyListMapEntry_Value() {
		return (EReference) eObjectToScriptDependencyListMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getEObjectToScriptEngineMapEntry() {
		return eObjectToScriptEngineMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getEObjectToScriptEngineMapEntry_Key() {
		return (EReference) eObjectToScriptEngineMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getEObjectToScriptEngineMapEntry_Value() {
		return (EReference) eObjectToScriptEngineMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IScriptEngineFactory getScriptEngineFactory() {
		return (IScriptEngineFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to have no affect on
	 * any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		scriptManagerEClass = createEClass(SCRIPT_MANAGER);
		createEReference(scriptManagerEClass, SCRIPT_MANAGER__ENGINES);
		createEReference(scriptManagerEClass, SCRIPT_MANAGER__GLOBAL_EVALUATION_CONTEXT);
		createEReference(scriptManagerEClass, SCRIPT_MANAGER__REGISTERED_EVALUATION_CONTEXTS);
		createEReference(scriptManagerEClass, SCRIPT_MANAGER__DEPENDENCIES);

		scriptEngineDescriptorEClass = createEClass(SCRIPT_ENGINE_DESCRIPTOR);
		createEAttribute(scriptEngineDescriptorEClass, SCRIPT_ENGINE_DESCRIPTOR__LANGUAGE);
		createEReference(scriptEngineDescriptorEClass, SCRIPT_ENGINE_DESCRIPTOR__EXPRESSIONS);
		createEAttribute(scriptEngineDescriptorEClass, SCRIPT_ENGINE_DESCRIPTOR__ENGINE);

		scriptEngineEClass = createEClass(SCRIPT_ENGINE);

		scriptEvaluationContextEClass = createEClass(SCRIPT_EVALUATION_CONTEXT);
		createEReference(scriptEvaluationContextEClass, SCRIPT_EVALUATION_CONTEXT__PARENT);
		createEReference(scriptEvaluationContextEClass, SCRIPT_EVALUATION_CONTEXT__CHILDREN);
		createEReference(scriptEvaluationContextEClass, SCRIPT_EVALUATION_CONTEXT__VARIABLES);
		createEReference(scriptEvaluationContextEClass, SCRIPT_EVALUATION_CONTEXT__EXPRESSIONS);

		scriptExpressionEClass = createEClass(SCRIPT_EXPRESSION);
		createEReference(scriptExpressionEClass, SCRIPT_EXPRESSION__ENGINE);
		createEReference(scriptExpressionEClass, SCRIPT_EXPRESSION__EVALUATION_CONTEXT);
		createEAttribute(scriptExpressionEClass, SCRIPT_EXPRESSION__SCRIPT);
		createEReference(scriptExpressionEClass, SCRIPT_EXPRESSION__DEPENDENCIES);
		createEAttribute(scriptExpressionEClass, SCRIPT_EXPRESSION__EXPECTED_VALUE_CLASS);
		createEAttribute(scriptExpressionEClass, SCRIPT_EXPRESSION__CURRENT_VALUE);
		createEAttribute(scriptExpressionEClass, SCRIPT_EXPRESSION__OBSERVABLE_VALUE);
		createEAttribute(scriptExpressionEClass, SCRIPT_EXPRESSION__ERROR_MESSAGE);

		scriptDependencyEClass = createEClass(SCRIPT_DEPENDENCY);
		createEReference(scriptDependencyEClass, SCRIPT_DEPENDENCY__OBJECT);
		createEReference(scriptDependencyEClass, SCRIPT_DEPENDENCY__FEATURE);
		createEReference(scriptDependencyEClass, SCRIPT_DEPENDENCY__EXPRESSIONS);
		createEAttribute(scriptDependencyEClass, SCRIPT_DEPENDENCY__INDEX);
		createEAttribute(scriptDependencyEClass, SCRIPT_DEPENDENCY__KEY);

		stringToScriptEngineMapEntryEClass = createEClass(STRING_TO_SCRIPT_ENGINE_MAP_ENTRY);
		createEAttribute(stringToScriptEngineMapEntryEClass, STRING_TO_SCRIPT_ENGINE_MAP_ENTRY__KEY);
		createEReference(stringToScriptEngineMapEntryEClass, STRING_TO_SCRIPT_ENGINE_MAP_ENTRY__VALUE);

		eObjectToScriptDependencyListMapEntryEClass = createEClass(EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY);
		createEReference(eObjectToScriptDependencyListMapEntryEClass, EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY__KEY);
		createEReference(eObjectToScriptDependencyListMapEntryEClass,
				EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY__VALUE);

		eObjectToScriptEngineMapEntryEClass = createEClass(EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY);
		createEReference(eObjectToScriptEngineMapEntryEClass, EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY__KEY);
		createEReference(eObjectToScriptEngineMapEntryEClass, EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY__VALUE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is guarded to have
	 * no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		final IUIBindingsPackage theUIBindingsPackage = (IUIBindingsPackage) EPackage.Registry.INSTANCE
				.getEPackage(IUIBindingsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		scriptEngineEClass.getESuperTypes().add(theUIBindingsPackage.getIDisposable());
		scriptExpressionEClass.getESuperTypes().add(theUIBindingsPackage.getIDisposable());

		// Initialize classes and features; add operations and parameters
		initEClass(scriptManagerEClass, IScriptManager.class, "ScriptManager", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScriptManager_Engines(), this.getStringToScriptEngineMapEntry(), null, "engines", null, 0,
				-1, IScriptManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptManager_GlobalEvaluationContext(), this.getScriptEvaluationContext(), null,
				"globalEvaluationContext", null, 0, 1, IScriptManager.class, IS_TRANSIENT, !IS_VOLATILE,
				!IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptManager_RegisteredEvaluationContexts(), this.getEObjectToScriptEngineMapEntry(), null,
				"registeredEvaluationContexts", null, 0, -1, IScriptManager.class, IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptManager_Dependencies(), this.getEObjectToScriptDependencyListMapEntry(), null,
				"dependencies", null, 0, -1, IScriptManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scriptEngineDescriptorEClass, IScriptEngineDescriptor.class, "ScriptEngineDescriptor", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScriptEngineDescriptor_Language(), ecorePackage.getEString(), "language", null, 1, 1,
				IScriptEngineDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptEngineDescriptor_Expressions(), this.getScriptExpression(),
				this.getScriptExpression_Engine(), "expressions", null, 0, -1, IScriptEngineDescriptor.class,
				IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(theUIBindingsPackage.getCEObjectHolder());
		EGenericType g2 = createEGenericType(this.getScriptEngine());
		g1.getETypeArguments().add(g2);
		initEAttribute(getScriptEngineDescriptor_Engine(), g1, "engine", null, 0, 1, IScriptEngineDescriptor.class,
				IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scriptEngineEClass, IScriptEngine.class, "ScriptEngine", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(scriptEvaluationContextEClass, IScriptEvaluationContext.class, "ScriptEvaluationContext",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScriptEvaluationContext_Parent(), this.getScriptEvaluationContext(),
				this.getScriptEvaluationContext_Children(), "parent", null, 0, 1, IScriptEvaluationContext.class,
				IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptEvaluationContext_Children(), this.getScriptEvaluationContext(),
				this.getScriptEvaluationContext_Parent(), "children", null, 0, -1, IScriptEvaluationContext.class,
				IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptEvaluationContext_Variables(), theUIBindingsPackage.getStringToObjectMapEntry(), null,
				"variables", null, 0, -1, IScriptEvaluationContext.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptEvaluationContext_Expressions(), this.getScriptExpression(),
				this.getScriptExpression_EvaluationContext(), "expressions", null, 0, -1,
				IScriptEvaluationContext.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scriptExpressionEClass, IScriptExpression.class, "ScriptExpression", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScriptExpression_Engine(), this.getScriptEngineDescriptor(),
				this.getScriptEngineDescriptor_Expressions(), "engine", null, 1, 1, IScriptExpression.class,
				IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptExpression_EvaluationContext(), this.getScriptEvaluationContext(),
				this.getScriptEvaluationContext_Expressions(), "evaluationContext", null, 1, 1,
				IScriptExpression.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScriptExpression_Script(), ecorePackage.getEString(), "script", null, 1, 1,
				IScriptExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getScriptExpression_Dependencies(), this.getScriptDependency(),
				this.getScriptDependency_Expressions(), "dependencies", null, 0, -1, IScriptExpression.class,
				IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(getScriptExpression_ExpectedValueClass(), g1, "expectedValueClass", null, 1, 1,
				IScriptExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getScriptExpression_CurrentValue(), ecorePackage.getEJavaObject(), "currentValue", null, 0, 1,
				IScriptExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getScriptExpression_ObservableValue(), theUIBindingsPackage.getIObservableValue(),
				"observableValue", null, 1, 1, IScriptExpression.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScriptExpression_ErrorMessage(), ecorePackage.getEString(), "errorMessage", null, 0, 1,
				IScriptExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(scriptDependencyEClass, IScriptDependency.class, "ScriptDependency", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScriptDependency_Object(), ecorePackage.getEObject(), null, "object", null, 1, 1,
				IScriptDependency.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptDependency_Feature(), ecorePackage.getEStructuralFeature(), null, "feature", null, 1,
				1, IScriptDependency.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptDependency_Expressions(), this.getScriptExpression(),
				this.getScriptExpression_Dependencies(), "expressions", null, 0, -1, IScriptDependency.class,
				IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScriptDependency_Index(), ecorePackage.getEInt(), "index", "-1", 0, 1,
				IScriptDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getScriptDependency_Key(), ecorePackage.getEJavaObject(), "key", null, 0, 1,
				IScriptDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(stringToScriptEngineMapEntryEClass, Map.Entry.class, "StringToScriptEngineMapEntry", !IS_ABSTRACT,
				!IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringToScriptEngineMapEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1,
				Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getStringToScriptEngineMapEntry_Value(), this.getScriptEngineDescriptor(), null, "value", null,
				1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eObjectToScriptDependencyListMapEntryEClass, Map.Entry.class,
				"EObjectToScriptDependencyListMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEObjectToScriptDependencyListMapEntry_Key(), ecorePackage.getEObject(), null, "key", null, 1,
				1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEObjectToScriptDependencyListMapEntry_Value(), this.getScriptDependency(), null, "value",
				null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eObjectToScriptEngineMapEntryEClass, Map.Entry.class, "EObjectToScriptEngineMapEntry", !IS_ABSTRACT,
				!IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEObjectToScriptEngineMapEntry_Key(), ecorePackage.getEObject(), null, "key", null, 0, 1,
				Map.Entry.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEObjectToScriptEngineMapEntry_Value(), this.getScriptEvaluationContext(), null, "value",
				null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // ScriptEnginePackageImpl
