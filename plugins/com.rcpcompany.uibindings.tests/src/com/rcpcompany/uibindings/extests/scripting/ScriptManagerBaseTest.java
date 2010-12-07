package com.rcpcompany.uibindings.extests.scripting;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rcpcompany.uibindings.scripting.IScriptManager;

/**
 * Tests existence of the script manager.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ScriptManagerBaseTest {

	/**
	 * One manager
	 */
	@Test
	public void testManager() {
		final IScriptManager manager = IScriptManager.Factory.getManager();
		assertNotNull(manager);

		final IScriptManager m2 = IScriptManager.Factory.getManager();
		assertEquals(manager, m2);
	}
}
