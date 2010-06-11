package com.rcpcompany.uibindings.extests.manager;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rcpcompany.uibindings.tests.application.Activator;
import com.rcpcompany.uibindings.tests.application.Application;

/**
 * Tests that there was no errors during the initialization of this application.
 * <p>
 * Depends on:
 * <ul>
 * <li> {@link Activator#myLogListener}</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class NoErrorsDuringInitializationTest {

	@Test
	public void testNoErrors() {
		assertEquals(0, Application.noMessages);
	}
}
