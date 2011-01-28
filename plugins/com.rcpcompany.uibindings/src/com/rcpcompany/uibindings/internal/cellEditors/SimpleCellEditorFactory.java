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
/**
 * 
 */
package com.rcpcompany.uibindings.internal.cellEditors;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.swt.widgets.Composite;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.ICellEditorFactory;
import com.rcpcompany.uibindings.ICellEditorFactoryContext;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IValueBindingCell;
import com.rcpcompany.uibindings.internal.InternalConstants;
import com.rcpcompany.uibindings.internal.observables.IUpdatableObservable;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * The default cell editor factory used if no specific factory is specified for a cell.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SimpleCellEditorFactory implements ICellEditorFactory {
	/**
	 * Factory methods.
	 */
	public static final class Factory {
		private Factory() {
		}

		/**
		 * Returns the singleton factory.
		 * 
		 * @return the factory
		 */
		public static ICellEditorFactory getFactory() {
			if (theFactory == null) {
				theFactory = new SimpleCellEditorFactory();
			}
			return theFactory;
		}

		/**
		 * The factory singleton.
		 */
		private static ICellEditorFactory theFactory = null;
	};

	/**
	 * Constructs a new factory.
	 */
	protected SimpleCellEditorFactory() {
	}

	/**
	 * Items argument for the {@link ComboBoxCellEditor}.
	 */
	protected static final String[] NO_ITEMS = new String[0];

	@Override
	public CellEditor create(ICellEditorFactoryContext factoryContext) {
		final IValueBindingCell cell = factoryContext.getCell();

		final IValueBinding labelBinding = cell.getLabelBinding();
		final IBindingContext context = labelBinding.getContext();
		final IObservableValue value = cell.getObjectValue();

		String preferredCellEditor = labelBinding.getArgument(Constants.ARG_PREFERRED_CELL_EDITOR, String.class,
				InternalConstants.CELL_EDITOR_TYPE_CONTROL);

		/*
		 * The original value of the cell - used it the edit is canceled.
		 */
		final Object originalValue = value.getValue();

		/*
		 * The simple case: the boolean editor. This case does not have a visible editor...
		 */
		if (InternalConstants.CELL_EDITOR_TYPE_BUTTON.equals(preferredCellEditor)) {
			final Class<?> valueType = labelBinding.getDataType().getDataType();
			if (valueType == Boolean.class || valueType == Boolean.TYPE) return new ImmediateCellEditor(new Runnable() {
				@Override
				public void run() {
					final Boolean v = (Boolean) originalValue;
					value.setValue(v ? false : true);
				}
			});
			LogUtils.error(labelBinding, "modelType '" + value.getValueType()
					+ "' specifies illegal cell editor type: '" + preferredCellEditor + "'. Assumes "
					+ InternalConstants.CELL_EDITOR_TYPE_TEXT);
			preferredCellEditor = InternalConstants.CELL_EDITOR_TYPE_TEXT;
		}

		/*
		 * The general case: the widget-based editors
		 */
		CellEditor ce;
		final Composite parent = factoryContext.getParent();
		if (InternalConstants.CELL_EDITOR_TYPE_STYLED_TEXT.equals(preferredCellEditor)) {
			ce = new MyStyledTextCellEditor(parent, context);
		} else if (InternalConstants.CELL_EDITOR_TYPE_DIALOG.equals(preferredCellEditor)) {
			ce = new DialogControlCellEditor(parent, cell);
		} else {
			ce = new ControlCellEditor(parent, cell);
		}

		/*
		 * The binding for the text while editing
		 */
		final IValueBinding editorBinding = context.addBinding().ui(ce.getControl()).model(value);
		if (labelBinding.hasArguments()) {
			editorBinding.getExtraArgumentProviders().add(labelBinding);
		}
		if (labelBinding.eIsSet(IUIBindingsPackage.Literals.BINDING__EXTRA_ARGUMENT_PROVIDERS)) {
			editorBinding.getExtraArgumentProviders().addAll(labelBinding.getExtraArgumentProviders());
		}

		editorBinding.setCell(cell);

		/*
		 * Check if a special type has been specified for the cell editor
		 */
		final String cellEditorType = labelBinding.getArgument(Constants.ARG_CELL_EDITOR_TYPE, String.class, null);
		if (cellEditorType != null) {
			editorBinding.type(cellEditorType);
		}

		if (ce instanceof ControlCellEditor) {
			((ControlCellEditor) ce).setEditorBinding(editorBinding);
		} else if (ce instanceof DialogControlCellEditor) {
			((DialogControlCellEditor) ce).setEditorBinding(editorBinding);
		}

		/*
		 * We added a new binding to call finish as well...
		 */
		context.finish();

		/*
		 * And force an update
		 */
		editorBinding.updateUI();

		ce.addListener(new ICellEditorListener() {
			@Override
			public void editorValueChanged(boolean oldValidState, boolean newValidState) {
			}

			@Override
			public void cancelEditor() {
				value.setValue(originalValue);
				editorBinding.updateUI();
				editorBinding.dispose();
			}

			@Override
			public void applyEditorValue() {
				if (editorBinding.getUIObservable() instanceof IUpdatableObservable) {
					final IUpdatableObservable u = (IUpdatableObservable) editorBinding.getUIObservable();
					u.forceUpdateValue();
				}
				editorBinding.updateUI();
				editorBinding.dispose();
			}
		});

		return ce;
	}
}
