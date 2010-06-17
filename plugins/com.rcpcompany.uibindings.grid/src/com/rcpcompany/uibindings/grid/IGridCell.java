package com.rcpcompany.uibindings.grid;

import java.util.Map;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;

import com.rcpcompany.uibindings.IDisposable;

/**
 * A cell in a grid as returned by {@link IGridModel}.
 * <p>
 * A cell is disposed when all needed information has been retrieved from the cell. More than one
 * cell might be in use at any one time.
 * <p>
 * The usage of the value of the cell can be monitored - if needed - via the number of listeners:
 * {@link AbstractObservableValue#hasListeners()}.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public interface IGridCell extends IDisposable {
	/**
	 * Returns the value of the cell. {@link IObservableValue#getValueType()} specifies the type of
	 * the value.
	 * <p>
	 * The value will be explicitly disposed when not used any more. Note that when a cell is not
	 * shown, it might and might not be disposed.
	 * 
	 * @return the value
	 */
	IObservableValue getValue();

	/**
	 * Returns a map with all defined arguments.
	 * 
	 * @return the map or <code>null</code> if no arguments are defined
	 */
	Map<String, Object> getArguments();
}
