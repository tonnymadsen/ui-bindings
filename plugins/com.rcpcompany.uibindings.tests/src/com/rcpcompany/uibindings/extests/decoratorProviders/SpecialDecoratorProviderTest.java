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
package com.rcpcompany.uibindings.extests.decoratorProviders;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.rcpcompany.uibindings.IDecoratorProvider;
import com.rcpcompany.uibindings.IEnumDecoratorProvider;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.ModelValueKind;

public class SpecialDecoratorProviderTest {
	@Test
	public void testEnumDecorator() {
		final IDecoratorProvider provider = IManager.Factory.getManager().getProvider(Enum.class, ModelValueKind.VALUE,
				String.class, "");

		assertNotNull(provider);
		assertTrue(provider instanceof IEnumDecoratorProvider);
	}

	@Test
	public void testDateDecorator() {
		final IDecoratorProvider provider = IManager.Factory.getManager().getProvider(Date.class, ModelValueKind.VALUE,
				String.class, "");

		assertNotNull(provider);
		// TODO: assertTrue(provider instanceof DateDecoratorProvider);
	}
}
