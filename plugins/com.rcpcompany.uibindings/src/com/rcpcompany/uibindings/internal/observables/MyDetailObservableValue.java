package com.rcpcompany.uibindings.internal.observables;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.DisposeEvent;
import org.eclipse.core.databinding.observable.IDisposeListener;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.ObservableTracker;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.util.Policy;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.rcpcompany.uibindings.UIBindingsUtils;

/**
 * 
 */
public class MyDetailObservableValue extends AbstractObservableValue implements IObserving {

	private final boolean updating = false;

	private IValueChangeListener innerChangeListener = new IValueChangeListener() {
		@Override
		public void handleValueChange(ValueChangeEvent event) {
			/*
			 * Solves SIMA-694: Unhandled exception: java.lang.Double cannot be cast to
			 * org.eclipse.emf.common.util.EList -
			 * http://jira.marintek.sintef.no/jira/browse/SIMA-694
			 */
			if (isDisposed()) return;
			if (!updating) {
				fireValueChange(event.diff);
			}
		}
	};

	private Object currentOuterValue;

	private IObservableValue innerObservableValue;

	private final Object detailType;

	private IObservableValue outerObservableValue;

	private IObservableFactory factory;

	/**
	 * @param outerObservableValue
	 * @param factory
	 * @param detailType
	 */
	public MyDetailObservableValue(IObservableValue outerObservableValue, IObservableFactory factory, Object detailType) {
		super(outerObservableValue.getRealm());
		Assert.isTrue(!outerObservableValue.isDisposed(), "Master observable is disposed"); //$NON-NLS-1$

		this.factory = factory;
		this.detailType = detailType;
		this.outerObservableValue = outerObservableValue;

		outerObservableValue.addDisposeListener(new IDisposeListener() {
			@Override
			public void handleDispose(DisposeEvent staleEvent) {
				dispose();
			}
		});

		ObservableTracker.runAndIgnore(new Runnable() {
			@Override
			public void run() {
				updateInnerObservableValue();
			}
		});
		outerObservableValue.addValueChangeListener(outerChangeListener);
	}

	IValueChangeListener outerChangeListener = new IValueChangeListener() {
		@Override
		public void handleValueChange(ValueChangeEvent event) {
			/*
			 * Solves SIMA-694: Unhandled exception: java.lang.Double cannot be cast to
			 * org.eclipse.emf.common.util.EList -
			 * http://jira.marintek.sintef.no/jira/browse/SIMA-694
			 */
			if (isDisposed()) return;
			ObservableTracker.runAndIgnore(new Runnable() {
				@Override
				public void run() {
					final Object oldValue = doGetValue();
					updateInnerObservableValue();
					fireValueChange(Diffs.createValueDiff(oldValue, doGetValue()));
				}
			});
		}
	};

	private void updateInnerObservableValue() {
		currentOuterValue = outerObservableValue.getValue();
		if (innerObservableValue != null) {
			innerObservableValue.removeValueChangeListener(innerChangeListener);
			innerObservableValue.dispose();
		}
		if (currentOuterValue == null) {
			innerObservableValue = null;
		} else {
			ObservableTracker.runAndIgnore(new Runnable() {
				@Override
				public void run() {
					innerObservableValue = (IObservableValue) factory.createObservable(currentOuterValue);
				}
			});
			warnIfDifferentRealms(getRealm(), innerObservableValue.getRealm());

			if (detailType != null) {
				final Object innerValueType = innerObservableValue.getValueType();
				Assert.isTrue(
						detailType.equals(innerValueType),
						"Cannot change value type in a nested observable value, from " + innerValueType + " to " + detailType); //$NON-NLS-1$ //$NON-NLS-2$
			}
			innerObservableValue.addValueChangeListener(innerChangeListener);
		}
	}

	@Override
	public void doSetValue(final Object value) {
		if (innerObservableValue != null) {
			ObservableTracker.runAndIgnore(new Runnable() {
				@Override
				public void run() {
					innerObservableValue.setValue(value);
				}
			});
		}
	}

	@Override
	public Object doGetValue() {
		if (innerObservableValue == null) return null;
		final Object[] result = new Object[1];
		ObservableTracker.runAndIgnore(new Runnable() {
			@Override
			public void run() {
				result[0] = innerObservableValue.getValue();
			}
		});
		return result[0];
	}

	@Override
	public Object getValueType() {
		if (detailType == null && innerObservableValue != null) return innerObservableValue.getValueType();
		return detailType;
	}

	@Override
	public synchronized void dispose() {
		super.dispose();

		if (outerObservableValue != null) {
			outerObservableValue.removeValueChangeListener(outerChangeListener);
		}
		if (innerObservableValue != null) {
			innerObservableValue.removeValueChangeListener(innerChangeListener);
			innerObservableValue.dispose();
		}
		outerObservableValue = null;
		outerChangeListener = null;
		currentOuterValue = null;
		factory = null;
		innerObservableValue = null;
		innerChangeListener = null;
	}

	@Override
	public Object getObserved() {
		if (innerObservableValue instanceof IObserving) return ((IObserving) innerObservableValue).getObserved();
		return null;
	}

	private static void warnIfDifferentRealms(Realm detailRealm, Realm innerObservableRealm) {
		if (!UIBindingsUtils.equals(detailRealm, innerObservableRealm)) {
			final Throwable throwable = new Throwable();
			throwable.fillInStackTrace();
			final String message = "Inner observable realm (" + innerObservableRealm //$NON-NLS-1$
					+ ") not equal to detail realm (" //$NON-NLS-1$
					+ detailRealm + ")"; //$NON-NLS-1$
			Policy.getLog().log(new Status(IStatus.WARNING, Policy.JFACE_DATABINDING, message, throwable));
		}
	}
}
