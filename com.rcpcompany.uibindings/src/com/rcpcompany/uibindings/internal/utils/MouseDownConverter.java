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

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.SerializationException;
import org.eclipse.core.commands.common.CommandException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * A simple converter class that will convert an unhandled {@link SWT#MouseDown} event to be handled
 * globally and converted into a specific command.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class MouseDownConverter implements IDisposable, Listener {
	/**
	 * The mouse button to convert - 1..5.
	 */
	private final int myButton;

	/**
	 * The modifier state when the mouse button is pressed - zero, one or more of the following
	 * or'ed together {@link SWT#SHIFT},{@link SWT#ALT}, {@link SWT#CTRL}, and {@link SWT#SHIFT}.
	 */
	private final int myState;

	/**
	 * The command to execute
	 */
	private final ParameterizedCommand myCommand;

	/**
	 * The handler service...
	 */
	private final IHandlerService myHandlerService;

	/**
	 * Constructs and returns a new converter for the specified mouse button to the specified
	 * command
	 * 
	 * @param button the SWT button to convert - 1..5
	 * @param state the modifier state - zero, one or more of the following or'ed together
	 *            {@link SWT#SHIFT}, {@link SWT#ALT}, {@link SWT#CTRL}, and {@link SWT#SHIFT}
	 * @param serializedCommand the command to execute for the command in serialized form
	 * @throws SerializationException
	 * @throws NotDefinedException
	 */
	public MouseDownConverter(int button, int state, String serializedCommand) throws NotDefinedException,
			SerializationException {
		myButton = button;
		myState = state;
		final IWorkbench workbench = PlatformUI.getWorkbench();
		final ICommandService cs = (ICommandService) workbench.getService(ICommandService.class);
		myHandlerService = (IHandlerService) workbench.getService(IHandlerService.class);

		myCommand = cs.deserialize(serializedCommand);

		workbench.getDisplay().addFilter(SWT.MouseDown, this);
	}

	@Override
	public void dispose() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		workbench.getDisplay().removeFilter(SWT.MouseDown, this);
	}

	@Override
	public void handleEvent(Event event) {
		if (event.button == myButton && (event.stateMask & SWT.MODIFIER_MASK) == myState) {
			try {
				myHandlerService.executeCommand(myCommand, event);
			} catch (final CommandException ex) {
				LogUtils.error(this, ex);
			}
		}
	}
}
