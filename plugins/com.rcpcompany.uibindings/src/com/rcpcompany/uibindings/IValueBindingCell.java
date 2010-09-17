/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;

/**
 * The interface is used by bindings to access information and functionality that is available only
 * when the binding is used in a cell.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IValueBindingCell {
	/**
	 * Returns the container for this cell.
	 * 
	 * @return the container
	 */
	IContainerBinding getContainer();

	/**
	 * Returns the position of this cell in the parent viewer. Top left cell is <code>(0, 0)</code>.
	 * <p>
	 * Thus
	 * 
	 * <pre>
	 * Point position = cell.getPosition(false);
	 * cell.getContainer().getCell(position.x, position.y, false) == cell
	 * </pre>
	 * 
	 * @param visualModel <code>true</code> if the visual model should be used rather than the
	 *            logical model
	 * 
	 * @return the position
	 */
	Point getPosition(boolean visualModel);

	/**
	 * Sets the focus to the cell.
	 * 
	 * @return the Control that contains the cell - e.g. a table or grid
	 */
	Control setFocus();

	/**
	 * Returns a string that is suitable as a message prefix for any messages of the binding.
	 * 
	 * @return the proposed prefix or <code>null</code> if no string can be found
	 */
	String getMessagePrefix();

	/**
	 * Returns the {@link IObservableValue} for the object value of the cell.
	 * <p>
	 * If the observable value is changed - see {@link IObservableValue#setValue(Object)} - then the
	 * model is changed
	 * 
	 * @return the observable value
	 */
	IObservableValue getObjectValue();

	/**
	 * Returns the {@link IValueBinding value binding} for the cell.
	 * <p>
	 * The value binding is used to find the label used for the cell.
	 * 
	 * @return the label binding
	 */
	IValueBinding getLabelBinding();

	/**
	 * Returns the column of the cell, in case the cell belongs to an {@link IViewerBinding}.
	 * 
	 * @return the column or <code>null</code>
	 */
	IColumnBinding getColumnBinding();
}
