package com.rcpcompany.uibindings.internal.decorators;

import org.eclipse.core.databinding.observable.list.IObservableList;

import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.decorators.BaseUIBindingDecorator;
import com.rcpcompany.uibindings.internal.InternalConstants;

/**
 * {@link IUIBindingDecorator} for type {@link InternalConstants#VIEWERS_MESSAGE_ONLY_TYPE}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class MessagesOnlyBindingDecorator extends BaseUIBindingDecorator implements IUIBindingDecorator {

	@Override
	public IObservableList getValidUIList() {
		return null;
	}
}
