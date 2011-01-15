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
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
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
public class ViewerEditCellStrategiesTest {
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
	private ShopItem myShopItem2;

	private TestView myView;
	private Composite myBody;
	private TableViewer myTableViewer;
	private TableViewerColumn myNameColumn;
	private TableViewerColumn myPriceColumn;
	private TableViewerColumn myForSaleColumn;

	private IBindingContext myContext;
	private IViewerBinding myViewerBinding;
	private Table myTable;

	// private TableViewerColumn myForSaleColumn;

	public ViewerEditCellStrategiesTest(boolean anyKey, boolean singleClick) {
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

		myShopItem2 = ShopFactory.eINSTANCE.createShopItem();
		myShopItem2.setName("item 1");
		myShopItem2.setPrice(10f);
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

		myTableViewer = new TableViewer(myBody, SWT.FULL_SELECTION);
		myTable = myTableViewer.getTable();
		myTable.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		myTable.setHeaderVisible(true);

		myNameColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myNameColumn.getColumn().setWidth(100);

		myPriceColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myPriceColumn.getColumn().setWidth(100);

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
		myViewerBinding.addColumn(myNameColumn, IMOAOPackage.Literals.NAMED_OBJECT__NAME);
		// Speciel decorator with format "%,.3f" - to test that the arguments are properly
		// propagated
		myViewerBinding.addColumn(myPriceColumn, ShopPackage.Literals.SHOP_ITEM__PRICE).type("price-dummy");
		myViewerBinding.addColumn(myForSaleColumn, ShopPackage.Literals.SHOP_ITEM__FOR_SALE);

		myContext.finish();
		yield();
	}

	/**
	 * Tests double click: always activate edit
	 */
	@Test
	public void testDoubleClick() {
		testEditStrategy(!myEditCellSingleClick, myShopItem1.getName(), new Runnable() {
			@Override
			public void run() {
				postMouse(myTable, 0 + myViewerBinding.getFirstTableColumnOffset(), 0, 2);
			}
		});
	}

	/**
	 * Tests single click: only edit if preference is set
	 */
	@Test
	public void testSingleClick() {
		testEditStrategy(myEditCellSingleClick, myShopItem1.getName(), new Runnable() {
			@Override
			public void run() {
				postMouse(myTable, 0 + myViewerBinding.getFirstTableColumnOffset(), 0);
			}
		});
	}

	/**
	 * Tests any key: only edit if preference is set
	 */
	@Test
	public void testAnyKey() {
		testEditStrategy(myEditCellAnyKey, "a", new Runnable() {
			@Override
			public void run() {
				postKeyStroke(myTable, "a");
			}
		});
	}

	/**
	 * Tests double click: always activate edit
	 */
	@Test
	public void testDoubleClickTraversal() {
		if (!myEditCellSingleClick) {
			testTABTraversal(myShopItem1.getName(), String.format("%,.3f", myShopItem1.getPrice()),
					myShopItem1.isForSale(), myShopItem2.getName(), new Runnable() {
						@Override
						public void run() {
							postMouse(myTable, 0 + myViewerBinding.getFirstTableColumnOffset(), 0, 2);
						}
					});
		}
	}

	/**
	 * Tests single click: only edit if preference is set
	 */
	@Test
	public void testSingleClickTraversal() {
		if (myEditCellSingleClick) {
			testTABTraversal(myShopItem1.getName(), String.format("%,.3f", myShopItem1.getPrice()),
					myShopItem1.isForSale(), myShopItem2.getName(), new Runnable() {
						@Override
						public void run() {
							postMouse(myTable, 0 + myViewerBinding.getFirstTableColumnOffset(), 0);
						}
					});
		}
	}

	/**
	 * Tests any key: only edit if preference is set
	 */
	@Test
	public void testAnyKeyTraversal() {
		if (myEditCellAnyKey) {
			testTABTraversal("a", String.format("%,.3f", myShopItem1.getPrice()), myShopItem1.isForSale(),
					myShopItem2.getName(), new Runnable() {
						@Override
						public void run() {
							postKeyStroke(myTable, "a");
						}
					});
		}
	}

	@Test
	public void testDoubleClickUndo() {
		if (!myEditCellSingleClick) {
			testUndoAsCancel(new Runnable() {
				@Override
				public void run() {
					postMouse(myTable, 0 + myViewerBinding.getFirstTableColumnOffset(), 0, 2);
				}
			});
		}
	}

	@Test
	public void testSingleClickUndo() {
		if (myEditCellSingleClick) {
			testUndoAsCancel(new Runnable() {
				@Override
				public void run() {
					postMouse(myTable, 0 + myViewerBinding.getFirstTableColumnOffset(), 0);
				}
			});
		}
	}

	@Test
	public void testAnyKeyUndo() {
		if (myEditCellAnyKey) {
			testUndoAsCancel(new Runnable() {
				@Override
				public void run() {
					postKeyStroke(myTable, "a");
				}
			});
		}
	}

	/**
	 * Tests that the specified runnable can get the table into edit mode (or not)
	 * 
	 * @param editExpected whether edit mode is expected
	 * @param expectedValue the value expected in the edit box
	 * @param runnable the runnable to get the
	 */
	private void testEditStrategy(final boolean editExpected, final String expectedValue, final Runnable runnable) {

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				runnable.run();
				yield();
			}
		});
		assertNoLog(new Runnable() {

			@Override
			public void run() {
				assertEquals(editExpected, myTableViewer.isCellEditorActive());

				if (editExpected) {
					testBindingValue(expectedValue);

					final EList<IBinding> bindings = myContext.getBindings();

					final IValueBinding editBinding = (IValueBinding) bindings.get(bindings.size() - 1);

					final Text t = (Text) editBinding.getControl();

					postKeyStroke(t, "ESCAPE");
					yield();
					assertEquals(what, false, myTableViewer.isCellEditorActive());
				}
			}
		});
	}

	/**
	 * Tests that Undo = Ctrl-Z works as escape.
	 * 
	 * @param runnable the runnable to get the
	 */
	private void testUndoAsCancel(final Runnable runnable) {
		final String oldName = myShopItem1.getName();
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				runnable.run();
				yield();
			}
		});
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				assertEquals(what, true, myTableViewer.isCellEditorActive());

				final EList<IBinding> bindings = myContext.getBindings();

				final IValueBinding editBinding = (IValueBinding) bindings.get(bindings.size() - 1);

				final Text t = (Text) editBinding.getControl();
				t.setText("dummy");
				yield();
				assertEquals(what, "dummy", myShopItem1.getName());

				postKeyStroke(t, "M1+Z");
				yield();
				assertEquals(what, false, myTableViewer.isCellEditorActive());

				assertEquals(what, oldName, myShopItem1.getName());
			}
		});
	}

	private void testTABTraversal(final String expectedValue, final String afterTabExpectedValue,
			final boolean afterTabTabExpectedValue, final String afterTabTabTabExpectedValue, final Runnable runnable) {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				runnable.run();
				yield();
				testBindingValue(expectedValue);
			}
		});
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				postKeyStroke(myTable, "TAB");
				yield();
				testBindingValue(afterTabExpectedValue);
			}
		});
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				postKeyStroke(myTable, "TAB");
				yield();
				testBooleanBindingValue(afterTabTabExpectedValue);
			}
		});
		// assertNoLog(new Runnable() {
		// public void run() {
		// postKeyStroke(myTable, "TAB");
		// yield();
		// testBindingValue(afterTabTabTabExpectedValue);
		// }
		// });
		// assertNoLog(new Runnable() {
		// public void run() {
		// postKeyStroke(myTable, "M3+TAB");
		// yield();
		// testBooleanBindingValue(afterTabTabExpectedValue);
		// }
		// });
		// assertNoLog(new Runnable() {
		// public void run() {
		// postKeyStroke(myTable, "M3+TAB");
		// yield();
		// testBindingValue(afterTabExpectedValue);
		// }
		// });
		// assertNoLog(new Runnable() {
		// public void run() {
		// postKeyStroke(myTable, "M3+TAB");
		// yield();
		// testBindingValue(expectedValue);
		// }
		// });
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

	protected void testBooleanBindingValue(final boolean expectedValue) {
		assertEquals(what, false, myTableViewer.isCellEditorActive());
		assertEquals(expectedValue, myShopItem1.isForSale());
	}
}
