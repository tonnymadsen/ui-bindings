package com.rcpcompany.uibindings.items;

import java.util.Collections;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.IViewerItemDeletor;
import com.rcpcompany.uibindings.IViewerItemDeletorContext;

/**
 * Generic deletor for items in viewers.
 * <p>
 * The fnction of the deletor depends on the data type of the viewer binding. If the binding is
 * based on a structural feature and this feature is a containment EMF reference the deletor will
 * remove the deleted object from all non-containment relation as well as from the parent relation.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GenericDeletor implements IViewerItemDeletor, IExecutableExtension {

	@Override
	public void deleteItem(IViewerItemDeletorContext context) {
		final IViewerBinding binding = context.getViewerBinding();
		final EObject object = context.getObject();
		final IObservableList list = context.getList();

		boolean containment = false;

		final Object type = binding.getDataType().getValueType();
		if (type instanceof EReference) {
			final EReference sf = (EReference) type;
			if (sf.isContainment()) {
				containment = true;
			}
		}

		if (!containment) {
			// Use the exiting databinding as we cannot find the parent
			if (!context.getTestOnly()) {
				list.remove(object);
			}
		} else {
			final EditingDomain domain = binding.getEditingDomain();
			final Command cmd = domain.createCommand(DeleteCommand.class, new CommandParameter(object.eContainer(),
					type, Collections.singleton(object)));
			if (!context.getTestOnly()) {
				domain.getCommandStack().execute(cmd);
			}
		}
	}

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {

	}
}
