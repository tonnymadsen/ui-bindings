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
package com.rcpcompany.utils.logging.internal;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.packageadmin.PackageAdmin;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The bundle activator for the logging utilities.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class Activator extends Plugin {

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
	private static Activator theActivator;

	/**
	 * Constructs and returns a new activator.
	 */
	public Activator() {
		theActivator = this;
	}

	/**
	 * Returns the activator for the bundle.
	 * 
	 * @return the activator ()
	 */
	public static Activator getDefault() {
		return theActivator;
	}

	/* ===================================================================== */

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		myContext = context;

		if (isDebugging()) {

		}
	}

	/**
	 * The bundle context of the bundle.
	 */
	private BundleContext myContext;

	/**
	 * Returns the bundle context.
	 * 
	 * @return the context
	 */
	public BundleContext getContext() {
		return myContext;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		assert context == myContext;
		myContext = null;
	}

	/* ===================================================================== */

	/**
	 * Service tracker used in {@link #getBundleId(Object)}.
	 */
	private ServiceTracker bundleTracker;

	/**
	 * Returns the bundle id of the bundle that contains the provided object, or <code>null</code>
	 * if the bundle could not be determined.
	 * 
	 * @param object the object to test
	 * @return the build ID or <code>null</code>
	 */
	public String getBundleId(Object object) {
		if (object == null) return null;

		if (object instanceof String) return (String) object;

		return getBundleId(object.getClass());
	}

	/**
	 * Returns the bundle id of the bundle that contains the provided object, or <code>null</code>
	 * if the bundle could not be determined.
	 * 
	 * @param clazz the object to test
	 * @return the build ID or <code>null</code>
	 */
	public String getBundleId(Class<? extends Object> clazz) {
		if (clazz == null) return null;

		final PackageAdmin packageAdmin = getBundleAdmin();
		if (packageAdmin == null) return null;

		final Bundle source = packageAdmin.getBundle(clazz);
		if (source == null || source.getSymbolicName() == null) return null;

		return source.getSymbolicName();
	}

	/**
	 * Returns the OSGi Package Admin service, if available.
	 */
	public PackageAdmin getBundleAdmin() {
		if (bundleTracker == null) {
			bundleTracker = new ServiceTracker(getContext(), PackageAdmin.class.getName(), null);
			bundleTracker.open();
		}
		return (PackageAdmin) bundleTracker.getService();
	}
}
