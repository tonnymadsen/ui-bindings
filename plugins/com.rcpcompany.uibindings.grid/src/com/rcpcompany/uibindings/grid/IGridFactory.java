/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.grid;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see com.rcpcompany.uibindings.grid.IGridPackage
 * @generated
 */
public interface IGridFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	IGridFactory eINSTANCE = com.rcpcompany.uibindings.grid.internal.GridFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Binding</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Binding</em>'.
	 * @generated
	 */
	IGridBinding createGridBinding();

	/**
	 * Returns a new object of class '<em>Binding Cell Information</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Binding Cell Information</em>'.
	 * @generated
	 */
	IGridBindingCellInformation createGridBindingCellInformation();

	/**
	 * Returns a new object of class '<em>Binding Cell Editor</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Binding Cell Editor</em>'.
	 * @generated
	 */
	IGridBindingCellEditor createGridBindingCellEditor();

	/**
	 * Returns a new object of class '<em>Binding Column Information</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Binding Column Information</em>'.
	 * @generated
	 */
	IGridBindingColumnInformation createGridBindingColumnInformation();

	/**
	 * Returns a new object of class '<em>Binding Row Information</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Binding Row Information</em>'.
	 * @generated
	 */
	IGridBindingRowInformation createGridBindingRowInformation();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	IGridPackage getGridPackage();

	/**
	 * Creates a new Column Information object for the specified id
	 * 
	 * @param grid the grid binding
	 * @param columnID the id
	 * @param index the index
	 * @return the new object
	 */
	IGridBindingColumnInformation createGridBindingColumnInformation(IGridBinding grid, Object columnID, int index);

	/**
	 * Creates a new Row Information object for the specified id
	 * 
	 * @param grid the grid binding
	 * @param rowID the id
	 * @param index the index
	 * 
	 * @return the new object
	 */
	IGridBindingRowInformation createGridBindingRowInformation(IGridBinding grid, Object rowID, int index);

	/**
	 * Creates a new Cell Information object for the specified column and row id
	 * 
	 * @param column the column object
	 * @param row the row object
	 * @return the new object
	 */
	IGridBindingCellInformation createGridBindingCellInformation(IGridBindingColumnInformation column,
			IGridBindingRowInformation row);

} // IGridFactory
