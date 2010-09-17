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
package com.rcpcompany.uibindings.utils;

import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.utils.ViewerToolBar;

/**
 * Support for a control toolbar for {@link IViewerBinding}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IViewerToolBar {
	/**
	 * Factory for {@link IViewerToolBar}.
	 */
	public static final class Factory {
		private Factory() {
		}

		/**
		 * Adds a toolbar to the specified viewer (if not already present).
		 * 
		 * @param viewer the viewer that will get the toolbar
		 * @param style the style for the toolbar
		 */
		public static IViewerToolBar addToolBar(IViewerBinding viewer, int style) {
			Assert.isNotNull(viewer);
			return ViewerToolBar.addToolBar(viewer, style);
		}
	};

	/**
	 * The toolbar includes an "add" button.
	 */
	int ADD = 0x001;

	/**
	 * The toolbar includes an "delete" button.
	 */
	int DELETE = 0x002;

	/**
	 * The toolbar includes an "up" button.
	 */
	int UP = 0x004;

	/**
	 * The toolbar includes an "down" button.
	 */
	int DOWN = 0x008;

	/**
	 * The toolbar is horizontal.
	 */
	int HORIZONTAL = SWT.HORIZONTAL;

	/**
	 * The toolbar is vertical.
	 */
	int VERTICAL = SWT.VERTICAL;

	/**
	 * All style values.
	 */
	int[] STYLES = new int[] { ADD, DELETE, UP, DOWN, HORIZONTAL, VERTICAL };

	/**
	 * The default standard items.
	 */
	int STANDARD_ITEMS = ADD | DELETE | UP | DOWN;

	/**
	 * The viewer of this toolbar.
	 * 
	 * @return the viewer
	 */
	IViewerBinding getViewer();

	/**
	 * Returns the style for this toolbar.
	 * 
	 * @return the style
	 */
	int getStyle();

	/**
	 * Returns the {@link ToolBar} widget of this toolbar.
	 * 
	 * @return the widget
	 */
	ToolBar getToolBar();

	/**
	 * Returns the {@link ToolBar} item with the specified ID.
	 * 
	 * @param itemId the ID of the wanted item
	 * @return the item or <code>null</code> if the item is not added
	 */
	ToolItem getItem(int itemId);

	/**
	 * Adds a new {@link ToolBar} item to this toolbar for the specified command.
	 * <p>
	 * Icons, tool tips and behavior is defined by the command.
	 * 
	 * @param id the id of the item
	 * @param commandId the command to execute
	 */
	void addItem(int id, String commandId);

	/**
	 * Adds a new {@link ToolBar} item to this toolbar.
	 * 
	 * @param id the id of the item
	 * @param item the item to add
	 */
	void addItem(int id, ToolItem item);

}
