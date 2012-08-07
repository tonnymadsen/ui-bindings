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
package com.rcpcompany.uibinding.tests.model.internal;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibinding.tests.model.TestGrid;
import com.rcpcompany.uibinding.tests.model.TestGridCell;
import com.rcpcompany.uibinding.tests.model.TestGridColumn;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Test Grid Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestGridColumnImpl#getGrid <em>Grid
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestGridColumnImpl#getName <em>Name
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestGridColumnImpl#getCells <em>Cells
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TestGridColumnImpl extends EObjectImpl implements TestGridColumn {
	/**
	 * The cached value of the '{@link #getGrid() <em>Grid</em>}' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGrid()
	 * @generated
	 * @ordered
	 */
	protected TestGrid grid;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCells() <em>Cells</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCells()
	 * @generated
	 * @ordered
	 */
	protected EList<TestGridCell> cells;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TestGridColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestModelPackage.Literals.TEST_GRID_COLUMN;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public TestGrid getGrid() {
		return grid;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetGrid(TestGrid newGrid, NotificationChain msgs) {
		final TestGrid oldGrid = grid;
		grid = newGrid;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					TestModelPackage.TEST_GRID_COLUMN__GRID, oldGrid, newGrid);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setGrid(TestGrid newGrid) {
		if (newGrid != grid) {
			NotificationChain msgs = null;
			if (grid != null) {
				msgs = ((InternalEObject) grid).eInverseRemove(this, TestModelPackage.TEST_GRID__COLUMNS,
						TestGrid.class, msgs);
			}
			if (newGrid != null) {
				msgs = ((InternalEObject) newGrid).eInverseAdd(this, TestModelPackage.TEST_GRID__COLUMNS,
						TestGrid.class, msgs);
			}
			msgs = basicSetGrid(newGrid, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_GRID_COLUMN__GRID, newGrid,
					newGrid));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		final String oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_GRID_COLUMN__NAME, oldName,
					name));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<TestGridCell> getCells() {
		if (cells == null) {
			cells = new EObjectWithInverseEList<TestGridCell>(TestGridCell.class, this,
					TestModelPackage.TEST_GRID_COLUMN__CELLS, TestModelPackage.TEST_GRID_CELL__COLUMN);
		}
		return cells;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TestModelPackage.TEST_GRID_COLUMN__GRID:
			if (grid != null) {
				msgs = ((InternalEObject) grid).eInverseRemove(this, TestModelPackage.TEST_GRID__COLUMNS,
						TestGrid.class, msgs);
			}
			return basicSetGrid((TestGrid) otherEnd, msgs);
		case TestModelPackage.TEST_GRID_COLUMN__CELLS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getCells()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TestModelPackage.TEST_GRID_COLUMN__GRID:
			return basicSetGrid(null, msgs);
		case TestModelPackage.TEST_GRID_COLUMN__CELLS:
			return ((InternalEList<?>) getCells()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case TestModelPackage.TEST_GRID_COLUMN__GRID:
			return getGrid();
		case TestModelPackage.TEST_GRID_COLUMN__NAME:
			return getName();
		case TestModelPackage.TEST_GRID_COLUMN__CELLS:
			return getCells();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case TestModelPackage.TEST_GRID_COLUMN__GRID:
			setGrid((TestGrid) newValue);
			return;
		case TestModelPackage.TEST_GRID_COLUMN__NAME:
			setName((String) newValue);
			return;
		case TestModelPackage.TEST_GRID_COLUMN__CELLS:
			getCells().clear();
			getCells().addAll((Collection<? extends TestGridCell>) newValue);
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
		case TestModelPackage.TEST_GRID_COLUMN__GRID:
			setGrid((TestGrid) null);
			return;
		case TestModelPackage.TEST_GRID_COLUMN__NAME:
			setName(NAME_EDEFAULT);
			return;
		case TestModelPackage.TEST_GRID_COLUMN__CELLS:
			getCells().clear();
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
		case TestModelPackage.TEST_GRID_COLUMN__GRID:
			return grid != null;
		case TestModelPackage.TEST_GRID_COLUMN__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case TestModelPackage.TEST_GRID_COLUMN__CELLS:
			return cells != null && !cells.isEmpty();
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
		if (eIsProxy()) return super.toString();

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} // TestGridColumnImpl
