/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.utils;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.internal.utils.dnd.DnDSupport;

/**
 * Drag 'n drop support for {@link IBindingContext}.
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
		 * Install drag 'n drop support for the specified context
		 * 
		 * @param context the context
		 * @return the support object
		 */
		public static IDnDSupport installOn(IBindingContext context) {
			return DnDSupport.installOn(context);
		}
	}
}
