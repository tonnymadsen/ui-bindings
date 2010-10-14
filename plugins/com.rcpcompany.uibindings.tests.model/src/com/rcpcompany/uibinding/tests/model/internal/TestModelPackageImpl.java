/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibinding.tests.model.internal;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.rcpcompany.uibinding.tests.model.AmountAndCurrency;
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

		testGridCellEClass = createEClass(TEST_GRID_CELL);
		createEAttribute(testGridCellEClass, TEST_GRID_CELL__DETAILS);
		createEAttribute(testGridCellEClass, TEST_GRID_CELL__PRICE);
		createEReference(testGridCellEClass, TEST_GRID_CELL__COLUMN);
		createEReference(testGridCellEClass, TEST_GRID_CELL__ROW);

		// Create enums
		weightUnitEEnum = createEEnum(WEIGHT_UNIT);
		timeUnitEEnum = createEEnum(TIME_UNIT);

		// Create data types
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		subTestObjectEClass.getESuperTypes().add(this.getTestObject());

		// Initialize classes and features; add operations and parameters
		initEClass(testObjectEClass, TestObject.class, "TestObject", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestObject_Number(), ecorePackage.getEInt(), "number", "0", 0, 1, TestObject.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject_D(), ecorePackage.getEDouble(), "d", null, 0, 1, TestObject.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject_F(), ecorePackage.getEFloat(), "f", null, 0, 1, TestObject.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject_Date(), ecorePackage.getEDate(), "date", null, 0, 1, TestObject.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject_Text(), ecorePackage.getEString(), "text", null, 0, 1, TestObject.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestObject_Parent(), this.getTestContainer(), this.getTestContainer_Children(), "parent",
				null, 0, 1, TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject_B(), ecorePackage.getEBoolean(), "b", null, 0, 1, TestObject.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject_Ac(), this.getAmountAndCurrencyStruct(), "ac", null, 0, 1, TestObject.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject_Unit(), this.getWeightUnit(), "unit", null, 1, 1, TestObject.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject_TimeUnit(), this.getTimeUnit(), "timeUnit", null, 0, 1, TestObject.class,
				IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject_Byte(), ecorePackage.getEByte(), "byte", null, 0, 1, TestObject.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject_Short(), ecorePackage.getEShort(), "short", null, 0, 1, TestObject.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject_Long(), ecorePackage.getELong(), "long", null, 0, 1, TestObject.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject_BigDecimal(), ecorePackage.getEBigDecimal(), "bigDecimal", null, 0, 1,
				TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestObject_BigInteger(), ecorePackage.getEBigInteger(), "bigInteger", null, 0, 1,
				TestObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(subTestObjectEClass, SubTestObject.class, "SubTestObject", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(testContainerEClass, TestContainer.class, "TestContainer", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestContainer_Children(), this.getTestObject(), this.getTestObject_Parent(), "children",
				null, 0, -1, TestContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestContainer_Current(), this.getTestObject(), null, "current", null, 0, 1,
				TestContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(amountAndCurrencyEClass, AmountAndCurrency.class, "AmountAndCurrency", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAmountAndCurrency_Amount(), ecorePackage.getEFloat(), "amount", null, 0, 1,
				AmountAndCurrency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getAmountAndCurrency_Currency(), ecorePackage.getEString(), "currency", null, 0, 1,
				AmountAndCurrency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(testGridEClass, TestGrid.class, "TestGrid", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestGrid_Columns(), this.getTestGridColumn(), this.getTestGridColumn_Grid(), "columns", null,
				0, -1, TestGrid.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestGrid_Rows(), this.getTestGridRow(), this.getTestGridRow_Grid(), "rows", null, 0, -1,
				TestGrid.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testGridColumnEClass, TestGridColumn.class, "TestGridColumn", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestGridColumn_Grid(), this.getTestGrid(), this.getTestGrid_Columns(), "grid", null, 0, 1,
				TestGridColumn.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestGridColumn_Name(), ecorePackage.getEString(), "name", null, 0, 1, TestGridColumn.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestGridColumn_Cells(), this.getTestGridCell(), this.getTestGridCell_Column(), "cells", null,
				0, -1, TestGridColumn.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testGridRowEClass, TestGridRow.class, "TestGridRow", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestGridRow_Grid(), this.getTestGrid(), this.getTestGrid_Rows(), "grid", null, 0, 1,
				TestGridRow.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestGridRow_Number(), ecorePackage.getEInt(), "number", null, 0, 1, TestGridRow.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testGridCellEClass, TestGridCell.class, "TestGridCell", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestGridCell_Details(), ecorePackage.getEString(), "details", null, 0, 1, TestGridCell.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestGridCell_Price(), ecorePackage.getEFloat(), "price", null, 0, 1, TestGridCell.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestGridCell_Column(), this.getTestGridColumn(), this.getTestGridColumn_Cells(), "column",
				null, 0, 1, TestGridCell.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestGridCell_Row(), this.getTestGridRow(), null, "row", null, 0, 1, TestGridCell.class,
				IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(weightUnitEEnum, WeightUnit.class, "WeightUnit");
		addEEnumLiteral(weightUnitEEnum, WeightUnit.G);
		addEEnumLiteral(weightUnitEEnum, WeightUnit.KG);
		addEEnumLiteral(weightUnitEEnum, WeightUnit.TONNE);

		initEEnum(timeUnitEEnum, TimeUnit.class, "TimeUnit");
		addEEnumLiteral(timeUnitEEnum, TimeUnit.SEC);
		addEEnumLiteral(timeUnitEEnum, TimeUnit.MIN);

		// Initialize data types
		initEDataType(amountAndCurrencyStructEDataType, AmountAndCurrency.class, "AmountAndCurrencyStruct",
				IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://rcp-company.com/schemas/uibindings
		createUibindingsAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://rcp-company.com/schemas/uibindings</b>. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createUibindingsAnnotations() {
		final String source = "http://rcp-company.com/schemas/uibindings";
		addAnnotation(testObjectEClass, source, new String[] { "foobar-Sequence-all", "TestObject (annotation)",
				"foobar-Sequence-parent", "TestObject (annotation)", "foobar-Sequence-targetType",
				"TestObject (annotation)", "foobar-Sequence-containingClass", "TestObject (annotation)",
				"foobar-Sequence-default", "TestObject (annotation)" });
		addAnnotation(getTestObject_Text(), source, new String[] { "foobar-Sequence-all",
				"TestObject.text (annotation)", "foobar-Sequence-parent", "TestObject.text (annotation)",
				"foobar-Sequence-targetType", "TestObject.text (annotation)", "foobar-Sequence-containingClass",
				"TestObject.text (annotation)", "foobar-Sequence-default", "TestObject.text (annotation)" });
		addAnnotation(getTestObject_Short(), source, new String[] { "foobar", "b" });
		addAnnotation(subTestObjectEClass, source, new String[] { "foobar-Sequence-all", "SubTestObject (annotation)",
				"foobar-Sequence-parent", "SubTestObject (annotation)", "foobar-Sequence-targetType",
				"SubTestObject (annotation)", "foobar-Sequence-containingClass", "SubTestObject (annotation)",
				"foobar-Sequence-default", "SubTestObject (annotation)", "text.foobar-Sequence-all",
				"SubTestObject.text (annotation)", "text.foobar-Sequence-parent", "SubTestObject.text (annotation)",
				"text.foobar-Sequence-targetType", "SubTestObject.text (annotation)",
				"text.foobar-Sequence-containingClass", "SubTestObject.text (annotation)",
				"text.foobar-Sequence-default", "SubTestObject.text (annotation)" });
		addAnnotation(testContainerEClass, source, new String[] { "foobar-Sequence-all", "TestContainer (annotation)",
				"foobar-Sequence-parent", "TestContainer (annotation)", "foobar-Sequence-targetType",
				"TestContainer (annotation)", "foobar-Sequence-containingClass", "TestContainer (annotation)",
				"foobar-Sequence-default", "TestContainer (annotation)" });
		addAnnotation(getTestContainer_Current(), source, new String[] { "foobar-Sequence-all",
				"TestContainer.current (annotation)", "foobar-Sequence-parent", "TestContainer.current (annotation)",
				"foobar-Sequence-targetType", "TestContainer.current (annotation)", "foobar-Sequence-containingClass",
				"TestContainer.current (annotation)", "foobar-Sequence-default", "TestContainer.current (annotation)" });
		addAnnotation(amountAndCurrencyStructEDataType, source, new String[] { "foobar", "c" });
	}

} // TestModelPackageImpl
