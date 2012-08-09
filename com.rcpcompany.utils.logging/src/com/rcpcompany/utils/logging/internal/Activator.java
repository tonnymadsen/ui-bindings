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
package com.rcpcompany.utils.logging.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * The bundle activator for the logging utilities.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class Activator implements BundleActivator {

	/**
	 * The ID of this bundle.
	 */
	public static final String ID;

	static {
		String pkg = Activator.class.getPackage().getName();
		if (pkg.endsWith(".internal")) { //$NON-NLS-1$
			pkg = pkg.substring(0, pkg.indexOf(".internal")); //$NON-NLS-1$
		}
		ID = pkg;
	}

	/**
	 * The singleton activator.
	 */
	private static Activator ACTIVATOR;

	/**
	 * Constructs and returns a new activator.
	 */
	public Activator() {
		ACTIVATOR = this;
	}

	/**
	 * Returns the activator for the bundle.
	 * 
	 * @return the activator ()
	 */
	public static Activator getDefault() {
		return ACTIVATOR;
	}

	/* ===================================================================== */

	@Override
	public void start(BundleContext context) throws Exception {
		CONTEXT = context;
	}

	/**
	 * The bundle context of the bundle.
	 */
	private BundleContext CONTEXT;

	/**
	 * Returns the bundle context.
	 * 
	 * @return the context
	 */
	public BundleContext getContext() {
		return CONTEXT;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		assert context == CONTEXT;
		CONTEXT = null;
	}

}
