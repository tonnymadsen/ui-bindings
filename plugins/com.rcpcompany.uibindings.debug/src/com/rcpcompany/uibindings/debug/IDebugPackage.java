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
package com.rcpcompany.uibindings.debug;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see com.rcpcompany.uibindings.debug.IDebugFactory
 * @generated
 */
public interface IDebugPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "debug";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://rcp-company.com/schemas/uibindings/debug.ecore";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "debug";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	IDebugPackage eINSTANCE = com.rcpcompany.uibindings.debug.internals.DebugPackageImpl.init();

	/**
	 * The meta object id for the ' {@link com.rcpcompany.uibindings.debug.internals.ScriptConsoleContextImpl
	 * <em>Script Console Context</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.debug.internals.ScriptConsoleContextImpl
	 * @see com.rcpcompany.uibindings.debug.internals.DebugPackageImpl#getScriptConsoleContext()
	 * @generated
	 */
	int SCRIPT_CONSOLE_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCRIPT_CONSOLE_CONTEXT__OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCRIPT_CONSOLE_CONTEXT__LANGUAGE = 1;

	/**
	 * The feature id for the '<em><b>Script</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCRIPT_CONSOLE_CONTEXT__SCRIPT = 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCRIPT_CONSOLE_CONTEXT__EXPRESSION = 3;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCRIPT_CONSOLE_CONTEXT__RESULT = 4;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCRIPT_CONSOLE_CONTEXT__EXCEPTION = 5;

	/**
	 * The number of structural features of the '<em>Script Console Context</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCRIPT_CONSOLE_CONTEXT_FEATURE_COUNT = 6;

	/**
	 * Returns the meta object for class ' {@link com.rcpcompany.uibindings.debug.IScriptConsoleContext
	 * <em>Script Console Context</em>} '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Script Console Context</em>'.
	 * @see com.rcpcompany.uibindings.debug.IScriptConsoleContext
	 * @generated
	 */
	EClass getScriptConsoleContext();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.debug.IScriptConsoleContext#getObject <em>Object</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see com.rcpcompany.uibindings.debug.IScriptConsoleContext#getObject()
	 * @see #getScriptConsoleContext()
	 * @generated
	 */
	EReference getScriptConsoleContext_Object();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.debug.IScriptConsoleContext#getLanguage <em>Language</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see com.rcpcompany.uibindings.debug.IScriptConsoleContext#getLanguage()
	 * @see #getScriptConsoleContext()
	 * @generated
	 */
	EAttribute getScriptConsoleContext_Language();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.debug.IScriptConsoleContext#getScript <em>Script</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Script</em>'.
	 * @see com.rcpcompany.uibindings.debug.IScriptConsoleContext#getScript()
	 * @see #getScriptConsoleContext()
	 * @generated
	 */
	EAttribute getScriptConsoleContext_Script();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.debug.IScriptConsoleContext#getExpression <em>Expression</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see com.rcpcompany.uibindings.debug.IScriptConsoleContext#getExpression()
	 * @see #getScriptConsoleContext()
	 * @generated
	 */
	EReference getScriptConsoleContext_Expression();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.debug.IScriptConsoleContext#getResult <em>Result</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see com.rcpcompany.uibindings.debug.IScriptConsoleContext#getResult()
	 * @see #getScriptConsoleContext()
	 * @generated
	 */
	EAttribute getScriptConsoleContext_Result();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.debug.IScriptConsoleContext#getException <em>Exception</em>} '. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Exception</em>'.
	 * @see com.rcpcompany.uibindings.debug.IScriptConsoleContext#getException()
	 * @see #getScriptConsoleContext()
	 * @generated
	 */
	EAttribute getScriptConsoleContext_Exception();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IDebugFactory getDebugFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the ' {@link com.rcpcompany.uibindings.debug.internals.ScriptConsoleContextImpl
		 * <em>Script Console Context</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.debug.internals.ScriptConsoleContextImpl
		 * @see com.rcpcompany.uibindings.debug.internals.DebugPackageImpl#getScriptConsoleContext()
		 * @generated
		 */
		EClass SCRIPT_CONSOLE_CONTEXT = eINSTANCE.getScriptConsoleContext();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SCRIPT_CONSOLE_CONTEXT__OBJECT = eINSTANCE.getScriptConsoleContext_Object();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SCRIPT_CONSOLE_CONTEXT__LANGUAGE = eINSTANCE.getScriptConsoleContext_Language();

		/**
		 * The meta object literal for the '<em><b>Script</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SCRIPT_CONSOLE_CONTEXT__SCRIPT = eINSTANCE.getScriptConsoleContext_Script();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' reference feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SCRIPT_CONSOLE_CONTEXT__EXPRESSION = eINSTANCE.getScriptConsoleContext_Expression();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SCRIPT_CONSOLE_CONTEXT__RESULT = eINSTANCE.getScriptConsoleContext_Result();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SCRIPT_CONSOLE_CONTEXT__EXCEPTION = eINSTANCE.getScriptConsoleContext_Exception();

	}

} // IDebugPackage
