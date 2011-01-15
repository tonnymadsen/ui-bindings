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
package com.rcpcompany.uibindings.internal.utils;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.EcoreExtUtils;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

/**
 * Tests {@link EcoreExtUtils#toString(Command)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class CommandToStringTest {
	private Shop myShop;
	private EditingDomain myED;

	@Before
	public void before() {
		resetAll();

		myShop = ShopFactory.eINSTANCE.createShop();
		myED = EditingDomainUtils.getEditingDomain();

		myShop.setName("SHOP");
		myShop.setNextCustomerNo(10);
	}

	@Test
	public void testIdentityCommand() {
		final Command command = IdentityCommand.INSTANCE;

		assertEquals("IdentityCommand()", EcoreExtUtils.toString(command));
	}

	@Test
	public void testUnexecutableCommand() {
		final Command command = UnexecutableCommand.INSTANCE;

		assertEquals("UnexecutableCommand()", EcoreExtUtils.toString(command));
	}

	@Test
	public void testSetCommand() {
		final Command command = SetCommand.create(myED, myShop, ShopPackage.Literals.SHOP__NEXT_CUSTOMER_NO, 1);

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myED.getCommandStack().execute(command);

				assertEquals(1, myShop.getNextCustomerNo());

				assertEquals("SetCommand(SHOP, nextCustomerNo, 10, 1)", EcoreExtUtils.toString(command));
			}
		});

	}

	@Test
	public void testAddCommand() {
		final Country c = ShopFactory.eINSTANCE.createCountry();
		c.setAbbreviation("DK");
		c.setName("Denmark");

		final Command command = AddCommand.create(myED, myShop, ShopPackage.Literals.SHOP__COUNTRIES, c);

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myED.getCommandStack().execute(command);

				assertTrue(myShop.getCountries().contains(c));

				assertEquals("AddCommand(SHOP, countries, [DK])", EcoreExtUtils.toString(command));
			}
		});
	}

	@Test
	public void testMoveCommand() {
		final Country c1 = ShopFactory.eINSTANCE.createCountry();
		c1.setAbbreviation("DK");
		c1.setName("Denmark");
		c1.setShop(myShop);

		final Country c2 = ShopFactory.eINSTANCE.createCountry();
		c2.setAbbreviation("SE");
		c2.setName("Sweden");
		c2.setShop(myShop);

		final Command command = MoveCommand.create(myED, myShop, ShopPackage.Literals.SHOP__COUNTRIES, c2, 0);

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myED.getCommandStack().execute(command);

				assertTrue(myShop.getCountries().get(0) == c2);

				assertEquals("MoveCommand(SHOP, countries, SE, 0)", EcoreExtUtils.toString(command));
			}
		});
	}

	@Test
	public void testRemoveCommand() {
		final Country c = ShopFactory.eINSTANCE.createCountry();
		c.setAbbreviation("DK");
		c.setName("Denmark");

		c.setShop(myShop);

		final Command command = RemoveCommand.create(myED, c);

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myED.getCommandStack().execute(command);

				assertTrue(!myShop.getCountries().contains(c));

				assertEquals("RemoveCommand(SHOP, countries, [DK])", EcoreExtUtils.toString(command));
			}
		});
	}
}
