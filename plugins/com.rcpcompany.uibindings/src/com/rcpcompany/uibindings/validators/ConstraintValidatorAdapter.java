package com.rcpcompany.uibindings.validators;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IDecoratorProvider;
import com.rcpcompany.uibindings.IJavaDecoratorProvider;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.INumberDecoratorProvider;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IUIBindingsFactory;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.bindingMessages.AbstractBindingMessage;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.decorators.FileNameWidgetDecorator;
import com.rcpcompany.uibindings.internal.decorators.NumberBindingDecorator;
import com.rcpcompany.uibindings.uiAttributes.VirtualUIAttribute;

/**
 * This class provides an adapter interface between the constraint specified in the uibindings extension point and
 * {@link IValidatorAdapterManager}
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ConstraintValidatorAdapter extends AbstractValidatorAdapter {
	/**
	 * The full description of a single constraint.
	 * <p>
	 * Created in {@link ConstraintValidatorAdapter#getConstraints(EObject)}.
	 */
	public interface IConstraint {
		/**
		 * Validates the specified object against this constraint.
		 * <p>
		 * If the validation fails a new message is added to the messages list - if not already present - and (whether
		 * it existed already or not) returned.
		 * 
		 * @param obj the object to validate
		 * @param messages the list of current messages
		 * @return the message for the validation if it failed
		 */
		public Message validate(EObject obj, IObservableList messages);
	}

	/**
	 * Map with all found constraints indexed by class. Extended ALAP in {@link #getConstraints(EObject)}.
	 */
	protected Map<EClass, List<IConstraint>> myConstraints = new HashMap<EClass, List<IConstraint>>();

	@Override
	public void validateObjectTree(EObject root, IObservableList messages) {
		final TreeIterator<Object> iterator = EcoreUtil.getAllContents(root, false);
		final List<Message> toRemoveMessages = new ArrayList<Message>(messages);
		for (; iterator.hasNext();) {
			final Object o = iterator.next();
			if (!(o instanceof EObject)) {
				continue;
			}
			final EObject obj = (EObject) o;
			/*
			 * Find the constraints for this particular object
			 */
			final List<IConstraint> constraints = getConstraints(obj);
			if (constraints == null) {
				continue;
			}
			for (final IConstraint c : constraints) {
				toRemoveMessages.remove(c.validate(obj, messages));
			}
		}

		messages.removeAll(toRemoveMessages);
	}

	/**
	 * Returns the list of constraints for the specified object or <code>null</code>.
	 * <p>
	 * If the class of the object has not been tested before, new constraints are constructed as needed.
	 * 
	 * @param obj the object to test
	 * @return the found constraints or <code>null</code>
	 */
	public List<IConstraint> getConstraints(EObject obj) {
		final EClass eClass = obj.eClass();
		if (myConstraints.containsKey(eClass)) {
			return myConstraints.get(eClass);
		}

		List<IConstraint> cs = new ArrayList<IConstraint>();

		final IManager manager = IManager.Factory.getManager();
		for (final EStructuralFeature sf : eClass.getEAllStructuralFeatures()) {
			/*
			 * Forget about -to-many features...
			 */
			if ((sf.getUpperBound() > 1) || (sf.getUpperBound() == -1)) {
				continue;
			}

			/*
			 * We temporary create a new value binding (needed for the argument handling).
			 */
			final IValueBinding vb = IUIBindingsFactory.eINSTANCE.createValueBinding();
			vb.model(obj, sf).ui(new VirtualUIAttribute(String.class));

			final IDecoratorProvider provider = manager.getProvider(vb.getModelType(), String.class, vb.getType());
			vb.setDecoratorProvider(provider);
			if (provider instanceof INumberDecoratorProvider) {
				/*
				 * So we have a number decoration...
				 */
				final NumberBindingDecorator decorator = (NumberBindingDecorator) provider.getDecorator();

				decorator.initForValidation(vb);
				if (!decorator.isLimitsSet()) {
					continue;
				}
				cs.add(new NumberConstraint(sf, decorator));
			} else if (provider instanceof IJavaDecoratorProvider) {
				final IUIBindingDecorator decorator = provider.getDecorator();
				if (decorator instanceof FileNameWidgetDecorator) {
					final FileNameWidgetDecorator fnw = (FileNameWidgetDecorator) decorator;
					fnw.initForValidation(vb);
					cs.add(new FileNameConstraint(sf, fnw));
				}
			}
		}

		if (cs.size() == 0) {
			cs = null;
		}
		myConstraints.put(eClass, cs);
		return cs;
	}

	/**
	 * Construct to handle number range based violations
	 */
	public static class NumberConstraint implements IConstraint {

		private final EStructuralFeature myFeature;
		private final NumberBindingDecorator myDecorator;

		/**
		 * Constructs and return a new constraint for the specified feature and decorator
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
			if (value == null) {
				return null;
			}

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
			if (m == null) {
				return null;
			}

			/*
			 * Error found!! Check if the message is already present in the list
			 */
			for (final Object o : messages) {
				final Message f = (Message) o;
				if (f.getObject() == obj && f.getFeature() == myFeature && f.getMessage().equals(m)) {
					return f;
				}
			}

			/*
			 * Create new message
			 */
			final Message f = new Message(obj, myFeature, m, BindingMessageSeverity.ERROR);
			messages.add(f);

			return f;
		}
	}

	/**
	 * Construct to handle file name based violations
	 */
	public static class FileNameConstraint implements IConstraint {

		private final EStructuralFeature myFeature;
		private final FileNameWidgetDecorator myDecorator;

		/**
		 * Constructs and return a new constraint for the specified feature and decorator
		 * 
		 * @param feature the feature in question
		 * @param decorator the decorator to use to perform the validationitself
		 */
		public FileNameConstraint(EStructuralFeature feature, FileNameWidgetDecorator decorator) {
			myFeature = feature;
			myDecorator = decorator;
		}

		@Override
		public Message validate(EObject obj, IObservableList messages) {
			final Object value = obj.eGet(myFeature);
			if (value == null) {
				return null;
			}

			final String m = myDecorator.checkValue(value);
			if (m == null) {
				return null;
			}

			/*
			 * Error found!! Check if the message is already present in the list
			 */
			for (final Object o : messages) {
				final Message f = (Message) o;
				if (f.getObject() == obj && f.getFeature() == myFeature && f.getMessage().equals(m)) {
					return f;
				}
			}

			/*
			 * Create new message
			 */
			final Message f = new Message(obj, myFeature, m, BindingMessageSeverity.ERROR);
			messages.add(f);

			return f;
		}
	}

	/**
	 * Message implementation for a constraint violation.
	 * 
	 * @author Tonny Madsen, The RCP Company
	 */
	private static class Message extends AbstractBindingMessage {
		public Message(EObject object, EStructuralFeature feature, String message, BindingMessageSeverity severity) {
			super(null);
			myObject = object;
			myFeature = feature;
			myMessage = message;
			mySeverity = severity;
			addTarget(object, feature, null);
		}

		private final EObject myObject;
		private final EStructuralFeature myFeature;
		private final String myMessage;
		private final BindingMessageSeverity mySeverity;

		@Override
		public String getSource() {
			return Activator.ID;
		}

		@Override
		public int getCode() {
			return NumberBindingDecorator.NUMBER_ERROR_CODE;
		}

		@Override
		public String getMessage() {
			return myMessage;
		}

		@Override
		public BindingMessageSeverity getSeverity() {
			return mySeverity;
		}

		@Override
		public boolean supersedes(IBindingMessage otherMessage) {
			if (!matches(getObject(), getFeature(), null, FeatureMatchingAlgorithm.EXACT)) {
				return false;
			}
			if (otherMessage.getSeverity() != getSeverity()) {
				return false;
			}
			if (getSource() == null || getSource().equals(otherMessage.getSource())) {
				return false;
			}
			if (otherMessage.getCode() != getCode()) {
				return false;
			}

			return true;
		}

		public EObject getObject() {
			return myObject;
		}

		public EStructuralFeature getFeature() {
			return myFeature;
		}
	}
}
