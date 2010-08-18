package com.rcpcompany.uibindings.internal.utils;

import org.eclipse.swt.widgets.Button;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.utils.ITableButtonBar;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Implementation of {@link ITableButtonBar}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class TableButtonBar implements ITableButtonBar, IDisposable {
	/**
	 * The viewer of this button bar.
	 */
	private IViewerBinding myViewer;

	/**
	 * The style of this button bar.
	 */
	private int myStyle;

	public static ITableButtonBar addButtonBar(IViewerBinding viewer, int style) {
		return null;
	}

	private Button myAddButton;
	private Button myDeleteButton;
	private Button myUpButton;
	private Button myDownButton;

	@Override
	public IViewerBinding getViewer() {
		return myViewer;
	}

	@Override
	public int getStyle() {
		return myStyle;
	}

	@Override
	public Button getButton(int buttonId) {
		switch (buttonId) {
		case ADD:
			return myAddButton;
		case DELETE:
			return myDeleteButton;
		case UP:
			return myUpButton;
		case DOWN:
			return myDownButton;
		default:
			LogUtils.error(this, "button id not one of ADD, DELETE, UP or DOWN");
			return null;
		}
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
