/*******************************************************************************
 * Copyright (c) 2007, 2011 The RCP Company and others.
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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.IGridBindingCellEditor;
import com.rcpcompany.uibindings.grid.IGridBindingCellInformation;
import com.rcpcompany.uibindings.grid.IGridBindingColumnInformation;
import com.rcpcompany.uibindings.grid.IGridBindingRowInformation;
import com.rcpcompany.uibindings.grid.IGridFactory;
import com.rcpcompany.uibindings.grid.IGridPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class GridFactoryImpl extends EFactoryImpl implements IGridFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static IGridFactory init() {
		try {
			final IGridFactory theGridFactory = (IGridFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://rcp-company.com/schemas/uibindings/grid");
			if (theGridFactory != null) return theGridFactory;
		} catch (final Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GridFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GridFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case IGridPackage.GRID_BINDING:
			return createGridBinding();
		case IGridPackage.GRID_BINDING_CELL_INFORMATION:
			return createGridBindingCellInformation();
		case IGridPackage.GRID_BINDING_CELL_EDITOR:
			return createGridBindingCellEditor();
		case IGridPackage.GRID_BINDING_COLUMN_INFORMATION:
			return createGridBindingColumnInformation();
		case IGridPackage.GRID_BINDING_ROW_INFORMATION:
			return createGridBindingRowInformation();
		case IGridPackage.OBJECT_TO_COLUMN_MAP_ENTRY:
			return (EObject) createObjectToColumnMapEntry();
		case IGridPackage.OBJECT_TO_ROW_MAP_ENTRY:
			return (EObject) createObjectToRowMapEntry();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public IGridBinding createGridBinding() {
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public IGridBindingCellInformation createGridBindingCellInformation() {
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IGridBindingCellEditor createGridBindingCellEditor() {
		final GridBindingCellEditorImpl gridBindingCellEditor = new GridBindingCellEditorImpl();
		return gridBindingCellEditor;
	}

	@Override
	public IGridBindingCellInformation createGridBindingCellInformation(IGridBindingColumnInformation column,
			IGridBindingRowInformation row) {
		final GridBindingCellInformationImpl i = new GridBindingCellInformationImpl();
		i.init(column, row);
		return i;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public IGridBindingColumnInformation createGridBindingColumnInformation() {
		return null;
	}

	@Override
	public IGridBindingColumnInformation createGridBindingColumnInformation(IGridBinding grid, Object columnID,
			int index) {
		final GridBindingColumnInformationImpl i = new GridBindingColumnInformationImpl();
		i.init(grid, columnID, index);
		return i;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public IGridBindingRowInformation createGridBindingRowInformation() {
		return null;
	}

	@Override
	public IGridBindingRowInformation createGridBindingRowInformation(IGridBinding grid, Object rowID, int index) {
		final GridBindingRowInformationImpl i = new GridBindingRowInformationImpl();
		i.init(grid, rowID, index);
		return i;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Map.Entry<Object, IGridBindingColumnInformation> createObjectToColumnMapEntry() {
		final ObjectToColumnMapEntryImpl objectToColumnMapEntry = new ObjectToColumnMapEntryImpl();
		return objectToColumnMapEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Map.Entry<Object, IGridBindingRowInformation> createObjectToRowMapEntry() {
		final ObjectToRowMapEntryImpl objectToRowMapEntry = new ObjectToRowMapEntryImpl();
		return objectToRowMapEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IGridPackage getGridPackage() {
		return (IGridPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IGridPackage getPackage() {
		return IGridPackage.eINSTANCE;
	}

} // GridFactoryImpl
