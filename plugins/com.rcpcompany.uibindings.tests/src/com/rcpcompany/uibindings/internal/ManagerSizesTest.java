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
package com.rcpcompany.uibindings.internal;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;

/**
 * This class tests that the difference lists and maps of the {@link IManager} have a sane size.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ManagerSizesTest {
	private IManager m;

	@Before
	public void setup() {
		resetAll();
		m = IManager.Factory.getManager();
	}

	/**
	 * Tests for {@link IManager#providers}.
	 */
	@Test
	public void testAttributeProviders() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final List<IConfigurationElement> elements = getElements(InternalConstants.BINDING_DECORATOR_TAG);

				assertTrue(m.getProviders().size() > 12);
				assertEquals(elements.size(), m.getProviders().size());

			}
		});
	}

	/**
	 * Tests for {@link IManager#myQuickfixes}.
	 */
	@Test
	public void testAttributeQuickfixes() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final List<IConfigurationElement> elements = getElements(InternalConstants.QUICKFIX_PROCESSOR_TAG);

				assertTrue(m.getQuickfixProposalProcessors().size() > 2);
				assertEquals(elements.size(), m.getQuickfixProposalProcessors().size());
			}
		});
	}

	/**
	 * Tests for {@link IManager#myQuickfixes}.
	 */
	@Test
	public void testArgumentInfo() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final List<IConfigurationElement> elements = getElements(InternalConstants.ARGUMENT_INFO_TAG);

				assertTrue(m.getArgumentInformation().size() > 2);
				assertEquals(elements.size(), m.getArgumentInformation().size());
			}
		});
	}

	/**
	 * Tests for {@link IManager#getUiAttributeFactories()}.
	 */
	@Test
	public void testAttributeUIAttributeFactoryRepository() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final List<IConfigurationElement> elements = getElements(InternalConstants.UI_ATTRIBUTE_FACTORY_TAG);

				assertTrue(m.getUiAttributeFactories().size() > 2);
				assertEquals(elements.size(), m.getUiAttributeFactories().size());
			}
		});
	}

	/**
	 * Tests for {@link IManager#myModelClassInfo}.
	 */
	@Test
	public void testAttributeModelClassInfo() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final List<IConfigurationElement> elements = getElements(InternalConstants.MODEL_TAG);

				assertTrue(m.getModelInfo().size() > 1);
				// Some elements can refer to the same model class and thus collapse the number of
				// model class records.
				assertTrue(elements.size() - 10 < m.getModelInfo().size());
			}
		});
	}

	/**
	 * Tests for {@link IManager#myObservableFactories}.
	 */
	@Test
	public void testAttributeObservableFactories() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final List<IConfigurationElement> elements = getElements(InternalConstants.OBSERVABLES_FACTORY_TAG);

				// assertTrue(m.myObservableFactories.size() > 1);
				assertEquals(elements.size(), m.getObservableFactories().size());
			}
		});
	}
}
