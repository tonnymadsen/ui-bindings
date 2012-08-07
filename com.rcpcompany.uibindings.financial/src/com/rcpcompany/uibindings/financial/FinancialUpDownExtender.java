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
package com.rcpcompany.uibindings.financial;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.financial.internal.Activator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Extender that will format a financial number as follows:
 * <ul>
 * <li>when the number increases it should be green with an up-arrow</li>
 * <li>when the number decreases it should be red with a down-arrow</li>
 * <li>after a short while - a preference - it should go back to black</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FinancialUpDownExtender extends AbstractUIBindingDecoratorExtender {
	/**
	 * Argument name to enable the financial up/down arrow for numbers.
	 * <p>
	 * The argument value is a {@link Boolean}.
	 */
	public static final String ARG_FINANCIAL_UP_DOWN = "financialUpDown";

	/**
	 * {@link JFaceResources} identity of image used for "up".
	 */
	public static final String UP_ARROW = FinancialUpDownExtender.class.getName() + "$up";

	/**
	 * {@link JFaceResources} identity of image used for "down".
	 */
	public static final String DOWN_ARROW = FinancialUpDownExtender.class.getName() + "$down";

	/**
	 * The timeout for the up or down trends.
	 * 
	 * TODO: change to preference
	 */
	public static final int TIMEOUT = 2000;

	public FinancialUpDownExtender() {
		final ImageRegistry colorRegistry = JFaceResources.getImageRegistry();
		colorRegistry.put(UP_ARROW, AbstractUIPlugin.imageDescriptorFromPlugin(Activator.ID, "/images/up-arrow.png"));
		colorRegistry.put(DOWN_ARROW,
				AbstractUIPlugin.imageDescriptorFromPlugin(Activator.ID, "/images/down-arrow.png"));
	}

	@Override
	public boolean isEnabled(IValueBinding binding) {
		if (!binding.getArgument(ARG_FINANCIAL_UP_DOWN, Boolean.class, false)) return false;

		if (binding.getModelObservableValue() == null) return false;

		return true;
	}

	@Override
	public void extend(IUIBindingDecoratorExtenderContext context) {
		final IValueBinding binding = context.getBinding();
		BindingData data = binding.getService(BindingData.class);
		if (data == null) {
			data = new BindingData(binding);
		}

		data.extend(context);
	}

	/**
	 * Per binding specific data.
	 */
	public class BindingData implements IDisposable {
		/**
		 * The binding
		 */
		private final IValueBinding myBinding;

		/**
		 * The observable value for the binding
		 */
		private final IObservableValue myObservableValue;

		/**
		 * The currently reported trend for this binding
		 */
		protected int myCurrentTrend = 0;

		/**
		 * The time-out for the current trend. 0 if no timeout is needed.
		 */
		protected long myCurrentTimeout = 0;

		/**
		 * The last known value for the binding
		 */
		private Object myValue;

		private DisplayTimeout myDisplayTimeout;

		/**
		 * Constructs and returns a new data record for the specified binding.
		 * 
		 * @param binding the binding
		 */
		public BindingData(IValueBinding binding) {
			myBinding = binding;
			/*
			 * Tested in isEnabled(...)
			 */
			myObservableValue = binding.getModelObservableValue();
			myValue = myObservableValue.getValue();
			myBinding.registerService(this);
		}

		@Override
		public void dispose() {
			myBinding.unregisterService(this);
		}

		/**
		 * Extends the specified binding context.
		 * 
		 * @param context the context to extend
		 */
		public void extend(IUIBindingDecoratorExtenderContext context) {
			int trend = getTrend();
			/*
			 * Within the timeout, we keep the same trend.
			 */
			if (trend == 0) {
				if (System.currentTimeMillis() < myCurrentTimeout) {
					// Old trend
					trend = myCurrentTrend;
				} else
					// No old or new trends
					return;
			} else {
				// New trend
				if (myDisplayTimeout != null) {
					myDisplayTimeout.cancelled = true;
					myDisplayTimeout = null;
				}
				myDisplayTimeout = new DisplayTimeout();
				Display.getDefault().timerExec(TIMEOUT, myDisplayTimeout);
			}

			switch (trend) {
			case -1:
				context.setForegound(Display.getDefault().getSystemColor(SWT.COLOR_DARK_GREEN));
				context.setImage(JFaceResources.getImage(DOWN_ARROW));
				break;
			case 1:
				context.setForegound(Display.getDefault().getSystemColor(SWT.COLOR_DARK_RED));
				context.setImage(JFaceResources.getImage(UP_ARROW));
				break;
			case 0:
				break;
			default:
				LogUtils.error(this, "Trend value illegal: " + trend);
				break;
			}
		}

		protected class DisplayTimeout implements Runnable {
			public boolean cancelled = false;

			@Override
			public void run() {
				if (cancelled) return;
				/*
				 * Repaint the field!
				 */
				myBinding.updateBinding();
			}
		}

		/**
		 * Returns the current trend for this data item.
		 * <p>
		 * The rules are:
		 * <ul>
		 * <li>-1 if it is decreasing</li>
		 * <li>+1 if it is increasing</li>
		 * <li>0 if it is the same</li>
		 * <li>0 if either the old or the new value is <code>null</code></li>
		 * </ul>
		 * <p>
		 * If the old value implements the {@link Comparable} interface this is used. Otherwise TODO
		 * 
		 * @return the trend
		 */
		private int getTrend() {
			final Object newValue = myObservableValue.getValue();

			try {
				if (newValue == null) return 0;
				if (myValue == null) return 0;
				if (myValue == newValue) return 0;
				if (newValue.equals(myValue)) return 0;

				if (myValue instanceof Comparable) return ((Comparable) myValue).compareTo(newValue);

				final Object valueType = myObservableValue.getValueType();
				LogUtils.debug(valueType, "Cannot compare type " + valueType);

				return 0;
			} finally {
				myValue = newValue;
			}
		}
	}

}
