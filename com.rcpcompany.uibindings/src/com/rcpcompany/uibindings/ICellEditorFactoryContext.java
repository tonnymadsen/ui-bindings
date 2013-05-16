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
package com.rcpcompany.uibindings;

import org.eclipse.swt.widgets.Composite;

/**
 * This context used when a {@link ICellEditorFactory} create a new cell editor.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface ICellEditorFactoryContext {
	/**
	 * Returns the cell information for the cell
	 * 
	 * @return the CI
	 */
	IValueBindingCell getCell();

	/**
	 * Returns the {@link Composite} parent for the cell editor
	 * 
	 * @return the parent
	 */
	Composite getParent();
}
