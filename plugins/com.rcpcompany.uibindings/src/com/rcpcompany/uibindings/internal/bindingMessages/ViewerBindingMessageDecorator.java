package com.rcpcompany.uibindings.internal.bindingMessages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IColumnBindingCellInformation;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * {@link IWidgetDecoration} handler for a {@link ColumnViewer}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerBindingMessageDecorator implements IDisposable {
	/**
	 * The viewer binding.
	 */
	protected final IViewerBinding myViewerBinding;

	/**
	 * The viewer of this decoration.
	 */
	protected final ColumnViewer myViewer;

	/**
	 * The control that backs the viewer.
	 */
	protected final Control myControl;

	/**
	 * Margin width used between the decorator and the control.
	 */
	protected int myMarginWidth = 0;

	private final Listener myPaintItemListener = new Listener() {
		@Override
		public void handleEvent(Event event) {
			final IColumnBindingCellInformation cell = getViewerBinding().getCell(
					event.index - getViewerBinding().getFirstTableColumnOffset(), event.item.getData());
			if (cell == null) return;
			decorate(cell, event);
		}
	};

	/**
	 * Constructs and returns a new decoration for the specified viewer.
	 * 
	 * @param viewerBinding the viewer binding
	 */
	public ViewerBindingMessageDecorator(IViewerBinding viewerBinding) {
		if (Activator.getDefault().TRACE_LIFECYCLE_VIEWER_BINDING_MESSAGE_DECORATOR) {
			LogUtils.debug(this, hashCode() + ": " + viewerBinding); //$NON-NLS-1$
		}
		myViewerBinding = viewerBinding;
		myViewer = viewerBinding.getViewer();
		myControl = viewerBinding.getControl();
		getViewerBinding().registerService(this);

		getControl().addListener(SWT.PaintItem, myPaintItemListener);
	}

	@Override
	public void dispose() {
		if (Activator.getDefault().TRACE_LIFECYCLE_VIEWER_BINDING_MESSAGE_DECORATOR) {
			LogUtils.debug(this, hashCode() + ": " + getViewerBinding()); //$NON-NLS-1$
		}
		getControl().removeListener(SWT.PaintItem, myPaintItemListener);
		// TODO
		getViewerBinding().unregisterService(this);
	}

	/**
	 * Returns the binding of this decorator
	 * 
	 * @return the binding
	 */
	public IViewerBinding getViewerBinding() {
		return myViewerBinding;
	}

	/**
	 * Returns the viewer of the decoration.
	 * 
	 * @return the viewer
	 */
	public ColumnViewer getViewer() {
		return myViewer;
	}

	/**
	 * Returns the control that backs the viewer of this decoration.
	 * 
	 * @return the control
	 */
	public Control getControl() {
		return myControl;
	}

	/**
	 * Constructs and returns a new widget decoration for the specified cell.
	 * 
	 * @param cell the cell in question
	 * @param position TODO
	 * @return the widget decoration
	 */
	public IWidgetDecoration addCellDecoration(IColumnBindingCellInformation cell, int position) {
		final CellDecoration d = new CellDecoration(cell, position);
		return d;
	}

	/**
	 * Decorates the specified cell with all registered decorations.
	 * 
	 * @param cell the cell to decorate
	 * @param event the event of the paint
	 */
	public void decorate(IColumnBindingCellInformation cell, Event event) {
		for (final CellDecoration cd : myCellDecorations) {
			if (!cd.isCell(cell)) {
				continue;
			}
			cd.decorate(event);
		}
	}

	/**
	 * List with all current cell decorations
	 */
	protected List<CellDecoration> myCellDecorations = new ArrayList<CellDecoration>();

	/**
	 * A decoration for a specific {@link ViewerCell}.
	 * <p>
	 * Note that there can be multiple decorations for a specific cell.
	 * 
	 * @author Tonny Madsen, The RCP Company
	 */
	protected class CellDecoration implements IWidgetDecoration {
		/**
		 * The cell of this decoration.
		 */
		private final IColumnBindingCellInformation myCell;

		/**
		 * Returns the cell of this decoration.
		 * 
		 * @return the cell
		 */
		public IColumnBindingCellInformation getCell() {
			return myCell;
		}

		/**
		 * The text of this decoration
		 */
		private String myText;

		@Override
		public String getDescriptionText() {
			return myText;
		}

		@Override
		public void setDescriptionText(String text) {
			myText = text;
		}

		/**
		 * The image of this decoration
		 */
		private Image myImage;

		@Override
		public Image getImage() {
			return myImage;
		}

		@Override
		public void setImage(Image image) {
			myImage = image;
			update();
		}

		/**
		 * The area of this cell that needs to be redrawn if any change happens.
		 */
		private Rectangle myDecorationArea;

		/**
		 * Returns the area of this cell that needs to be redrawn if any change happens.
		 * 
		 * @return a rectangle with the area or <code>null</code>
		 */
		public Rectangle getDecorationArea() {
			return myDecorationArea;
		}

		/**
		 * The position of the decoration.
		 */
		private final int myPosition;

		/**
		 * Returns the position of the decoration.
		 * 
		 * @return the position
		 */
		public int getPosition() {
			return myPosition;
		}

		/**
		 * Constructs and returns a new cell decoration.
		 * 
		 * @param cell the cell in question
		 * @param position the wanted position of the decoration
		 */
		public CellDecoration(IColumnBindingCellInformation cell, int position) {
			myCell = cell;
			myPosition = position;
			myCellDecorations.add(this);

			if (Activator.getDefault().TRACE_LIFECYCLE_VIEWER_BINDING_MESSAGE_DECORATOR) {
				LogUtils.debug(this, hashCode() + ": " + getCell()); //$NON-NLS-1$
			}
		}

		@Override
		public void dispose() {
			if (shouldShowDecoration()) {
				hide();
				/*
				 * Only update the control if it is not disposed and the viewer binding is still OK
				 */
				if (!getControl().isDisposed() && getViewerBinding().getState() == BindingState.OK) {
					getControl().update();
				}
			}
			if (Activator.getDefault().TRACE_LIFECYCLE_VIEWER_BINDING_MESSAGE_DECORATOR) {
				LogUtils.debug(this, hashCode() + ": " + getCell()); //$NON-NLS-1$
			}
			myCellDecorations.remove(this);
		}

		/**
		 * Returns whether the specified cell is identical to the cell of this decoration.
		 * 
		 * @param cell the cell to test
		 * @return <code>true</code> if the cells are identical.
		 */
		public boolean isCell(IColumnBindingCellInformation cell) {
			return cell == myCell;
		}

		/**
		 * Decorates the current cell as needed.
		 * 
		 * @param event the cell to decorate
		 */
		public void decorate(Event event) {
			if (Activator.getDefault().TRACE_LIFECYCLE_VIEWER_BINDING_MESSAGE_DECORATOR) {
				LogUtils.debug(this, hashCode() + ": " + getCell()); //$NON-NLS-1$
			}
			final Rectangle rect = calulateDecorationArea(event);
			// LogUtils.debug(this, "\nclipping: " + event.gc.getClipping() + "\narea: " + rect);
			if (shouldShowDecoration()) {
				event.gc.drawImage(getImage(), rect.x, rect.y);
			}
			// event.gc.drawRectangle(rect);

			// TODO update area
		}

		/**
		 * Calculates the area of the decoration based on the paint event object
		 * 
		 * @param event the paint event object
		 * @return the new area
		 */
		public Rectangle calulateDecorationArea(Event event) {
			// Compute the bounds first relative to the event clipping.
			final Rectangle imageBounds = getImage().getBounds();
			final Rectangle cellBounds = event.gc.getClipping();
			int x, y;
			// Compute x
			if ((getPosition() & SWT.RIGHT) == SWT.RIGHT) {
				x = cellBounds.x + cellBounds.width + myMarginWidth - imageBounds.width;
			} else {
				// default is left
				x = cellBounds.x - myMarginWidth;
			}
			// Compute y
			if ((getPosition() & SWT.TOP) == SWT.TOP) {
				y = cellBounds.y;
			} else if ((getPosition() & SWT.BOTTOM) == SWT.BOTTOM) {
				y = cellBounds.y + cellBounds.height - imageBounds.height;
			} else {
				// default is center
				y = cellBounds.y + (cellBounds.height - imageBounds.height) / 2;
			}
			myDecorationArea = new Rectangle(x, y, imageBounds.width, imageBounds.height);
			return getDecorationArea();
		}

		/**
		 * Requests an update of the area of this cell decoration
		 */
		public void update() {
			Rectangle area = getDecorationArea();
			if (area == null) {
				final IColumnBinding column = getCell().getColumn();
				final IViewerBinding viewer = column.getViewerBinding();
				if (viewer.getControl() instanceof Table) {
					final Table t = (Table) viewer.getControl();
					final int rowNo = viewer.getList().indexOf(getCell().getElement());
					/*
					 * Timing! We can request an element that does not exist any more or has not
					 * been created in the table yet...
					 */
					if (rowNo == -1 || rowNo >= t.getItemCount()) return;
					final TableItem item = t.getItem(rowNo);
					area = item.getBounds(viewer.getColumns().indexOf(column) + viewer.getFirstTableColumnOffset());
				}
			}
			if (Activator.getDefault().TRACE_LIFECYCLE_VIEWER_BINDING_MESSAGE_DECORATOR) {
				LogUtils.debug(this, hashCode() + ": " + getCell() + "\narea: " + area); //$NON-NLS-1$ //$NON-NLS-2$
			}
			if (area != null) {
				getControl().redraw(area.x, area.y, area.width, area.height, true);
			}
		}

		/**
		 * Whether the decoration is shown.
		 */
		private boolean myVisible = false;

		@Override
		public void hide() {
			if (myVisible) {
				myVisible = false;
				update();
			}
		}

		@Override
		public void show() {
			if (!myVisible) {
				myVisible = true;
				update();
			}
		}

		/*
		 * Return true if the decoration should be shown, false if it should not.
		 */
		private boolean shouldShowDecoration() {
			if (!myVisible) return false;
			if (getControl() == null || getControl().isDisposed() || getImage() == null) return false;

			if (!getControl().isVisible()) return false;
			// if (showOnlyOnFocus) {
			// return hasFocus;
			// }
			return true;
		}

	}
}
