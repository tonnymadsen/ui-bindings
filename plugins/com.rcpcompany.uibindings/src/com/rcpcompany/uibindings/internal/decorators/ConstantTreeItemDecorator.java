package com.rcpcompany.uibindings.internal.decorators;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IConstantTreeItem;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.decorators.SimpleUIBindingDecorator;

/**
 * {@link IUIBindingDecorator} used for {@link IConstantTreeItem} objects.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ConstantTreeItemDecorator extends SimpleUIBindingDecorator implements IUIBindingDecorator {
	@Override
	protected Object convertModelToUI(Object fromObject) {
		String l = getBinding().getArgument(Constants.ARG_TEXT, String.class, null);
		if (l == null) {
			// LogUtils.error(getBinding(), "No text for model object: " +
			// getBinding().getModelObject());
			l = "<no text?>";
		}
		return l;
	}

	@Override
	protected Object convertUIToModel(Object fromObject) {
		return null;
	}

	/**
	 * These objects cannot be changed!
	 */
	@Override
	public boolean isChangeable() {
		return false;
	}
}
