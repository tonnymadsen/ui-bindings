package com.rcpcompany.uibindings.extests.viewerBindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Tests the basic value of cells.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerCellValuesTest {
	private Shop myShop;
	private ShopItem myShopItem1;
	private ShopItem myShopItem2;

	private TestView myView;
	private Composite myBody;

	private IBindingContext myContext;
	private ITableCreator myCreator;

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

		myShopItem1 = ShopFactory.eINSTANCE.createShopItem();
		myShopItem1.setName("item 1");
		myShopItem1.setPrice(1f);
		myShopItem1.setForSale(true);

		myShopItem2 = ShopFactory.eINSTANCE.createShopItem();
		myShopItem2.setName("item 2");
		myShopItem2.setPrice(2f);
		myShopItem2.setForSale(false);

		myShop.getShopItems().add(myShopItem1);
		myShop.getShopItems().add(myShopItem2);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();

		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myCreator = ITableCreator.Factory.create(myContext, myBody, SWT.NONE, myShop,
				ShopPackage.Literals.SHOP__SHOP_ITEMS);
		myCreator.addColumn("name(w=100)");
		myCreator.addColumn("price(w=100)");

		myContext.finish();
		yield();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Tests the values of all cells
	 */
	@Test
	public void testCellValuesRow0() {
		oneCell(0, 0, myShopItem1.getName());
		oneCell(0, 1, String.format("%,.2f", myShopItem1.getPrice()));
	}

	/**
	 * Tests the values of all cells
	 */
	@Test
	public void testCellValuesRow1() {
		oneCell(1, 0, myShopItem2.getName());
		oneCell(1, 1, String.format("%,.2f", myShopItem2.getPrice()));
	}

	public void oneCell(int rowNo, int columnNo, String expectedText) {
		final Table table = myCreator.getTable();
		assertNotNull(table);
		final TableItem item = table.getItem(rowNo);
		assertNotNull(item);

		assertEquals(expectedText, item.getText(columnNo + myCreator.getBinding().getFirstTableColumnOffset()));
	}
}
