package com.rcpcompany.uibindings.utils;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.utils.SortableTableAdapter;

/**
 * Column sorter based on an {@link IViewerBinding}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface ISortableTableAdapter extends IDisposable {
	public final class Factory {
		private Factory() {
		}

		/**
		 * Constructs and returns a new column sorter for the specified viewer binding.
		 * 
		 * @param viewer the viewer
		 * @return the new sorter
		 */
		public static ISortableTableAdapter adapt(final IViewerBinding viewer) {
			final ISortableTableAdapter adapter = viewer.getService(ISortableTableAdapter.class);
			if (adapter != null) return adapter;
			return new SortableTableAdapter(viewer);
		}
	};
}
