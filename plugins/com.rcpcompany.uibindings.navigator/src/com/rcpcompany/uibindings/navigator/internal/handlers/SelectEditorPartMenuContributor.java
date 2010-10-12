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

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;

import com.rcpcompany.uibindings.navigator.IEditorInformation;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.IEditorPartView;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.internal.NavigatorConstants;

/**
 * Adds items to the "Select Editor" sub-menu based on the current object of the current editor.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SelectEditorPartMenuContributor extends ExtensionContributionFactory {
	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		final IWorkbenchPartSite site = (IWorkbenchPartSite) serviceLocator.getService(IWorkbenchPartSite.class);
		if (site == null) return;
		final IWorkbenchPart part = site.getPart();
		if (part == null) return;
		if (!(part instanceof IEditorPartView)) return;
		final IEditorPartView view = (IEditorPartView) part;
		final EObject obj = view.getCurrentObject();
		if (obj == null) return;

		final IEditorInformation mt = INavigatorManager.Factory.getManager().getEditorInformation(obj.getClass());
		final List<IEditorPartDescriptor> editors = mt.getEnabledEditors();

		/*
		 * Less than two editors... no need for an open with menu... Ignore.
		 */
		if (editors.size() < 2) return;

		/*
		 * Create contributions items for all the editors
		 */
		for (final IEditorPartDescriptor d : editors) {
			final CommandContributionItemParameter parameters = new CommandContributionItemParameter(serviceLocator,
					null, NavigatorConstants.SELECT_EDITOR_PART_COMMAND, CommandContributionItem.STYLE_CHECK);
			parameters.parameters = new HashMap<Object, Object>();
			parameters.parameters.put(NavigatorConstants.EDITOR_ID_PARAMETER, d.getId());
			final IContributionItem item = new CommandContributionItem(parameters);
			additions.addContributionItem(item, null);
		}
	}
}
