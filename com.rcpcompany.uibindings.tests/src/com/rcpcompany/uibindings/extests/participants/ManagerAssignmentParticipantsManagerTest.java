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
package com.rcpcompany.uibindings.extests.participants;

import static com.rcpcompany.test.utils.BaseTestUtils.*;
import static com.rcpcompany.test.utils.ExtensionTestUtils.*;
import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.SetCommand;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IAssignmentParticipantsManager;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.internal.InternalConstants;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.participants.IAssignmentParticipant;
import com.rcpcompany.uibindings.participants.IAssignmentParticipantContext;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopItemGroup;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;

/**
 * Test of {@link IManager#getAssignmentParticiantsManager()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ManagerAssignmentParticipantsManagerTest {
	private IManager MANAGER;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		MANAGER = IManager.Factory.getManager();
	}

	@Test
	public void testGetAPM() {
		final IAssignmentParticipantsManager m = MANAGER.getAssignmentParticiantsManager();
		assertNotNull(m);

		assertEquals(m, MANAGER.getAssignmentParticiantsManager());
	}

	/**
	 * Number of entries.
	 */
	@Test
	public void testNoGlobalParticipants() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final IAssignmentParticipantsManager m = MANAGER.getAssignmentParticiantsManager();
				final List<IConfigurationElement> elements = getElements("com.rcpcompany.uibindings.uiBindings", InternalConstants.ASSIGNMENT_PARTICIPANT_TAG);

				assertTrue(m.getParticipants().size() >= 1);
				assertEquals(elements.size(), m.getParticipants().size());
			}
		});
	}

	public static ShopItem mySI;
	public static ShopItemGroup mySG;

	/**
	 * Tests existance of {@link IAssignmentParticipant}.
	 */
	@Test
	public void testExistParticipant() {
		assertNoLog(new Runnable() {

			@Override
			public void run() {
				final IAssignmentParticipantsManager apm = IManager.Factory.getManager()
						.getAssignmentParticiantsManager();
				assertNotNull(apm);

				final IAssignmentParticipant p = apm.getParticipant(ShopPackage.Literals.SHOP_ITEM_GROUP,
						ShopPackage.Literals.SHOP_ITEM);
				assertTrue(p instanceof ItemToGroupAssignmentParticipant);
			}
		});
	}

	/**
	 * Tests execution of assignment.
	 */
	@Test
	public void testGlobalAssignment() {
		assertNoLog(new Runnable() {

			@Override
			public void run() {
				mySI = ShopFactory.eINSTANCE.createShopItem();
				mySI.setName("old");

				mySG = ShopFactory.eINSTANCE.createShopItemGroup();
				mySG.setName("new");

				Command c = MANAGER.assignObject(MANAGER.getEditingDomain(), null, mySG, mySI);
				assertNotNull(c);
				assertTrue(c instanceof SetCommand);

				c = MANAGER.assignObject(MANAGER.getEditingDomain(), null, mySI, mySI);
				assertEquals(null, c);
			}
		});
	}

	/**
	 * {@link IAssignmentParticipant} for {@link ShopItem} to {@link ShopItemGroup}.
	 */
	public static class ItemToGroupAssignmentParticipant implements IAssignmentParticipant {
		@Override
		public void assign(IAssignmentParticipantContext context) {
			assertEquals(mySI, context.getSourceObject());
			assertEquals(mySG, context.getObject());
			assertEquals(IManager.Factory.getManager().getEditingDomain(), context.getEditingDomain());

			context.setStructuralFeature(IMOAOPackage.Literals.NAMED_OBJECT__NAME, mySI.getName());
		}
	}
}
