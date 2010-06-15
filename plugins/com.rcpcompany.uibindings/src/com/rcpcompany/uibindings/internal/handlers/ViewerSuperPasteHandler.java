package com.rcpcompany.uibindings.internal.handlers;

import java.util.Arrays;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.HTMLTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.Activator;
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
		final boolean ro = HandlerUtil.getVariable(event, Constants.SOURCES_ACTIVE_BINDING_RO) == Boolean.TRUE;
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
					"Data format of the pasted data is not supported by SIMA");
			return null;
		}
		LogUtils.debug(this, "result: " + Arrays.toString(result));

		/*
		 * - Check that the cell can in fact be changed
		 */
		if (ro) {
			Display.getCurrent().beep();
			return null;
		}
		//
		// final IColumnBindingCellInformation ci;
		// final Class<?> dataType = binding.getDataType().getDataType();
		//
		// /*
		// * - if a binding based transfer is attempted, then check that the data type of the cell
		// can be assigned to
		// from
		// * the type of the content
		// */
		// Object content = clipboard.getContents(BindingTransfer.getInstance());
		// if (content != null) {
		// if (isAssignableFrom(dataType, content.getClass())) {
		// final IObservable observable = binding.getModelObservable();
		// if (observable instanceof IObservableValue) {
		// ((IObservableValue) observable).setValue(content);
		// }
		// if (observable instanceof IObservableList) {
		// ((IObservableList) observable).add(content);
		// }
		//
		// return null;
		// }
		// }
		//
		// /*
		// * - otherwise attempt a text based assignment.
		// */
		// content = clipboard.getContents(TextTransfer.getInstance());
		// if (content != null) {
		// final IBindingContext context = binding.getContext();
		//
		// final WritableValue ov = new WritableValue("", String.class);
		// final IUIAttribute attribute = new SimpleUIAttribute(null, null, ov, true);
		// final IValueBinding pasteBinding =
		// context.addBinding().model(binding.getModelObservableValue()).ui(
		// attribute).args(binding.getArguments());
		// context.finish(FinishOption.FORCE);
		//
		// ov.setValue(content);
		// // TODO check for errors and popup an info box
		// pasteBinding.dispose();
		//
		// return null;
		// }

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
