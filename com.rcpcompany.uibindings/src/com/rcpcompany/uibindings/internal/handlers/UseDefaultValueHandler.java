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
package com.rcpcompany.uibindings.internal.handlers;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.ui.ISourceProviderListener;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.ui.services.ISourceProviderService;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.sourceProviders.BindingSourceProvider;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Handler for the commands <code>com.rcpcompany.uibindings.commands.UseDefaultValue</code>.
 * <p>
 * Keeps track of the current binding and updates the state appropriately.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UseDefaultValueHandler extends AbstractHandler implements IHandler, IElementUpdater {

	/**
	 * The binding source provider...
	 */
	private final BindingSourceProvider myProvider;

	/**
	 * The current "checked" state of the handler.
	 */
	private boolean myIsUnset = false;

	/**
	 * The current "is unsettable" state of the handler. Use to set the name.
	 */
	private boolean myIsUnsettable;

	/**
	 * Listener that tracks the {@link EObject#eIsSet(org.eclipse.emf.ecore.EStructuralFeature)}
	 * state of the current binding when {@link Constants#SOURCES_ACTIVE_BINDING} is
	 * <code>true</code>.
	 */
	private final ISourceProviderListener myProviderListener = new ISourceProviderListener() {

		@Override
		public void sourceChanged(int sourcePriority, String sourceName, Object sourceValue) {
			if (sourceName.equals(Constants.SOURCES_ACTIVE_BINDING)) {
				updateHandlerState();
			}
		}

		@Override
		public void sourceChanged(int sourcePriority, Map sourceValuesByName) {
			if (sourceValuesByName.containsKey(Constants.SOURCES_ACTIVE_BINDING)) {
				updateHandlerState();
			}
		}
	};

	/**
	 * The global command service.
	 */
	private final ICommandService myCommandService;

	/**
	 * Constructs and returns a new handler.
	 */
	public UseDefaultValueHandler() {
		final IServiceLocator locator = PlatformUI.getWorkbench();

		final ISourceProviderService sourceProviders = (ISourceProviderService) locator
				.getService(ISourceProviderService.class);
		myCommandService = (ICommandService) locator.getService(ICommandService.class);

		myProvider = (BindingSourceProvider) sourceProviders.getSourceProvider(Constants.SOURCES_ACTIVE_BINDING);

		myProvider.addSourceProviderListener(myProviderListener);
	}

	/**
	 * Calculates any new {@link #myIsUnset} and {@link #myIsUnsettable}.
	 */
	protected void updateHandlerState() {
		final Map<String, Object> currentState = myProvider.getCurrentState();
		final Object b = currentState.get(Constants.SOURCES_ACTIVE_BINDING);
		if (!(b instanceof IValueBinding)) return;
		final IValueBinding binding = (IValueBinding) b;

		final EStructuralFeature feature = binding.getModelFeature();
		if (feature == null) {
			setHandlerState(false, false);
			return;
		}
		final EObject obj = binding.getModelObject();
		if (obj == null) {
			setHandlerState(false, feature.isUnsettable());
			return;
		}

		setHandlerState(!obj.eIsSet(feature), feature.isUnsettable());
	}

	/**
	 * Sets the new value of {@link #myIsUnset}.
	 * 
	 * @param newIsUnset the new state
	 * @param newIsUnsettable TODO
	 */
	protected void setHandlerState(boolean newIsUnset, boolean newIsUnsettable) {
		if (myIsUnset == newIsUnset && myIsUnsettable == newIsUnsettable) return;
		myIsUnset = newIsUnset;
		myIsUnsettable = newIsUnsettable;
		myCommandService.refreshElements(Constants.USE_DEFAULT_TOGGLE_COMMAND, null);
	}

	@Override
	public void dispose() {
		myProvider.removeSourceProviderListener(myProviderListener);
		super.dispose();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (Activator.getDefault().TRACE_HANDLERS) {
			LogUtils.debug(this, "");
		}

		final IValueBinding binding = (IValueBinding) HandlerUtil.getVariableChecked(event,
				Constants.SOURCES_ACTIVE_BINDING);
		if (binding == null) return null;

		final EObject obj = binding.getModelObject();
		final EStructuralFeature feature = binding.getModelFeature();
		if (obj == null || feature == null) return null;

		final Object value;
		if (obj.eIsSet(feature)) {
			value = SetCommand.UNSET_VALUE;
		} else {
			value = obj.eGet(feature);
		}
		final Command command = SetCommand.create(binding.getEditingDomain(), obj, feature, value);
		binding.getEditingDomain().getCommandStack().execute(command);
		updateHandlerState();

		return null;
	}

	@Override
	public void updateElement(UIElement element, Map parameters) {
		String name = null;
		if (myIsUnset) {
			name = "Set as Normal Attribute";
		} else {
			if (myIsUnsettable) {
				name = "Set to Default";
			} else {
				name = "Use Default Value";
			}
		}
		element.setText(name);
		element.setChecked(myIsUnset);
	}
}
