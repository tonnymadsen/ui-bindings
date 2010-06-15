/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.widgets.Control;

/**
 * The interface is used by bindings to access information and functionality that is available only
 * when the binding is used in a cell.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IValueBindingCell {
	/**
	 * Sets the focus to the cell.
	 * 
	 * @return the Control that contains the cell - e.g. a table or grid
	 */
	public Control setFocus();

	/**
	 * Returns a string that is suitable as a message prefix for any messages of the binding.
	 * 
	 * @return the proposed prefix or <code>null</code> if no string can be found
	 */
	public String getMessagePrefix();

	/**
	 * Returns the {@link IObservableValue} for the object value of the cell.
	 * <p>
	 * If the observable value is changed - see {@link IObservableValue#setValue(Object)} - then the
	 * model is changed
	 * 
	 * @return the observable value
	 */
	public IObservableValue getObjectValue();

	/**
	 * Returns the {@link IValueBinding value binding} for the cell.
	 * <p>
	 * The value binding is used to find the label used for the cell.
	 * 
	 * @return the label binding
	 */
	public IValueBinding getLabelBinding();

	/**
	 * Returns the column of the cell, in case the cell belongs to an {@link IViewerBinding}.
	 * 
	 * @return the column or <code>null</code>
	 */
	public IColumnBinding getColumnBinding();
}
