package com.rcpcompany.uibindings.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.utils.BindingTransfer;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Handler for org.eclipse.ui.edit.copy for within {@link IViewerBinding}...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerCopyHandler extends AbstractHandler implements IHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (Activator.getDefault().TRACE_HANDLERS) {
			LogUtils.debug(this, "");
		}
		final Object cellObject = HandlerUtil.getVariableChecked(event, Constants.SOURCES_ACTIVE_BINDING_VALUE);
		final String cellDisplayText = (String) HandlerUtil.getVariableChecked(event,
				Constants.SOURCES_ACTIVE_BINDING_VALUE_DISPLAY);

		final Clipboard clipboard = IManager.Factory.getManager().getClipboard();

		/*
		 * TextTransfer does not allow for empty strings...
		 */
		if (cellDisplayText == null || cellDisplayText.length() == 0) {
			clipboard.setContents(new Object[] { cellObject }, new Transfer[] { BindingTransfer.getInstance() });
		} else {
			clipboard.setContents(new Object[] { cellDisplayText, cellObject },
					new Transfer[] { TextTransfer.getInstance(), BindingTransfer.getInstance() });
		}

		return null;
	}
}
