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
package com.rcpcompany.uibindings.utils;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.common.CommandException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.services.IServiceLocator;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * This handler executes a generic command that is specified as the extension data for the handler
 * class.
 * <p>
 * E.g.
 * 
 * <pre>
 * &lt;extension point=&quot;org.eclipse.ui.handlers&quot;&gt;
 *     &lt;handler
 *             class=&quot;com.rcpcompany.uibindings.utils.GenericCommandHandler:org.eclipse.ui.views.showView(org.eclipse.ui.views.showView.viewId=com.rcpcompany.uibindings.example.application.views.InventoryView)&quot;
 *             commandId=&quot;com.rcpcompany.uibindings.commands.open&quot;&gt;
 *         &lt;activeWhen&gt;
 *             &lt;with variable=&quot;com.rcpcompany.uibindings.sourceProviders.currentCellValue&quot;&gt;
 *                 &lt;instanceof value=&quot;com.rcpcompany.uibindings.tests.shop.Country&quot; /&gt;
 *             &lt;/with&gt;
 *         &lt;/activeWhen&gt;
 *     &lt;/handler&gt;
 * &lt;/extension&gt;
 * </pre>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GenericCommandHandler extends AbstractHandler implements IHandler, IExecutableExtension {

	@Override
	public Object execute(ExecutionEvent ee) throws ExecutionException {
		if (Activator.getDefault().TRACE_HANDLERS) {
			LogUtils.debug(this, "command: " + myCommand);
		}
		final IBindingContext context = (IBindingContext) HandlerUtil.getVariableChecked(ee,
				Constants.SOURCES_ACTIVE_CONTEXT);

		final IServiceLocator sl = context.getServiceLocator();
		final ICommandService cs = (ICommandService) sl.getService(ICommandService.class);
		final IHandlerService hs = (IHandlerService) sl.getService(IHandlerService.class);

		try {
			final ParameterizedCommand command = cs.deserialize(myCommand);
			hs.executeCommand(command, (Event) ee.getTrigger());
		} catch (final CommandException ex) {
			LogUtils.error(hs, ex);
		}

		return null;
	}

	/**
	 * The command to execute.
	 */
	private String myCommand;

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) {
		myCommand = (String) data;
	}
}
