package com.rcpcompany.uibindings.internal.validators.constraints;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.IDecoratorProvider;
import com.rcpcompany.uibindings.IJavaDecoratorProvider;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.internal.decorators.FileNameControlDecorator;
import com.rcpcompany.uibindings.validators.ConstraintValidatorAdapter.Message;
import com.rcpcompany.uibindings.validators.IConstraintValidatorAdapterConstraint;
import com.rcpcompany.uibindings.validators.IConstraintValidatorAdapterConstraintProvider;

public class FileNameControlConstraintProvider implements IConstraintValidatorAdapterConstraintProvider {

	@Override
	public IConstraintValidatorAdapterConstraint getConstraint(IValueBinding binding) {
		final IDecoratorProvider provider = binding.getDecoratorProvider();
		if (!(provider instanceof IJavaDecoratorProvider)) return null;
		final IUIBindingDecorator decorator = provider.getDecorator();
		if (!(decorator instanceof FileNameControlDecorator)) return null;
		final FileNameControlDecorator fnw = (FileNameControlDecorator) decorator;
		fnw.initForValidation(binding);
		return new FileNameConstraint(binding.getModelFeature(), fnw);
	}

	private static class FileNameConstraint implements IConstraintValidatorAdapterConstraint {
		private final EStructuralFeature myFeature;
		private final FileNameControlDecorator myDecorator;
		private final IValidator myValidator;

		/**
		 * Constructs and return a new constraint for the specified feature and decorator.
		 * 
		 * @param feature the feature in question
		 * @param decorator the decorator to use to perform the validation itself
		 */
		public FileNameConstraint(EStructuralFeature feature, FileNameControlDecorator decorator) {
			myFeature = feature;
			myDecorator = decorator;
			myValidator = decorator.getUIToModelAfterConvertValidator();
		}

		@Override
		public Message validate(EObject obj, IObservableList messages) {
			final Object value = obj.eGet(myFeature);
			if (value == null) return null;

			final IStatus status = myValidator.validate(value);
			if (status.isOK()) return null;

			/*
			 * Error found!! Check if the message is already present in the list
			 */
			for (final Object o : messages) {
				final Message f = (Message) o;
				if (f.getObject() == obj && f.getFeature() == myFeature && f.getMessage().equals(status.getMessage()))
					return f;
			}

			/*
			 * Create new message
			 */
			final Message f = new Message(obj, myFeature, status);
			messages.add(f);

			return f;
		}
	}
}
