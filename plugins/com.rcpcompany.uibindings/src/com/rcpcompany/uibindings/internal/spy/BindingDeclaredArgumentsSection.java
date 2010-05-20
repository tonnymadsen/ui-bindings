package com.rcpcompany.uibindings.internal.spy;

import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.SWT;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingSpySection;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Section for the services of the binding.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingDeclaredArgumentsSection implements IBindingSpySection {
	@Override
	public void build(IFormCreator creator, ExecutionEvent event) {
		final IBinding b = (IBinding) creator.getObject();

		if (!b.eIsSet(IUIBindingsPackage.Literals.ARGUMENT_PROVIDER__DECLARED_ARGUMENTS)) {
			return;
		}

		final IFormCreator subform = creator.addSection("Declared Arguments");

		for (final Map.Entry<String, Object> e : b.getDeclaredArguments()) {
			subform.addConstantField(e.getKey() + ":", e.getValue(), SWT.NONE);
		}
	}
}
