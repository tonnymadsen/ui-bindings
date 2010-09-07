package com.rcpcompany.uibindings.shop.observableListFactories;

import org.eclipse.core.databinding.observable.list.IObservableList;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IObservableListFactory;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * {@link IObservableListFactory} for {@link ShopItem}.
 */
public class CustomersObservableListFactory implements IObservableListFactory {
	@Override
	public IObservableList createList(IValueBinding binding) {
		final Shop shop = ShopFactory.eINSTANCE.getShop(IManager.Factory.getManager().getEditingDomain());
		return UIBindingsEMFObservables.observeList(binding.getEditingDomain(), shop,
				ShopPackage.Literals.SHOP__CUSTOMERS);
	}
}
