/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Container Binding</b></em>'.
 * <!-- end-user-doc -->
 * 
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getContainerBinding()
 * @generated
 */
public interface IContainerBinding extends IBinding {

	/**
	 * Returns the cell in the container with the specified row and column (<code>(0, 0)</code>
	 * based).
	 * 
	 * @param column column number
	 * @param row row number
	 * @param visualModel <code>true</code> if the visual model should be used, <code>false</code>
	 *            if the logical model should be used
	 * 
	 * @return the cell or <code>null</code>
	 */
	IValueBindingCell getCell(int column, int row, boolean visualModel);
} // IContainerBinding
