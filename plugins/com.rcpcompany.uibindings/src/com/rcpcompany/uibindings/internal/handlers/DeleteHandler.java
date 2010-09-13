package com.rcpcompany.uibindings.internal.handlers;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler2;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.IViewerBinding.IElementParentage;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.utils.UIBEcoreUtils;
import com.rcpcompany.utils.logging.LogUtils;
import com.rcpcompany.utils.selection.SelectionUtils;

/**
 * Deletes the current object in a viewer.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DeleteHandler extends AbstractHandler implements IHandler2 {
	@Override
	public Object execute(ExecutionEvent ee) throws ExecutionException {
		if (Activator.getDefault().TRACE_HANDLERS) {
			LogUtils.debug(this, "");
		}
		// The binding
		final IBinding bb = (IBinding) HandlerUtil.getVariableChecked(ee, Constants.SOURCES_ACTIVE_CONTAINER_BINDING);
		if (!(bb instanceof IViewerBinding)) return null;
		// The viewer
		final IViewerBinding vb = (IViewerBinding) bb;

		final Command cmd = createCommand(vb);
		/*
		 * Execute if possible... TODO return value
		 */
		if (!cmd.canExecute()) return null;

		final ISelection s = vb.getViewer().getSelection();

		final List<EObject> list = SelectionUtils.computeSelection(s, EObject.class);
		final Map<EObject, Collection<Setting>> references = UIBEcoreUtils.findIncommingRequiredReferences(list);
		if (references != null) {
			UIBEcoreUtils.showErrorDialog("Cannot delete the selected objects", references);
			return null;
		}

		LogUtils.debug(this, "execute");

		vb.getEditingDomain().getCommandStack().execute(cmd);

		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		if (!(evaluationContext instanceof IEvaluationContext)) return;
		final IEvaluationContext context = (IEvaluationContext) evaluationContext;

		// The binding
		final IBinding bb = (IBinding) context.getVariable(Constants.SOURCES_ACTIVE_CONTAINER_BINDING);
		if (!(bb instanceof IViewerBinding)) {
			setBaseEnabled(false);
			return;
		}
		// The viewer
		final IViewerBinding vb = (IViewerBinding) bb;

		final Command cmd = createCommand(vb);
		/*
		 * Execute if possible...
		 */
		if (!cmd.canExecute()) {
			setBaseEnabled(false);
			return;
		}

		final ISelection s = vb.getViewer().getSelection();

		final List<EObject> list = SelectionUtils.computeSelection(s, EObject.class);
		final Map<EObject, Collection<Setting>> references = UIBEcoreUtils.findIncommingRequiredReferences(list);
		if (references != null) {
			setBaseEnabled(false);
			return;
		}

		setBaseEnabled(true);
	}

	@Override
	protected void setBaseEnabled(boolean state) {
		super.setBaseEnabled(state);

		LogUtils.debug(this, "" + state);
	}

	/**
	 * Creates and returns a command that can delete the current objects of the specified viewer.
	 * 
	 * @param vb the viewer binding
	 * @return the command that will delete the current objects or <code>null</code>
	 */
	public static Command createCommand(IViewerBinding vb) {
		// Then find the selected objects
		final ISelection s = vb.getViewer().getSelection();

		final List<EObject> list = SelectionUtils.computeSelection(s, EObject.class);
		if (list.size() == 0) return null;

		final EditingDomain domain = vb.getEditingDomain();
		final CompoundCommand cc = new CompoundCommand();
		for (final EObject element : list) {
			/*
			 * Find the parentage for the element. Especially important - and difficult - for trees.
			 */
			final IElementParentage ep = vb.getElementParentage(element);
			if (ep == null) {
				continue;
			}
			final EObject parent = ep.getParent();
			final EReference ref = ep.getReference();
			if (parent == null || ref == null) {
				continue;
			}

			Command cmd = null;
			if (ref.isContainment()) {
				cmd = DeleteCommand.create(domain, element);
			} else {
				cmd = RemoveCommand.create(domain, parent, ref, element);
			}
			cc.append(cmd);
		}
		return cc.unwrap();
	}
}
