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
package com.rcpcompany.uibindings.navigator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * 
 * @see com.rcpcompany.uibindings.navigator.INavigatorModelFactory
 * @generated
 */
public interface INavigatorModelPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "navigator";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://rcp-company.com/schemas/uibindings/navigator";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "navigator";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	INavigatorModelPackage eINSTANCE = com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl.init();

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.navigator.internal.NavigatorManagerImpl
	 * <em>Navigator Manager</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorManagerImpl
	 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getNavigatorManager()
	 * @generated
	 */
	int NAVIGATOR_MANAGER = 0;

	/**
	 * The feature id for the '<em><b>Navigators</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_MANAGER__NAVIGATORS = 0;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_MANAGER__DESCRIPTORS = 1;

	/**
	 * The feature id for the '<em><b>Editor Informations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_MANAGER__EDITOR_INFORMATIONS = 2;

	/**
	 * The feature id for the '<em><b>Use Generic Editor Part Fallback</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_MANAGER__USE_GENERIC_EDITOR_PART_FALLBACK = 3;

	/**
	 * The feature id for the '<em><b>Pin Editor By Default</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_MANAGER__PIN_EDITOR_BY_DEFAULT = 4;

	/**
	 * The feature id for the '<em><b>Open Must Open New</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_MANAGER__OPEN_MUST_OPEN_NEW = 5;

	/**
	 * The feature id for the '<em><b>Preference Model Types</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_MANAGER__PREFERENCE_MODEL_TYPES = 6;

	/**
	 * The number of structural features of the '<em>Navigator Manager</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_MANAGER_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.navigator.internal.NavigatorDescriptorImpl
	 * <em>Navigator Descriptor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorDescriptorImpl
	 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getNavigatorDescriptor()
	 * @generated
	 */
	int NAVIGATOR_DESCRIPTOR = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_DESCRIPTOR__ID = 0;

	/**
	 * The feature id for the '<em><b>Advisor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_DESCRIPTOR__ADVISOR = 1;

	/**
	 * The number of structural features of the '<em>Navigator Descriptor</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_DESCRIPTOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.navigator.internal.EditorInformationImpl
	 * <em>Editor Information</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.navigator.internal.EditorInformationImpl
	 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getEditorInformation()
	 * @generated
	 */
	int EDITOR_INFORMATION = 2;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_INFORMATION__EDITORS = 0;

	/**
	 * The feature id for the '<em><b>Preferred Editor</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_INFORMATION__PREFERRED_EDITOR = 1;

	/**
	 * The feature id for the '<em><b>Model Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_INFORMATION__MODEL_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Tree Item ID</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_INFORMATION__TREE_ITEM_ID = 3;

	/**
	 * The number of structural features of the '<em>Editor Information</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_INFORMATION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.navigator.internal.EditorPartDescriptorImpl
	 * <em>Editor Part Descriptor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.navigator.internal.EditorPartDescriptorImpl
	 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getEditorPartDescriptor()
	 * @generated
	 */
	int EDITOR_PART_DESCRIPTOR = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART_DESCRIPTOR__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART_DESCRIPTOR__NAME = 1;

	/**
	 * The feature id for the '<em><b>Model Types</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART_DESCRIPTOR__MODEL_TYPES = 2;

	/**
	 * The feature id for the '<em><b>Tree Item IDs</b></em>' attribute list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART_DESCRIPTOR__TREE_ITEM_IDS = 3;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART_DESCRIPTOR__PRIORITY = 4;

	/**
	 * The feature id for the '<em><b>Fallback Editor</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART_DESCRIPTOR__FALLBACK_EDITOR = 5;

	/**
	 * The feature id for the '<em><b>Factory</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART_DESCRIPTOR__FACTORY = 6;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART_DESCRIPTOR__IMAGE = 7;

	/**
	 * The feature id for the '<em><b>Enabled When Expression</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART_DESCRIPTOR__ENABLED_WHEN_EXPRESSION = 8;

	/**
	 * The number of structural features of the '<em>Editor Part Descriptor</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART_DESCRIPTOR_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.navigator.IEditorPartFactory
	 * <em>IEditor Part Factory</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.navigator.IEditorPartFactory
	 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getIEditorPartFactory()
	 * @generated
	 */
	int IEDITOR_PART_FACTORY = 4;

	/**
	 * The number of structural features of the '<em>IEditor Part Factory</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IEDITOR_PART_FACTORY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.navigator.views.INavigatorBaseViewAdvisor
	 * <em>INavigator Base View Advisor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.navigator.views.INavigatorBaseViewAdvisor
	 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getINavigatorBaseViewAdvisor()
	 * @generated
	 */
	int INAVIGATOR_BASE_VIEW_ADVISOR = 5;

	/**
	 * The number of structural features of the '<em>INavigator Base View Advisor</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INAVIGATOR_BASE_VIEW_ADVISOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.navigator.IEditorPartView
	 * <em>IEditor Part View</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.navigator.IEditorPartView
	 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getIEditorPartView()
	 * @generated
	 */
	int IEDITOR_PART_VIEW = 6;

	/**
	 * The number of structural features of the '<em>IEditor Part View</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IEDITOR_PART_VIEW_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.navigator.internal.StringToEditorInformationMapEntryImpl
	 * <em>String To Editor Information Map Entry</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.navigator.internal.StringToEditorInformationMapEntryImpl
	 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getStringToEditorInformationMapEntry()
	 * @generated
	 */
	int STRING_TO_EDITOR_INFORMATION_MAP_ENTRY = 7;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_EDITOR_INFORMATION_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_EDITOR_INFORMATION_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Editor Information Map Entry</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_EDITOR_INFORMATION_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '<em>Expression</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.core.expressions.Expression
	 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 8;

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.navigator.INavigatorManager <em>Navigator Manager</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Navigator Manager</em>'.
	 * @see com.rcpcompany.uibindings.navigator.INavigatorManager
	 * @generated
	 */
	EClass getNavigatorManager();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.navigator.INavigatorManager#getNavigators
	 * <em>Navigators</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Navigators</em>'.
	 * @see com.rcpcompany.uibindings.navigator.INavigatorManager#getNavigators()
	 * @see #getNavigatorManager()
	 * @generated
	 */
	EReference getNavigatorManager_Navigators();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.navigator.INavigatorManager#getDescriptors
	 * <em>Descriptors</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Descriptors</em>'.
	 * @see com.rcpcompany.uibindings.navigator.INavigatorManager#getDescriptors()
	 * @see #getNavigatorManager()
	 * @generated
	 */
	EReference getNavigatorManager_Descriptors();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.navigator.INavigatorManager#getEditorInformations
	 * <em>Editor Informations</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Editor Informations</em>'.
	 * @see com.rcpcompany.uibindings.navigator.INavigatorManager#getEditorInformations()
	 * @see #getNavigatorManager()
	 * @generated
	 */
	EReference getNavigatorManager_EditorInformations();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.navigator.INavigatorManager#isUseGenericEditorPartFallback
	 * <em>Use Generic Editor Part Fallback</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Use Generic Editor Part Fallback</em>'.
	 * @see com.rcpcompany.uibindings.navigator.INavigatorManager#isUseGenericEditorPartFallback()
	 * @see #getNavigatorManager()
	 * @generated
	 */
	EAttribute getNavigatorManager_UseGenericEditorPartFallback();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.navigator.INavigatorManager#isPinEditorByDefault
	 * <em>Pin Editor By Default</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Pin Editor By Default</em>'.
	 * @see com.rcpcompany.uibindings.navigator.INavigatorManager#isPinEditorByDefault()
	 * @see #getNavigatorManager()
	 * @generated
	 */
	EAttribute getNavigatorManager_PinEditorByDefault();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.navigator.INavigatorManager#isOpenMustOpenNew
	 * <em>Open Must Open New</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Open Must Open New</em>'.
	 * @see com.rcpcompany.uibindings.navigator.INavigatorManager#isOpenMustOpenNew()
	 * @see #getNavigatorManager()
	 * @generated
	 */
	EAttribute getNavigatorManager_OpenMustOpenNew();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link com.rcpcompany.uibindings.navigator.INavigatorManager#getPreferenceModelTypes
	 * <em>Preference Model Types</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Preference Model Types</em>'.
	 * @see com.rcpcompany.uibindings.navigator.INavigatorManager#getPreferenceModelTypes()
	 * @see #getNavigatorManager()
	 * @generated
	 */
	EAttribute getNavigatorManager_PreferenceModelTypes();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.navigator.INavigatorDescriptor
	 * <em>Navigator Descriptor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Navigator Descriptor</em>'.
	 * @see com.rcpcompany.uibindings.navigator.INavigatorDescriptor
	 * @generated
	 */
	EClass getNavigatorDescriptor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.navigator.INavigatorDescriptor#getId <em>Id</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.rcpcompany.uibindings.navigator.INavigatorDescriptor#getId()
	 * @see #getNavigatorDescriptor()
	 * @generated
	 */
	EAttribute getNavigatorDescriptor_Id();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.navigator.INavigatorDescriptor#getAdvisor <em>Advisor</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Advisor</em>'.
	 * @see com.rcpcompany.uibindings.navigator.INavigatorDescriptor#getAdvisor()
	 * @see #getNavigatorDescriptor()
	 * @generated
	 */
	EAttribute getNavigatorDescriptor_Advisor();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorInformation <em>Editor Information</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Editor Information</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorInformation
	 * @generated
	 */
	EClass getEditorInformation();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorInformation#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Editors</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorInformation#getEditors()
	 * @see #getEditorInformation()
	 * @generated
	 */
	EReference getEditorInformation_Editors();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorInformation#getPreferredEditor
	 * <em>Preferred Editor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Preferred Editor</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorInformation#getPreferredEditor()
	 * @see #getEditorInformation()
	 * @generated
	 */
	EReference getEditorInformation_PreferredEditor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorInformation#getModelType
	 * <em>Model Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Model Type</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorInformation#getModelType()
	 * @see #getEditorInformation()
	 * @generated
	 */
	EAttribute getEditorInformation_ModelType();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorInformation#getTreeItemID
	 * <em>Tree Item ID</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Tree Item ID</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorInformation#getTreeItemID()
	 * @see #getEditorInformation()
	 * @generated
	 */
	EAttribute getEditorInformation_TreeItemID();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor
	 * <em>Editor Part Descriptor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Editor Part Descriptor</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorPartDescriptor
	 * @generated
	 */
	EClass getEditorPartDescriptor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getId <em>Id</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getId()
	 * @see #getEditorPartDescriptor()
	 * @generated
	 */
	EAttribute getEditorPartDescriptor_Id();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getName()
	 * @see #getEditorPartDescriptor()
	 * @generated
	 */
	EAttribute getEditorPartDescriptor_Name();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getModelTypes
	 * <em>Model Types</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Model Types</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getModelTypes()
	 * @see #getEditorPartDescriptor()
	 * @generated
	 */
	EAttribute getEditorPartDescriptor_ModelTypes();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getTreeItemIDs
	 * <em>Tree Item IDs</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Tree Item IDs</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getTreeItemIDs()
	 * @see #getEditorPartDescriptor()
	 * @generated
	 */
	EAttribute getEditorPartDescriptor_TreeItemIDs();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getPriority
	 * <em>Priority</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getPriority()
	 * @see #getEditorPartDescriptor()
	 * @generated
	 */
	EAttribute getEditorPartDescriptor_Priority();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#isFallbackEditor
	 * <em>Fallback Editor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Fallback Editor</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#isFallbackEditor()
	 * @see #getEditorPartDescriptor()
	 * @generated
	 */
	EAttribute getEditorPartDescriptor_FallbackEditor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getFactory <em>Factory</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Factory</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getFactory()
	 * @see #getEditorPartDescriptor()
	 * @generated
	 */
	EAttribute getEditorPartDescriptor_Factory();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getImage()
	 * @see #getEditorPartDescriptor()
	 * @generated
	 */
	EAttribute getEditorPartDescriptor_Image();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getEnabledWhenExpression
	 * <em>Enabled When Expression</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Enabled When Expression</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getEnabledWhenExpression()
	 * @see #getEditorPartDescriptor()
	 * @generated
	 */
	EAttribute getEditorPartDescriptor_EnabledWhenExpression();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorPartFactory <em>IEditor Part Factory</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>IEditor Part Factory</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorPartFactory
	 * @generated
	 */
	EClass getIEditorPartFactory();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.navigator.views.INavigatorBaseViewAdvisor
	 * <em>INavigator Base View Advisor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>INavigator Base View Advisor</em>'.
	 * @see com.rcpcompany.uibindings.navigator.views.INavigatorBaseViewAdvisor
	 * @generated
	 */
	EClass getINavigatorBaseViewAdvisor();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorPartView <em>IEditor Part View</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>IEditor Part View</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorPartView
	 * @generated
	 */
	EClass getIEditorPartView();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry
	 * <em>String To Editor Information Map Entry</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>String To Editor Information Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	EClass getStringToEditorInformationMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToEditorInformationMapEntry()
	 * @generated
	 */
	EAttribute getStringToEditorInformationMapEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToEditorInformationMapEntry()
	 * @generated
	 */
	EReference getStringToEditorInformationMapEntry_Value();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.expressions.Expression
	 * <em>Expression</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Expression</em>'.
	 * @see org.eclipse.core.expressions.Expression
	 * @generated
	 */
	EDataType getExpression();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	INavigatorModelFactory getNavigatorModelFactory();

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
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.navigator.internal.NavigatorManagerImpl
		 * <em>Navigator Manager</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorManagerImpl
		 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getNavigatorManager()
		 * @generated
		 */
		EClass NAVIGATOR_MANAGER = eINSTANCE.getNavigatorManager();

		/**
		 * The meta object literal for the '<em><b>Navigators</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference NAVIGATOR_MANAGER__NAVIGATORS = eINSTANCE.getNavigatorManager_Navigators();

		/**
		 * The meta object literal for the '<em><b>Descriptors</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference NAVIGATOR_MANAGER__DESCRIPTORS = eINSTANCE.getNavigatorManager_Descriptors();

		/**
		 * The meta object literal for the '<em><b>Editor Informations</b></em>' containment
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference NAVIGATOR_MANAGER__EDITOR_INFORMATIONS = eINSTANCE.getNavigatorManager_EditorInformations();

		/**
		 * The meta object literal for the '<em><b>Use Generic Editor Part Fallback</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NAVIGATOR_MANAGER__USE_GENERIC_EDITOR_PART_FALLBACK = eINSTANCE
				.getNavigatorManager_UseGenericEditorPartFallback();

		/**
		 * The meta object literal for the '<em><b>Pin Editor By Default</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NAVIGATOR_MANAGER__PIN_EDITOR_BY_DEFAULT = eINSTANCE.getNavigatorManager_PinEditorByDefault();

		/**
		 * The meta object literal for the '<em><b>Open Must Open New</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NAVIGATOR_MANAGER__OPEN_MUST_OPEN_NEW = eINSTANCE.getNavigatorManager_OpenMustOpenNew();

		/**
		 * The meta object literal for the '<em><b>Preference Model Types</b></em>' attribute list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NAVIGATOR_MANAGER__PREFERENCE_MODEL_TYPES = eINSTANCE.getNavigatorManager_PreferenceModelTypes();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.navigator.internal.NavigatorDescriptorImpl
		 * <em>Navigator Descriptor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorDescriptorImpl
		 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getNavigatorDescriptor()
		 * @generated
		 */
		EClass NAVIGATOR_DESCRIPTOR = eINSTANCE.getNavigatorDescriptor();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NAVIGATOR_DESCRIPTOR__ID = eINSTANCE.getNavigatorDescriptor_Id();

		/**
		 * The meta object literal for the '<em><b>Advisor</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NAVIGATOR_DESCRIPTOR__ADVISOR = eINSTANCE.getNavigatorDescriptor_Advisor();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.navigator.internal.EditorInformationImpl
		 * <em>Editor Information</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.navigator.internal.EditorInformationImpl
		 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getEditorInformation()
		 * @generated
		 */
		EClass EDITOR_INFORMATION = eINSTANCE.getEditorInformation();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EDITOR_INFORMATION__EDITORS = eINSTANCE.getEditorInformation_Editors();

		/**
		 * The meta object literal for the '<em><b>Preferred Editor</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EDITOR_INFORMATION__PREFERRED_EDITOR = eINSTANCE.getEditorInformation_PreferredEditor();

		/**
		 * The meta object literal for the '<em><b>Model Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EDITOR_INFORMATION__MODEL_TYPE = eINSTANCE.getEditorInformation_ModelType();

		/**
		 * The meta object literal for the '<em><b>Tree Item ID</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EDITOR_INFORMATION__TREE_ITEM_ID = eINSTANCE.getEditorInformation_TreeItemID();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.navigator.internal.EditorPartDescriptorImpl
		 * <em>Editor Part Descriptor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.navigator.internal.EditorPartDescriptorImpl
		 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getEditorPartDescriptor()
		 * @generated
		 */
		EClass EDITOR_PART_DESCRIPTOR = eINSTANCE.getEditorPartDescriptor();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EDITOR_PART_DESCRIPTOR__ID = eINSTANCE.getEditorPartDescriptor_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EDITOR_PART_DESCRIPTOR__NAME = eINSTANCE.getEditorPartDescriptor_Name();

		/**
		 * The meta object literal for the '<em><b>Model Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EDITOR_PART_DESCRIPTOR__MODEL_TYPES = eINSTANCE.getEditorPartDescriptor_ModelTypes();

		/**
		 * The meta object literal for the '<em><b>Tree Item IDs</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EDITOR_PART_DESCRIPTOR__TREE_ITEM_IDS = eINSTANCE.getEditorPartDescriptor_TreeItemIDs();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EDITOR_PART_DESCRIPTOR__PRIORITY = eINSTANCE.getEditorPartDescriptor_Priority();

		/**
		 * The meta object literal for the '<em><b>Fallback Editor</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EDITOR_PART_DESCRIPTOR__FALLBACK_EDITOR = eINSTANCE.getEditorPartDescriptor_FallbackEditor();

		/**
		 * The meta object literal for the '<em><b>Factory</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EDITOR_PART_DESCRIPTOR__FACTORY = eINSTANCE.getEditorPartDescriptor_Factory();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EDITOR_PART_DESCRIPTOR__IMAGE = eINSTANCE.getEditorPartDescriptor_Image();

		/**
		 * The meta object literal for the '<em><b>Enabled When Expression</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EDITOR_PART_DESCRIPTOR__ENABLED_WHEN_EXPRESSION = eINSTANCE
				.getEditorPartDescriptor_EnabledWhenExpression();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.navigator.IEditorPartFactory
		 * <em>IEditor Part Factory</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.navigator.IEditorPartFactory
		 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getIEditorPartFactory()
		 * @generated
		 */
		EClass IEDITOR_PART_FACTORY = eINSTANCE.getIEditorPartFactory();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.navigator.views.INavigatorBaseViewAdvisor
		 * <em>INavigator Base View Advisor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see com.rcpcompany.uibindings.navigator.views.INavigatorBaseViewAdvisor
		 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getINavigatorBaseViewAdvisor()
		 * @generated
		 */
		EClass INAVIGATOR_BASE_VIEW_ADVISOR = eINSTANCE.getINavigatorBaseViewAdvisor();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.navigator.IEditorPartView <em>IEditor Part View</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.navigator.IEditorPartView
		 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getIEditorPartView()
		 * @generated
		 */
		EClass IEDITOR_PART_VIEW = eINSTANCE.getIEditorPartView();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.navigator.internal.StringToEditorInformationMapEntryImpl
		 * <em>String To Editor Information Map Entry</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.navigator.internal.StringToEditorInformationMapEntryImpl
		 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getStringToEditorInformationMapEntry()
		 * @generated
		 */
		EClass STRING_TO_EDITOR_INFORMATION_MAP_ENTRY = eINSTANCE.getStringToEditorInformationMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_EDITOR_INFORMATION_MAP_ENTRY__KEY = eINSTANCE.getStringToEditorInformationMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STRING_TO_EDITOR_INFORMATION_MAP_ENTRY__VALUE = eINSTANCE
				.getStringToEditorInformationMapEntry_Value();

		/**
		 * The meta object literal for the '<em>Expression</em>' data type. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.core.expressions.Expression
		 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getExpression()
		 * @generated
		 */
		EDataType EXPRESSION = eINSTANCE.getExpression();

	}

} // INavigatorModelPackage
