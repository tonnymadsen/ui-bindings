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
package com.rcpcompany.uibindings;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IExecutableExtensionFactory;

import com.rcpcompany.uibindings.internal.preferencePages.DefaultUIBindingsHighlightPreferencePage;
import com.rcpcompany.uibindings.internal.preferencePages.DefaultUIBindingsTopPreferencePage;
import com.rcpcompany.uibindings.internal.preferencePages.DefaultUIBindingsValidationPreferencePage;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Preferences supported by the UI Bindings framework that are not related directly to the bindings
 * themselves.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UIBindingPreferences implements IExecutableExtension, IExecutableExtensionFactory, Constants {
	private String myType;

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) {
		myType = (String) data;
	}

	@Override
	public Object create() {
		if (TOP_PREF_PAGE.equals(myType)) return new DefaultUIBindingsTopPreferencePage();
		if (VALIDATION_PREF_PAGE.equals(myType)) return new DefaultUIBindingsValidationPreferencePage();
		if (HIGHLIGHT_PREF_PAGE.equals(myType)) return new DefaultUIBindingsHighlightPreferencePage();
		LogUtils.error(this, "Unknown type name specified: " + myType); //$NON-NLS-1$
		return null;
	}
}
