package com.rcpcompany.uibindings.observables;

import org.eclipse.core.databinding.observable.IStaleListener;
import org.eclipse.core.databinding.observable.StaleEvent;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;

/**
 * Proxy wrapper class for IObservableValue instances.
 */
public class ProxyObservableValue extends AbstractObservableValue {
	private final IObservableValue wrappedValue;
	private final IValueChangeListener valueChangeListener = new IValueChangeListener() {
		public void handleValueChange(ValueChangeEvent event) {
			fireValueChange(event.diff);
		}
	};
	IStaleListener staleListener = new IStaleListener() {
		public void handleStale(StaleEvent staleEvent) {
			fireStale();
		}
	};

	/**
	 * Constructs an UnmodifiableObservableValue which wraps the given observable value
	 * 
	 * @param wrappedValue the observable value to wrap in an unmodifiable instance.
	 */
	public ProxyObservableValue(IObservableValue wrappedValue) {
		super(wrappedValue.getRealm());

		this.wrappedValue = wrappedValue;
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
		wrappedValue.addValueChangeListener(valueChangeListener);
		wrappedValue.addStaleListener(staleListener);
	}

	@Override
	protected void lastListenerRemoved() {
		wrappedValue.removeValueChangeListener(valueChangeListener);
		wrappedValue.removeStaleListener(staleListener);
		super.lastListenerRemoved();
	}

	@Override
	protected Object doGetValue() {
		return wrappedValue.getValue();
	}

	@Override
	protected void doSetValue(Object value) {
		wrappedValue.setValue(value);
	}

	public Object getValueType() {
		return wrappedValue.getValueType();
	}

	@Override
	public boolean isStale() {
		return wrappedValue.isStale();
	}
}
