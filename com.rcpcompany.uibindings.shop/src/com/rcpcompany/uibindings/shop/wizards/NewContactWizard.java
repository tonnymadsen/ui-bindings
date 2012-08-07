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
package com.rcpcompany.uibindings.shop.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

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
		ShopFactory.eINSTANCE.getShop(EditingDomainUtils.getEditingDomain()).getContacts().add(myContact);
		return true;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}

}
