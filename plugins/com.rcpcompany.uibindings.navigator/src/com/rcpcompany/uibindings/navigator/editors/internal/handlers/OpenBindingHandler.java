package com.rcpcompany.uibindings.navigator.editors.internal.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorModelFactory;
import com.rcpcompany.utils.selection.SelectionUtils;

/**
 * Handler for <code>com.rcpcompany.uibindings.commands.openBinding</code>.
 * <p>
 * Only active for {@link EObject} with a {@link IEditorPartDescriptor}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class OpenBindingHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);

		final List<EObject> list = SelectionUtils.computeSelection(selection, EObject.class);

		for (final EObject o : list) {
			INavigatorModelFactory.eINSTANCE.getManager().getView(o);
		}
		return null;
	}

}
