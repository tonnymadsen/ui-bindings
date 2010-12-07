package com.rcpcompany.uibindings.extests.scripting;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rcpcompany.uibindings.internal.scripting.simple.SimpleScriptEngine;
import com.rcpcompany.uibindings.scripting.IScriptEngine;
import com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor;
import com.rcpcompany.uibindings.scripting.IScriptManager;

/**
 * Tests the model of the script manager is correct.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ScriptManagerModelTest {

	/**
	 * One engine registered.
	 */
	@Test
	public void testModel() {
		final IScriptManager mng = IScriptManager.Factory.getManager();
		assertNotNull(mng);

		assertEquals(1, mng.getEngines().size());
		final IScriptEngineDescriptor engine = mng.getEngines().get(IScriptManager.LANGUAGE_SIMPLE_VARIABLES);
		assertNotNull(engine);
		assertEquals(IScriptManager.LANGUAGE_SIMPLE_VARIABLES, engine.getLanguage());
		assertNotNull(engine.getEngine());
		final IScriptEngine e = engine.getEngine().getObject();
		assertTrue(e instanceof SimpleScriptEngine);
	}
}
