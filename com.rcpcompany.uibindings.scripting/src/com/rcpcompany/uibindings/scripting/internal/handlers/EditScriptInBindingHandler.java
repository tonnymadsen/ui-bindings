/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.scripting.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.moao.IMOAO;
import com.rcpcompany.uibindings.scripting.internal.bindings.FeatureScriptDialog;

/**
 * Edits the current binding in a feature script editor.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EditScriptInBindingHandler extends AbstractHandler implements IHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final Shell shell = HandlerUtil.getActiveShellChecked(event);
		/*
		 * Find the binding and the object in question
		 */
		final Object binding = HandlerUtil.getVariableChecked(event, Constants.SOURCES_ACTIVE_BINDING);
		if (!(binding instanceof IValueBinding)) {
			return null;
		}
		final IValueBinding vb = (IValueBinding) binding;

		if (!(vb.getModelObject() instanceof IMOAO)) {
			return null;
		}

		new FeatureScriptDialog(shell, vb).open();

		return null;
	}
}
