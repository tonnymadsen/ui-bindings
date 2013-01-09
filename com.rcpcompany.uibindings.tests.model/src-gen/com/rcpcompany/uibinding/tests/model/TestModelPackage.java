/**
 */
package com.rcpcompany.uibinding.tests.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.rcpcompany.uibinding.tests.model.TestModelFactory
 * @generated
 */
public interface TestModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://rcp-company.com/schemas/uibindings/testModel"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tm"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	TestModelPackage eINSTANCE = com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl <em>Test Object</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getTestObject()
	 * @generated
	 */
	int TEST_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__NUMBER = 0;

	/**
	 * The feature id for the '<em><b>D</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__D = 1;

	/**
	 * The feature id for the '<em><b>F</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__F = 2;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__DATE = 3;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__TEXT = 4;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__PARENT = 5;

	/**
	 * The feature id for the '<em><b>B</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__B = 6;

	/**
	 * The feature id for the '<em><b>Ac</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__AC = 7;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__UNIT = 8;

	/**
	 * The feature id for the '<em><b>Time Unit</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__TIME_UNIT = 9;

	/**
	 * The feature id for the '<em><b>Byte</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__BYTE = 10;

	/**
	 * The feature id for the '<em><b>Short</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__SHORT = 11;

	/**
	 * The feature id for the '<em><b>Long</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__LONG = 12;

	/**
	 * The feature id for the '<em><b>Big Decimal</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__BIG_DECIMAL = 13;

	/**
	 * The feature id for the '<em><b>Big Integer</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT__BIG_INTEGER = 14;

	/**
	 * The number of structural features of the '<em>Test Object</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT_FEATURE_COUNT = 15;

	/**
	 * The number of operations of the '<em>Test Object</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibinding.tests.model.internal.SubTestObjectImpl <em>Sub Test Object</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.rcpcompany.uibinding.tests.model.internal.SubTestObjectImpl
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getSubTestObject()
	 * @generated
	 */
	int SUB_TEST_OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TEST_OBJECT__NUMBER = TEST_OBJECT__NUMBER;

	/**
	 * The feature id for the '<em><b>D</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TEST_OBJECT__D = TEST_OBJECT__D;

	/**
	 * The feature id for the '<em><b>F</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TEST_OBJECT__F = TEST_OBJECT__F;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TEST_OBJECT__DATE = TEST_OBJECT__DATE;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TEST_OBJECT__TEXT = TEST_OBJECT__TEXT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TEST_OBJECT__PARENT = TEST_OBJECT__PARENT;

	/**
	 * The feature id for the '<em><b>B</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TEST_OBJECT__B = TEST_OBJECT__B;

	/**
	 * The feature id for the '<em><b>Ac</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TEST_OBJECT__AC = TEST_OBJECT__AC;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TEST_OBJECT__UNIT = TEST_OBJECT__UNIT;

	/**
	 * The feature id for the '<em><b>Time Unit</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TEST_OBJECT__TIME_UNIT = TEST_OBJECT__TIME_UNIT;

	/**
	 * The feature id for the '<em><b>Byte</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TEST_OBJECT__BYTE = TEST_OBJECT__BYTE;

	/**
	 * The feature id for the '<em><b>Short</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TEST_OBJECT__SHORT = TEST_OBJECT__SHORT;

	/**
	 * The feature id for the '<em><b>Long</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TEST_OBJECT__LONG = TEST_OBJECT__LONG;

	/**
	 * The feature id for the '<em><b>Big Decimal</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TEST_OBJECT__BIG_DECIMAL = TEST_OBJECT__BIG_DECIMAL;

	/**
	 * The feature id for the '<em><b>Big Integer</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TEST_OBJECT__BIG_INTEGER = TEST_OBJECT__BIG_INTEGER;

	/**
	 * The number of structural features of the '<em>Sub Test Object</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUB_TEST_OBJECT_FEATURE_COUNT = TEST_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sub Test Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TEST_OBJECT_OPERATION_COUNT = TEST_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibinding.tests.model.internal.TestContainerImpl <em>Test Container</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestContainerImpl
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getTestContainer()
	 * @generated
	 */
	int TEST_CONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CONTAINER__CHILDREN = 0;

	/**
	 * The feature id for the '<em><b>Current</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CONTAINER__CURRENT = 1;

	/**
	 * The number of structural features of the '<em>Test Container</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Test Container</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CONTAINER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibinding.tests.model.internal.AmountAndCurrencyImpl <em>Amount And Currency</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.rcpcompany.uibinding.tests.model.internal.AmountAndCurrencyImpl
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getAmountAndCurrency()
	 * @generated
	 */
	int AMOUNT_AND_CURRENCY = 3;

	/**
	 * The feature id for the '<em><b>Amount</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMOUNT_AND_CURRENCY__AMOUNT = 0;

	/**
	 * The feature id for the '<em><b>Currency</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMOUNT_AND_CURRENCY__CURRENCY = 1;

	/**
	 * The number of structural features of the '<em>Amount And Currency</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AMOUNT_AND_CURRENCY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Amount And Currency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMOUNT_AND_CURRENCY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibinding.tests.model.internal.TestGridImpl <em>Test Grid</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestGridImpl
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getTestGrid()
	 * @generated
	 */
	int TEST_GRID = 4;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID__COLUMNS = 0;

	/**
	 * The feature id for the '<em><b>Rows</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID__ROWS = 1;

	/**
	 * The number of structural features of the '<em>Test Grid</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Test Grid</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibinding.tests.model.internal.TestGridColumnImpl <em>Test Grid Column</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestGridColumnImpl
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getTestGridColumn()
	 * @generated
	 */
	int TEST_GRID_COLUMN = 5;

	/**
	 * The feature id for the '<em><b>Grid</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID_COLUMN__GRID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID_COLUMN__NAME = 1;

	/**
	 * The feature id for the '<em><b>Cells</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID_COLUMN__CELLS = 2;

	/**
	 * The number of structural features of the '<em>Test Grid Column</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEST_GRID_COLUMN_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Test Grid Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID_COLUMN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibinding.tests.model.internal.TestGridRowImpl <em>Test Grid Row</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestGridRowImpl
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getTestGridRow()
	 * @generated
	 */
	int TEST_GRID_ROW = 6;

	/**
	 * The feature id for the '<em><b>Grid</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID_ROW__GRID = 0;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID_ROW__NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Cells</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID_ROW__CELLS = 2;

	/**
	 * The number of structural features of the '<em>Test Grid Row</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID_ROW_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Test Grid Row</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID_ROW_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibinding.tests.model.internal.TestGridCellImpl <em>Test Grid Cell</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestGridCellImpl
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getTestGridCell()
	 * @generated
	 */
	int TEST_GRID_CELL = 7;

	/**
	 * The feature id for the '<em><b>Details</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID_CELL__DETAILS = 0;

	/**
	 * The feature id for the '<em><b>Price</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID_CELL__PRICE = 1;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID_CELL__COLUMN = 2;

	/**
	 * The feature id for the '<em><b>Row</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID_CELL__ROW = 3;

	/**
	 * The number of structural features of the '<em>Test Grid Cell</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID_CELL_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Test Grid Cell</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GRID_CELL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibinding.tests.model.WeightUnit <em>Weight Unit</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.rcpcompany.uibinding.tests.model.WeightUnit
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getWeightUnit()
	 * @generated
	 */
	int WEIGHT_UNIT = 8;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibinding.tests.model.TimeUnit <em>Time Unit</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.rcpcompany.uibinding.tests.model.TimeUnit
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getTimeUnit()
	 * @generated
	 */
	int TIME_UNIT = 9;

	/**
	 * The meta object id for the '<em>EDate</em>' data type.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see java.util.Date
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getEDate()
	 * @generated
	 */
	int EDATE = 10;

	/**
	 * The meta object id for the '<em>EBig Decimal</em>' data type.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see java.math.BigDecimal
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getEBigDecimal()
	 * @generated
	 */
	int EBIG_DECIMAL = 11;

	/**
	 * The meta object id for the '<em>EBig Integer</em>' data type.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see java.math.BigInteger
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getEBigInteger()
	 * @generated
	 */
	int EBIG_INTEGER = 12;

	/**
	 * The meta object id for the '<em>Amount And Currency Struct</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibinding.tests.model.AmountAndCurrencyOld
	 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getAmountAndCurrencyStruct()
	 * @generated
	 */
	int AMOUNT_AND_CURRENCY_STRUCT = 13;

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibinding.tests.model.TestObject <em>Test Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Object</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestObject
	 * @generated
	 */
	EClass getTestObject();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibinding.tests.model.TestObject#getNumber <em>Number</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestObject#getNumber()
	 * @see #getTestObject()
	 * @generated
	 */
	EAttribute getTestObject_Number();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibinding.tests.model.TestObject#getD <em>D</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>D</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestObject#getD()
	 * @see #getTestObject()
	 * @generated
	 */
	EAttribute getTestObject_D();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibinding.tests.model.TestObject#getF <em>F</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>F</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestObject#getF()
	 * @see #getTestObject()
	 * @generated
	 */
	EAttribute getTestObject_F();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibinding.tests.model.TestObject#getDate <em>Date</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestObject#getDate()
	 * @see #getTestObject()
	 * @generated
	 */
	EAttribute getTestObject_Date();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibinding.tests.model.TestObject#getText <em>Text</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestObject#getText()
	 * @see #getTestObject()
	 * @generated
	 */
	EAttribute getTestObject_Text();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibinding.tests.model.TestObject#getParent <em>Parent</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestObject#getParent()
	 * @see #getTestObject()
	 * @generated
	 */
	EReference getTestObject_Parent();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibinding.tests.model.TestObject#isB <em>B</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>B</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestObject#isB()
	 * @see #getTestObject()
	 * @generated
	 */
	EAttribute getTestObject_B();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibinding.tests.model.TestObject#getAc <em>Ac</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Ac</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestObject#getAc()
	 * @see #getTestObject()
	 * @generated
	 */
	EAttribute getTestObject_Ac();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibinding.tests.model.TestObject#getUnit <em>Unit</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestObject#getUnit()
	 * @see #getTestObject()
	 * @generated
	 */
	EAttribute getTestObject_Unit();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibinding.tests.model.TestObject#getTimeUnit <em>Time Unit</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Time Unit</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestObject#getTimeUnit()
	 * @see #getTestObject()
	 * @generated
	 */
	EAttribute getTestObject_TimeUnit();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibinding.tests.model.TestObject#getByte <em>Byte</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Byte</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestObject#getByte()
	 * @see #getTestObject()
	 * @generated
	 */
	EAttribute getTestObject_Byte();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibinding.tests.model.TestObject#getShort <em>Short</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Short</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestObject#getShort()
	 * @see #getTestObject()
	 * @generated
	 */
	EAttribute getTestObject_Short();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibinding.tests.model.TestObject#getLong <em>Long</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Long</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestObject#getLong()
	 * @see #getTestObject()
	 * @generated
	 */
	EAttribute getTestObject_Long();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibinding.tests.model.TestObject#getBigDecimal <em>Big Decimal</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Big Decimal</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestObject#getBigDecimal()
	 * @see #getTestObject()
	 * @generated
	 */
	EAttribute getTestObject_BigDecimal();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibinding.tests.model.TestObject#getBigInteger <em>Big Integer</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Big Integer</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestObject#getBigInteger()
	 * @see #getTestObject()
	 * @generated
	 */
	EAttribute getTestObject_BigInteger();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibinding.tests.model.SubTestObject <em>Sub Test Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Test Object</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.SubTestObject
	 * @generated
	 */
	EClass getSubTestObject();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibinding.tests.model.TestContainer <em>Test Container</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Container</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestContainer
	 * @generated
	 */
	EClass getTestContainer();

	/**
	 * Returns the meta object for the reference list '{@link com.rcpcompany.uibinding.tests.model.TestContainer#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestContainer#getChildren()
	 * @see #getTestContainer()
	 * @generated
	 */
	EReference getTestContainer_Children();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibinding.tests.model.TestContainer#getCurrent <em>Current</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Current</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestContainer#getCurrent()
	 * @see #getTestContainer()
	 * @generated
	 */
	EReference getTestContainer_Current();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibinding.tests.model.AmountAndCurrency <em>Amount And Currency</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Amount And Currency</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.AmountAndCurrency
	 * @generated
	 */
	EClass getAmountAndCurrency();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibinding.tests.model.AmountAndCurrency#getAmount <em>Amount</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Amount</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.AmountAndCurrency#getAmount()
	 * @see #getAmountAndCurrency()
	 * @generated
	 */
	EAttribute getAmountAndCurrency_Amount();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibinding.tests.model.AmountAndCurrency#getCurrency <em>Currency</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Currency</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.AmountAndCurrency#getCurrency()
	 * @see #getAmountAndCurrency()
	 * @generated
	 */
	EAttribute getAmountAndCurrency_Currency();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibinding.tests.model.TestGrid <em>Test Grid</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Grid</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestGrid
	 * @generated
	 */
	EClass getTestGrid();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibinding.tests.model.TestGrid#getColumns <em>Columns</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Columns</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestGrid#getColumns()
	 * @see #getTestGrid()
	 * @generated
	 */
	EReference getTestGrid_Columns();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibinding.tests.model.TestGrid#getRows <em>Rows</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Rows</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestGrid#getRows()
	 * @see #getTestGrid()
	 * @generated
	 */
	EReference getTestGrid_Rows();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibinding.tests.model.TestGridColumn <em>Test Grid Column</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Test Grid Column</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestGridColumn
	 * @generated
	 */
	EClass getTestGridColumn();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibinding.tests.model.TestGridColumn#getGrid <em>Grid</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Grid</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestGridColumn#getGrid()
	 * @see #getTestGridColumn()
	 * @generated
	 */
	EReference getTestGridColumn_Grid();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibinding.tests.model.TestGridColumn#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestGridColumn#getName()
	 * @see #getTestGridColumn()
	 * @generated
	 */
	EAttribute getTestGridColumn_Name();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibinding.tests.model.TestGridColumn#getCells <em>Cells</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Cells</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestGridColumn#getCells()
	 * @see #getTestGridColumn()
	 * @generated
	 */
	EReference getTestGridColumn_Cells();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibinding.tests.model.TestGridRow <em>Test Grid Row</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Grid Row</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestGridRow
	 * @generated
	 */
	EClass getTestGridRow();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibinding.tests.model.TestGridRow#getGrid <em>Grid</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Grid</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestGridRow#getGrid()
	 * @see #getTestGridRow()
	 * @generated
	 */
	EReference getTestGridRow_Grid();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibinding.tests.model.TestGridRow#getNumber <em>Number</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestGridRow#getNumber()
	 * @see #getTestGridRow()
	 * @generated
	 */
	EAttribute getTestGridRow_Number();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibinding.tests.model.TestGridRow#getCells <em>Cells</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Cells</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestGridRow#getCells()
	 * @see #getTestGridRow()
	 * @generated
	 */
	EReference getTestGridRow_Cells();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibinding.tests.model.TestGridCell <em>Test Grid Cell</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Grid Cell</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestGridCell
	 * @generated
	 */
	EClass getTestGridCell();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibinding.tests.model.TestGridCell#getDetails <em>Details</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Details</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestGridCell#getDetails()
	 * @see #getTestGridCell()
	 * @generated
	 */
	EAttribute getTestGridCell_Details();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibinding.tests.model.TestGridCell#getPrice <em>Price</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Price</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestGridCell#getPrice()
	 * @see #getTestGridCell()
	 * @generated
	 */
	EAttribute getTestGridCell_Price();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibinding.tests.model.TestGridCell#getColumn <em>Column</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Column</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestGridCell#getColumn()
	 * @see #getTestGridCell()
	 * @generated
	 */
	EReference getTestGridCell_Column();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibinding.tests.model.TestGridCell#getRow <em>Row</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Row</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TestGridCell#getRow()
	 * @see #getTestGridCell()
	 * @generated
	 */
	EReference getTestGridCell_Row();

	/**
	 * Returns the meta object for enum '{@link com.rcpcompany.uibinding.tests.model.WeightUnit <em>Weight Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Weight Unit</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.WeightUnit
	 * @generated
	 */
	EEnum getWeightUnit();

	/**
	 * Returns the meta object for enum '{@link com.rcpcompany.uibinding.tests.model.TimeUnit <em>Time Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Time Unit</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.TimeUnit
	 * @generated
	 */
	EEnum getTimeUnit();

	/**
	 * Returns the meta object for data type '{@link java.util.Date <em>EDate</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>EDate</em>'.
	 * @see java.util.Date
	 * @generated
	 */
	EDataType getEDate();

	/**
	 * Returns the meta object for data type '{@link java.math.BigDecimal <em>EBig Decimal</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EBig Decimal</em>'.
	 * @see java.math.BigDecimal
	 * @generated
	 */
	EDataType getEBigDecimal();

	/**
	 * Returns the meta object for data type '{@link java.math.BigInteger <em>EBig Integer</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EBig Integer</em>'.
	 * @see java.math.BigInteger
	 * @generated
	 */
	EDataType getEBigInteger();

	/**
	 * Returns the meta object for data type '{@link com.rcpcompany.uibinding.tests.model.AmountAndCurrencyOld <em>Amount And Currency Struct</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Amount And Currency Struct</em>'.
	 * @see com.rcpcompany.uibinding.tests.model.AmountAndCurrencyOld
	 * @generated
	 */
	EDataType getAmountAndCurrencyStruct();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestModelFactory getTestModelFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl <em>Test Object</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getTestObject()
		 * @generated
		 */
		EClass TEST_OBJECT = eINSTANCE.getTestObject();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_OBJECT__NUMBER = eINSTANCE.getTestObject_Number();

		/**
		 * The meta object literal for the '<em><b>D</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_OBJECT__D = eINSTANCE.getTestObject_D();

		/**
		 * The meta object literal for the '<em><b>F</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_OBJECT__F = eINSTANCE.getTestObject_F();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_OBJECT__DATE = eINSTANCE.getTestObject_Date();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_OBJECT__TEXT = eINSTANCE.getTestObject_Text();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TEST_OBJECT__PARENT = eINSTANCE.getTestObject_Parent();

		/**
		 * The meta object literal for the '<em><b>B</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_OBJECT__B = eINSTANCE.getTestObject_B();

		/**
		 * The meta object literal for the '<em><b>Ac</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_OBJECT__AC = eINSTANCE.getTestObject_Ac();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_OBJECT__UNIT = eINSTANCE.getTestObject_Unit();

		/**
		 * The meta object literal for the '<em><b>Time Unit</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_OBJECT__TIME_UNIT = eINSTANCE.getTestObject_TimeUnit();

		/**
		 * The meta object literal for the '<em><b>Byte</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_OBJECT__BYTE = eINSTANCE.getTestObject_Byte();

		/**
		 * The meta object literal for the '<em><b>Short</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_OBJECT__SHORT = eINSTANCE.getTestObject_Short();

		/**
		 * The meta object literal for the '<em><b>Long</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_OBJECT__LONG = eINSTANCE.getTestObject_Long();

		/**
		 * The meta object literal for the '<em><b>Big Decimal</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_OBJECT__BIG_DECIMAL = eINSTANCE.getTestObject_BigDecimal();

		/**
		 * The meta object literal for the '<em><b>Big Integer</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_OBJECT__BIG_INTEGER = eINSTANCE.getTestObject_BigInteger();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibinding.tests.model.internal.SubTestObjectImpl <em>Sub Test Object</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.rcpcompany.uibinding.tests.model.internal.SubTestObjectImpl
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getSubTestObject()
		 * @generated
		 */
		EClass SUB_TEST_OBJECT = eINSTANCE.getSubTestObject();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibinding.tests.model.internal.TestContainerImpl <em>Test Container</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestContainerImpl
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getTestContainer()
		 * @generated
		 */
		EClass TEST_CONTAINER = eINSTANCE.getTestContainer();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TEST_CONTAINER__CHILDREN = eINSTANCE.getTestContainer_Children();

		/**
		 * The meta object literal for the '<em><b>Current</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TEST_CONTAINER__CURRENT = eINSTANCE.getTestContainer_Current();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibinding.tests.model.internal.AmountAndCurrencyImpl <em>Amount And Currency</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.rcpcompany.uibinding.tests.model.internal.AmountAndCurrencyImpl
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getAmountAndCurrency()
		 * @generated
		 */
		EClass AMOUNT_AND_CURRENCY = eINSTANCE.getAmountAndCurrency();

		/**
		 * The meta object literal for the '<em><b>Amount</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute AMOUNT_AND_CURRENCY__AMOUNT = eINSTANCE.getAmountAndCurrency_Amount();

		/**
		 * The meta object literal for the '<em><b>Currency</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute AMOUNT_AND_CURRENCY__CURRENCY = eINSTANCE.getAmountAndCurrency_Currency();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibinding.tests.model.internal.TestGridImpl <em>Test Grid</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestGridImpl
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getTestGrid()
		 * @generated
		 */
		EClass TEST_GRID = eINSTANCE.getTestGrid();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TEST_GRID__COLUMNS = eINSTANCE.getTestGrid_Columns();

		/**
		 * The meta object literal for the '<em><b>Rows</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TEST_GRID__ROWS = eINSTANCE.getTestGrid_Rows();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibinding.tests.model.internal.TestGridColumnImpl <em>Test Grid Column</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestGridColumnImpl
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getTestGridColumn()
		 * @generated
		 */
		EClass TEST_GRID_COLUMN = eINSTANCE.getTestGridColumn();

		/**
		 * The meta object literal for the '<em><b>Grid</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TEST_GRID_COLUMN__GRID = eINSTANCE.getTestGridColumn_Grid();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_GRID_COLUMN__NAME = eINSTANCE.getTestGridColumn_Name();

		/**
		 * The meta object literal for the '<em><b>Cells</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TEST_GRID_COLUMN__CELLS = eINSTANCE.getTestGridColumn_Cells();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibinding.tests.model.internal.TestGridRowImpl <em>Test Grid Row</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestGridRowImpl
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getTestGridRow()
		 * @generated
		 */
		EClass TEST_GRID_ROW = eINSTANCE.getTestGridRow();

		/**
		 * The meta object literal for the '<em><b>Grid</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TEST_GRID_ROW__GRID = eINSTANCE.getTestGridRow_Grid();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_GRID_ROW__NUMBER = eINSTANCE.getTestGridRow_Number();

		/**
		 * The meta object literal for the '<em><b>Cells</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TEST_GRID_ROW__CELLS = eINSTANCE.getTestGridRow_Cells();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibinding.tests.model.internal.TestGridCellImpl <em>Test Grid Cell</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestGridCellImpl
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getTestGridCell()
		 * @generated
		 */
		EClass TEST_GRID_CELL = eINSTANCE.getTestGridCell();

		/**
		 * The meta object literal for the '<em><b>Details</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_GRID_CELL__DETAILS = eINSTANCE.getTestGridCell_Details();

		/**
		 * The meta object literal for the '<em><b>Price</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_GRID_CELL__PRICE = eINSTANCE.getTestGridCell_Price();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TEST_GRID_CELL__COLUMN = eINSTANCE.getTestGridCell_Column();

		/**
		 * The meta object literal for the '<em><b>Row</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TEST_GRID_CELL__ROW = eINSTANCE.getTestGridCell_Row();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibinding.tests.model.WeightUnit <em>Weight Unit</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.rcpcompany.uibinding.tests.model.WeightUnit
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getWeightUnit()
		 * @generated
		 */
		EEnum WEIGHT_UNIT = eINSTANCE.getWeightUnit();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibinding.tests.model.TimeUnit <em>Time Unit</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.rcpcompany.uibinding.tests.model.TimeUnit
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getTimeUnit()
		 * @generated
		 */
		EEnum TIME_UNIT = eINSTANCE.getTimeUnit();

		/**
		 * The meta object literal for the '<em>EDate</em>' data type.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see java.util.Date
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getEDate()
		 * @generated
		 */
		EDataType EDATE = eINSTANCE.getEDate();

		/**
		 * The meta object literal for the '<em>EBig Decimal</em>' data type.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @see java.math.BigDecimal
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getEBigDecimal()
		 * @generated
		 */
		EDataType EBIG_DECIMAL = eINSTANCE.getEBigDecimal();

		/**
		 * The meta object literal for the '<em>EBig Integer</em>' data type.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @see java.math.BigInteger
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getEBigInteger()
		 * @generated
		 */
		EDataType EBIG_INTEGER = eINSTANCE.getEBigInteger();

		/**
		 * The meta object literal for the '<em>Amount And Currency Struct</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibinding.tests.model.AmountAndCurrencyOld
		 * @see com.rcpcompany.uibinding.tests.model.internal.TestModelPackageImpl#getAmountAndCurrencyStruct()
		 * @generated
		 */
		EDataType AMOUNT_AND_CURRENCY_STRUCT = eINSTANCE.getAmountAndCurrencyStruct();

	}

} // TestModelPackage
