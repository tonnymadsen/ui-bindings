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
package com.rcpcompany.uibindings.shop.initializers;

import com.rcpcompany.uibindings.participants.IInitializationParticipant;
import com.rcpcompany.uibindings.participants.IInitializationParticipantContext;
import com.rcpcompany.uibindings.tests.shop.Order;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * {@link IInitializationParticipant} for {@link Order#getNo()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class OrderInitializer implements IInitializationParticipant {

	@Override
	public void initialize(IInitializationParticipantContext context, Object facet) {
		if (facet == ShopPackage.Literals.ORDER__NO) {
			int no = 0;
			final Shop shop = (Shop) context.getStructuralFeature(ShopPackage.Literals.ORDER__SHOP);
			if (shop != null) {
				no = shop.getNextOrderNo();
				shop.setNextOrderNo(no + 1);
				context.setStructuralFeature(ShopPackage.Literals.ORDER__NO, no);
			}
		}
	}
}
