/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.FocusCellHighlighter;
import org.eclipse.jface.viewers.TreeViewerFocusCellManager;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Rectangle;

/**
 * Implementation of {@link FocusCellHighlighter} that delegates the real "painting" of cells to.
 */
public class FocusCellUIPainterHighlighter extends FocusCellHighlighter {
	/**
	 * Create a new instance which can be passed to a {@link TreeViewerFocusCellManager}.
	 * 
	 * @param viewer the viewer
	 */
	public FocusCellUIPainterHighlighter(ColumnViewer viewer) {
		super(viewer);
	}

	@Override
	protected void focusCellChanged(ViewerCell newCell, ViewerCell oldCell) {
		super.focusCellChanged(newCell, oldCell);

		// Redraw new area
		if (newCell != null) {
			final Rectangle rect = newCell.getBounds();
			final int x = newCell.getColumnIndex() == 0 ? 0 : rect.x;
			final int width = newCell.getColumnIndex() == 0 ? rect.x + rect.width : rect.width;
			// 1 is a fix for Linux-GTK
			newCell.getControl().redraw(x, rect.y - 1, width, rect.height + 1, true);
		}

		if (oldCell != null) {
			final Rectangle rect = oldCell.getBounds();
			final int x = oldCell.getColumnIndex() == 0 ? 0 : rect.x;
			final int width = oldCell.getColumnIndex() == 0 ? rect.x + rect.width : rect.width;
			// 1 is a fix for Linux-GTK
			oldCell.getControl().redraw(x, rect.y - 1, width, rect.height + 1, true);
		}
	}
}
