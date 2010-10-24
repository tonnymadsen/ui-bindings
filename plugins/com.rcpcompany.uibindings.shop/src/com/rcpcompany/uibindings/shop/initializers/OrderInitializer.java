package com.rcpcompany.uibindings.shop.initializers;

import com.rcpcompany.uibindings.IInitializer;
import com.rcpcompany.uibindings.IInitializerContext;
import com.rcpcompany.uibindings.tests.shop.Order;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * {@link IInitializer} for {@link Order#getNo()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class OrderInitializer implements IInitializer {

	@Override
	public void initialize(IInitializerContext context, Object facet) {
		if (facet == ShopPackage.Literals.ORDER__NO) {
			int no = 0;
			if (context.getParent() instanceof Shop) {
				final Shop shop = (Shop) context.getParent();

				no = shop.getNextOrderNo();
				shop.setNextOrderNo(no + 1);
			}

			context.setStructuralFeature(ShopPackage.Literals.ORDER__NO, no);
		}
	}
}
