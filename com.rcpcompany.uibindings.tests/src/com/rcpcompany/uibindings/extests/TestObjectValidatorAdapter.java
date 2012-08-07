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
/**
 * 
 */
package com.rcpcompany.uibindings.extests;

import static org.junit.Assert.*;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.bindingMessages.AbstractBindingMessage;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.validators.IValidatorAdapter;

public class TestObjectValidatorAdapter implements IValidatorAdapter {
	public static final float LIMIT = 100f;
	public static final String ERROR_MESSAGE = "This is an error";

	private final Shop myShop;
	private final ShopItem myItem;

	private final AbstractBindingMessage myItemMessage;
	private final AbstractBindingMessage myShopMessage;

	public Shop getShop() {
		return myShop;
	}

	public ShopItem getItem() {
		return myItem;
	}

	public AbstractBindingMessage getItemMessage() {
		return myItemMessage;
	}

	public AbstractBindingMessage getShopMessage() {
		return myShopMessage;
	}

	public TestObjectValidatorAdapter() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myItem = ShopFactory.eINSTANCE.createShopItem();
		myItem.setPrice(LIMIT + 1f);
		myItem.setShop(myShop);

		myItemMessage = new AbstractBindingMessage(null, myItem, null, null) {

			@Override
			public String getMessage() {
				return ERROR_MESSAGE + " for item";
			}

			@Override
			public BindingMessageSeverity getSeverity() {
				return BindingMessageSeverity.ERROR;
			}
		};
		myShopMessage = new AbstractBindingMessage(null, myShop, null, null) {

			@Override
			public String getMessage() {
				return ERROR_MESSAGE + " for shop";
			}

			@Override
			public BindingMessageSeverity getSeverity() {
				return BindingMessageSeverity.ERROR;
			}
		};
	}

	@Override
	public void validateObjectTree(EObject root, IObservableList messages) {
		assertEquals(myShop, root);

		if (!messages.contains(myShopMessage)) {
			messages.add(myShopMessage);
		}

		final boolean showError = (myItem.getPrice() < LIMIT);
		if (showError && !messages.contains(myItemMessage)) {
			messages.add(myItemMessage);
		}
		if (!showError && messages.contains(myItemMessage)) {
			messages.remove(myItemMessage);
		}
	}

	@Override
	public void dispose() {

	}
}
