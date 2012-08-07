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
 * TODO SWTB
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
