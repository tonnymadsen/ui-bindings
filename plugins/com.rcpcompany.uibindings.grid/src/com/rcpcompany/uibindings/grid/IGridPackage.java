/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.grid;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.rcpcompany.uibindings.IUIBindingsPackage;

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
 * @see com.rcpcompany.uibindings.grid.IGridFactory
 * @generated
 */
public interface IGridPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "grid";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://rcp-company.com/schemas/uibindings/grid";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "grid";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	IGridPackage eINSTANCE = com.rcpcompany.uibindings.grid.internal.GridPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.grid.internal.GridBindingImpl
	 * <em>Binding</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.grid.internal.GridBindingImpl
	 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getGridBinding()
	 * @generated
	 */
	int GRID_BINDING = 0;

	/**
	 * The feature id for the '<em><b>Services</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__SERVICES = IUIBindingsPackage.BINDING__SERVICES;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__CONTEXT = IUIBindingsPackage.BINDING__CONTEXT;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__STATE = IUIBindingsPackage.BINDING__STATE;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__CHANGEABLE = IUIBindingsPackage.BINDING__CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Creation Point</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__CREATION_POINT = IUIBindingsPackage.BINDING__CREATION_POINT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__ID = IUIBindingsPackage.BINDING__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__TYPE = IUIBindingsPackage.BINDING__TYPE;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__LABEL = IUIBindingsPackage.BINDING__LABEL;

	/**
	 * The feature id for the '<em><b>Static Data Type</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__STATIC_DATA_TYPE = IUIBindingsPackage.BINDING__STATIC_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__DATA_TYPE = IUIBindingsPackage.BINDING__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Model EType</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__MODEL_ETYPE = IUIBindingsPackage.BINDING__MODEL_ETYPE;

	/**
	 * The feature id for the '<em><b>Model Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__MODEL_TYPE = IUIBindingsPackage.BINDING__MODEL_TYPE;

	/**
	 * The feature id for the '<em><b>UI Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__UI_TYPE = IUIBindingsPackage.BINDING__UI_TYPE;

	/**
	 * The feature id for the '<em><b>DB Bindings</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__DB_BINDINGS = IUIBindingsPackage.BINDING__DB_BINDINGS;

	/**
	 * The feature id for the '<em><b>Monitored DB Bindings</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__MONITORED_DB_BINDINGS = IUIBindingsPackage.BINDING__MONITORED_DB_BINDINGS;

	/**
	 * The feature id for the '<em><b>Error Conditions</b></em>' attribute list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__ERROR_CONDITIONS = IUIBindingsPackage.BINDING__ERROR_CONDITIONS;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__WIDGET = IUIBindingsPackage.BINDING__WIDGET;

	/**
	 * The feature id for the '<em><b>Control</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__CONTROL = IUIBindingsPackage.BINDING__CONTROL;

	/**
	 * The feature id for the '<em><b>Extra Argument Providers</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__EXTRA_ARGUMENT_PROVIDERS = IUIBindingsPackage.BINDING__EXTRA_ARGUMENT_PROVIDERS;

	/**
	 * The feature id for the '<em><b>No Column Headers</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__NO_COLUMN_HEADERS = IUIBindingsPackage.BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' map. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__COLUMNS = IUIBindingsPackage.BINDING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>No Row Headers</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__NO_ROW_HEADERS = IUIBindingsPackage.BINDING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Rows</b></em>' map. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__ROWS = IUIBindingsPackage.BINDING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Grid</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__GRID = IUIBindingsPackage.BINDING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Model</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__MODEL = IUIBindingsPackage.BINDING_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Focus Cell</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__FOCUS_CELL = IUIBindingsPackage.BINDING_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Cell Editor</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING__CELL_EDITOR = IUIBindingsPackage.BINDING_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Binding</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_FEATURE_COUNT = IUIBindingsPackage.BINDING_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.grid.internal.GridBindingCellInformationImpl
	 * <em>Binding Cell Information</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.grid.internal.GridBindingCellInformationImpl
	 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getGridBindingCellInformation()
	 * @generated
	 */
	int GRID_BINDING_CELL_INFORMATION = 1;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_CELL_INFORMATION__COLUMN = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Row</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_CELL_INFORMATION__ROW = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_CELL_INFORMATION__DATA_TYPE = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Label Binding</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_CELL_INFORMATION__LABEL_BINDING = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Label UI Attribute</b></em>' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_CELL_INFORMATION__LABEL_UI_ATTRIBUTE = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Object Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_CELL_INFORMATION__OBJECT_VALUE = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_CELL_INFORMATION__CHANGEABLE = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Display Text</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_CELL_INFORMATION__DISPLAY_TEXT = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Value Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_CELL_INFORMATION__VALUE_TYPE = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Paste UI Attribute</b></em>' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_CELL_INFORMATION__PASTE_UI_ATTRIBUTE = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_CELL_INFORMATION__ENABLED = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Painter</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_CELL_INFORMATION__PAINTER = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Binding Cell Information</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_CELL_INFORMATION_FEATURE_COUNT = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.grid.internal.GridBindingCellEditorImpl
	 * <em>Binding Cell Editor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.grid.internal.GridBindingCellEditorImpl
	 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getGridBindingCellEditor()
	 * @generated
	 */
	int GRID_BINDING_CELL_EDITOR = 2;

	/**
	 * The feature id for the '<em><b>Grid</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_CELL_EDITOR__GRID = 0;

	/**
	 * The feature id for the '<em><b>Grid Editor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_CELL_EDITOR__GRID_EDITOR = 1;

	/**
	 * The feature id for the '<em><b>Active Edit Cell</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_CELL_EDITOR__ACTIVE_EDIT_CELL = 2;

	/**
	 * The number of structural features of the '<em>Binding Cell Editor</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_CELL_EDITOR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.grid.internal.GridBindingColumnInformationImpl
	 * <em>Binding Column Information</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.grid.internal.GridBindingColumnInformationImpl
	 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getGridBindingColumnInformation()
	 * @generated
	 */
	int GRID_BINDING_COLUMN_INFORMATION = 3;

	/**
	 * The feature id for the '<em><b>Grid</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_COLUMN_INFORMATION__GRID = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_COLUMN_INFORMATION__ID = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Row Cells</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_COLUMN_INFORMATION__ROW_CELLS = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Grid Column</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_COLUMN_INFORMATION__GRID_COLUMN = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Binding Column Information</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_COLUMN_INFORMATION_FEATURE_COUNT = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.grid.internal.GridBindingRowInformationImpl
	 * <em>Binding Row Information</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.grid.internal.GridBindingRowInformationImpl
	 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getGridBindingRowInformation()
	 * @generated
	 */
	int GRID_BINDING_ROW_INFORMATION = 4;

	/**
	 * The feature id for the '<em><b>Grid</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_ROW_INFORMATION__GRID = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_ROW_INFORMATION__ID = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Column Cells</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_ROW_INFORMATION__COLUMN_CELLS = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Grid Item</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_ROW_INFORMATION__GRID_ITEM = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Binding Row Information</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRID_BINDING_ROW_INFORMATION_FEATURE_COUNT = IUIBindingsPackage.IDISPOSABLE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.grid.internal.ObjectToColumnMapEntryImpl
	 * <em>Object To Column Map Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.grid.internal.ObjectToColumnMapEntryImpl
	 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getObjectToColumnMapEntry()
	 * @generated
	 */
	int OBJECT_TO_COLUMN_MAP_ENTRY = 5;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_TO_COLUMN_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_TO_COLUMN_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Object To Column Map Entry</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_TO_COLUMN_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.grid.internal.ObjectToRowMapEntryImpl
	 * <em>Object To Row Map Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.grid.internal.ObjectToRowMapEntryImpl
	 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getObjectToRowMapEntry()
	 * @generated
	 */
	int OBJECT_TO_ROW_MAP_ENTRY = 6;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_TO_ROW_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_TO_ROW_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Object To Row Map Entry</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_TO_ROW_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '<em>Grid</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.nebula.widgets.grid.Grid
	 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getGrid()
	 * @generated
	 */
	int GRID = 7;

	/**
	 * The meta object id for the '<em>Column</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.nebula.widgets.grid.GridColumn
	 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getGridColumn()
	 * @generated
	 */
	int GRID_COLUMN = 8;

	/**
	 * The meta object id for the '<em>Editor</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.nebula.widgets.grid.GridEditor
	 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getGridEditor()
	 * @generated
	 */
	int GRID_EDITOR = 9;

	/**
	 * The meta object id for the '<em>Item</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.nebula.widgets.grid.GridItem
	 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getGridItem()
	 * @generated
	 */
	int GRID_ITEM = 10;

	/**
	 * The meta object id for the '<em>IGrid Model</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.grid.IGridModel
	 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getIGridModel()
	 * @generated
	 */
	int IGRID_MODEL = 11;

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.grid.IGridBinding
	 * <em>Binding</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Binding</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBinding
	 * @generated
	 */
	EClass getGridBinding();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.grid.IGridBinding#getNoColumnHeaders
	 * <em>No Column Headers</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>No Column Headers</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBinding#getNoColumnHeaders()
	 * @see #getGridBinding()
	 * @generated
	 */
	EAttribute getGridBinding_NoColumnHeaders();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.grid.IGridBinding#getCellEditor <em>Cell Editor</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Cell Editor</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBinding#getCellEditor()
	 * @see #getGridBinding()
	 * @generated
	 */
	EReference getGridBinding_CellEditor();

	/**
	 * Returns the meta object for the map '
	 * {@link com.rcpcompany.uibindings.grid.IGridBinding#getRows <em>Rows</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the map '<em>Rows</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBinding#getRows()
	 * @see #getGridBinding()
	 * @generated
	 */
	EReference getGridBinding_Rows();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.grid.IGridBinding#getGrid <em>Grid</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Grid</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBinding#getGrid()
	 * @see #getGridBinding()
	 * @generated
	 */
	EAttribute getGridBinding_Grid();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.grid.IGridBinding#getModel <em>Model</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Model</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBinding#getModel()
	 * @see #getGridBinding()
	 * @generated
	 */
	EAttribute getGridBinding_Model();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.grid.IGridBinding#getFocusCell <em>Focus Cell</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Focus Cell</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBinding#getFocusCell()
	 * @see #getGridBinding()
	 * @generated
	 */
	EReference getGridBinding_FocusCell();

	/**
	 * Returns the meta object for the map '
	 * {@link com.rcpcompany.uibindings.grid.IGridBinding#getColumns <em>Columns</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the map '<em>Columns</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBinding#getColumns()
	 * @see #getGridBinding()
	 * @generated
	 */
	EReference getGridBinding_Columns();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.grid.IGridBinding#getNoRowHeaders <em>No Row Headers</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>No Row Headers</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBinding#getNoRowHeaders()
	 * @see #getGridBinding()
	 * @generated
	 */
	EAttribute getGridBinding_NoRowHeaders();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation
	 * <em>Binding Cell Information</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Binding Cell Information</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellInformation
	 * @generated
	 */
	EClass getGridBindingCellInformation();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getColumn <em>Column</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Column</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getColumn()
	 * @see #getGridBindingCellInformation()
	 * @generated
	 */
	EReference getGridBindingCellInformation_Column();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getRow <em>Row</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Row</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getRow()
	 * @see #getGridBindingCellInformation()
	 * @generated
	 */
	EReference getGridBindingCellInformation_Row();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getDataType
	 * <em>Data Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Data Type</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getDataType()
	 * @see #getGridBindingCellInformation()
	 * @generated
	 */
	EReference getGridBindingCellInformation_DataType();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getLabelBinding
	 * <em>Label Binding</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Label Binding</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getLabelBinding()
	 * @see #getGridBindingCellInformation()
	 * @generated
	 */
	EReference getGridBindingCellInformation_LabelBinding();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getLabelUIAttribute
	 * <em>Label UI Attribute</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Label UI Attribute</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getLabelUIAttribute()
	 * @see #getGridBindingCellInformation()
	 * @generated
	 */
	EReference getGridBindingCellInformation_LabelUIAttribute();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getObjectValue
	 * <em>Object Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Object Value</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getObjectValue()
	 * @see #getGridBindingCellInformation()
	 * @generated
	 */
	EAttribute getGridBindingCellInformation_ObjectValue();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#isChangeable
	 * <em>Changeable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Changeable</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellInformation#isChangeable()
	 * @see #getGridBindingCellInformation()
	 * @generated
	 */
	EAttribute getGridBindingCellInformation_Changeable();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getDisplayText
	 * <em>Display Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Display Text</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getDisplayText()
	 * @see #getGridBindingCellInformation()
	 * @generated
	 */
	EAttribute getGridBindingCellInformation_DisplayText();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getValueType
	 * <em>Value Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value Type</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getValueType()
	 * @see #getGridBindingCellInformation()
	 * @generated
	 */
	EAttribute getGridBindingCellInformation_ValueType();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getPasteUIAttribute
	 * <em>Paste UI Attribute</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Paste UI Attribute</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getPasteUIAttribute()
	 * @see #getGridBindingCellInformation()
	 * @generated
	 */
	EReference getGridBindingCellInformation_PasteUIAttribute();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#isEnabled <em>Enabled</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellInformation#isEnabled()
	 * @see #getGridBindingCellInformation()
	 * @generated
	 */
	EAttribute getGridBindingCellInformation_Enabled();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getPainter
	 * <em>Painter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Painter</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getPainter()
	 * @see #getGridBindingCellInformation()
	 * @generated
	 */
	EAttribute getGridBindingCellInformation_Painter();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellEditor <em>Binding Cell Editor</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Binding Cell Editor</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellEditor
	 * @generated
	 */
	EClass getGridBindingCellEditor();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellEditor#getGrid <em>Grid</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Grid</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellEditor#getGrid()
	 * @see #getGridBindingCellEditor()
	 * @generated
	 */
	EReference getGridBindingCellEditor_Grid();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellEditor#getGridEditor
	 * <em>Grid Editor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Grid Editor</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellEditor#getGridEditor()
	 * @see #getGridBindingCellEditor()
	 * @generated
	 */
	EAttribute getGridBindingCellEditor_GridEditor();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellEditor#getActiveEditCell
	 * <em>Active Edit Cell</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Active Edit Cell</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellEditor#getActiveEditCell()
	 * @see #getGridBindingCellEditor()
	 * @generated
	 */
	EReference getGridBindingCellEditor_ActiveEditCell();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingColumnInformation
	 * <em>Binding Column Information</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Binding Column Information</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingColumnInformation
	 * @generated
	 */
	EClass getGridBindingColumnInformation();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingColumnInformation#getGrid <em>Grid</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Grid</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingColumnInformation#getGrid()
	 * @see #getGridBindingColumnInformation()
	 * @generated
	 */
	EReference getGridBindingColumnInformation_Grid();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingColumnInformation#getId <em>Id</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingColumnInformation#getId()
	 * @see #getGridBindingColumnInformation()
	 * @generated
	 */
	EAttribute getGridBindingColumnInformation_Id();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingColumnInformation#getRowCells
	 * <em>Row Cells</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Row Cells</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingColumnInformation#getRowCells()
	 * @see #getGridBindingColumnInformation()
	 * @generated
	 */
	EReference getGridBindingColumnInformation_RowCells();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingColumnInformation#getGridColumn
	 * <em>Grid Column</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Grid Column</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingColumnInformation#getGridColumn()
	 * @see #getGridBindingColumnInformation()
	 * @generated
	 */
	EAttribute getGridBindingColumnInformation_GridColumn();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingRowInformation
	 * <em>Binding Row Information</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Binding Row Information</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingRowInformation
	 * @generated
	 */
	EClass getGridBindingRowInformation();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingRowInformation#getGrid <em>Grid</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Grid</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingRowInformation#getGrid()
	 * @see #getGridBindingRowInformation()
	 * @generated
	 */
	EReference getGridBindingRowInformation_Grid();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingRowInformation#getId <em>Id</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingRowInformation#getId()
	 * @see #getGridBindingRowInformation()
	 * @generated
	 */
	EAttribute getGridBindingRowInformation_Id();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingRowInformation#getColumnCells
	 * <em>Column Cells</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Column Cells</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingRowInformation#getColumnCells()
	 * @see #getGridBindingRowInformation()
	 * @generated
	 */
	EReference getGridBindingRowInformation_ColumnCells();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingRowInformation#getGridItem
	 * <em>Grid Item</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Grid Item</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridBindingRowInformation#getGridItem()
	 * @see #getGridBindingRowInformation()
	 * @generated
	 */
	EAttribute getGridBindingRowInformation_GridItem();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry
	 * <em>Object To Column Map Entry</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Object To Column Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	EClass getObjectToColumnMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getObjectToColumnMapEntry()
	 * @generated
	 */
	EAttribute getObjectToColumnMapEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getObjectToColumnMapEntry()
	 * @generated
	 */
	EReference getObjectToColumnMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry
	 * <em>Object To Row Map Entry</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Object To Row Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	EClass getObjectToRowMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getObjectToRowMapEntry()
	 * @generated
	 */
	EAttribute getObjectToRowMapEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getObjectToRowMapEntry()
	 * @generated
	 */
	EReference getObjectToRowMapEntry_Value();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.nebula.widgets.grid.Grid
	 * <em>Grid</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Grid</em>'.
	 * @see org.eclipse.nebula.widgets.grid.Grid
	 * @generated
	 */
	EDataType getGrid();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.nebula.widgets.grid.GridColumn
	 * <em>Column</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Column</em>'.
	 * @see org.eclipse.nebula.widgets.grid.GridColumn
	 * @generated
	 */
	EDataType getGridColumn();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.nebula.widgets.grid.GridEditor
	 * <em>Editor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Editor</em>'.
	 * @see org.eclipse.nebula.widgets.grid.GridEditor
	 * @generated
	 */
	EDataType getGridEditor();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.nebula.widgets.grid.GridItem
	 * <em>Item</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Item</em>'.
	 * @see org.eclipse.nebula.widgets.grid.GridItem
	 * @generated
	 */
	EDataType getGridItem();

	/**
	 * Returns the meta object for data type '{@link com.rcpcompany.uibindings.grid.IGridModel
	 * <em>IGrid Model</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>IGrid Model</em>'.
	 * @see com.rcpcompany.uibindings.grid.IGridModel
	 * @generated
	 */
	EDataType getIGridModel();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IGridFactory getGridFactory();

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
		 * {@link com.rcpcompany.uibindings.grid.internal.GridBindingImpl <em>Binding</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.grid.internal.GridBindingImpl
		 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getGridBinding()
		 * @generated
		 */
		EClass GRID_BINDING = eINSTANCE.getGridBinding();

		/**
		 * The meta object literal for the '<em><b>No Column Headers</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRID_BINDING__NO_COLUMN_HEADERS = eINSTANCE.getGridBinding_NoColumnHeaders();

		/**
		 * The meta object literal for the '<em><b>Cell Editor</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRID_BINDING__CELL_EDITOR = eINSTANCE.getGridBinding_CellEditor();

		/**
		 * The meta object literal for the '<em><b>Rows</b></em>' map feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRID_BINDING__ROWS = eINSTANCE.getGridBinding_Rows();

		/**
		 * The meta object literal for the '<em><b>Grid</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRID_BINDING__GRID = eINSTANCE.getGridBinding_Grid();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRID_BINDING__MODEL = eINSTANCE.getGridBinding_Model();

		/**
		 * The meta object literal for the '<em><b>Focus Cell</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRID_BINDING__FOCUS_CELL = eINSTANCE.getGridBinding_FocusCell();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRID_BINDING__COLUMNS = eINSTANCE.getGridBinding_Columns();

		/**
		 * The meta object literal for the '<em><b>No Row Headers</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRID_BINDING__NO_ROW_HEADERS = eINSTANCE.getGridBinding_NoRowHeaders();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.grid.internal.GridBindingCellInformationImpl
		 * <em>Binding Cell Information</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.grid.internal.GridBindingCellInformationImpl
		 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getGridBindingCellInformation()
		 * @generated
		 */
		EClass GRID_BINDING_CELL_INFORMATION = eINSTANCE.getGridBindingCellInformation();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRID_BINDING_CELL_INFORMATION__COLUMN = eINSTANCE.getGridBindingCellInformation_Column();

		/**
		 * The meta object literal for the '<em><b>Row</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRID_BINDING_CELL_INFORMATION__ROW = eINSTANCE.getGridBindingCellInformation_Row();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRID_BINDING_CELL_INFORMATION__DATA_TYPE = eINSTANCE.getGridBindingCellInformation_DataType();

		/**
		 * The meta object literal for the '<em><b>Label Binding</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRID_BINDING_CELL_INFORMATION__LABEL_BINDING = eINSTANCE
				.getGridBindingCellInformation_LabelBinding();

		/**
		 * The meta object literal for the '<em><b>Label UI Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRID_BINDING_CELL_INFORMATION__LABEL_UI_ATTRIBUTE = eINSTANCE
				.getGridBindingCellInformation_LabelUIAttribute();

		/**
		 * The meta object literal for the '<em><b>Object Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRID_BINDING_CELL_INFORMATION__OBJECT_VALUE = eINSTANCE.getGridBindingCellInformation_ObjectValue();

		/**
		 * The meta object literal for the '<em><b>Changeable</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRID_BINDING_CELL_INFORMATION__CHANGEABLE = eINSTANCE.getGridBindingCellInformation_Changeable();

		/**
		 * The meta object literal for the '<em><b>Display Text</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRID_BINDING_CELL_INFORMATION__DISPLAY_TEXT = eINSTANCE.getGridBindingCellInformation_DisplayText();

		/**
		 * The meta object literal for the '<em><b>Value Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRID_BINDING_CELL_INFORMATION__VALUE_TYPE = eINSTANCE.getGridBindingCellInformation_ValueType();

		/**
		 * The meta object literal for the '<em><b>Paste UI Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRID_BINDING_CELL_INFORMATION__PASTE_UI_ATTRIBUTE = eINSTANCE
				.getGridBindingCellInformation_PasteUIAttribute();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRID_BINDING_CELL_INFORMATION__ENABLED = eINSTANCE.getGridBindingCellInformation_Enabled();

		/**
		 * The meta object literal for the '<em><b>Painter</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRID_BINDING_CELL_INFORMATION__PAINTER = eINSTANCE.getGridBindingCellInformation_Painter();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.grid.internal.GridBindingCellEditorImpl
		 * <em>Binding Cell Editor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.grid.internal.GridBindingCellEditorImpl
		 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getGridBindingCellEditor()
		 * @generated
		 */
		EClass GRID_BINDING_CELL_EDITOR = eINSTANCE.getGridBindingCellEditor();

		/**
		 * The meta object literal for the '<em><b>Grid</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRID_BINDING_CELL_EDITOR__GRID = eINSTANCE.getGridBindingCellEditor_Grid();

		/**
		 * The meta object literal for the '<em><b>Grid Editor</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRID_BINDING_CELL_EDITOR__GRID_EDITOR = eINSTANCE.getGridBindingCellEditor_GridEditor();

		/**
		 * The meta object literal for the '<em><b>Active Edit Cell</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRID_BINDING_CELL_EDITOR__ACTIVE_EDIT_CELL = eINSTANCE.getGridBindingCellEditor_ActiveEditCell();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.grid.internal.GridBindingColumnInformationImpl
		 * <em>Binding Column Information</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see com.rcpcompany.uibindings.grid.internal.GridBindingColumnInformationImpl
		 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getGridBindingColumnInformation()
		 * @generated
		 */
		EClass GRID_BINDING_COLUMN_INFORMATION = eINSTANCE.getGridBindingColumnInformation();

		/**
		 * The meta object literal for the '<em><b>Grid</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRID_BINDING_COLUMN_INFORMATION__GRID = eINSTANCE.getGridBindingColumnInformation_Grid();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRID_BINDING_COLUMN_INFORMATION__ID = eINSTANCE.getGridBindingColumnInformation_Id();

		/**
		 * The meta object literal for the '<em><b>Row Cells</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRID_BINDING_COLUMN_INFORMATION__ROW_CELLS = eINSTANCE.getGridBindingColumnInformation_RowCells();

		/**
		 * The meta object literal for the '<em><b>Grid Column</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRID_BINDING_COLUMN_INFORMATION__GRID_COLUMN = eINSTANCE
				.getGridBindingColumnInformation_GridColumn();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.grid.internal.GridBindingRowInformationImpl
		 * <em>Binding Row Information</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.grid.internal.GridBindingRowInformationImpl
		 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getGridBindingRowInformation()
		 * @generated
		 */
		EClass GRID_BINDING_ROW_INFORMATION = eINSTANCE.getGridBindingRowInformation();

		/**
		 * The meta object literal for the '<em><b>Grid</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRID_BINDING_ROW_INFORMATION__GRID = eINSTANCE.getGridBindingRowInformation_Grid();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRID_BINDING_ROW_INFORMATION__ID = eINSTANCE.getGridBindingRowInformation_Id();

		/**
		 * The meta object literal for the '<em><b>Column Cells</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRID_BINDING_ROW_INFORMATION__COLUMN_CELLS = eINSTANCE.getGridBindingRowInformation_ColumnCells();

		/**
		 * The meta object literal for the '<em><b>Grid Item</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRID_BINDING_ROW_INFORMATION__GRID_ITEM = eINSTANCE.getGridBindingRowInformation_GridItem();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.grid.internal.ObjectToColumnMapEntryImpl
		 * <em>Object To Column Map Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see com.rcpcompany.uibindings.grid.internal.ObjectToColumnMapEntryImpl
		 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getObjectToColumnMapEntry()
		 * @generated
		 */
		EClass OBJECT_TO_COLUMN_MAP_ENTRY = eINSTANCE.getObjectToColumnMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute OBJECT_TO_COLUMN_MAP_ENTRY__KEY = eINSTANCE.getObjectToColumnMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OBJECT_TO_COLUMN_MAP_ENTRY__VALUE = eINSTANCE.getObjectToColumnMapEntry_Value();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.grid.internal.ObjectToRowMapEntryImpl
		 * <em>Object To Row Map Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.grid.internal.ObjectToRowMapEntryImpl
		 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getObjectToRowMapEntry()
		 * @generated
		 */
		EClass OBJECT_TO_ROW_MAP_ENTRY = eINSTANCE.getObjectToRowMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute OBJECT_TO_ROW_MAP_ENTRY__KEY = eINSTANCE.getObjectToRowMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OBJECT_TO_ROW_MAP_ENTRY__VALUE = eINSTANCE.getObjectToRowMapEntry_Value();

		/**
		 * The meta object literal for the '<em>Grid</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.nebula.widgets.grid.Grid
		 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getGrid()
		 * @generated
		 */
		EDataType GRID = eINSTANCE.getGrid();

		/**
		 * The meta object literal for the '<em>Column</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.nebula.widgets.grid.GridColumn
		 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getGridColumn()
		 * @generated
		 */
		EDataType GRID_COLUMN = eINSTANCE.getGridColumn();

		/**
		 * The meta object literal for the '<em>Editor</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.nebula.widgets.grid.GridEditor
		 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getGridEditor()
		 * @generated
		 */
		EDataType GRID_EDITOR = eINSTANCE.getGridEditor();

		/**
		 * The meta object literal for the '<em>Item</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.nebula.widgets.grid.GridItem
		 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getGridItem()
		 * @generated
		 */
		EDataType GRID_ITEM = eINSTANCE.getGridItem();

		/**
		 * The meta object literal for the '<em>IGrid Model</em>' data type. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.grid.IGridModel
		 * @see com.rcpcompany.uibindings.grid.internal.GridPackageImpl#getIGridModel()
		 * @generated
		 */
		EDataType IGRID_MODEL = eINSTANCE.getIGridModel();

	}

} // IGridPackage
