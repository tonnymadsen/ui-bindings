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
package com.rcpcompany.uibindings.utils;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.utils.dnd.DnDSupport;

/**
 * Drag 'n drop support for {@link IViewerBinding}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IDnDSupport extends IDisposable {
	/**
	 * Factory for {@link IDnDSupport}.
	 */
	static final class Factory {
		private Factory() {

		}

		/**
		 * Adapt the specified viewer for drag 'n drop.
		 * 
		 * @param viewer the viewer
		 * @return the support object
		 */
		public static IDnDSupport adapt(IViewerBinding viewer) {
			IDnDSupport adapter = viewer.getService(IDnDSupport.class);
			if (adapter == null) {
				adapter = new DnDSupport(viewer);
			}
			return adapter;
		}
	}
}
