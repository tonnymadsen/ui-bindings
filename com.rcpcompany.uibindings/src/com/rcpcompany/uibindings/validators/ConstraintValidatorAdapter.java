/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.validators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IConstraintValidatorAdapterConstraintDescriptor;
import com.rcpcompany.uibindings.IDecoratorProvider;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingsFactory;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.ModelValueKind;
import com.rcpcompany.uibindings.bindingMessages.AbstractBindingMessage;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.uiAttributes.VirtualUIAttribute;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * This class provides an adapter interface between the constraint specified in the uibindings
 * extension point and {@link IValidatorAdapterManager}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ConstraintValidatorAdapter extends AbstractValidatorAdapter {
	/**
	 * A provider for a new constraint that can then be added to the constraints to be checked.
	 */
	public interface IConstraintProvider {

	}

	/**
	 * Map with all found constraints indexed by class. Extended ALAP in
	 * {@link #getConstraints(EObject)}.
	 */
	private final Map<EClass, List<IConstraintValidatorAdapterConstraint>> myConstraints = new HashMap<EClass, List<IConstraintValidatorAdapterConstraint>>();

	@Override
	public void validateObjectTree(EObject root, IObservableList messages) {
		final List<Message> toRemoveMessages = new ArrayList<Message>(messages);
		validateOneEObject(root, messages, toRemoveMessages);
		final TreeIterator<Object> iterator = EcoreUtil.getAllContents(root, false);
		for (; iterator.hasNext();) {
			final Object o = iterator.next();
			if (!(o instanceof EObject)) {
				continue;
			}
			validateOneEObject((EObject) o, messages, toRemoveMessages);
		}

		messages.removeAll(toRemoveMessages);
	}

	/**
	 * Validates the given object. Returns messages and possible messages to be removed.
	 * 
	 * @param obj the object to validate
	 * @param messages the list of current messages
	 * @param toRemoveMessages list of messages to be removed at the end of the validation
	 */
	private void validateOneEObject(final EObject obj, IObservableList messages, final List<Message> toRemoveMessages) {
		/*
		 * Find the constraints for this particular object
		 */
		final List<IConstraintValidatorAdapterConstraint> constraints = getConstraints(obj);
		if (constraints == null) return;
		for (final IConstraintValidatorAdapterConstraint c : constraints) {
			toRemoveMessages.remove(c.validate(obj, messages));
		}
	}

	/**
	 * Returns the list of constraints for the specified object or <code>null</code>.
	 * <p>
	 * If the class of the object has not been tested before, new constraints are constructed as
	 * needed.
	 * 
	 * @param obj the object to test
	 * @return the found constraints or <code>null</code>
	 */
	public List<IConstraintValidatorAdapterConstraint> getConstraints(EObject obj) {
		final EClass eClass = obj.eClass();
		if (myConstraints.containsKey(eClass)) return myConstraints.get(eClass);

		List<IConstraintValidatorAdapterConstraint> cs = new ArrayList<IConstraintValidatorAdapterConstraint>();

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

			/*
			 * Allow the user to turn off validation for specified feature
			 */
			if (!vb.getArgument(Constants.ARG_CONSTRAINTS_VALIDATE, Boolean.class, true)) {
				continue;
			}

			final IDecoratorProvider provider = manager.getProvider(vb.getModelType(), ModelValueKind.VALUE,
					String.class, vb.getType());
			vb.setDecoratorProvider(provider);
			for (final IConstraintValidatorAdapterConstraintDescriptor cpd : IManager.Factory.getManager()
					.getConstraintProviders()) {
				final IConstraintValidatorAdapterConstraintProvider cp = cpd.getProvider().getObject();
				try {
					final IConstraintValidatorAdapterConstraint c = cp.getConstraint(vb);
					if (c != null) {
						cs.add(c);
					}
				} catch (final Exception ex) {
					LogUtils.error(cpd.getProvider().getConfigurationElement(), ex);
				}
			}
			/*
			 * TODO Handle binding with ARG_VALID_VALUES
			 */
		}

		if (cs.size() == 0) {
			cs = null;
		}
		myConstraints.put(eClass, cs);
		return cs;
	}

	/**
	 * Message implementation for a constraint violation.
	 * 
	 * @author Tonny Madsen, The RCP Company
	 */
	public static class Message extends AbstractBindingMessage {
		public Message(EObject object, EStructuralFeature feature, String message, BindingMessageSeverity severity,
				int code) {
			super(null);
			myObject = object;
			myFeature = feature;
			myMessage = message;
			mySeverity = severity;
			myCode = code;
			addTarget(object, feature, null);
		}

		public Message(EObject object, EStructuralFeature feature, IStatus status) {
			super(null);
			myObject = object;
			myFeature = feature;
			myMessage = status.getMessage();
			switch (status.getSeverity()) {
			case IStatus.OK:
				mySeverity = BindingMessageSeverity.NONE;
				break;
			case IStatus.INFO:
				mySeverity = BindingMessageSeverity.INFORMATION;
				break;
			case IStatus.WARNING:
				mySeverity = BindingMessageSeverity.WARNING;
				break;
			case IStatus.ERROR:
				mySeverity = BindingMessageSeverity.ERROR;
				break;
			default:
				mySeverity = BindingMessageSeverity.NONE;
				break;
			}
			myCode = status.getCode();

			addTarget(object, feature, null);
		}

		private final EObject myObject;
		private final EStructuralFeature myFeature;
		private final String myMessage;
		private final BindingMessageSeverity mySeverity;
		private final int myCode;

		@Override
		public String getSource() {
			return Activator.ID;
		}

		@Override
		public int getCode() {
			return myCode;
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
			if (!matches(getObject(), getFeature(), null, FeatureMatchingAlgorithm.EXACT)) return false;
			if (otherMessage.getSeverity() != getSeverity()) return false;
			if (getSource() != null && !getSource().equals(otherMessage.getSource())) return false;
			if (otherMessage.getCode() != getCode()) return false;

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
