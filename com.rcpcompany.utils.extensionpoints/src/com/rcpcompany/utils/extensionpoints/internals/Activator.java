/*******************************************************************************
 * Copyright (c) 2006-2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.utils.extensionpoints.internals;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The activator for this plug. Used to get the Bundle.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class Activator extends AbstractUIPlugin {

	private static Activator INSTANCE;
	private BundleContext myContext;

	public Activator() {
		INSTANCE = this;
	}

	public static Activator getDefault() {
		return INSTANCE;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		myContext = context;
		super.start(context);
	}

	/**
	 * Returns the bundle with the specified symbolic name.
	 * 
	 * @param name
	 *            the name
	 * @return the bundle or <code>null</code> if not found
	 */
	public Bundle getBundle(String name) {
		for (final Bundle b : myContext.getBundles()) {
			if (b.getSymbolicName().equals(name))
				return b;
		}

		return null;
	}
}
