package com.rcpcompany.uibindings.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;

import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.InternalConstants;

/**
 * File and directory name widget.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FileNameControl extends BaseTextButtonWidget {
	protected static Image myButtonImage = Activator.getDefault().getImageRegistry().get(
			InternalConstants.IMG_OPEN_DIALOG);
	private boolean myExistingOnly = true;
	private String[] myExtensions = null;
	private String myDialogTitle = null;
	private boolean myDirectoryMode = false;

	/**
	 * Constructs and returns a new file and directory name widget
	 * 
	 * @param parent the parent composite
	 * @param style the style
	 */
	public FileNameControl(Composite parent, int style) {
		super(parent, style, myButtonImage);
	}

	@Override
	public void open(MouseEvent e) {
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
			dialog.setFilterExtensions(getExtensions() != null ? getExtensions() : new String[] { "*.*" });
			dialog.setFileName(getText());
			if (getDialogTitle() != null) {
				dialog.setText(getDialogTitle());
			}
			path = dialog.open();
		}
		if (path == null) {
			return;
		}
		setText(path);
	}

	/**
	 * Set whether the file or directory must already exist
	 * 
	 * @param existingOnly <code>true</code> if the file or directory must exist
	 */
	public void setExistingOnly(boolean existingOnly) {
		myExistingOnly = existingOnly;
	}

	/**
	 * Returns whether the file or directory must exist
	 * 
	 * @return <code>true</code> if the file or directory must exist
	 */
	public boolean isExistingOnly() {
		return myExistingOnly;
	}

	/**
	 * Sets the valid extensions for the files
	 * <p>
	 * See {@link FileDialog#setFilterExtensions(String[])} for a description of the format
	 * 
	 * @param extensions the extensions to use
	 */
	public void setExtensions(String[] extensions) {
		myExtensions = extensions;
	}

	/**
	 * Returns the extensions for the files
	 * 
	 * @return the extensions
	 */
	public String[] getExtensions() {
		return myExtensions;
	}

	/**
	 * Sets the title of the open dialog if needed
	 * 
	 * @param dialogTitle the dialog title
	 */
	public void setDialogTitle(String dialogTitle) {
		myDialogTitle = dialogTitle;
	}

	/**
	 * Retrusn the title of the open dialog
	 * 
	 * @return the dialog title
	 */
	public String getDialogTitle() {
		return myDialogTitle;
	}

	/**
	 * Parses an extensions specification and returns the corresponding String[].
	 * 
	 * @param spec the specification
	 * @return the corresponding array or <code>null</code>
	 */
	public static String[] parseExtensions(String spec) {
		if (spec == null) {
			return null;
		}
		return spec.split("\n");
	}

	/**
	 * @param dirMode the dirMode to set
	 */
	public void setDirectoryMode(boolean dirMode) {
		myDirectoryMode = dirMode;
	}

	/**
	 * @return the dirMode
	 */
	public boolean isDirectoryMode() {
		return myDirectoryMode;
	}

}
