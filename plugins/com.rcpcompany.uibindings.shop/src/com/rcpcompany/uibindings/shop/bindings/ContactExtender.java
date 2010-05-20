package com.rcpcompany.uibindings.shop.bindings;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;

import com.rcpcompany.uibindings.DecorationPosition;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

public class ContactExtender extends AbstractUIBindingDecoratorExtender implements IUIBindingDecoratorExtender {

	@Override
	public boolean isEnabled(IValueBinding binding) {
		return binding.isEClassFeature(null, ShopPackage.Literals.CONTACT__NAME);
	}

	final Image cornerImage = UIBindingsUtils.getCornerImage(DecorationPosition.TOP_RIGHT, new RGB(0, 0, 255));

	@Override
	public void extend(IUIBindingDecoratorExtenderContext context) {
		final EObject value = context.getBinding().getModelObject();
		if (!(value instanceof Contact)) {
			return;
		}

		final Contact c = (Contact) value;
		if (c.getCustomer() != null) {
			context.setDecoratingImage(DecorationPosition.TOP_RIGHT, false, cornerImage, "Contact is a customer");
		}
	}
}
