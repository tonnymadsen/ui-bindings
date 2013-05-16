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
package com.rcpcompany.uibindings.internal.cellEditors;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IValueBindingCell;

/**
 * Special edition of {@link TextCellEditor}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DialogControlCellEditor extends CellEditor {
	/**
	 * The cell of the editor.
	 */
	private final IValueBindingCell myCell;

	private MyDialog myDialog;

	/**
	 * Constructs and returns a new cell editors for the specified cell.
	 * 
	 * @param parent the parent composite
	 * @param cell the cell for this cell editor
	 */
	public DialogControlCellEditor(Composite parent, IValueBindingCell cell) {
		super(parent, SWT.SINGLE | SWT.LEAD);
		myCell = cell;

		/*
		 * Call create again... this time myCell is set.
		 */
		create(parent);
	}

	@Override
	protected Control createControl(Composite parent) {
		/*
		 * Called twice!
		 * 
		 * First time indirectly from the super constructor and thus myCell is not set.
		 */
		if (getCell() == null) return null;
		myDialog = new MyDialog(parent.getShell());

		myDialog.create();

		return myDialog.getCE().getControl();
	}

	/**
	 * Returns the cell of the {@link CellEditor}.
	 * 
	 * @return the cell
	 */
	private IValueBindingCell getCell() {
		return myCell;
	}

	@Override
	public LayoutData getLayoutData() {
		final LayoutData result = new LayoutData();
		return result;
	}

	/**
	 * Sets the editor binding of this cell editor.
	 * 
	 * @param binding the new editor binding
	 */
	public void setEditorBinding(IValueBinding binding) {
		myDialog.getCE().setEditorBinding(binding);
	}

	@Override
	public void activate(ColumnViewerEditorActivationEvent activationEvent) {
		super.activate(activationEvent);
		myDialog.getCE().activate(activationEvent);
		// myDialog.open();
	}

	@Override
	public void deactivate() {
		super.deactivate();
	}

	@Override
	protected void doSetFocus() {
		getControl().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				myDialog.open();
			}
		});
	}

	@Override
	protected void focusLost() {
		super.focusLost();
	}

	/**
	 * Cancels the current edit.
	 */
	private void cancelEdit() {
		fireCancelEditor();
		deactivate();
	}

	/**
	 * Ends the current edit.
	 * <p>
	 * Handled as a focus lost event...
	 */
	private void endEdit() {
		focusLost();
	}

	@Override
	protected Object doGetValue() {
		return null;
	}

	@Override
	protected void doSetValue(Object value) {
	}

	public class MyDialog extends Dialog {

		private ControlCellEditor myCE;

		public ControlCellEditor getCE() {
			return myCE;
		}

		protected MyDialog(Shell parentShell) {
			super(parentShell);
		}

		@Override
		protected Control createContents(Composite parent) {
			final Composite top = new Composite(parent, SWT.NONE);
			top.setLayout(new GridLayout(2, false));

			myCE = new ControlCellEditor(top, getCell());
			final GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
			layoutData.minimumWidth = 200;
			myCE.getControl().setLayoutData(layoutData);

			/*
			 * Forward all events to the caller
			 */
			myCE.addListener(new ICellEditorListener() {
				@Override
				public void editorValueChanged(boolean oldValidState, boolean newValidState) {
					fireEditorValueChanged(oldValidState, newValidState);
				}

				@Override
				public void cancelEditor() {
					cancelPressed();
					fireCancelEditor();
				}

				@Override
				public void applyEditorValue() {
					okPressed();
					fireApplyEditorValue();
				}
			});

			final Button button = new Button(top, SWT.PUSH);
			button.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
			button.setText("OK");
			getShell().setDefaultButton(button);

			button.addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					myCE.focusLost();
					okPressed();
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					widgetSelected(e);
				}
			});

			return top;
		}
	}
}
