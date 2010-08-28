package com.rcpcompany.uibindings.shop.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;

public class ShopNameView extends ViewPart {

	public Text myShopName;
	private final FormToolkit myToolkit = IManager.Factory.getManager().getFormToolkit();
	private ScrolledForm myForm;

	@Override
	public void createPartControl(Composite parent) {
		myForm = myToolkit.createScrolledForm(parent);
		final Composite body = myForm.getBody();
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		body.setLayout(gridLayout);
		myToolkit.paintBordersFor(body);
		myForm.setText("Shop");

		myToolkit.createLabel(body, "Name:", SWT.NONE);

		myShopName = myToolkit.createText(body, null, SWT.NONE);
		myShopName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		bindUI();
	}

	private void bindUI() {
		final Shop shop = ShopFactory.eINSTANCE.getShop();

		final IBindingContext context = IBindingContext.Factory.createContext(myForm);

		context.addBinding(myShopName, shop, IMOAOPackage.Literals.NAMED_OBJECT__NAME);

		context.finish();
		IBindingContextSelectionProvider.Factory.adapt(context, getSite());
	}

	@Override
	public void setFocus() {
		myShopName.setFocus();
	}
}
