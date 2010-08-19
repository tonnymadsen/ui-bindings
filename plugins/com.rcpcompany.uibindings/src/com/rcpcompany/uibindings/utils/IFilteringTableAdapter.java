package com.rcpcompany.uibindings.utils;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.utils.FilteringTableAdapter;

/**
 * Column filter based on an {@link IViewerBinding}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IFilteringTableAdapter extends IDisposable {
	/**
	 * Factory for {@link IFilteringTableAdapter}.
	 */
	public final class Factory {
		private Factory() {

		}

		/**
		 * Constructs and returns a new column sorter for the specified viewer binding.
		 * 
		 * @param viewer the viewer
		 * @param filter an observable value that contains the filter value
		 * @return the new filter
		 */
		public static IFilteringTableAdapter adapt(IViewerBinding viewer, IObservableValue filter) {
			return adapt(viewer, filter, null);
		}

		/**
		 * Constructs and returns a new column sorter for the specified viewer binding.
		 * 
		 * @param viewer the viewer
		 * @param filter an observable value that contains the filter value
		 * @param text the Text widget that holds the filter
		 * @return the new filter
		 */
		public static IFilteringTableAdapter adapt(IViewerBinding viewer, IObservableValue filter, Text text) {
			IFilteringTableAdapter adapter = viewer.getService(IFilteringTableAdapter.class);
			if (adapter == null) {
				adapter = new FilteringTableAdapter(viewer, filter, text);
			}
			return adapter;
		}

		/**
		 * Constructs and returns a new column sorter for the specified viewer binding.
		 * 
		 * @param viewer the viewer
		 * @param filter a Text widget with the current filter value
		 * @return the new filter
		 */
		public static IFilteringTableAdapter adapt(IViewerBinding viewer, final Text filter) {
			return adapt(viewer, SWTObservables.observeText(filter, SWT.Modify), filter);
		}

		/**
		 * Creates a default filter field for for use with {@link #adapt(IViewerBinding, Text)}.
		 * 
		 * @param parent the parent composite with a {@link GridLayout} with one column
		 * @return the Text field
		 */
		public static Text createFilter(Composite parent) {
			return FilteringTableAdapter.createFilter(parent);
		}
	}

	/**
	 * Returns the {@link Text} control for the filter.
	 * 
	 * @return the text control
	 */
	Text getText();
}
