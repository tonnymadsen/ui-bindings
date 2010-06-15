package com.rcpcompany.uibindings.internal.spy;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingSpySection;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Section for the services of the binding.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingServicesSection implements IBindingSpySection {
	@Override
	public void build(IFormCreator creator, ExecutionEvent event) {
		final IBinding b = (IBinding) creator.getObject();

		if (!b.eIsSet(IUIBindingsPackage.Literals.SERVICE_REGISTRY__SERVICES)) return;

		final IFormCreator subform = creator.addSection("Services");

		final Table table = subform.getToolkit().createTable(subform.getTop(),
				SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL | SWT.SINGLE);
		final TableColumn column = new TableColumn(table, SWT.None);

		// subform.getContext().addViewer(table, b,
		// IUIBindingsPackage.Literals.SERVICE_REGISTRY__SERVICES);

		for (final Object e : b.getServices()) {
			final TableItem item = new TableItem(table, SWT.NONE);
			item.setText(e.toString());
		}
	}
}
