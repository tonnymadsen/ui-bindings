/**
 */
package com.rcpcompany.uibinding.tests.model.internal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.rcpcompany.uibinding.tests.model.AmountAndCurrency;
import com.rcpcompany.uibinding.tests.model.AmountAndCurrencyOld;
import com.rcpcompany.uibinding.tests.model.SubTestObject;
import com.rcpcompany.uibinding.tests.model.TestContainer;
import com.rcpcompany.uibinding.tests.model.TestGrid;
import com.rcpcompany.uibinding.tests.model.TestGridCell;
import com.rcpcompany.uibinding.tests.model.TestGridColumn;
import com.rcpcompany.uibinding.tests.model.TestGridRow;
import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibinding.tests.model.TimeUnit;
import com.rcpcompany.uibinding.tests.model.WeightUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class TestModelFactoryImpl extends EFactoryImpl implements TestModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static TestModelFactory init() {
		try {
			TestModelFactory theTestModelFactory = (TestModelFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://rcp-company.com/schemas/uibindings/testModel"); //$NON-NLS-1$ 
			if (theTestModelFactory != null) { return theTestModelFactory; }
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TestModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TestModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case TestModelPackage.TEST_OBJECT:
			return createTestObject();
		case TestModelPackage.SUB_TEST_OBJECT:
			return createSubTestObject();
		case TestModelPackage.TEST_CONTAINER:
			return createTestContainer();
		case TestModelPackage.AMOUNT_AND_CURRENCY:
			return createAmountAndCurrency();
		case TestModelPackage.TEST_GRID:
			return createTestGrid();
		case TestModelPackage.TEST_GRID_COLUMN:
			return createTestGridColumn();
		case TestModelPackage.TEST_GRID_ROW:
			return createTestGridRow();
		case TestModelPackage.TEST_GRID_CELL:
			return createTestGridCell();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case TestModelPackage.WEIGHT_UNIT:
			return createWeightUnitFromString(eDataType, initialValue);
		case TestModelPackage.TIME_UNIT:
			return createTimeUnitFromString(eDataType, initialValue);
		case TestModelPackage.EDATE:
			return createEDateFromString(eDataType, initialValue);
		case TestModelPackage.EBIG_DECIMAL:
			return createEBigDecimalFromString(eDataType, initialValue);
		case TestModelPackage.EBIG_INTEGER:
			return createEBigIntegerFromString(eDataType, initialValue);
		case TestModelPackage.AMOUNT_AND_CURRENCY_STRUCT:
			return createAmountAndCurrencyStructFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case TestModelPackage.WEIGHT_UNIT:
			return convertWeightUnitToString(eDataType, instanceValue);
		case TestModelPackage.TIME_UNIT:
			return convertTimeUnitToString(eDataType, instanceValue);
		case TestModelPackage.EDATE:
			return convertEDateToString(eDataType, instanceValue);
		case TestModelPackage.EBIG_DECIMAL:
			return convertEBigDecimalToString(eDataType, instanceValue);
		case TestModelPackage.EBIG_INTEGER:
			return convertEBigIntegerToString(eDataType, instanceValue);
		case TestModelPackage.AMOUNT_AND_CURRENCY_STRUCT:
			return convertAmountAndCurrencyStructToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestObject createTestObject() {
		TestObjectImpl testObject = new TestObjectImpl();
		return testObject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubTestObject createSubTestObject() {
		SubTestObjectImpl subTestObject = new SubTestObjectImpl();
		return subTestObject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestContainer createTestContainer() {
		TestContainerImpl testContainer = new TestContainerImpl();
		return testContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AmountAndCurrency createAmountAndCurrency() {
		AmountAndCurrencyImpl amountAndCurrency = new AmountAndCurrencyImpl();
		return amountAndCurrency;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestGrid createTestGrid() {
		TestGridImpl testGrid = new TestGridImpl();
		return testGrid;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestGridColumn createTestGridColumn() {
		TestGridColumnImpl testGridColumn = new TestGridColumnImpl();
		return testGridColumn;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestGridRow createTestGridRow() {
		TestGridRowImpl testGridRow = new TestGridRowImpl();
		return testGridRow;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestGridCell createTestGridCell() {
		TestGridCellImpl testGridCell = new TestGridCellImpl();
		return testGridCell;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WeightUnit createWeightUnitFromString(EDataType eDataType, String initialValue) {
		WeightUnit result = WeightUnit.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWeightUnitToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TimeUnit createTimeUnitFromString(EDataType eDataType, String initialValue) {
		TimeUnit result = TimeUnit.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTimeUnitToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Date createEDateFromString(EDataType eDataType, String initialValue) {
		return (Date) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEDateToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal createEBigDecimalFromString(EDataType eDataType, String initialValue) {
		return (BigDecimal) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEBigDecimalToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger createEBigIntegerFromString(EDataType eDataType, String initialValue) {
		return (BigInteger) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEBigIntegerToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AmountAndCurrencyOld createAmountAndCurrencyStructFromString(EDataType eDataType, String initialValue) {
		return (AmountAndCurrencyOld) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAmountAndCurrencyStructToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestModelPackage getTestModelPackage() {
		return (TestModelPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TestModelPackage getPackage() {
		return TestModelPackage.eINSTANCE;
	}

	private TestContainer theContainer = null;

	@Override
	public TestContainer getTestContainer() {
		if (theContainer == null) {
			theContainer = createTestContainer();
			addChild(true, 0, "", WeightUnit.G);
			addChild(false, 1, "a", WeightUnit.G);
			addChild(true, 0, "b", WeightUnit.G);
			addChild(false, 3, "c", WeightUnit.TONNE);
			addChild(true, 0, "d", WeightUnit.KG);
			addChild(false, 5, "e", WeightUnit.G);
		}
		return theContainer;
	}

	private void addChild(boolean b, int i, String t, WeightUnit w) {
		final TestObject c = createTestObject();
		c.setB(b);
		// c.setDate(date);
		c.setNumber(i);
		c.setText(t);
		c.setUnit(w);
		getTestContainer().getChildren().add(c);
	}

} // TestModelFactoryImpl
