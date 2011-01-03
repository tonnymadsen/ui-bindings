/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.scripting.utils;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.scripting.*;
import com.rcpcompany.uibindings.scripting.IScriptDependency;
import com.rcpcompany.uibindings.scripting.IScriptEngine;
import com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor;
import com.rcpcompany.uibindings.scripting.IScriptEnginePackage;
import com.rcpcompany.uibindings.scripting.IScriptEvaluationContext;
import com.rcpcompany.uibindings.scripting.IScriptExpression;
import com.rcpcompany.uibindings.scripting.IScriptManager;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage
 * @generated
 */
public class ScriptEngineSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static IScriptEnginePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptEngineSwitch() {
		if (modelPackage == null) {
			modelPackage = IScriptEnginePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case IScriptEnginePackage.SCRIPT_MANAGER: {
				IScriptManager scriptManager = (IScriptManager)theEObject;
				T result = caseScriptManager(scriptManager);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IScriptEnginePackage.SCRIPT_ENGINE_DESCRIPTOR: {
				IScriptEngineDescriptor scriptEngineDescriptor = (IScriptEngineDescriptor)theEObject;
				T result = caseScriptEngineDescriptor(scriptEngineDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IScriptEnginePackage.SCRIPT_ENGINE: {
				IScriptEngine scriptEngine = (IScriptEngine)theEObject;
				T result = caseScriptEngine(scriptEngine);
				if (result == null) result = caseIDisposable(scriptEngine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT: {
				IScriptEvaluationContext scriptEvaluationContext = (IScriptEvaluationContext)theEObject;
				T result = caseScriptEvaluationContext(scriptEvaluationContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IScriptEnginePackage.SCRIPT_EXPRESSION: {
				IScriptExpression scriptExpression = (IScriptExpression)theEObject;
				T result = caseScriptExpression(scriptExpression);
				if (result == null) result = caseIDisposable(scriptExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IScriptEnginePackage.SCRIPT_DEPENDENCY: {
				IScriptDependency scriptDependency = (IScriptDependency)theEObject;
				T result = caseScriptDependency(scriptDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IScriptEnginePackage.STRING_TO_SCRIPT_ENGINE_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, IScriptEngineDescriptor> stringToScriptEngineMapEntry = (Map.Entry<String, IScriptEngineDescriptor>)theEObject;
				T result = caseStringToScriptEngineMapEntry(stringToScriptEngineMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IScriptEnginePackage.EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<EObject, EList<IScriptDependency>> eObjectToScriptDependencyListMapEntry = (Map.Entry<EObject, EList<IScriptDependency>>)theEObject;
				T result = caseEObjectToScriptDependencyListMapEntry(eObjectToScriptDependencyListMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IScriptEnginePackage.EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<EObject, IScriptEvaluationContext> eObjectToScriptEngineMapEntry = (Map.Entry<EObject, IScriptEvaluationContext>)theEObject;
				T result = caseEObjectToScriptEngineMapEntry(eObjectToScriptEngineMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Script Manager</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScriptManager(IScriptManager object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Descriptor</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScriptEngineDescriptor(IScriptEngineDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Script Engine</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script Engine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScriptEngine(IScriptEngine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Script Evaluation Context</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script Evaluation Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScriptEvaluationContext(IScriptEvaluationContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Script Expression</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScriptExpression(IScriptExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Script Dependency</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScriptDependency(IScriptDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To Script Engine Map Entry</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To Script Engine Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToScriptEngineMapEntry(Map.Entry<String, IScriptEngineDescriptor> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject To Script Dependency List Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject To Script Dependency List Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEObjectToScriptDependencyListMapEntry(Map.Entry<EObject, EList<IScriptDependency>> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject To Script Engine Map Entry</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject To Script Engine Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEObjectToScriptEngineMapEntry(Map.Entry<EObject, IScriptEvaluationContext> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IDisposable</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDisposable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDisposable(IDisposable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} // ScriptEngineSwitch
