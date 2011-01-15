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
package com.rcpcompany.uibindings.extests.bindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;

/**
 * Test that {@link IBinding#getCreationPoint()} is handled correctly.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class CreationPointTest {
	private final int myLevels;

	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] {

		{ 0 },

		{ 7 }

		});
	}

	public CreationPointTest(int levels) {
		myLevels = levels;
	}

	private Shop myShop;

	private TestView myView;
	private Composite myBody;
	private FormToolkit myToolkit;

	private Text myText;

	private int STACK_LEVELS;

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellAnyKey(false);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		STACK_LEVELS = Activator.getDefault().CREATION_POINT_STACK_LEVELS;

		createShop();
		createView();

		myView.getSite().getPage().activate(myView);
		myBody.layout();
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);
		myToolkit = myView.getToolkit();
		myBody = myView.getBody();
		myBody.setLayout(new TableWrapLayout());

		myText = myToolkit.createText(myBody, "", SWT.NONE);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}

		Activator.getDefault().CREATION_POINT_STACK_LEVELS = STACK_LEVELS;
	}

	protected int lineNumber;
	protected IBindingContext context;
	protected IValueBinding binding;

	/**
	 * Test the creation of the creation point structure.
	 */
	@Test
	public void testCP() {
		Activator.getDefault().CREATION_POINT_STACK_LEVELS = myLevels;
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				context = IBindingContext.Factory.createContext(myView.getScrolledForm());

				final Throwable t = new Throwable();
				t.fillInStackTrace();
				lineNumber = t.getStackTrace()[0].getLineNumber() + 2;
				binding = context.addBinding();
				assertNotNull(binding);
				final Throwable creationPoint = binding.getCreationPoint();
				if (Activator.getDefault().CREATION_POINT_STACK_LEVELS == 0) {
					assertEquals(null, creationPoint);
				} else {
					assertNotNull(creationPoint);
					assertEquals(myLevels, creationPoint.getStackTrace().length);
					assertEquals(lineNumber, creationPoint.getStackTrace()[0].getLineNumber());

					binding.ui(myText);
					assertNotNull(creationPoint);
					assertEquals(myLevels, creationPoint.getStackTrace().length);
					assertEquals(lineNumber, creationPoint.getStackTrace()[0].getLineNumber());
				}
			}
		});

		/*
		 * When we finish below, the model side of the binding has not been made, so it will result
		 * in an exception
		 */
		final IStatus status = assertOneLog(new Runnable() {
			@Override
			public void run() {
				context.finish();
				yield();
			}
		});
		Throwable exception = status.getException();
		assertNotNull(exception);
		exception = exception.getCause();
		if (Activator.getDefault().CREATION_POINT_STACK_LEVELS == 0) {
			assertEquals(null, exception);
		} else {
			assertNotNull(exception);
			assertEquals(myLevels, exception.getStackTrace().length);
			assertEquals(lineNumber, exception.getStackTrace()[0].getLineNumber());

			// assertEquals(null, binding.getCreationPoint());
		}
	}
}
