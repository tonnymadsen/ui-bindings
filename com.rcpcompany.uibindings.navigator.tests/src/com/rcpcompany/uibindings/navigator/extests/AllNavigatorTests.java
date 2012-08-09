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
package com.rcpcompany.uibindings.navigator.extests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.rcpcompany.uibindings.navigator.extests.editors.EditorPartDescriptorTest;
import com.rcpcompany.uibindings.navigator.extests.editors.EditorPartLifecycleTest;
import com.rcpcompany.uibindings.navigator.extests.editors.OpenBindingTest;
import com.rcpcompany.uibindings.navigator.extests.editors.ShowViewTest;
import com.rcpcompany.uibindings.navigator.extests.manager.ManagerUseGenericEditorPartFallback;
import com.rcpcompany.uibindings.navigator.extests.manager.NavigatorModelManagerTest;
import com.rcpcompany.uibindings.navigator.extests.manager.PreferenceTest;
import com.rcpcompany.uibindings.navigator.internal.views.EditorPartFactoryTest;
import com.rcpcompany.uibindings.navigator.internal.views.GenericPlainFormEditorPartFactoryTest;

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
		EditorPartDescriptorTest.class, PreferenceTest.class, OpenBindingTest.class,

		/*
		 * View tests
		 */
		ShowViewTest.class, EditorPartLifecycleTest.class, EditorPartFactoryTest.class,
		GenericPlainFormEditorPartFactoryTest.class

})
public class AllNavigatorTests {
}
