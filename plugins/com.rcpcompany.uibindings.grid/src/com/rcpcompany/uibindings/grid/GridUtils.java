package com.rcpcompany.uibindings.grid;

/**
 * Utilities for the Grid Bindings.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GridUtils {

	/**
	 * Returns whether the specified ID designates a column or row header.
	 * 
	 * @param id the ID to test
	 * @return <code>true</code> if it is a header
	 */
	public static boolean isHeader(Object id) {
		if (id == IGridModel.HEADER1) {
			return true;
		}
		if (id == IGridModel.HEADER2) {
			return true;
		}
		if (id == IGridModel.HEADER3) {
			return true;
		}
		if (id == IGridModel.HEADER4) {
			return true;
		}
		if (id == IGridModel.HEADER5) {
			return true;
		}
		return false;
	}
}
