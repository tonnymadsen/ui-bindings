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
package com.rcpcompany.uibindings.scripting.internal;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.rcpcompany.uibindings.IManager;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String ID = "com.rcpcompany.uibindings.scripting"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
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

	/**
	 * Preference name for {@link #getShowScriptInBindings()}.
	 */
	public static final String SHOW_SCRIPT_IN_BINDINGS_PREFERENCE = "showScriptInBindings";

	/**
	 * Whether to show script or values in bindings.
	 */
	private boolean myShowScriptInBindings = false;

	/**
	 * @param showScriptInBindings the showScriptInBindings to set
	 */
	public void setShowScriptInBindings(boolean showScriptInBindings) {
		myShowScriptInBindings = showScriptInBindings;

		/*
		 * Update the preference
		 */
		final IPreferenceStore ps = getPreferenceStore();
		ps.setValue(Activator.SHOW_SCRIPT_IN_BINDINGS_PREFERENCE, myShowScriptInBindings);
		IManager.Factory.getManager().updateBindings(null);

		/*
		 * Update command states
		 */
		final ICommandService cs = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
		if (cs != null) {
			cs.refreshElements("com.rcpcompany.uibindings.scripting.commands.ToggleShowScriptInBinding", null);
		}
	}

	/**
	 * Returns whether script or value is shown ion bindings
	 * 
	 * @return <code>true</code> if script is shown
	 */
	public boolean getShowScriptInBindings() {
		return myShowScriptInBindings;
	}

	private final IPropertyChangeListener myPropListener = new IPropertyChangeListener() {
		@Override
		public void propertyChange(PropertyChangeEvent event) {
			final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
			final boolean b = ps.getBoolean(SHOW_SCRIPT_IN_BINDINGS_PREFERENCE);
			if (b != getShowScriptInBindings()) {
				setShowScriptInBindings(b);
			}
		}
	};

}
