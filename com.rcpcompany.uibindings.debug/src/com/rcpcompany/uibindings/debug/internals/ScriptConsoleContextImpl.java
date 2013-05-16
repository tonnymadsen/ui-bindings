/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.debug.internals;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.debug.IDebugPackage;
import com.rcpcompany.uibindings.debug.IScriptConsoleContext;
import com.rcpcompany.uibindings.scripting.IScriptExpression;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Script Console Context</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.debug.internals.ScriptConsoleContextImpl#getObject <em> Object</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.debug.internals.ScriptConsoleContextImpl#getLanguage <em> Language</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.debug.internals.ScriptConsoleContextImpl#getScript <em> Script</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.debug.internals.ScriptConsoleContextImpl#getExpression <em> Expression</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.debug.internals.ScriptConsoleContextImpl#getResult <em> Result</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.debug.internals.ScriptConsoleContextImpl#getException <em> Exception</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ScriptConsoleContextImpl extends EObjectImpl implements IScriptConsoleContext {
	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected EObject object;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getScript() <em>Script</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getScript()
	 * @generated
	 * @ordered
	 */
	protected static final String SCRIPT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScript() <em>Script</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getScript()
	 * @generated
	 * @ordered
	 */
	protected String script = SCRIPT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected IScriptExpression expression;

	/**
	 * The default value of the '{@link #getResult() <em>Result</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected static final String RESULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected String result = RESULT_EDEFAULT;

	/**
	 * The default value of the '{@link #getException() <em>Exception</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected static final String EXCEPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getException() <em>Exception</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected String exception = EXCEPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ScriptConsoleContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IDebugPackage.Literals.SCRIPT_CONSOLE_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject getObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setObject(EObject newObject) {
		final EObject oldObject = object;
		object = newObject;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IDebugPackage.SCRIPT_CONSOLE_CONTEXT__OBJECT,
					oldObject, object));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setLanguage(String newLanguage) {
		final String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IDebugPackage.SCRIPT_CONSOLE_CONTEXT__LANGUAGE,
					oldLanguage, language));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getScript() {
		return script;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setScript(String newScript) {
		final String oldScript = script;
		script = newScript;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IDebugPackage.SCRIPT_CONSOLE_CONTEXT__SCRIPT,
					oldScript, script));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IScriptExpression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setExpression(IScriptExpression newExpression) {
		final IScriptExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IDebugPackage.SCRIPT_CONSOLE_CONTEXT__EXPRESSION,
					oldExpression, expression));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setResult(String newResult) {
		final String oldResult = result;
		result = newResult;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IDebugPackage.SCRIPT_CONSOLE_CONTEXT__RESULT,
					oldResult, result));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getException() {
		return exception;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setException(String newException) {
		final String oldException = exception;
		exception = newException;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IDebugPackage.SCRIPT_CONSOLE_CONTEXT__EXCEPTION,
					oldException, exception));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__OBJECT:
			return getObject();
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__LANGUAGE:
			return getLanguage();
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__SCRIPT:
			return getScript();
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__EXPRESSION:
			return getExpression();
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__RESULT:
			return getResult();
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__EXCEPTION:
			return getException();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__OBJECT:
			setObject((EObject) newValue);
			return;
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__LANGUAGE:
			setLanguage((String) newValue);
			return;
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__SCRIPT:
			setScript((String) newValue);
			return;
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__EXPRESSION:
			setExpression((IScriptExpression) newValue);
			return;
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__RESULT:
			setResult((String) newValue);
			return;
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__EXCEPTION:
			setException((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__OBJECT:
			setObject((EObject) null);
			return;
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__LANGUAGE:
			setLanguage(LANGUAGE_EDEFAULT);
			return;
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__SCRIPT:
			setScript(SCRIPT_EDEFAULT);
			return;
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__EXPRESSION:
			setExpression((IScriptExpression) null);
			return;
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__RESULT:
			setResult(RESULT_EDEFAULT);
			return;
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__EXCEPTION:
			setException(EXCEPTION_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__OBJECT:
			return object != null;
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__LANGUAGE:
			return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__SCRIPT:
			return SCRIPT_EDEFAULT == null ? script != null : !SCRIPT_EDEFAULT.equals(script);
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__EXPRESSION:
			return expression != null;
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__RESULT:
			return RESULT_EDEFAULT == null ? result != null : !RESULT_EDEFAULT.equals(result);
		case IDebugPackage.SCRIPT_CONSOLE_CONTEXT__EXCEPTION:
			return EXCEPTION_EDEFAULT == null ? exception != null : !EXCEPTION_EDEFAULT.equals(exception);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (language: ");
		result.append(language);
		result.append(", script: ");
		result.append(script);
		result.append(", result: ");
		result.append(result);
		result.append(", exception: ");
		result.append(exception);
		result.append(')');
		return result.toString();
	}

} // ScriptConsoleContextImpl
