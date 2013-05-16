/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
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

import java.util.Map;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.swt.SWT;
import org.eclipse.ui.ISourceProvider;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.ui.services.ISourceProviderService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.TestGrid;
import com.rcpcompany.uibinding.tests.model.TestGridCell;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.IGridBindingCellInformation;
import com.rcpcompany.uibindings.grid.extests.models.TestGridGridModel;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

/**
 * Test of {@link BindingSourseProvider} for grids
 * <p>
 * TODO: test that the change of a grid results in a re-calculation of the binding sources.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GridBindingSourceProviderTest {

	private UIBTestView myView;
	private Grid myGrid;
	private IGridBinding myGridBinding;

	private TestGrid myTestGrid;
	private TestGridGridModel myModel;
	private IBindingContext myContext;
	private ISourceProvider myProvider;

	@Before
	public void setup() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();

		final IServiceLocator locator = myContext.getServiceLocator();

		final ISourceProviderService sourceProviders = (ISourceProviderService) locator
				.getService(ISourceProviderService.class);

		myProvider = sourceProviders.getSourceProvider(Constants.SOURCES_ACTIVE_BINDING);
	}

	private void createModel() {
		myTestGrid = createTestGrid();
		myModel = new TestGridGridModel(EditingDomainUtils.getEditingDomain(), myTestGrid,
				TestModelPackage.Literals.TEST_GRID_CELL__DETAILS, null);
	}

	private void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);

		myGrid = new Grid(myView.getBody(), SWT.NONE);
		myContext = IBindingContext.Factory.createContext(myView.getBody());
		myGridBinding = IGridBinding.Factory.createGrid(myContext, myGrid, myModel);
		myContext.finish();
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

	/**
	 * Source values for a column binding for a simple feature.
	 */
	@Test
	public void testSimpleBinding() {
		postMouse(myGrid, 0, 1);

		// dumpBindingSourceState();

		final IGridBindingCellInformation cell = myGridBinding.getCell(0, 1);
		final TestGridCell testCell = myTestGrid.getColumns().get(0).getCells().get(1);

		assertSource(Constants.SOURCES_THE_MANAGER, IManager.Factory.getManager());

		assertSource(Constants.SOURCES_ACTIVE_CONTEXT, myContext);

		assertSource(Constants.SOURCES_ACTIVE_CONTAINER_BINDING, myGridBinding);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_RO, false);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_TYPE, "");
		assertSource(Constants.SOURCES_ACTIVE_BINDING_MODEL_OBJECT, String.class);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_FEATURE, TestModelPackage.Literals.TEST_GRID_CELL__DETAILS);
		assertSource(Constants.SOURCES_ACTIVE_BINDING_VALUE, testCell.getDetails());
		assertSource(Constants.SOURCES_ACTIVE_BINDING_VALUE_DISPLAY, testCell.getDetails());
	}

	public void assertSource(String name, Object value) {
		final Map<String, Object> currentState = myProvider.getCurrentState();

		assertEquals("variable " + name, value, currentState.get(name));
	}
}
