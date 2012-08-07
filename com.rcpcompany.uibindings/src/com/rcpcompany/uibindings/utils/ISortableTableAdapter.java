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
	static final class Factory {
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
