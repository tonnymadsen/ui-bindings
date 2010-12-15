/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.extests.manager;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.emf.common.util.EList;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.ITreeItemDescriptor;
import com.rcpcompany.uibindings.ITreeItemRelation;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;

/**
 * Test of {@link IManager#getTreeItems()}, {@link IManager#getTreeItem(String)} and
 * {@link IManager#getTreeItem(org.eclipse.emf.ecore.EObject)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ManagerTreeFunctionalityTest {
	private IManager myManager;

	@Before
	public void setup() {
		resetAll();
		myManager = IManager.Factory.getManager();
	}

	@Test
	public void testGetTreeItems() {
		final EList<ITreeItemDescriptor> treeItems = myManager.getTreeItems();

		assertEquals(6, treeItems.size());
		for (final ITreeItemDescriptor i : treeItems) {
			if (i.getId().equals("com.rcpcompany.uibindings.shop.treeItems.shop")) {
				assertEquals(1, i.getModelTypes().size());
				assertEquals("com.rcpcompany.uibindings.tests.shop.Shop", i.getModelTypes().get(0));
				assertEquals(2, i.getChildRelations().size());
				assertEquals(0, i.getArguments().size());

				final ITreeItemRelation relation = i.getChildRelations().get(0);
				assertEquals("com.rcpcompany.uibindings.shop.treeItems.contactFolder", relation.getDescriptor().getId());
				assertEquals(null, relation.getFeatureName());
				assertEquals(null, relation.getFactory());
				assertEquals(2, relation.getTreeIDs().size());
				assertEquals("contacts", relation.getTreeIDs().get(0));
				assertEquals("", relation.getTreeIDs().get(1));
			} else if (i.getId().equals("com.rcpcompany.uibindings.shop.treeItems.contactFolder")) {
				assertEquals(0, i.getModelTypes().size());
				assertEquals(1, i.getChildRelations().size());
				assertEquals(2, i.getArguments().size());

				final ITreeItemRelation relation = i.getChildRelations().get(0);
				assertEquals(null, relation.getDescriptor());
				assertEquals("contacts", relation.getFeatureName());
				assertEquals(null, relation.getFactory());
			} else if (i.getId().equals("com.rcpcompany.uibindings.shop.treeItems.contact")) {
				assertEquals(1, i.getModelTypes().size());
				assertEquals("com.rcpcompany.uibindings.tests.shop.Contact", i.getModelTypes().get(0));
				assertEquals(1, i.getChildRelations().size());
				assertEquals(0, i.getArguments().size());
			} else if (i.getId().equals("com.rcpcompany.uibindings.shop.treeItems.customer")) {
			} else if (i.getId().equals("com.rcpcompany.uibindings.shop.treeItems.order")) {
			} else if (i.getId().equals("com.rcpcompany.uibindings.shop.treeItems.shopItem")) {
			} else {
				fail("Unknown id: " + i.getId());
			}
		}
	}

	@Test
	public void testGetTreeItemId() {
		for (final ITreeItemDescriptor ti : myManager.getTreeItems()) {
			assertEquals(ti, myManager.getTreeItem(ti.getId()));
		}
		assertEquals(null, myManager.getTreeItem("xxx"));
	}

	@Test
	public void testGetTreeItemClassOfQ() {
		assertEquals(myManager.getTreeItem("com.rcpcompany.uibindings.shop.treeItems.shop"),
				myManager.getTreeItem(ShopFactory.eINSTANCE.createShop()));
		assertEquals(null, myManager.getTreeItem(ShopFactory.eINSTANCE.createShopItemDescription()));
	}
}
