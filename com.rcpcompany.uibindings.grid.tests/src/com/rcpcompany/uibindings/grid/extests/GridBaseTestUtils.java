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
package com.rcpcompany.uibindings.grid.extests;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.nebula.widgets.grid.Grid;

import com.rcpcompany.uibinding.tests.model.TestGrid;
import com.rcpcompany.uibinding.tests.model.TestGridCell;
import com.rcpcompany.uibinding.tests.model.TestGridColumn;
import com.rcpcompany.uibinding.tests.model.TestGridRow;
import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibindings.extests.BaseTestUtils;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * A number of test utilities used to test grids.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public final class GridBaseTestUtils {
	private GridBaseTestUtils() {
	}

	/**
	 * Creates and returns a shop.
	 * 
	 * @return the new shop
	 */
	public static Shop createShop() {
		final ResourceSetImpl rs = new ResourceSetImpl();

		/*
		 * Need to convert the platform: URI into a file: URI as we otherwise cannot save the data
		 */
		URL resolve = null;
		try {
			resolve = FileLocator.resolve(new URL(
					"platform:/plugin/com.rcpcompany.uibindings.tests.grid/data/TEST.shop"));
		} catch (final Exception ex) {
			LogUtils.error(rs, ex);
		}
		final URI uri = URI.createURI(resolve.toString());
		final Resource resource = rs.getResource(uri, true);

		return (Shop) resource.getContents().get(0);
	}

	public static TestGrid createTestGrid() {
		final TestGrid grid = TestModelFactory.eINSTANCE.createTestGrid();

		final String[] columnNames = { "First", "Second", "Third" };
		final Integer[] rowNames = { 1, 2, 4, 8 };
		final Object[][][] cellData = new Object[][][] {

				// Column First
				{ { "F1", 1.0f }, { "F2", 1.2f }, { "F4", 1.4f }, { "F8", 1.8f } },

				// Column "Second"
				{ { "S1", 2.0f }, { "S2", 2.2f }, { "S4", 2.4f }, { "S8", 2.8f } },

				// Column "Third"
				{ { "T1", 3.0f }, { "T2", 3.2f }, { "T4", 3.4f }, { "T8", 3.8f } },

		};
		for (final String name : columnNames) {
			final TestGridColumn c = TestModelFactory.eINSTANCE.createTestGridColumn();
			c.setName(name);
			c.setGrid(grid);
		}

		for (final Integer number : rowNames) {
			final TestGridRow r = TestModelFactory.eINSTANCE.createTestGridRow();
			r.setNumber(number);
			r.setGrid(grid);
		}

		for (int i = 0; i < columnNames.length; i++) {
			for (int j = 0; j < rowNames.length; j++) {
				final TestGridColumn c = grid.getColumns().get(i);
				final TestGridRow r = grid.getRows().get(j);

				final Object[] data = cellData[i][j];
				final TestGridCell cell = TestModelFactory.eINSTANCE.createTestGridCell();
				cell.setDetails((String) data[0]);
				cell.setPrice((Float) data[1]);
				cell.setColumn(c);
				cell.setRow(r);
			}
		}

		return grid;
	}

	/**
	 * Posts a mouse event for the specified grid cell
	 * 
	 * @param grid the grid
	 * @param column the column number
	 * @param row the row number
	 */
	public static void postMouse(Grid grid, int column, int row) {
		postMouse(grid, column, row, 1);
	}

	/**
	 * Posts a mouse event for the specified grid cell
	 * 
	 * @param grid the grid
	 * @param column the column number
	 * @param row the row number
	 * @param noClicks the number of clicks
	 */
	public static void postMouse(Grid grid, int column, int row, int noClicks) {
		BaseTestUtils.postMouse(grid, grid.getItem(row).getBounds(column), noClicks);
	}

}
