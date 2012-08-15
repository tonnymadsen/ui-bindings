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
package com.rcpcompany.uibindings.extests.viewerBindings;

import static com.rcpcompany.test.utils.BaseTestUtils.*;
import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;

/**
 * Tests the dispose sequence of a viewer and the columns in the viewer.
 * <p>
 * Multiple cases:
 * <ul>
 * <li>The composite of the context is disposed</li>
 * <li>The composite of the viewer is disposed</li>
 * <li>The context is disposed</li>
 * <li>The viewer is disposed</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerDisposeTest {
	private Shop myShop;

	private UIBTestView myView;
	private Composite myBody;
	private Composite myContextTop;
	private Composite myViewerTop;
	private TableViewer myTableViewer;
	private TableViewerColumn myContactNameColumn;
	private TableViewerColumn myCountryNameColumn;
	private TableViewerColumn myCountryAbbrevColumn;
	private TableViewerColumn myContactCityColumn;

	private IBindingContext myContext;
	private IViewerBinding myViewerBinding;
	private Table myTable;

	private IColumnBinding myContactNameBinding;
	private IColumnBinding myCountryAbbrevBinding;
	private IColumnBinding myCountryNameBinding;
	private IColumnBinding myContactCityBinding;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
		bindUI();

		myView.getSite().getPage().activate(myView);
		myBody.layout();
	}

	/**
	 * Creates the shop itself
	 */
	public void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();

		final Country dk = ShopFactory.eINSTANCE.createCountry();
		dk.setName("Denmark");
		dk.setAbbreviation("DK");
		myShop.getCountries().add(dk);

		final Country se = ShopFactory.eINSTANCE.createCountry();
		se.setName("Sweden");
		se.setAbbreviation("SE");
		myShop.getCountries().add(se);

		final Contact a = ShopFactory.eINSTANCE.createContact();
		a.setName("a");
		a.setCity("A");
		a.setCountry(dk);
		myShop.getContacts().add(a);

		final Contact b = ShopFactory.eINSTANCE.createContact();
		b.setName("b");
		b.setCity("A");
		b.setCountry(se);
		myShop.getContacts().add(b);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);
		myBody = myView.getBody();
		myContextTop = new Composite(myBody, SWT.NONE);
		myContextTop.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		myContextTop.setLayout(new FillLayout());
		myViewerTop = new Composite(myContextTop, SWT.NONE);
		myViewerTop.setLayout(new FillLayout());

		myTableViewer = new TableViewer(myViewerTop, SWT.FULL_SELECTION | SWT.BORDER);
		myTable = myTableViewer.getTable();
		myTable.setHeaderVisible(true);

		myContactNameColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myContactNameColumn.getColumn().setWidth(100);

		myCountryAbbrevColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myCountryAbbrevColumn.getColumn().setWidth(100);

		myCountryNameColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myCountryNameColumn.getColumn().setWidth(100);

		myContactCityColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myContactCityColumn.getColumn().setWidth(100);
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
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext = IBindingContext.Factory.createContext(myContextTop);

				myViewerBinding = myContext.addViewer(myTableViewer, myShop, ShopPackage.Literals.SHOP__CONTACTS);
				myContactNameBinding = myViewerBinding.addColumn(myContactNameColumn,
						IMOAOPackage.Literals.NAMED_OBJECT__NAME);
				myCountryAbbrevBinding = myViewerBinding.addColumn(myCountryAbbrevColumn,
						ShopPackage.Literals.CONTACT__COUNTRY);
				myCountryNameBinding = myCountryAbbrevBinding.addColumn(myCountryNameColumn,
						IMOAOPackage.Literals.NAMED_OBJECT__NAME);
				myContactCityBinding = myViewerBinding.addColumn(myContactCityColumn,
						ShopPackage.Literals.CONTACT__CITY);

				myContext.finish();
				yield();
			}
		});
	}

	/**
	 * Dispose the {@link Composite} of the {@link IBindingContext}
	 */
	@Test
	public void testContextCompositeDispose() {
		doTestDispose(new Runnable() {
			@Override
			public void run() {
				myContextTop.dispose();
			}
		});

	}

	/**
	 * Dispose the {@link Composite} of the {@link IViewerBinding}
	 */
	@Test
	public void testViewerCompositeDispose() {
		doTestDispose(new Runnable() {
			@Override
			public void run() {
				myViewerTop.dispose();
			}
		});

	}

	/**
	 * Dispose the {@link IBindingContext}
	 */
	@Test
	public void testContextDispose() {
		doTestDispose(new Runnable() {
			@Override
			public void run() {
				myContext.dispose();
			}
		});

	}

	/**
	 * Dispose the {@link IViewerBinding}
	 */
	@Test
	public void testViewerDispose() {
		doTestDispose(new Runnable() {
			@Override
			public void run() {
				myViewerBinding.dispose();
			}
		});

	}

	private void doTestDispose(final Runnable runnable) {
		final int[] no = new int[] { 0 };

		yield();

		/*
		 * The columns are disposed in various order, depending on where the dispose initiatted.
		 * 
		 * Based on Context dispose: The column bindings are disposed in a reverse order, but child
		 * columns before their base column.
		 * 
		 * Base on Viewer dispose: The column bindings are disposed in order, but child columns
		 * before their base column.
		 */
		monitorObject(myContactNameBinding, IUIBindingsPackage.Literals.BINDING__STATE, no, -1);
		monitorObject(myCountryNameBinding, IUIBindingsPackage.Literals.BINDING__STATE, no, -1);
		monitorObject(myCountryAbbrevBinding, IUIBindingsPackage.Literals.BINDING__STATE, no, -1);
		monitorObject(myContactCityBinding, IUIBindingsPackage.Literals.BINDING__STATE, no, -1);
		monitorObject(myViewerBinding, IUIBindingsPackage.Literals.BINDING__STATE, no, 4);

		assertNoLog(runnable);
		yield();

		assertEquals(5, no[0]);
	}

	private void monitorObject(IBinding binding, final EAttribute stateAttribute, final int[] no, final int expectedNo) {
		((EObject) binding).eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				synchronized (no) {
					if (msg.isTouch()) return;
					if (msg.getFeature() != stateAttribute) return;
					// We ignore the pending dispose for now...
					if (BindingState.DISPOSE_PENDING == ((EObject) msg.getNotifier()).eGet(stateAttribute)) return;
					assertEquals(BindingState.DISPOSED, ((EObject) msg.getNotifier()).eGet(stateAttribute));
					if (expectedNo != -1) {
						assertEquals(expectedNo, no[0]);
					}
					no[0]++;
				}
			}
		});
	}
}
