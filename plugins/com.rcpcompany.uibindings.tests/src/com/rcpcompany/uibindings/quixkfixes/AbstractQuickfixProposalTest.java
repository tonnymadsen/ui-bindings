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
package com.rcpcompany.uibindings.quixkfixes;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rcpcompany.uibindings.IQuickfixProposal;

public class AbstractQuickfixProposalTest {
	@Test
	public void imageTests() {
		assertNotNull(IQuickfixProposal.ADD_IMAGE);
		assertNotNull(IQuickfixProposal.CHANGE_IMAGE);
		assertNotNull(IQuickfixProposal.REMOVE_IMAGE);
	}
}
