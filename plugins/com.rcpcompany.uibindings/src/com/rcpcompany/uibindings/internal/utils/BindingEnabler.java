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
package com.rcpcompany.uibindings.internal.utils;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EcorePackage;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingContextFinalizer;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.utils.IBindingEnabler;

/**
 * Implementation of {@link IBindingEnabler}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingEnabler implements IBindingEnabler, IBindingContextFinalizer {
	private final IValueBinding myBinding;
	private final IObservableValue mySourceOV;
	private final Object[] myValues;
	private final String myAttribute = "enabled";
	private IValueBinding myEnableBinding;
	private IObservableValue myEnabledOV;

	/**
	 * {@inheritDoc IBindingEnabler.Factory#add(IValueBinding, IObservableValue, Object...)}.
	 * 
	 * @see IBindingEnabler.Factory#add(IValueBinding, IObservableValue, Object...)
	 */
	public BindingEnabler(IValueBinding b, IObservableValue sourceOV, Object... values) {
		myBinding = b;
		mySourceOV = sourceOV;
		myValues = values;

		final IBindingContext context = myBinding.getContext();
		switch (context.getState()) {
		case OK:
			run(context);
			break;
		case INIT:
		case PHASE1:
		case PHASE2:
		case PHASE3:
			context.getFinalizers().add(this);
			break;
		default:
			break;
		}
	}

	@Override
	public void dispose() {
		myBinding.getContext().getFinalizers().remove(this);

		if (myEnableBinding != null && !myEnableBinding.isDisposed()) {
			myEnableBinding.dispose();
		}
		myEnableBinding = null;

		if (myEnabledOV != null && !myEnabledOV.isDisposed()) {
			myEnabledOV.dispose();
		}
		myEnabledOV = null;
	}

	@Override
	public void run(IBindingContext context) {
		context.getFinalizers().remove(this);

		myEnabledOV = WritableValue.withValueType(EcorePackage.Literals.EBOOLEAN);
		mySourceOV.addChangeListener(new IChangeListener() {
			@Override
			public void handleChange(ChangeEvent event) {
				myEnabledOV.setValue(isEnabled());
			}
		});
		myEnabledOV.setValue(isEnabled());

		myEnableBinding = context.addBinding().ui(myBinding.getControl(), myAttribute).model(myEnabledOV);
		context.finish();
	}

	/**
	 * Returns the current enabled state for this enabler based on the current value of the source
	 * value.
	 * 
	 * @return the current enablement state
	 */
	public boolean isEnabled() {
		final Object currentValue = mySourceOV.getValue();
		boolean enabled = false;
		for (final Object v : myValues) {
			if (UIBindingsUtils.equals(currentValue, v)) {
				enabled = true;
				break;
			}
		}
		return enabled;
	}
}
