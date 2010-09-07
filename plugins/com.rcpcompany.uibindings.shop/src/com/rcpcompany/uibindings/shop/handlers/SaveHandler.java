package com.rcpcompany.uibindings.shop.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;

public class SaveHandler extends AbstractHandler implements IHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final Shop shop = ShopFactory.eINSTANCE.getShop(IManager.Factory.getManager().getEditingDomain());
		shop.save();
		return null;
	}

}
