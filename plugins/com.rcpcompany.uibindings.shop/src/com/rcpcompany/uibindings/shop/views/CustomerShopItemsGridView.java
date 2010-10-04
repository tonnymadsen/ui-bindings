/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.shop.views;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.IGridCell;
import com.rcpcompany.uibindings.grid.IGridModel;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.Order;
import com.rcpcompany.uibindings.tests.shop.OrderItem;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IFormCreator;

public class CustomerShopItemsGridView extends ViewPart {

	private IFormCreator myForm;

	public CustomerShopItemsGridView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		final Shop shop = ShopFactory.eINSTANCE.getShop(EditingDomainUtils.getEditingDomain());
		myForm = IFormCreator.Factory.createScrolledForm(shop, parent, "Customers versus Shop Items");

		final Grid g = new Grid(myForm.addComposite(true, true), SWT.NONE);
		myForm.getToolkit().adapt(g, true, true);

		final IGridModel model = new Model(shop);
		IGridBinding.Factory.createGrid(myForm.getContext(), g, model);

		myForm.finish();
		IBindingContextSelectionProvider.Factory.adapt(myForm.getContext(), getSite());
	}

	@Override
	public void setFocus() {
		myForm.setFocus();
	}

	protected class Model implements IGridModel {
		private final Shop myShop;
		private final IObservableList myCustomers;
		private final IObservableList myShopItems;

		public Model(Shop shop) {
			myShop = shop;
			myCustomers = UIBindingsEMFObservables.observeList(myForm.getContext().getEditingDomain(), shop,
					ShopPackage.Literals.SHOP__CUSTOMERS);
			myShopItems = UIBindingsEMFObservables.observeList(myForm.getContext().getEditingDomain(), shop,
					ShopPackage.Literals.SHOP__SHOP_ITEMS);
		}

		@Override
		public IGridCell getCell(Object columnID, Object rowID) {
			return new Cell(columnID, rowID);
		}

		@Override
		public IObservableList getColumnIDs() {
			return myShopItems;
		}

		@Override
		public IObservableList getRowIDs() {
			return myCustomers;
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}
	}

	protected class Cell implements IGridCell {
		private final Object myRowID;
		private final Object myColumnID;

		private final ShopItem myItem;
		private final Customer myCustomer;

		public Cell(Object columnID, Object rowID) {
			myColumnID = columnID;
			myRowID = rowID;

			if (columnID instanceof ShopItem) {
				myItem = (ShopItem) columnID;
			} else {
				myItem = null;
			}
			if (rowID instanceof Customer) {
				myCustomer = (Customer) rowID;
			} else {
				myCustomer = null;
			}
		}

		@Override
		public Map<String, Object> getArguments() {
			final Map<String, Object> map = new HashMap<String, Object>();
			map.put(Constants.ARG_READONLY, true);
			return map;
		}

		@Override
		public IObservableValue getValue() {
			if (myItem == null && myCustomer == null)
				return null;
			else if (myItem == null)
				return Observables.constantObservableValue(myCustomer, myCustomer.eClass());
			else if (myCustomer == null) return Observables.constantObservableValue(myItem, myItem.eClass());
			// Both myItem and myCustomer non-null!!!
			return new CountCustomerShopItemOV(myCustomer, myItem);
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}
	}

	protected class CountCustomerShopItemOV extends ComputedValue implements IObservableValue {

		private final IObservableList myCustomerOrderList;
		private final IObservableList myItemOrderList;

		public CountCustomerShopItemOV(Customer customer, ShopItem item) {
			super(Boolean.class);
			myCustomerOrderList = UIBindingsEMFObservables.observeList(myForm.getContext().getEditingDomain(),
					customer, ShopPackage.Literals.CUSTOMER__ORDERS);
			myItemOrderList = UIBindingsEMFObservables.observeList(myForm.getContext().getEditingDomain(), item,
					ShopPackage.Literals.SHOP_ITEM__ORDER_ITEMS);
		}

		@Override
		protected Object calculate() {
			for (final Object oo : myCustomerOrderList) {
				final Order o = (Order) oo;
				for (final Object oio : myItemOrderList) {
					final OrderItem oi = (OrderItem) oio;
					if (oi.getOrder() == o) return true;
				}
			}
			return false;
		}
	}
}
