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
package com.rcpcompany.uibindings.extests.manager;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IFormatter;
import com.rcpcompany.uibindings.IFormatterProvider;
import com.rcpcompany.uibindings.IManager;

/**
 * Test of {@link IManager#getFormatterProvider()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ManagerFormatterProviderTest {
	private IManager MANAGER;
	private IFormatterProvider myOrigFormatterProvider;

	@Before
	public void before() {
		resetAll();
		MANAGER = IManager.Factory.getManager();
		myOrigFormatterProvider = MANAGER.getFormatterProvider();
	}

	@Test
	public void testSetGet() {
		assertEquals(myOrigFormatterProvider, MANAGER.getFormatterProvider());

		MANAGER.setFormatterProvider(null);
		assertNotSame(null, MANAGER.getFormatterProvider());
		assertNotSame(myOrigFormatterProvider, MANAGER.getFormatterProvider());

		final IFormatterProvider fp = new FP();

		MANAGER.setFormatterProvider(fp);
		assertEquals(fp, MANAGER.getFormatterProvider());
	}

	@Test
	public void testDefaultFormatG() {
		testOne("%g", 1.2f, "1.20000");
	}

	@Test
	public void testDefaultFormatD() {
		testOne("%3d", 12, " 12");
	}

	private void testOne(final String format, final Object arg, final String expectedResult) {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final StringBuilder sb = new StringBuilder();
				final IFormatter formatter = myOrigFormatterProvider.getFormatter(sb, format);
				formatter.format(arg);
				assertEquals(expectedResult, sb.toString());
			}
		});
	}

	@After
	public void after() {
		MANAGER.setFormatterProvider(myOrigFormatterProvider);
	}

	public class FP implements IFormatterProvider {
		@Override
		public IFormatter getFormatter(Appendable dest, String format) {
			return null;
		}
	}
}
