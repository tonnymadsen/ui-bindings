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
package com.rcpcompany.uibindings.internal.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler2;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IChildCreationSpecification;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.InternalConstants;
import com.rcpcompany.uibindings.internal.utils.SelectionUtils;
import com.rcpcompany.uibindings.utils.UIBEcoreUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Adds a new object.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class NewHandler extends AbstractHandler implements IHandler2 {
	@Override
	public Object execute(ExecutionEvent ee) throws ExecutionException {
		if (Activator.getDefault().TRACE_HANDLERS) {
			LogUtils.debug(this, "");
		}
		// The binding
		final IBinding bb = (IBinding) HandlerUtil.getVariableChecked(ee, Constants.SOURCES_ACTIVE_CONTAINER_BINDING);
		if (!(bb instanceof IViewerBinding)) return null;
		// The viewer
		final IViewerBinding vb = (IViewerBinding) bb;

		final ISelection s = vb.getViewer().getSelection();

		final List<EObject> list = SelectionUtils.computeSelection(s, EObject.class);
		if (list.size() != 0) return null;

		final EObject parent = list.get(0);

		final List<IChildCreationSpecification> specs = vb.getPossibleChildObjects(parent);
		if (specs.size() == 0) return null;

		LogUtils.debug(this, "" + specs);

		final String id = ee.getParameter(InternalConstants.ID_PARAMETER);

		/*
		 * Find the right spec again
		 */
		IChildCreationSpecification spec = null;
		for (final IChildCreationSpecification sp : specs) {
			if (sp.getId().equals(id)) {
				spec = sp;
				break;
			}
		}
		if (spec == null) return null;

		/*
		 * Two possible cases:
		 * 
		 * - the reference is a containment reference, in which case, we want to add a new object,
		 * 
		 * - or the reference is "normal" reference, in which case, we want to use a dialog first to
		 * select the object to add
		 */
		final EObject child;
		if (spec.getReference().isContainment()) {
			child = EcoreUtil.create(spec.getChildType());
		} else {
			child = null;
			UIBEcoreUtils.showErrorDialog("New Aborted", "Cannot add the selected objects", null);
			return null;
		}
		final Command cmd = AddCommand.create(vb.getEditingDomain(), spec.getParent(), spec.getReference(), child);

		/*
		 * Execute if possible...
		 * 
		 * TODO return value
		 */
		if (!cmd.canExecute()) return null;

		LogUtils.debug(this, "execute");

		vb.getEditingDomain().getCommandStack().execute(cmd);

		return null;
	}
}
