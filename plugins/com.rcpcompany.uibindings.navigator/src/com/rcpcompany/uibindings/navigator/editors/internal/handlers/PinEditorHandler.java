package com.rcpcompany.uibindings.navigator.editors.internal.handlers;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IViewPart;
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
		final IEditorPartView view = (IEditorPartView) HandlerUtil.getActivePartChecked(event);

		view.setPinned(!view.isPinned());
		return null;
	}

	@Override
	public void updateElement(UIElement element, Map parameters) {
		final IViewPart viewpart = (IViewPart) element.getServiceLocator().getService(IViewPart.class);
		if (!(viewpart instanceof IEditorPartView)) return;

		final IEditorPartView view = (IEditorPartView) viewpart;
		element.setChecked(view.isPinned());
	}
}
