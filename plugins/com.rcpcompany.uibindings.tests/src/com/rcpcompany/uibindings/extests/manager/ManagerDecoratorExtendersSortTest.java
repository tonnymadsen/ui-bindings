package com.rcpcompany.uibindings.extests.manager;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor;

/**
 * Tests the sorting order of decorator extenders from the manager.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ManagerDecoratorExtendersSortTest {
	@Test
	public void testOrder() {
		int p = Integer.MIN_VALUE;

		for (final IUIBindingDecoratorExtenderDescriptor e : IManager.Factory.getManager().getDecoratorExtenders()) {
			assertTrue(p <= e.getPriority());
			p = e.getPriority();
		}
	}
}
