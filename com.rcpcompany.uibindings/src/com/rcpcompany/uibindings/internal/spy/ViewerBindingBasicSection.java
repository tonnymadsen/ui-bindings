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
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingSpySection;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Basic section for {@link IColumnBinding}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerBindingBasicSection implements IBindingSpySection {
	@Override
	public void build(IFormCreator creator, ExecutionEvent event) {
		final Object container = HandlerUtil.getVariable(event, Constants.SOURCES_ACTIVE_CONTAINER_BINDING);
		if (!(container instanceof IViewerBinding)) return;
		final IViewerBinding v = (IViewerBinding) container;

		final IFormCreator subform = creator.addSection("Viewer Information", v);

		subform.addField("viewer").type("className");
	}
}
