/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.navigator.extests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.rcpcompany.uibindings.navigator.extests.editors.EditorPartDescriptorTest;
import com.rcpcompany.uibindings.navigator.extests.editors.EditorPartLifecycleTests;
import com.rcpcompany.uibindings.navigator.extests.editors.OpenBindingTests;
import com.rcpcompany.uibindings.navigator.extests.editors.ShowViewTests;
import com.rcpcompany.uibindings.navigator.extests.manager.ManagerUseGenericEditorPartFallback;
import com.rcpcompany.uibindings.navigator.extests.manager.NavigatorModelManagerTest;
import com.rcpcompany.uibindings.navigator.extests.manager.PreferenceTests;
import com.rcpcompany.uibindings.navigator.internal.views.EditorPartFactoryTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({

/*
 * All the basic UI Bindings tests
 */
// AllBindingTests.class,

		/*
		 * Simple manager tests
		 */
		NavigatorModelManagerTest.class, ManagerUseGenericEditorPartFallback.class,

		/*
		 * Editor retrieval tests
		 */
		EditorPartDescriptorTest.class, PreferenceTests.class, OpenBindingTests.class,

		/*
		 * View tests
		 */
		ShowViewTests.class, EditorPartLifecycleTests.class, EditorPartFactoryTests.class

})
public class AllEditorsTests {
}
