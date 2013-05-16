/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.observables;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * Observable value that will return <code>true</code> or <code>false</code> if an observed value
 * has a specific guard value.
 * <p>
 * Note that although it is possible to set this observable value to <code>true</code> - which sets
 * the observed value to the guard value - it is not possible to set it to <code>false</code>.
 * <p>
 * The primary use of this observable value is as the observable for radio button groups.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GuardObservableValue extends AbstractObservableValue implements IObserving {

	private final IObservableValue myObserved;
	private final Object myGuardValue;
	private final boolean myNegate;

	/**
	 * Constructs and returns a new observable guard value.
	 * 
	 * @param observed the observed value
	 * @param guardValue the guard value
	 * @param negate TODO
	 */
	public GuardObservableValue(IObservableValue observed, Object guardValue, boolean negate) {
		super(observed.getRealm());
		Assert.isNotNull(observed);
		Assert.isNotNull(guardValue);
		myObserved = observed;
		myGuardValue = guardValue;
		myNegate = negate;

		currentValue = doGetValue();
	}

	/**
	 * The current value of this observable
	 */
	protected Object currentValue;
	private final IChangeListener myListListener = new IChangeListener() {
		@Override
		public void handleChange(ChangeEvent event) {
			final Object newValue = doGetValue();
			if (currentValue != newValue) {
				fireValueChange(Diffs.createValueDiff(currentValue, currentValue = newValue));
			}
		}
	};

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
		myObserved.addChangeListener(myListListener);
	}

	@Override
	protected void lastListenerRemoved() {
		myObserved.removeChangeListener(myListListener);
		super.lastListenerRemoved();
	}

	@Override
	protected Object doGetValue() {
		return myGuardValue.equals(myObserved.getValue()) ^ myNegate;
	}

	@Override
	protected void doSetValue(Object value) {
		if (!(value instanceof Boolean))
			throw new IllegalStateException("Value of " + this.getClass().getSimpleName() + " must be boolean");
		if ((Boolean) value != myNegate) {
			myObserved.setValue(myGuardValue);
		}
	}

	@Override
	public Object getValueType() {
		return EcorePackage.Literals.EBOOLEAN;
	}

	@Override
	public Object getObserved() {
		return myObserved;
	}
}
