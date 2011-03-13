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
package com.rcpcompany.uibindings.extests.participants;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IAssignmentParticipantsManager;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.internal.InternalConstants;

/**
 * Test of {@link IManager#getAssignmentParticiantsManager()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ManagerAssignmentParticipantTest {
	private IManager MANAGER;

	@Before
	public void before() {
		resetAll();
		MANAGER = IManager.Factory.getManager();
	}

	@Test
	public void testGetAPM() {
		final IAssignmentParticipantsManager m = MANAGER.getAssignmentParticiantsManager();
		assertNotNull(m);

		assertEquals(m, MANAGER.getAssignmentParticiantsManager());
	}

	/**
	 * Number of entries.
	 */
	@Test
	public void testAssignment() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final IAssignmentParticipantsManager m = MANAGER.getAssignmentParticiantsManager();
				final List<IConfigurationElement> elements = getElements(InternalConstants.ASSIGNMENT_PARTICIPANT_TAG);

				assertTrue(m.getParticipants().size() > 12);
				assertEquals(elements.size(), m.getParticipants().size());

			}
		});
	}

}
