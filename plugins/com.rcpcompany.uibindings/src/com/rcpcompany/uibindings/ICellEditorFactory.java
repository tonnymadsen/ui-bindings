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

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Control;

/**
 * This factory interface is used to create preferred {@link Control Controls} for
 * {@link IValueBinding}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface ICellEditorFactory {
	/**
	 * Creates and returns a new {@link CellEditor cell editor}.
	 * 
	 * @param context the context for the creation.
	 * 
	 * @return the created editor
	 */
	CellEditor create(ICellEditorFactoryContext context);
}
