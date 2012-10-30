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
package com.rcpcompany.uibindings.grid.extests.cells;

import static com.rcpcompany.test.utils.BaseTestUtils.*;
import static com.rcpcompany.test.utils.ui.UITestUtils.*;
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
import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.extests.models.TestGridGridModel;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

/**
 * Tests of <a href="http://jira.marintek.sintef.no/jira/browse/SIMA-1049">SIMA-1049: Moving and
 * Editing Cell, Edits Wrong Cell</a>.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GridEditMoveEditTest {
	private UIBTestView myView;
	private Grid myGrid;
	private IGridBinding myGridBinding;

	private TestGrid myTestGrid;
	private TestGridGridModel myModel;
	private TestGridCell myCellA1;
	private TestGridCell myCellB1;
	private IBindingContext myContext;

	@Before
	public void setup() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);

		createModel();
		createView();
	}

	private void createModel() {
		myTestGrid = createTestGrid();
		myModel = new TestGridGridModel(EditingDomainUtils.getEditingDomain(), myTestGrid,
				TestModelPackage.Literals.TEST_GRID_CELL__DETAILS, null);
		myCellA1 = myTestGrid.getColumns().get(0).getCells().get(0);
		myCellB1 = myTestGrid.getColumns().get(1).getCells().get(0);
	}

	private void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);

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
