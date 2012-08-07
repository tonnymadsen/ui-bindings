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
package com.rcpcompany.uibindings.shop.views.advisors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;

import com.rcpcompany.uibindings.IConstantTreeItem;
import com.rcpcompany.uibindings.navigator.views.AbstractNavigatorBaseViewAdvisor;
import com.rcpcompany.uibindings.navigator.views.INavigatorBaseViewAdvisor;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IManagerRunnable;
import com.rcpcompany.uibindings.utils.SelectionUtils;

/**
 * Advisor for Navigation view.
 * <p>
 * Will just show the orders for the current selection
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ShopNavigatorOrderAdvisor extends AbstractNavigatorBaseViewAdvisor implements INavigatorBaseViewAdvisor {
	private IViewSite mySite;
	private final IObservableList myList = WritableList.withElementType(ShopPackage.Literals.CUSTOMER);

	@Override
	public IObservableList getRootElements() {
		return myList;
	}

	@Override
	public String getTreeID() {
		return "orders";
	}

	@Override
	public void setSite(IViewSite site) {
		super.setSite(site);
		mySite = site;

		final ISelectionService ss = mySite.getPage().getWorkbenchWindow().getSelectionService();
		ss.addPostSelectionListener(mySelectionListener);
		mySelectionListener.selectionChanged(null, ss.getSelection());
	}

	@Override
	public void dispose() {
		super.dispose();
		final ISelectionService ss = mySite.getPage().getWorkbenchWindow().getSelectionService();

		ss.removePostSelectionListener(mySelectionListener);
		IManagerRunnable.Factory.cancelAsyncExec("update", ShopNavigatorOrderAdvisor.this);

	}

	private final ISelectionListener mySelectionListener = new ISelectionListener() {
		@Override
		public void selectionChanged(IWorkbenchPart part, final ISelection selection) {
			/*
			 * Don't react to selection in the navigator itself
			 */
			if (part != null && part.getSite() == mySite) return;
			IManagerRunnable.Factory.asyncExec("update", ShopNavigatorOrderAdvisor.this, new Runnable() {
				@Override
				public void run() {
					final List<EObject> l = SelectionUtils.computeSelection(selection, EObject.class);

					if (l.size() != 1) return;

					final List<Customer> newCustomers = new ArrayList<Customer>();
					EObject o = l.get(0);
					/*
					 * Virtual containers...
					 */
					if (o instanceof IConstantTreeItem) {
						o = ((IConstantTreeItem) o).getTarget();
					}
					do {
						if (o instanceof Customer) {
							final Customer c = (Customer) o;
							newCustomers.add(c);
							break;
						} else if (o instanceof Contact) {
							final Contact c = (Contact) o;
							if (c.getCustomer() != null) {
								newCustomers.add(c.getCustomer());
								break;
							}
						} else if (o instanceof Shop) {
							final Shop s = (Shop) o;
							/*
							 * TODO: should follow the base list...
							 */
							newCustomers.addAll(s.getCustomers());
							break;
						}
						o = o.eContainer();
						if (o == null) return;
					} while (true);

					if (newCustomers.equals(myList)) return;
					myList.clear();
					myList.addAll(newCustomers);
				}
			});
		}
	};
}
