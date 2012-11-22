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
package com.rcpcompany.uibindings.internal.spy;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * The Binding Spy Dialog. Loosely modeled on the PDE Spy Dialog.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingSpyDialog extends PopupDialog {
	/**
	 * The binding is question...
	 */
	protected final IBinding myBinding;

	/**
	 * The top composite of the dialog.
	 */
	private Composite myTop;

	/**
	 * The event that triggered the dialog.
	 */
	private final ExecutionEvent myEvent;

	/**
	 * Creates the dialog.
	 * 
	 * @param parentShell the parent shell
	 * @param binding the binding for the dialog
	 * @param event the event that triggered the dialog
	 */
	public BindingSpyDialog(Shell parentShell, IBinding binding, ExecutionEvent event) {
		super(parentShell, SWT.NONE, true, true, false, false, false, null, "Press 'Escape' to close the dialog.");

		myBinding = binding;
		myEvent = event;
	}

	/*
	 * @see org.eclipse.jface.window.Window#configureShell(Shell)
	 */
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		// PlatformUI.getWorkbench().getHelpSystem().setHelp(shell, IHelpContextIds.SPY_DIALOG);
	}

	@Override
	protected Control createContents(Composite parent) {
		getShell().setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
		initializeBounds();
		return createDialogArea(parent);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		myTop = (Composite) super.createDialogArea(parent);

		final IFormCreator form = IFormCreator.Factory.createScrolledForm(myBinding, myTop, "Binding Spy");
		form.setReadOnly(true);
		final Image image = PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT).createImage();
		final ScrolledForm scrolledForm = form.getScrolledForm();
		scrolledForm.setImage(image);

		// add a Close button to the toolbar
		scrolledForm.getToolBarManager().add(new CloseAction());
		scrolledForm.getToolBarManager().update(true);

		// TODO: make this so we use an extension point.

		new BindingBasicSection().build(form, myEvent);
		new ValueBindingBasicSection().build(form, myEvent);
		new ValueBindingAttributeSection().build(form, myEvent);
		new ColumnBindingBasicSection().build(form, myEvent);
		new ViewerBindingBasicSection().build(form, myEvent);
		new BindingCreationSection().build(form, myEvent);
		new BindingErrorsSection().build(form, myEvent);
		new BindingArgumentsSection().build(form, myEvent);
		new BindingServicesSection().build(form, myEvent);
		new EventSection().build(form, myEvent);

		form.finish();
		// TODO: ContextSelectionProvider.adapt(myContext, getSite());

		return myTop;
	}

	@Override
	protected Point getInitialLocation(Point size) {
		final Point anchor = getShell().getDisplay().getCursorLocation();
		if (anchor == null) return super.getInitialLocation(size);
		final Point point = anchor;
		final Rectangle monitor = getShell().getMonitor().getClientArea();
		if (monitor.width < point.x + size.x) {
			point.x = Math.max(0, point.x - size.x);
		}
		if (monitor.height < point.y + size.y) {
			point.y = Math.max(0, point.y - size.y);
		}
		return point;
	}

	@Override
	protected Control getFocusControl() {
		return myTop;
	}

	protected class CloseAction extends Action {
		@Override
		public ImageDescriptor getImageDescriptor() {
			return PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_DELETE);
		}

		@Override
		public String getToolTipText() {
			return "Close the dialog";
		}

		@Override
		public void run() {
			close();
		}
	}

}
