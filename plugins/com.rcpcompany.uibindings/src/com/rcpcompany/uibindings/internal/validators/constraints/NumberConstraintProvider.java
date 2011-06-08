package com.rcpcompany.uibindings.internal.validators.constraints;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.IDecoratorProvider;
import com.rcpcompany.uibindings.INumberDecoratorProvider;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.internal.decorators.NumberBindingDecorator;
import com.rcpcompany.uibindings.validators.ConstraintValidatorAdapter.Message;
import com.rcpcompany.uibindings.validators.IConstraintValidatorAdapterConstraint;
import com.rcpcompany.uibindings.validators.IConstraintValidatorAdapterConstraintProvider;

public class NumberConstraintProvider implements IConstraintValidatorAdapterConstraintProvider {

	@Override
	public IConstraintValidatorAdapterConstraint getConstraint(IValueBinding binding) {
		final IDecoratorProvider provider = binding.getDecoratorProvider();
		if (!(provider instanceof INumberDecoratorProvider)) return null;
		/*
		 * So we have a number decoration...
		 */
		final NumberBindingDecorator decorator = (NumberBindingDecorator) provider.getDecorator();

		decorator.initForValidation(binding);
		if (!decorator.isLimitsSet()) return null;
		return new NumberConstraint(binding.getModelFeature(), decorator);
	}

	/**
	 * Construct to handle number range based violations.
	 */
	private static class NumberConstraint implements IConstraintValidatorAdapterConstraint {
		private final EStructuralFeature myFeature;
		private final NumberBindingDecorator myDecorator;

		/**
		 * Constructs and return a new constraint for the specified feature and decorator.
		 * 
		 * @param feature the feature in question
		 * @param decorator the decorator to use to perform the validationitself
		 */
		public NumberConstraint(EStructuralFeature feature, NumberBindingDecorator decorator) {
			myFeature = feature;
			myDecorator = decorator;
		}

		@Override
		public Message validate(EObject obj, IObservableList messages) {
			final Object value = obj.eGet(myFeature);
			if (value == null) return null;

			final Class<?> c = value.getClass();
			BigDecimal d = null;

			if (c == Byte.class || c == Byte.TYPE) {
				d = new BigDecimal((Byte) value);
			} else if (c == Short.class || c == Short.TYPE) {
				d = new BigDecimal((Short) value);
			} else if (c == Integer.class || c == Integer.TYPE) {
				d = new BigDecimal((Integer) value);
			} else if (c == Long.class || c == Long.TYPE) {
				d = new BigDecimal((Long) value);
			} else if (c == Float.class || c == Float.TYPE) {
				d = new BigDecimal((Float) value);
			} else if (c == Double.class || c == Double.TYPE) {
				d = new BigDecimal((Double) value);
			} else if (c == BigDecimal.class) {
				d = (BigDecimal) value;
			} else if (c == BigInteger.class) {
				d = new BigDecimal((BigInteger) value);
			}

			final String m = myDecorator.checkRange(value, d);
			if (m == null) return null;

			/*
			 * Error found!! Check if the message is already present in the list
			 */
			for (final Object o : messages) {
				final Message f = (Message) o;
				if (f.getObject() == obj && f.getFeature() == myFeature && f.getMessage().equals(m)) return f;
			}

			/*
			 * Create new message
			 */
			final Message f = new Message(obj, myFeature, m, BindingMessageSeverity.ERROR,
					NumberBindingDecorator.NUMBER_ERROR_CODE);
			messages.add(f);

			return f;
		}
	}
}
