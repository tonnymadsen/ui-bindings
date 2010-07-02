package com.rcpcompany.uibindings.navigator.internal.handlers;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;

import com.rcpcompany.uibindings.navigator.IEditorPartView;

/**
 * Handler fopr the "Pin Editor" command.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class PinEditorHandler extends AbstractHandler implements IHandler, IElementUpdater {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		final IEditorPartView view = (IEditorPartView) HandlerUtil.getActivePartChecked(event);

		view.setPinned(!view.isPinned());
		final ICommandService commandService = (ICommandService) window.getService(ICommandService.class);
		commandService.refreshElements(event.getCommand().getId(), null);
		return null;
	}

	@Override
	public void updateElement(UIElement element, Map parameters) {
		final IWorkbenchWindow window = (IWorkbenchWindow) element.getServiceLocator().getService(
				IWorkbenchWindow.class);
		if (window == null) return;
		final IWorkbenchPart part = window.getActivePage().getActivePart();
		if (part == null) return;
		if (!(part instanceof IEditorPartView)) return;

		final IEditorPartView view = (IEditorPartView) part;
		element.setChecked(view.isPinned());
	}
}
