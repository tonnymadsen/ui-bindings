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
package com.rcpcompany.uibindings.grid;

/**
 * Utilities for the Grid Bindings.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public final class GridUtils {
	private GridUtils() {
	}

	/**
	 * Returns whether the specified ID designates a column or row header.
	 * 
	 * @param id the ID to test
	 * @return <code>true</code> if it is a header
	 */
	public static boolean isHeader(Object id) {
		if (id == IGridModel.HEADER1) return true;
		if (id == IGridModel.HEADER2) return true;
		if (id == IGridModel.HEADER3) return true;
		if (id == IGridModel.HEADER4) return true;
		if (id == IGridModel.HEADER5) return true;
		return false;
	}
}
