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
import com.rcpcompany.uibinding.tests.model.TestGridColumn;
import com.rcpcompany.uibinding.tests.model.TestGridRow;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.IGridBindingCellInformation;
import com.rcpcompany.uibindings.grid.IGridModel;
import com.rcpcompany.uibindings.grid.extests.models.TestGridGridModel;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

/**
 * Basic test of cell binding: changes in the values of the model and ui is reflected correctly.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GridChangeContentTest {

	private UIBTestView myView;
	private Grid myGrid;
	private IGridBinding myGridBinding;

	private TestGrid myTestGrid;
	private TestGridGridModel myModel;

	@Before
	public void setup() {
		BaseUIBTestUtils.resetAll();

		createModel();
		createView();
	}

	private void createModel() {
		myTestGrid = createTestGrid();
		myModel = new TestGridGridModel(EditingDomainUtils.getEditingDomain(), myTestGrid,
				TestModelPackage.Literals.TEST_GRID_CELL__DETAILS, null);
	}

	private void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);

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
	public void testModelToUIContent() {
		final TestGridCell modelCell = myTestGrid.getColumns().get(0).getCells().get(0);
		final IGridBindingCellInformation gridCell = myGridBinding.getCell(0, 0);
		yield();
		assertEquals(modelCell.getDetails(), gridCell.getDisplayText());

		modelCell.setDetails("hello");
		yield();
		assertEquals(modelCell.getDetails(), gridCell.getDisplayText());
	}

	@Test
	public void testModelToUIColumnHeader() {
		final TestGridColumn modelColumn = myTestGrid.getColumns().get(0);
		final IGridBindingCellInformation gridCell = myGridBinding.getCell(modelColumn, IGridModel.HEADER1);
		yield();
		assertEquals(modelColumn.getName(), gridCell.getDisplayText());

		modelColumn.setName("hello");
		yield();
		assertEquals(modelColumn.getName(), gridCell.getDisplayText());
	}

	@Test
	public void testModelToUIRowHeader() {
		final TestGridRow modelRow = myTestGrid.getRows().get(0);
		final IGridBindingCellInformation gridCell = myGridBinding.getCell(IGridModel.HEADER1, modelRow);
		yield();
		assertEquals(modelRow.getNumber() + "", gridCell.getDisplayText());

		modelRow.setNumber(1000);
		yield();
		assertEquals(modelRow.getNumber() + "", gridCell.getDisplayText());
	}

	@Test
	public void testUIToModel() {
		assertTrue(IManager.Factory.getManager().isEditCellSingleClick());
		final TestGridCell modelCell = myTestGrid.getColumns().get(1).getCells().get(0);
		final IGridBindingCellInformation gridCell = myGridBinding.getCell(1, 0);
		final String originalValue = modelCell.getDetails();
		yield();
		assertEquals(originalValue, gridCell.getDisplayText());
		assertTrue(!myGridBinding.isEditing());

		postMouse(myGrid, 1, 0);

		assertTrue(myGridBinding.isEditing());
		assertEquals(gridCell, myGridBinding.getFocusCell());

		postKeyStroke(myGrid, "4");
		postKeyStroke(myGrid, "2");
		postKeyStroke(myGrid, "ENTER");

		assertTrue(!myGridBinding.isEditing());
		assertEquals(gridCell, myGridBinding.getFocusCell());

		yield();
		assertEquals("42", modelCell.getDetails());
		assertEquals("42", gridCell.getDisplayText());
	}
}
