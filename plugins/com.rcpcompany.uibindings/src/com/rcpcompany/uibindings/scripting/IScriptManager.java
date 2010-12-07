/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.scripting;

import java.util.Map;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.internal.scripting.ScriptManagerImpl;

/**
 * <!-- begin-user-doc -->
 * 
 * The manager for all things needed for the scripting.
 * 
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.scripting.IScriptManager#getEngines <em>Engines</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.scripting.IScriptManager#getGlobalEvaluationContext <em>
 * Global Evaluation Context</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.scripting.IScriptManager#getRegisteredEvaluationContexts
 * <em>Registered Evaluation Contexts</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.scripting.IScriptManager#getDependencies <em>Dependencies
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptManager()
 * @generated
 */
public interface IScriptManager extends EObject {
	/**
	 * Factory methods for the manager.
	 */
	public static class Factory {
		private Factory() {
		}

		/**
		 * Returns the singleton manager.
		 * 
		 * @return the manager
		 */
		public static IScriptManager getManager() {
			return ScriptManagerImpl.getManager();
		}

		/**
		 * Adds a new script.
		 * 
		 * @param language the language of the script
		 * @param script the script itself
		 * @param expectedClass the expected class of the result
		 * @param parentEvaluationContext parent evaluation context
		 * @param localVariables any local variables - or <code>null</code>
		 * @return a expression for the script
		 * @throws ScriptEngineException if no engine exists for the specified language
		 */
		public static IScriptExpression addScript(String language, String script, Class<?> expectedClass,
				IScriptEvaluationContext parentEvaluationContext, Map<String, Object> localVariables)
				throws ScriptEngineException {
			return getManager().addScript(language, script, expectedClass, parentEvaluationContext, localVariables);
		}
	}

	/**
	 * Return value of {@link IScriptEngineDescriptor#getLanguage()} for JavaScript.
	 */
	String LANGUAGE_JAVA_SCRIPT = "js";

	/**
	 * Return value of {@link IScriptEngineDescriptor#getLanguage()} for Simple Variables.
	 */
	String LANGUAGE_SIMPLE_VARIABLES = "simple";

	/**
	 * Returns the value of the '<em><b>Engines</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type
	 * {@link com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor}, <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engines</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Engines</em>' map.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptManager_Engines()
	 * @generated
	 */
	EMap<String, IScriptEngineDescriptor> getEngines();

	/**
	 * Returns the value of the '<em><b>Global Evaluation Context</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Evaluation Context</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Global Evaluation Context</em>' reference.
	 * @see #setGlobalEvaluationContext(IScriptEvaluationContext)
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptManager_GlobalEvaluationContext()
	 * @generated
	 */
	IScriptEvaluationContext getGlobalEvaluationContext();

	/**
	 * Returns the value of the '<em><b>Registered Evaluation Contexts</b></em>' map. The key is of
	 * type {@link org.eclipse.emf.ecore.EObject}, and the value is of type
	 * {@link com.rcpcompany.uibindings.scripting.IScriptEvaluationContext}, <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registered Evaluation Contexts</em>' map isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Registered Evaluation Contexts</em>' map.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptManager_RegisteredEvaluationContexts()
	 * @generated
	 */
	EMap<EObject, IScriptEvaluationContext> getRegisteredEvaluationContexts();

	/**
	 * Returns the evaluation context for use with the specified object.
	 * <p>
	 * It is based on {@link #getRegisteredEvaluationContexts()} and the containment heirarchy of
	 * the object.
	 * <p>
	 * If no context can be found, it falls back on {@link #getGlobalEvaluationContext()}.
	 * 
	 * @param obj the object
	 * @return the evaluation context
	 */
	IScriptEvaluationContext getRegisteredEvaluationContext(EObject obj);

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.scripting.IScriptDependency}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Dependencies</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptManager_Dependencies()
	 * @generated
	 */
	EList<IScriptDependency> getDependencies();

	/**
	 * Adds a new script.
	 * 
	 * @param language the language of the script
	 * @param script the script itself
	 * @param expectedClass the expected class of the result
	 * @param parentEvaluationContext parent evaluation context or <code>null</code> if the global
	 *            context should be used
	 * @param localVariables any local variables - or <code>null</code>
	 * @return a expression for the script
	 * @throws ScriptEngineException if the language does not have an associated engine
	 */
	IScriptExpression addScript(String language, String script, Class<?> expectedClass,
			IScriptEvaluationContext parentEvaluationContext, Map<String, Object> localVariables)
			throws ScriptEngineException;

	/**
	 * Returns an evaluation context for the specified parent evaluation context and set of
	 * additional local variables.
	 * <p>
	 * This method will try to reuse any existing context before creating a new context.
	 * 
	 * @param evaluationContext parent evaluation context or <code>null</code> if the global context
	 *            should be used
	 * @param localVariables the extra local variables or <code>null</code>
	 * @return the resulting context
	 */
	IScriptEvaluationContext getEvaluationContext(IScriptEvaluationContext evaluationContext,
			Map<String, Object> localVariables);

	/**
	 * Returns and observable list for all the current languages.
	 * <p>
	 * For use in UI...
	 * 
	 * @return the list
	 */
	IObservableList getLanguageList();
} // IScriptManager
