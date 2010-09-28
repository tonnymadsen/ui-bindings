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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.ui.menus.IWorkbenchContribution;
import org.eclipse.ui.services.IEvaluationService;
import org.eclipse.ui.services.IServiceLocator;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IChildCreationSpecification;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.utils.SelectionUtils;
import com.rcpcompany.uibindings.utils.IBindingObjectInformation;
import com.rcpcompany.uibindings.utils.UIBEcoreUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Adds items to the "New..." sub-menu based on the current element of the current viewer.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class NewHandlerMenuContributor extends CompoundContributionItem implements IWorkbenchContribution {

	private IServiceLocator myServiceLocator;

	public NewHandlerMenuContributor() {
	}

	public NewHandlerMenuContributor(String id) {
		super(id);
	}

	@Override
	public void initialize(IServiceLocator serviceLocator) {
		myServiceLocator = serviceLocator;
	}

	/**
	 * Empty set of items.
	 */
	private final IContributionItem[] EMPTY_ITEMS = new IContributionItem[0];

	@Override
	protected IContributionItem[] getContributionItems() {
		final IEvaluationService es = (IEvaluationService) myServiceLocator.getService(IEvaluationService.class);
		final IBinding bb = (IBinding) es.getCurrentState().getVariable(Constants.SOURCES_ACTIVE_CONTAINER_BINDING);
		if (!(bb instanceof IViewerBinding)) return EMPTY_ITEMS;
		// The viewer
		final IViewerBinding vb = (IViewerBinding) bb;

		final ISelection s = vb.getViewer().getSelection();

		final List<EObject> list = SelectionUtils.computeSelection(s, EObject.class);
		/*
		 * Only one selection please
		 */
		if (list.size() != 1) return EMPTY_ITEMS;

		final List<IChildCreationSpecification> specs = vb.getPossibleChildObjects(list.get(0));

		/*
		 * Less than two specs... no need for an open with menu... Ignore.
		 */
		if (specs.size() < 1) return EMPTY_ITEMS;

		/*
		 * Create contributions items for all the specifications
		 */
		final IContributionItem[] items = new IContributionItem[specs.size()];
		for (int i = 0; i < items.length; i++) {
			final IChildCreationSpecification sp = specs.get(i);
			final IContributionItem item = new NewContributionItem(sp, vb.getEditingDomain());
			items[i] = item;
		}

		return items;
	}

	/**
	 * A single menu entry.
	 * 
	 * @author Tonny Madsen, The RCP Company
	 */
	public class NewContributionItem extends ContributionItem {

		private final IChildCreationSpecification mySpec;
		private final EditingDomain myEditingDomain;

		public NewContributionItem(IChildCreationSpecification sp, EditingDomain ed) {
			mySpec = sp;
			myEditingDomain = ed;
		}

		private MenuItem myItem;

		@Override
		public void fill(Menu menu, int index) {
			final IBindingObjectInformation i = IBindingObjectInformation.Factory.createObjectInformation(mySpec
					.getChildType());
			myItem = new MenuItem(menu, SWT.PUSH, index);

			myItem.setText(i.getLabel());
			myItem.setImage(i.getImage());

			myItem.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					createObject();
				}
			});
		}

		protected void createObject() {
			/*
			 * Two possible cases:
			 * 
			 * - the reference is a containment reference, in which case, we want to add a new
			 * object,
			 * 
			 * - or the reference is "normal" reference, in which case, we want to use a dialog
			 * first to select the object to add
			 */
			final EObject child;
			if (mySpec.getReference().isContainment()) {
				child = EcoreUtil.create(mySpec.getChildType());
			} else {
				child = null;
				UIBEcoreUtils.showErrorDialog("New Aborted", "Cannot add the selected objects", null);
				return;
			}
			final Command cmd = AddCommand.create(myEditingDomain, mySpec.getParent(), mySpec.getReference(), child);

			/*
			 * Execute if possible...
			 * 
			 * TODO return value
			 */
			if (!cmd.canExecute()) return;

			LogUtils.debug(this, "execute");

			myEditingDomain.getCommandStack().execute(cmd);
		}
	}
}
