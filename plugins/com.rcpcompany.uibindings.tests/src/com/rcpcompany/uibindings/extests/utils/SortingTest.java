package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.utils.FilteringTableAdapter;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.ISortableTableAdapter;

/**
 * Test of {@link FilteringTableAdapter}.
 * <p>
 * This test contains a number of "sleep(nnn)", which seems to be necessary to get it right. It has
 * to do with the viewer code, but...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SortingTest {
	private WritableValue myShopValue;
	private Shop myShop;
	private Country a;
	private Country b;
	private Country c;
	private Country d;
	private Country e;

	private TestView myView;
	private Composite myBody;

	private TableViewer myViewer;
	private Table myTable;
	private TableColumn myNameColumn;
	private TableColumn myAbbreviationColumn;

	private IBindingContext myContext;
	private IViewerBinding myBinding;
	private EList<Country> myCountries;

	@Before
	public void before() {
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createShop();
		createView();
		bindUI();

		myBody.layout();
		myView.getSite().getPage().activate(myView);
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myCountries = myShop.getCountries();

		a = ShopFactory.eINSTANCE.createCountry();
		a.setName("A");
		a.setAbbreviation("AA");
		myCountries.add(a);

		b = ShopFactory.eINSTANCE.createCountry();
		b.setName("2A");
		b.setAbbreviation("CC");
		myCountries.add(b);

		c = ShopFactory.eINSTANCE.createCountry();
		c.setName("2B");
		c.setAbbreviation("CC");
		myCountries.add(c);

		d = ShopFactory.eINSTANCE.createCountry();
		d.setName("C");
		d.setAbbreviation("BarBar");
		myCountries.add(d);

		e = ShopFactory.eINSTANCE.createCountry();
		e.setName("B");
		e.setAbbreviation("BarToo");
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();
		myViewer = new TableViewer(myBody, SWT.FULL_SELECTION);
		myTable = myViewer.getTable();
		myTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		myTable.setHeaderVisible(true);

		myNameColumn = new TableColumn(myTable, SWT.NONE);
		myNameColumn.setWidth(100);

		myAbbreviationColumn = new TableColumn(myTable, SWT.NONE);
		myAbbreviationColumn.setWidth(100);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Binds the UI
	 */
	public void bindUI() {
		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());

		myShopValue = WritableValue.withValueType(ShopPackage.Literals.SHOP);
		myShopValue.setValue(myShop);

		myBinding = myContext.addViewer(myViewer, myShopValue, ShopPackage.Literals.SHOP__COUNTRIES);
		myBinding.addColumn(myNameColumn, ShopPackage.Literals.COUNTRY__NAME);
		myBinding.addColumn(myAbbreviationColumn, ShopPackage.Literals.COUNTRY__ABBREVIATION);

		myContext.finish();
		yield();
	}

	/**
	 * Tests that all listeners are removed on dispose
	 */
	@Test
	public void disposeTest() {
		final Listener[] nameColumnListeners = myNameColumn.getListeners(SWT.Selection);
		final Listener[] abbreviationColumnListeners = myAbbreviationColumn.getListeners(SWT.Selection);

		final ISortableTableAdapter adapter = ISortableTableAdapter.Factory.adapt(myBinding);

		adapter.dispose();

		assertEquals(null, myBinding.getService(ISortableTableAdapter.class));

		assertArrayEquals(nameColumnListeners, myNameColumn.getListeners(SWT.Selection));
		assertArrayEquals(abbreviationColumnListeners, myAbbreviationColumn.getListeners(SWT.Selection));
	}

	/**
	 * Tests the same adapter is returned every time
	 */
	@Test
	public void uniqueTest() {
		final ISortableTableAdapter adapt = ISortableTableAdapter.Factory.adapt(myBinding);
		assertEquals(adapt, ISortableTableAdapter.Factory.adapt(myBinding));
	}

	/**
	 * Tests the different sorting
	 */
	@Test
	public void sortingTest() {
		assertEquals(4, myShop.getCountries().size());
		ISortableTableAdapter.Factory.adapt(myBinding);

		/*
		 * - no sorting
		 */
		yield();
		assertEquals(null, myTable.getSortColumn());
		assertEquals(SWT.NONE, myTable.getSortDirection());
		assertOrder(a, b, c, d);
		myCountries.add(2, e);
		assertOrder(a, b, e, c, d);

		/*
		 * - name up
		 */
		clickHeader(myNameColumn);
		assertEquals(myNameColumn, myTable.getSortColumn());
		assertEquals(SWT.UP, myTable.getSortDirection());
		sleep(1000);
		assertOrder(b, c, a, e, d);
		myCountries.remove(c);
		sleep(1000);
		assertOrder(b, a, e, d);
		myCountries.add(c);
		sleep(1000);
		assertOrder(b, c, a, e, d);
		myCountries.remove(c);

		/*
		 * - name down
		 */
		sleep(1000);
		clickHeader(myNameColumn);
		sleep(1000);
		assertEquals(myNameColumn, myTable.getSortColumn());
		assertEquals(SWT.DOWN, myTable.getSortDirection());
		assertOrder(d, e, a, b);
		myCountries.add(c);
		sleep(1000);
		assertOrder(d, e, a, c, b);

		/*
		 * - abbreviation up
		 */
		clickHeader(myAbbreviationColumn);
		sleep(1000);
		assertEquals(myAbbreviationColumn, myTable.getSortColumn());
		assertEquals(SWT.UP, myTable.getSortDirection());
		assertOrder(a, d, e, b, c);

		/*
		 * - no sorting
		 */
		clickHeader(myAbbreviationColumn);
		sleep(1000);
		clickHeader(myAbbreviationColumn);
		sleep(1000);
		assertEquals(null, myTable.getSortColumn());
		assertEquals(SWT.NONE, myTable.getSortDirection());
		assertOrder(a, b, e, d, c);
	}

	/**
	 * Tests that the base object of the viewer can be changed
	 */
	@Test
	public void newShopTest() {
		assertEquals(4, myShop.getCountries().size());
		ISortableTableAdapter.Factory.adapt(myBinding);

		/*
		 * - no sorting
		 */
		yield();
		assertEquals(null, myTable.getSortColumn());
		assertEquals(SWT.NONE, myTable.getSortDirection());
		assertOrder(a, b, c, d);
		myCountries.add(2, e);
		assertOrder(a, b, e, c, d);

		/*
		 * - name up
		 */
		clickHeader(myNameColumn);
		assertEquals(myNameColumn, myTable.getSortColumn());
		assertEquals(SWT.UP, myTable.getSortDirection());
		sleep(1000);
		assertOrder(b, c, a, e, d);

		/*
		 * - create new shop
		 */
		final Shop shop = ShopFactory.eINSTANCE.createShop();
		final EList<Country> countries = shop.getCountries();

		final Country m = ShopFactory.eINSTANCE.createCountry();
		m.setName("Last");
		m.setAbbreviation("LL");
		countries.add(m);

		final Country n = ShopFactory.eINSTANCE.createCountry();
		n.setName("First");
		n.setAbbreviation("FF");
		countries.add(n);

		/*
		 * - name down - new shop
		 */
		myShopValue.setValue(shop);
		sleep(1000);
		assertEquals(myNameColumn, myTable.getSortColumn());
		assertEquals(SWT.UP, myTable.getSortDirection());
		assertOrder(n, m);
	}

	private void assertOrder(Country... expected) {
		// assertEquals(expected.length, myCountries.size());
		assertEquals(expected.length, myTable.getItemCount());

		// assertEquals(myShop.getCountries().size(), myTable.getItemCount());
		final Country[] actuals = new Country[myTable.getItemCount()];

		final TableItem[] items = myTable.getItems();
		for (int i = 0; i < items.length; i++) {
			final TableItem item = items[i];

			actuals[i] = (Country) item.getData();
		}

		// System.out.println("expected " + Arrays.toString(expected));
		// System.out.println("actuals " + Arrays.toString(actuals));
		assertArrayEquals(expected, actuals);
	}

	/**
	 * Clicks in the header of the column. Assumes the table contains at least one item.
	 * 
	 * @param col the column to click
	 */
	private void clickHeader(TableColumn col) {
		final TableColumn[] columns = myTable.getColumns();
		int i = 0;
		for (int n = 0; n < columns.length; n++) {
			if (col == columns[n]) {
				i = n;
				break;
			}
		}

		final Rectangle bounds = myTable.getItem(0).getBounds(i); // Not needed: +
		// IViewerBinding.FIRST_TABLE_COLUMN_OFFSET
		bounds.y = 0;
		bounds.height = myTable.getHeaderHeight();
		postMouse(myTable, bounds);
	}
}
