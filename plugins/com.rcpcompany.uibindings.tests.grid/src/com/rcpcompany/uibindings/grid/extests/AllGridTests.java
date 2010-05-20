package com.rcpcompany.uibindings.grid.extests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.rcpcompany.uibindings.grid.extests.cells.GridBindingSourceProviderTest;
import com.rcpcompany.uibindings.grid.extests.cells.GridCellTraversalTest;
import com.rcpcompany.uibindings.grid.extests.cells.GridChangeContentTest;
import com.rcpcompany.uibindings.grid.extests.cells.GridEditCellStrategiesTest;
import com.rcpcompany.uibindings.grid.extests.cells.GridEditMoveEditTest;
import com.rcpcompany.uibindings.grid.extests.cells.GridGetCellTest;
import com.rcpcompany.uibindings.grid.extests.cells.GridSimpleCellContextTest;
import com.rcpcompany.uibindings.grid.extests.createdispose.GridSimpleCreateDisposeTest;
import com.rcpcompany.uibindings.grid.extests.structure.GridStructureChangeTest;
import com.rcpcompany.uibindings.grid.extests.structure.GridStructureTest;

@RunWith(Suite.class)
@Suite.SuiteClasses( {

		/*
		 * All the basic UI Bindings tests
		 */
		// AllBindingTests.class,

		/*
		 * Simple tests
		 */
		GridSimpleCreateDisposeTest.class, GridSimpleCellContextTest.class, GridGetCellTest.class,
		GridBindingSourceProviderTest.class,

		/*
		 * Structure tests
		 */
		GridStructureTest.class, GridStructureChangeTest.class,

		/*
		 * Content Tests
		 */
		GridChangeContentTest.class,

		/*
		 * Editing
		 */
		GridEditCellStrategiesTest.class, GridEditMoveEditTest.class,

		/*
		 * Travesal
		 */
		GridCellTraversalTest.class,

})
public class AllGridTests {
}
