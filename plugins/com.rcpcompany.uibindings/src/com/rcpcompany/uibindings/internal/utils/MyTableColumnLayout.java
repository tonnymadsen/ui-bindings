package com.rcpcompany.uibindings.internal.utils;

import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Widget;

/**
 * The TableColumnLayout is the {@link Layout} used to maintain {@link TableColumn} sizes in a
 * {@link Table}.
 * 
 * <p>
 * <b>You can only add the {@link Layout} to a container whose <i>only</i> child is the
 * {@link Table} control you want the {@link Layout} applied to. Don't assign the layout directly
 * the {@link Table}</b>
 * </p>
 */
public class MyTableColumnLayout extends UITableLayout {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected int getColumnCount(Scrollable tableTree) {
		return ((Table) tableTree).getColumnCount();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setColumnWidths(Scrollable tableTree, int[] widths) {
		final TableColumn[] columns = ((Table) tableTree).getColumns();
		for (int i = 0; i < widths.length; i++) {
			columns[i].setWidth(widths[i]);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ColumnLayoutData getLayoutData(Scrollable tableTree, int columnIndex) {
		final TableColumn column = ((Table) tableTree).getColumn(columnIndex);
		return (ColumnLayoutData) column.getData(LAYOUT_DATA);
	}

	Composite getComposite(Widget column) {
		return ((TableColumn) column).getParent().getParent();
	}

	/**
	 */
	@Override
	protected void updateColumnData(Widget column) {
		final TableColumn tColumn = (TableColumn) column;
		final Table t = tColumn.getParent();

		if (!IS_GTK || t.getColumn(t.getColumnCount() - 1) != tColumn) {
			tColumn.setData(LAYOUT_DATA, new ColumnPixelData(tColumn.getWidth()));
			layout(t.getParent(), true);
		}
	}
}
