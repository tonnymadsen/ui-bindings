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
package com.rcpcompany.uibindings.grid;

import java.util.Map;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;

/**
 * Abstract base class for {@link IGridCell}.
 * 
 * @param <COLUMN> the type the column objects - must extend {@link EObject}
 * @param <ROW> the type the row objects - must extend {@link EObject}
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractGridCell<COLUMN extends Object, ROW extends Object> implements IGridCell {
	/**
	 * The possible types of cells.
	 */
	public enum CellType {
		/**
		 * The top-left cells between the row and column headers.
		 */
		TOP_LEFT,

		/**
		 * Row header at the left side of the grid.
		 */
		ROW_HEADER,

		/**
		 * Column header at the top side of the grid.
		 */
		COLUMN_HEADER,

		/**
		 * Regular data cell.
		 */
		DATA
	}

	/**
	 * The row ID.
	 * <p>
	 * A row object or one of {@link IGridModel#HEADER1 HEADER1}, {@link IGridModel#HEADER2 HEADER2}, {@link IGridModel#HEADER3 HEADER3}, {@link IGridModel#HEADER4 HEADER4}, or
	 * {@link IGridModel#HEADER5 HEADER5}.
	 */
	private final Object myRowID;

	/**
	 * The column item.
	 */
	private final COLUMN myColumnItem;

	/**
	 * The column ID.
	 * <p>
	 * A column object or one of {@link IGridModel#HEADER1 HEADER1}, {@link IGridModel#HEADER2
	 * HEADER2}, {@link IGridModel#HEADER3 HEADER3}, {@link IGridModel#HEADER4 HEADER4}, or
	 * {@link IGridModel#HEADER5 HEADER5}.
	 */
	private final Object myColumnID;

	/**
	 * The row item.
	 */
	private final ROW myRowItem;

	/**
	 * The type of this cell.
	 */
	private final CellType myCellType;

	/**
	 * Returns the row ID.
	 * <p>
	 * A row object or one of {@link IGridModel#HEADER1 HEADER1}, {@link IGridModel#HEADER2 HEADER2}, {@link IGridModel#HEADER3 HEADER3}, {@link IGridModel#HEADER4 HEADER4}, or
	 * {@link IGridModel#HEADER5 HEADER5}.
	 * 
	 * @return the row ID
	 */
	public Object getRowID() {
		return myRowID;
	}

	/**
	 * Returns the column item.
	 * 
	 * @return the column item
	 */
	public COLUMN getColumnItem() {
		return myColumnItem;
	}

	/**
	 * Returns the column ID.
	 * <p>
	 * A column object or one of {@link IGridModel#HEADER1 HEADER1}, {@link IGridModel#HEADER2
	 * HEADER2}, {@link IGridModel#HEADER3 HEADER3}, {@link IGridModel#HEADER4 HEADER4}, or
	 * {@link IGridModel#HEADER5 HEADER5}.
	 * 
	 * @return the column ID
	 */
	public Object getColumnID() {
		return myColumnID;
	}

	/**
	 * Returns the row item.
	 * 
	 * @return the row item
	 */
	public ROW getRowItem() {
		return myRowItem;
	}

	/**
	 * Returns the type of this cell.
	 * 
	 * @return the cell type
	 */
	public CellType getCellType() {
		return myCellType;
	}

	/**
	 * Constructs and returns a new cell.
	 * 
	 * @param columnID the column ID
	 * @param rowID the row ID
	 */
	public AbstractGridCell(Object columnID, Object rowID) {
		myColumnID = columnID;
		myRowID = rowID;

		if (GridUtils.isHeader(columnID)) {
			myColumnItem = null;
		} else {
			myColumnItem = (COLUMN) columnID;
		}
		if (GridUtils.isHeader(rowID)) {
			myRowItem = null;
		} else {
			myRowItem = (ROW) rowID;
		}

		if (myColumnItem == null && myRowItem == null) {
			myCellType = CellType.TOP_LEFT;
		} else if (myColumnItem == null) {
			myCellType = CellType.ROW_HEADER;
		} else if (myRowItem == null) {
			myCellType = CellType.COLUMN_HEADER;
		} else {
			myCellType = CellType.DATA;
		}
	}

	@Override
	public Map<String, Object> getArguments() {
		return null;
	}

	@Override
	public abstract IObservableValue getValue();

	@Override
	public void dispose() {
	}
}
