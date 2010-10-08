package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.utils.IManagerRunnableManager;

/**
 * Tests of {@link IManagerRunnableManager} and friends.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ManagerRunnableManagerTests {
	@Before
	public void before() {
		resetAll();
	}

	@Test
	public void onlyOneManagerTest() {
		final IManager mng = IManager.Factory.getManager();

		final IManagerRunnableManager service = mng.getService(IManagerRunnableManager.class);
		assertEquals(null, service);

	}
}
