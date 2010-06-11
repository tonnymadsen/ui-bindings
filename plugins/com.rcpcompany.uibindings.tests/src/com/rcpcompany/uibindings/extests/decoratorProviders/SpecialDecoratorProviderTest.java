package com.rcpcompany.uibindings.extests.decoratorProviders;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import com.rcpcompany.uibindings.IDecoratorProvider;
import com.rcpcompany.uibindings.IEnumDecoratorProvider;
import com.rcpcompany.uibindings.IManager;

public class SpecialDecoratorProviderTest {
	@Test
	public void testEnumDecorator() {
		final IDecoratorProvider provider = IManager.Factory.getManager().getProvider(Enum.class, String.class, "");

		assertNotNull(provider);
		assertTrue(provider instanceof IEnumDecoratorProvider);
	}

	@Test
	public void testDateDecorator() {
		final IDecoratorProvider provider = IManager.Factory.getManager().getProvider(Date.class, String.class, "");

		assertNotNull(provider);
		// TODO: assertTrue(provider instanceof DateDecoratorProvider);
	}
}
