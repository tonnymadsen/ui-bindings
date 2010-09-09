package org.eclipse.jface.viewers;

import org.eclipse.swt.widgets.TreeItem;

/**
 * Special version of {@link TreeViewerFocusCellManager}.
 * <p>
 * This version
 * <ul>
 * <li>adds the ability to set the focus cell based on an object and index</li>
 * <li>add a method to update an existing cell with the correct element</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class MyTreeViewerFocusCellManager extends TreeViewerFocusCellManager {
	public MyTreeViewerFocusCellManager(TreeViewer viewer, FocusCellHighlighter focusDrawingDelegate) {
		super(viewer, focusDrawingDelegate);
	}

	public MyTreeViewerFocusCellManager(TreeViewer viewer, FocusCellHighlighter focusDrawingDelegate,
			CellNavigationStrategy navigationStrategy) {
		super(viewer, focusDrawingDelegate, navigationStrategy);
	}

	public void setFocusCell(Object element, int column) {
		final ViewerCell oldCell = getFocusCell();
		if (oldCell != null && (column == oldCell.getColumnIndex()) && (element == oldCell.getElement())) return;
		final ColumnViewer viewer = getViewer();
		final TreeItem item = (TreeItem) viewer.findItem(element);
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
		// final Tree Tree = (Tree) viewer.getControl();
		// final TreeItem item = (TreeItem) focusCell.getItem();
		//
		// Tree.setSelection(item);
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
		cell.update(cell.getViewerRow(), cell.getColumnIndex(), ((TreeItem) cell.getViewerRow().getItem()).getData());
	}
}
