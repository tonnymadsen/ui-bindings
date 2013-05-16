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
package com.rcpcompany.uibindings.extests.utils;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.utils.ExtendedCommandStack;

/**
 * Tests {@link ExtendedCommandStack}.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public class ExtendedCommandStackTest {
	private Shop myShop;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();

		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setNextCustomerNo(0);
		myShop.setNextOrderNo(0);
		myShop.setTmpDir("/tmp");
	}

	/**
	 * Tests {@link ExtendedCommandStack#getCommands()}.
	 */
	@Test
	public void testStack() {
		final EditingDomain editingDomain = IManager.Factory.getManager().getEditingDomain();

		assertTrue(editingDomain.getCommandStack() instanceof ExtendedCommandStack);

		final ExtendedCommandStack cs = (ExtendedCommandStack) editingDomain.getCommandStack();
		assertEquals(0, cs.getCommands().size());

		final Command cmd1 = SetCommand.create(editingDomain, myShop, ShopPackage.Literals.SHOP__NEXT_CUSTOMER_NO, 1);
		final Command cmd2 = SetCommand.create(editingDomain, myShop, ShopPackage.Literals.SHOP__NEXT_ORDER_NO, 1000);

		cs.execute(cmd1);
		assertEquals(1, myShop.getNextCustomerNo());
		assertEquals(1, cs.getCommands().size());
		assertEquals(cmd1, cs.getCommands().get(0));

		cs.execute(cmd2);
		assertEquals(1000, myShop.getNextOrderNo());
		assertEquals(2, cs.getCommands().size());
		assertEquals(cmd1, cs.getCommands().get(0));
		assertEquals(cmd2, cs.getCommands().get(1));
	}

	/**
	 * Tests {@link ExtendedCommandStack#setCollectCommandMode(boolean)}.
	 */
	@Test
	public void testCollectMode() {
		final EditingDomain editingDomain = IManager.Factory.getManager().getEditingDomain();

		assertTrue(editingDomain.getCommandStack() instanceof ExtendedCommandStack);

		final ExtendedCommandStack cs = (ExtendedCommandStack) editingDomain.getCommandStack();
		assertEquals(0, cs.getCommands().size());

		final Command cmd1 = SetCommand.create(editingDomain, myShop, ShopPackage.Literals.SHOP__NEXT_CUSTOMER_NO, 1);
		final Command cmd2 = SetCommand.create(editingDomain, myShop, ShopPackage.Literals.SHOP__NEXT_ORDER_NO, 1000);
		final Command cmd3 = SetCommand.create(editingDomain, myShop, ShopPackage.Literals.SHOP__TMP_DIR, "/usr/tmp/");

		cs.setCollectCommandMode(true);

		cs.execute(cmd1);
		assertEquals(1, myShop.getNextCustomerNo());
		assertEquals(1, cs.getCommands().size());
		final Command cc = cs.getCommands().get(0);
		assertTrue(cc instanceof CompoundCommand);
		final List<Command> commandList = ((CompoundCommand) cc).getCommandList();
		assertEquals(2, commandList.size());
		assertEquals(cmd1, commandList.get(1));

		cs.execute(cmd2);
		assertEquals(1000, myShop.getNextOrderNo());
		assertEquals(1, cs.getCommands().size());
		assertEquals(cc, cs.getCommands().get(0));
		assertEquals(3, commandList.size());
		assertEquals(cmd1, commandList.get(1));
		assertEquals(cmd2, commandList.get(2));

		cs.setCollectCommandMode(false);

		cs.execute(cmd3);
		assertEquals("/usr/tmp/", myShop.getTmpDir());
		assertEquals(2, cs.getCommands().size());
		assertEquals(cc, cs.getCommands().get(0));
		assertEquals(3, commandList.size());
		assertEquals(cmd1, commandList.get(1));
		assertEquals(cmd2, commandList.get(2));
		assertEquals(cmd3, cs.getCommands().get(1));

		assertEquals(true, cs.canUndo());
		cs.undo();
		assertEquals("/tmp", myShop.getTmpDir());

		assertEquals(true, cs.canUndo());
		cs.undo();
		assertEquals(0, myShop.getNextCustomerNo());
		assertEquals(0, myShop.getNextOrderNo());

		assertEquals(false, cs.canUndo());
	}
}
