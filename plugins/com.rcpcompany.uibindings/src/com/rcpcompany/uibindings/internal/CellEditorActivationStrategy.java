package com.rcpcompany.uibindings.internal;

import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.ViewerCell;

import com.rcpcompany.uibindings.IColumnBindingCellInformation;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;

/**
 * Common activation strategy used by most viewers.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class CellEditorActivationStrategy extends ColumnViewerEditorActivationStrategy {
	private final IViewerBinding myViewerBinding;

	public CellEditorActivationStrategy(IViewerBinding viewerBinding) {
		super(viewerBinding.getViewer());
		myViewerBinding = viewerBinding;
	}

	@Override
	protected boolean isEditorActivationEvent(ColumnViewerEditorActivationEvent event) {
		final ViewerCell viewerCell = (ViewerCell) event.getSource();
		final IColumnBindingCellInformation cell = myViewerBinding.getCell(viewerCell.getColumnIndex()
				- myViewerBinding.getFirstTableColumnOffset(), viewerCell.getItem().getData());
		return IManager.Factory.getManager().isEditorActivationEvent(event, cell);
	}
}
