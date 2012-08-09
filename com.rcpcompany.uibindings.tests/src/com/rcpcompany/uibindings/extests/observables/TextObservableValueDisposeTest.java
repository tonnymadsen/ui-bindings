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
package com.rcpcompany.uibindings.extests.observables;

import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;

/**
 * Tests whether listeners used by the {@link TextObservableValue} are properly disposed after use.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class TextObservableValueDisposeTest {
	private Shop myShop;

	private UIBTestView myView;
	private Composite myBody;
	private TableViewer myTableViewer;
	private TableViewerColumn myNameColumn;

	private IBindingContext myContext;
	private IViewerBinding myViewerBinding;
	private Table myTable;

	private Text myText;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createShop();
		createView();
		bindUI();

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
		myView = UIBindingsTestUtils.createUIBTestView(this);
		myBody = myView.getBody();
		myBody.setLayout(new TableWrapLayout());

		myText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
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

		myContext.finish();
		yield();
	}

	@Test
	public void test() {
		final int initialSize = myContext.eAdapters().size();

		final IValueBinding b = myContext.addBinding(myText, myShop, IMOAOPackage.Literals.NAMED_OBJECT__NAME);
		myContext.finish();
		yield();

		assertTrue(initialSize < myContext.eAdapters().size());

		b.dispose();
		assertEquals(initialSize, myContext.eAdapters().size());
	}
}
