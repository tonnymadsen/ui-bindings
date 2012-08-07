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
package com.rcpcompany.uibindings.internal.spy;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.SWT;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingSpySection;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.internal.observables.TextObservableValue;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Basic section for {@link IValueBinding}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ValueBindingAttributeSection implements IBindingSpySection {
	@Override
	public void build(IFormCreator form, ExecutionEvent event) {
		final IBinding b = (IBinding) form.getObject();
		if (!(b instanceof IValueBinding)) return;
		final IValueBinding vb = (IValueBinding) b;
		final IUIAttribute attribute = vb.getUIAttribute();
		if (attribute == null) return;

		final IFormCreator subform = form.addSection("UI Attribute Information", attribute);

		subform.addField(form.getObservableValue(), "uiAttribute(w=300, label='Attribute Class')").type("className");
		subform.addField("attribute");
		subform.addField("changeable");
		subform.addField("widget(w=300)").type("className");

		final IObservableValue currentValue = attribute.getCurrentValue();
		if (currentValue instanceof TextObservableValue) {
			final TextObservableValue tov = (TextObservableValue) currentValue;
			subform.addConstantField("Current Commit Strategy:", tov.getStrategy(), SWT.NONE);
		}
	}
}
