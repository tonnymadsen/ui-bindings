/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.extests.manager;

import static com.rcpcompany.test.utils.BaseTestUtils.*;
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
