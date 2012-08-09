/*******************************************************************************
 * Copyright (c) 2007, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/

package com.rcpcompany.test.utils;

import org.eclipse.osgi.service.resolver.PlatformAdmin;
import org.osgi.service.packageadmin.PackageAdmin;
import org.osgi.util.tracker.ServiceTracker;

import com.rcpcompany.test.utils.internal.Activator;

/**
 * Base class for all tests.
 * <p>
 * Provides a number of convenience methods...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class OSGiTestUtils {
	private OSGiTestUtils() {
	}

	private static ServiceTracker bundleTrackerPackageAdmin;

	/**
	 * Returns the OSGi Package Admin service, if available.
	 */
	public static PackageAdmin getPackageAdmin() {
		if (bundleTrackerPackageAdmin == null) {
			bundleTrackerPackageAdmin = new ServiceTracker(Activator
					.getDefault().getContext(), PackageAdmin.class.getName(),
					null);
			bundleTrackerPackageAdmin.open();
		}
		return (PackageAdmin) bundleTrackerPackageAdmin.getService();
	}

	private static ServiceTracker bundleTrackerPlatformAdmin;

	/**
	 * Returns the OSGi Platform Admin service, if available.
	 */
	public static PlatformAdmin getPlatformAdmin() {
		if (bundleTrackerPlatformAdmin == null) {
			bundleTrackerPlatformAdmin = new ServiceTracker(Activator
					.getDefault().getContext(), PlatformAdmin.class.getName(),
					null);
			bundleTrackerPlatformAdmin.open();
		}
		return (PlatformAdmin) bundleTrackerPlatformAdmin.getService();
	}

}
