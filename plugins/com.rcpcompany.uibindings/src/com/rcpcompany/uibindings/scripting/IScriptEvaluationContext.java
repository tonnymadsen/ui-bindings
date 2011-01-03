/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.scripting;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Script Evaluation Context</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getParent <em>Parent</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getChildren <em>Children</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getVariables <em>Variables</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptEvaluationContext()
 * @generated
 */
public interface IScriptEvaluationContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(IScriptEvaluationContext)
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptEvaluationContext_Parent()
	 * @see com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getChildren
	 * @generated
	 */
	IScriptEvaluationContext getParent();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(IScriptEvaluationContext value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link com.rcpcompany.uibindings.scripting.IScriptEvaluationContext}.
	 * It is bidirectional and its opposite is '{@link com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptEvaluationContext_Children()
	 * @see com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getParent
	 * @generated
	 */
	EList<IScriptEvaluationContext> getChildren();

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type {@link java.lang.Object}, <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' map isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Variables</em>' map.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptEvaluationContext_Variables()
	 * @generated
	 */
	EMap<String, Object> getVariables();

	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' reference list.
	 * The list contents are of type {@link com.rcpcompany.uibindings.scripting.IScriptExpression}.
	 * It is bidirectional and its opposite is '{@link com.rcpcompany.uibindings.scripting.IScriptExpression#getEvaluationContext <em>Evaluation Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' reference list.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptEvaluationContext_Expressions()
	 * @see com.rcpcompany.uibindings.scripting.IScriptExpression#getEvaluationContext
	 * @generated
	 */
	EList<IScriptExpression> getExpressions();

	/**
	 * Collects the variables from this context - and all parent contexts - such that variables from
	 * parent contexts can be overruled by variables in child contexts.
	 * 
	 * @return the collected variables
	 */
	Map<String, Object> collectVariables();

	/**
	 * Re-evaluates all script expression this all all child evaluation contexts.
	 */
	void reevaluateExpressions();

} // IScriptEvaluationContext
