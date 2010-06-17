package com.rcpcompany.uibindings.grid.extests.models;

import java.util.Map;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibinding.tests.model.TestGrid;
import com.rcpcompany.uibinding.tests.model.TestGridCell;
import com.rcpcompany.uibinding.tests.model.TestGridColumn;
import com.rcpcompany.uibinding.tests.model.TestGridRow;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.grid.IGridCell;
import com.rcpcompany.uibindings.grid.IGridModel;

/**
 * A basic grid model with {@link TestGridRow customers} versus {@link TestGridColumn shop items}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class TestGridGridModel implements IGridModel {
	private final EditingDomain myEditingDomain;
	private final TestGrid myGrid;
	private final EStructuralFeature myFeature;
	private final Monitor myMonitor;

	private final IObservableList myColumns;
	private final IObservableList myRows;

	/**
	 * Simple interface used to monitor changes in grids during tests.
	 */
	public interface Monitor {
		void gridDisposed();

		void cellCreated(Cell cell);

		void cellDisposed(Cell cell);

	};

	public TestGridGridModel(EditingDomain editingDomain, TestGrid grid, EStructuralFeature feature, Monitor monitor) {
		myEditingDomain = editingDomain;
		myGrid = grid;
		myFeature = feature;
		myMonitor = monitor;
		myColumns = UIBindingsEMFObservables.observeList(myEditingDomain, grid,
				TestModelPackage.Literals.TEST_GRID__COLUMNS);
		myRows = UIBindingsEMFObservables.observeList(myEditingDomain, grid, TestModelPackage.Literals.TEST_GRID__ROWS);
	}

	@Override
	public IGridCell getCell(Object columnID, Object rowID) {
		return new Cell(columnID, rowID);
	}

	@Override
	public IObservableList getColumnIDs() {
		return myColumns;
	}

	@Override
	public IObservableList getRowIDs() {
		return myRows;
	}

	@Override
	public void dispose() {
		if (myMonitor != null) {
			myMonitor.gridDisposed();
		}
	}

	public class Cell implements IGridCell {
		private final Object myRowID;
		private final Object myColumnID;

		private final TestGridColumn myColumn;
		private final TestGridRow myRow;

		public Cell(Object columnID, Object rowID) {
			myColumnID = columnID;
			myRowID = rowID;

			if (columnID instanceof TestGridColumn) {
				myColumn = (TestGridColumn) columnID;
			} else {
				myColumn = null;
			}
			if (rowID instanceof TestGridRow) {
				myRow = (TestGridRow) rowID;
			} else {
				myRow = null;
			}

			if (myMonitor != null) {
				myMonitor.cellCreated(this);
			}
		}

		@Override
		public Map<String, Object> getArguments() {
			return null;
		}

		@Override
		public IObservableValue getValue() {
			if (myColumn == null && myRow == null)
				return null;
			else if (myColumn == null)
				return UIBindingsEMFObservables.observeValue(null, myEditingDomain, myRow,
						TestModelPackage.Literals.TEST_GRID_ROW__NUMBER);
			else if (myRow == null)
				return UIBindingsEMFObservables.observeValue(null, myEditingDomain, myColumn,
						TestModelPackage.Literals.TEST_GRID_COLUMN__NAME);
			// Both myItem and myCustomer non-null!!!
			final int j = myGrid.getRows().indexOf(myRow);
			final TestGridCell cell = myColumn.getCells().get(j);
			return UIBindingsEMFObservables.observeValue(null, myEditingDomain, cell, myFeature);
		}

		@Override
		public void dispose() {
			if (myMonitor != null) {
				myMonitor.cellDisposed(this);
			}
		}
	}
}
