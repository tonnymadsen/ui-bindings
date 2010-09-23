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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingContext.FinishOption;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.utils.BindingTransfer;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Handler for org.eclipse.ui.edit.paste for within {@link IViewerBinding}...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerPasteHandler extends AbstractHandler implements IHandler {
	@Override
	public Object execute(ExecutionEvent event) {
		if (Activator.getDefault().TRACE_HANDLERS) {
			LogUtils.debug(this, "");
		}
		final IValueBinding binding = (IValueBinding) HandlerUtil.getVariable(event, Constants.SOURCES_ACTIVE_BINDING);
		final boolean ro = HandlerUtil.getVariable(event, Constants.SOURCES_ACTIVE_BINDING_RO) == Boolean.TRUE;
		final Clipboard clipboard = IManager.Factory.getManager().getClipboard();

		/*
		 * - Check that the cell can in fact be changed
		 */
		if (ro) {
			Display.getCurrent().beep();
			return null;
		}

		final Class<?> dataType = binding.getDataType().getDataType();

		/*
		 * - if a binding based transfer is attempted, then check that the data type of the cell can
		 * be assigned to from the type of the content
		 */
		Object content = clipboard.getContents(BindingTransfer.getInstance());
		if (content != null) {
			if (isAssignableFrom(dataType, content.getClass())) {
				final IObservable observable = binding.getModelObservable();
				if (observable instanceof IObservableValue) {
					((IObservableValue) observable).setValue(content);
				}
				if (observable instanceof IObservableList) {
					((IObservableList) observable).add(content);
				}

				return null;
			}
		}

		/*
		 * - otherwise attempt a text based assignment.
		 */
		content = clipboard.getContents(TextTransfer.getInstance());
		if (content != null) {
			final IBindingContext context = binding.getContext();

			final WritableValue ov = new WritableValue("", String.class);
			final IUIAttribute attribute = new SimpleUIAttribute(null, null, ov, true);
			final IValueBinding pasteBinding = context.addBinding().model(binding.getModelObservableValue())
					.ui(attribute);
			if (binding.hasArguments()) {
				pasteBinding.getExtraArgumentProviders().add(binding);
			}
			if (binding.eIsSet(IUIBindingsPackage.Literals.BINDING__EXTRA_ARGUMENT_PROVIDERS)) {
				pasteBinding.getExtraArgumentProviders().addAll(binding.getExtraArgumentProviders());
			}
			context.finish(FinishOption.FORCE);

			ov.setValue(content);
			// TODO check for errors and popup an info box
			pasteBinding.dispose();

			return null;
		}

		return null;
	}

	/**
	 * Mapping from the boxed type to the corresponding primitive type.
	 */
	private final Map<Class<?>, Class<?>> primitiveMap = new HashMap<Class<?>, Class<?>>();

	{
		primitiveMap.put(Integer.class, Integer.TYPE);
		primitiveMap.put(Boolean.class, Boolean.TYPE);
		primitiveMap.put(Character.class, Character.TYPE);
		primitiveMap.put(Byte.class, Byte.TYPE);
		primitiveMap.put(Short.class, Short.TYPE);
		primitiveMap.put(Long.class, Long.TYPE);
		primitiveMap.put(Float.class, Float.TYPE);
		primitiveMap.put(Double.class, Double.TYPE);
	}

	private boolean isAssignableFrom(Class<?> destination, Class<?> source) {
		if (destination.isAssignableFrom(source)) return true;
		if (destination.isPrimitive()) {
			final Class<?> s = primitiveMap.get(source);
			if (s != null && destination.isAssignableFrom(s)) return true;
		}

		return false;
	}
}
