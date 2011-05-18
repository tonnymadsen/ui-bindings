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

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static com.rcpcompany.uibindings.grid.extests.GridBaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.swt.SWT;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.TestGrid;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.extests.models.TestGridGridModel;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

/**
 * Tests of cell travesal.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GridCellTraversalTest {
	private TestView myView;
	private Grid myGrid;
	private IGridBinding myGridBinding;

	private TestGrid myTestGrid;
	private TestGridGridModel myModel;
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
		myModel = new TestGridGridModel(EditingDomainUtils.getEditingDomain(), myTestGrid,
				TestModelPackage.Literals.TEST_GRID_CELL__DETAILS, null);
	}

	private void createView() {
		myView = UIBindingsTestUtils.createUIBTestView(this);

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
		assertEquals(myGridBinding.getCell(0, 0), myGridBinding.getFocusCell());

		testOneStroke("ARROW_RIGHT", 1, 0);
		testOneStroke("ARROW_LEFT", 0, 0);
		testOneStroke("ARROW_DOWN", 0, 1);
		testOneStroke("ARROW_LEFT", 0, 1);
		testOneStroke("ARROW_RIGHT", 1, 1);
		testOneStroke("ARROW_UP", 1, 0);
		testOneStroke("ARROW_UP", 1, 0);

		testOneStroke("ARROW_RIGHT", 2, 0);
		testOneStroke("ARROW_RIGHT", 2, 0);

		testOneStroke("ARROW_DOWN", 2, 1);
		testOneStroke("HOME", 0, 1);

		testOneStroke("ARROW_DOWN", 0, 2);
		testOneStroke("END", 2, 2);
		testOneStroke("ARROW_DOWN", 2, 3);
		testOneStroke("ARROW_DOWN", 2, 3);

		testOneStroke("ARROW_UP", 2, 2);
		testOneStroke("HOME", 0, 2);

		// TODO: handle TAB properly
		// testOneStroke("TAB", 1, 2);
		// testOneStroke("TAB", 2, 2);
		// testOneStroke("TAB", 0, 3);
	}

	/**
	 * Does one stroke and tests the nwe position.
	 * 
	 * @param stroke the stroke
	 * @param column the new column
	 * @param row the new row
	 */
	private void testOneStroke(final String stroke, final int column, final int row) {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				postKeyStroke(myGrid, stroke);
			}
		});
		assertEquals(myGridBinding.getCell(column, row), myGridBinding.getFocusCell());
	}
}
