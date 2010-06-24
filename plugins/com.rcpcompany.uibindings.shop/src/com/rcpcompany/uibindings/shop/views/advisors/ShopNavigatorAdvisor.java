package com.rcpcompany.uibindings.shop.views.advisors;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;

import com.rcpcompany.uibindings.navigator.views.AbstractNavigatorBaseViewAdvisor;
import com.rcpcompany.uibindings.navigator.views.INavigatorBaseViewAdvisor;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Advisor for Navigation view
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ShopNavigatorAdvisor extends AbstractNavigatorBaseViewAdvisor implements INavigatorBaseViewAdvisor {
	@Override
	public IObservableList getRootElements() {
		final IObservableList list = WritableList.withElementType(ShopPackage.Literals.SHOP);
		list.add(ShopFactory.eINSTANCE.getShop());
		return list;
	}

}
