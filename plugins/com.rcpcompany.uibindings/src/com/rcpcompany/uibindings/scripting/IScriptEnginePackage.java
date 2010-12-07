/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.scripting;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.rcpcompany.uibindings.IUIBindingsPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.rcpcompany.uibindings.scripting.IScriptEngineFactory
 * @generated
 */
public interface IScriptEnginePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "uibindings";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://rcp-company.com/schemas/uibindings/scriptEngine.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "scriptEngine";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	IScriptEnginePackage eINSTANCE = com.rcpcompany.uibindings.internal.scripting.ScriptEnginePackageImpl.init();

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.scripting.ScriptManagerImpl <em>Script Manager</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.rcpcompany.uibindings.internal.scripting.ScriptManagerImpl
	 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEnginePackageImpl#getScriptManager()
	 * @generated
	 */
	int SCRIPT_MANAGER = 0;

	/**
	 * The feature id for the '<em><b>Engines</b></em>' map.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_MANAGER__ENGINES = 0;

	/**
	 * The feature id for the '<em><b>Global Evaluation Context</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCRIPT_MANAGER__GLOBAL_EVALUATION_CONTEXT = 1;

	/**
	 * The feature id for the '<em><b>Registered Evaluation Contexts</b></em>' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCRIPT_MANAGER__REGISTERED_EVALUATION_CONTEXTS = 2;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCRIPT_MANAGER__DEPENDENCIES = 3;

	/**
	 * The number of structural features of the '<em>Script Manager</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_MANAGER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.scripting.ScriptEngineDescriptorImpl <em>Descriptor</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEngineDescriptorImpl
	 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEnginePackageImpl#getScriptEngineDescriptor()
	 * @generated
	 */
	int SCRIPT_ENGINE_DESCRIPTOR = 1;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_ENGINE_DESCRIPTOR__LANGUAGE = 0;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_ENGINE_DESCRIPTOR__EXPRESSIONS = 1;

	/**
	 * The feature id for the '<em><b>Engine</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_ENGINE_DESCRIPTOR__ENGINE = 2;

	/**
	 * The number of structural features of the '<em>Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_ENGINE_DESCRIPTOR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.scripting.ScriptEngineImpl <em>Script Engine</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEngineImpl
	 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEnginePackageImpl#getScriptEngine()
	 * @generated
	 */
	int SCRIPT_ENGINE = 2;

	/**
	 * The number of structural features of the '<em>Script Engine</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_ENGINE_FEATURE_COUNT = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.scripting.ScriptEvaluationContextImpl <em>Script Evaluation Context</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEvaluationContextImpl
	 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEnginePackageImpl#getScriptEvaluationContext()
	 * @generated
	 */
	int SCRIPT_EVALUATION_CONTEXT = 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EVALUATION_CONTEXT__PARENT = 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EVALUATION_CONTEXT__CHILDREN = 1;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' map.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EVALUATION_CONTEXT__VARIABLES = 2;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EVALUATION_CONTEXT__EXPRESSIONS = 3;

	/**
	 * The number of structural features of the '<em>Script Evaluation Context</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EVALUATION_CONTEXT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.scripting.ScriptExpressionImpl <em>Script Expression</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.rcpcompany.uibindings.internal.scripting.ScriptExpressionImpl
	 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEnginePackageImpl#getScriptExpression()
	 * @generated
	 */
	int SCRIPT_EXPRESSION = 4;

	/**
	 * The feature id for the '<em><b>Engine</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EXPRESSION__ENGINE = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Evaluation Context</b></em>' reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EXPRESSION__EVALUATION_CONTEXT = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Script</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EXPRESSION__SCRIPT = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EXPRESSION__DEPENDENCIES = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Expected Value Class</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EXPRESSION__EXPECTED_VALUE_CLASS = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EXPRESSION__CURRENT_VALUE = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Observable Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EXPRESSION__OBSERVABLE_VALUE = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Error Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EXPRESSION__ERROR_MESSAGE = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Script Expression</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EXPRESSION_FEATURE_COUNT = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.scripting.ScriptDependencyImpl <em>Script Dependency</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.rcpcompany.uibindings.internal.scripting.ScriptDependencyImpl
	 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEnginePackageImpl#getScriptDependency()
	 * @generated
	 */
	int SCRIPT_DEPENDENCY = 5;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_DEPENDENCY__OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_DEPENDENCY__FEATURE = 1;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_DEPENDENCY__EXPRESSIONS = 2;

	/**
	 * The number of structural features of the '<em>Script Dependency</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCRIPT_DEPENDENCY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.scripting.StringToScriptEngineMapEntryImpl
	 * <em>String To Script Engine Map Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.scripting.StringToScriptEngineMapEntryImpl
	 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEnginePackageImpl#getStringToScriptEngineMapEntry()
	 * @generated
	 */
	int STRING_TO_SCRIPT_ENGINE_MAP_ENTRY = 6;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_SCRIPT_ENGINE_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_SCRIPT_ENGINE_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Script Engine Map Entry</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_SCRIPT_ENGINE_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.scripting.EObjectToScriptEngineMapEntryImpl <em>EObject To Script Engine Map Entry</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see com.rcpcompany.uibindings.internal.scripting.EObjectToScriptEngineMapEntryImpl
	 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEnginePackageImpl#getEObjectToScriptEngineMapEntry()
	 * @generated
	 */
	int EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY = 7;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EObject To Script Engine Map Entry</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.scripting.IScriptManager <em>Script Manager</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script Manager</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptManager
	 * @generated
	 */
	EClass getScriptManager();

	/**
	 * Returns the meta object for the map '
	 * {@link com.rcpcompany.uibindings.scripting.IScriptManager#getEngines <em>Engines</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the map '<em>Engines</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptManager#getEngines()
	 * @see #getScriptManager()
	 * @generated
	 */
	EReference getScriptManager_Engines();

	/**
	 * Returns the meta object for the reference '{@link com.rcpcompany.uibindings.scripting.IScriptManager#getGlobalEvaluationContext <em>Global Evaluation Context</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Global Evaluation Context</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptManager#getGlobalEvaluationContext()
	 * @see #getScriptManager()
	 * @generated
	 */
	EReference getScriptManager_GlobalEvaluationContext();

	/**
	 * Returns the meta object for the map '{@link com.rcpcompany.uibindings.scripting.IScriptManager#getRegisteredEvaluationContexts <em>Registered Evaluation Contexts</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Registered Evaluation Contexts</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptManager#getRegisteredEvaluationContexts()
	 * @see #getScriptManager()
	 * @generated
	 */
	EReference getScriptManager_RegisteredEvaluationContexts();

	/**
	 * Returns the meta object for the containment reference list '{@link com.rcpcompany.uibindings.scripting.IScriptManager#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptManager#getDependencies()
	 * @see #getScriptManager()
	 * @generated
	 */
	EReference getScriptManager_Dependencies();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descriptor</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor
	 * @generated
	 */
	EClass getScriptEngineDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor#getLanguage()
	 * @see #getScriptEngineDescriptor()
	 * @generated
	 */
	EAttribute getScriptEngineDescriptor_Language();

	/**
	 * Returns the meta object for the containment reference list '{@link com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor#getExpressions()
	 * @see #getScriptEngineDescriptor()
	 * @generated
	 */
	EReference getScriptEngineDescriptor_Expressions();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor#getEngine <em>Engine</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Engine</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor#getEngine()
	 * @see #getScriptEngineDescriptor()
	 * @generated
	 */
	EAttribute getScriptEngineDescriptor_Engine();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.scripting.IScriptEngine <em>Script Engine</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script Engine</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEngine
	 * @generated
	 */
	EClass getScriptEngine();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.scripting.IScriptEvaluationContext <em>Script Evaluation Context</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script Evaluation Context</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEvaluationContext
	 * @generated
	 */
	EClass getScriptEvaluationContext();

	/**
	 * Returns the meta object for the reference '{@link com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getParent()
	 * @see #getScriptEvaluationContext()
	 * @generated
	 */
	EReference getScriptEvaluationContext_Parent();

	/**
	 * Returns the meta object for the reference list '{@link com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getChildren()
	 * @see #getScriptEvaluationContext()
	 * @generated
	 */
	EReference getScriptEvaluationContext_Children();

	/**
	 * Returns the meta object for the map '{@link com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Variables</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getVariables()
	 * @see #getScriptEvaluationContext()
	 * @generated
	 */
	EReference getScriptEvaluationContext_Variables();

	/**
	 * Returns the meta object for the reference list '{@link com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Expressions</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getExpressions()
	 * @see #getScriptEvaluationContext()
	 * @generated
	 */
	EReference getScriptEvaluationContext_Expressions();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.scripting.IScriptExpression <em>Script Expression</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script Expression</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptExpression
	 * @generated
	 */
	EClass getScriptExpression();

	/**
	 * Returns the meta object for the container reference '{@link com.rcpcompany.uibindings.scripting.IScriptExpression#getEngine <em>Engine</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Engine</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptExpression#getEngine()
	 * @see #getScriptExpression()
	 * @generated
	 */
	EReference getScriptExpression_Engine();

	/**
	 * Returns the meta object for the reference '{@link com.rcpcompany.uibindings.scripting.IScriptExpression#getEvaluationContext <em>Evaluation Context</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Evaluation Context</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptExpression#getEvaluationContext()
	 * @see #getScriptExpression()
	 * @generated
	 */
	EReference getScriptExpression_EvaluationContext();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibindings.scripting.IScriptExpression#getScript <em>Script</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Script</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptExpression#getScript()
	 * @see #getScriptExpression()
	 * @generated
	 */
	EAttribute getScriptExpression_Script();

	/**
	 * Returns the meta object for the reference list '{@link com.rcpcompany.uibindings.scripting.IScriptExpression#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptExpression#getDependencies()
	 * @see #getScriptExpression()
	 * @generated
	 */
	EReference getScriptExpression_Dependencies();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibindings.scripting.IScriptExpression#getExpectedValueClass <em>Expected Value Class</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expected Value Class</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptExpression#getExpectedValueClass()
	 * @see #getScriptExpression()
	 * @generated
	 */
	EAttribute getScriptExpression_ExpectedValueClass();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibindings.scripting.IScriptExpression#getCurrentValue <em>Current Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Value</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptExpression#getCurrentValue()
	 * @see #getScriptExpression()
	 * @generated
	 */
	EAttribute getScriptExpression_CurrentValue();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibindings.scripting.IScriptExpression#getObservableValue <em>Observable Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Observable Value</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptExpression#getObservableValue()
	 * @see #getScriptExpression()
	 * @generated
	 */
	EAttribute getScriptExpression_ObservableValue();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibindings.scripting.IScriptExpression#getErrorMessage <em>Error Message</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Message</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptExpression#getErrorMessage()
	 * @see #getScriptExpression()
	 * @generated
	 */
	EAttribute getScriptExpression_ErrorMessage();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.scripting.IScriptDependency <em>Script Dependency</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script Dependency</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptDependency
	 * @generated
	 */
	EClass getScriptDependency();

	/**
	 * Returns the meta object for the reference '{@link com.rcpcompany.uibindings.scripting.IScriptDependency#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptDependency#getObject()
	 * @see #getScriptDependency()
	 * @generated
	 */
	EReference getScriptDependency_Object();

	/**
	 * Returns the meta object for the reference '{@link com.rcpcompany.uibindings.scripting.IScriptDependency#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptDependency#getFeature()
	 * @see #getScriptDependency()
	 * @generated
	 */
	EReference getScriptDependency_Feature();

	/**
	 * Returns the meta object for the reference list '{@link com.rcpcompany.uibindings.scripting.IScriptDependency#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Expressions</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IScriptDependency#getExpressions()
	 * @see #getScriptDependency()
	 * @generated
	 */
	EReference getScriptDependency_Expressions();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To Script Engine Map Entry</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To Script Engine Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	EClass getStringToScriptEngineMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToScriptEngineMapEntry()
	 * @generated
	 */
	EAttribute getStringToScriptEngineMapEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToScriptEngineMapEntry()
	 * @generated
	 */
	EReference getStringToScriptEngineMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EObject To Script Engine Map Entry</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject To Script Engine Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	EClass getEObjectToScriptEngineMapEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEObjectToScriptEngineMapEntry()
	 * @generated
	 */
	EReference getEObjectToScriptEngineMapEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEObjectToScriptEngineMapEntry()
	 * @generated
	 */
	EReference getEObjectToScriptEngineMapEntry_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IScriptEngineFactory getScriptEngineFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.internal.scripting.ScriptManagerImpl <em>Script Manager</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.rcpcompany.uibindings.internal.scripting.ScriptManagerImpl
		 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEnginePackageImpl#getScriptManager()
		 * @generated
		 */
		EClass SCRIPT_MANAGER = eINSTANCE.getScriptManager();

		/**
		 * The meta object literal for the '<em><b>Engines</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SCRIPT_MANAGER__ENGINES = eINSTANCE.getScriptManager_Engines();

		/**
		 * The meta object literal for the '<em><b>Global Evaluation Context</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT_MANAGER__GLOBAL_EVALUATION_CONTEXT = eINSTANCE.getScriptManager_GlobalEvaluationContext();

		/**
		 * The meta object literal for the '<em><b>Registered Evaluation Contexts</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT_MANAGER__REGISTERED_EVALUATION_CONTEXTS = eINSTANCE.getScriptManager_RegisteredEvaluationContexts();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT_MANAGER__DEPENDENCIES = eINSTANCE.getScriptManager_Dependencies();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.internal.scripting.ScriptEngineDescriptorImpl <em>Descriptor</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEngineDescriptorImpl
		 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEnginePackageImpl#getScriptEngineDescriptor()
		 * @generated
		 */
		EClass SCRIPT_ENGINE_DESCRIPTOR = eINSTANCE.getScriptEngineDescriptor();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SCRIPT_ENGINE_DESCRIPTOR__LANGUAGE = eINSTANCE.getScriptEngineDescriptor_Language();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT_ENGINE_DESCRIPTOR__EXPRESSIONS = eINSTANCE.getScriptEngineDescriptor_Expressions();

		/**
		 * The meta object literal for the '<em><b>Engine</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SCRIPT_ENGINE_DESCRIPTOR__ENGINE = eINSTANCE.getScriptEngineDescriptor_Engine();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.internal.scripting.ScriptEngineImpl <em>Script Engine</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEngineImpl
		 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEnginePackageImpl#getScriptEngine()
		 * @generated
		 */
		EClass SCRIPT_ENGINE = eINSTANCE.getScriptEngine();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.internal.scripting.ScriptEvaluationContextImpl <em>Script Evaluation Context</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEvaluationContextImpl
		 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEnginePackageImpl#getScriptEvaluationContext()
		 * @generated
		 */
		EClass SCRIPT_EVALUATION_CONTEXT = eINSTANCE.getScriptEvaluationContext();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SCRIPT_EVALUATION_CONTEXT__PARENT = eINSTANCE.getScriptEvaluationContext_Parent();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SCRIPT_EVALUATION_CONTEXT__CHILDREN = eINSTANCE.getScriptEvaluationContext_Children();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SCRIPT_EVALUATION_CONTEXT__VARIABLES = eINSTANCE.getScriptEvaluationContext_Variables();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT_EVALUATION_CONTEXT__EXPRESSIONS = eINSTANCE.getScriptEvaluationContext_Expressions();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.internal.scripting.ScriptExpressionImpl <em>Script Expression</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.rcpcompany.uibindings.internal.scripting.ScriptExpressionImpl
		 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEnginePackageImpl#getScriptExpression()
		 * @generated
		 */
		EClass SCRIPT_EXPRESSION = eINSTANCE.getScriptExpression();

		/**
		 * The meta object literal for the '<em><b>Engine</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT_EXPRESSION__ENGINE = eINSTANCE.getScriptExpression_Engine();

		/**
		 * The meta object literal for the '<em><b>Evaluation Context</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT_EXPRESSION__EVALUATION_CONTEXT = eINSTANCE.getScriptExpression_EvaluationContext();

		/**
		 * The meta object literal for the '<em><b>Script</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SCRIPT_EXPRESSION__SCRIPT = eINSTANCE.getScriptExpression_Script();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT_EXPRESSION__DEPENDENCIES = eINSTANCE.getScriptExpression_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Expected Value Class</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPT_EXPRESSION__EXPECTED_VALUE_CLASS = eINSTANCE.getScriptExpression_ExpectedValueClass();

		/**
		 * The meta object literal for the '<em><b>Current Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SCRIPT_EXPRESSION__CURRENT_VALUE = eINSTANCE.getScriptExpression_CurrentValue();

		/**
		 * The meta object literal for the '<em><b>Observable Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPT_EXPRESSION__OBSERVABLE_VALUE = eINSTANCE.getScriptExpression_ObservableValue();

		/**
		 * The meta object literal for the '<em><b>Error Message</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SCRIPT_EXPRESSION__ERROR_MESSAGE = eINSTANCE.getScriptExpression_ErrorMessage();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.internal.scripting.ScriptDependencyImpl <em>Script Dependency</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.rcpcompany.uibindings.internal.scripting.ScriptDependencyImpl
		 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEnginePackageImpl#getScriptDependency()
		 * @generated
		 */
		EClass SCRIPT_DEPENDENCY = eINSTANCE.getScriptDependency();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SCRIPT_DEPENDENCY__OBJECT = eINSTANCE.getScriptDependency_Object();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SCRIPT_DEPENDENCY__FEATURE = eINSTANCE.getScriptDependency_Feature();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT_DEPENDENCY__EXPRESSIONS = eINSTANCE.getScriptDependency_Expressions();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.internal.scripting.StringToScriptEngineMapEntryImpl <em>String To Script Engine Map Entry</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see com.rcpcompany.uibindings.internal.scripting.StringToScriptEngineMapEntryImpl
		 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEnginePackageImpl#getStringToScriptEngineMapEntry()
		 * @generated
		 */
		EClass STRING_TO_SCRIPT_ENGINE_MAP_ENTRY = eINSTANCE.getStringToScriptEngineMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_SCRIPT_ENGINE_MAP_ENTRY__KEY = eINSTANCE.getStringToScriptEngineMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STRING_TO_SCRIPT_ENGINE_MAP_ENTRY__VALUE = eINSTANCE.getStringToScriptEngineMapEntry_Value();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.internal.scripting.EObjectToScriptEngineMapEntryImpl <em>EObject To Script Engine Map Entry</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see com.rcpcompany.uibindings.internal.scripting.EObjectToScriptEngineMapEntryImpl
		 * @see com.rcpcompany.uibindings.internal.scripting.ScriptEnginePackageImpl#getEObjectToScriptEngineMapEntry()
		 * @generated
		 */
		EClass EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY = eINSTANCE.getEObjectToScriptEngineMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY__KEY = eINSTANCE.getEObjectToScriptEngineMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY__VALUE = eINSTANCE.getEObjectToScriptEngineMapEntry_Value();

	}

} // IScriptEnginePackage
