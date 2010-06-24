package com.rcpcompany.uibindings.navigator.internal;

import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The plug-in ID.
	 */
	public static final String ID = "com.rcpcompany.uibindings.navigator";

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/**
	 * <code>true</code> if tracing the life-cycle of editor parts.
	 */
	public boolean TRACE_EDITOR_PARTS_LIFECYCLE = false;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		if (isDebugging()) {
			TRACE_EDITOR_PARTS_LIFECYCLE = Boolean.parseBoolean(Platform.getDebugOption(ID
					+ "/trace/EditorParts/LifeCycle")); //$NON-NLS-1$
		}
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
