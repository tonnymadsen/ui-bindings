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
package com.rcpcompany.uibindings.internal.observables;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Slider;

import com.rcpcompany.uibindings.Constants;

/**
 * 
 */
public class SliderObservableValue extends AbstractSWTObservableValue {

	private final Slider slider;

	private final String attribute;

	private boolean updating = false;

	private int currentSelection;

	private SelectionListener selectionListener;

	/**
	 * @param spinner
	 * @param attribute
	 */
	public SliderObservableValue(Slider spinner, String attribute) {
		super(spinner);
		slider = spinner;
		this.attribute = attribute;
		init();
	}

	/**
	 * @param realm
	 * @param spinner
	 * @param attribute
	 */
	public SliderObservableValue(Realm realm, Slider spinner, String attribute) {
		super(realm, spinner);
		slider = spinner;
		this.attribute = attribute;
		init();
	}

	private void init() {
		if (attribute.equals(Constants.ATTR_SELECTION)) {
			currentSelection = slider.getSelection();
			selectionListener = new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					if (!updating) {
						final int newSelection = SliderObservableValue.this.slider.getSelection();
						notifyIfChanged(currentSelection, newSelection);
						currentSelection = newSelection;
					}
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
				}
			};
			slider.addSelectionListener(selectionListener);
		} else if (!attribute.equals(Constants.ATTR_MIN) && !attribute.equals(Constants.ATTR_MAX))
			throw new IllegalArgumentException("Attribute name not valid: " + attribute); //$NON-NLS-1$
	}

	@Override
	public void doSetValue(final Object value) {
		int oldValue;
		int newValue;
		try {
			updating = true;
			newValue = ((Integer) value).intValue();
			if (attribute.equals(Constants.ATTR_SELECTION)) {
				oldValue = slider.getSelection();
				slider.setSelection(newValue);
				currentSelection = newValue;
			} else if (attribute.equals(Constants.ATTR_MIN)) {
				oldValue = slider.getMinimum();
				slider.setMinimum(newValue);
			} else if (attribute.equals(Constants.ATTR_MAX)) {
				oldValue = slider.getMaximum();
				slider.setMaximum(newValue);
			} else {
				Assert.isTrue(false, "invalid attribute name:" + attribute); //$NON-NLS-1$
				return;
			}
			notifyIfChanged(oldValue, newValue);
		} finally {
			updating = false;
		}
	}

	@Override
	public Object doGetValue() {
		int value = 0;
		if (attribute.equals(Constants.ATTR_SELECTION)) {
			value = slider.getSelection();
		} else if (attribute.equals(Constants.ATTR_MIN)) {
			value = slider.getMinimum();
		} else if (attribute.equals(Constants.ATTR_MAX)) {
			value = slider.getMaximum();
		}
		return Integer.valueOf(value);
	}

	@Override
	public Object getValueType() {
		return Integer.TYPE;
	}

	/**
	 * @return attribute being observed
	 */
	public String getAttribute() {
		return attribute;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue #dispose()
	 */
	@Override
	public synchronized void dispose() {
		super.dispose();
		if (selectionListener != null && !slider.isDisposed()) {
			slider.removeSelectionListener(selectionListener);
		}
	}

	private void notifyIfChanged(int oldValue, int newValue) {
		if (oldValue != newValue) {
			fireValueChange(Diffs.createValueDiff(Integer.valueOf(oldValue), Integer.valueOf(newValue)));
		}
	}
}
