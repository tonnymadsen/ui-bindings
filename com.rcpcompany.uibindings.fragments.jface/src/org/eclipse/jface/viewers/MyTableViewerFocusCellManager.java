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
package org.eclipse.jface.viewers;

import org.eclipse.swt.widgets.TableItem;

import com.rcpcompany.uibindings.fragments.jfaceif.IMyViewerFocusCellManager;

/**
 * Special version of {@link TableViewerFocusCellManager}.
 * <p>
 * This version
 * <ul>
 * <li>adds the ability to set the focus cell based on an object and index</li>
 * <li>add a method to update an existing cell with the correct element</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.1
 */
public class MyTableViewerFocusCellManager extends TableViewerFocusCellManager implements IMyViewerFocusCellManager {
	public MyTableViewerFocusCellManager(TableViewer viewer, FocusCellHighlighter focusDrawingDelegate) {
		super(viewer, focusDrawingDelegate);
	}

	public MyTableViewerFocusCellManager(TableViewer viewer, FocusCellHighlighter focusDrawingDelegate,
			CellNavigationStrategy navigationStrategy) {
		super(viewer, focusDrawingDelegate, navigationStrategy);
	}

	@Override
	public void setFocusCell(Object element, int column) {
		final ViewerCell oldCell = getFocusCell();
		if (oldCell != null && (column == oldCell.getColumnIndex()) && (element == oldCell.getElement())) return;
		final ColumnViewer viewer = getViewer();
		final TableItem item = (TableItem) viewer.findItem(element);
		if (item == null) return;
		final ViewerRow row = viewer.getViewerRowFromItem(item);

		final ViewerCell cell = row.getCell(column);
		if (cell == null) return;
		setFocusCell(cell);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IA#updateFocusCell()
	 */
	@Override
	public void updateFocusCell() {
		final ViewerCell cell = getFocusCell();
		if (cell == null || cell.getViewerRow() == null) return;
		cell.update(cell.getViewerRow(), cell.getColumnIndex(), ((TableItem) cell.getViewerRow().getItem()).getData());
	}
}
