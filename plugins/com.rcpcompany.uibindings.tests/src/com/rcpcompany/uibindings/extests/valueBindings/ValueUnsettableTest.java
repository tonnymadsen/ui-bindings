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
package com.rcpcompany.uibindings.extests.valueBindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.handlers.IHandlerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.decorators.extenders.UnsettableExtender;
import com.rcpcompany.uibindings.internal.handlers.UseDefaultValueHandler;

/**
 * Tests {@link UnsettableExtender} and {@link UseDefaultValueHandler}.
 * <p>
 * Depends on:
 * <ul>
 * <li></li>
 * <li></li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ValueUnsettableTest {

	private TestView myView;
	private Composite myBody;

	private IBindingContext myContext;
	private TestObject myObject;
	private Text myUnsettableText;
	private Text myNormalText;
	private ParameterizedCommand myCommand;
	private IHandlerService myHandlerServer;

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
		bindUI();

		myView.getSite().getPage().activate(myView);
		myBody.layout();

		final ICommandService cs = (ICommandService) myView.getSite().getService(ICommandService.class);
		myHandlerServer = (IHandlerService) myView.getSite().getService(IHandlerService.class);

		try {
			myCommand = cs.deserialize(Constants.USE_DEFAULT_TOGGLE_COMMAND);
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
		assertTrue(myCommand.getCommand().isDefined());
	}

	/**
	 * Creates the shop itself
	 */
	public void createModel() {
		myObject = TestModelFactory.eINSTANCE.createTestObject();
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();
		myBody.setLayout(new TableWrapLayout());

		myUnsettableText = myView.getToolkit().createText(myBody, "");
		myNormalText = myView.getToolkit().createText(myBody, "");
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Binds the UI
	 */
	public void bindUI() {
		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());

		myContext.addBinding(myNormalText, myObject, TestModelPackage.Literals.TEST_OBJECT__F);
		myContext.addBinding(myUnsettableText, myObject, TestModelPackage.Literals.TEST_OBJECT__NUMBER);

		myContext.finish();
		yield();
	}

	/**
	 * Checks that a normal feature (not unsettable) does not have an enabled command
	 */
	@Test
	public void testNormal() {
		//
		myNormalText.setFocus();
		yield();

		assertTrue(myCommand.getCommand().isHandled());
		assertTrue(!myCommand.getCommand().isEnabled());
	}

	/**
	 * Checks that an unsettable feature does have an enabled command and state is correct
	 */
	@Test
	public void testUnsettable() {
		//
		myUnsettableText.setFocus();
		yield();

		assertTrue(myCommand.getCommand().isHandled());
		assertTrue(myCommand.getCommand().isEnabled());

		myObject.unsetNumber();
		assertTrue(!myObject.eIsSet(TestModelPackage.Literals.TEST_OBJECT__NUMBER));

		assertNoLog(new Runnable() {
			public void run() {
				try {
					myHandlerServer.executeCommand(myCommand, null);
				} catch (final Exception ex) {
					fail(ex.getMessage());
				}
			}
		});

		assertTrue(myObject.eIsSet(TestModelPackage.Literals.TEST_OBJECT__NUMBER));

		try {
			myHandlerServer.executeCommand(myCommand, null);
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}

		assertTrue(!myObject.eIsSet(TestModelPackage.Literals.TEST_OBJECT__NUMBER));
	}
}
