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
package com.rcpcompany.uibindings.internal.utils;

import static com.rcpcompany.test.utils.BaseTestUtils.*;
import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.IGlobalNavigationManager;
import com.rcpcompany.uibindings.utils.IGlobalNavigationManager.BackwardHistoryHandler;
import com.rcpcompany.uibindings.utils.IGlobalNavigationManager.ForwardHistoryHandler;

/**
 * Test of {@link IGlobalNavigationManager}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GlobalNavigationManagerTest {
	private Shop myShop;
	private UIBTestView myView;
	private IFormCreator myForm;
	private IValueBinding myField1;
	private IValueBinding myField2;
	private IValueBinding myField3;
	private IValueBinding myField4;

	@Before
	public void setup() {
		BaseUIBTestUtils.resetAll();

		createModel();
		createView();
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("Hello");
		myShop.setNextCustomerNo(0);
	}

	private void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);
		myForm = myView.createFormCreator(myShop);

		myField1 = myForm.addField("name");
		myField2 = myForm.addField("name");
		myField3 = myForm.addField("name");
		myField4 = myForm.addField("name");

		myForm.finish();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Test for the existence of the manager
	 */
	@Test
	public void testExistence() {
		final IWorkbenchWindow w1 = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchWindow w2 = null;
		assertNotNull(w1);

		assertNull(IGlobalNavigationManager.Factory.getManager(w1));

		final IGlobalNavigationManager nm1 = IGlobalNavigationManager.Factory.createManager(w1);
		assertNotNull(nm1);

		assertEquals(nm1, IGlobalNavigationManager.Factory.createManager(w1));
		assertEquals(nm1, IGlobalNavigationManager.Factory.getManager(w1));

		nm1.dispose();
		assertNull(IGlobalNavigationManager.Factory.getManager(w1));

		final IGlobalNavigationManager nm2 = IGlobalNavigationManager.Factory.createManager(w1);
		assertNotNull(nm2);
		assertNotSame(nm1, nm2);

		assertEquals(nm2, IGlobalNavigationManager.Factory.createManager(w1));
		assertEquals(nm2, IGlobalNavigationManager.Factory.getManager(w1));

		try {
			w2 = PlatformUI.getWorkbench().openWorkbenchWindow(null);
		} catch (final WorkbenchException ex) {
			fail(ex.getMessage());
		}

		final IGlobalNavigationManager nm3 = IGlobalNavigationManager.Factory.createManager(w2);
		assertNotNull(nm3);
		assertNotSame(nm1, nm3);
		assertNotSame(nm2, nm3);

		assertEquals(nm2, IGlobalNavigationManager.Factory.getManager(w1));
		assertEquals(nm3, IGlobalNavigationManager.Factory.getManager(w2));

		nm2.dispose();

		assertEquals(null, IGlobalNavigationManager.Factory.getManager(w1));
		assertEquals(nm3, IGlobalNavigationManager.Factory.getManager(w2));

		assertTrue(w2.close());

		assertEquals(null, IGlobalNavigationManager.Factory.getManager(w1));
		assertEquals(null, IGlobalNavigationManager.Factory.getManager(w2));
	}

	/**
	 * Test manager is not automatically created
	 */
	@Test
	public void testNoExistence() {
		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		assertNotNull(window);

		assertNull(IGlobalNavigationManager.Factory.getManager(window));

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				IGlobalNavigationManager.Factory.addLocation();
				assertNull(IGlobalNavigationManager.Factory.getManager(window));
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final BackwardHistoryHandler handler = new IGlobalNavigationManager.BackwardHistoryHandler();
				assertNotNull(handler);
				assertNull(IGlobalNavigationManager.Factory.getManager(window));
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final ForwardHistoryHandler handler = new IGlobalNavigationManager.ForwardHistoryHandler();
				assertNotNull(handler);
				assertNull(IGlobalNavigationManager.Factory.getManager(window));
			}
		});
	}

	/**
	 * Test that the location stack is correct
	 */
	@Test
	public void testStack() {
		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		assertNotNull(window);

		final GlobalNavigationManager mng = (GlobalNavigationManager) IGlobalNavigationManager.Factory
				.createManager(window);
		assertNotNull(mng);

		assertTrue(myField1.getControl().setFocus());
		yield();
		assertEquals(1, mng.getLocationStack().size());
		assertEquals(0, mng.getCurrentLocationIndex());
		assertEquals(false, mng.isBackwardHistoryEnabled());
		assertEquals(false, mng.isForwardHistoryEnabled());
		assertEquals(myField1, mng.getCurrentLocation().getBinding());

		// add: adds a new location
		mng.addLocation();
		assertTrue(myField2.getControl().setFocus());
		yield();
		assertEquals(2, mng.getLocationStack().size());
		assertEquals(1, mng.getCurrentLocationIndex());
		assertEquals(true, mng.isBackwardHistoryEnabled());
		assertEquals(false, mng.isForwardHistoryEnabled());
		assertEquals(myField2, mng.getCurrentLocation().getBinding());

		// add: adds a new location
		mng.addLocation();
		assertTrue(myField3.getControl().setFocus());
		yield();
		assertEquals(3, mng.getLocationStack().size());
		assertEquals(2, mng.getCurrentLocationIndex());
		assertEquals(true, mng.isBackwardHistoryEnabled());
		assertEquals(false, mng.isForwardHistoryEnabled());
		assertEquals(myField3, mng.getCurrentLocation().getBinding());

		// backward: moved back
		mng.backwardHistory();
		assertTrue(myField2.getControl().isFocusControl());

		assertEquals(3, mng.getLocationStack().size());
		assertEquals(1, mng.getCurrentLocationIndex());
		assertEquals(true, mng.isBackwardHistoryEnabled());
		assertEquals(true, mng.isForwardHistoryEnabled());
		assertEquals(myField2, mng.getCurrentLocation().getBinding());

		// change focus: current location is updated
		assertTrue(myField4.getControl().setFocus());
		yield();
		assertEquals(3, mng.getLocationStack().size());
		assertEquals(1, mng.getCurrentLocationIndex());
		assertEquals(true, mng.isBackwardHistoryEnabled());
		assertEquals(true, mng.isForwardHistoryEnabled());
		assertEquals(myField4, mng.getCurrentLocation().getBinding());

		// forward: move forward
		mng.forwardHistory();
		assertTrue(myField3.getControl().isFocusControl());

		assertEquals(3, mng.getLocationStack().size());
		assertEquals(2, mng.getCurrentLocationIndex());
		assertEquals(true, mng.isBackwardHistoryEnabled());
		assertEquals(false, mng.isForwardHistoryEnabled());
		assertEquals(myField3, mng.getCurrentLocation().getBinding());

		// backward: moved back
		mng.backwardHistory();
		assertTrue(myField4.getControl().isFocusControl());

		assertEquals(3, mng.getLocationStack().size());
		assertEquals(1, mng.getCurrentLocationIndex());
		assertEquals(true, mng.isBackwardHistoryEnabled());
		assertEquals(true, mng.isForwardHistoryEnabled());
		assertEquals(myField4, mng.getCurrentLocation().getBinding());

		// backward: moved back
		mng.backwardHistory();
		assertTrue(myField1.getControl().isFocusControl());

		assertEquals(3, mng.getLocationStack().size());
		assertEquals(0, mng.getCurrentLocationIndex());
		assertEquals(false, mng.isBackwardHistoryEnabled());
		assertEquals(true, mng.isForwardHistoryEnabled());
		assertEquals(myField1, mng.getCurrentLocation().getBinding());

		// add: removes the old locations and adds a new location
		mng.addLocation();
		assertTrue(myField3.getControl().setFocus());
		yield();
		assertEquals(2, mng.getLocationStack().size());
		assertEquals(1, mng.getCurrentLocationIndex());
		assertEquals(true, mng.isBackwardHistoryEnabled());
		assertEquals(false, mng.isForwardHistoryEnabled());
		assertEquals(myField3, mng.getCurrentLocation().getBinding());
	}

	/**
	 * Tests that views are correctly activated
	 */
	@Test
	public void testViewActivation() {
		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		assertNotNull(window);

		final GlobalNavigationManager mng = (GlobalNavigationManager) IGlobalNavigationManager.Factory
				.createManager(window);
		assertNotNull(mng);

		assertTrue(myField1.getControl().setFocus());
		yield();
		assertEquals(1, mng.getLocationStack().size());
		assertEquals(0, mng.getCurrentLocationIndex());
		assertEquals(false, mng.isBackwardHistoryEnabled());
		assertEquals(false, mng.isForwardHistoryEnabled());
		assertEquals(myView.getViewSite().getSecondaryId(), mng.getCurrentLocation().getSecondaryId());
		assertEquals(null, mng.getCurrentLocation().getSelection());
		assertEquals(myField1, mng.getCurrentLocation().getBinding());

		// add: adds a new location in another view
		mng.addLocation();

		/*
		 * Create extra view
		 */
		final UIBTestView view2 = BaseUIBTestUtils.createUIBTestView(this);
		final ISelection selection2 = new StructuredSelection();
		view2.selectReveal(selection2);
		final IFormCreator form2 = view2.createFormCreator(myShop);
		final IValueBinding field2 = form2.addField("name");
		form2.finish();
		final String secondaryId2 = view2.getViewSite().getSecondaryId();
		assertNotSame(myView.getViewSite().getSecondaryId(), secondaryId2);
		assertEquals(selection2, view2.getCurrentSelection());

		view2.getSite().getWorkbenchWindow().getActivePage().activate(view2);
		assertTrue(field2.getControl().setFocus());
		yield();
		assertEquals(2, mng.getLocationStack().size());
		assertEquals(1, mng.getCurrentLocationIndex());
		assertEquals(true, mng.isBackwardHistoryEnabled());
		assertEquals(false, mng.isForwardHistoryEnabled());
		assertEquals(secondaryId2, mng.getCurrentLocation().getSecondaryId());
		assertEquals(selection2, mng.getCurrentLocation().getSelection());
		assertEquals(field2, mng.getCurrentLocation().getBinding());

		// backward: moved back
		mng.backwardHistory();
		assertEquals(myView, window.getActivePage().getActivePart());
		assertTrue(myField1.getControl().isFocusControl());

		assertEquals(2, mng.getLocationStack().size());
		assertEquals(0, mng.getCurrentLocationIndex());
		assertEquals(false, mng.isBackwardHistoryEnabled());
		assertEquals(true, mng.isForwardHistoryEnabled());
		assertEquals(myView.getViewSite().getSecondaryId(), mng.getCurrentLocation().getSecondaryId());
		assertEquals(null, mng.getCurrentLocation().getSelection());
		assertEquals(myField1, mng.getCurrentLocation().getBinding());

		// close view 2
		view2.getSite().getWorkbenchWindow().getActivePage().hideView(view2);
		assertEquals(BindingState.DISPOSED, field2.getState());

		// forward: move forward - recreate
		mng.forwardHistory();
		// assertTrue(myField3.getControl().isFocusControl());
		final UIBTestView view2b = (UIBTestView) window.getActivePage().getActivePart();
		assertEquals(secondaryId2, view2b.getViewSite().getSecondaryId());
		assertEquals(selection2, view2b.getCurrentSelection());
	}
}
