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
package com.rcpcompany.uibindings.internal.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler2;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IElementParentage;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.utils.UIBEcoreUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Deletes the current object in a viewer.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DeleteHandler extends AbstractHandler implements IHandler2 {
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

		final Command cmd = createCommand(vb, true);
		/*
		 * Execute if possible...
		 */
		if (cmd == null || !cmd.canExecute()) throw new ExecutionException("Cannot delete selected objects");

		// LogUtils.debug(this, "execute");

		vb.getEditingDomain().getCommandStack().execute(cmd);

		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		if (!(evaluationContext instanceof IEvaluationContext)) return;
		final IEvaluationContext context = (IEvaluationContext) evaluationContext;

		// The binding
		final Object bbo = context.getVariable(Constants.SOURCES_ACTIVE_CONTAINER_BINDING);
		if (!(bbo instanceof IViewerBinding)) {
			setBaseEnabled(false);
			return;
		}
		// The viewer
		final IViewerBinding vb = (IViewerBinding) bbo;

		final Command cmd = createCommand(vb, false);
		/*
		 * Execute if possible...
		 */
		if (cmd == null || !cmd.canExecute()) {
			setBaseEnabled(false);
			return;
		}

		if (IManager.Factory.getManager().isDeleteHandlerCheckEnabled()) {
			final Collection<EObject> list = vb.getSelection();

			final Map<EObject, Collection<Setting>> references = UIBEcoreUtils.findIncomingRequiredReferences(list);
			if (references != null) {
				setBaseEnabled(false);
				return;
			}
		}

		setBaseEnabled(true);
	}

	@Override
	protected void setBaseEnabled(boolean state) {
		super.setBaseEnabled(state);
	}

	/**
	 * Creates and returns a command that can delete the current objects of the specified viewer.
	 * 
	 * @param vb the viewer binding
	 * @param queryUser TODO
	 * @return the command that will delete the current objects or <code>null</code>
	 */
	public static Command createCommand(IViewerBinding vb, boolean queryUser) {
		/*
		 * TODO: find a way to cache the result - this method is called far too many times!
		 */
		// Then find the selected objects
		final Collection<EObject> list = vb.getSelection();
		if (list.size() == 0) return null;

		final EditingDomain domain = vb.getEditingDomain();
		final CompoundCommand cc = new CompoundCommand();
		final List<EObject> deleteObjects = new ArrayList<EObject>();
		for (final EObject element : list) {
			/*
			 * Find the parentage for the element. Especially important - and difficult - for trees.
			 */
			final IElementParentage ep = vb.getElementParentage(element);
			if (ep == null) {
				continue;
			}
			final EObject parent = ep.getParent();
			final EReference ref = ep.getReference();
			if (parent == null || ref == null) {
				continue;
			}

			Command cmd = null;
			if (ref.isContainment()) {
				deleteObjects.add(element);
			} else {
				cmd = RemoveCommand.create(domain, parent, ref, element);
			}
			cc.append(cmd);
		}
		if (!deleteObjects.isEmpty()) {
			cc.append(DeleteCommand.create(domain, deleteObjects));
			final Command deleteCommands = IManager.Factory.getManager().deleteObjects(domain, deleteObjects, false);
			if (deleteCommands == null) return UnexecutableCommand.INSTANCE;
			cc.append(deleteCommands);
		}
		return cc.unwrap();
	}
}
