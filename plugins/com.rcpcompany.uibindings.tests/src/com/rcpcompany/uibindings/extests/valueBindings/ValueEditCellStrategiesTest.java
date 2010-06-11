package com.rcpcompany.uibindings.extests.valueBindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertNoLog;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.createTestView;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.postKeyStroke;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.postMouse;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.sleep;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.yield;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
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
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Tests of when text is accepted in .
 * <p>
 * Tests the functionality of {@link IManager#isEditCellAnyKey()} and {@link IManager#isAutoApplySingleQuickfix()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class ValueEditCellStrategiesTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { false, false }, { false, true }, { true, false }, { true, true } });
	}

	private final boolean myEditCellAnyKey;
	private final boolean myEditCellSingleClick;

	private Shop myShop;
	private ShopItem myShopItem1;
	private ShopItem myShopItem2;

	private TestView myView;
	private Composite myBody;
	private TableViewer myTableViewer;
	private TableViewerColumn myNameColumn;
	private TableViewerColumn myPriceColumn;

	private IBindingContext myContext;
	private IViewerBinding myViewerBinding;
	private Table myTable;
	private TableViewerColumn myForSaleColumn;

	public ValueEditCellStrategiesTest(boolean anyKey, boolean singleClick) {
		myEditCellAnyKey = anyKey;
		myEditCellSingleClick = singleClick;
	}

	@Before
	public void before() {
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
		// myTableViewer.getColumnViewerEditor().addEditorActivationListener(new ColumnViewerEditorActivationListener()
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
		myViewerBinding.addColumn(myNameColumn, ShopPackage.Literals.SHOP_ITEM__NAME);
		myViewerBinding.addColumn(myPriceColumn, ShopPackage.Literals.SHOP_ITEM__PRICE).type("currency");
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
			testTABTraversal(myShopItem1.getName(), String.format("%,.2f", myShopItem1.getPrice()), ""
					+ myShopItem1.isForSale(), myShopItem2.getName(), new Runnable() {
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
			testTABTraversal(myShopItem1.getName(), String.format("%,.2f", myShopItem1.getPrice()), ""
					+ myShopItem1.isForSale(), myShopItem2.getName(), new Runnable() {
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
			testTABTraversal("a", String.format("%,.2f", myShopItem1.getPrice()), "" + myShopItem1.isForSale(),
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
			public void run() {
				runnable.run();
				yield();
			}
		});
		assertNoLog(new Runnable() {
			public void run() {
				assertEquals(editExpected, myTableViewer.isCellEditorActive());

				if (editExpected) {
					testBindingValue(expectedValue);

					postKeyStroke(myTable, "ESCAPE");
					sleep(100);
					assertEquals(false, myTableViewer.isCellEditorActive());
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
			public void run() {
				runnable.run();
				yield();
			}
		});
		assertNoLog(new Runnable() {
			public void run() {
				assertEquals(true, myTableViewer.isCellEditorActive());

				final EList<IBinding> bindings = myContext.getBindings();

				final IValueBinding editBinding = (IValueBinding) bindings.get(bindings.size() - 1);

				final Text t = (Text) editBinding.getControl();
				t.setText("dummy");
				yield();
				assertEquals("dummy", myShopItem1.getName());

				postKeyStroke(myTable, "CTRL+Z");
				yield();
				assertEquals(false, myTableViewer.isCellEditorActive());

				assertEquals(oldName, myShopItem1.getName());
			}
		});
	}

	private void testTABTraversal(final String expectedValue, final String afterTabExpectedValue,
			final String afterTabTabExpectedValue, final String afterTabTabTabExpectedValue, final Runnable runnable) {
		assertNoLog(new Runnable() {
			public void run() {
				runnable.run();
				yield();
				testBindingValue(expectedValue);
			}
		});
		assertNoLog(new Runnable() {
			public void run() {
				postKeyStroke(myTable, "TAB");
				yield();
				testBindingValue(afterTabExpectedValue);
			}
		});
		// assertNoLog(new Runnable() {
		// public void run() {
		// postKeyDown(myTable, "TAB");
		// yield();
		// testBindingValue(afterTabTabExpectedValue);
		// }
		// });
		// assertNoLog(new Runnable() {
		// public void run() {
		// postKeyDown(myTable, "TAB");
		// yield();
		// testBindingValue(afterTabTabTabExpectedValue);
		// }
		// });
		// assertNoLog(new Runnable() {
		// public void run() {
		// postKeyDown(myTable, "Shift+TAB");
		// yield();
		// testBindingValue(afterTabTabExpectedValue);
		// }
		// });
		// assertNoLog(new Runnable() {
		// public void run() {
		// postKeyDown(myTable, "Shift+TAB");
		// yield();
		// testBindingValue(afterTabExpectedValue);
		// }
		// });
		assertNoLog(new Runnable() {
			public void run() {
				postKeyStroke(myTable, "Shift+TAB");
				yield();
				testBindingValue(expectedValue);
			}
		});
	}

	protected void testBindingValue(final String expectedValue) {
		assertNoLog(new Runnable() {
			public void run() {
				assertEquals(true, myTableViewer.isCellEditorActive());
				final EList<IBinding> bindings = myContext.getBindings();

				final IValueBinding editBinding = (IValueBinding) bindings.get(bindings.size() - 1);

				final Text t = (Text) editBinding.getControl();
				assertNotNull("edit controll null", t);

				assertEquals(expectedValue, t.getText());
			}
		});
	}
}
