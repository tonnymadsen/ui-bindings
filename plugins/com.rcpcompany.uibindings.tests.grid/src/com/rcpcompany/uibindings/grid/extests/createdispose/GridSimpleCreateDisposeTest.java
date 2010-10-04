package com.rcpcompany.uibindings.grid.extests.createdispose;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static com.rcpcompany.uibindings.grid.extests.GridBaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.TestGrid;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.extests.models.TestGridGridModel;
import com.rcpcompany.uibindings.grid.extests.models.TestGridGridModel.Cell;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

/**
 * Simple test to show that a grid can be created and disposed again - multiple times.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GridSimpleCreateDisposeTest {

	private TestView myView;

	@Before
	public void setup() {
		resetAll();

		createModel();
		createView();
	}

	private void createModel() {
	}

	private void createView() {
		myView = createTestView(this);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	protected int myGridDisposed;
	protected Set<Cell> myGridCells = new HashSet<Cell>();

	@Test
	public void testCreateDispose() {
		final Composite composite = new Composite(myView.getBody(), SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(1, false));

		myGridDisposed = 0;

		final TestGrid testGrid = createTestGrid();
		final TestGridGridModel model = new TestGridGridModel(EditingDomainUtils.getEditingDomain(), testGrid,
				TestModelPackage.Literals.TEST_GRID_CELL__PRICE, new TestGridGridModel.Monitor() {

					@Override
					public void gridDisposed() {
						myGridDisposed++;
					}

					@Override
					public void cellDisposed(Cell cell) {
						assertTrue(myGridCells.contains(cell));
						myGridCells.remove(cell);
					}

					@Override
					public void cellCreated(Cell cell) {
						myGridCells.add(cell);
					}
				});

		final Grid grid = new Grid(composite, SWT.NONE);
		final IBindingContext context = IBindingContext.Factory.createContext(composite);
		IGridBinding.Factory.createGrid(context, grid, model);
		context.finish();
		yield();

		myView.getBody().layout();

		yield();

		assertEquals(0, myGridDisposed);
		assertEquals(0, myGridCells.size());

		composite.dispose();

		yield();

		assertEquals(1, myGridDisposed);
		assertEquals(0, myGridCells.size());
	}
}
