package com.rcpcompany.uibindings.extests.trees;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.createTestView;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.yield;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IConstantTreeItem;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.SpecialBinding;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;

public class TreeContentTest {
	private Shop myShop;
	private ShopItem myShopItem;
	private Contact myContact1;
	private Contact myContact2;

	private TestView myView;

	private IBindingContext myContext;
	private Tree myTree;
	private TreeColumn myTreeColumn;
	private IViewerBinding myTreeBinding;
	private IColumnBinding myTreeColumnBinding;

	@Before
	public void before() {
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();

		myView.getSite().getPage().activate(myView);
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("my shop");

		myShopItem = ShopFactory.eINSTANCE.createShopItem();
		myShopItem.setName("Wellknown dummy");
		myShopItem.setShop(myShop);

		myContact1 = ShopFactory.eINSTANCE.createContact();
		myContact1.setName("John Doe");
		myContact1.setShop(myShop);

		myContact2 = ShopFactory.eINSTANCE.createContact();
		myContact2.setName("Doe John");
		myContact2.setShop(myShop);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);

		myContext = IBindingContext.Factory.createContext(myView.getBody());

		myTree = new Tree(myView.getBody(), SWT.SINGLE | SWT.FULL_SELECTION);
		myTree.setHeaderVisible(true);
		myTreeColumn = new TreeColumn(myTree, SWT.LEAD);
		myTreeColumn.setWidth(300);
		// TODO: use listener to make this column 100%

		final IObservableList list = WritableList.withElementType(ShopPackage.Literals.SHOP);
		list.add(myShop);
		myTreeBinding = myContext.addViewer().viewer(myTree).model(list);
		myTreeColumnBinding = myTreeBinding.addColumn().column(myTreeColumn).model(SpecialBinding.TREE_ITEM);

		myContext.finish();

		IBindingContextSelectionProvider.Factory.adapt(myContext, myView.getSite());

		myView.getBody().layout();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void testContent() {

		final TreeViewer viewer = (TreeViewer) myTreeBinding.getViewer();
		viewer.expandAll();
		/*
		 * Make sure the tree is properly shown
		 */
		yield();

		TreeItem[] items = myTree.getItems();
		assertEquals(1, items.length);
		assertEquals(myShop, items[0].getData());
		assertEquals(myShop.getName(), items[0].getText(0));

		items = items[0].getItems();
		assertEquals(1, items.length);
		assertTrue(items[0].getData() instanceof IConstantTreeItem);
		assertEquals("Contacts", items[0].getText(0));

		items = items[0].getItems();
		assertEquals(2, items.length);
		assertEquals(myContact1, items[0].getData());
		assertEquals(myContact1.getName(), items[0].getText(0));
		assertEquals(myContact2, items[1].getData());
		assertEquals(myContact2.getName(), items[1].getText(0));
	}
}
