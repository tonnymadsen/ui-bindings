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
package com.rcpcompany.uibindings.extests.spy;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.internal.spy.BindingSpyDialog;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;

public class SpyDialogTest {
	private Shop myShop;
	private Text myText;
	private UIBTestView myView;

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
		bindUI();
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("The little shop");
	}

	private void createView() {
		myView = UIBindingsTestUtils.createUIBTestView(this);

		final Composite body = myView.getBody();

		myText = myView.getToolkit().createText(body, "");
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	private void bindUI() {
		final IBindingContext context = IBindingContext.Factory.createContext(myView.getScrolledForm());

		context.addBinding(myText, myShop, IMOAOPackage.Literals.NAMED_OBJECT__NAME);

		context.finish();
		yield();
	}

	@Test
	public void testSpy() {
		try {
			final IWorkbench workbench = PlatformUI.getWorkbench();
			final int shells = workbench.getDisplay().getShells().length;

			myText.setFocus();
			yield();

			// Have to use timerExec to get the runnable executed after the dialog is shown
			workbench.getDisplay().timerExec(1000, new Runnable() {
				@Override
				public void run() {
					/*
					 * More than one shell is created as the used CCombo's also each create a Shell.
					 */
					assertTrue(workbench.getDisplay().getShells().length > shells);
					final Shell lastShell = workbench.getDisplay().getShells()[shells];
					assertNotNull(lastShell);
					final Object data = lastShell.getData();
					assertNotNull(data);
					assertTrue(data instanceof BindingSpyDialog);
					((BindingSpyDialog) data).close();

					assertEquals(shells, workbench.getDisplay().getShells().length);
				}
			});

			postKeyStroke(myText, "M2+M3+F3");

			sleep(2000);
			assertEquals(shells, workbench.getDisplay().getShells().length);
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
	}
}
