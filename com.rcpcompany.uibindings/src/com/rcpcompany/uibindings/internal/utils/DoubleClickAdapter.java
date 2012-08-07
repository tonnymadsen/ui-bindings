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
package com.rcpcompany.uibindings.internal.utils;

import java.util.Map;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.SerializationException;
import org.eclipse.core.commands.common.CommandException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.ui.services.ISourceProviderService;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.sourceProviders.BindingSourceProvider;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Implementation of double click adapter on a viewer.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DoubleClickAdapter implements Listener, IDisposable {
	/**
	 * The viewer of this adapter.
	 */
	private final IViewerBinding myViewer;

	/**
	 * Creates a new adapter for the specified viewer.
	 * 
	 * @param viewer the viewer
	 */
	public static void adapt(IViewerBinding viewer) {
		if (viewer.getService(DoubleClickAdapter.class) != null) return;
		new DoubleClickAdapter(viewer);
	}

	/**
	 * Constructs and returns a new adapter for the specified viewer.
	 * 
	 * @param viewer the viewer of the adapter
	 */
	public DoubleClickAdapter(IViewerBinding viewer) {
		myViewer = viewer;
		myViewer.registerService(this);

		myViewer.getControl().addListener(SWT.MouseDoubleClick, this);
	}

	@Override
	public void dispose() {
		myViewer.unregisterService(this);
		myViewer.getControl().removeListener(SWT.MouseDoubleClick, this);
	}

	@Override
	public void handleEvent(Event event) {
		final IServiceLocator locator = myViewer.getContext().getServiceLocator();
		final IHandlerService hs = (IHandlerService) locator.getService(IHandlerService.class);

		final ISourceProviderService sourceProviders = (ISourceProviderService) locator
				.getService(ISourceProviderService.class);
		final BindingSourceProvider theBindingSourceProvider = (BindingSourceProvider) sourceProviders
				.getSourceProvider(Constants.SOURCES_ACTIVE_BINDING);

		/*
		 * First see if there are an open command associated with the specific column.
		 * 
		 * Can change the global state...
		 */
		final Map<String, Object> currentState = theBindingSourceProvider.getCurrentState();

		final Object b = currentState.get(Constants.SOURCES_ACTIVE_BINDING);
		if (!(b instanceof IValueBinding)) return;

		final IValueBinding binding = (IValueBinding) b;

		try {
			/*
			 * Get the command from the binding if present - otherwise from the viewer itself
			 */
			String cmd = binding.getArgument(Constants.ARG_DOUBLE_CLICK_COMMAND, String.class, null);
			if (cmd == null) {
				cmd = myViewer.getArgument(Constants.ARG_DOUBLE_CLICK_COMMAND, String.class, null);
			}
			if (cmd == null) return;

			/*
			 * Construct the pc...
			 */
			ParameterizedCommand pc = null;
			final IServiceLocator locator1 = myViewer.getContext().getServiceLocator();
			final ICommandService cs = (ICommandService) locator1.getService(ICommandService.class);
			try {
				pc = cs.deserialize(cmd);
			} catch (final NotDefinedException ex) {
				LogUtils.error(this, ex);
			} catch (final SerializationException ex) {
				LogUtils.error(this, ex);
			}

			if (pc == null) return;

			/*
			 * Execute it... If successful, then mark the event.
			 */
			if (!pc.getCommand().isHandled()) return;
			hs.executeCommand(pc, event);
			event.doit = false;
		} catch (final CommandException ex) {
			LogUtils.error(this, ex);
		}
	}
};
