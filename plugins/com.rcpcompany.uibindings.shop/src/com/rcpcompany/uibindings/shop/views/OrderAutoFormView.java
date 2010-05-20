package com.rcpcompany.uibindings.shop.views;

import com.rcpcompany.uibindings.tests.shop.Order;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.views.AutoFormBaseView;

public class OrderAutoFormView extends AutoFormBaseView<Order> {
	public OrderAutoFormView() {
		super(ShopPackage.Literals.ORDER, "Order");
	}
}
