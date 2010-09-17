/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
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
