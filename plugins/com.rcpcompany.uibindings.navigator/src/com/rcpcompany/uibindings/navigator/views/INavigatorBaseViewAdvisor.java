package com.rcpcompany.uibindings.navigator.views;

import org.eclipse.core.databinding.observable.list.IObservableList;

/**
 * Advisor for {@link NavigatorBaseView}
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface INavigatorBaseViewAdvisor {
	/**
	 * Returns the root elements of the navigator
	 * 
	 * @return the root elements
	 */
	IObservableList getRootElements();

	/**
	 * Returns the navigator (tree) ID.
	 * <p>
	 * Used to control the items that are available in the navigator. See the
	 * <code>com.rcpcompany.uibindings.uiBindings</code> extension point.
	 * 
	 * @return the navigator ID
	 */
	String getTreeID();
}
