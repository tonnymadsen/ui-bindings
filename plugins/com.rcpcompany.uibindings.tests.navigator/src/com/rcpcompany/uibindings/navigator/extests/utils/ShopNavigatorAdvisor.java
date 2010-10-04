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
package com.rcpcompany.uibindings.navigator.extests.utils;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;

import com.rcpcompany.uibindings.navigator.views.AbstractNavigatorBaseViewAdvisor;
import com.rcpcompany.uibindings.navigator.views.INavigatorBaseViewAdvisor;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

/**
 * Advisor for Navigation view
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ShopNavigatorAdvisor extends AbstractNavigatorBaseViewAdvisor implements INavigatorBaseViewAdvisor {
	@Override
	public IObservableList getRootElements() {
		final IObservableList list = WritableList.withElementType(ShopPackage.Literals.SHOP);
		list.add(ShopFactory.eINSTANCE.getShop(EditingDomainUtils.getEditingDomain()));
		return list;
	}
}
