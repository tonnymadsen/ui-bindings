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
package com.rcpcompany.uibindings.internal.decorators.extenders;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor;
import com.rcpcompany.uibindings.IUIBindingsFactory;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.UIBindingDecoratorExtenderImpl;
import com.rcpcompany.uibindings.uiAttributes.VirtualUIAttribute;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * Tests of {@link IUIBindingDecoratorExtender} and {@link IUIBindingDecoratorExtenderContext}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ExtenderTest {
	private static final String EXTENDER = "EXTENDER";
	private TestObject myTestObject;
	private IManager MANAGER;
	private final MyExtender myExtender = new MyExtender();
	private IUIBindingDecoratorExtenderDescriptor myDescriptor;
	private TestView myView;
	private IUIAttribute myUIAttr;
	private IValueBinding myBinding;

	private final static Display D = Display.getCurrent();
	private final static Color RED = D.getSystemColor(SWT.COLOR_RED);
	private final static Color BLUE = D.getSystemColor(SWT.COLOR_BLUE);
	private final static Font CN = new Font(D, D.getFontList(null, true)[0]);

	@Before
	public void before() {
		MANAGER = IManager.Factory.getManager();
		myDescriptor = IUIBindingsFactory.eINSTANCE.createUIBindingDecoratorExtenderDescriptor();
		myDescriptor.setFactory(new CEObjectHolder<IUIBindingDecoratorExtender>(myExtender));
		myDescriptor.setPriority(20000);
		MANAGER.getDecoratorExtenders().add(myDescriptor);

		myTestObject = TestModelFactory.eINSTANCE.createTestObject();
		myUIAttr = new VirtualUIAttribute(String.class);

		myView = createTestView(this);

		final IFormCreator form = myView.createFormCreator(myTestObject);
		myBinding = form.getContext().addBinding().model(myTestObject, TestModelPackage.Literals.TEST_OBJECT__NUMBER)
				.ui(myUIAttr).arg(EXTENDER, true);
		form.finish();

		myView.getParent().layout();
	}

	@After
	public void after() {
		MANAGER.getDecoratorExtenders().remove(myDescriptor);

		myView.getSite().getPage().hideView(myView);
	}

	/**
	 * Test the colors and fonts aspects of {@link IUIBindingDecoratorExtender}.
	 */
	@Test
	public void testColorsFont() {
		testOne(new E() {
			@Override
			public void extend(IUIBindingDecoratorExtenderContext context) {
				context.setBackgound(RED);
				context.setForegound(BLUE);
				context.setFont(CN);
				context.setCursor(D.getSystemCursor(SWT.CURSOR_CROSS));
			}
		});

		assertEquals(RED, myUIAttr.getBackground());
		assertEquals(BLUE, myUIAttr.getForeground());
		assertEquals(CN, myUIAttr.getFont());
		assertEquals(D.getSystemCursor(SWT.CURSOR_CROSS), myUIAttr.getCursor());
	}

	/**
	 * Test the enabled aspects of {@link IUIBindingDecoratorExtender}.
	 */
	@Test
	public void testEnabled() {
		testOne(new E() {
			@Override
			public void extend(IUIBindingDecoratorExtenderContext context) {
				context.setEnabled(false);
			}
		});

		assertEquals(false, myUIAttr.isEnabled());
	}

	/**
	 * Test the text aspects of {@link IUIBindingDecoratorExtender}.
	 */
	@Test
	public void testText() {
		testOne(new E() {
			@Override
			public void extend(IUIBindingDecoratorExtenderContext context) {
				context.setMessageFormat("abc");
				context.setTooltip("xyz");
			}
		});

		assertEquals("abc", myUIAttr.getCurrentValue().getValue());
		assertEquals("xyz", myUIAttr.getTooltip());
	}

	/**
	 * Test appending tooltip of {@link IUIBindingDecoratorExtender}.
	 */
	@Test
	public void testTooltip() {
		testOne(new E() {
			@Override
			public void extend(IUIBindingDecoratorExtenderContext context) {
				context.appendTooltip("abc");
				context.appendTooltip("xyz");
			}
		});
		/*
		 * Number is unsettable
		 */
		assertEquals("[Set to Default] abc xyz", myUIAttr.getTooltip());
	}

	/**
	 * Test the number aspects of {@link IUIBindingDecoratorExtender}.
	 */
	@Test
	public void testMinMax() {
		testOne(new E() {
			@Override
			public void extend(IUIBindingDecoratorExtenderContext context) {
				context.setMin(-10);
				context.setMax(10);
			}
		});

		assertEquals(-10, myUIAttr.getMinValue().getValue());
		assertEquals(10, myUIAttr.getMaxValue().getValue());
	}

	private void testOne(E e) {
		myExtender.e = e;
		myExtender.called = 0;
		myBinding.updateBinding();

		assertEquals(1, myExtender.called);
	}

	private interface E {
		public void extend(IUIBindingDecoratorExtenderContext context);
	}

	private class MyExtender extends UIBindingDecoratorExtenderImpl {
		public E e = null;
		public int called = 0;

		@Override
		public boolean isEnabled(IValueBinding binding) {
			return binding.getArgument(EXTENDER, Boolean.class, false);
		}

		@Override
		public void extend(IUIBindingDecoratorExtenderContext context) {
			called++;
			if (e != null) {
				e.extend(context);
			}
		}
	}
}
