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
package com.rcpcompany.uibindings.extests.sourceProviders;

import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.ISourceProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.ui.services.ISourceProviderService;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.sourceProviders.ManagerSourceProvider;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

/**
 * Tests of the defined sources in {@link ManagerSourceProvider} and well as the value of these.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ManagerSourceProviderTest {
	private Shop myShop;

	private ISourceProvider myProvider;

	private CommandStack myCommandStack;

	private ICommandService myCommandService;

	private org.eclipse.core.commands.Command myUndoCommand;

	private org.eclipse.core.commands.Command myRedoCommand;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();

		final IManager mng = IManager.Factory.getManager();
		myCommandStack = mng.getEditingDomain().getCommandStack();
		assertEquals(false, myCommandStack.canUndo());
		assertEquals(false, myCommandStack.canRedo());

		createShop();

		final IServiceLocator locator = PlatformUI.getWorkbench();

		final ISourceProviderService sourceProviders = (ISourceProviderService) locator
				.getService(ISourceProviderService.class);

		myCommandService = (ICommandService) locator.getService(ICommandService.class);

		myUndoCommand = myCommandService.getCommand("org.eclipse.ui.edit.undo");
		assertNotNull(myUndoCommand);
		assertTrue(myUndoCommand.isDefined());
		myRedoCommand = myCommandService.getCommand("org.eclipse.ui.edit.redo");
		assertNotNull(myRedoCommand);
		assertTrue(myRedoCommand.isDefined());

		myProvider = sourceProviders.getSourceProvider(Constants.SOURCES_CAN_UNDO);
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("ABC");
	}

	/**
	 * Tests that the services extension point for {@link BindingSourceProvider} is correct.
	 */
	@Test
	public void testServicesExtension() {
		boolean found = false;
		final Map<String, Object> currentState = myProvider.getCurrentState();

		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		for (final IConfigurationElement ce : registry.getConfigurationElementsFor("org.eclipse.ui.services")) {
			if (!ce.getContributor().getName().equals(Activator.ID)) {
				continue;
			}
			assertEquals("sourceProvider", ce.getName());
			if (!ce.getAttribute("provider").equals(ManagerSourceProvider.class.getName())) {
				continue;
			}

			assertTrue(!found);
			found = true;

			final IConfigurationElement[] children = ce.getChildren("variable");
			for (final IConfigurationElement cce : children) {
				final String name = cce.getAttribute("name");
				assertTrue(name + " not present", currentState.containsKey(name));
				assertEquals(name + " priority", "activeSite", cce.getAttribute("priorityLevel"));
			}
			assertEquals(myProvider.getProvidedSourceNames().length, children.length);
		}

		assertTrue(found);
	}

	/**
	 * Test the values of the sources.
	 */
	@Test
	public void testValues() {
		final EditingDomain ed = EditingDomainUtils.getEditingDomain();
		final CommandStack cs = ed.getCommandStack();

		testUndoRedo("ABC", false, false);

		final Command c1 = SetCommand.create(ed, myShop, IMOAOPackage.Literals.NAMED_OBJECT__NAME, "NEW");
		cs.execute(c1);
		testUndoRedo("NEW", true, false);

		cs.undo();
		testUndoRedo("ABC", false, true);

		cs.redo();
		testUndoRedo("NEW", true, false);
	}

	private void testUndoRedo(String expectedName, boolean expectedCanUndo, boolean expectedCanRedo) {
		yield();

		assertEquals(expectedName, myShop.getName());

		final Map currentState = myProvider.getCurrentState();
		assertEquals(expectedCanUndo, currentState.get(Constants.SOURCES_CAN_UNDO));
		assertEquals(expectedCanRedo, currentState.get(Constants.SOURCES_CAN_REDO));

		assertEquals(expectedCanUndo, myUndoCommand.isEnabled());
		assertEquals(expectedCanRedo, myRedoCommand.isEnabled());
	}
}
