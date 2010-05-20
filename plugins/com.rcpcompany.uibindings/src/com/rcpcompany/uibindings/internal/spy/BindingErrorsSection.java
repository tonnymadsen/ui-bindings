package com.rcpcompany.uibindings.internal.spy;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingSpySection;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Basic section for {@link IValueBinding}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingErrorsSection implements IBindingSpySection {
	@Override
	public void build(IFormCreator creator, ExecutionEvent event) {
		final IBinding b = (IBinding) creator.getObject();

		if (!b.eIsSet(IUIBindingsPackage.Literals.BINDING__ERROR_CONDITIONS)) {
			return;
		}

		final IFormCreator subform = creator.addSection("Error Conditions");

		final Table table = subform.getToolkit()
				.createTable(subform.getTop(), SWT.V_SCROLL | SWT.H_SCROLL | SWT.SINGLE);
		final TableColumn column = new TableColumn(table, SWT.None);

		for (final String e : b.getErrorConditions()) {
			final TableItem item = new TableItem(table, SWT.NONE);
			item.setText(e);
		}
	}
}
