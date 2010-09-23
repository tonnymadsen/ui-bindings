/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.bindingMessages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IBindingMessage.FeatureMatchingAlgorithm;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IQuickfixProposal;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.Messages;
import com.rcpcompany.uibindings.internal.bindingMessages.messageAdapters.DataBindingDecoratorMessageObservableValue;
import com.rcpcompany.uibindings.internal.observables.DelayedChangeEvent;
import com.rcpcompany.uibindings.internal.observables.IDelayedChangeListener;
import com.rcpcompany.uibindings.internal.observables.IDelayedChangeObservable;
import com.rcpcompany.uibindings.internal.observables.TextObservableValue;
import com.rcpcompany.uibindings.observables.IKeyedObservable;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;
import com.rcpcompany.uibindings.validators.IValidatorAdapterMessageDecorator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Message decorator for {@link IValueBinding} objects.
 * <p>
 * One of these exists for each {@link IValueBinding} object so some care must be taken to limit the
 * amount of data in the object.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ValueBindingMessageImageDecorator extends AdapterImpl implements IDisposable, IContextMessageProvider,
		IValidatorAdapterMessageDecorator, Adapter, IChangeListener, IDelayedChangeListener {

	/**
	 * Extender for {@link ValueBindingMessageImageDecorator}.
	 */
	public static class Extender extends AbstractUIBindingDecoratorExtender implements IUIBindingDecoratorExtender {

		@Override
		public void extend(IUIBindingDecoratorExtenderContext context) {
			final IValueBinding binding = context.getBinding();
			ValueBindingMessageImageDecorator data = binding.getService(ValueBindingMessageImageDecorator.class);
			if (data == null) {
				data = new ValueBindingMessageImageDecorator(binding);
			}

			data.extend(context);
		}
	}

	/**
	 * The {@link IValueBinding value binding} of this decorator.
	 */
	private final IValueBinding myBinding;

	/**
	 * Constructs and returns a new decorator.
	 * 
	 * @param binding the value binding
	 */
	public ValueBindingMessageImageDecorator(IValueBinding binding) {
		myBinding = binding;
		myObservedObject = getBinding().getModelObject();

		init();
	}

	/**
	 * Completes the initialization of this message decorator. Only invoked when the state of the
	 * binding is OK.
	 */
	protected void init() {
		if (getBinding().getState() != BindingState.OK) {
			/*
			 * If not in state OK, then wait until we get there...
			 */
			getBinding().eAdapters().add(this);
			return;
		}
		Assert.isTrue(getBinding().getState() == BindingState.OK);
		if (Activator.getDefault().TRACE_LIFECYCLE_VALUE_BINDING_MESSAGE_DECORATOR) {
			LogUtils.debug(this, "init " + hashCode() + ": " + getBinding()); //$NON-NLS-1$ //$NON-NLS-2$
		}

		getBinding().registerService(this);
		final IObservableValue observable = getBinding().getUIObservable();
		observable.addChangeListener(this);
		if (observable instanceof IDelayedChangeObservable) {
			((IDelayedChangeObservable) observable).addDelayedChangeListener(this);
		}

		/*
		 * The list change listener will ensure that the change listener is added to all the message
		 * providers
		 */
		final List<Binding> bindings = getBinding().getMonitoredDBBindings();
		myMessageProviders = new IObservableValue[bindings.size()];
		for (int i = 0; i < bindings.size(); i++) {
			// TODO TMTM reduce the extra observable!
			myMessageProviders[i] = new DataBindingDecoratorMessageObservableValue(getBinding(), bindings.get(i));
			myMessageProviders[i].addChangeListener(this);
		}

		/*
		 * Register this decorator with the ValidatorAdapterManager.
		 */
		VALIDATION_MANAGER.addDecorator(this);

		/*
		 * Add ourself as a message decorator to the context if present
		 */
		final ContextMessageDecorator contextMessageDecorator = myBinding.getContext().getService(
				ContextMessageDecorator.class);
		if (contextMessageDecorator != null) {
			contextMessageDecorator.addMessageProvider(this);
		}

		/*
		 * Register for configuration changes
		 */
		IManager.Factory.getManager().eAdapters().add(this);
	}

	/**
	 * Disposes of this binding message decoration.
	 */
	@Override
	public void dispose() {
		/*
		 * Cancel any outstanding update...
		 */
		updateDecorationScheduled = false;

		VALIDATION_MANAGER.removeDecorator(this);

		final IObservableValue observable = getBinding().getUIObservable();
		observable.removeChangeListener(this);
		if (observable instanceof IDelayedChangeObservable) {
			((IDelayedChangeObservable) observable).removeDelayedChangeListener(this);
		}
		getBinding().unregisterService(this);

		/*
		 * Clear all messages and update the context decorator...
		 */
		myMessagesOL.clear();

		// Remove all listeners
		for (final Object v : myMessageProviders) {
			((IObservableValue) v).removeChangeListener(this);
		}
		myMessageProviders = null;
		final ContextMessageDecorator contextMessageDecorator = myBinding.getContext().getService(
				ContextMessageDecorator.class);
		if (contextMessageDecorator != null) {
			contextMessageDecorator.removeMessageProvider(this);
		}
		IManager.Factory.getManager().eAdapters().remove(this);
		if (Activator.getDefault().TRACE_LIFECYCLE_VALUE_BINDING_MESSAGE_DECORATOR) {
			LogUtils.debug(this, "dispose " + hashCode() + ": " + getBinding()); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	@Override
	public void notifyChanged(Notification msg) {
		if (msg.isTouch()) return;

		/*
		 * React to change is the configuration used by this decorator.
		 */
		if ((msg.getFeature() == IUIBindingsPackage.Literals.MANAGER__MESSAGE_DECORATION_POSITION)
				|| (msg.getFeature() == IUIBindingsPackage.Literals.MANAGER__ALTERNATIVE_DECORATION_POSITION)
				|| (msg.getFeature() == IUIBindingsPackage.Literals.MANAGER__MESSAGE_DECORATION_MINIMUM_SEVERITY)
				|| (msg.getFeature() == IUIBindingsPackage.Literals.MANAGER__REQUIRED_VB_IMAGE_DECORATION_SHOWN)
				|| (msg.getFeature() == IUIBindingsPackage.Literals.MANAGER__ASSIST_VB_IMAGE_DECORATION_SHOWN)
				|| (msg.getFeature() == IUIBindingsPackage.Literals.MANAGER__QUICKFIX_VB_IMAGE_DECORATION_SHOWN)) {
			updateDecoration();
			return;
		}
		/*
		 * When the state of the underlying binding changes to OK or DISPOSED, then react to this.
		 */
		if (msg.getFeature() == IUIBindingsPackage.Literals.BINDING__STATE) {
			switch (getBinding().getState()) {
			case OK:
				init();
				//$FALL-THROUGH$ fallthrough
			case DISPOSED:
				getBinding().eAdapters().remove(this);
				break;
			default:
				break;
			}
			return;
		}
	}

	/**
	 * Common change listener used to update the decoration whenever any of the individual elements
	 * of {@link #myMessageProviders} is changed.
	 */
	@Override
	public void handleChange(ChangeEvent event) {
		updateDecoration();
	}

	/**
	 * Common change listener used to update the decoration whenever changes are initiated for the
	 * UI Observable. See {@link TextObservableValue} for more information.
	 */
	@Override
	public void handleDelayedChange(DelayedChangeEvent event) {
		updateDecoration();
	}

	@Override
	public IValueBinding getBinding() {
		return myBinding;
	}

	/**
	 * Array with all the added message providers for this messages decorator.
	 * <p>
	 * The list elements are observable values that returns an {@link IBindingMessage} or
	 * <code>null</code>.
	 * <p>
	 * The array is static - once it is created, it does not change.
	 */
	private IObservableValue[] myMessageProviders = null;

	/**
	 * The current list of outstanding messages for this decorator.
	 * <p>
	 * These messages comes from the outside. The party that adds a message must also remove it
	 * again.
	 * 
	 * @see #addMessage(IBindingMessage)
	 * @see #removeMessage(IBindingMessage)
	 */
	private final List<IBindingMessage> myOutstandingMessages = new ArrayList<IBindingMessage>();

	/**
	 * The current list of shown messages for this decorator.
	 * <p>
	 * The messages all have the same message type.
	 */
	private final List<IBindingMessage> myMessages = new ArrayList<IBindingMessage>();

	@Override
	public IObservableList getMessages() {
		return myMessagesOL;
	}

	private final IObservableList myMessagesOL = new WritableList(myMessages, IBindingMessage.class);

	@Override
	public void addMessage(IBindingMessage message) {
		if (Activator.getDefault().TRACE_LIFECYCLE_VALUE_BINDING_MESSAGE_DECORATOR) {
			// LogUtils.DEBUG_STRACK_LEVELS = 10;
			LogUtils.debug(this, hashCode() + ": " + getBinding() + "\n" + message + "@" + message.hashCode()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		myOutstandingMessages.add(message);
		updateDecoration();
	}

	@Override
	public void removeMessage(IBindingMessage message) {
		if (Activator.getDefault().TRACE_LIFECYCLE_VALUE_BINDING_MESSAGE_DECORATOR) {
			LogUtils.debug(this, hashCode() + ": " + getBinding() + "\n" + message + "@" + message.hashCode()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		myOutstandingMessages.remove(message);
		updateDecoration();
	}

	/**
	 * Returns the current list of quick fixes..
	 * <p>
	 * A new list is returned for every call.
	 * 
	 * @return the list
	 */
	public List<IQuickfixProposal> getQuickfixes() {
		final IManager manager = IManager.Factory.getManager();
		final List<IQuickfixProposal> quickfixes = new ArrayList<IQuickfixProposal>();
		for (final IBindingMessage m : myMessages) {
			manager.getQuickfixes(m, quickfixes);
		}

		return quickfixes;
	}

	/**
	 * Whether an update is wanted.
	 * 
	 * Set to <code>true</code> in {@link #updateDecoration()}
	 */
	private boolean updateDecorationScheduled = false;

	/**
	 * Updates the message decoration of this decorator.
	 */
	protected void updateDecoration() {
		if (getBinding().getState() != BindingState.OK) return;
		if (!updateDecorationScheduled) {
			updateDecorationScheduled = true;
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
				@Override
				public void run() {
					updateDecorationDelayed();
				}
			});
		}
	}

	/**
	 * The object observed by this decorator. Used to track changes in master-detail bindings.
	 */
	private EObject myObservedObject = null;

	private Image myMessageDecorationImage;
	private String myMessageDecorationMessage;

	private Image myAlternativeDecorationImage;
	private String myAlternativeDecorationMessage;

	/**
	 * The VAM...
	 */
	public static final IValidatorAdapterManager VALIDATION_MANAGER = IValidatorAdapterManager.Factory.getManager();

	/**
	 * Decoration used to display <em>a value is required</em> for the binding.
	 */
	public static final FieldDecoration REQUIRED_FIELD_DECORATOR = FieldDecorationRegistry.getDefault()
			.getFieldDecoration(FieldDecorationRegistry.DEC_REQUIRED);
	/**
	 * Decoration used to display <em>additional information</em> is available for the binding.
	 */
	public static final FieldDecoration INFORMATION_FIELD_DECORATOR = FieldDecorationRegistry.getDefault()
			.getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION);
	/**
	 * Decoration used to display <em>a warning</em> is detected for the binding.
	 */
	public static final FieldDecoration WARNING_FIELD_DECORATOR = FieldDecorationRegistry.getDefault()
			.getFieldDecoration(FieldDecorationRegistry.DEC_WARNING);
	/**
	 * Decoration used to display <em>an error</em> is detected for the binding.
	 */
	public static final FieldDecoration ERROR_FIELD_DECORATOR = FieldDecorationRegistry.getDefault()
			.getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
	/**
	 * Decoration used to display <em>a content proposal</em> is detected for the binding.
	 */
	public static final FieldDecoration CONTENT_PROPOSAL_FIELD_DECORATOR = FieldDecorationRegistry.getDefault()
			.getFieldDecoration(FieldDecorationRegistry.DEC_CONTENT_PROPOSAL);
	/**
	 * Decoration used to display <em>a quick fix proposal</em> is detected for the binding.
	 */
	public static final FieldDecoration QUICKFIX_FIELD_DECORATOR = FieldDecorationRegistry.getDefault()
			.getFieldDecoration(FieldDecorationRegistry.DEC_ERROR_QUICKFIX);

	/**
	 * @see #updateDecoration()
	 */
	protected void updateDecorationDelayed() {
		if (!updateDecorationScheduled) return;
		updateDecorationScheduled = false;
		/*
		 * As this operation is delayed, the widget might be disposed in the mean time...
		 */
		if (getBinding().getUIObservable().isDisposed()) return;

		if (Activator.getDefault().TRACE_LIFECYCLE_VALUE_BINDING_MESSAGE_DECORATOR) {
			LogUtils.debug(this, "update delayed " + hashCode() + ": " + getBinding()); //$NON-NLS-1$ //$NON-NLS-2$
		}
		if (VALIDATION_MANAGER != null) {
			if (getBinding().getModelObservable().isDisposed()) {
				LogUtils.debug(this, "value is disposed");
				return;
			}
			/*
			 * Check if the observed object of the binding has changed. If so, then reset the
			 * decoration for the validation manager - this will remove all current messages and set
			 * up a new set...
			 */
			final EObject newObservedObject = getBinding().getModelObject();
			if (myObservedObject != newObservedObject) {
				myObservedObject = newObservedObject;
				VALIDATION_MANAGER.resetDecorator(this);
			}
		}

		/*
		 * Make a list of all the potential messages
		 */
		final List<IBindingMessage> ml = new ArrayList<IBindingMessage>();
		final BindingMessageSeverity minimumSeverity = IManager.Factory.getManager()
				.getMessageDecorationMinimumSeverity();
		for (final Object v : myMessageProviders) {
			final IBindingMessage message = (IBindingMessage) ((IObservableValue) v).getValue();
			if (message.getSeverity().compareTo(minimumSeverity) < 0) {
				continue;
			}
			ml.add(message);

		}
		for (final IBindingMessage message : myOutstandingMessages) {
			if (message.getSeverity().compareTo(minimumSeverity) < 0) {
				continue;
			}
			ml.add(message);
		}

		/*
		 * Find the current max type and the combined messages to use...
		 */
		int maxType = IMessageProvider.NONE;
		final List<IBindingMessage> topList = new ArrayList<IBindingMessage>();
		for (final IBindingMessage message : ml) {
			final int type = message.getMessageType();
			if (type > maxType) {
				topList.clear();
				maxType = type;
			}
			if (type == maxType) {
				topList.add(message);
			}
		}

		/*
		 * Weed out any superseded messages.
		 * 
		 * There has to be at least two messages before there any anything to weed out...
		 */
		if (topList.size() > 1) {
			final IBindingMessage[] ma = topList.toArray(new IBindingMessage[topList.size()]);
			for (int i = 0; i < ma.length; i++) {
				final IBindingMessage a = ma[i];
				for (int j = i + 1; j < ma.length; j++) {
					final IBindingMessage b = ma[j];
					if (a.supersedes(b)) {
						topList.remove(b);
						continue;
					}
					if (b.supersedes(a)) {
						topList.remove(a);
						break;
					}
				}
			}
		}

		/*
		 * Updated the messages
		 */
		for (final IBindingMessage m : topList) {
			if (myMessages.contains(m)) {
				continue;
			}
			myMessagesOL.add(m);
		}
		for (final IBindingMessage m : myMessages.toArray(new IBindingMessage[myMessages.size()])) {
			if (topList.contains(m)) {
				continue;
			}
			myMessagesOL.remove(m);
		}

		final StringBuilder sb = new StringBuilder(100);
		for (final IBindingMessage message : myMessages) {
			if (sb.length() > 0) {
				sb.append('\n');
			}
			sb.append(message.getMessage());
		}

		/*
		 * Show the appropriate message decorations
		 */
		final Image oldMessageDecorationImage = myMessageDecorationImage;
		final String oldMessageDecorationMessage = myMessageDecorationMessage;
		switch (maxType) {
		case IMessageProvider.NONE:
			myMessageDecorationImage = null;
			break;
		case IMessageProvider.ERROR:
			myMessageDecorationImage = ERROR_FIELD_DECORATOR.getImage();
			break;
		case IMessageProvider.WARNING:
			myMessageDecorationImage = WARNING_FIELD_DECORATOR.getImage();
			break;
		case IMessageProvider.INFORMATION:
			myMessageDecorationImage = INFORMATION_FIELD_DECORATOR.getImage();
			break;
		default:
			break;
		}
		myMessageDecorationMessage = sb.toString();

		/*
		 * The alternative stuff is only relevant if the binding is changeable...
		 */
		final Image oldAlternativeDecorationImage = myAlternativeDecorationImage;
		final String oldAlternativeDecorationMessage = myAlternativeDecorationMessage;
		if (getBinding().isChangeable()) {
			final IManager manager = IManager.Factory.getManager();

			final boolean showAlternativeDecorations = getBinding().getControl() != null;

			// TODO TMTM add key bindings
			if (getQuickfixes().size() > 0 && manager.isQuickfixVBImageDecorationShown()) {
				myAlternativeDecorationImage = QUICKFIX_FIELD_DECORATOR.getImage();
				myAlternativeDecorationMessage = QUICKFIX_FIELD_DECORATOR.getDescription();
			} else if (showAlternativeDecorations && getBinding().getDataType().isRequired()
					&& manager.isRequiredVBImageDecorationShown()) {
				myAlternativeDecorationImage = REQUIRED_FIELD_DECORATOR.getImage();
				myAlternativeDecorationMessage = Messages.ValueBindingMessageImageDecorator_ValueRequired;
			} else if (showAlternativeDecorations && getBinding().getDecorator().getValidUIList() != null
					&& getBinding().getUIAttribute().getFieldAssistAdapter() != null
					&& manager.isAssistVBImageDecorationShown()) {
				myAlternativeDecorationImage = CONTENT_PROPOSAL_FIELD_DECORATOR.getImage();
				myAlternativeDecorationMessage = Messages.ValueBindingMessageImageDecorator_ContentAssistAvailanble;
			} else {
				myAlternativeDecorationImage = null;
				myAlternativeDecorationMessage = null;
			}
		}

		/*
		 * If everything is the same, then do nothing
		 */
		if (UIBindingsUtils.equals(oldMessageDecorationImage, myMessageDecorationImage)
				&& UIBindingsUtils.equals(oldMessageDecorationMessage, myMessageDecorationMessage)
				&& UIBindingsUtils.equals(oldAlternativeDecorationImage, myAlternativeDecorationImage)
				&& UIBindingsUtils.equals(oldAlternativeDecorationMessage, myAlternativeDecorationMessage)) return;

		/*
		 * Update the binding
		 */
		getBinding().updateBinding();
	}

	/**
	 * Updates the context based on the current images and message values.
	 * 
	 * @param context the extender context to update
	 */
	public void extend(IUIBindingDecoratorExtenderContext context) {
		if (myMessageDecorationImage != null) {
			// LogUtils.debug(this, myMessageDecorationMessage);
			context.setDecoratingImage(IManager.Factory.getManager().getMessageDecorationPosition(), true,
					myMessageDecorationImage, myMessageDecorationMessage);
		}
		if (myAlternativeDecorationImage != null) {
			// LogUtils.debug(this, myAlternativeDecorationMessage);
			context.setDecoratingImage(IManager.Factory.getManager().getAlternativeDecorationPosition(), true,
					myAlternativeDecorationImage, myAlternativeDecorationMessage);
		}
	}

	@Override
	public boolean accept(IBindingMessage unboundMessage) {
		if (myObservedObject == null) return false;

		final IValueBinding binding = getBinding();
		final IObservable modelObservable = binding.getModelObservable();
		Object key = null;
		if (modelObservable instanceof IKeyedObservable) {
			key = ((IKeyedObservable) modelObservable).getObservableKey();
		}

		FeatureMatchingAlgorithm matchingAlgorithm;
		if (binding.getArgument(Constants.ARG_MODEL_OBJECT_MESSAGES, Boolean.class, Boolean.FALSE) == Boolean.TRUE) {
			matchingAlgorithm = FeatureMatchingAlgorithm.EXACT_OR_NULL;
		} else {
			matchingAlgorithm = FeatureMatchingAlgorithm.EXACT;
		}
		if (unboundMessage.matches(myObservedObject, binding.getModelFeature(), key, matchingAlgorithm)) return true;

		if (binding.getArgument(Constants.ARG_VALUE_OBJECT_MESSAGES, Boolean.class, Boolean.FALSE) == Boolean.TRUE
				&& unboundMessage.matches(myObservedObject, null, null, FeatureMatchingAlgorithm.EXACT)) return true;

		return false;
	}
}
