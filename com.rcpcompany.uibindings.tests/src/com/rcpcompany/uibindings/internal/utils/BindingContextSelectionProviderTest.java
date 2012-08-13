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

import static org.junit.Assert.*;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPartSite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Tests of {@link com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingContextSelectionProviderTest {
	private Shop myShop;

	private UIBTestView myView;
	private IFormCreator myForm;

	private IValueBinding myNameBinding;

	private IViewerBinding myTableBinding;

	@Before
	public void before() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("abc");

		final Country country = ShopFactory.eINSTANCE.createCountry();
		country.setName("Denmark");
		country.setAbbreviation("DK");
		country.setShop(myShop);

		myView = BaseUIBTestUtils.createUIBTestView(this);

		myForm = myView.createFormCreator(myShop);

		myNameBinding = myForm.addField("name");

		final ITableCreator table = myForm.addTableCreator(ShopPackage.Literals.SHOP__COUNTRIES, false, SWT.NONE);
		table.addColumn("name");
		myTableBinding = table.getBinding();

		myForm.finish();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Tests that the factory provides a singeton.
	 */
	@Test
	public void testSingleton() {
		final IBindingContextSelectionProvider provider = IBindingContextSelectionProvider.Factory.adapt(
				myForm.getContext(), myView.getSite());

		assertNotNull(provider);

		final IBindingContextSelectionProvider p2 = IBindingContextSelectionProvider.Factory.adapt(myForm.getContext(),
				myView.getSite());
		assertEquals(provider, p2);
	}

	/**
	 * Tests that a new {@link org.eclipse.jface.viewers.ISelectionProvider} is installed.
	 */
	@Test
	public void testIsSelectionProvider() {
		final IWorkbenchPartSite site = myView.getSite();
		assertEquals(null, site.getSelectionProvider());

		final IBindingContextSelectionProvider provider = IBindingContextSelectionProvider.Factory.adapt(
				myForm.getContext(), site);

		assertEquals(provider, site.getSelectionProvider());
	}

	/**
	 * Tests that a menu is added and deleted as a control is added or deleted.
	 */
	@Test
	public void testAddRemove() {
		final IBindingContextSelectionProvider provider = IBindingContextSelectionProvider.Factory.adapt(
				myForm.getContext(), myView.getSite());

		final Text text = new Text(myForm.addComposite(), SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text.setText("");

		final IObservableValue ov = WritableValue.withValueType(EcorePackage.Literals.EOBJECT);

		assertEquals(null, text.getMenu());

		provider.addControl(text, ov);
		assertNotSame(null, text.getMenu());

		provider.removeControl(text);
		assertEquals(null, text.getMenu());
	}

	/**
	 * Tests that the same menu is installed everywhere and the menu manager is properly registered
	 * in the site.
	 */
	@Test
	public void testMenu() {
		final IWorkbenchPartSite site = myView.getSite();
		final BindingContextSelectionProvider provider = (BindingContextSelectionProvider) IBindingContextSelectionProvider.Factory
				.adapt(myForm.getContext(), site);

		final MenuManager mm = provider.myMenuManager;
		assertNotNull(mm);

		final Menu menu = mm.getMenu();
		assertNotNull(menu);

		assertEquals(menu, myNameBinding.getControl().getMenu());
		assertEquals(menu, myTableBinding.getControl().getMenu());
	}
}
