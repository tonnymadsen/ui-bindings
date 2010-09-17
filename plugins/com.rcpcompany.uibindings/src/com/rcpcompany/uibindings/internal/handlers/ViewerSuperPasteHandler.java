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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.HTMLTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IContainerBinding;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IValueBindingCell;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Handler for org.eclipse.ui.edit.paste for within {@link IViewerBinding}...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerSuperPasteHandler extends AbstractHandler implements IHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (Activator.getDefault().TRACE_HANDLERS) {
			LogUtils.debug(this, "");
		}
		final IValueBinding binding = (IValueBinding) HandlerUtil.getVariable(event, Constants.SOURCES_ACTIVE_BINDING);
		final IBindingContext context = binding.getContext();

		final Clipboard clipboard = IManager.Factory.getManager().getClipboard();

		LogUtils.debug(this, "Available Types: " + Arrays.toString(clipboard.getAvailableTypeNames()));
		String[][] result = null;
		if (result == null) {
			result = convertHTML((String) clipboard.getContents(HTMLTransfer.getInstance()));
		}
		if (result == null) {
			result = convertTSV((String) clipboard.getContents(TextTransfer.getInstance()));
		}

		if (result == null) {
			MessageDialog.openError(HandlerUtil.getActiveShell(event), "Cannot paste data",
					"Data format of the pasted data is not supported");
			return null;
		}
		if (result.length == 0) {
			MessageDialog.openError(HandlerUtil.getActiveShell(event), "Cannot paste data", "No data to paste");
			return null;
		}

		for (final String[] l : result) {
			LogUtils.debug(this, "line: " + Arrays.toString(l));
		}

		final int rows = result.length;
		final int columns = result[0].length;

		/*
		 * Check that we have room for the paste...
		 */
		final IContainerBinding container = binding.getCell().getContainer();
		final Point p = binding.getCell().getPosition(true);
		if (p == null) {
			MessageDialog.openError(HandlerUtil.getActiveShell(event), "Cannot paste data",
					"Can only paste into a viewer");
			return null;
		}

		final Map<IValueBinding, String> assignmentMap = new HashMap<IValueBinding, String>();
		try {
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < columns; c++) {
					final String data = result[r][c];

					final IValueBindingCell cell = container.getCell(p.x + c, p.y + r, true);
					if (cell == null) {
						MessageDialog.openError(HandlerUtil.getActiveShell(event), "Cannot paste data",
								"No room for data");
						return null;
					}
					final IValueBinding b = cell.getLabelBinding();
					if (!b.isChangeable()) {
						MessageDialog.openError(HandlerUtil.getActiveShell(event), "Cannot paste data",
								"Target cell is not changeable");
						cell.setFocus();
						return null;
					}

					/*
					 * Make a new paste binding and add this to the assignmentMap...
					 */
					final WritableValue ov = new WritableValue("", String.class);
					final IUIAttribute attribute = new SimpleUIAttribute(null, null, ov, true);
					final IValueBinding pasteBinding = context.addBinding().model(b.getModelObservableValue())
							.ui(attribute);
					if (binding.hasArguments()) {
						pasteBinding.getExtraArgumentProviders().add(b);
					}
					if (binding.eIsSet(IUIBindingsPackage.Literals.BINDING__EXTRA_ARGUMENT_PROVIDERS)) {
						pasteBinding.getExtraArgumentProviders().addAll(b.getExtraArgumentProviders());
					}

					assignmentMap.put(pasteBinding, data);
				}
			}

			/*
			 * Assign all values
			 */
			for (final Entry<IValueBinding, String> d : assignmentMap.entrySet()) {
				d.getKey().getUIAttribute().getCurrentValue().setValue(d.getValue());
			}
		} finally {
		}

		return null;
	}

	/**
	 * Converts Tab-Separated-Values to String[][].
	 * 
	 * @param contents the String to convert
	 * @return the result or <code>null</code>
	 */
	private String[][] convertTSV(String contents) {
		if (contents == null) return null;
		while (contents.endsWith("\n")) {
			contents = contents.substring(0, contents.length() - 1);
		}
		contents = contents.replace("\r", "");
		LogUtils.debug(this, "s='" + contents + "'");
		final String[] lines = contents.split("\n");
		final int noLines = lines.length;
		LogUtils.debug(this, "# " + noLines);
		final String[][] result = new String[noLines][0];
		for (int i = 0; i < lines.length; i++) {
			result[i] = lines[i].split("\t");
		}
		return result;
	}

	/**
	 * Converts HTML to String[][].
	 * 
	 * @param contents the String to convert
	 * @return the result or <code>null</code>
	 */
	private String[][] convertHTML(String contents) {
		if (contents == null) return null;
		LogUtils.debug(this, "s='" + contents + "'");
		return null;
	}
}
