package org.eclipse.jface.viewers;

import org.eclipse.swt.widgets.TableItem;

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
 */
public class TableViewerFocusCellManagerEx extends TableViewerFocusCellManager {
	public TableViewerFocusCellManagerEx(TableViewer viewer, FocusCellHighlighter focusDrawingDelegate) {
		super(viewer, focusDrawingDelegate);
	}

	public TableViewerFocusCellManagerEx(TableViewer viewer, FocusCellHighlighter focusDrawingDelegate,
			CellNavigationStrategy navigationStrategy) {
		super(viewer, focusDrawingDelegate, navigationStrategy);
	}

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

	@Override
	void setFocusCell(ViewerCell focusCell) {
		// if (focusCell != null) {
		// LogUtils.debug(this, "" + focusCell.getElement());
		// final ColumnViewer viewer = getViewer();
		// final Table table = (Table) viewer.getControl();
		// final TableItem item = (TableItem) focusCell.getItem();
		//
		// table.setSelection(item);
		// }

		super.setFocusCell(focusCell);
	}

	/**
	 * Updates the element part of the {@link ViewerCell}.
	 * <p>
	 * Part of our fix for SIMA-182.
	 */
	public void updateFocusCell() {
		final ViewerCell cell = getFocusCell();
		if (cell == null || cell.getViewerRow() == null) return;
		cell.update(cell.getViewerRow(), cell.getColumnIndex(), ((TableItem) cell.getViewerRow().getItem()).getData());
	}
}
