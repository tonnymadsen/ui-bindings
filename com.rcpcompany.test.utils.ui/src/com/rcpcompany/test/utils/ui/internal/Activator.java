package com.rcpcompany.test.utils.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {
	// The shared instance
	private static Activator PLUGIN;

	private BundleContext CONTEXT;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		CONTEXT = context;
		super.start(context);
		PLUGIN = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		PLUGIN = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return PLUGIN;
	}

	public BundleContext getContext() {
		return CONTEXT;
	}
}
