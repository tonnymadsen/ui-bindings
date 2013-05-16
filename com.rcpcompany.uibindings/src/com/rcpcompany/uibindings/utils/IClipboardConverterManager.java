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
package com.rcpcompany.uibindings.utils;

import java.util.List;

import com.rcpcompany.uibindings.internal.clipboardconverters.ClipboardConverterManager;

/**
 * A set of services to ease the conversion of clipboard data to tables.
 * <p>
 * Primary for use in super paste and super create.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IClipboardConverterManager {
	/**
	 * Factory methods...
	 */
	public static final class Factory {
		/**
		 * Private constructor to prevent construction.
		 */
		private Factory() {
		}

		public static IClipboardConverterManager getManager() {
			return ClipboardConverterManager.getManager();
		}
	}

	/**
	 * A single result from the convertion of the clipboard.
	 * 
	 * @author Tonny Madsen, The RCP Company
	 */
	public interface IResult {
		/**
		 * Returns the names of all the converters with the specified table result.
		 * 
		 * @return a list of names
		 */
		List<String> getConverterNames();

		/**
		 * Returns the result table for the specified converters.
		 * <p>
		 * The returned table is in the format row-column, so <code>result.length == #rows</code>
		 * and <code>result[0].length == #columns</code>. All rows must have the identical number of
		 * columns.
		 * 
		 * @return the table.
		 */
		String[][] getTable();

		/**
		 * Returns the number of rows in the table.
		 * 
		 * @return the number of rows
		 */
		int getRows();

		/**
		 * Returns the number of columns in the table.
		 * 
		 * @return the number of columns
		 */
		int getColumns();
	}

	/**
	 * Returns the result of converting the current clipboard content.
	 * <p>
	 * The results are is priority order, so the first result is the most likely.
	 * 
	 * @return the results
	 */
	List<IResult> getClipboardConversions();
}
