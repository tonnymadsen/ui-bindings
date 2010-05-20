package com.rcpcompany.uibindings.internal.decorators.extenders;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;

/**
 * Extender that will mark a binding as "default" if the model attribute is an unsettable primitive.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UnsettableExtender extends AbstractUIBindingDecoratorExtender {

	@Override
	public boolean isEnabled(IValueBinding binding) {
		final IBindingDataType dataType = binding.getDataType();
		return dataType.isUnsettable();
	}

	@Override
	public void extend(IUIBindingDecoratorExtenderContext context) {
		final IValueBinding binding = context.getBinding();
		final IBindingDataType dataType = binding.getDataType();
		if (!dataType.isUnsettable()) {
			return;
		}

		if (!dataType.getDataType().isPrimitive()) {
			return;
		}

		final EObject obj = binding.getModelObject();
		final EStructuralFeature feature = binding.getModelFeature();
		if (obj == null || feature == null) {
			return;
		}

		if (!obj.eIsSet(feature)) {
			context.setEnabled(false);
			context.setMessageFormat("Default");
		}
	}
}
