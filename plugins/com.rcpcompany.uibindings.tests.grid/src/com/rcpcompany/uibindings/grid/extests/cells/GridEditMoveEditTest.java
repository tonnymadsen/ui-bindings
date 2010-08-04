package com.rcpcompany.uibindings.grid.extests.cells;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static com.rcpcompany.uibindings.grid.extests.GridBaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.swt.SWT;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.TestGrid;
import com.rcpcompany.uibinding.tests.model.TestGridCell;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.extests.models.TestGridGridModel;

/**
 * Tests of <a href="http://jira.marintek.sintef.no/jira/browse/SIMA-1049">SIMA-1049: Moving and
 * Editing Cell, Edits Wrong Cell</a>.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GridEditMoveEditTest {
	private TestView myView;
	private Grid myGrid;
	private IGridBinding myGridBinding;

	private TestGrid myTestGrid;
	private TestGridGridModel myModel;
	private TestGridCell myCellA1;
	private TestGridCell myCellB1;
	private IBindingContext myContext;

	@Before
	public void setup() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);

		createModel();
		createView();
	}

	private void createModel() {
		myTestGrid = createTestGrid();
		myModel = new TestGridGridModel(IManager.Factory.getManager().getEditingDomain(), myTestGrid,
				TestModelPackage.Literals.TEST_GRID_CELL__DETAILS, null);
		myCellA1 = myTestGrid.getColumns().get(0).getCells().get(0);
		myCellB1 = myTestGrid.getColumns().get(1).getCells().get(0);
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
	 * 
	 */
	@Test
	public void test() {
		final String oldA2Details = myCellB1.getDetails();

		assertEquals(myGridBinding.getCell(0, 0), myGridBinding.getFocusCell());
		assertEquals(false, myGridBinding.isEditing());

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				postKeyStroke(myGrid, "ENTER");
			}
		});
		assertEquals(myGridBinding.getCell(0, 0), myGridBinding.getFocusCell());
		assertEquals(true, myGridBinding.isEditing());

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				postKeyStroke(myGrid, "q");
			}
		});
		assertEquals(myGridBinding.getCell(0, 0), myGridBinding.getFocusCell());
		assertEquals(true, myGridBinding.isEditing());
		assertEquals("q", myCellA1.getDetails());
		assertEquals(oldA2Details, myCellB1.getDetails());

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				postKeyStroke(myGrid, "ENTER");
			}
		});
		assertEquals(myGridBinding.getCell(0, 0), myGridBinding.getFocusCell());
		assertEquals(false, myGridBinding.isEditing());
		assertEquals("q", myCellA1.getDetails());
		assertEquals(oldA2Details, myCellB1.getDetails());

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				postKeyStroke(myGrid, "ARROW_RIGHT");
			}
		});
		assertEquals(myGridBinding.getCell(1, 0), myGridBinding.getFocusCell());
		assertEquals(false, myGridBinding.isEditing());

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				postKeyStroke(myGrid, "ENTER");
			}
		});
		assertEquals(myGridBinding.getCell(1, 0), myGridBinding.getFocusCell());
		assertEquals(true, myGridBinding.isEditing());

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				postKeyStroke(myGrid, "r");
			}
		});
		assertEquals(myGridBinding.getCell(1, 0), myGridBinding.getFocusCell());
		assertEquals(true, myGridBinding.isEditing());
		assertEquals("q", myCellA1.getDetails());
		assertEquals("r", myCellB1.getDetails());

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				postKeyStroke(myGrid, "ENTER");
			}
		});
		assertEquals(myGridBinding.getCell(1, 0), myGridBinding.getFocusCell());
		assertEquals(false, myGridBinding.isEditing());
		assertEquals("q", myCellA1.getDetails());
		assertEquals("r", myCellB1.getDetails());
	}
}
