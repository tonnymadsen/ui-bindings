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
package com.rcpcompany.uibindings.extests.bindingMessages;

import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.validators.ConstraintValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * Tests the behavior of {@link IValidatorAdapterManager} for master-detail bindings.
 * <p>
 * The basic behavior of the manager is tested in {@link BindingMessageCollectionTest}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ValidationAdapterManagerMasterDetailTest {

	private Shop myShop;
	private UIBTestView myView;
	private Composite myBody;
	/**
	 * The alternate item
	 */
	private ShopItem myAltItem;
	/**
	 * The changed item
	 */
	private ShopItem myChangedItem;
	private IBindingContext myContext;
	private IValueBinding myBinding;
	private ValueBindingMessageImageDecorator myMessageDecorator;
	private IValidatorAdapterManager myValidatorManager;

	/**
	 * The current item - corresponding the selection of a viewer
	 */
	private WritableValue myCurrentItem;
	private Text myText;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setValidationDelay(500);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
		bindUI();

		myValidatorManager = IValidatorAdapterManager.Factory.getManager();
		myMessageDecorator = myBinding.getService(ValueBindingMessageImageDecorator.class);
		// implies an immediate validation
		myValidatorManager.addRoot(myShop, new ConstraintValidatorAdapter());
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myChangedItem = ShopFactory.eINSTANCE.createShopItem();
		myChangedItem.setPrice(-1f);
		myShop.getShopItems().add(myChangedItem);
		myAltItem = ShopFactory.eINSTANCE.createShopItem();
		myAltItem.setPrice(10f);
		myShop.getShopItems().add(myAltItem);
	}

	private void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);
		myBody = myView.getBody();

		myText = myView.getToolkit().createText(myView.getBody(), "");
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	private void bindUI() {
		myCurrentItem = WritableValue.withValueType(ShopPackage.Literals.SHOP_ITEM);

		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myBinding = myContext.addBinding(myText, myCurrentItem, ShopPackage.Literals.SHOP_ITEM__PRICE);

		myContext.finish();
		yield();
	}

	@After
	public void after() {
		myValidatorManager.removeRoot(myShop);
	}

	@Test
	public void testValue() {
		final List<IBindingMessage> messages = myMessageDecorator.getMessages();
		assertNotNull(messages);
		assertNotNull(myMessageDecorator.getQuickfixes());

		myCurrentItem.setValue(null);
		yield(); // Decorator updates are made in an asyncExec

		assertEquals(0, messages.size());
		assertEquals(0, myMessageDecorator.getQuickfixes().size());

		myCurrentItem.setValue(myAltItem);
		yield(); // Decorator updates are made in an asyncExec

		assertEquals(0, messages.size());
		assertEquals(0, myMessageDecorator.getQuickfixes().size());

		myCurrentItem.setValue(myChangedItem);
		yield(); // Decorator updates are made in an asyncExec

		assertEquals(1, messages.size());
		assertEquals(0, myMessageDecorator.getQuickfixes().size());

		myCurrentItem.setValue(myAltItem);
		yield(); // Decorator updates are made in an asyncExec

		assertEquals(0, messages.size());
		assertEquals(0, myMessageDecorator.getQuickfixes().size());
	}
}
