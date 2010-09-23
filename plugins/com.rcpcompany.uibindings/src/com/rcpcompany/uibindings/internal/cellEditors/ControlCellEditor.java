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
package com.rcpcompany.uibindings.internal.cellEditors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IValueBindingCell;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Special edition of {@link TextCellEditor}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ControlCellEditor extends CellEditor {
	/**
	 * The cell of the editor.
	 */
	private final IValueBindingCell myCell;

	/**
	 * The editor binding for the control of this cell editor.
	 */
	private IValueBinding myEditorBinding;

	/**
	 * For Text based editors: Used to signal that the text has just been replaced and should not be
	 * selected.
	 */
	private boolean justReplacedText = false;

	private IHandlerActivation myActiveUndoHandler;
	/* package */IHandler undoHandler = new AbstractHandler() {
		@Override
		public Object execute(ExecutionEvent event) {
			if (Activator.getDefault().TRACE_HANDLERS) {
				LogUtils.debug(this, "");
			}
			cancelEdit();
			return null;
		}
	};

	/**
	 * Constructs and returns a new cell editors for the specified cell.
	 * 
	 * @param parent the parent composite
	 * @param cell the cell for this cell editor
	 */
	public ControlCellEditor(Composite parent, IValueBindingCell cell) {
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
		 * Call twice!
		 * 
		 * First time indirectly from the super constructor and thus myCell is not set.
		 */
		if (getCell() == null) return null;
		return getLabelBinding().createPreferredControl(parent, SWT.NONE, true);
	}

	/**
	 * Returns the cell of the {@link CellEditor}.
	 * 
	 * @return the cell
	 */
	private IValueBindingCell getCell() {
		return myCell;
	}

	/**
	 * Returns the label binding used in the container for the cell.
	 * <p>
	 * This is <em>not</em> the same as the binding for the control of this cell editor.
	 * 
	 * @return the label binding
	 */
	private IValueBinding getLabelBinding() {
		return getCell().getLabelBinding();
	}

	/**
	 * Returns the editor binding for this cell editor.
	 * 
	 * @return the binding
	 */
	public IValueBinding getEditorBinding() {
		return myEditorBinding;
	}

	/**
	 * Sets the editor binding of this cell editor.
	 * 
	 * @param binding the new editor binding
	 */
	public void setEditorBinding(IValueBinding binding) {
		myEditorBinding = binding;

		initControl();
	}

	/**
	 * Initializes the control.
	 */
	private void initControl() {
		final Control c = getControl();
		final Text t = getTextControl();

		if (t != null) {
			t.addListener(SWT.DefaultSelection, myListener);
		}
		c.addListener(SWT.KeyDown, myListener);
		c.addListener(SWT.Traverse, myListener);
		c.addListener(SWT.FocusOut, myListener);
		if (t != null && t != c) {
			t.addListener(SWT.FocusOut, myListener);
		}
	}

	/**
	 * Listener for the control of the cell editor.
	 */
	private final Listener myListener = new Listener() {
		@Override
		public void handleEvent(Event event) {
			// LogUtils.debug(this, ToStringUtils.toString(event));
			switch (event.type) {
			case SWT.DefaultSelection:
				endEdit();
				break;
			case SWT.KeyDown:
				if (event.character == SWT.ESC) {
					cancelEdit();
				} else if (event.character == SWT.CR) {
					/*
					 * The general handling of CR in Text widgets is via the Selection event (see
					 * above).
					 * 
					 * But... for a MULTI-line Text widget CTRL+CR is also handled
					 */
					final Text text = getTextControl();
					if (text != null) {
						if (!text.isDisposed() && (text.getStyle() & SWT.MULTI) == SWT.MULTI
								&& (event.stateMask & SWT.CTRL) != SWT.CTRL) {
							endEdit();
						}
					} else {

						endEdit();
					}
				}
				break;
			case SWT.FocusOut:
				focusLost();
				break;
			case SWT.Traverse:
				/*
				 * ESC and CR are handled by the editor
				 */
				if (event.detail == SWT.TRAVERSE_ESCAPE || event.detail == SWT.TRAVERSE_RETURN) {
					event.doit = false;
				}
				break;
			default:
				break;
			}
		}
	};

	/**
	 * Returns the context for this cell editor.
	 * <p>
	 * It is the same context for the {@link #getLabelBinding() label binding} and the cell
	 * {@link #getEditorBinding() editor binding}.
	 * 
	 * @return the context
	 */
	private IBindingContext getContext() {
		return getLabelBinding().getContext();
	}

	/**
	 * Returns the primary {@link Text} control component of the current {@link #getControl() cell
	 * editor control} if one exists.
	 * 
	 * @return the primary {@link Text} control or <code>null</code>
	 */
	private Text getTextControl() {
		if (getControl() instanceof Text) return (Text) getControl();
		final Control c = getEditorBinding().getUIAttribute().getFieldAssistControl();
		if (c instanceof Text) return (Text) c;

		return null;
	}

	@Override
	public void activate(ColumnViewerEditorActivationEvent activationEvent) {
		super.activate(activationEvent);

		/*
		 * If the editor was activated using a key - see Manager.isEditCellAnyKey() - then replace
		 * the content and consume the event
		 */
		if (activationEvent.eventType == ColumnViewerEditorActivationEvent.KEY_PRESSED
				&& !Character.isISOControl(activationEvent.character)) {
			final Text t = getTextControl();
			if (t != null) {
				t.setText(new String(new char[] { activationEvent.character }));
				justReplacedText = true;
				if (activationEvent.sourceEvent instanceof KeyEvent) {
					final KeyEvent e = (KeyEvent) activationEvent.sourceEvent;
					e.doit = false;
				}
			}
		}

		if (Activator.getDefault().TRACE_HANDLERS) {
			LogUtils.debug(undoHandler, "activating '" + IWorkbenchCommandConstants.EDIT_UNDO + "' handler");
		}
		final IHandlerService hs = (IHandlerService) getContext().getServiceLocator().getService(IHandlerService.class);
		myActiveUndoHandler = hs.activateHandler(IWorkbenchCommandConstants.EDIT_UNDO, undoHandler,
				Constants.TRUE_EXPRESSION);
	}

	@Override
	public void deactivate() {
		super.deactivate();
		if (myActiveUndoHandler != null) {
			if (Activator.getDefault().TRACE_HANDLERS) {
				LogUtils.debug(undoHandler, "deactivating '" + IWorkbenchCommandConstants.EDIT_UNDO + "' handler");
			}
			final IHandlerService hs = (IHandlerService) getContext().getServiceLocator().getService(
					IHandlerService.class);
			hs.deactivateHandler(myActiveUndoHandler);
			myActiveUndoHandler = null;
		}
	}

	@Override
	protected void doSetFocus() {
		getControl().setFocus();
		final Text text = getTextControl();
		if (text != null) {
			if (justReplacedText) {
				text.setSelection(text.getText().length());
				justReplacedText = false;
			} else {
				text.selectAll();
			}
		}
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
}
