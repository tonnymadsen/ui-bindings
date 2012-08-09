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
package com.rcpcompany.uibindings.extests.scripting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

/*
 * All the basic UI Bindings tests
 */
// AllBindingTests.class,

		/*
		 * Simple manager tests
		 */
		ScriptManagerBaseTest.class, ScriptManagerModelTest.class, ScriptManagerEvalContextTest.class,

		/*
		 * Simple tests of the functionality
		 */
		SimpleScriptTest.class

})
public class AllScriptEngineTest {
}
