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

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.IDecoratorProvider;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.ModelValueKind;

@RunWith(Parameterized.class)
public class DecoratorProviderTest<T, U> {
	protected final Class<T> myModelClass;
	protected final Class<U> myUIClass;
	protected final String myType;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

		{ String.class, String.class, "" },

		{ Character.class, String.class, "" }, { Character.TYPE, String.class, "" },

		{ BigInteger.class, String.class, "" },

		{ BigDecimal.class, String.class, "" },

		{ Integer.class, String.class, "" }, { Integer.TYPE, String.class, "" },

		{ Long.class, String.class, "" }, { Long.TYPE, String.class, "" },

		{ Short.class, String.class, "" }, { Short.TYPE, String.class, "" },

		{ Byte.class, String.class, "" }, { Byte.TYPE, String.class, "" },

		{ Float.class, String.class, "" }, { Float.TYPE, String.class, "" },

		{ Double.class, String.class, "" }, { Double.TYPE, String.class, "" },

		/* { BigInteger.class, String.class, "scientific" }, */

		{ BigDecimal.class, String.class, "scientific" },

		{ Float.class, String.class, "scientific" }, { Float.TYPE, String.class, "scientific" },

		{ Double.class, String.class, "scientific" }, { Double.TYPE, String.class, "scientific" },

		{ Boolean.class, String.class, "" }, { Boolean.TYPE, String.class, "" },

		{ Integer.class, Integer.class, "" }, { Integer.TYPE, Integer.TYPE, "" },

		{ Long.class, Long.class, "" }, { Long.TYPE, Long.TYPE, "" },

		{ Short.class, Short.class, "" }, { Short.TYPE, Short.TYPE, "" },

		{ Byte.class, Byte.class, "" }, { Byte.TYPE, Byte.TYPE, "" },

		{ Float.class, Float.class, "" }, { Float.TYPE, Float.TYPE, "" },

		{ Double.class, Double.class, "" }, { Double.TYPE, Double.TYPE, "" },

		{ Boolean.class, Boolean.class, "" }, { Boolean.TYPE, Boolean.TYPE, "" },

		{ Date.class, String.class, "" },

		/* requires a binding { Enum.class, String.class, "" }, */

		{ EObject.class, String.class, "" },

		{ Integer.class, Integer.TYPE, "" }, { Integer.TYPE, Integer.TYPE, "" },

		{ Boolean.class, Boolean.TYPE, "" }, { Boolean.TYPE, Boolean.TYPE, "" },

		{ Date.class, Date.class, "" },

		{ Color.class, Color.class, "" },

		/* { Point.class, Point.class, "" }, */

		{ Font.class, Font.class, "" },

		});
	}

	public DecoratorProviderTest(Class<T> modelClass, Class<U> uiClass, String type) {
		myType = type;
		myModelClass = modelClass;
		myUIClass = uiClass;
	}

	protected IDecoratorProvider provider = null;
	protected IUIBindingDecorator myDecorator = null;

	@Test
	public void test() {
		final IManager manager = IManager.Factory.getManager();
		final EList<IDecoratorProvider> providers = manager.getProviders();

		final String what = "(" + myModelClass.getSimpleName() + ", " + myUIClass.getSimpleName() + ", '" + myType
				+ "')";

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				provider = manager.getProvider(myModelClass, ModelValueKind.VALUE, myUIClass, myType);
				assertNotNull(what + " provider is null", provider);
				assertTrue(what + " is not a provider in the manager", providers.contains(provider));
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myDecorator = provider.getDecorator();
				assertNotNull(what + " decorator null", myDecorator);
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final IObservableList list = myDecorator.getValidUIList();
				assertEquals(what + " validList not identical", list, myDecorator.getValidUIList());
			}
		});
	}
}
