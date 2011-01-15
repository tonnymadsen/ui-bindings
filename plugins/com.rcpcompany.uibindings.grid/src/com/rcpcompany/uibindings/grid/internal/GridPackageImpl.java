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
package com.rcpcompany.uibindings.grid.internal;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridEditor;
import org.eclipse.nebula.widgets.grid.GridItem;

import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.IGridBindingCellEditor;
import com.rcpcompany.uibindings.grid.IGridBindingCellInformation;
import com.rcpcompany.uibindings.grid.IGridBindingColumnInformation;
import com.rcpcompany.uibindings.grid.IGridBindingRowInformation;
import com.rcpcompany.uibindings.grid.IGridFactory;
import com.rcpcompany.uibindings.grid.IGridModel;
import com.rcpcompany.uibindings.grid.IGridPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class GridPackageImpl extends EPackageImpl implements IGridPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass gridBindingEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass gridBindingCellInformationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass gridBindingCellEditorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass gridBindingColumnInformationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass gridBindingRowInformationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass objectToColumnMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass objectToRowMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType gridEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType gridColumnEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType gridEditorEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType gridItemEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType iGridModelEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI
	 * value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init
	 * init()}, which also performs initialization of the package, or returns the registered
	 * package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GridPackageImpl() {
		super(eNS_URI, IGridFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others
	 * upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link IGridPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to
	 * obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static IGridPackage init() {
		if (isInited) return (IGridPackage) EPackage.Registry.INSTANCE.getEPackage(IGridPackage.eNS_URI);

		// Obtain or create and register package
		final GridPackageImpl theGridPackage = (GridPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GridPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new GridPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IUIBindingsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGridPackage.createPackageContents();

		// Initialize created meta-data
		theGridPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGridPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(IGridPackage.eNS_URI, theGridPackage);
		return theGridPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getGridBinding() {
		return gridBindingEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getGridBinding_NoColumnHeaders() {
		return (EAttribute) gridBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getGridBinding_CellEditor() {
		return (EReference) gridBindingEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getGridBinding_Rows() {
		return (EReference) gridBindingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getGridBinding_Grid() {
		return (EAttribute) gridBindingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getGridBinding_Model() {
		return (EAttribute) gridBindingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getGridBinding_FocusCell() {
		return (EReference) gridBindingEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getGridBinding_Columns() {
		return (EReference) gridBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getGridBinding_NoRowHeaders() {
		return (EAttribute) gridBindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getGridBindingCellInformation() {
		return gridBindingCellInformationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getGridBindingCellInformation_Column() {
		return (EReference) gridBindingCellInformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getGridBindingCellInformation_Row() {
		return (EReference) gridBindingCellInformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getGridBindingCellInformation_DataType() {
		return (EReference) gridBindingCellInformationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getGridBindingCellInformation_LabelBinding() {
		return (EReference) gridBindingCellInformationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getGridBindingCellInformation_LabelUIAttribute() {
		return (EReference) gridBindingCellInformationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getGridBindingCellInformation_ObjectValue() {
		return (EAttribute) gridBindingCellInformationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getGridBindingCellInformation_Changeable() {
		return (EAttribute) gridBindingCellInformationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getGridBindingCellInformation_DisplayText() {
		return (EAttribute) gridBindingCellInformationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getGridBindingCellInformation_ValueType() {
		return (EAttribute) gridBindingCellInformationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getGridBindingCellInformation_PasteUIAttribute() {
		return (EReference) gridBindingCellInformationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getGridBindingCellInformation_Enabled() {
		return (EAttribute) gridBindingCellInformationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getGridBindingCellInformation_Painter() {
		return (EAttribute) gridBindingCellInformationEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getGridBindingCellEditor() {
		return gridBindingCellEditorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getGridBindingCellEditor_Grid() {
		return (EReference) gridBindingCellEditorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getGridBindingCellEditor_GridEditor() {
		return (EAttribute) gridBindingCellEditorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getGridBindingCellEditor_ActiveEditCell() {
		return (EReference) gridBindingCellEditorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getGridBindingColumnInformation() {
		return gridBindingColumnInformationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getGridBindingColumnInformation_Grid() {
		return (EReference) gridBindingColumnInformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getGridBindingColumnInformation_Id() {
		return (EAttribute) gridBindingColumnInformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getGridBindingColumnInformation_RowCells() {
		return (EReference) gridBindingColumnInformationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getGridBindingColumnInformation_GridColumn() {
		return (EAttribute) gridBindingColumnInformationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getGridBindingRowInformation() {
		return gridBindingRowInformationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getGridBindingRowInformation_Grid() {
		return (EReference) gridBindingRowInformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getGridBindingRowInformation_Id() {
		return (EAttribute) gridBindingRowInformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getGridBindingRowInformation_ColumnCells() {
		return (EReference) gridBindingRowInformationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getGridBindingRowInformation_GridItem() {
		return (EAttribute) gridBindingRowInformationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getObjectToColumnMapEntry() {
		return objectToColumnMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getObjectToColumnMapEntry_Key() {
		return (EAttribute) objectToColumnMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getObjectToColumnMapEntry_Value() {
		return (EReference) objectToColumnMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getObjectToRowMapEntry() {
		return objectToRowMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getObjectToRowMapEntry_Key() {
		return (EAttribute) objectToRowMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getObjectToRowMapEntry_Value() {
		return (EReference) objectToRowMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getGrid() {
		return gridEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getGridColumn() {
		return gridColumnEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getGridEditor() {
		return gridEditorEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getGridItem() {
		return gridItemEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getIGridModel() {
		return iGridModelEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IGridFactory getGridFactory() {
		return (IGridFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to have no affect on
	 * any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		gridBindingEClass = createEClass(GRID_BINDING);
		createEAttribute(gridBindingEClass, GRID_BINDING__NO_COLUMN_HEADERS);
		createEReference(gridBindingEClass, GRID_BINDING__COLUMNS);
		createEAttribute(gridBindingEClass, GRID_BINDING__NO_ROW_HEADERS);
		createEReference(gridBindingEClass, GRID_BINDING__ROWS);
		createEAttribute(gridBindingEClass, GRID_BINDING__GRID);
		createEAttribute(gridBindingEClass, GRID_BINDING__MODEL);
		createEReference(gridBindingEClass, GRID_BINDING__FOCUS_CELL);
		createEReference(gridBindingEClass, GRID_BINDING__CELL_EDITOR);

		gridBindingCellInformationEClass = createEClass(GRID_BINDING_CELL_INFORMATION);
		createEReference(gridBindingCellInformationEClass, GRID_BINDING_CELL_INFORMATION__COLUMN);
		createEReference(gridBindingCellInformationEClass, GRID_BINDING_CELL_INFORMATION__ROW);
		createEReference(gridBindingCellInformationEClass, GRID_BINDING_CELL_INFORMATION__DATA_TYPE);
		createEReference(gridBindingCellInformationEClass, GRID_BINDING_CELL_INFORMATION__LABEL_BINDING);
		createEReference(gridBindingCellInformationEClass, GRID_BINDING_CELL_INFORMATION__LABEL_UI_ATTRIBUTE);
		createEAttribute(gridBindingCellInformationEClass, GRID_BINDING_CELL_INFORMATION__OBJECT_VALUE);
		createEAttribute(gridBindingCellInformationEClass, GRID_BINDING_CELL_INFORMATION__CHANGEABLE);
		createEAttribute(gridBindingCellInformationEClass, GRID_BINDING_CELL_INFORMATION__DISPLAY_TEXT);
		createEAttribute(gridBindingCellInformationEClass, GRID_BINDING_CELL_INFORMATION__VALUE_TYPE);
		createEReference(gridBindingCellInformationEClass, GRID_BINDING_CELL_INFORMATION__PASTE_UI_ATTRIBUTE);
		createEAttribute(gridBindingCellInformationEClass, GRID_BINDING_CELL_INFORMATION__ENABLED);
		createEAttribute(gridBindingCellInformationEClass, GRID_BINDING_CELL_INFORMATION__PAINTER);

		gridBindingCellEditorEClass = createEClass(GRID_BINDING_CELL_EDITOR);
		createEReference(gridBindingCellEditorEClass, GRID_BINDING_CELL_EDITOR__GRID);
		createEAttribute(gridBindingCellEditorEClass, GRID_BINDING_CELL_EDITOR__GRID_EDITOR);
		createEReference(gridBindingCellEditorEClass, GRID_BINDING_CELL_EDITOR__ACTIVE_EDIT_CELL);

		gridBindingColumnInformationEClass = createEClass(GRID_BINDING_COLUMN_INFORMATION);
		createEReference(gridBindingColumnInformationEClass, GRID_BINDING_COLUMN_INFORMATION__GRID);
		createEAttribute(gridBindingColumnInformationEClass, GRID_BINDING_COLUMN_INFORMATION__ID);
		createEReference(gridBindingColumnInformationEClass, GRID_BINDING_COLUMN_INFORMATION__ROW_CELLS);
		createEAttribute(gridBindingColumnInformationEClass, GRID_BINDING_COLUMN_INFORMATION__GRID_COLUMN);

		gridBindingRowInformationEClass = createEClass(GRID_BINDING_ROW_INFORMATION);
		createEReference(gridBindingRowInformationEClass, GRID_BINDING_ROW_INFORMATION__GRID);
		createEAttribute(gridBindingRowInformationEClass, GRID_BINDING_ROW_INFORMATION__ID);
		createEReference(gridBindingRowInformationEClass, GRID_BINDING_ROW_INFORMATION__COLUMN_CELLS);
		createEAttribute(gridBindingRowInformationEClass, GRID_BINDING_ROW_INFORMATION__GRID_ITEM);

		objectToColumnMapEntryEClass = createEClass(OBJECT_TO_COLUMN_MAP_ENTRY);
		createEAttribute(objectToColumnMapEntryEClass, OBJECT_TO_COLUMN_MAP_ENTRY__KEY);
		createEReference(objectToColumnMapEntryEClass, OBJECT_TO_COLUMN_MAP_ENTRY__VALUE);

		objectToRowMapEntryEClass = createEClass(OBJECT_TO_ROW_MAP_ENTRY);
		createEAttribute(objectToRowMapEntryEClass, OBJECT_TO_ROW_MAP_ENTRY__KEY);
		createEReference(objectToRowMapEntryEClass, OBJECT_TO_ROW_MAP_ENTRY__VALUE);

		// Create data types
		gridEDataType = createEDataType(GRID);
		gridColumnEDataType = createEDataType(GRID_COLUMN);
		gridEditorEDataType = createEDataType(GRID_EDITOR);
		gridItemEDataType = createEDataType(GRID_ITEM);
		iGridModelEDataType = createEDataType(IGRID_MODEL);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is guarded to have
	 * no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		final IUIBindingsPackage theUIBindingsPackage = (IUIBindingsPackage) EPackage.Registry.INSTANCE
				.getEPackage(IUIBindingsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		gridBindingEClass.getESuperTypes().add(theUIBindingsPackage.getContainerBinding());
		gridBindingEClass.getESuperTypes().add(theUIBindingsPackage.getIArgumentProvider());
		gridBindingCellInformationEClass.getESuperTypes().add(theUIBindingsPackage.getIDisposable());
		gridBindingCellInformationEClass.getESuperTypes().add(theUIBindingsPackage.getValueBindingCell());
		gridBindingColumnInformationEClass.getESuperTypes().add(theUIBindingsPackage.getIDisposable());
		gridBindingRowInformationEClass.getESuperTypes().add(theUIBindingsPackage.getIDisposable());

		// Initialize classes and features; add operations and parameters
		initEClass(gridBindingEClass, IGridBinding.class, "GridBinding", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGridBinding_NoColumnHeaders(), ecorePackage.getEInt(), "noColumnHeaders", null, 1, 1,
				IGridBinding.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getGridBinding_Columns(), this.getObjectToColumnMapEntry(), null, "columns", null, 0, -1,
				IGridBinding.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridBinding_NoRowHeaders(), ecorePackage.getEInt(), "noRowHeaders", null, 1, 1,
				IGridBinding.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getGridBinding_Rows(), this.getObjectToRowMapEntry(), null, "rows", null, 0, -1,
				IGridBinding.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridBinding_Grid(), this.getGrid(), "grid", null, 0, 1, IGridBinding.class, IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridBinding_Model(), this.getIGridModel(), "model", null, 0, 1, IGridBinding.class,
				IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGridBinding_FocusCell(), this.getGridBindingCellInformation(), null, "focusCell", null, 0, 1,
				IGridBinding.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGridBinding_CellEditor(), this.getGridBindingCellEditor(),
				this.getGridBindingCellEditor_Grid(), "cellEditor", null, 0, 1, IGridBinding.class, IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(gridBindingCellInformationEClass, IGridBindingCellInformation.class, "GridBindingCellInformation",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGridBindingCellInformation_Column(), this.getGridBindingColumnInformation(),
				this.getGridBindingColumnInformation_RowCells(), "column", null, 1, 1,
				IGridBindingCellInformation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGridBindingCellInformation_Row(), this.getGridBindingRowInformation(),
				this.getGridBindingRowInformation_ColumnCells(), "row", null, 1, 1, IGridBindingCellInformation.class,
				IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGridBindingCellInformation_DataType(), theUIBindingsPackage.getBindingDataType(), null,
				"dataType", null, 1, 1, IGridBindingCellInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGridBindingCellInformation_LabelBinding(), theUIBindingsPackage.getValueBinding(), null,
				"labelBinding", null, 1, 1, IGridBindingCellInformation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGridBindingCellInformation_LabelUIAttribute(), theUIBindingsPackage.getUIAttribute(), null,
				"labelUIAttribute", null, 1, 1, IGridBindingCellInformation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridBindingCellInformation_ObjectValue(), theUIBindingsPackage.getIObservableValue(),
				"objectValue", null, 1, 1, IGridBindingCellInformation.class, IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridBindingCellInformation_Changeable(), ecorePackage.getEBoolean(), "changeable", null, 1,
				1, IGridBindingCellInformation.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridBindingCellInformation_DisplayText(), ecorePackage.getEString(), "displayText", null, 1,
				1, IGridBindingCellInformation.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		final EGenericType g1 = createEGenericType(ecorePackage.getEJavaClass());
		final EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(getGridBindingCellInformation_ValueType(), g1, "valueType", null, 1, 1,
				IGridBindingCellInformation.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGridBindingCellInformation_PasteUIAttribute(), theUIBindingsPackage.getUIAttribute(), null,
				"pasteUIAttribute", null, 1, 1, IGridBindingCellInformation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridBindingCellInformation_Enabled(), ecorePackage.getEBoolean(), "enabled", "true", 1, 1,
				IGridBindingCellInformation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridBindingCellInformation_Painter(), theUIBindingsPackage.getUIAttributePainter(),
				"painter", null, 1, 1, IGridBindingCellInformation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gridBindingCellEditorEClass, IGridBindingCellEditor.class, "GridBindingCellEditor", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGridBindingCellEditor_Grid(), this.getGridBinding(), this.getGridBinding_CellEditor(),
				"grid", null, 1, 1, IGridBindingCellEditor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridBindingCellEditor_GridEditor(), this.getGridEditor(), "gridEditor", null, 0, 1,
				IGridBindingCellEditor.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGridBindingCellEditor_ActiveEditCell(), this.getGridBindingCellInformation(), null,
				"activeEditCell", null, 0, 1, IGridBindingCellEditor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gridBindingColumnInformationEClass, IGridBindingColumnInformation.class,
				"GridBindingColumnInformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGridBindingColumnInformation_Grid(), this.getGridBinding(), null, "grid", null, 0, 1,
				IGridBindingColumnInformation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridBindingColumnInformation_Id(), ecorePackage.getEJavaObject(), "id", null, 0, 1,
				IGridBindingColumnInformation.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGridBindingColumnInformation_RowCells(), this.getGridBindingCellInformation(),
				this.getGridBindingCellInformation_Column(), "rowCells", null, 0, -1,
				IGridBindingColumnInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridBindingColumnInformation_GridColumn(), this.getGridColumn(), "gridColumn", null, 1, 1,
				IGridBindingColumnInformation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gridBindingRowInformationEClass, IGridBindingRowInformation.class, "GridBindingRowInformation",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGridBindingRowInformation_Grid(), this.getGridBinding(), null, "grid", null, 0, 1,
				IGridBindingRowInformation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridBindingRowInformation_Id(), ecorePackage.getEJavaObject(), "id", null, 0, 1,
				IGridBindingRowInformation.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGridBindingRowInformation_ColumnCells(), this.getGridBindingCellInformation(),
				this.getGridBindingCellInformation_Row(), "columnCells", null, 0, -1, IGridBindingRowInformation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGridBindingRowInformation_GridItem(), this.getGridItem(), "gridItem", null, 0, 1,
				IGridBindingRowInformation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectToColumnMapEntryEClass, Map.Entry.class, "ObjectToColumnMapEntry", !IS_ABSTRACT,
				!IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getObjectToColumnMapEntry_Key(), ecorePackage.getEJavaObject(), "key", null, 0, 1,
				Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getObjectToColumnMapEntry_Value(), this.getGridBindingColumnInformation(), null, "value", null,
				0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectToRowMapEntryEClass, Map.Entry.class, "ObjectToRowMapEntry", !IS_ABSTRACT, !IS_INTERFACE,
				!IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getObjectToRowMapEntry_Key(), ecorePackage.getEJavaObject(), "key", null, 0, 1, Map.Entry.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectToRowMapEntry_Value(), this.getGridBindingRowInformation(), null, "value", null, 0, 1,
				Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(gridEDataType, Grid.class, "Grid", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(gridColumnEDataType, GridColumn.class, "GridColumn", !IS_SERIALIZABLE,
				!IS_GENERATED_INSTANCE_CLASS);
		initEDataType(gridEditorEDataType, GridEditor.class, "GridEditor", !IS_SERIALIZABLE,
				!IS_GENERATED_INSTANCE_CLASS);
		initEDataType(gridItemEDataType, GridItem.class, "GridItem", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iGridModelEDataType, IGridModel.class, "IGridModel", !IS_SERIALIZABLE,
				!IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} // GridPackageImpl
