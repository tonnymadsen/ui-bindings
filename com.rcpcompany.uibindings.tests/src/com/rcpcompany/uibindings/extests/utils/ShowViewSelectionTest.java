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
package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.handlers.IHandlerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Tests the correct selection is used in the "show view" command and handler.
 * <p>
 * Depends on:
 * <ul>
 * <li>{@link ShowViewSelectionTestView}</li>
 * <li>openCommand</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ShowViewSelectionTest {
	public final static String TEST_VIEW_ID = ShowViewSelectionTestView.class.getName();

	/**
	 * Command used for test
	 */
	private static final String SHOW_VIEW_COMMAND = "com.rcpcompany.uibindings.commands.showView(viewId="
			+ TEST_VIEW_ID + ")";

	private Shop myShop;
	private Country myCountry1;
	private Country myCountry2;
	private Country myCountry3;
	private Country myCountry4;

	private UIBTestView myView;
	private Composite myBody;

	private TableViewer myTableViewer1;
	private Table myTable1;
	private TableViewerColumn myNameColumn1;

	private TableViewer myTableViewer2;
	private Table myTable2;
	private TableViewerColumn myNameColumn2;

	private IBindingContext myContext;
	private IViewerBinding myViewerBinding;

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

		myCountry1 = ShopFactory.eINSTANCE.createCountry();
		myCountry1.setName("1");
		myShop.getCountries().add(myCountry1);

		myCountry2 = ShopFactory.eINSTANCE.createCountry();
		myCountry2.setName("2");
		myShop.getCountries().add(myCountry2);

		myCountry3 = ShopFactory.eINSTANCE.createCountry();
		myCountry3.setName("3");
		myShop.getCountries().add(myCountry3);

		myCountry4 = ShopFactory.eINSTANCE.createCountry();
		myCountry4.setName("4");
		myShop.getCountries().add(myCountry4);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);
		myBody = myView.getBody();
		myBody.setLayout(new TableWrapLayout());

		myTableViewer1 = new TableViewer(myBody, SWT.FULL_SELECTION | SWT.BORDER);
		myTable1 = myTableViewer1.getTable();
		myTable1.setLayoutData(new TableWrapData(TableWrapData.FILL));
		myTable1.setHeaderVisible(true);

		myNameColumn1 = new TableViewerColumn(myTableViewer1, SWT.NONE);
		myNameColumn1.getColumn().setWidth(100);

		myTableViewer2 = new TableViewer(myBody, SWT.FULL_SELECTION | SWT.BORDER);
		myTable2 = myTableViewer2.getTable();
		myTable2.setLayoutData(new TableWrapData(TableWrapData.FILL));
		myTable2.setHeaderVisible(true);

		myNameColumn2 = new TableViewerColumn(myTableViewer2, SWT.NONE);
		myNameColumn2.getColumn().setWidth(100);
		myNameColumn2.getColumn().setText("N");
		myNameColumn2.setLabelProvider(new CellLabelProvider() {
			@Override
			public void update(ViewerCell cell) {
				final Country c = (Country) cell.getElement();
				cell.setText(c.getName());
			}
		});

		myTableViewer2.setContentProvider(new ArrayContentProvider());
		myTableViewer2.setInput(myShop.getCountries());

		// myTableViewer2.addSelectionChangedListener(new ISelectionChangedListener() {
		// @Override
		// public void selectionChanged(SelectionChangedEvent event) {
		// LogUtils.debug(this, "" + event.getSelection());
		// }
		// });
		// myView.getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(new
		// ISelectionListener() {
		//
		// @Override
		// public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// LogUtils.debug(this, "" + selection);
		// }
		// });
		myView.getSite().setSelectionProvider(myTableViewer2);
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

		myViewerBinding = myContext.addViewer(myTableViewer1, myShop, ShopPackage.Literals.SHOP__COUNTRIES);
		myViewerBinding.addColumn(myNameColumn1, IMOAOPackage.Literals.NAMED_OBJECT__NAME)
				.arg(Constants.ARG_OPEN_COMMAND, SHOW_VIEW_COMMAND)
				.validValues(myShop, ShopPackage.Literals.SHOP__COUNTRIES);

		myContext.finish();
		yield();
	}

	/**
	 * Test the current cell value is used as the current selection
	 */
	@Test
	public void currentCellValueTest() {
		test(myCountry2.getName(), true, myTable1, 1);
	}

	/**
	 * Test the current selection is used as the current selection
	 */
	@Test
	@Ignore
	public void currentSelectionTest() {
		test(myCountry2, false, myTable2, 1);
	}

	public void test(Object c, boolean pm, Table t, int row) {
		ShowViewSelectionTestView.setTheSelection(null);
		if (ShowViewSelectionTestView.getTheView() != null) {
			myView.getSite().getPage().hideView(ShowViewSelectionTestView.getTheView());
		}
		assertNull(ShowViewSelectionTestView.getTheView());
		myView.getSite().getPage().activate(myView);
		// sleep(4000);
		if (pm) {
			postMouse("CTRL+Space", t, 0 + myViewerBinding.getFirstTableColumnOffset(), row, 1);
		} else {
			assertEquals(myTableViewer2, myView.getSite().getSelectionProvider());
			// LogUtils.debug(this, "1");
			postMouse(t, 0 + myViewerBinding.getFirstTableColumnOffset(), row);
			yield();
			// sleep(4000);
			// LogUtils.debug(this, "2");
			final IHandlerService hs = (IHandlerService) myView.getSite().getService(IHandlerService.class);
			final ICommandService cs = (ICommandService) myView.getSite().getService(ICommandService.class);

			try {
				final ParameterizedCommand command = cs.deserialize(SHOW_VIEW_COMMAND);
				hs.executeCommand(command, null);
			} catch (final Exception ex) {
				LogUtils.error(this, ex);
				fail(ex.getMessage());
			}
		}
		assertNotNull(ShowViewSelectionTestView.getTheView());
		final ISelection theSelection = ShowViewSelectionTestView.getTheSelection();
		assertNotNull(theSelection);
		assertTrue(theSelection instanceof IStructuredSelection);
		final IStructuredSelection ss = (IStructuredSelection) theSelection;
		assertTrue(!ss.isEmpty());
		assertEquals(c, ss.getFirstElement());
	}
}
