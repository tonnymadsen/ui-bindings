/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.navigator.editors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.rcpcompany.uibindings.navigator.editors.IEditorsFactory
 * @generated
 */
public interface IEditorsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "editors";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://rcpcompany.com/schemas/uibindings/editors";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "editors";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IEditorsPackage eINSTANCE = com.rcpcompany.uibindings.navigator.editors.internal.EditorsPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.navigator.editors.internal.EditorManagerImpl <em>Editor Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.rcpcompany.uibindings.navigator.editors.internal.EditorManagerImpl
	 * @see com.rcpcompany.uibindings.navigator.editors.internal.EditorsPackageImpl#getEditorManager()
	 * @generated
	 */
	int EDITOR_MANAGER = 0;

	/**
	 * The feature id for the '<em><b>Model Types</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_MANAGER__MODEL_TYPES = 0;

	/**
	 * The number of structural features of the '<em>Editor Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_MANAGER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.navigator.editors.internal.EditiorModelTypeImpl <em>Editior Model Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.rcpcompany.uibindings.navigator.editors.internal.EditiorModelTypeImpl
	 * @see com.rcpcompany.uibindings.navigator.editors.internal.EditorsPackageImpl#getEditiorModelType()
	 * @generated
	 */
	int EDITIOR_MODEL_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITIOR_MODEL_TYPE__EDITORS = 0;

	/**
	 * The feature id for the '<em><b>Model Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITIOR_MODEL_TYPE__MODEL_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Editior Model Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITIOR_MODEL_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.navigator.editors.internal.EditorDescriptorImpl <em>Editor Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.rcpcompany.uibindings.navigator.editors.internal.EditorDescriptorImpl
	 * @see com.rcpcompany.uibindings.navigator.editors.internal.EditorsPackageImpl#getEditorDescriptor()
	 * @generated
	 */
	int EDITOR_DESCRIPTOR = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_DESCRIPTOR__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_DESCRIPTOR__NAME = 1;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_DESCRIPTOR__PRIORITY = 2;

	/**
	 * The feature id for the '<em><b>Factory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_DESCRIPTOR__FACTORY = 3;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_DESCRIPTOR__IMAGE = 4;

	/**
	 * The number of structural features of the '<em>Editor Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_DESCRIPTOR_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.navigator.editors.IEditor <em>IEditor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.rcpcompany.uibindings.navigator.editors.IEditor
	 * @see com.rcpcompany.uibindings.navigator.editors.internal.EditorsPackageImpl#getIEditor()
	 * @generated
	 */
	int IEDITOR = 3;

	/**
	 * The number of structural features of the '<em>IEditor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IEDITOR_FEATURE_COUNT = 0;


	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.navigator.editors.internal.StringToModelTypeMapEntryImpl <em>String To Model Type Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.rcpcompany.uibindings.navigator.editors.internal.StringToModelTypeMapEntryImpl
	 * @see com.rcpcompany.uibindings.navigator.editors.internal.EditorsPackageImpl#getStringToModelTypeMapEntry()
	 * @generated
	 */
	int STRING_TO_MODEL_TYPE_MAP_ENTRY = 4;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_MODEL_TYPE_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_MODEL_TYPE_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Model Type Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_MODEL_TYPE_MAP_ENTRY_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.navigator.editors.IEditorManager <em>Editor Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Editor Manager</em>'.
	 * @see com.rcpcompany.uibindings.navigator.editors.IEditorManager
	 * @generated
	 */
	EClass getEditorManager();

	/**
	 * Returns the meta object for the map '{@link com.rcpcompany.uibindings.navigator.editors.IEditorManager#getModelTypes <em>Model Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Model Types</em>'.
	 * @see com.rcpcompany.uibindings.navigator.editors.IEditorManager#getModelTypes()
	 * @see #getEditorManager()
	 * @generated
	 */
	EReference getEditorManager_ModelTypes();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.navigator.editors.IEditiorModelType <em>Editior Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Editior Model Type</em>'.
	 * @see com.rcpcompany.uibindings.navigator.editors.IEditiorModelType
	 * @generated
	 */
	EClass getEditiorModelType();

	/**
	 * Returns the meta object for the reference list '{@link com.rcpcompany.uibindings.navigator.editors.IEditiorModelType#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Editors</em>'.
	 * @see com.rcpcompany.uibindings.navigator.editors.IEditiorModelType#getEditors()
	 * @see #getEditiorModelType()
	 * @generated
	 */
	EReference getEditiorModelType_Editors();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibindings.navigator.editors.IEditiorModelType#getModelType <em>Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Type</em>'.
	 * @see com.rcpcompany.uibindings.navigator.editors.IEditiorModelType#getModelType()
	 * @see #getEditiorModelType()
	 * @generated
	 */
	EAttribute getEditiorModelType_ModelType();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.navigator.editors.IEditorDescriptor <em>Editor Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Editor Descriptor</em>'.
	 * @see com.rcpcompany.uibindings.navigator.editors.IEditorDescriptor
	 * @generated
	 */
	EClass getEditorDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibindings.navigator.editors.IEditorDescriptor#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.rcpcompany.uibindings.navigator.editors.IEditorDescriptor#getId()
	 * @see #getEditorDescriptor()
	 * @generated
	 */
	EAttribute getEditorDescriptor_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibindings.navigator.editors.IEditorDescriptor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.rcpcompany.uibindings.navigator.editors.IEditorDescriptor#getName()
	 * @see #getEditorDescriptor()
	 * @generated
	 */
	EAttribute getEditorDescriptor_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibindings.navigator.editors.IEditorDescriptor#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see com.rcpcompany.uibindings.navigator.editors.IEditorDescriptor#getPriority()
	 * @see #getEditorDescriptor()
	 * @generated
	 */
	EAttribute getEditorDescriptor_Priority();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibindings.navigator.editors.IEditorDescriptor#getFactory <em>Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factory</em>'.
	 * @see com.rcpcompany.uibindings.navigator.editors.IEditorDescriptor#getFactory()
	 * @see #getEditorDescriptor()
	 * @generated
	 */
	EAttribute getEditorDescriptor_Factory();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibindings.navigator.editors.IEditorDescriptor#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see com.rcpcompany.uibindings.navigator.editors.IEditorDescriptor#getImage()
	 * @see #getEditorDescriptor()
	 * @generated
	 */
	EAttribute getEditorDescriptor_Image();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.navigator.editors.IEditor <em>IEditor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IEditor</em>'.
	 * @see com.rcpcompany.uibindings.navigator.editors.IEditor
	 * @generated
	 */
	EClass getIEditor();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To Model Type Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To Model Type Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	EClass getStringToModelTypeMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToModelTypeMapEntry()
	 * @generated
	 */
	EAttribute getStringToModelTypeMapEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToModelTypeMapEntry()
	 * @generated
	 */
	EReference getStringToModelTypeMapEntry_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IEditorsFactory getEditorsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.navigator.editors.internal.EditorManagerImpl <em>Editor Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.rcpcompany.uibindings.navigator.editors.internal.EditorManagerImpl
		 * @see com.rcpcompany.uibindings.navigator.editors.internal.EditorsPackageImpl#getEditorManager()
		 * @generated
		 */
		EClass EDITOR_MANAGER = eINSTANCE.getEditorManager();

		/**
		 * The meta object literal for the '<em><b>Model Types</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDITOR_MANAGER__MODEL_TYPES = eINSTANCE.getEditorManager_ModelTypes();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.navigator.editors.internal.EditiorModelTypeImpl <em>Editior Model Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.rcpcompany.uibindings.navigator.editors.internal.EditiorModelTypeImpl
		 * @see com.rcpcompany.uibindings.navigator.editors.internal.EditorsPackageImpl#getEditiorModelType()
		 * @generated
		 */
		EClass EDITIOR_MODEL_TYPE = eINSTANCE.getEditiorModelType();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDITIOR_MODEL_TYPE__EDITORS = eINSTANCE.getEditiorModelType_Editors();

		/**
		 * The meta object literal for the '<em><b>Model Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITIOR_MODEL_TYPE__MODEL_TYPE = eINSTANCE.getEditiorModelType_ModelType();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.navigator.editors.internal.EditorDescriptorImpl <em>Editor Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.rcpcompany.uibindings.navigator.editors.internal.EditorDescriptorImpl
		 * @see com.rcpcompany.uibindings.navigator.editors.internal.EditorsPackageImpl#getEditorDescriptor()
		 * @generated
		 */
		EClass EDITOR_DESCRIPTOR = eINSTANCE.getEditorDescriptor();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR_DESCRIPTOR__ID = eINSTANCE.getEditorDescriptor_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR_DESCRIPTOR__NAME = eINSTANCE.getEditorDescriptor_Name();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR_DESCRIPTOR__PRIORITY = eINSTANCE.getEditorDescriptor_Priority();

		/**
		 * The meta object literal for the '<em><b>Factory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR_DESCRIPTOR__FACTORY = eINSTANCE.getEditorDescriptor_Factory();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR_DESCRIPTOR__IMAGE = eINSTANCE.getEditorDescriptor_Image();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.navigator.editors.IEditor <em>IEditor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.rcpcompany.uibindings.navigator.editors.IEditor
		 * @see com.rcpcompany.uibindings.navigator.editors.internal.EditorsPackageImpl#getIEditor()
		 * @generated
		 */
		EClass IEDITOR = eINSTANCE.getIEditor();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.navigator.editors.internal.StringToModelTypeMapEntryImpl <em>String To Model Type Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.rcpcompany.uibindings.navigator.editors.internal.StringToModelTypeMapEntryImpl
		 * @see com.rcpcompany.uibindings.navigator.editors.internal.EditorsPackageImpl#getStringToModelTypeMapEntry()
		 * @generated
		 */
		EClass STRING_TO_MODEL_TYPE_MAP_ENTRY = eINSTANCE.getStringToModelTypeMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_MODEL_TYPE_MAP_ENTRY__KEY = eINSTANCE.getStringToModelTypeMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_TO_MODEL_TYPE_MAP_ENTRY__VALUE = eINSTANCE.getStringToModelTypeMapEntry_Value();

	}

} //IEditorsPackage
