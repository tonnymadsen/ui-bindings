package com.rcpcompany.uibindings.extests.manager;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.IDecoratorProvider;
import com.rcpcompany.uibindings.IManager;

/**
 * Tests the providers from the manager.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class ManagerDecoratorProvidersTest {

	private final IDecoratorProvider myProvider;

	@Parameters
	public static Collection<Object[]> data() {
		final Collection<Object[]> l = new ArrayList<Object[]>();

		for (final IDecoratorProvider p : IManager.Factory.getManager().getProviders()) {
			l.add(new Object[] { p });
		}

		return l;
	}

	public ManagerDecoratorProvidersTest(IDecoratorProvider provider) {
		myProvider = provider;
	}

	/**
	 * Tests for {@link IManager#getProviders()}.
	 */
	@Test
	public void testGetProviders() {
		assertNotNull(myProvider.getId());
		assertNotNull(myProvider.getType());
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				assertNotNull(myProvider.getProviderCE());
			}
		});
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				assertNotNull(myProvider.getChildCE());
			}
		});
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				assertNotNull(myProvider.getDecorator());
			}
		});
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				assertTrue(myProvider.getModelTypes().size() >= 0);
			}
		});
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				assertTrue(myProvider.getUiTypes().size() > 0);
			}
		});
	}
}
