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
package com.rcpcompany.uibindings.scripting;

import java.util.List;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.IDisposable;

/**
 * <!-- begin-user-doc -->
 * 
 * The expression for a single script as created by {@link IScriptEngineDescriptor}
 * 
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.scripting.IScriptExpression#getEngine <em>Engine</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.scripting.IScriptExpression#getEvaluationContext <em>
 * Evaluation Context</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.scripting.IScriptExpression#getScript <em>Script</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.scripting.IScriptExpression#getDependencies <em>Dependencies
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.scripting.IScriptExpression#getExpectedValueClass <em>
 * Expected Value Class</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.scripting.IScriptExpression#getCurrentValue <em>Current
 * Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.scripting.IScriptExpression#getObservableValue <em>
 * Observable Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.scripting.IScriptExpression#getErrorMessage <em>Error
 * Message</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptExpression()
 * @generated
 */
public interface IScriptExpression extends EObject, IDisposable {
	/**
	 * Returns the value of the '<em><b>Engine</b></em>' container reference. It is bidirectional
	 * and its opposite is '
	 * {@link com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor#getExpressions
	 * <em>Expressions</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine</em>' container reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Engine</em>' container reference.
	 * @see #setEngine(IScriptEngineDescriptor)
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptExpression_Engine()
	 * @see com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor#getExpressions
	 * @generated
	 */
	IScriptEngineDescriptor getEngine();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.scripting.IScriptExpression#getEngine <em>Engine</em>}'
	 * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Engine</em>' container reference.
	 * @see #getEngine()
	 * @generated
	 */
	void setEngine(IScriptEngineDescriptor value);

	/**
	 * Returns the value of the '<em><b>Evaluation Context</b></em>' reference. It is bidirectional
	 * and its opposite is '
	 * {@link com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getExpressions
	 * <em>Expressions</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evaluation Context</em>' reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Evaluation Context</em>' reference.
	 * @see #setEvaluationContext(IScriptEvaluationContext)
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptExpression_EvaluationContext()
	 * @see com.rcpcompany.uibindings.scripting.IScriptEvaluationContext#getExpressions
	 * @generated
	 */
	IScriptEvaluationContext getEvaluationContext();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.scripting.IScriptExpression#getEvaluationContext
	 * <em>Evaluation Context</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Evaluation Context</em>' reference.
	 * @see #getEvaluationContext()
	 * @generated
	 */
	void setEvaluationContext(IScriptEvaluationContext value);

	/**
	 * Returns the value of the '<em><b>Script</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Script</em>' attribute.
	 * @see #setScript(String)
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptExpression_Script()
	 * @generated
	 */
	String getScript();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.scripting.IScriptExpression#getScript <em>Script</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Script</em>' attribute.
	 * @see #getScript()
	 * @generated
	 */
	void setScript(String value);

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
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptContext_Dependencies()
	 * @generated
	 */
	EList<IScriptDependency> getDependencies();

	/**
	 * Returns the value of the '<em><b>Expected Value Class</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expected Value Class</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Expected Value Class</em>' attribute.
	 * @see #setExpectedValueClass(Class)
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptExpression_ExpectedValueClass()
	 * @generated
	 */
	Class<?> getExpectedValueClass();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.scripting.IScriptExpression#getExpectedValueClass
	 * <em>Expected Value Class</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Expected Value Class</em>' attribute.
	 * @see #getExpectedValueClass()
	 * @generated
	 */
	void setExpectedValueClass(Class<?> value);

	/**
	 * Returns the value of the '<em><b>Current Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Value</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Current Value</em>' attribute.
	 * @see #setCurrentValue(Object)
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptExpression_CurrentValue()
	 * @generated
	 */
	Object getCurrentValue();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.scripting.IScriptExpression#getCurrentValue
	 * <em>Current Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Current Value</em>' attribute.
	 * @see #getCurrentValue()
	 * @generated
	 */
	void setCurrentValue(Object value);

	/**
	 * Returns the value of the '<em><b>Observable Value</b></em>' attribute. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Observable Value</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Observable Value</em>' attribute.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptExpression_ObservableValue()
	 * @generated
	 */
	IObservableValue getObservableValue();

	/**
	 * Returns the value of the '<em><b>Error Message</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Message</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Error Message</em>' attribute.
	 * @see #setErrorMessage(String)
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptExpression_ErrorMessage()
	 * @generated
	 */
	String getErrorMessage();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.scripting.IScriptExpression#getErrorMessage
	 * <em>Error Message</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Error Message</em>' attribute.
	 * @see #getErrorMessage()
	 * @generated
	 */
	void setErrorMessage(String value);

	/**
	 * Evaluates the expression.
	 */
	void evaluate();

	/**
	 * Sets the dependencies for this expression.
	 * <p>
	 * This method will replace the current set of dependencies with the new specified set of
	 * dependencies by replacing as few adapters as possible.
	 * 
	 * @param dependencies the new set of dependencies
	 */
	void updateDependencies(List<IScriptDependency> dependencies);
} // IScriptContext
