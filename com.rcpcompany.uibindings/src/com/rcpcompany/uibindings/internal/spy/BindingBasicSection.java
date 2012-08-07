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

import com.rcpcompany.uibindings.IBindingSpySection;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Basic section for {@link IValueBinding}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingBasicSection implements IBindingSpySection {
	@Override
	public void build(IFormCreator creator, ExecutionEvent event) {
		final IFormCreator subform = creator.addSection("Basic Binding Information");

		subform.addField("state");
		subform.addField("type");
		subform.addSeparator();
		subform.addField("label");
		subform.addField("widget(label='Widget Class')").type("className");
		subform.addSeparator();
		subform.addField("changeable");
		subform.addField("dataType").type("className");
		subform.addField("modelEType");
		subform.addField("modelType").type("className");
		subform.addField("uiType").type("className");
	}
}
