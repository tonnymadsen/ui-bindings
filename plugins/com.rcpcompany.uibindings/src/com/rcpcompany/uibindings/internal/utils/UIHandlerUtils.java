package com.rcpcompany.uibindings.internal.utils;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ViewerCell;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.IViewerItemDeletor;
import com.rcpcompany.uibindings.IViewerItemDeletorContext;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Various utility methods for use in handler and expressions/property testers.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UIHandlerUtils {
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
		// Don't move if there are any sorter or filters installed as these negates the visual
		// effect
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

			vb.setFocus(element, oldFocusCell.getColumnIndex());
			// ((Table) viewer.getControl()).setSelection(newPosition);
		}
		return true;
	}

	/**
	 * Deletes the specified element in the viewer of the binding.
	 * 
	 * @param vb the viewer binding
	 * @param element the element to delete
	 * @param testOnly <code>true</code> if the move should only be tested for, but not performed
	 * @return <code>true</code> if the element could be deleted
	 */
	public static boolean deleteElement(final IViewerBinding vb, final EObject element, final boolean testOnly) {
		// if (Activator.getDefault().TRACE_NAVIGATION) {
		// LogUtils.debug(vb, "delta=" + delta + ", testOnly=" + testOnly + ", element=" + element);
		// }

		Assert.isNotNull(vb);
		if (element == null) return false;

		final IViewerItemDeletor deletor = vb.getArgument(Constants.ARG_ITEM_DELETOR, IViewerItemDeletor.class, null);
		if (deletor == null) return false;

		final int oldPosition = vb.getList().indexOf(element);
		if (oldPosition == -1) return false;

		// Do it
		final IViewerItemDeletorContext context = new IViewerItemDeletorContext() {
			@Override
			public IViewerBinding getViewerBinding() {
				return vb;
			}

			@Override
			public EObject getObject() {
				return element;
			}

			@Override
			public IObservableList getList() {
				return vb.getList();
			}

			@Override
			public int getIndex() {
				return oldPosition;
			}

			@Override
			public boolean getTestOnly() {
				return testOnly;
			}
		};
		deletor.deleteItem(context);
		return true;
	}
}
