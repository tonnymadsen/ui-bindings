/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.shop.observableListFactories;

import org.eclipse.core.databinding.observable.list.IObservableList;

import com.rcpcompany.uibindings.IObservableListFactory;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

/**
 * {@link IObservableListFactory} for {@link Customers}.
 */
public class ShopGroupsObservableListFactory implements IObservableListFactory {
	@Override
	public IObservableList createList(IValueBinding binding) {
		final Shop shop = ShopFactory.eINSTANCE.getShop(EditingDomainUtils.getEditingDomain());
		return UIBindingsEMFObservables.observeList(binding.getEditingDomain(), shop,
				ShopPackage.Literals.SHOP__SHOP_GROUPS);
	}
}
