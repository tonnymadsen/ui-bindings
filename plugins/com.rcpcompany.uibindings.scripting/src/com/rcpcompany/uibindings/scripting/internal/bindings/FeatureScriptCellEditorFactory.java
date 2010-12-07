package com.rcpcompany.uibindings.scripting.internal.bindings;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.rcpcompany.uibindings.ICellEditorFactory;
import com.rcpcompany.uibindings.ICellEditorFactoryContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IValueBindingCell;
import com.rcpcompany.uibindings.moao.IMOAO;

/**
 * {@link ICellEditorFactory} for cells with a feature script attached.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FeatureScriptCellEditorFactory implements ICellEditorFactory {
	@Override
	public CellEditor create(ICellEditorFactoryContext context) {
		final Composite parent = context.getParent();
		final IValueBindingCell cell = context.getCell();
		final IValueBinding vb = cell.getLabelBinding();

		final CellEditor ce = new CellEditor(parent) {
			private FeatureScriptDialog myDialog;

			@Override
			protected Control createControl(Composite parent) {
				final Shell shell = parent.getShell();
				if (!(vb.getModelObject() instanceof IMOAO)) return null;

				myDialog = new FeatureScriptDialog(shell, vb);

				return myDialog.getShell();
			}

			@Override
			public void activate() {
				super.activate();
				myDialog.open();

				deactivate();
			}

			@Override
			protected Object doGetValue() {
				return null;
			}

			@Override
			protected void doSetFocus() {
			}

			@Override
			protected void doSetValue(Object value) {
			}
		};

		return ce;
	}
}
