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
package com.rcpcompany.uibindings.extests.bindings;

import com.rcpcompany.uibindings.IUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;

/**
 * Dummy extender for use in {@link ArgumentsSequenceTest#testDecoratorExtender()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FoobarExtender extends AbstractUIBindingDecoratorExtender implements IUIBindingDecoratorExtender {
	@Override
	public boolean isEnabled(IValueBinding binding) {
		return "foobar".equals(binding.getArgument("extender", String.class, null));
	}

	@Override
	public void extend(IUIBindingDecoratorExtenderContext context) {
	}
}
