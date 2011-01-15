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

import org.eclipse.swt.widgets.Composite;

/**
 * Context interface for {@link IControlFactory#create(IControlFactoryContext)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IControlFactoryContext {

	/**
	 * Returns the binding for wehich the control must be created.
	 * 
	 * @return the binding
	 */
	IValueBinding getBinding();

	/**
	 * Returns the parent composite of the new control.
	 * 
	 * @return the parent composite
	 */
	Composite getParent();

	/**
	 * Returns the SWT style arguments for the new control.
	 * 
	 * @return the style
	 */
	int getStyle();

	/**
	 * Returns whether the control is to be used for a cell editor or not.
	 * 
	 * @return <code>true</code> if for a cell editor, and <code>false</code> if not
	 */
	boolean isCellEditor();
}
