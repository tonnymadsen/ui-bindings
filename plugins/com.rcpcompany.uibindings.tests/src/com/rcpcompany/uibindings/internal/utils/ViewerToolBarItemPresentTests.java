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
package com.rcpcompany.uibindings.internal.utils;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolItem;
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
import com.rcpcompany.uibindings.utils.ITableCreator;
import com.rcpcompany.uibindings.utils.IViewerToolBar;

/**
 * Tests of the presence of {@link ToolBar} items in {@link IViewerToolBar}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class ViewerToolBarItemPresentTests {
	private final int myStyle;

	/**
	 * Ensure that the {@link #data()} method is correct...
	 */
	@Before
	public void beforeConstantTest() {
		assertEquals(15, IViewerToolBar.ADD | IViewerToolBar.DELETE | IViewerToolBar.UP | IViewerToolBar.DOWN);
	}

	@Parameters
	public static List<Object[]> data() {
		final List<Object[]> d = new ArrayList<Object[]>();
		for (int style = 1; style < 16; style++) {
			// TODO Skiping all ADD for now
			if ((style & IViewerToolBar.ADD) != 0) {
				continue;
			}
			d.add(new Object[] { style });
		}

		return d;
	}

	public ViewerToolBarItemPresentTests(int style) {
		myStyle = style;
	}

	private TestView myView;

	private Shop myShop;
	private Country myCountry1;
	private Country myCountry2;

	private IFormCreator myForm;

	private ITableCreator myTable;

	private IViewerBinding myTableBinding;

	@Before
	public void before() {
		resetAll();

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
		myTable.addColumn("abbreviation(w=100)");
		myTableBinding = myTable.getBinding();

		myForm.finish();
	}

	/**
	 * Tests that the correct items are present for all the combinations of ADD, DELETE, UP and
	 * DOWN.
	 */
	@Test
	public void testItemPresent() {
		final IViewerToolBar bb = IViewerToolBar.Factory.addToolBar(myTableBinding, myStyle);

		assertNotNull(bb);
		for (final int s : IViewerToolBar.STYLES) {
			final ToolItem item = bb.getItem(s);
			if ((myStyle & s) == 0) {
				assertEquals(null, item);
			} else {
				assertNotNull(item);
				// assertTrue(button.isVisible());
				// Check parentage
				for (Composite c = item.getParent();; c = c.getParent()) {
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
