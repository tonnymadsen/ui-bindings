package com.rcpcompany.uibindings.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;

import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.utils.TableButtonBar;

/**
 * Support for a control button bar for Tables.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface ITableButtonBar {
	/**
	 * Factory for {@link ITableButtonBar}.
	 */
	public static final class Factory {
		private Factory() {
		}

		/**
		 * Adds a button bar to the specified viewer (if not already present).
		 * 
		 * @param viewer the viewer that will get the button bar
		 * @param style the style for the button bar
		 */
		public static ITableButtonBar addButtonBar(IViewerBinding viewer, int style) {
			return TableButtonBar.addButtonBar(viewer, style);
		}
	};

	/**
	 * The button bar includes an "add" button.
	 */
	int ADD = 0x001;

	/**
	 * The button bar includes an "delete" button.
	 */
	int DELETE = 0x002;

	/**
	 * The button bar includes an "up" button.
	 */
	int UP = 0x004;

	/**
	 * The button bar includes an "down" button.
	 */
	int DOWN = 0x008;

	/**
	 * The button bar wil have a border.
	 */
	int BORDER = SWT.BORDER;

	/**
	 * The button bar is horizontal.
	 */
	int HORIZONTAL = SWT.HORIZONTAL;

	/**
	 * The button bar is vertical.
	 */
	int VERTICAL = SWT.VERTICAL;

	/**
	 * The viewer of this button bar.
	 * 
	 * @return the viewer
	 */
	IViewerBinding getViewer();

	/**
	 * Returns the style for this button bar.
	 * 
	 * @return the style
	 */
	int getStyle();

	/**
	 * Returns the button with the specified ID.
	 * 
	 * @param buttonId the ID of the wanted button
	 * @return the button of <code>null</code> if the button is not created
	 */
	Button getButton(int buttonId);
}
