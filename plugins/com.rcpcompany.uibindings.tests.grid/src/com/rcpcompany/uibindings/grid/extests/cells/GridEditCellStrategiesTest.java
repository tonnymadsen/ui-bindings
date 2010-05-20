package com.rcpcompany.uibindings.grid.extests.cells;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertNoLog;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.createTestView;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.postKeyStroke;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.resetAll;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.yield;
import static com.rcpcompany.uibindings.grid.extests.GridBaseTestUtils.createTestGrid;
import static com.rcpcompany.uibindings.grid.extests.GridBaseTestUtils.postMouse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibinding.tests.model.TestGrid;
import com.rcpcompany.uibinding.tests.model.TestGridCell;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.extests.models.TestGridGridModel;

/**
 * Tests of the different way editing of a cell can start and end as well as traversal out of the cell.
 * <p>
 * Tests the functionality of {@link IManager#isEditCellAnyKey()} and {@link IManager#isAutoApplySingleQuickfix()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class GridEditCellStrategiesTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { false, false }, { false, true }, { true, false }, { true, true } });
	}

	private final boolean myEditCellAnyKey;
	private final boolean myEditCellSingleClick;
	private final String what;

	private TestView myView;
	private Grid myGrid;
	private IGridBinding myGridBinding;

	private TestGrid myTestGrid;
	private TestGridGridModel myModel;
	private TestGridCell myCellA1;
	private TestGridCell myCellB1;
	private TestGridCell myCellC1;
	private TestGridCell myCellA2;
	private IBindingContext myContext;

	// private TableViewerColumn myForSaleColumn;

	public GridEditCellStrategiesTest(boolean anyKey, boolean singleClick) {
		myEditCellAnyKey = anyKey;
		myEditCellSingleClick = singleClick;
		what = "(key: " + anyKey + ", single: " + singleClick + ")";
	}

	@Before
	public void setup() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellAnyKey(myEditCellAnyKey);
		IManager.Factory.getManager().setEditCellSingleClick(myEditCellSingleClick);

		createModel();
		createView();
	}

	private void createModel() {
		myTestGrid = createTestGrid();
		myModel = new TestGridGridModel(IManager.Factory.getManager().getEditingDomain(), myTestGrid,
				TestModelPackage.Literals.TEST_GRID_CELL__DETAILS, null);
		myCellA1 = myTestGrid.getColumns().get(0).getCells().get(0);
		myCellB1 = myTestGrid.getColumns().get(1).getCells().get(0);
		myCellC1 = myTestGrid.getColumns().get(2).getCells().get(0);
		myCellA2 = myTestGrid.getColumns().get(0).getCells().get(1);
	}

	private void createView() {
		myView = createTestView(this);

		myGrid = new Grid(myView.getBody(), SWT.NONE);
		myContext = IBindingContext.Factory.createContext(myView.getBody());
		myGridBinding = IGridBinding.Factory.createGrid(myContext, myGrid, myModel);
		myContext.finish();
		yield();

		myView.getSite().getPage().activate(myView);
		myView.getBody().layout();

		yield();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Tests double click: always activate edit
	 */
	@Test
	public void testDoubleClick() {
		testEditStrategy(!myEditCellSingleClick, myCellA1.getDetails(), new Runnable() {
			@Override
			public void run() {
				postMouse(myGrid, 0, 0, 2);
			}
		});
	}

	/**
	 * Tests single click: only edit if preference is set
	 */
	@Test
	public void testSingleClick() {
		testEditStrategy(myEditCellSingleClick, myCellA1.getDetails(), new Runnable() {
			@Override
			public void run() {
				postMouse(myGrid, 0, 0);
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
				postKeyStroke(myGrid, "a");
			}
		});
	}

	/**
	 * Tests double click: always activate edit
	 */
	@Test
	public void testDoubleClickTraversal() {
		if (!myEditCellSingleClick) {
			testTABTraversal(myCellA1.getDetails(), myCellB1.getDetails(), myCellC1.getDetails(),
					myCellA2.getDetails(), new Runnable() {
						@Override
						public void run() {
							postMouse(myGrid, 0, 0, 2);
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
			testTABTraversal(myCellA1.getDetails(), myCellB1.getDetails(), myCellC1.getDetails(),
					myCellA2.getDetails(), new Runnable() {
						@Override
						public void run() {
							postMouse(myGrid, 0, 0);
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
			testTABTraversal("a", myCellB1.getDetails(), myCellC1.getDetails(), myCellA2.getDetails(), new Runnable() {
				@Override
				public void run() {
					postKeyStroke(myGrid, "a");
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
					postMouse(myGrid, 0, 0, 2);
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
					postMouse(myGrid, 0, 0);
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
					postKeyStroke(myGrid, "a");
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
				assertEquals(what, editExpected, myGridBinding.isEditing());

				if (editExpected) {
					testBindingValue(expectedValue);

					final EList<IBinding> bindings = myContext.getBindings();

					final IValueBinding editBinding = (IValueBinding) bindings.get(bindings.size() - 1);

					final Text t = (Text) editBinding.getControl();

					postKeyStroke(t, "ESCAPE");
					yield();
					assertEquals(what, false, myGridBinding.isEditing());
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
		final String oldName = myCellA1.getDetails();
		assertNoLog(new Runnable() {
			public void run() {
				runnable.run();
				yield();
			}
		});
		assertNoLog(new Runnable() {
			public void run() {
				assertEquals(what, true, myGridBinding.isEditing());

				final EList<IBinding> bindings = myContext.getBindings();

				final IValueBinding editBinding = (IValueBinding) bindings.get(bindings.size() - 1);

				final Text t = (Text) editBinding.getControl();
				t.setText("dummy");
				yield();
				assertEquals(what, "dummy", myCellA1.getDetails());

				postKeyStroke(t, "CTRL+Z");
				yield();
				assertEquals(what, false, myGridBinding.isEditing());

				assertEquals(what, oldName, myCellA1.getDetails());
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
				postKeyStroke(myGrid, "TAB");
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
		assertNoLog(new Runnable() {
			public void run() {
				postKeyStroke(myGrid, "TAB");
				yield();
				testBindingValue(afterTabTabTabExpectedValue);
			}
		});
		// assertNoLog(new Runnable() {
		// public void run() {
		// postKeyDown(myTable, "Shift+TAB");
		// yield();
		// testBindingValue(afterTabTabExpectedValue);
		// }
		// });
		assertNoLog(new Runnable() {
			public void run() {
				postKeyStroke(myGrid, "Shift+TAB");
				yield();
				testBindingValue(afterTabExpectedValue);
			}
		});
		assertNoLog(new Runnable() {
			public void run() {
				postKeyStroke(myGrid, "Shift+TAB");
				yield();
				testBindingValue(expectedValue);
			}
		});
	}

	protected void testBindingValue(final String expectedValue) {
		assertEquals(what, true, myGridBinding.isEditing());
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
