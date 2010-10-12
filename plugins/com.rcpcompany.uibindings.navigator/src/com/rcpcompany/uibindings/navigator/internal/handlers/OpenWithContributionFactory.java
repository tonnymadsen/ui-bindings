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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;

import com.rcpcompany.uibindings.navigator.IEditorInformation;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.utils.extensionpoints.CEResourceHolder;
import com.rcpcompany.utils.selection.SelectionUtils;

/**
 * Adds items to the "Open With" sub-menu based on the type of the current selection.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class OpenWithContributionFactory extends ExtensionContributionFactory {
	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		final ISelectionService ss = (ISelectionService) serviceLocator.getService(ISelectionService.class);

		final List<EObject> list = SelectionUtils.computeSelection(ss.getSelection(), EObject.class);

		/*
		 * Only know how to handle one item
		 */
		if (list.size() != 1) return;
		final EObject obj = list.get(0);

		final IEditorInformation mt = INavigatorManager.Factory.getManager().getEditorInformation(obj.getClass());
		final List<IEditorPartDescriptor> editors = mt.getEnabledEditors();

		/*
		 * Less than two editors... no need for an open with menu... Ignore.
		 */
		if (editors.size() < 2) return;

		/*
		 * Create contributions items for all the editors based on the name and image
		 */
		for (final IEditorPartDescriptor d : editors) {
			final IContributionItem item = new ContributionItem() {
				@Override
				public void fill(Menu menu, int index) {
					final MenuItem mi = new MenuItem(menu, SWT.NONE);
					mi.setText(d.getName());
					final CEResourceHolder image = d.getImage();
					if (image != null) {
						mi.setImage(image.getImage());
					}

					mi.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							mt.setPreferredEditor(d);
							INavigatorManager.Factory.getManager().openView(obj, false);
						}
					});
				}
			};
			additions.addContributionItem(item, null);
		}
	}
}
