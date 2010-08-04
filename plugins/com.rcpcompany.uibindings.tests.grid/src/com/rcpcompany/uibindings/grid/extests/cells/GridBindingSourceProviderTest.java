package com.rcpcompany.uibindings.grid.extests.cells;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
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
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.IGridBindingCellInformation;
import com.rcpcompany.uibindings.grid.extests.models.TestGridGridModel;

/**
 * Test of {@link IGridBinding#getCell(int, int)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GridBindingSourceProviderTest {

	private TestView myView;
	private Grid myGrid;
	private IGridBinding myGridBinding;

	private TestGrid myTestGrid;
	private TestGridGridModel myModel;
	private IBindingContext myContext;
	private ISourceProvider myProvider;

	@Before
	public void setup() {
		resetAll();
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
		myModel = new TestGridGridModel(IManager.Factory.getManager().getEditingDomain(), myTestGrid,
				TestModelPackage.Literals.TEST_GRID_CELL__DETAILS, null);
	}

	private void createView() {
		myView = createTestView(this);

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
	 * Source values for a column binding for a simple feature
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
