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
package com.rcpcompany.uibindings.observables;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.UIBindingsUtils.IClassIdentiferMapper;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Observable value that returns a value based on a mapper functor (function object).
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class MapperObservableValue extends AbstractObservableValue implements IObserving {

	private final IValueChangeListener myListener = new IValueChangeListener() {
		@Override
		public void handleValueChange(ValueChangeEvent event) {
			updateValue();
		}
	};
	private final IObservableValue myBaseObject;
	private final EditingDomain myEditingDomain;
	private final IClassIdentiferMapper myMapper;

	/**
	 * Constructs and returns a new observable value for the value and mapper.
	 * 
	 * @param value the base value for this observable value
	 * @param editingDomain the editing domain used for all changes
	 * @param classIdentiferMapper the mapper
	 */
	public MapperObservableValue(IObservableValue value, EditingDomain editingDomain,
			IClassIdentiferMapper classIdentiferMapper) {
		myBaseObject = value;
		myEditingDomain = editingDomain;
		myMapper = classIdentiferMapper;

		try {
			myCurrentOV = myMapper.getObservableValue(myBaseObject, myEditingDomain);
		} catch (final Exception ex) {
			LogUtils.error(myMapper, ex);
		}
		if (myCurrentOV != null) {
			myCurrentOV.addValueChangeListener(myListener);
		}
		updateValue();
	}

	@Override
	public synchronized void dispose() {
		if (myCurrentOV != null) {
			myCurrentOV.removeValueChangeListener(myListener);
		}

		if (myMapper instanceof IDisposable) {
			((IDisposable) myMapper).dispose();
		}
		super.dispose();
	}

	private IObservableValue myCurrentOV = null;
	private Object myCurrentValue;

	/**
	 * Updates the resulting count for this observable value.
	 */
	protected void updateValue() {
		Object v;
		try {
			v = myMapper.map(myBaseObject.getValue());
		} catch (final Exception ex) {
			LogUtils.error(myMapper, ex);
			v = null;
		}
		if (UIBindingsUtils.equals(v, myCurrentValue)) return;

		final ValueDiff diff = Diffs.createValueDiff(myCurrentValue, v);

		myCurrentValue = v;
		getRealm().exec(new Runnable() {
			@Override
			public void run() {
				fireValueChange(diff);
			}
		});
	}

	@Override
	protected Object doGetValue() {
		return myCurrentValue;
	}

	@Override
	protected void doSetValue(Object value) {
		myCurrentOV.setValue(value);
	}

	@Override
	public Object getValueType() {
		return myCurrentOV.getValueType();
	}

	@Override
	public Object getObserved() {
		return myBaseObject.getValue();
	}
}
