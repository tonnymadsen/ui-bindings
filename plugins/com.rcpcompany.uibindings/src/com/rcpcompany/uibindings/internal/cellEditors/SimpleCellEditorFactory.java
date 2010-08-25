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
		final Composite parent = factoryContext.getParent();
		final IValueBindingCell cell = factoryContext.getCell();

		final IValueBinding labelBinding = cell.getLabelBinding();
		final IBindingContext context = labelBinding.getContext();
		final IObservableValue value = cell.getObjectValue();

		final String preferredCellEditor = labelBinding.getArgument(Constants.ARG_PREFERRED_CELL_EDITOR, String.class,
				InternalConstants.CELL_EDITOR_TYPE_TEXT);

		/*
		 * The original value of the cell - used it the edit is canceled.
		 */
		final Object originalValue = value.getValue();

		/*
		 * The simple case: the boolean editor. This case does not have a visible editors...
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
					+ "' specifies illegal cell editor type: '" + preferredCellEditor + "'. ignored");
			return null;
		}

		/*
		 * The general case: the widget-based editors
		 */
		CellEditor ce;
		if (InternalConstants.CELL_EDITOR_TYPE_TEXT.equals(preferredCellEditor)) {
			ce = new MyTextCellEditor(parent, context);
		} else if (InternalConstants.CELL_EDITOR_TYPE_STYLED_TEXT.equals(preferredCellEditor)) {
			ce = new MyStyledTextCellEditor(parent, context);
		} else if (InternalConstants.CELL_EDITOR_TYPE_COMBO.equals(preferredCellEditor)) {
			ce = new ComboBoxCellEditor(parent, NO_ITEMS);
		} else if (InternalConstants.CELL_EDITOR_TYPE_CCOMBO.equals(preferredCellEditor)) {
			ce = new ComboBoxCellEditor(parent, NO_ITEMS);
		} else {
			LogUtils.error(labelBinding, "modelType '" + value.getValueType()
					+ "' specifies illegal cell editor type: '" + preferredCellEditor + "'. ignored");
			return null;
		}

		/*
		 * The binding for the text while editing
		 */
		final IValueBinding editorBinding = context.addBinding().ui(ce.getControl()).model(value);
		if (labelBinding.hasArguments()) {
			// TODO: problem with arguments
			editorBinding.getExtraArgumentProviders().add(labelBinding);
		}

		editorBinding.setCell(cell);

		/*
		 * Check if a special type has been specified for the cell editor
		 */
		final String cellEditorType = labelBinding.getArgument(Constants.ARG_CELL_EDITOR_TYPE, String.class, null);
		if (cellEditorType != null) {
			editorBinding.type(cellEditorType);
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
