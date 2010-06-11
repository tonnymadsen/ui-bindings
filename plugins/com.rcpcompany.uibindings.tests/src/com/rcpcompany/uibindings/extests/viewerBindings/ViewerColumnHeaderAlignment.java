package com.rcpcompany.uibindings.extests.viewerBindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.createTestView;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.yield;
import static org.junit.Assert.assertEquals;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Tests the alignment of column headers in viewers.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerColumnHeaderAlignment {
	private Shop myShop;

	private TestView myView;

	private ITableCreator myTable;

	private IFormCreator myForm;

	@Before
	public void before() {
		createShop();
		createView();

		myView.getSite().getPage().activate(myView);
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		ShopItem si = ShopFactory.eINSTANCE.createShopItem();
		si.setName("item 1");
		si.setPrice(1f);
		si.setForSale(true);

		si = ShopFactory.eINSTANCE.createShopItem();
		si.setName("item 2");
		si.setPrice(2f);
		si.setForSale(false);

		myShop.getShopItems().add(si);
		myShop.getShopItems().add(si);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);

		myForm = myView.createFormCreator(myShop);
		myTable = myForm.addTableCreator(ShopPackage.Literals.SHOP__SHOP_ITEMS, true, SWT.NONE);
		myTable.addColumn("name(w=100)");
		myTable.addColumn("price(w=100)");

		myForm.finish();
		yield();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Tests the alignment
	 */
	@Test
	public void testAlignment() {
		final Table table = myTable.getTable();
		final TableColumn[] columns = table.getColumns();
		for (int i = myTable.getBinding().getFirstTableColumnOffset(); i < columns.length; i++) {
			final TableColumn c = columns[i];
			assertEquals(SWT.CENTER, c.getAlignment());
		}
	}
}
