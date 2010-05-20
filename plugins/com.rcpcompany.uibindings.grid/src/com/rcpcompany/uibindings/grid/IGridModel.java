package com.rcpcompany.uibindings.grid;

import org.eclipse.core.databinding.observable.list.IObservableList;

import com.rcpcompany.uibindings.IDisposable;

/**
 * The adapter for a grid to be shown.
 * <p>
 * Spanning: via {@link IGridCell#getArguments()} for argument name ....
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IGridModel extends IDisposable {
	/**
	 * Returns a list with the IDs of all columns of the grid.
	 * 
	 * @return the list of columns
	 */
	public IObservableList getColumnIDs();

	/**
	 * Returns a list with the IDs of all rows of the grid.
	 * 
	 * @return the list of rows
	 */
	public IObservableList getRowIDs();

	/**
	 * Returns the cell of the specified column and row, The column and row are specified by their respective IDs as
	 * returns by {@link #getColumnIDs()} and {@link #getRowIDs()}.
	 * <p>
	 * The cells for column and row headers are accessed via the special constants {@link #HEADER1}, {@link #HEADER2},
	 * {@link #HEADER3}, {@link #HEADER4}, and {@link #HEADER5}.
	 * 
	 * @param columnID the column
	 * @param rowID the row
	 * @return the cell or <code>null</code>
	 */
	public IGridCell getCell(Object columnID, Object rowID);

	/**
	 * the ID for header column or row 1.
	 */
	public static final Object HEADER1 = new Object() {
		@Override
		public String toString() {
			return "HEADER1";
		};
	};

	/**
	 * the ID for header column or row 2.
	 */
	public static final Object HEADER2 = new Object() {
		@Override
		public String toString() {
			return "HEADER2";
		};
	};

	/**
	 * the ID for header column or row 3.
	 */
	public static final Object HEADER3 = new Object() {
		@Override
		public String toString() {
			return "HEADER3";
		};
	};

	/**
	 * the ID for header column or row 4.
	 */
	public static final Object HEADER4 = new Object() {
		@Override
		public String toString() {
			return "HEADER4";
		};
	};

	/**
	 * the ID for header column or row 5.
	 */
	public static final Object HEADER5 = new Object() {
		@Override
		public String toString() {
			return "HEADER5";
		};
	};

	/**
	 * Argument name for the number of header rows and header columns in a grid.
	 * <p>
	 * The argument value is {@link Integer} and defaults to 1.
	 */
	public static final String ARG_NO_HEADERS = "gridNoHeaders";
}
