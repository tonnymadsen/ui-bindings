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
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.IGridBindingCellInformation;
import com.rcpcompany.uibindings.grid.extests.models.TestGridGridModel;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

/**
 * Test of {@link IGridBinding#getCell(int, int)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GridGetCellTest {

	private UIBTestView myView;
	private Grid myGrid;
	private IGridBinding myGridBinding;

	private TestGrid myTestGrid;
	private TestGridGridModel myModel;

	@Before
	public void setup() {
		resetAll();

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
		final IBindingContext context = IBindingContext.Factory.createContext(myView.getBody());
		myGridBinding = IGridBinding.Factory.createGrid(context, myGrid, myModel);
		context.finish();
		yield();

		myView.getBody().layout();

		yield();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void testGetCell() {
		testOneGetCell(0, 0, myTestGrid.getColumns().get(0).getCells().get(0).getDetails());
		testOneGetCell(2, 3, myTestGrid.getColumns().get(2).getCells().get(3).getDetails());

		testOneGetCell(-1, 0, null);
		testOneGetCell(0, -1, null);
		testOneGetCell(myTestGrid.getColumns().size(), myTestGrid.getRows().size(), null);
	}

	public void testOneGetCell(int x, int y, String content) {
		final IGridBindingCellInformation cell = myGridBinding.getCell(x, y);
		if (content == null) {
			assertEquals(null, cell);
		} else {
			assertNotNull(cell);
			final String text = cell.getDisplayText();
			assertEquals(content, text);
		}
	}
}
