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
package com.rcpcompany.uibindings.extests.utils;

import static org.junit.Assert.*;

import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.SubTestObject;
import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.participants.AbstractDeleteParticipant;
import com.rcpcompany.uibindings.participants.IDeleteParticipantContext;

/**
 * Tests {@link com.rcpcompany.uibindings.IDeleteParticipant}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DeleteParticipantTest {
	/*
	 * Here to provoke load of the test model...
	 */
	private static EClass to = TestModelPackage.Literals.TEST_OBJECT;

	private static TestObject myTestObject;
	private static SubTestObject mySubTestObject;

	public static boolean myCanDeleteTestObjectResult = true;
	public static int myCanDeleteTestObjectCalled = 0;

	public static boolean myCanDeleteSubTestObjectResult = true;
	public static int myCanDeleteSubTestObjectCalled = 0;

	public static boolean myQueryUser = true;

	public static final IManager M = IManager.Factory.getManager();
	public static final EditingDomain ED = M.getEditingDomain();

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
		myQueryUser = false;

		Command c = M.deleteObjects(ED, Collections.singletonList(myTestObject), myQueryUser);
		assertEquals(myCanDeleteTestObjectResult, c != null && c.canExecute());

		assertEquals(1, myCanDeleteTestObjectCalled);
		assertEquals(0, myCanDeleteSubTestObjectCalled);

		// --------------
		myCanDeleteTestObjectResult = false;
		myCanDeleteSubTestObjectResult = false;
		myCanDeleteTestObjectCalled = 0;
		myCanDeleteSubTestObjectCalled = 0;
		myQueryUser = true;

		c = M.deleteObjects(ED, Collections.singletonList(myTestObject), myQueryUser);
		assertEquals(myCanDeleteTestObjectResult, c != null && c.canExecute());

		assertEquals(1, myCanDeleteTestObjectCalled);
		assertEquals(0, myCanDeleteSubTestObjectCalled);

		// --------------
		myCanDeleteTestObjectResult = true;
		myCanDeleteSubTestObjectResult = false;
		myCanDeleteTestObjectCalled = 0;
		myCanDeleteSubTestObjectCalled = 0;
		myQueryUser = false;

		c = M.deleteObjects(ED, Collections.singletonList(myTestObject), myQueryUser);
		assertEquals(myCanDeleteTestObjectResult, c != null && c.canExecute());

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
		myQueryUser = false;

		Command c = M.deleteObjects(ED, Collections.singletonList(mySubTestObject), myQueryUser);
		assertEquals(myCanDeleteSubTestObjectResult, c != null && c.canExecute());

		assertEquals(1, myCanDeleteSubTestObjectCalled);
		assertEquals(0, myCanDeleteTestObjectCalled);

		// --------------
		myCanDeleteTestObjectResult = true;
		myCanDeleteSubTestObjectResult = false;
		myCanDeleteTestObjectCalled = 0;
		myCanDeleteSubTestObjectCalled = 0;
		myQueryUser = false;

		c = M.deleteObjects(ED, Collections.singletonList(myTestObject), myQueryUser);
		assertEquals(myCanDeleteTestObjectResult && myCanDeleteSubTestObjectResult, c != null && c.canExecute());

		assertEquals(1, myCanDeleteSubTestObjectCalled);
		assertEquals(0, myCanDeleteTestObjectCalled);

		// --------------
		myCanDeleteTestObjectResult = true;
		myCanDeleteSubTestObjectResult = true;
		myCanDeleteTestObjectCalled = 0;
		myCanDeleteSubTestObjectCalled = 0;
		myQueryUser = false;

		c = M.deleteObjects(ED, Collections.singletonList(myTestObject), myQueryUser);
		assertEquals(myCanDeleteTestObjectResult && myCanDeleteSubTestObjectResult, c != null && c.canExecute());

		assertEquals(1, myCanDeleteSubTestObjectCalled);
		assertEquals(1, myCanDeleteTestObjectCalled);
	}

	public static class TestObjectDeleteParticipant extends AbstractDeleteParticipant {
		@Override
		public boolean canDelete(IDeleteParticipantContext context) {
			assertNotNull(context);
			assertEquals(myTestObject, context.getElement());
			assertEquals(myQueryUser, context.canQueryUser());
			assertEquals(ED, context.getEditingDomain());

			myCanDeleteTestObjectCalled++;
			return myCanDeleteTestObjectResult;
		}
	}

	public static class SubTestObjectDeleteParticipant extends AbstractDeleteParticipant {
		@Override
		public boolean canDelete(IDeleteParticipantContext context) {
			assertNotNull(context);
			assertEquals(mySubTestObject, context.getElement());
			assertEquals(myQueryUser, context.canQueryUser());
			assertEquals(ED, context.getEditingDomain());

			myCanDeleteSubTestObjectCalled++;
			return myCanDeleteSubTestObjectResult;
		}
	}
}
