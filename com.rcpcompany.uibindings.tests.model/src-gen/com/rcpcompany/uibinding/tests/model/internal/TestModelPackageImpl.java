/**
 */
package com.rcpcompany.uibinding.tests.model.internal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

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
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class TestModelPackageImpl extends EPackageImpl implements TestModelPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass testObjectEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass subTestObjectEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass testContainerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass amountAndCurrencyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass testGridEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass testGridColumnEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass testGridRowEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass testGridCellEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum weightUnitEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum timeUnitEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType eDateEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType eBigDecimalEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType eBigIntegerEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType amountAndCurrencyStructEDataType = null;

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
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TestModelPackageImpl() {
		super(eNS_URI, TestModelFactory.eINSTANCE);
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
	 * This method is used to initialize {@link TestModelPackage#eINSTANCE} when that field is
	 * accessed. Clients should not invoke it directly. Instead, they should simply access that
	 * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TestModelPackage init() {
		if (isInited) return (TestModelPackage) EPackage.Registry.INSTANCE.getEPackage(TestModelPackage.eNS_URI);

		// Obtain or create and register package
		final TestModelPackageImpl theTestModelPackage = (TestModelPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof TestModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
				: new TestModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTestModelPackage.createPackageContents();

		// Initialize created meta-data
		theTestModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTestModelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TestModelPackage.eNS_URI, theTestModelPackage);
		return theTestModelPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getTestObject() {
		return testObjectEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTestObject_Number() {
		return (EAttribute) testObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTestObject_D() {
		return (EAttribute) testObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTestObject_F() {
		return (EAttribute) testObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTestObject_Date() {
		return (EAttribute) testObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTestObject_Text() {
		return (EAttribute) testObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getTestObject_Parent() {
		return (EReference) testObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTestObject_B() {
		return (EAttribute) testObjectEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTestObject_Ac() {
		return (EAttribute) testObjectEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTestObject_Unit() {
		return (EAttribute) testObjectEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTestObject_TimeUnit() {
		return (EAttribute) testObjectEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTestObject_Byte() {
		return (EAttribute) testObjectEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTestObject_Short() {
		return (EAttribute) testObjectEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTestObject_Long() {
		return (EAttribute) testObjectEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTestObject_BigDecimal() {
		return (EAttribute) testObjectEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTestObject_BigInteger() {
		return (EAttribute) testObjectEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getSubTestObject() {
		return subTestObjectEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getTestContainer() {
		return testContainerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getTestContainer_Children() {
		return (EReference) testContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getTestContainer_Current() {
		return (EReference) testContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getAmountAndCurrency() {
		return amountAndCurrencyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getAmountAndCurrency_Amount() {
		return (EAttribute) amountAndCurrencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getAmountAndCurrency_Currency() {
		return (EAttribute) amountAndCurrencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getTestGrid() {
		return testGridEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getTestGrid_Columns() {
		return (EReference) testGridEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getTestGrid_Rows() {
		return (EReference) testGridEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getTestGridColumn() {
		return testGridColumnEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getTestGridColumn_Grid() {
		return (EReference) testGridColumnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTestGridColumn_Name() {
		return (EAttribute) testGridColumnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getTestGridColumn_Cells() {
		return (EReference) testGridColumnEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getTestGridRow() {
		return testGridRowEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getTestGridRow_Grid() {
		return (EReference) testGridRowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTestGridRow_Number() {
		return (EAttribute) testGridRowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getTestGridRow_Cells() {
		return (EReference) testGridRowEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getTestGridCell() {
		return testGridCellEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTestGridCell_Details() {
		return (EAttribute) testGridCellEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTestGridCell_Price() {
		return (EAttribute) testGridCellEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getTestGridCell_Column() {
		return (EReference) testGridCellEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getTestGridCell_Row() {
		return (EReference) testGridCellEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EEnum getWeightUnit() {
		return weightUnitEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EEnum getTimeUnit() {
		return timeUnitEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getEDate() {
		return eDateEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getEBigDecimal() {
		return eBigDecimalEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getEBigInteger() {
		return eBigIntegerEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getAmountAndCurrencyStruct() {
		return amountAndCurrencyStructEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public TestModelFactory getTestModelFactory() {
		return (TestModelFactory) getEFactoryInstance();
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
		testObjectEClass = createEClass(TEST_OBJECT);
		createEAttribute(testObjectEClass, TEST_OBJECT__NUMBER);
		createEAttribute(testObjectEClass, TEST_OBJECT__D);
		createEAttribute(testObjectEClass, TEST_OBJECT__F);
		createEAttribute(testObjectEClass, TEST_OBJECT__DATE);
		createEAttribute(testObjectEClass, TEST_OBJECT__TEXT);
		createEReference(testObjectEClass, TEST_OBJECT__PARENT);
		createEAttribute(testObjectEClass, TEST_OBJECT__B);
		createEAttribute(testObjectEClass, TEST_OBJECT__AC);
		createEAttribute(testObjectEClass, TEST_OBJECT__UNIT);
		createEAttribute(testObjectEClass, TEST_OBJECT__TIME_UNIT);
		createEAttribute(testObjectEClass, TEST_OBJECT__BYTE);
		createEAttribute(testObjectEClass, TEST_OBJECT__SHORT);
		createEAttribute(testObjectEClass, TEST_OBJECT__LONG);
		createEAttribute(testObjectEClass, TEST_OBJECT__BIG_DECIMAL);
		createEAttribute(testObjectEClass, TEST_OBJECT__BIG_INTEGER);

		subTestObjectEClass = createEClass(SUB_TEST_OBJECT);

		testContainerEClass = createEClass(TEST_CONTAINER);
		createEReference(testContainerEClass, TEST_CONTAINER__CHILDREN);
		createEReference(testContainerEClass, TEST_CONTAINER__CURRENT);

		amountAndCurrencyEClass = createEClass(AMOUNT_AND_CURRENCY);
		createEAttribute(amountAndCurrencyEClass, AMOUNT_AND_CURRENCY__AMOUNT);
		createEAttribute(amountAndCurrencyEClass, AMOUNT_AND_CURRENCY__CURRENCY);

		testGridEClass = createEClass(TEST_GRID);
		createEReference(testGridEClass, TEST_GRID__COLUMNS);
		createEReference(testGridEClass, TEST_GRID__ROWS);

		testGridColumnEClass = createEClass(TEST_GRID_COLUMN);
		createEReference(testGridColumnEClass, TEST_GRID_COLUMN__GRID);
		createEAttribute(testGridColumnEClass, TEST_GRID_COLUMN__NAME);
		createEReference(testGridColumnEClass, TEST_GRID_COLUMN__CELLS);

		testGridRowEClass = createEClass(TEST_GRID_ROW);
		createEReference(testGridRowEClass, TEST_GRID_ROW__GRID);
		createEAttribute(testGridRowEClass, TEST_GRID_ROW__NUMBER);
		createEReference(testGridRowEClass, TEST_GRID_ROW__CELLS);

		testGridCellEClass = createEClass(TEST_GRID_CELL);
		createEAttribute(testGridCellEClass, TEST_GRID_CELL__DETAILS);
		createEAttribute(testGridCellEClass, TEST_GRID_CELL__PRICE);
		createEReference(testGridCellEClass, TEST_GRID_CELL__COLUMN);
		createEReference(testGridCellEClass, TEST_GRID_CELL__ROW);

		// Create enums
		weightUnitEEnum = createEEnum(WEIGHT_UNIT);
		timeUnitEEnum = createEEnum(TIME_UNIT);

		// Create data types
		eDateEDataType = createEDataType(EDATE);
		eBigDecimalEDataType = createEDataType(EBIG_DECIMAL);
		eBigIntegerEDataType = createEDataType(EBIG_INTEGER);
		amountAndCurrencyStructEDataType = createEDataType(AMOUNT_AND_CURRENCY_STRUCT);
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
		final EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		subTestObjectEClass.getESuperTypes().add(this.getTestObject());

		// Initialize classes, features, and operations; add parameters
		initEClass(testObjectEClass, TestObject.class,
				"TestObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getTestObject_Number(),
				theEcorePackage.getEInt(),
				"number", "0", 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getTestObject_D(),
				theEcorePackage.getEDouble(),
				"d", null, 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTestObject_F(),
				theEcorePackage.getEFloat(),
				"f", null, 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTestObject_Date(),
				this.getEDate(),
				"date", null, 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTestObject_Text(),
				theEcorePackage.getEString(),
				"text", null, 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getTestObject_Parent(),
				this.getTestContainer(),
				null,
				"parent", null, 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTestObject_B(),
				theEcorePackage.getEBoolean(),
				"b", null, 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTestObject_Ac(),
				this.getAmountAndCurrencyStruct(),
				"ac", null, 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTestObject_Unit(),
				this.getWeightUnit(),
				"unit", null, 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTestObject_TimeUnit(),
				this.getTimeUnit(),
				"timeUnit", null, 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTestObject_Byte(),
				theEcorePackage.getEByte(),
				"byte", null, 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTestObject_Short(),
				theEcorePackage.getEShort(),
				"short", null, 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTestObject_Long(),
				theEcorePackage.getELong(),
				"long", null, 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTestObject_BigDecimal(),
				this.getEBigDecimal(),
				"bigDecimal", null, 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTestObject_BigInteger(),
				this.getEBigInteger(),
				"bigInteger", null, 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(subTestObjectEClass, SubTestObject.class,
				"SubTestObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(testContainerEClass, TestContainer.class,
				"TestContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getTestContainer_Children(),
				this.getTestObject(),
				null,
				"children", null, 0, -1, TestContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getTestContainer_Current(),
				this.getTestObject(),
				null,
				"current", null, 0, 1, TestContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(amountAndCurrencyEClass, AmountAndCurrency.class,
				"AmountAndCurrency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getAmountAndCurrency_Amount(),
				theEcorePackage.getEFloat(),
				"amount", null, 0, 1, AmountAndCurrency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAmountAndCurrency_Currency(),
				theEcorePackage.getEString(),
				"currency", null, 0, 1, AmountAndCurrency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(testGridEClass, TestGrid.class, "TestGrid", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getTestGrid_Columns(),
				this.getTestGridColumn(),
				this.getTestGridColumn_Grid(),
				"columns", null, 0, -1, TestGrid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getTestGrid_Rows(),
				this.getTestGridRow(),
				this.getTestGridRow_Grid(),
				"rows", null, 0, -1, TestGrid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(testGridColumnEClass, TestGridColumn.class,
				"TestGridColumn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getTestGridColumn_Grid(),
				this.getTestGrid(),
				this.getTestGrid_Columns(),
				"grid", null, 0, 1, TestGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTestGridColumn_Name(),
				theEcorePackage.getEString(),
				"name", null, 0, 1, TestGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getTestGridColumn_Cells(),
				this.getTestGridCell(),
				this.getTestGridCell_Column(),
				"cells", null, 0, -1, TestGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(testGridRowEClass, TestGridRow.class,
				"TestGridRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getTestGridRow_Grid(),
				this.getTestGrid(),
				this.getTestGrid_Rows(),
				"grid", null, 0, 1, TestGridRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTestGridRow_Number(),
				theEcorePackage.getEInt(),
				"number", null, 0, 1, TestGridRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getTestGridRow_Cells(),
				this.getTestGridCell(),
				this.getTestGridCell_Row(),
				"cells", null, 0, -1, TestGridRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(testGridCellEClass, TestGridCell.class,
				"TestGridCell", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getTestGridCell_Details(),
				theEcorePackage.getEString(),
				"details", null, 0, 1, TestGridCell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTestGridCell_Price(),
				theEcorePackage.getEFloat(),
				"price", null, 0, 1, TestGridCell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getTestGridCell_Column(),
				this.getTestGridColumn(),
				this.getTestGridColumn_Cells(),
				"column", null, 0, 1, TestGridCell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getTestGridCell_Row(),
				this.getTestGridRow(),
				this.getTestGridRow_Cells(),
				"row", null, 0, 1, TestGridCell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(weightUnitEEnum, WeightUnit.class, "WeightUnit"); //$NON-NLS-1$
		addEEnumLiteral(weightUnitEEnum, WeightUnit.G);
		addEEnumLiteral(weightUnitEEnum, WeightUnit.KG);
		addEEnumLiteral(weightUnitEEnum, WeightUnit.TONNE);

		initEEnum(timeUnitEEnum, TimeUnit.class, "TimeUnit"); //$NON-NLS-1$
		addEEnumLiteral(timeUnitEEnum, TimeUnit.SEC);
		addEEnumLiteral(timeUnitEEnum, TimeUnit.MIN);

		// Initialize data types
		initEDataType(eDateEDataType, Date.class, "EDate", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(eBigDecimalEDataType, BigDecimal.class,
				"EBigDecimal", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(eBigIntegerEDataType, BigInteger.class,
				"EBigInteger", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(amountAndCurrencyStructEDataType, AmountAndCurrencyOld.class,
				"AmountAndCurrencyStruct", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
		// http://www.eclipse.org/emf/2011/Xcore
		createXcoreAnnotations();
		// http://rcp-company.com/schemas/uibindings
		createUibindingsAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		final String source = "http://www.eclipse.org/emf/2002/GenModel"; //$NON-NLS-1$		
		addAnnotation(this, source, new String[] { "nonNLSMarkers", "true", //$NON-NLS-1$ //$NON-NLS-2$
				"classPackageSuffix", "internal", //$NON-NLS-1$ //$NON-NLS-2$
				"adapterFactory", "false", //$NON-NLS-1$ //$NON-NLS-2$
				"classNamePattern", "{0}Impl", //$NON-NLS-1$ //$NON-NLS-2$
				"interfaceNamePattern", "{0}", //$NON-NLS-1$ //$NON-NLS-2$
				"suppressEMFModelTags", "true", //$NON-NLS-1$ //$NON-NLS-2$
				"fileExtensions", "aserver", //$NON-NLS-1$ //$NON-NLS-2$
				"suppressGenModelAnnotations", "false", //$NON-NLS-1$ //$NON-NLS-2$
				"language", "", //$NON-NLS-1$ //$NON-NLS-2$
				"prefix", "TestModel", //$NON-NLS-1$ //$NON-NLS-2$
				"modelName", "TestModel", //$NON-NLS-1$ //$NON-NLS-2$
				"codeFormatting", "true", //$NON-NLS-1$ //$NON-NLS-2$
				"redirection", "", //$NON-NLS-1$ //$NON-NLS-2$
				"updateClasspath", "false", //$NON-NLS-1$ //$NON-NLS-2$
				"containmentProxies", "false", //$NON-NLS-1$ //$NON-NLS-2$
				"basePackage", "com.rcpcompany.uibinding.tests" //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2011/Xcore</b>. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createXcoreAnnotations() {
		final String source = "http://www.eclipse.org/emf/2011/Xcore"; //$NON-NLS-1$			
		addAnnotation(this, source, new String[] { "uibindings", "http://rcp-company.com/schemas/uibindings" //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

	/**
	 * Initializes the annotations for <b>http://rcp-company.com/schemas/uibindings</b>. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createUibindingsAnnotations() {
		final String source = "http://rcp-company.com/schemas/uibindings"; //$NON-NLS-1$				
		addAnnotation(testObjectEClass, source, new String[] { "foobar_Sequence_all", "TestObject (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_parent", "TestObject (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_targetType", "TestObject (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_containingClass", "TestObject (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_default", "TestObject (annotation)" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getTestObject_Text(), source, new String[] {
				"foobar_Sequence_all", "TestObject.text (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_parent", "TestObject.text (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_targetType", "TestObject.text (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_containingClass", "TestObject.text (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_default", "TestObject.text (annotation)" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getTestObject_Short(), source, new String[] { "foobar", "b" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(subTestObjectEClass, source, new String[] { "foobar_Sequence_all", "SubTestObject (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_parent", "SubTestObject (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_targetType", "SubTestObject (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_containingClass", "SubTestObject (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_default", "SubTestObject (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"text.foobar_Sequence_all", "SubTestObject.text (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"text.foobar_Sequence_parent", "SubTestObject.text (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"text.foobar_Sequence_targetType", "SubTestObject.text (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"text.foobar_Sequence_containingClass", "SubTestObject.text (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"text.foobar_Sequence_default", "SubTestObject.text (annotation)" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(testContainerEClass, source, new String[] { "foobar_Sequence_all", "TestContainer (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_parent", "TestContainer (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_targetType", "TestContainer (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_containingClass", "TestContainer (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_default", "TestContainer (annotation)" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getTestContainer_Current(), source, new String[] {
				"foobar_Sequence_all", "TestContainer.current (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_parent", "TestContainer.current (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_targetType", "TestContainer.current (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_containingClass", "TestContainer.current (annotation)", //$NON-NLS-1$ //$NON-NLS-2$
				"foobar_Sequence_default", "TestContainer.current (annotation)" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(amountAndCurrencyStructEDataType, source, new String[] { "foobar", "c" //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

} // TestModelPackageImpl
