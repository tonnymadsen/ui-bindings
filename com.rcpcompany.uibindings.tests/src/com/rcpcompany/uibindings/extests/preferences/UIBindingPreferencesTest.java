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
package com.rcpcompany.uibindings.extests.preferences;

import static org.junit.Assert.*;

import org.eclipse.jface.preference.IPreferencePage;
import org.junit.Test;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.UIBindingPreferences;
import com.rcpcompany.uibindings.internal.preferencePages.DefaultUIBindingsHighlightPreferencePage;
import com.rcpcompany.uibindings.internal.preferencePages.DefaultUIBindingsTopPreferencePage;
import com.rcpcompany.uibindings.internal.preferencePages.DefaultUIBindingsValidationPreferencePage;

/**
 * Tests of {@link com.rcpcompany.uibindings.UIBindingPreferences}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UIBindingPreferencesTest {
	@Test
	public void testTOP_PREF_PAGE() {
		testPage(Constants.TOP_PREF_PAGE, DefaultUIBindingsTopPreferencePage.class);
	}

	@Test
	public void testVALIDATION_PREF_PAGE() {
		testPage(Constants.VALIDATION_PREF_PAGE, DefaultUIBindingsValidationPreferencePage.class);
	}

	@Test
	public void testHIGHLIGHT_PREF_PAGE() {
		testPage(Constants.HIGHLIGHT_PREF_PAGE, DefaultUIBindingsHighlightPreferencePage.class);
	}

	private void testPage(String pageName, Class<? extends IPreferencePage> pageClass) {
		final UIBindingPreferences bindingPreferences = new UIBindingPreferences();
		bindingPreferences.setInitializationData(null, "class", pageName);

		final Object object = bindingPreferences.create();

		assertNotNull(object);
		assertTrue(pageClass.isInstance(object));
	}
}
