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
package com.rcpcompany.uibindings.internal.spy;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.SWT;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingSpySection;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Basic section for {@link IValueBinding}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ValueBindingBasicSection implements IBindingSpySection {
	@Override
	public void build(IFormCreator creator, ExecutionEvent event) {
		final IBinding b = (IBinding) creator.getObject();
		if (!(b instanceof IValueBinding)) return;

		final IValueBinding vb = (IValueBinding) b;

		final IFormCreator subform = creator.addSection("Basic Value Information");

		subform.addField("messagePrefix");
		subform.addField("modelObservable(w=300)").type("className");
		subform.addField("modelObject(w=500)");
		subform.addField("modelFeature(w=300)").type("long");
		subform.addField("decoratorProvider(w=300)").type("className");
		subform.addField("decorator(w=300)").type("className");
		final IObservableValue o = vb.getModelObservableValue();
		if (o != null) {
			subform.addSeparator();
			subform.addConstantField("Observable Value", o.getValue(), SWT.NONE);
			subform.addConstantField("Observable Type", o.getValueType(), SWT.NONE);
		}
	}
}
