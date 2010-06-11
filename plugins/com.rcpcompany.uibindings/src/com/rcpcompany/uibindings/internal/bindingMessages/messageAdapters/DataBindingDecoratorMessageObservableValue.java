package com.rcpcompany.uibindings.internal.bindingMessages.messageAdapters;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.IStatus;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.bindingMessages.AbstractBindingMessage;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Decorator message observable value for a data binding of a value binding.
 */
public class DataBindingDecoratorMessageObservableValue extends AbstractObservableValue {
	/**
	 * The binding of this object
	 */
	protected final IValueBinding myValueBinding;
	/**
	 * The data binding monitored by this object.
	 */
	protected final Binding myDataBinding;
	/**
	 * The current message of the observable value.
	 */
	protected Message myMessage;
	/**
	 * The current validation status of the data binding.
	 */
	protected final IObservableValue myValidationStatus;

	/**
	 * Constructs and returns a new observable value
	 * 
	 * @param valueBinding the value binding
	 * @param dataBinding the data binding
	 */
	public DataBindingDecoratorMessageObservableValue(IValueBinding valueBinding, Binding dataBinding) {
		myValueBinding = valueBinding;
		myDataBinding = dataBinding;
		myValidationStatus = myDataBinding.getValidationStatus();
		myMessage = new Message(myValueBinding, (IStatus) myValidationStatus.getValue());
	}

	@Override
	public synchronized void dispose() {
		if (hasListeners()) {
			lastListenerRemoved();
		}
		super.dispose();
	}

	@Override
	protected void firstListenerAdded() {
		super.firstListenerAdded();
		myValidationStatus.addValueChangeListener(myListener);
	}

	@Override
	protected void lastListenerRemoved() {
		myValidationStatus.removeValueChangeListener(myListener);
		super.lastListenerRemoved();
	}

	@Override
	protected Object doGetValue() {
		return myMessage;
	}

	@Override
	public Object getValueType() {
		return IBindingMessage.class;
	}

	private final IValueChangeListener myListener = new IValueChangeListener() {
		@Override
		public void handleValueChange(ValueChangeEvent event) {
			// Only report changes when the value is in fact changed
			final IStatus oldValue = (IStatus) event.diff.getOldValue();
			final IStatus newValue = (IStatus) event.diff.getNewValue();
			if ((oldValue.getSeverity() == newValue.getSeverity())
					&& (oldValue.getMessage().equals(newValue.getMessage()))) {
				return;
			}

			if (Activator.getDefault().TRACE_MESSAGE_DECORATION_VALIDATION_STATUS) {
				LogUtils.debug(DataBindingDecoratorMessageObservableValue.this, "Change: " + myValueBinding + "\n"
						+ oldValue.getSeverity() + " -> " + newValue.getSeverity() + "\n" + oldValue.getMessage()
						+ " -> " + newValue.getMessage());
			}

			fireValueChange(Diffs.createValueDiff(myMessage, myMessage = new Message(myValueBinding,
					(IStatus) myValidationStatus.getValue())));
		}
	};

	private class Message extends AbstractBindingMessage {
		private final IStatus myStatus;

		public Message(IValueBinding binding, IStatus status) {
			super(binding);
			myStatus = status;
			addTarget(binding.getModelObject(), binding.getModelFeature(), null);
		}

		@Override
		public Object getData() {
			return myDataBinding;
		}

		@Override
		public String getMessage() {
			return myStatus.getMessage();
		}

		@Override
		public BindingMessageSeverity getSeverity() {
			switch (myStatus.getSeverity()) {
			case IStatus.OK:
				return BindingMessageSeverity.NONE;
			case IStatus.INFO:
				return BindingMessageSeverity.INFORMATION;
			case IStatus.WARNING:
				return BindingMessageSeverity.WARNING;
			case IStatus.ERROR:
				return BindingMessageSeverity.ERROR;
			default:
				return BindingMessageSeverity.NONE;
			}
		}

		@Override
		public int getCode() {
			return myStatus.getCode();
		}
	}
}
