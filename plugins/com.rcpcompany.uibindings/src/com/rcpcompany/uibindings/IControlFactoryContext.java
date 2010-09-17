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
package com.rcpcompany.uibindings;

import org.eclipse.swt.widgets.Composite;

/**
 * Context interface for {@link IControlFactory#create(IControlFactoryContext)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IControlFactoryContext {

	/**
	 * Returns the binding for wehich the control must be created
	 * 
	 * @return the binding
	 */
	public IValueBinding getBinding();

	/**
	 * Returns the parent composite of the new control.
	 * 
	 * @return the parent composite
	 */
	public Composite getParent();

	/**
	 * Returns the SWT style arguments for the new control
	 * 
	 * @return the style
	 */
	public int getStyle();
}
