package com.rcpcompany.uibindings.scripting.internal.bindings;

import org.eclipse.core.databinding.observable.list.IObservableList;

import com.rcpcompany.uibindings.IObservableListFactory;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.scripting.IScriptManager;

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
