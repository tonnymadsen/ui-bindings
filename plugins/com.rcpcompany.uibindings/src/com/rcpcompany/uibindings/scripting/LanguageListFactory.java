package com.rcpcompany.uibindings.scripting;

import org.eclipse.core.databinding.observable.list.IObservableList;

import com.rcpcompany.uibindings.IObservableListFactory;
import com.rcpcompany.uibindings.IValueBinding;

/**
 * {@link IObservableListFactory} for {@link IScriptManager#getLanguageList()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class LanguageListFactory implements IObservableListFactory {
	@Override
	public IObservableList createList(IValueBinding binding) {
		return IScriptManager.Factory.getManager().getLanguageList();
	}
}
