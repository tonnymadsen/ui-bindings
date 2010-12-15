package com.rcpcompany.uibindings.shop.initializers;

import com.rcpcompany.uibindings.IInitializationParticipant;
import com.rcpcompany.uibindings.IInitializationParticipantContext;
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
			if (context.getParent() instanceof Shop) {
				final Shop shop = (Shop) context.getParent();

				no = shop.getNextOrderNo();
				shop.setNextOrderNo(no + 1);
			}

			context.setStructuralFeature(ShopPackage.Literals.ORDER__NO, no);
		}
	}
}
