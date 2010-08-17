package com.rcpcompany.uibindings.extests.manager;

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
		myManager = IManager.Factory.getManager();
	}

	@Test
	public void testGetTreeItems() {
		final EList<ITreeItemDescriptor> treeItems = myManager.getTreeItems();

		assertEquals(3, treeItems.size());
		for (final ITreeItemDescriptor i : treeItems) {
			if (i.getId().equals("com.rcpcompany.uibindings.shop.treeItems.shop")) {
				assertEquals(1, i.getModelTypes().size());
				assertEquals("com.rcpcompany.uibindings.tests.shop.Shop", i.getModelTypes().get(0));
				assertEquals(1, i.getChildRelations().size());
				assertEquals(0, i.getDeclaredArguments().size());

				final ITreeItemRelation relation = i.getChildRelations().get(0);
				assertEquals("com.rcpcompany.uibindings.shop.treeItems.contactFolder", relation.getDescriptor().getId());
				assertEquals(null, relation.getFeatureName());
				assertEquals(null, relation.getProcessor());
			} else if (i.getId().equals("com.rcpcompany.uibindings.shop.treeItems.contactFolder")) {
				assertEquals(0, i.getModelTypes().size());
				assertEquals(1, i.getChildRelations().size());
				assertEquals(2, i.getDeclaredArguments().size());

				final ITreeItemRelation relation = i.getChildRelations().get(0);
				assertEquals(null, relation.getDescriptor());
				assertEquals("contacts", relation.getFeatureName());
				assertEquals(null, relation.getProcessor());
			} else if (i.getId().equals("com.rcpcompany.uibindings.shop.treeItems.contact")) {
				assertEquals(1, i.getModelTypes().size());
				assertEquals("com.rcpcompany.uibindings.tests.shop.Contact", i.getModelTypes().get(0));
				assertEquals(0, i.getChildRelations().size());
				assertEquals(0, i.getDeclaredArguments().size());
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
