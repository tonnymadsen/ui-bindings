package com.rcpcompany.uibindings.shop.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;

public class NewContactWizard extends Wizard implements INewWizard {

	private final Contact myContact;

	public NewContactWizard() {
		// TODO Auto-generated constructor stub
		myContact = ShopFactory.eINSTANCE.createContact();
	}

	@Override
	public void addPages() {
		addPage(new ContactNamePage(myContact));
		super.addPages();
	}

	@Override
	public boolean performFinish() {
		ShopFactory.eINSTANCE.getShop().getContacts().add(myContact);
		return true;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}

}
