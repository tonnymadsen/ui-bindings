package com.rcpcompany.uibindings.shop.wizards;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.utils.IFormCreator;

public class ContactNamePage extends WizardPage implements IWizardPage {

	private final Contact myContact;

	public ContactNamePage(Contact contact) {
		super("name", "Enter basic contact information", null);
		myContact = contact;
	}

	private final Shop myShop = ShopFactory.eINSTANCE.getShop();
	private Text myNameText;
	private Text myCountryText;

	@Override
	public void createControl(Composite parent) {
		final IFormCreator form = IFormCreator.Factory.createWizardPage(myContact, this, parent);
		setControl(form.getTop());

		form.addField("name");
		form.addField("country");

		form.finish();
	}
}
