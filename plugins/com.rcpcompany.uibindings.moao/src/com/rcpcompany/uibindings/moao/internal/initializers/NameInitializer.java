package com.rcpcompany.uibindings.moao.internal.initializers;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;

import com.rcpcompany.uibindings.IInitializer;
import com.rcpcompany.uibindings.IInitializerContext;
import com.rcpcompany.uibindings.moao.INamedObject;
import com.rcpcompany.uibindings.utils.IBindingObjectInformation;

/**
 * Initializer for {@link INamedObject#getName()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class NameInitializer implements IInitializer {
	private static int lastNo = 0;

	@Override
	public void initialize(IInitializerContext context, Object facet) {
		final EObject obj = context.getObject();
		final EStructuralFeature sf = (EStructuralFeature) facet;
		final String label = IBindingObjectInformation.Factory.getLabel(obj.eClass());

		// TODO: possibly use validValues to check for exiting objects

		final Command cmd = SetCommand.create(context.getEditingDomain(), obj, sf, label + (lastNo++));
		context.addCommand(cmd);
	}
}
