/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.extests.viewerBindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Tests of the different way editing of a cell can start and end as well as traversal out of the
 * cell.
 * <p>
 * Tests the functionality of {@link IManager#isEditCellAnyKey()} and
 * {@link IManager#isAutoApplySingleQuickfix()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class ViewerEditCheckboxTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

				// boolean anyKey, boolean singleClick

				{ false, false },

				{ false, true },

				{ true, false },

				{ true, true } });
	}

	private final boolean myEditCellAnyKey;
	private final boolean myEditCellSingleClick;
	private final String what;

	private Shop myShop;
	private ShopItem myShopItem1;

	private TestView myView;
	private Composite myBody;
	private TableViewer myTableViewer;
	private TableViewerColumn myForSaleColumn;

	private IBindingContext myContext;
	private IViewerBinding myViewerBinding;
	private Table myTable;

	// private TableViewerColumn myForSaleColumn;

	public ViewerEditCheckboxTest(boolean anyKey, boolean singleClick) {
		myEditCellAnyKey = anyKey;
		myEditCellSingleClick = singleClick;
		what = "(key: " + anyKey + ", single: " + singleClick + ")";
	}

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellAnyKey(myEditCellAnyKey);
		IManager.Factory.getManager().setEditCellSingleClick(myEditCellSingleClick);

		createShop();
		createView();
		bindUI();

		myView.getSite().getPage().activate(myView);
		myBody.layout();

		// final Listener listener = new Listener() {
		// @Override
		// public void handleEvent(Event event) {
		// LogUtils.debug(this, ToStringUtils.toString(event));
		// }
		// };
		// for (int i = SWT.None; i <= SWT.ImeComposition; i++) {
		// myTable.getDisplay().addFilter(i, listener);
		// }
		//
		// myTableViewer.getColumnViewerEditor().addEditorActivationListener(new
		// ColumnViewerEditorActivationListener()
		// {
		//
		// @Override
		// public void beforeEditorDeactivated(ColumnViewerEditorDeactivationEvent event) {
		// LogUtils.debug(this, "");
		// }
		//
		// @Override
		// public void beforeEditorActivated(ColumnViewerEditorActivationEvent event) {
		// LogUtils.debug(this, "");
		// }
		//
		// @Override
		// public void afterEditorDeactivated(ColumnViewerEditorDeactivationEvent event) {
		// LogUtils.debug(this, "");
		// }
		//
		// @Override
		// public void afterEditorActivated(ColumnViewerEditorActivationEvent event) {
		// LogUtils.debug(this, "");
		// }
		// });
	}

	@After
	public void after() {
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellAnyKey(false);
		IManager.Factory.getManager().setEditCellSingleClick(false);
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myShopItem1 = ShopFactory.eINSTANCE.createShopItem();
		myShopItem1.setName("item 0");
		myShopItem1.setPrice(5f);
		myShopItem1.setForSale(true);

		myShop.getShopItems().add(myShopItem1);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = UIBindingsTestUtils.createUIBTestView(this);
		myBody = myView.getBody();

		myTableViewer = new TableViewer(myBody, SWT.FULL_SELECTION);
		myTable = myTableViewer.getTable();
		myTable.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		myTable.setHeaderVisible(true);

		myForSaleColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myForSaleColumn.getColumn().setWidth(100);
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

		myViewerBinding = myContext.addViewer(myTableViewer, myShop, ShopPackage.Literals.SHOP__SHOP_ITEMS);
		myViewerBinding.addColumn(myForSaleColumn, ShopPackage.Literals.SHOP_ITEM__FOR_SALE);

		myContext.finish();
		yield();
	}

	/**
	 * Tests double click: changed twice = original
	 */
	@Test
	public void testDoubleClick() {
		testEditStrategy(false, false, new Runnable() {
			@Override
			public void run() {
				postMouse(myTable, 0 + myViewerBinding.getFirstTableColumnOffset(), 0, 2);
			}
		});
	}

	/**
	 * Tests single click: changed
	 */
	@Test
	public void testSingleClick() {
		testEditStrategy(false, true, new Runnable() {
			@Override
			public void run() {
				postMouse(myTable, 0 + myViewerBinding.getFirstTableColumnOffset(), 0);
			}
		});
	}

	/**
	 * Tests any key: no change
	 */
	@Test
	public void testAnyKey() {
		testEditStrategy(false, false, new Runnable() {
			@Override
			public void run() {
				postKeyStroke(myTable, "a");
			}
		});
	}

	/**
	 * Tests SPACE: change
	 */
	@Test
	public void testSPACEKey() {
		testEditStrategy(false, true, new Runnable() {
			@Override
			public void run() {
				postKeyStroke(myTable, "SPACE");
			}
		});
	}

	/**
	 * Tests ENTER: change
	 */
	@Test
	public void testENTERKey() {
		testEditStrategy(false, true, new Runnable() {
			@Override
			public void run() {
				postKeyStroke(myTable, "ENTER");
			}
		});
	}

	/**
	 * Tests that the specified runnable changes the "forSale" attribute to the expected value
	 * 
	 * @param start TODO
	 * @param expected the new forSale value
	 * @param runnable the runnable to get the
	 */
	private void testEditStrategy(final boolean start, final boolean expected, final Runnable runnable) {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myShopItem1.setForSale(start);
				runnable.run();
				yield();
			}
		});
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				assertEquals(what, false, myTableViewer.isCellEditorActive());

				assertEquals(what, expected, myShopItem1.isForSale());
			}
		});
	}

	protected void testBindingValue(final String expectedValue) {
		assertEquals(what, true, myTableViewer.isCellEditorActive());
		final EList<IBinding> bindings = myContext.getBindings();

		final IBinding b = bindings.get(bindings.size() - 1);
		assertTrue(what + " is IValueBinding", b instanceof IValueBinding);
		final IValueBinding editBinding = (IValueBinding) b;

		final Control c = editBinding.getControl();
		assertNotNull(what + " edit controll null", c);
		assertTrue(what + " is Text", c instanceof Text);
		final Text t = (Text) c;

		assertEquals(what, expectedValue, t.getText());
	}
}
