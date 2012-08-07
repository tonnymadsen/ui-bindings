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
package com.rcpcompany.uibindings;

/**
 * A piece of code to be run whenever a {@link IBindingContext} has been finalized.
 * <p>
 * Finalizers are added and removed via {@link IBindingContext#getFinalizers()}
 * <p>
 * Will be run multiple times if {@link IBindingContext#finish()} is called multiple times.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public interface IBindingContextFinalizer {
	/**
	 * Runs the finalizer.
	 * <p>
	 * Can uninstall itself via <code>context.getFinalizers().remove(this);</code>.
	 * 
	 * @param context
	 */
	void run(IBindingContext context);
}
