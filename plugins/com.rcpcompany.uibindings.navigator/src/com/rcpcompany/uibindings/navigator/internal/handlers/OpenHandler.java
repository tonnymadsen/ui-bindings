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
package com.rcpcompany.uibindings.navigator.internal.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.utils.selection.SelectionUtils;

/**
 * Handler for <code>com.rcpcompany.uibindings.commands.openBinding</code>.
 * <p>
 * Only active for {@link EObject} with a {@link IEditorPartDescriptor}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class OpenHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		boolean forceNewEditor = false;
		final ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);

		if (event.getTrigger() instanceof Event) {
			final Event e = (Event) event.getTrigger();
			if ((e.stateMask & SWT.SHIFT) == SWT.SHIFT) {
				forceNewEditor = true;
			}
		}

		final List<EObject> list = SelectionUtils.computeSelection(selection, EObject.class);

		for (final EObject o : list) {
			INavigatorManager.Factory.getManager().openView(o, forceNewEditor);
		}
		return null;
	}

}
