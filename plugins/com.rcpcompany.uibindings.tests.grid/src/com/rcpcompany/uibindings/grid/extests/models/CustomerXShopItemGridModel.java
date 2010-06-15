package com.rcpcompany.uibindings.grid.extests.models;

import java.util.Map;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.grid.IGridCell;
import com.rcpcompany.uibindings.grid.IGridModel;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.Order;
import com.rcpcompany.uibindings.tests.shop.OrderItem;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * A basic grid model with {@link Customer customers} versus {@link ShopItem shop items}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class CustomerXShopItemGridModel implements IGridModel {
	private final EditingDomain myEditingDomain;
	private final Shop myShop;
	private final IObservableList myCustomers;
	private final IObservableList myShopItems;

	public CustomerXShopItemGridModel(EditingDomain editingDomain, Shop shop) {
		myEditingDomain = editingDomain;
		myShop = shop;
		myCustomers = UIBindingsEMFObservables.observeList(myEditingDomain, shop, ShopPackage.Literals.SHOP__CUSTOMERS);
		myShopItems = UIBindingsEMFObservables
				.observeList(myEditingDomain, shop, ShopPackage.Literals.SHOP__SHOP_ITEMS);
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
			return null;
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
			myCustomerOrderList = UIBindingsEMFObservables.observeList(myEditingDomain, customer,
					ShopPackage.Literals.CUSTOMER__ORDERS);
			myItemOrderList = UIBindingsEMFObservables.observeList(myEditingDomain, item,
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
