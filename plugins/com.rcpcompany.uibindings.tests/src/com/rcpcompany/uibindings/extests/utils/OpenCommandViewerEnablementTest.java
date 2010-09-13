package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Tests the correct selection is used in the "show view" command and handler.
 * <p>
 * Depends on:
 * <ul>
 * <li>{@link ShowViewSelectionTestView}</li>
 * <li>openCommand</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class OpenCommandViewerEnablementTest {
	public final static String TEST_VIEW_ID = ShowViewSelectionTestView.class.getName();

	/**
	 * Command used for test
	 */
	private static final String SHOW_VIEW_COMMAND = "com.rcpcompany.uibindings.commands.showView(viewId="
			+ TEST_VIEW_ID + ")";

	private Shop myShop;
	private Country myCountry;
	private Contact myContact1;
	private Contact myContact2;

	private TestView myView;
	private Composite myBody;

	private IBindingContext myContext;

	private ITableCreator myTableCreator;
	private Table myTable;
	private IColumnBinding myNameColumnBinding;
	private IColumnBinding myCountryColumnBinding;

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createShop();
		createView();

		myView.getSite().getPage().activate(myView);
		myBody.layout();
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myCountry = ShopFactory.eINSTANCE.createCountry();
		myCountry.setName("1");
		myShop.getCountries().add(myCountry);

		myContact1 = ShopFactory.eINSTANCE.createContact();
		myContact1.setName("NN 1");
		myContact1.setCountry(myCountry);
		myShop.getContacts().add(myContact1);

		myContact2 = ShopFactory.eINSTANCE.createContact();
		myContact2.setName("NN 2");
		myShop.getContacts().add(myContact2);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();

		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myTableCreator = ITableCreator.Factory.create(myContext, myBody, SWT.NONE, myShop,
				ShopPackage.Literals.SHOP__CONTACTS);

		final IObservableList countries = UIBindingsEMFObservables.observeList(myContext.getEditingDomain(), myShop,
				ShopPackage.Literals.SHOP__COUNTRIES);

		myTable = myTableCreator.getTable();

		myNameColumnBinding = myTableCreator.addColumn("name(w=100)");
		myCountryColumnBinding = myTableCreator.addColumn("country(w=100)").validValues(countries);

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
	 * Test the name column does not have an open command
	 */
	@Test
	public void nameColumnTest() {
		testColumnBinding(myNameColumnBinding, 1, 0, false);
	}

	/**
	 * Test the {@link #myContact1} does have an open command
	 * <p>
	 * Test Data: see binding above
	 */
	@Test
	public void countryColumnOKTest() {
		testColumnBinding(myCountryColumnBinding, 0, 1, true);
	}

	/**
	 * Test the {@link #myContact2} does not have an open command
	 */
	@Test
	public void countryColumnNotOKTest() {
		testColumnBinding(myCountryColumnBinding, 1, 1, false);
	}

	private void testColumnBinding(IColumnBinding column, int rowNo, int columnNo, boolean openEnabled) {
		final Rectangle bounds = myTable.getItem(rowNo).getBounds(
				columnNo + myTableCreator.getBinding().getFirstTableColumnOffset());
		final Point p = new Point(bounds.x + bounds.width / 2, bounds.y + bounds.height / 2);
		postMouseMove(myTable, p);
		postMouse(myTable, columnNo + myTableCreator.getBinding().getFirstTableColumnOffset(), rowNo);

		final Cursor initCursor = column.getViewerBinding().getControl().getCursor();

		myTable.setFocus();

		Event event;
		event = new Event();
		event.type = SWT.KeyDown;
		event.stateMask = 0;
		event.keyCode = SWT.CTRL;
		event.widget = myTable;

		assertTrue(myTable.getDisplay().post(event));
		yield();

		p.x += 1;
		postMouseMove(myTable, p);
		p.x -= 1;

		final Cursor cursor = column.getViewerBinding().getControl().getCursor();
		assertEquals(openEnabled, cursor != null);

		event = new Event();
		event.type = SWT.KeyUp;
		event.stateMask = 0;
		event.keyCode = SWT.CTRL;
		event.widget = myTable;

		assertTrue(myTable.getDisplay().post(event));
		yield();

		postMouseMove(myTable, p);
		yield();

		final Cursor cursor2 = column.getViewerBinding().getControl().getCursor();
		assertEquals(initCursor, cursor2);
	}
}
