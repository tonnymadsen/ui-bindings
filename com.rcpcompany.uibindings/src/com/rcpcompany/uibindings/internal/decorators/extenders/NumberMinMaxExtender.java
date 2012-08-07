/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.decorators.extenders;

import java.math.BigDecimal;

import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.internal.decorators.NumberBindingDecorator;

/**
 * Extender that will set min and max values on widgets if known and supported.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class NumberMinMaxExtender extends AbstractUIBindingDecoratorExtender {

	@Override
	public boolean isEnabled(IValueBinding binding) {
		return binding.getDecorator() instanceof NumberBindingDecorator;
	}

	@Override
	public void extend(IUIBindingDecoratorExtenderContext context) {
		final IValueBinding binding = context.getBinding();
		if (!(binding.getDecorator() instanceof NumberBindingDecorator)) return;
		final NumberBindingDecorator d = (NumberBindingDecorator) binding.getDecorator();
		if (!d.isIntegralNumber()) return;

		try {
			final BigDecimal m = d.getMin();
			if (m != null) {
				final int min = m.intValueExact();
				context.setMin(min);
			}
		} catch (final ArithmeticException ex) {
			// Do nothing
		}
		try {
			final BigDecimal m = d.getMax();
			if (m != null) {
				final int max = m.intValueExact();
				context.setMax(max);
			}
		} catch (final ArithmeticException ex) {
			// Do nothing
		}
	}
}
