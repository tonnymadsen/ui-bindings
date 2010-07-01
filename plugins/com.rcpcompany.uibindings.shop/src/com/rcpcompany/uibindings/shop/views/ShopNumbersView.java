package com.rcpcompany.uibindings.shop.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Simple view to show some very basic information about the {@link Shop}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ShopNumbersView extends ViewPart {

	private IFormCreator myForm;

	@Override
	public void createPartControl(Composite parent) {
		myForm = IFormCreator.Factory.createScrolledForm(ShopFactory.eINSTANCE.getShop(), parent, "Shop Numbers");

		myForm.addField("name");
		myForm.addField("nextOrderNo");
		myForm.addField("nextCustomerNo");
		myForm.addField("tmpDir");

		myForm.finish();
		IBindingContextSelectionProvider.Factory.adapt(myForm.getContext(), getSite());
	}

	@Override
	public void setFocus() {
		myForm.setFocus();
	}
}
