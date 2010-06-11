package com.rcpcompany.uibindings.quixkfixes;

import static org.junit.Assert.assertNotNull;

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
