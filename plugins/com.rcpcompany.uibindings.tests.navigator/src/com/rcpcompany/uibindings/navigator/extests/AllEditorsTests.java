package com.rcpcompany.uibindings.navigator.extests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.rcpcompany.uibindings.navigator.extests.manager.NavigatorModelManagerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({

/*
 * All the basic UI Bindings tests
 */
// AllBindingTests.class,

/*
 * Simple tests
 */
NavigatorModelManagerTest.class })
public class AllEditorsTests {
}
