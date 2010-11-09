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

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;
import org.eclipse.ui.services.IServiceLocator;

import com.rcpcompany.uibindings.navigator.IEditorInformation;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.IEditorPartView;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.INavigatorModelPackage;
import com.rcpcompany.uibindings.navigator.internal.NavigatorConstants;
import com.rcpcompany.utils.extensionpoints.CEResourceHolder;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Handler for the "Select Editor..." command.
 * <p>
 * Important for toolbars.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SelectEditorPartHandler extends AbstractHandler implements IHandler, IElementUpdater {
	private static final INavigatorManager MANAGER = INavigatorManager.Factory.getManager();
	private final ImageDescriptor myFallBackImage = PlatformUI.getWorkbench().getSharedImages()
			.getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT);

	/*
	 * Adapter used to update the handler when the preferred editor changes
	 */
	private final Adapter myAdapter = new EContentAdapter() {
		@Override
		public void notifyChanged(Notification msg) {
			super.notifyChanged(msg);
			if (msg.isTouch()) return;
			if (msg.getEventType() == Notification.MOVE) return;
			if (msg.getFeature() == INavigatorModelPackage.Literals.EDITOR_INFORMATION__PREFERRED_EDITOR) {
				LogUtils.debug(this, "update " + NavigatorConstants.SELECT_EDITOR_PART_COMMAND);
				/*
				 * Make all select editor parts update themselves...
				 */
				final ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getService(
						ICommandService.class);
				commandService.refreshElements(NavigatorConstants.SELECT_EDITOR_PART_COMMAND, null);
			}
		};
	};

	public SelectEditorPartHandler() {
		MANAGER.eAdapters().add(myAdapter);
	}

	@Override
	public void dispose() {
		super.dispose();
		MANAGER.eAdapters().remove(myAdapter);
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final String editorID = event.getParameter(NavigatorConstants.EDITOR_ID_PARAMETER);
		if (editorID == null || editorID.length() == 0) return null;

		IEditorPartDescriptor desc = null;
		for (final IEditorPartDescriptor d : MANAGER.getDescriptors()) {
			if (d.getId().equals(editorID)) {
				desc = d;
				break;
			}
		}
		if (desc == null) throw new ExecutionException("No editor with ID '" + editorID + "'");

		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		final IWorkbenchPart activePart = HandlerUtil.getActivePartChecked(event);
		if (!(activePart instanceof IEditorPartView)) return null;
		final IEditorPartView view = (IEditorPartView) activePart;

		final EObject currentObject = view.getCurrentObject();
		if (currentObject == null) return null;
		final IEditorInformation mt = MANAGER.getEditorInformation(currentObject.getClass());

		mt.setPreferredEditor(desc);
		view.setCurrentObject(view.getCurrentObject());

		return null;
	}

	@Override
	public void updateElement(UIElement element, Map parameters) {
		final IServiceLocator serviceLocator = element.getServiceLocator();

		final IWorkbenchPartSite site = (IWorkbenchPartSite) serviceLocator.getService(IWorkbenchPartSite.class);
		if (site == null) return;
		final IWorkbenchPart part = site.getPart();
		if (!(part instanceof IEditorPartView)) return;
		final IEditorPartView view = (IEditorPartView) part;

		IEditorPartDescriptor desc = null;

		final String editorID = (String) parameters.get(NavigatorConstants.EDITOR_ID_PARAMETER);
		if (editorID == null || editorID.length() == 0) {
			desc = view.getCurrentDescriptor();
		} else {
			for (final IEditorPartDescriptor d : MANAGER.getDescriptors()) {
				if (d.getId().equals(editorID)) {
					desc = d;
					break;
				}
			}
			if (desc == null) {
				LogUtils.error(this, "No editor with ID '" + editorID + "'");
			}
		}

		final boolean enabled = desc != null;
		ImageDescriptor descriptor = myFallBackImage;
		String name = "<none>";
		if (enabled) {
			final CEResourceHolder imageHolder = desc.getImage();
			if (imageHolder != null) {
				descriptor = imageHolder.getImageDescriptor();
			}
			name = desc.getName();
		}

		setBaseEnabled(enabled);
		element.setText(name);
		element.setIcon(descriptor);
		element.setChecked(desc == view.getCurrentDescriptor());
	}
}
