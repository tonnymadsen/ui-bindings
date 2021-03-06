/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.moao.ui.internal.dialogs;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.moao.IMOAOMessage;
import com.rcpcompany.uibindings.moao.ui.internal.Activator;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * The editor dialog itself...
 */
public class CommentEditorDialog extends TitleAreaDialog {
	/**
	 * The button ID for the 'Delete' button.
	 */
	public static final int DELETE = 10;

	/**
	 * The comment that is the subject of this editor.
	 */
	protected final IMOAOMessage myComment;

	/**
	 * The form.
	 */
	protected IFormCreator myForm;
	/**
	 * The binding for the description.
	 */
	protected IValueBinding myDescriptionBinding;
	/**
	 * The binding for the details.
	 */
	protected IValueBinding myDetailsBinding;

	/**
	 * Constructs and returns a new editor dialog for a comment.
	 * 
	 * @param shell the parent shell
	 * @param comment the comment to edit
	 */
	public CommentEditorDialog(Shell shell, IMOAOMessage comment) {
		super(shell);
		myComment = comment;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite top = (Composite) super.createDialogArea(parent);

		final IBindingContext context = IBindingContext.Factory.createContext(this);

		setTitle("Editing comment...");
		setMessage("Press 'OK' to set comment, 'Cancel' to reject change and 'Delete' to use this comment");

		myForm = IFormCreator.Factory.createForm(context, myComment, null, top);

		myForm.addField("object").type(Constants.TYPE_QUALIFIED_NAME).dynamic().readonly()
				.arg(Constants.ARG_PREFERRED_CONTROL, CLabel.class.getName());
		myForm.addField("feature").dynamic().readonly();
		myForm.addSeparator();
		myDescriptionBinding = myForm.addField("description (w=30em)");
		myDetailsBinding = myForm.addField("details(sb=v, h=200, w=30em)").arg(Constants.ARG_PREFERRED_CONTROL,
				StyledText.class.getName());

		myForm.finish();

		// Text comment = new Text(top, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
		// comment.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		//
		// context.addBinding(comment, myComment, IApplPackage.Literals.STATUS__DESCRIPTION);
		//
		// context.finish();

		applyDialogFont(top);

		myDescriptionBinding.setFocus();

		return top;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Edit Comment");
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);

		Button button;
		button = createButton(parent, DELETE, "&Delete", false);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setReturnCode(DELETE);
				close();
			}
		});
	}

	// @Override
	// protected Control getFocusControl() {
	// return getText();
	// }
	//
	// @Override
	// protected Color getForeground() {
	// return myForm.getToolkit().getColors().getForeground();
	// }
	//
	// @Override
	// protected Color getBackground() {
	// return myForm.getToolkit().getColors().getBackground();
	// }

	/**
	 * ID used for the {@link IDialogSettings} of this dialog.
	 */
	public final String ID = CommentEditorDialog.class.getName();

	@Override
	protected IDialogSettings getDialogBoundsSettings() {
		final IDialogSettings settings = Activator.getDefault().getDialogSettings();
		IDialogSettings result = settings.getSection(ID);
		if (result == null) {
			result = settings.addNewSection(ID);
		}
		return result;
	}
}
