package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
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
import com.rcpcompany.uibindings.utils.IFilteringTableAdapter;

/**
 * Test of {@link FilteringTableAdapter}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FilterTest {
	private TestView myView;
	private Shop myShop;
	private Composite myBody;
	private Table myTable;
	private Text myFilter;
	private TableColumn myNameColumn;
	private TableColumn myAbbreviationColumn;
	private IBindingContext myContext;
	private IViewerBinding myViewer;

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

		Country c;

		c = ShopFactory.eINSTANCE.createCountry();
		c.setName("A");
		c.setAbbreviation("AA");
		myShop.getCountries().add(c);

		c = ShopFactory.eINSTANCE.createCountry();
		c.setName("2A");
		c.setAbbreviation("BarBar");
		myShop.getCountries().add(c);

		c = ShopFactory.eINSTANCE.createCountry();
		c.setName("C");
		c.setAbbreviation("CC");
		myShop.getCountries().add(c);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();
		myFilter = IFilteringTableAdapter.Factory.createFilter(myBody);
		myTable = new Table(myBody, SWT.FULL_SELECTION);
		myTable.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

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

		myViewer = myContext.addViewer(myTable, myShop, ShopPackage.Literals.SHOP__COUNTRIES);
		myViewer.addColumn(myNameColumn, ShopPackage.Literals.COUNTRY__NAME);
		myViewer.addColumn(myAbbreviationColumn, ShopPackage.Literals.COUNTRY__ABBREVIATION);

		myContext.finish();
		yield();
	}

	@Test
	public void filterExists() {
		Listener[] listeners = myFilter.getListeners(SWT.Modify);
		assertNotNull(listeners);
		assertEquals(0, listeners.length);

		IFilteringTableAdapter.Factory.adapt(myViewer, myFilter);

		assertTrue(myViewer.getService(IFilteringTableAdapter.class) != null);
		listeners = myFilter.getListeners(SWT.Modify);
		assertNotNull(listeners);
		assertEquals(1, listeners.length);
	}

	/**
	 * Tests the navigation between the filter and the table.
	 */
	@Test
	public void navigationTest() {
		IFilteringTableAdapter.Factory.adapt(myViewer, myFilter);

		myFilter.setText("");
		assertEquals(myShop.getCountries().size(), myTable.getItemCount());

		myFilter.setFocus();

		postKeyStroke(myFilter, "ARROW_DOWN");
		yield();

		assertTrue(myTable.isFocusControl());
		assertEquals(0, myTable.getSelectionIndex());

		postKeyStroke(myTable, "ARROW_DOWN");
		yield();

		assertTrue(myTable.isFocusControl());
		assertEquals(1, myTable.getSelectionIndex());

		postKeyStroke(myTable, "ARROW_UP");
		yield();

		assertTrue(myTable.isFocusControl());
		assertEquals(0, myTable.getSelectionIndex());

		postKeyStroke(myTable, "ARROW_UP");
		yield();

		assertTrue(myFilter.isFocusControl());
	}

	/**
	 * Tests that all listeners are removed on dispose
	 */
	@Test
	public void disposeTest() {
		final Listener[] filterKeyDownListeners = myFilter.getListeners(SWT.KeyDown);
		final Listener[] filterSelectionListeners = myFilter.getListeners(SWT.Selection);
		final Listener[] filterFocusInListeners = myFilter.getListeners(SWT.FocusIn);
		final Listener[] tableKeyDownListeners = myTable.getListeners(SWT.KeyDown);
		final Listener[] tableDisposeListeners = myTable.getListeners(SWT.Dispose);

		final IFilteringTableAdapter adapter = IFilteringTableAdapter.Factory.adapt(myViewer, myFilter);

		adapter.dispose();

		assertEquals(null, myViewer.getService(IFilteringTableAdapter.class));

		assertArrayEquals(filterKeyDownListeners, myFilter.getListeners(SWT.KeyDown));
		assertArrayEquals(filterSelectionListeners, myFilter.getListeners(SWT.Selection));
		assertArrayEquals(filterFocusInListeners, myFilter.getListeners(SWT.FocusIn));
		assertArrayEquals(tableKeyDownListeners, myTable.getListeners(SWT.KeyDown));
		assertArrayEquals(tableDisposeListeners, myTable.getListeners(SWT.Dispose));
	}

	/**
	 * Tests the different supported patterns
	 */
	@Test
	public void filterPatternTest() {
		IFilteringTableAdapter.Factory.adapt(myViewer, myFilter);

		// Empty
		// myFilter.setText("");
		// yield();
		// assertEquals(myShop.getCountries().size(), myTable.getItemCount());

		// Plain
		myFilter.setText("A");
		yield();
		assertEquals(1, myTable.getItemCount());

		// Star
		myFilter.setText("*A");
		yield();
		assertEquals(2, myTable.getItemCount());

		// CamelCase
		myFilter.setText("BB");
		yield();
		assertEquals(1, myTable.getItemCount());

		// Empty
		myFilter.setText("");
		yield();
		assertEquals(myShop.getCountries().size(), myTable.getItemCount());
	}
}
