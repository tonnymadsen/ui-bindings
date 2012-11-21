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
package org.eclipse.jface.viewers;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;

/**
 * A {@link StyledCellLabelProvider} supports styled labels by using owner draw. Besides the styles
 * in labels, the label provider preserves native viewer behavior:
 * <ul>
 * <li>similar image and label positioning</li>
 * <li>native drawing of focus and selection</li>
 * </ul>
 * <p>
 * For providing the label's styles, create a subclass and overwrite
 * {@link StyledCellLabelProvider#update(ViewerCell)} to return set all information needed to render
 * a element. Use {@link ViewerCell#setStyleRanges(StyleRange[])} to set style ranges on the label.
 * </p>
 * 
 * @since 1.1
 */
public abstract class MyStyledCellLabelProvider extends OwnerDrawLabelProvider {

	/**
	 * Style constant for indicating that the styled colors are to be applied even it the viewer's
	 * item is selected. Default is not to apply colors.
	 */
	public static final int COLORS_ON_SELECTION = 1 << 0;

	/**
	 * Style constant for indicating to draw the focus if requested by the owner draw event. Default
	 * is to draw the focus.
	 */
	public static final int NO_FOCUS = 1 << 1;

	/**
	 * Private constant to indicate if owner draw is enabled for the label provider's column.
	 */
	private static final int OWNER_DRAW_ENABLED = 1 << 4;

	/**
	 * Style mask for the alignment of a column.
	 */
	private static final int ALIGNMENT = SWT.LEFT | SWT.CENTER | SWT.RIGHT;

	private int style;

	// reused text layout
	private TextLayout cachedTextLayout;

	private ColumnViewer viewer;
	private ViewerColumn column;

	private Widget itemOfLastMeasure;
	private Object elementOfLastMeasure;
	private int deltaOfLastMeasure;

	/**
	 * Creates a new StyledCellLabelProvider. By default, owner draw is enabled, focus is drawn and
	 * no colors are painted on selected elements.
	 */
	public MyStyledCellLabelProvider() {
		this(0);
	}

	/**
	 * Creates a new StyledCellLabelProvider. By default, owner draw is enabled.
	 * 
	 * @param style the style bits
	 * @see StyledCellLabelProvider#COLORS_ON_SELECTION
	 * @see StyledCellLabelProvider#NO_FOCUS
	 * @see SWT#LEFT
	 * @see SWT#CENTER
	 * @see SWT#RIGHT
	 */
	public MyStyledCellLabelProvider(int style) {
		this.style = style & (ALIGNMENT | COLORS_ON_SELECTION | NO_FOCUS) | OWNER_DRAW_ENABLED;
	}

	/**
	 * Returns <code>true</code> is the owner draw rendering is enabled for this label provider. By
	 * default owner draw rendering is enabled. If owner draw rendering is disabled, rending is done
	 * by the viewer and no styled ranges (see {@link ViewerCell#getStyleRanges()}) are drawn.
	 * 
	 * @return <code>true</code> is the rendering of styles is enabled.
	 */
	public boolean isOwnerDrawEnabled() {
		return (this.style & OWNER_DRAW_ENABLED) != 0;
	}

	/**
	 * Specifies whether owner draw rendering is enabled for this label provider. By default owner
	 * draw rendering is enabled. If owner draw rendering is disabled, rendering is done by the
	 * viewer and no styled ranges (see {@link ViewerCell#getStyleRanges()}) are drawn. It is the
	 * caller's responsibility to also call {@link StructuredViewer#refresh()} or similar methods to
	 * update the underlying widget.
	 * 
	 * @param enabled specifies if owner draw rendering is enabled
	 */
	public void setOwnerDrawEnabled(boolean enabled) {
		final boolean isEnabled = isOwnerDrawEnabled();
		if (isEnabled != enabled) {
			if (enabled) {
				this.style |= OWNER_DRAW_ENABLED;
			} else {
				this.style &= ~OWNER_DRAW_ENABLED;
			}
			if (this.viewer != null) {
				setOwnerDrawEnabled(this.viewer, this.column, enabled);
			}
		}
	}

	/**
	 * Returns the viewer on which this label provider is installed on or <code>null</code> if the
	 * label provider is not installed.
	 * 
	 * @return the viewer on which this label provider is installed on or <code>null</code> if the
	 *         label provider is not installed.
	 */
	protected final ColumnViewer getViewer() {
		return this.viewer;
	}

	/**
	 * Returns the column on which this label provider is installed on or <code>null</code> if the
	 * label provider is not installed.
	 * 
	 * @return the column on which this label provider is installed on or <code>null</code> if the
	 *         label provider is not installed.
	 */
	protected final ViewerColumn getColumn() {
		return this.column;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.OwnerDrawLabelProvider#initialize(org.eclipse.jface.viewers.
	 * ColumnViewer, org.eclipse.jface.viewers.ViewerColumn)
	 */
	@Override
	public void initialize(ColumnViewer viewer, ViewerColumn column) {
		Assert.isTrue(this.viewer == null && this.column == null, "Label provider instance already in use"); //$NON-NLS-1$

		this.viewer = viewer;
		this.column = column;
		super.initialize(viewer, column, isOwnerDrawEnabled());

		if ((style & ALIGNMENT) == 0) {
			int columnStyle = 0;
			if (column instanceof TableViewerColumn) {
				final TableViewerColumn tvc = (TableViewerColumn) column;
				columnStyle = tvc.getColumn().getStyle();
			} else if (column instanceof TableViewerColumn) {
				final TableViewerColumn tvc = (TableViewerColumn) column;
				columnStyle = tvc.getColumn().getStyle();
			}
			style |= columnStyle & ALIGNMENT;
		}
	}

	/**
	 * Returns the alignment of the column
	 * 
	 * @return one of {@link SWT#LEFT}, {@link SWT#CENTER} or {@link SWT#RIGHT}
	 */
	public int getAlignment() {
		return style & ALIGNMENT;
	}

	/**
	 * Sets the alignment of the column
	 * <p>
	 * The column is <em>not</em> updated.
	 * 
	 * @param align one of {@link SWT#LEFT}, {@link SWT#CENTER} or {@link SWT#RIGHT}
	 */
	public void setAlignment(int align) {
		style = (style & ~ALIGNMENT) | (align & ALIGNMENT);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
		if (this.cachedTextLayout != null) {
			cachedTextLayout.dispose();
			cachedTextLayout = null;
		}

		this.viewer = null;
		this.column = null;
		this.itemOfLastMeasure = null;
		this.elementOfLastMeasure = null;

		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.OwnerDrawLabelProvider#update(org.eclipse.jface.viewers.ViewerCell)
	 */
	@Override
	public void update(ViewerCell cell) {
		// clients must override and configure the cell and call super
		super.update(cell); // calls 'repaint' to trigger the paint listener
	}

	private TextLayout getSharedTextLayout(Display display) {
		if (cachedTextLayout == null) {
			final int orientation = viewer.getControl().getStyle() & (SWT.LEFT_TO_RIGHT | SWT.RIGHT_TO_LEFT);
			cachedTextLayout = new TextLayout(display);
			cachedTextLayout.setOrientation(orientation);
		}
		return cachedTextLayout;
	}

	private boolean useColors(Event event) {
		return (event.detail & SWT.SELECTED) == 0 || (this.style & COLORS_ON_SELECTION) != 0;
	}

	private boolean drawFocus(Event event) {
		return (event.detail & SWT.FOCUSED) != 0 && (this.style & NO_FOCUS) == 0;
	}

	/**
	 * Prepares the given style range before it is applied to the label. This method makes sure that
	 * no colors are drawn when the element is selected. The current version of the
	 * {@link StyledCellLabelProvider} will also ignore all font settings on the style range.
	 * Clients can override.
	 * 
	 * @param styleRange the style range to prepare. the style range element must not be modified
	 * @param applyColors specifies if colors should be applied.
	 * @return returns the style range to use on the label
	 */
	protected StyleRange prepareStyleRange(StyleRange styleRange, boolean applyColors) {
		// if no colors apply or font is set, create a clone and clear the
		// colors and font
		if (!applyColors && (styleRange.foreground != null || styleRange.background != null)) {
			styleRange = (StyleRange) styleRange.clone();
			if (!applyColors) {
				styleRange.foreground = null;
				styleRange.background = null;
			}
		}
		return styleRange;
	}

	private ViewerCell getViewerCell(Event event, Object element) {
		final ViewerRow row = viewer.getViewerRowFromItem(event.item);
		return new ViewerCell(row, event.index, element);
	}

	/**
	 * Handle the erase event. The default implementation does nothing to ensure keep native
	 * selection highlighting working.
	 * 
	 * @param event the erase event
	 * @param element the model object
	 * @see SWT#EraseItem
	 */
	@Override
	protected void erase(Event event, Object element) {
		// use native erase
		if (isOwnerDrawEnabled()) {
			// info has been set by 'update': announce that we paint ourselves
			event.detail &= ~SWT.FOREGROUND;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.OwnerDrawLabelProvider#measure(org.eclipse.swt.widgets.Event,
	 * java.lang.Object)
	 */
	@Override
	protected void measure(Event event, Object element) {
		if (!isOwnerDrawEnabled()) return;

		final ViewerCell cell = getViewerCell(event, element);
		final boolean applyColors = useColors(event); // returns false because of bug 228376

		final TextLayout layout = getSharedTextLayout(event.display);

		final int textWidthDelta = deltaOfLastMeasure = updateTextLayout(layout, cell, applyColors);
		/* remove-begin if bug 228695 fixed */
		itemOfLastMeasure = event.item;
		elementOfLastMeasure = event.item.getData();
		/* remove-end if bug 228695 fixed */

		event.width += textWidthDelta;
	}

	/**
	 * @param layout
	 * @param cell
	 * @param applyColors
	 * @return the text width delta (0 if the text layout contains no other font)
	 */
	private int updateTextLayout(TextLayout layout, ViewerCell cell, boolean applyColors) {
		layout.setText(""); //$NON-NLS-1$  //make sure all previous ranges are cleared (see bug 226090)

		layout.setText(cell.getText());
		layout.setFont(cell.getFont()); // set also if null to clear previous usages

		final int originalTextWidth = layout.getBounds().width; // text width without any styles
		boolean containsOtherFont = false;

		final StyleRange[] styleRanges = cell.getStyleRanges();
		if (styleRanges != null) { // user didn't fill styled ranges
			for (final StyleRange styleRange : styleRanges) {
				final StyleRange curr = prepareStyleRange(styleRange, applyColors);
				layout.setStyle(curr, curr.start, curr.start + curr.length - 1);
				if (curr.font != null) {
					containsOtherFont = true;
				}
			}
		}
		int textWidthDelta = 0;
		if (containsOtherFont) {
			textWidthDelta = layout.getBounds().width - originalTextWidth;
		}
		return textWidthDelta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.OwnerDrawLabelProvider#paint(org.eclipse.swt.widgets.Event,
	 * java.lang.Object)
	 */
	@Override
	protected void paint(Event event, Object element) {
		if (!isOwnerDrawEnabled()) return;

		final ViewerCell cell = getViewerCell(event, element);

		final boolean applyColors = useColors(event);

		final GC gc = event.gc;
		// remember colors to restore the GC later
		final Color oldForeground = gc.getForeground();
		final Color oldBackground = gc.getBackground();

		if (applyColors) {
			final Color foreground = cell.getForeground();
			if (foreground != null) {
				gc.setForeground(foreground);
			}

			final Color background = cell.getBackground();
			if (background != null) {
				gc.setBackground(background);
			}
		}
		final Image image = cell.getImage();
		if (image != null) {
			final Rectangle imageBounds = cell.getImageBounds();
			if (imageBounds != null) {
				final Rectangle bounds = image.getBounds();

				// center the image in the given space
				final int x = imageBounds.x + Math.max(0, (imageBounds.width - bounds.width) / 2);
				final int y = imageBounds.y + Math.max(0, (imageBounds.height - bounds.height) / 2);
				gc.drawImage(image, x, y);
			}
		}

		final Rectangle textBounds = cell.getTextBounds();
		if (textBounds != null) {
			final TextLayout textLayout = getSharedTextLayout(event.display);

			/* remove-begin if bug 228695 fixed */
			if (event.item != itemOfLastMeasure || event.item.getData() != elementOfLastMeasure) {
				// fLayout has not been configured in 'measure()'
				deltaOfLastMeasure = updateTextLayout(textLayout, cell, applyColors);
				itemOfLastMeasure = event.item;
				elementOfLastMeasure = event.item.getData();
			}
			/* remove-end if bug 228695 fixed */

			/* remove-begin if bug 228376 fixed */
			if (!applyColors) {
				// need to remove colors for selected elements: measure doesn't provide that
				// information, see bug 228376
				final StyleRange[] styleRanges = cell.getStyleRanges();
				if (styleRanges != null) {
					for (final StyleRange styleRange : styleRanges) {
						final StyleRange curr = prepareStyleRange(styleRange, applyColors);
						textLayout.setStyle(curr, curr.start, curr.start + curr.length - 1);
					}
				}
			}
			/* remove-end if bug 228376 fixed */

			final Rectangle layoutBounds = textLayout.getBounds();

			int x = 0;
			switch (style & ALIGNMENT) {
			case SWT.LEFT:
				x = textBounds.x;
				break;
			case SWT.CENTER:
				x = textBounds.x;
				if (layoutBounds.width < textBounds.width) {
					x += (textBounds.width - layoutBounds.width) / 2;
				}
				break;
			case SWT.RIGHT:
				x = textBounds.x;
				if (layoutBounds.width < textBounds.width) {
					x += textBounds.width - layoutBounds.width;
				}
				break;
			}
			final int y = textBounds.y + Math.max(0, (textBounds.height - layoutBounds.height) / 2);

			textLayout.draw(gc, x, y);
		}

		if (drawFocus(event)) {
			final Rectangle focusBounds = cell.getViewerRow().getBounds();
			gc.drawFocus(focusBounds.x, focusBounds.y, focusBounds.width + deltaOfLastMeasure, focusBounds.height);
		}

		if (applyColors) {
			gc.setForeground(oldForeground);
			gc.setBackground(oldBackground);
		}
	}

	/**
	 * Applies decoration styles to the decorated string and adds the styles of the previously
	 * undecorated string.
	 * <p>
	 * If the <code>decoratedString</code> contains the <code>styledString</code>, then the result
	 * keeps the styles of the <code>styledString</code> and styles the decorations with the
	 * <code>decorationStyler</code>. Otherwise, the decorated string is returned without any
	 * styles.
	 * 
	 * @param decoratedString the decorated string
	 * @param decorationStyler the styler to use for the decoration or <code>null</code> for no
	 *            styles
	 * @param styledString the original styled string
	 * 
	 * @return the styled decorated string (can be the given <code>styledString</code>)
	 * @since 3.5
	 */
	public static StyledString styleDecoratedString(String decoratedString, Styler decorationStyler,
			StyledString styledString) {
		final String label = styledString.getString();
		final int originalStart = decoratedString.indexOf(label);
		if (originalStart == -1) return new StyledString(decoratedString); // the decorator did
																			// something wild

		if (decoratedString.length() == label.length()) return styledString;

		if (originalStart > 0) {
			final StyledString newString = new StyledString(decoratedString.substring(0, originalStart),
					decorationStyler);
			newString.append(styledString);
			styledString = newString;
		}
		if (decoratedString.length() > originalStart + label.length())
			return styledString.append(decoratedString.substring(originalStart + label.length()), decorationStyler);
		return styledString; // no change
	}
}
