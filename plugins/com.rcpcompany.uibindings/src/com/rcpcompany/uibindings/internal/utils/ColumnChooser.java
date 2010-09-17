/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.IMemento;

import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.utils.IBindingContextPersistence;
import com.rcpcompany.uibindings.utils.IColumnChooser;
import com.rcpcompany.uibindings.utils.IPersistentParty;

/**
 * Implementation of {@link IColumnChooser}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ColumnChooser implements IColumnChooser, IPersistentParty, IDisposable {

	/**
	 * The viewer
	 */
	protected final IViewerBinding myViewer;

	/**
	 * The managed columns
	 */
	protected List<IColumnBinding> myColumns = new ArrayList<IColumnBinding>();

	/**
	 * If non-<code>null</code>, the memento restored by {@link IBindingContextPersistence}
	 */
	private IMemento myMemento = null;

	/**
	 * Constructs and returns a new column chooser
	 * 
	 * @param viewer the viewer of the chooser
	 */
	public ColumnChooser(IViewerBinding viewer) {
		myViewer = viewer;

		// Add popup
	}

	@Override
	public void dispose() {
		// Remove popup
	}

	@Override
	public void addColumn(IColumnBinding column) {
		myColumns.add(column);
		if (myMemento != null && column.getId() != null) {
			for (final IMemento m : myMemento.getChildren("column")) {
				if (m.getID().equals(column.getId())) {
					final Integer w = m.getInteger("width");
					if (w != null) {
						column.getColumnAdapter().setWidth(w);
					}
					final Boolean v = m.getBoolean("visible");
					if (v != null) {
						column.getColumnVisibility().setValue(v);
					}
					break;
				}
			}
		}
	}

	@Override
	public void removeColumn(IColumnBinding column) {
		myColumns.remove(column);
	}

	@Override
	public void addDefaultColumns() {
		for (final IColumnBinding cb : myViewer.getColumns()) {
			if (cb.getArgument(ARG_CHOOSABLE, Boolean.class, Boolean.TRUE) == Boolean.FALSE) {
				continue;
			}
			if (cb.getColumnAdapter().getWidth() == 0) {
				continue;
			}

			addColumn(cb);
		}
	}

	@Override
	public String getId() {
		return this.getClass().getName();
	}

	@Override
	public void saveState(IMemento memento) {
		for (final IColumnBinding cb : myColumns) {
			if (cb.getId() == null || cb.getId().length() == 0) {
				continue;
			}
			final IMemento child = memento.createChild("column", cb.getId());
			child.putInteger("width", cb.getColumnAdapter().getWidth());
			child.putBoolean("visible", (Boolean) cb.getColumnVisibility().getValue());
		}
	}

	@Override
	public void restoreState(IMemento memento) {
		myMemento = memento;
	}
}
