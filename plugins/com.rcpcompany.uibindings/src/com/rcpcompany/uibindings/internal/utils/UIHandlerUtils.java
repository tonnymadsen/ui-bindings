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
package com.rcpcompany.uibindings.internal.utils;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ViewerCell;

import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Various utility methods for use in handler and expressions/property testers.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public final class UIHandlerUtils {
	private UIHandlerUtils() {
	}

	/**
	 * Moves the specified element in the viewer of the binding.
	 * 
	 * @param vb the viewer binding
	 * @param element the element to move
	 * @param delta the amount to move
	 * @param testOnly <code>true</code> if the move should only be tested for, but not performed
	 * @return <code>true</code> if the element could be moved
	 */
	public static boolean moveElement(IViewerBinding vb, EObject element, int delta, boolean testOnly) {
		if (Activator.getDefault().TRACE_NAVIGATION_VIEWER) {
			LogUtils.debug(vb, "delta=" + delta + ", testOnly=" + testOnly + ", element=" + element);
		}

		Assert.isNotNull(vb);
		if (element == null) return false;

		final ColumnViewer viewer = vb.getViewer();
		/*
		 * Don't move if there are any sorter or filters installed as these negates the visual
		 * effect.
		 */
		if (viewer.getComparator() != null || viewer.getFilters().length > 0) return false;

		// The list of objects
		final IObservableList list = vb.getList();

		// Old position
		final int oldPosition = list.indexOf(element);
		if (oldPosition == -1) return false;

		// New position
		int newPosition = oldPosition + delta;
		if (newPosition < 0) {
			newPosition = 0;
		}
		if (newPosition >= list.size()) {
			newPosition = list.size() - 1;
		}

		// Can not be moved?
		if (oldPosition == newPosition) return false;

		// Move it
		if (!testOnly) {
			final ColumnViewerEditor editor = viewer.getColumnViewerEditor();
			final ViewerCell oldFocusCell = editor.getFocusCell();

			list.move(newPosition, oldPosition);

			vb.setFocus(oldFocusCell.getColumnIndex(), element);
			// ((Table) viewer.getControl()).setSelection(newPosition);
		}
		return true;
	}
}
