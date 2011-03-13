package com.rcpcompany.uibindings.shop.participants;

import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.participants.IAssignmentParticipant;
import com.rcpcompany.uibindings.participants.IAssignmentParticipantContext;
import com.rcpcompany.uibindings.tests.shop.ShopItem;

public class ShopItemToGroupAsignmentParticipant implements IAssignmentParticipant {

	@Override
	public void assign(IAssignmentParticipantContext context) {
		final ShopItem si = (ShopItem) context.getSourceObject();
		context.setStructuralFeature(IMOAOPackage.Literals.NAMED_OBJECT__NAME, si.getName());
	}
}
