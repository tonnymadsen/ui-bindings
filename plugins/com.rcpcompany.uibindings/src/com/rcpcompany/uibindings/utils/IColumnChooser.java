package com.rcpcompany.uibindings.utils;

import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.SpecialBinding;
import com.rcpcompany.uibindings.internal.utils.ColumnChooser;

/**
 * This interface is used make columns in a viewer "choosable".
 * <p>
 * When columns in a viewer is choosable, they can be made visible and invisible via a popup on the column header.
 * <p>
 * Only columns that are added using {@link #addColumn(IColumnBinding)} can be made visible/invisible.
 * 
 * @author Tonny Madsen, The RCP Company
 * @noimplement
 */
public interface IColumnChooser extends IDisposable {
	/*
	 * Factory for the chooser
	 */
	public final static class Factory {
		private Factory() {

		}

		/**
		 * Constructs and returns a new column chooser
		 * 
		 * @param viewer the viewer with the columns
		 * @param addDefaultColumn add all default columns automatically
		 * @return the new column chooser
		 */
		public static IColumnChooser create(IViewerBinding viewer) {
			return new ColumnChooser(viewer);
		}
	}

	/**
	 * Argument name for when a column is choosable.
	 * <p>
	 * The argument value is an {@link Boolean}, and the default is <code>true</code>.
	 */
	public static final String ARG_CHOOSABLE = "choosable";

	/**
	 * Adds the specified column to this chooser
	 * 
	 * @param column the column to be added
	 */
	public void addColumn(IColumnBinding column);

	/**
	 * Removes the specified column from this chooser
	 * 
	 * @param column the column to be removed
	 */
	public void removeColumn(IColumnBinding column);

	/**
	 * Adds all default columns to this chooser.
	 * <p>
	 * All columns are added to the chooser, except for columns with a {@link SpecialBinding} and columns with zero
	 * width.
	 */
	public void addDefaultColumns();
}
