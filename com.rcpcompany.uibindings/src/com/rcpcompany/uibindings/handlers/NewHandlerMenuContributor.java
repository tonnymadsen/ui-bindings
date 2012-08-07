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
package com.rcpcompany.uibindings.handlers;

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.ui.menus.IWorkbenchContribution;
import org.eclipse.ui.services.IEvaluationService;
import org.eclipse.ui.services.IServiceLocator;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IChildCreationSpecification;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.utils.IBindingObjectInformation;
import com.rcpcompany.uibindings.utils.UIBEcoreUtils;

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
	 * <p>
	 * Used when no items can be found in {@link #getContributionItems()}. This is needed as the
	 * menu is other not updated as it is visible but disable when it is empty...
	 */
	private static final IContributionItem[] EMPTY_ITEMS = new IContributionItem[1];
	{
		EMPTY_ITEMS[0] = new ContributionItem() {
			@Override
			public void fill(Menu menu, int index) {
				final MenuItem item = new MenuItem(menu, SWT.NONE);

				item.setText("Nothing to create...");
				item.setEnabled(false);
			};
		};
	}

	@Override
	protected IContributionItem[] getContributionItems() {
		final IEvaluationService evalService = (IEvaluationService) myServiceLocator
				.getService(IEvaluationService.class);
		Object bb = evalService.getCurrentState().getVariable(Constants.SOURCES_ACTIVE_CONTAINER_BINDING);
		if (!(bb instanceof IViewerBinding)) return EMPTY_ITEMS;
		// The viewer
		final IViewerBinding container = (IViewerBinding) bb;

		bb = evalService.getCurrentState().getVariable(Constants.SOURCES_ACTIVE_BINDING);
		final EObject obj;
		if (bb instanceof IValueBinding) {
			obj = ((IValueBinding) bb).getModelObject();
		} else {
			obj = null;
		}

		/*
		 * Only one selection please
		 */
		final List<IChildCreationSpecification> specs = container.getPossibleChildObjects(obj, null);
		if (specs == null) return EMPTY_ITEMS;

		// Only handle containment relations
		for (final IChildCreationSpecification sp : specs.toArray(new IChildCreationSpecification[specs.size()])) {
			if (!sp.getReference().isContainment()) {
				specs.remove(sp);
			}
		}

		/*
		 * Less than one specs... no need for an open with menu... Ignore.
		 */
		if (specs == null || specs.size() < 1) return EMPTY_ITEMS;

		/*
		 * Create contributions items for all the specifications
		 */
		final IContributionItem[] items = new IContributionItem[specs.size()];
		for (int i = 0; i < items.length; i++) {
			final IChildCreationSpecification sp = specs.get(i);
			final IContributionItem item = new NewContributionItem(sp, container, container.getEditingDomain());
			items[i] = item;
		}

		return items;
	}

	/**
	 * A single menu entry.
	 * 
	 * @author Tonny Madsen, The RCP Company
	 */
	public class NewContributionItem extends ContributionItem implements SelectionListener {
		private final IChildCreationSpecification mySpec;
		private final IViewerBinding myContainer;
		private final EditingDomain myEditingDomain;

		public NewContributionItem(IChildCreationSpecification sp, IViewerBinding container, EditingDomain ed) {
			mySpec = sp;
			myContainer = container;
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

			myItem.addSelectionListener(this);
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
			Command initializeCommand;
			if (mySpec.getReference().isContainment()) {
				child = EcoreUtil.create(mySpec.getChildType());
				/*
				 * Initialize the object
				 */
				initializeCommand = IManager.Factory.getManager().initializeObject(myEditingDomain, mySpec.getParent(),
						mySpec.getReference(), child, false);
			} else {
				child = null;
				UIBEcoreUtils.showErrorDialog("New Aborted", "Cannot add the selected objects", null);
				return;
			}
			final CompoundCommand cmd = new CompoundCommand();
			if (initializeCommand != null) {
				cmd.append(initializeCommand);
			}
			if (mySpec.getReference().isMany()) {
				cmd.append(AddCommand.create(myEditingDomain, mySpec.getParent(), mySpec.getReference(), child));
			} else {
				cmd.append(SetCommand.create(myEditingDomain, mySpec.getParent(), mySpec.getReference(), child));
			}

			/*
			 * Execute if possible...
			 * 
			 * TODO return value
			 */
			if (!cmd.canExecute()) {
				UIBEcoreUtils.showErrorDialog("New Aborted", "Cannot add the selected objects", null);
				return;
			}

			// LogUtils.debug(this, "execute");

			myEditingDomain.getCommandStack().execute(cmd);

			/*
			 * Select the new child object
			 */
			final ColumnViewer viewer = myContainer.getViewer();
			viewer.setSelection(new StructuredSelection(child), true);

			/*
			 * Possibly open an editor
			 */
			// TODO
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			createObject();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			createObject();
		}
	}
}
