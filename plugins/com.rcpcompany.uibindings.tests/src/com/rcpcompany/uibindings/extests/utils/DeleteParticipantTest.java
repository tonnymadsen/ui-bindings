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
package com.rcpcompany.uibindings.extests.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.SubTestObject;
import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.participants.AbstractDeleteParticipant;
import com.rcpcompany.uibindings.participants.IDeleteParticipantContext;
import com.rcpcompany.uibindings.utils.ParticipantUtils;

/**
 * Tests {@link com.rcpcompany.uibindings.IDeleteParticipant}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DeleteParticipantTest {
	private static TestObject myTestObject;
	private static SubTestObject mySubTestObject;

	public static boolean myCanDeleteTestObjectResult = true;
	public static int myCanDeleteTestObjectCalled = 0;

	public static boolean myCanDeleteSubTestObjectResult = true;
	public static int myCanDeleteSubTestObjectCalled = 0;

	/**
	 * Tests that the correct participants are found and executed.
	 */
	@Test
	public void testSuperObjectParticipantUtil() {
		myTestObject = TestModelFactory.eINSTANCE.createTestObject();
		mySubTestObject = null;

		// --------------
		myCanDeleteTestObjectResult = false;
		myCanDeleteSubTestObjectResult = false;
		myCanDeleteTestObjectCalled = 0;
		myCanDeleteSubTestObjectCalled = 0;

		assertEquals(myCanDeleteTestObjectResult, ParticipantUtils.canDeleteAccordingToParticipants(myTestObject));

		assertEquals(1, myCanDeleteTestObjectCalled);
		assertEquals(0, myCanDeleteSubTestObjectCalled);

		// --------------
		myCanDeleteTestObjectResult = true;
		myCanDeleteSubTestObjectResult = false;
		myCanDeleteTestObjectCalled = 0;
		myCanDeleteSubTestObjectCalled = 0;

		assertEquals(myCanDeleteTestObjectResult, ParticipantUtils.canDeleteAccordingToParticipants(myTestObject));

		assertEquals(1, myCanDeleteTestObjectCalled);
		assertEquals(0, myCanDeleteSubTestObjectCalled);
	}

	/**
	 * Tests that the correct participants are found and executed.
	 */
	@Test
	public void testSubObjectParticipantUtil() {
		mySubTestObject = TestModelFactory.eINSTANCE.createSubTestObject();
		myTestObject = mySubTestObject;

		// --------------
		myCanDeleteTestObjectResult = false;
		myCanDeleteSubTestObjectResult = false;
		myCanDeleteTestObjectCalled = 0;
		myCanDeleteSubTestObjectCalled = 0;

		assertEquals(myCanDeleteTestObjectResult && myCanDeleteSubTestObjectResult,
				ParticipantUtils.canDeleteAccordingToParticipants(myTestObject));

		assertEquals(1, myCanDeleteSubTestObjectCalled);
		assertEquals(0, myCanDeleteTestObjectCalled);

		// --------------
		myCanDeleteTestObjectResult = true;
		myCanDeleteSubTestObjectResult = false;
		myCanDeleteTestObjectCalled = 0;
		myCanDeleteSubTestObjectCalled = 0;

		assertEquals(myCanDeleteTestObjectResult && myCanDeleteSubTestObjectResult,
				ParticipantUtils.canDeleteAccordingToParticipants(myTestObject));

		assertEquals(1, myCanDeleteSubTestObjectCalled);
		assertEquals(0, myCanDeleteTestObjectCalled);

		// --------------
		myCanDeleteTestObjectResult = true;
		myCanDeleteSubTestObjectResult = true;
		myCanDeleteTestObjectCalled = 0;
		myCanDeleteSubTestObjectCalled = 0;

		assertEquals(myCanDeleteTestObjectResult && myCanDeleteSubTestObjectResult,
				ParticipantUtils.canDeleteAccordingToParticipants(myTestObject));

		assertEquals(1, myCanDeleteSubTestObjectCalled);
		assertEquals(1, myCanDeleteTestObjectCalled);
	}

	public static class TestObjectDeleteParticipant extends AbstractDeleteParticipant {
		@Override
		public boolean canDelete(IDeleteParticipantContext context) {
			assertNotNull(context);
			assertEquals(myTestObject, context.getElement());

			myCanDeleteTestObjectCalled++;
			return myCanDeleteTestObjectResult;
		}
	}

	public static class SubTestObjectDeleteParticipant extends AbstractDeleteParticipant {
		@Override
		public boolean canDelete(IDeleteParticipantContext context) {
			assertNotNull(context);
			assertEquals(mySubTestObject, context.getElement());

			myCanDeleteSubTestObjectCalled++;
			return myCanDeleteSubTestObjectResult;
		}
	}
}
