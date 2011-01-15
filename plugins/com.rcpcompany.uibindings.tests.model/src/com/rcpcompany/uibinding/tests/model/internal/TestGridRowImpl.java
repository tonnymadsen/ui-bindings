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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibinding.tests.model.TestGrid;
import com.rcpcompany.uibinding.tests.model.TestGridRow;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Test Grid Row</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestGridRowImpl#getGrid <em>Grid</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestGridRowImpl#getNumber <em>Number
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TestGridRowImpl extends EObjectImpl implements TestGridRow {
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
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected int number = NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TestGridRowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestModelPackage.Literals.TEST_GRID_ROW;
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
					TestModelPackage.TEST_GRID_ROW__GRID, oldGrid, newGrid);
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
				msgs = ((InternalEObject) grid).eInverseRemove(this, TestModelPackage.TEST_GRID__ROWS, TestGrid.class,
						msgs);
			}
			if (newGrid != null) {
				msgs = ((InternalEObject) newGrid).eInverseAdd(this, TestModelPackage.TEST_GRID__ROWS, TestGrid.class,
						msgs);
			}
			msgs = basicSetGrid(newGrid, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_GRID_ROW__GRID, newGrid,
					newGrid));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setNumber(int newNumber) {
		final int oldNumber = number;
		number = newNumber;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_GRID_ROW__NUMBER, oldNumber,
					number));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TestModelPackage.TEST_GRID_ROW__GRID:
			if (grid != null) {
				msgs = ((InternalEObject) grid).eInverseRemove(this, TestModelPackage.TEST_GRID__ROWS, TestGrid.class,
						msgs);
			}
			return basicSetGrid((TestGrid) otherEnd, msgs);
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
		case TestModelPackage.TEST_GRID_ROW__GRID:
			return basicSetGrid(null, msgs);
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
		case TestModelPackage.TEST_GRID_ROW__GRID:
			return getGrid();
		case TestModelPackage.TEST_GRID_ROW__NUMBER:
			return getNumber();
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
		case TestModelPackage.TEST_GRID_ROW__GRID:
			setGrid((TestGrid) newValue);
			return;
		case TestModelPackage.TEST_GRID_ROW__NUMBER:
			setNumber((Integer) newValue);
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
		case TestModelPackage.TEST_GRID_ROW__GRID:
			setGrid((TestGrid) null);
			return;
		case TestModelPackage.TEST_GRID_ROW__NUMBER:
			setNumber(NUMBER_EDEFAULT);
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
		case TestModelPackage.TEST_GRID_ROW__GRID:
			return grid != null;
		case TestModelPackage.TEST_GRID_ROW__NUMBER:
			return number != NUMBER_EDEFAULT;
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
		result.append(" (number: ");
		result.append(number);
		result.append(')');
		return result.toString();
	}

} // TestGridRowImpl
