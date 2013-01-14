/**
 */
package com.rcpcompany.uibinding.tests.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage
 * @generated
 */
public interface TestModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	TestModelFactory eINSTANCE = com.rcpcompany.uibinding.tests.model.internal.TestModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Test Object</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Test Object</em>'.
	 * @generated
	 */
	TestObject createTestObject();

	/**
	 * Returns a new object of class '<em>Sub Test Object</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Sub Test Object</em>'.
	 * @generated
	 */
	SubTestObject createSubTestObject();

	/**
	 * Returns a new object of class '<em>Test Container</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Test Container</em>'.
	 * @generated
	 */
	TestContainer createTestContainer();

	/**
	 * Returns a new object of class '<em>Amount And Currency</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Amount And Currency</em>'.
	 * @generated
	 */
	AmountAndCurrency createAmountAndCurrency();

	/**
	 * Returns a new object of class '<em>Test Grid</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Test Grid</em>'.
	 * @generated
	 */
	TestGrid createTestGrid();

	/**
	 * Returns a new object of class '<em>Test Grid Column</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Test Grid Column</em>'.
	 * @generated
	 */
	TestGridColumn createTestGridColumn();

	/**
	 * Returns a new object of class '<em>Test Grid Row</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Test Grid Row</em>'.
	 * @generated
	 */
	TestGridRow createTestGridRow();

	/**
	 * Returns a new object of class '<em>Test Grid Cell</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Test Grid Cell</em>'.
	 * @generated
	 */
	TestGridCell createTestGridCell();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	TestModelPackage getTestModelPackage();

	TestContainer getTestContainer();

} // TestModelFactory
