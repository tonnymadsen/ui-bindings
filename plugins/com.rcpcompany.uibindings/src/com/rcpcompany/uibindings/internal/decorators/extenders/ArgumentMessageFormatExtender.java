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
package com.rcpcompany.uibindings.internal.decorators.extenders;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;

/**
 * Extender that handles {@link Constants#ARG_MESSAGE_FORMAT}.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public class ArgumentMessageFormatExtender extends AbstractUIBindingDecoratorExtender {

	@Override
	public boolean isEnabled(IValueBinding binding) {
		final String format = binding.getArgument(Constants.ARG_MESSAGE_FORMAT, String.class, null);
		return format != null;
	}

	@Override
	public void extend(IUIBindingDecoratorExtenderContext context) {
		final IValueBinding binding = context.getBinding();
		final String format = binding.getArgument(Constants.ARG_MESSAGE_FORMAT, String.class, null);
		if (format == null) return;

		context.setMessageFormat(format);
	}
}
