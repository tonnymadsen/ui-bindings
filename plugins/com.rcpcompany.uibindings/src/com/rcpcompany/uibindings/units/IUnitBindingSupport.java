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
package com.rcpcompany.uibindings.units;

/**
 * This interface defines the unit support for a binding.
 * <p>
 * 
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IUnitBindingSupport {
	/**
	 * Returns the current conversion factor for the binding of the context.
	 * <p>
	 * <code>uiValue = modelValue*factor</code> and <code>modelValue = uiValue/factor</code>.
	 * 
	 * @param context the context for the operation
	 * @return the factor
	 */
	double getFactor(IUnitBindingSupportContext context);

	/**
	 * Returns the current unit for the binding of the context.
	 * 
	 * @param context the context for the operation
	 * @return the unit - e.g "m/s"
	 */
	String getUnitDescription(IUnitBindingSupportContext context);

	/**
	 * Adds a listener that will be notified if any changes is made in the unit support.
	 * <p>
	 * If the listener has already been added, the following calls will be silently ignored.
	 * 
	 * @param listener the listener that will be invoked if a relevant change is detected
	 */
	void addListener(IUnitBindingSupportListener listener);

	/**
	 * Removes a listener that has previously been added with
	 * {@link #addListener(IUnitBindingSupportListener)}.
	 * 
	 * @param listener the listener to be removed
	 */
	void removeListener(IUnitBindingSupportListener listener);
}
