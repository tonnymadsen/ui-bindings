package com.rcpcompany.uibindings.grid.internal.renderers;

import org.eclipse.nebula.widgets.grid.GridCellRenderer;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.nebula.widgets.grid.IRenderer;
import org.eclipse.nebula.widgets.grid.internal.CheckBoxRenderer;
import org.eclipse.nebula.widgets.grid.internal.DefaultCellRenderer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.grid.IGridBindingCellInformation;
import com.rcpcompany.uibindings.grid.IGridBindingColumnInformation;
import com.rcpcompany.uibindings.uiAttributes.UIAttributePainter;

/**
 * The renderer used for cells in the grid.
 * <p>
 * It delegates to either an {@link DefaultCellRenderer} or an {@link CheckBoxRenderer} depending on the current value
 * of .
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UIPainterCellRenderer extends GridCellRenderer implements IRenderer {

	private final IGridBindingColumnInformation myColumn;

	/**
	 * Constructs and returns a new cell renderer for the specified column.
	 * 
	 * @param column the column of the renderer
	 */
	public UIPainterCellRenderer(IGridBindingColumnInformation column) {
		myColumn = column;
	}

	@Override
	public boolean notify(int event, Point point, Object value) {
		return false;
	}

	private UIAttributePainter getPainter(Object value) {
		final IGridBindingCellInformation ci = myColumn.getCell((GridItem) value);
		if (ci == null) {
			return null;
		}
		final UIAttributePainter painter = ci.getPainter();
		if (painter == null) {
			return null;
		}
		painter.setFocus(isCellFocus());
		painter.setSelected(isCellSelected());
		final IValueBinding b = ci.getLabelBinding();
		if (b.getModelType() == Boolean.class || b.getModelType() == Boolean.TYPE) {
			painter.setCheckbox((Boolean) b.getModelObservableValue().getValue());
			painter.setHorizontalAlignment(SWT.CENTER);
		} else {
			painter.setCheckbox(null);
			final Integer align = b.getArgument(Constants.ARG_ALIGNMENT, Integer.class, UIBindingsUtils
					.defaultAlignment(b.getModelEType()));
			if (align != null) {
				painter.setHorizontalAlignment(align);
			}
		}
		return painter;
	}

	@Override
	public Point computeSize(GC gc, int wHint, int hHint, Object value) {
		final UIAttributePainter painter = getPainter(value);
		if (painter == null) {
			return new Point(15, 15);
		}
		return painter.getSize(gc);
	}

	@Override
	public void paint(GC gc, Object value) {
		final UIAttributePainter painter = getPainter(value);
		if (painter == null) {
			return;
		}
		painter.paint(gc, getBounds());
	}
}
