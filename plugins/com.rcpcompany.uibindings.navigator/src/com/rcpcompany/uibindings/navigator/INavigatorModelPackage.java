/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.navigator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
	String eNS_URI = "http://rcpcompany.com/schemas/uibindings/navigator";

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
	 * The feature id for the '<em><b>Model Types</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_MANAGER__MODEL_TYPES = 0;

	/**
	 * The feature id for the '<em><b>Use Generic Editor Part Fallback</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_MANAGER__USE_GENERIC_EDITOR_PART_FALLBACK = 1;

	/**
	 * The feature id for the '<em><b>Pin Editor By Default</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_MANAGER__PIN_EDITOR_BY_DEFAULT = 2;

	/**
	 * The feature id for the '<em><b>Open Must Open New</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_MANAGER__OPEN_MUST_OPEN_NEW = 3;

	/**
	 * The number of structural features of the '<em>Navigator Manager</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAVIGATOR_MANAGER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.navigator.internal.EditorModelTypeImpl
	 * <em>Editor Model Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.navigator.internal.EditorModelTypeImpl
	 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getEditorModelType()
	 * @generated
	 */
	int EDITOR_MODEL_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_MODEL_TYPE__EDITORS = 0;

	/**
	 * The feature id for the '<em><b>Preferred Editor</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_MODEL_TYPE__PREFERRED_EDITOR = 1;

	/**
	 * The feature id for the '<em><b>Model Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_MODEL_TYPE__MODEL_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Auto Generated</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_MODEL_TYPE__AUTO_GENERATED = 3;

	/**
	 * The number of structural features of the '<em>Editor Model Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_MODEL_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.navigator.internal.EditorPartDescriptorImpl
	 * <em>Editor Part Descriptor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.navigator.internal.EditorPartDescriptorImpl
	 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getEditorPartDescriptor()
	 * @generated
	 */
	int EDITOR_PART_DESCRIPTOR = 2;

	/**
	 * The feature id for the '<em><b>Model Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART_DESCRIPTOR__MODEL_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART_DESCRIPTOR__ID = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART_DESCRIPTOR__NAME = 2;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART_DESCRIPTOR__PRIORITY = 3;

	/**
	 * The feature id for the '<em><b>Factory</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART_DESCRIPTOR__FACTORY = 4;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART_DESCRIPTOR__IMAGE = 5;

	/**
	 * The number of structural features of the '<em>Editor Part Descriptor</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART_DESCRIPTOR_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.navigator.IEditorPartFactory
	 * <em>IEditor Part Factory</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.navigator.IEditorPartFactory
	 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getIEditorPartFactory()
	 * @generated
	 */
	int IEDITOR_PART_FACTORY = 3;

	/**
	 * The number of structural features of the '<em>IEditor Part Factory</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IEDITOR_PART_FACTORY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.navigator.IEditorPartView
	 * <em>IEditor Part View</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.navigator.IEditorPartView
	 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getIEditorPartView()
	 * @generated
	 */
	int IEDITOR_PART_VIEW = 4;

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
	 * {@link com.rcpcompany.uibindings.navigator.internal.StringToModelTypeMapEntryImpl
	 * <em>String To Model Type Map Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see com.rcpcompany.uibindings.navigator.internal.StringToModelTypeMapEntryImpl
	 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getStringToModelTypeMapEntry()
	 * @generated
	 */
	int STRING_TO_MODEL_TYPE_MAP_ENTRY = 5;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_MODEL_TYPE_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_MODEL_TYPE_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Model Type Map Entry</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_MODEL_TYPE_MAP_ENTRY_FEATURE_COUNT = 2;

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
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibindings.navigator.INavigatorManager#getModelTypes
	 * <em>Model Types</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Model Types</em>'.
	 * @see com.rcpcompany.uibindings.navigator.INavigatorManager#getModelTypes()
	 * @see #getNavigatorManager()
	 * @generated
	 */
	EReference getNavigatorManager_ModelTypes();

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
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorModelType <em>Editor Model Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Editor Model Type</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorModelType
	 * @generated
	 */
	EClass getEditorModelType();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorModelType#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Editors</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorModelType#getEditors()
	 * @see #getEditorModelType()
	 * @generated
	 */
	EReference getEditorModelType_Editors();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorModelType#getPreferredEditor
	 * <em>Preferred Editor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Preferred Editor</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorModelType#getPreferredEditor()
	 * @see #getEditorModelType()
	 * @generated
	 */
	EReference getEditorModelType_PreferredEditor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorModelType#getModelType <em>Model Type</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Model Type</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorModelType#getModelType()
	 * @see #getEditorModelType()
	 * @generated
	 */
	EAttribute getEditorModelType_ModelType();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorModelType#isAutoGenerated
	 * <em>Auto Generated</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Auto Generated</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorModelType#isAutoGenerated()
	 * @see #getEditorModelType()
	 * @generated
	 */
	EAttribute getEditorModelType_AutoGenerated();

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
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getModelType
	 * <em>Model Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Model Type</em>'.
	 * @see com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getModelType()
	 * @see #getEditorPartDescriptor()
	 * @generated
	 */
	EReference getEditorPartDescriptor_ModelType();

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
	 * <em>String To Model Type Map Entry</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>String To Model Type Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	EClass getStringToModelTypeMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToModelTypeMapEntry()
	 * @generated
	 */
	EAttribute getStringToModelTypeMapEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToModelTypeMapEntry()
	 * @generated
	 */
	EReference getStringToModelTypeMapEntry_Value();

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
		 * The meta object literal for the '<em><b>Model Types</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference NAVIGATOR_MANAGER__MODEL_TYPES = eINSTANCE.getNavigatorManager_ModelTypes();

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
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.navigator.internal.EditorModelTypeImpl
		 * <em>Editor Model Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.navigator.internal.EditorModelTypeImpl
		 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getEditorModelType()
		 * @generated
		 */
		EClass EDITOR_MODEL_TYPE = eINSTANCE.getEditorModelType();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EDITOR_MODEL_TYPE__EDITORS = eINSTANCE.getEditorModelType_Editors();

		/**
		 * The meta object literal for the '<em><b>Preferred Editor</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EDITOR_MODEL_TYPE__PREFERRED_EDITOR = eINSTANCE.getEditorModelType_PreferredEditor();

		/**
		 * The meta object literal for the '<em><b>Model Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EDITOR_MODEL_TYPE__MODEL_TYPE = eINSTANCE.getEditorModelType_ModelType();

		/**
		 * The meta object literal for the '<em><b>Auto Generated</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EDITOR_MODEL_TYPE__AUTO_GENERATED = eINSTANCE.getEditorModelType_AutoGenerated();

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
		 * The meta object literal for the '<em><b>Model Type</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EDITOR_PART_DESCRIPTOR__MODEL_TYPE = eINSTANCE.getEditorPartDescriptor_ModelType();

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
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EDITOR_PART_DESCRIPTOR__PRIORITY = eINSTANCE.getEditorPartDescriptor_Priority();

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
		 * {@link com.rcpcompany.uibindings.navigator.internal.StringToModelTypeMapEntryImpl
		 * <em>String To Model Type Map Entry</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.navigator.internal.StringToModelTypeMapEntryImpl
		 * @see com.rcpcompany.uibindings.navigator.internal.NavigatorModelPackageImpl#getStringToModelTypeMapEntry()
		 * @generated
		 */
		EClass STRING_TO_MODEL_TYPE_MAP_ENTRY = eINSTANCE.getStringToModelTypeMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_MODEL_TYPE_MAP_ENTRY__KEY = eINSTANCE.getStringToModelTypeMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STRING_TO_MODEL_TYPE_MAP_ENTRY__VALUE = eINSTANCE.getStringToModelTypeMapEntry_Value();

	}

} // INavigatorModelPackage
