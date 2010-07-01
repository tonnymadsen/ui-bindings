package com.rcpcompany.uibindings.widgets;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;

import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.InternalConstants;
import com.rcpcompany.uibindings.internal.observables.TextObservableValue;

/**
 * File and directory name widget.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FileNameControl extends BaseTextButtonWidget implements TextObservableValue.IWidgetUpdated {
	private static Image myButtonImage = Activator.getDefault().getImageRegistry()
			.get(InternalConstants.IMG_OPEN_DIALOG);
	private boolean myExistingOnly = true;
	private String[] myFilterExtensions = null;
	private String[] myFilterNames = null;
	private String myDialogTitle = null;
	private boolean myDirectoryMode = false;

	/**
	 * Constructs and returns a new file and directory name widget.
	 * 
	 * @param parent the parent composite
	 * @param style the style
	 */
	public FileNameControl(Composite parent, int style) {
		super(parent, style, myButtonImage);
	}

	@Override
	public void open(MouseEvent e) {
		getTextControl().setFocus();
		final String path;
		if (myDirectoryMode) {
			final DirectoryDialog dialog = new DirectoryDialog(getShell(), isExistingOnly() ? SWT.OPEN : SWT.SAVE);
			dialog.setFilterPath(getText());
			if (getDialogTitle() != null) {
				dialog.setText(getDialogTitle());
			}
			path = dialog.open();
		} else {
			final FileDialog dialog = new FileDialog(getShell(), isExistingOnly() ? SWT.OPEN : SWT.SAVE);
			dialog.setFilterExtensions(myFilterExtensions);
			dialog.setFilterNames(myFilterNames);
			dialog.setFileName(getText());
			if (getDialogTitle() != null) {
				dialog.setText(getDialogTitle());
			}
			path = dialog.open();
		}
		if (path == null) return;
		setText(path);

		/*
		 * Need to provoke the TextObservableValue to accept the text
		 */
		for (final Listener l : getListeners(100)) {
			SafeRunner.run(new ISafeRunnable() {
				@Override
				public void run() throws Exception {
					l.handleEvent(null);
				}

				@Override
				public void handleException(Throwable exception) {
				}
			});
		}
	}

	private void updateMessage() {
		if (isDirectoryMode() && isExistingOnly()) {
			getTextControl().setMessage("Enter existing directory name");
		} else if (isDirectoryMode() && !isExistingOnly()) {
			getTextControl().setMessage("Enter directory name");
		} else if (!isDirectoryMode() && isExistingOnly()) {
			getTextControl().setMessage("Enter existing file name");
		} else if (!isDirectoryMode() && !isExistingOnly()) {
			getTextControl().setMessage("Enter file name");
		}
	}

	/**
	 * Set whether the file or directory must already exist.
	 * 
	 * @param existingOnly <code>true</code> if the file or directory must exist
	 */
	public void setExistingOnly(boolean existingOnly) {
		myExistingOnly = existingOnly;

		updateMessage();
	}

	/**
	 * Returns whether the file or directory must exist.
	 * 
	 * @return <code>true</code> if the file or directory must exist
	 */
	public boolean isExistingOnly() {
		return myExistingOnly;
	}

	/**
	 * Sets the valid extension names and filters for the files.
	 * 
	 * @param names the names - can be <code>null</code>
	 * @param filters the filters - cannot be <code>null</code>
	 */
	public void setExtensions(String[] names, String[] filters) {
		myFilterNames = names;
		myFilterExtensions = filters;

		updateMessage();
	}

	/**
	 * Sets the title of the open dialog if needed.
	 * 
	 * @param dialogTitle the dialog title
	 */
	public void setDialogTitle(String dialogTitle) {
		myDialogTitle = dialogTitle;
	}

	/**
	 * Returns the title of the open dialog.
	 * 
	 * @return the dialog title
	 */
	public String getDialogTitle() {
		return myDialogTitle;
	}

	/**
	 * @param dirMode the dirMode to set
	 */
	public void setDirectoryMode(boolean dirMode) {
		myDirectoryMode = dirMode;

		updateMessage();
	}

	/**
	 * @return the dirMode
	 */
	public boolean isDirectoryMode() {
		return myDirectoryMode;
	}

	@Override
	public void addWidgetUpdatedListener(Listener listener) {
		addListener(100, listener);
	}

	@Override
	public void removeWidgetUpdatedListener(Listener listener) {
		removeListener(100, listener);
	}
}
