package com.rcpcompany.uibindings.navigator.views;

import org.eclipse.core.databinding.observable.list.IObservableList;

/**
 * Abstract base class for {@link INavigatorBaseViewAdvisor}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractNavigatorBaseViewAdvisor implements INavigatorBaseViewAdvisor {

	@Override
	public abstract IObservableList getRootElements();

	@Override
	public String getTreeID() {
		return "";
	}
}
