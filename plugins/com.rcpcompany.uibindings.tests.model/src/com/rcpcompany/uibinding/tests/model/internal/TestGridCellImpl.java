/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibinding.tests.model.internal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibinding.tests.model.TestGridCell;
import com.rcpcompany.uibinding.tests.model.TestGridColumn;
import com.rcpcompany.uibinding.tests.model.TestGridRow;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Test Grid Cell</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestGridCellImpl#getDetails <em>Details</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestGridCellImpl#getPrice <em>Price</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestGridCellImpl#getColumn <em>Column</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestGridCellImpl#getRow <em>Row</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TestGridCellImpl extends EObjectImpl implements TestGridCell {
	/**
	 * The default value of the '{@link #getDetails() <em>Details</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getDetails()
	 * @generated
	 * @ordered
	 */
	protected static final String DETAILS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDetails() <em>Details</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getDetails()
	 * @generated
	 * @ordered
	 */
	protected String details = DETAILS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrice() <em>Price</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getPrice()
	 * @generated
	 * @ordered
	 */
	protected static final float PRICE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getPrice() <em>Price</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getPrice()
	 * @generated
	 * @ordered
	 */
	protected float price = PRICE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected TestGridColumn column;

	/**
	 * The cached value of the '{@link #getRow() <em>Row</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRow()
	 * @generated
	 * @ordered
	 */
	protected TestGridRow row;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TestGridCellImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestModelPackage.Literals.TEST_GRID_CELL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDetails(String newDetails) {
		final String oldDetails = details;
		details = newDetails;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_GRID_CELL__DETAILS, oldDetails,
					details));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPrice(float newPrice) {
		final float oldPrice = price;
		price = newPrice;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_GRID_CELL__PRICE, oldPrice,
					price));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TestGridColumn getColumn() {
		return column;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetColumn(TestGridColumn newColumn, NotificationChain msgs) {
		final TestGridColumn oldColumn = column;
		column = newColumn;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					TestModelPackage.TEST_GRID_CELL__COLUMN, oldColumn, newColumn);
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
	public void setColumn(TestGridColumn newColumn) {
		if (newColumn != column) {
			NotificationChain msgs = null;
			if (column != null) {
				msgs = ((InternalEObject) column).eInverseRemove(this, TestModelPackage.TEST_GRID_COLUMN__CELLS,
						TestGridColumn.class, msgs);
			}
			if (newColumn != null) {
				msgs = ((InternalEObject) newColumn).eInverseAdd(this, TestModelPackage.TEST_GRID_COLUMN__CELLS,
						TestGridColumn.class, msgs);
			}
			msgs = basicSetColumn(newColumn, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_GRID_CELL__COLUMN, newColumn,
					newColumn));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TestGridRow getRow() {
		return row;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRow(TestGridRow newRow) {
		final TestGridRow oldRow = row;
		row = newRow;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_GRID_CELL__ROW, oldRow, row));
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
		case TestModelPackage.TEST_GRID_CELL__COLUMN:
			if (column != null) {
				msgs = ((InternalEObject) column).eInverseRemove(this, TestModelPackage.TEST_GRID_COLUMN__CELLS,
						TestGridColumn.class, msgs);
			}
			return basicSetColumn((TestGridColumn) otherEnd, msgs);
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
		case TestModelPackage.TEST_GRID_CELL__COLUMN:
			return basicSetColumn(null, msgs);
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
		case TestModelPackage.TEST_GRID_CELL__DETAILS:
			return getDetails();
		case TestModelPackage.TEST_GRID_CELL__PRICE:
			return getPrice();
		case TestModelPackage.TEST_GRID_CELL__COLUMN:
			return getColumn();
		case TestModelPackage.TEST_GRID_CELL__ROW:
			return getRow();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case TestModelPackage.TEST_GRID_CELL__DETAILS:
			setDetails((String) newValue);
			return;
		case TestModelPackage.TEST_GRID_CELL__PRICE:
			setPrice((Float) newValue);
			return;
		case TestModelPackage.TEST_GRID_CELL__COLUMN:
			setColumn((TestGridColumn) newValue);
			return;
		case TestModelPackage.TEST_GRID_CELL__ROW:
			setRow((TestGridRow) newValue);
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
		case TestModelPackage.TEST_GRID_CELL__DETAILS:
			setDetails(DETAILS_EDEFAULT);
			return;
		case TestModelPackage.TEST_GRID_CELL__PRICE:
			setPrice(PRICE_EDEFAULT);
			return;
		case TestModelPackage.TEST_GRID_CELL__COLUMN:
			setColumn((TestGridColumn) null);
			return;
		case TestModelPackage.TEST_GRID_CELL__ROW:
			setRow((TestGridRow) null);
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
		case TestModelPackage.TEST_GRID_CELL__DETAILS:
			return DETAILS_EDEFAULT == null ? details != null : !DETAILS_EDEFAULT.equals(details);
		case TestModelPackage.TEST_GRID_CELL__PRICE:
			return price != PRICE_EDEFAULT;
		case TestModelPackage.TEST_GRID_CELL__COLUMN:
			return column != null;
		case TestModelPackage.TEST_GRID_CELL__ROW:
			return row != null;
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
		if (eIsProxy()) {
			return super.toString();
		}

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (details: ");
		result.append(details);
		result.append(", price: ");
		result.append(price);
		result.append(')');
		return result.toString();
	}

} // TestGridCellImpl
