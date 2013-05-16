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
package com.rcpcompany.uibindings.scripting;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.rcpcompany.uibindings.moao.IMOAOPackage;

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
 * @see com.rcpcompany.uibindings.scripting.IScriptingFactory
 * @generated
 */
public interface IScriptingPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "scripting";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://rcp-company.com/schemas/uibindings/scripting.ecore";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "scripting";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	IScriptingPackage eINSTANCE = com.rcpcompany.uibindings.scripting.internal.ScriptingPackageImpl.init();

	/**
	 * The meta object id for the ' {@link com.rcpcompany.uibindings.scripting.internal.FeatureScriptImpl
	 * <em>Feature Script</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.scripting.internal.FeatureScriptImpl
	 * @see com.rcpcompany.uibindings.scripting.internal.ScriptingPackageImpl#getFeatureScript()
	 * @generated
	 */
	int FEATURE_SCRIPT = 0;

	/**
	 * The feature id for the '<em><b>Facets</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_SCRIPT__FACETS = IMOAOPackage.MOAO_FACET__FACETS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_SCRIPT__OBJECT = IMOAOPackage.MOAO_FACET__OBJECT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_SCRIPT__FEATURE = IMOAOPackage.MOAO_FACET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_SCRIPT__LANGUAGE = IMOAOPackage.MOAO_FACET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Script</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_SCRIPT__SCRIPT = IMOAOPackage.MOAO_FACET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_SCRIPT__EXPRESSION = IMOAOPackage.MOAO_FACET_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Feature Script</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_SCRIPT_FEATURE_COUNT = IMOAOPackage.MOAO_FACET_FEATURE_COUNT + 4;

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.scripting.IFeatureScript
	 * <em>Feature Script</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Feature Script</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IFeatureScript
	 * @generated
	 */
	EClass getFeatureScript();

	/**
	 * Returns the meta object for the reference ' {@link com.rcpcompany.uibindings.scripting.IFeatureScript#getFeature
	 * <em>Feature</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IFeatureScript#getFeature()
	 * @see #getFeatureScript()
	 * @generated
	 */
	EReference getFeatureScript_Feature();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.scripting.IFeatureScript#getLanguage <em>Language</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IFeatureScript#getLanguage()
	 * @see #getFeatureScript()
	 * @generated
	 */
	EAttribute getFeatureScript_Language();

	/**
	 * Returns the meta object for the attribute ' {@link com.rcpcompany.uibindings.scripting.IFeatureScript#getScript
	 * <em>Script</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Script</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IFeatureScript#getScript()
	 * @see #getFeatureScript()
	 * @generated
	 */
	EAttribute getFeatureScript_Script();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.scripting.IFeatureScript#getExpression <em>Expression</em>} '. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see com.rcpcompany.uibindings.scripting.IFeatureScript#getExpression()
	 * @see #getFeatureScript()
	 * @generated
	 */
	EReference getFeatureScript_Expression();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IScriptingFactory getScriptingFactory();

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
		 * The meta object literal for the ' {@link com.rcpcompany.uibindings.scripting.internal.FeatureScriptImpl
		 * <em>Feature Script</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.scripting.internal.FeatureScriptImpl
		 * @see com.rcpcompany.uibindings.scripting.internal.ScriptingPackageImpl#getFeatureScript()
		 * @generated
		 */
		EClass FEATURE_SCRIPT = eINSTANCE.getFeatureScript();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FEATURE_SCRIPT__FEATURE = eINSTANCE.getFeatureScript_Feature();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FEATURE_SCRIPT__LANGUAGE = eINSTANCE.getFeatureScript_Language();

		/**
		 * The meta object literal for the '<em><b>Script</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FEATURE_SCRIPT__SCRIPT = eINSTANCE.getFeatureScript_Script();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' reference feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FEATURE_SCRIPT__EXPRESSION = eINSTANCE.getFeatureScript_Expression();

	}

} // IScriptingPackage
