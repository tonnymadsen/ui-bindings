package com.rcpcompany.uibindings;

import org.eclipse.core.databinding.observable.list.IObservableList;

/**
 * This factory interface is used when a {@link IObservableList} is needed based on an annotation argument argument.
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public interface IObservableListFactory {
	/**
	 * Creates and returns a new observable list for the binding.
	 * <p>
	 * The caller must dispose the returned list.
	 * 
	 * @param binding the binding to return a list for
	 * @return the list
	 */
	public IObservableList createList(IValueBinding binding);
}
