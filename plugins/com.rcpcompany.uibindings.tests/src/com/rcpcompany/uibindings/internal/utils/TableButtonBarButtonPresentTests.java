package com.rcpcompany.uibindings.internal.utils;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableButtonBar;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Tests of the presence of buttons in {@link ITableButtonBar}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class TableButtonBarButtonPresentTests {
	private final int myStyle;

	/**
	 * Ensure that the {@link #data()} method is correct...
	 */
	@Before
	public void beforeConstantTest() {
		assertEquals(15, ITableButtonBar.ADD | ITableButtonBar.DELETE | ITableButtonBar.UP | ITableButtonBar.DOWN);
	}

	@Parameters
	public static List<Object[]> data() {
		final List<Object[]> d = new ArrayList<Object[]>();
		for (int style = 1; style < 16; style++) {
			d.add(new Object[] { style });
		}

		return d;
	}

	public TableButtonBarButtonPresentTests(int style) {
		myStyle = style;
	}

	private static final int[] CONSTANTS = new int[] { ITableButtonBar.ADD, ITableButtonBar.DELETE, ITableButtonBar.UP,
			ITableButtonBar.DOWN, ITableButtonBar.BORDER, ITableButtonBar.HORIZONTAL, ITableButtonBar.VERTICAL };

	private TestView myView;

	private Shop myShop;
	private Country myCountry1;
	private Country myCountry2;

	private IFormCreator myForm;

	private ITableCreator myTable;

	private IViewerBinding myTableBinding;

	@Before
	public void before() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myCountry1 = ShopFactory.eINSTANCE.createCountry();
		myCountry1.setAbbreviation("AB");
		myCountry1.setShop(myShop);

		myCountry2 = ShopFactory.eINSTANCE.createCountry();
		myCountry2.setAbbreviation("AB");
		myCountry2.setShop(myShop);

		myView = createTestView(this);
		myForm = myView.createFormCreator(myShop);

		myTable = myForm.addTableCreator(ShopPackage.Literals.SHOP__COUNTRIES, true, SWT.NONE);
		myTableBinding = myTable.getBinding();

		myForm.finish();
	}

	/**
	 * Tests that the correct buttons are present for all the combinations of ADD, DELETE, UP and
	 * DOWN.
	 */
	@Test
	public void testButtonPresent() {
		final ITableButtonBar bb = ITableButtonBar.Factory.addButtonBar(myTableBinding, myStyle);

		assertNotNull(bb);
		for (final int s : CONSTANTS) {
			final Button button = bb.getButton(s);
			if ((myStyle & s) == 0) {
				assertEquals(null, button);
			} else {
				assertNotNull(button);
				assertTrue(button.isVisible());
				// Check parentage
				for (Composite c = button.getParent();; c = c.getParent()) {
					assertNotNull(c);
					assertFalse(c instanceof Shell);
					if (c == myView.getParent()) {
						break;
					}
				}
			}
		}
	}
}
