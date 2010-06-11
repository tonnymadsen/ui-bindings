package com.rcpcompany.uibindings.extests.manager;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertPixelColor;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.createTestView;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.yield;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IFormColors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Test of {@link IManager#setAlternateRowColors(boolean)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class AlternatingRowColorsTest {
	private TestView myView;
	private Shop myShop;
	private Composite myBody;
	private Table myTable;
	private TableColumn myNameColumn;
	private TableColumn myAbbreviationColumn;
	private IBindingContext myContext;
	private IViewerBinding myViewer;
	private final boolean myEnable;
	private Text myNoFocusText;
	private final boolean myHasFocus;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

		// enabled, focus

				{ true, true },

				{ false, true },

				{ true, false },

				{ false, false },

		});
	}

	public AlternatingRowColorsTest(boolean enable, boolean hasFocus) {
		myEnable = enable;
		myHasFocus = hasFocus;
	}

	@Before
	public void before() {
		IManager.Factory.getManager().setEditCellSingleClick(false);
		IManager.Factory.getManager().setAlternateRowColors(myEnable);
		createShop();
		createView();
		bindUI();
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
		myTable = new Table(myBody, SWT.FULL_SELECTION);
		myTable.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		myNameColumn = new TableColumn(myTable, SWT.NONE);
		myNameColumn.setWidth(100);
		myAbbreviationColumn = new TableColumn(myTable, SWT.NONE);
		myAbbreviationColumn.setWidth(200);

		myNoFocusText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		myNoFocusText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		myNoFocusText.setText("Empty");

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

		myBody.layout();
		if (myHasFocus) {
			myTable.setFocus();
		} else {
			myNoFocusText.setFocus();
		}
		yield();
	}

	/**
	 * Tests the colors of the row alternates
	 */
	@Test
	public void colorTest() {
		final TableItem[] items = myTable.getItems();
		final Color evenColor = JFaceResources.getColorRegistry().get(
				"com.rcpcompany.uibindings.colorDefinitions.EvenRowBackground");
		final Color oddColor = myTable.getDisplay().getSystemColor(SWT.COLOR_WHITE);
		// First row is selected and therefpore a different color
		for (int i = 0; i < items.length; i++) {
			final TableItem item = items[i];
			final Rectangle bounds = item.getBounds(myViewer.getFirstTableColumnOffset());

			Color c;
			if (i == 0) {
				if (myHasFocus) {
					c = myTable.getDisplay().getSystemColor(SWT.COLOR_LIST_SELECTION);
				} else {
					final FormColors colors = IManager.Factory.getManager().getFormToolkit().getColors();
					c = colors.getColor(IFormColors.H_HOVER_LIGHT);
				}
			} else if (i % 2 == 0 && myEnable) {
				c = evenColor;
			} else {
				c = oddColor;
			}
			assertPixelColor(myTable, bounds.x + 3, bounds.y + 3, c.getRGB());
		}
	}
}
