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
	public IObservableList getRootElements();
}
