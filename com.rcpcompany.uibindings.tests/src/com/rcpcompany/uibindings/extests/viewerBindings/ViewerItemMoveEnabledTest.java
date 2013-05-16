/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.extests.viewerBindings;

import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.commands.ICommandService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

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
import com.rcpcompany.uibindings.utils.IFilteringTableAdapter;

/**
 * Tests the enablement of the item movement commands and handlers.
 * <p>
 * Depends on:
 * <ul>
 * <li></li>
 * <li></li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class ViewerItemMoveEnabledTest {
	private Shop myShop;
	private Country myCountry1;
	private Country myCountry2;
	private Country myCountry3;
	private Country myCountry4;

	private UIBTestView myView;
	private Composite myBody;

	private Text myFilter;
	private TableViewer myTableViewer;
	private Table myTable;
	private TableViewerColumn myNameColumn;

	private IBindingContext myContext;
	private IViewerBinding myViewerBinding;

	final int myRow;
	final boolean myUpEnabled;
	final boolean myDownEnabled;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 0, false, true }, { 1, true, true }, { 3, true, false }, });
	}

	public ViewerItemMoveEnabledTest(int row, boolean up, boolean down) {
		myRow = row;
		myUpEnabled = up;
		myDownEnabled = down;
	}

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

		myFilter = IFilteringTableAdapter.Factory.createFilter(myBody);

		myTableViewer = new TableViewer(myBody, SWT.FULL_SELECTION | SWT.BORDER);
		myTable = myTableViewer.getTable();
		myTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		myTable.setHeaderVisible(true);

		myNameColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myNameColumn.getColumn().setWidth(100);
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

		myViewerBinding = myContext.addViewer(myTableViewer, myShop, ShopPackage.Literals.SHOP__COUNTRIES);
		myViewerBinding.addColumn(myNameColumn, IMOAOPackage.Literals.NAMED_OBJECT__NAME);

		myContext.finish();
		yield();

		IFilteringTableAdapter.Factory.adapt(myViewerBinding, myFilter);
	}

	/**
	 * Checks that the shop item table does have an enabled move operation
	 */
	@Test
	public void testEnablement() {
		try {
			final ICommandService cs = (ICommandService) myView.getSite().getService(ICommandService.class);

			final ParameterizedCommand moveItemUpCommand = cs
					.deserialize("com.rcpcompany.uibindings.commands.moveItemUp");
			assertTrue(moveItemUpCommand.getCommand().isDefined());
			final ParameterizedCommand moveItemDownCommand = cs
					.deserialize("com.rcpcompany.uibindings.commands.moveItemDown");
			assertTrue(moveItemDownCommand.getCommand().isDefined());
			final ParameterizedCommand moveItemTopCommand = cs
					.deserialize("com.rcpcompany.uibindings.commands.moveItemToTop");
			assertTrue(moveItemTopCommand.getCommand().isDefined());
			final ParameterizedCommand moveItemBottomCommand = cs
					.deserialize("com.rcpcompany.uibindings.commands.moveItemToBottom");
			assertTrue(moveItemBottomCommand.getCommand().isDefined());

			// myTableViewer1.getTable().setFocus();
			postMouse(myTableViewer.getTable(), 0 + myViewerBinding.getFirstTableColumnOffset(), myRow);
			yield();

			assertEquals("row " + myRow, true, moveItemUpCommand.getCommand().isHandled());
			assertEquals("row " + myRow, true, moveItemDownCommand.getCommand().isHandled());
			assertEquals("row " + myRow, true, moveItemTopCommand.getCommand().isHandled());
			assertEquals("row " + myRow, true, moveItemBottomCommand.getCommand().isHandled());

			assertEquals("row " + myRow, myUpEnabled, moveItemUpCommand.getCommand().isEnabled());
			assertEquals("row " + myRow, myDownEnabled, moveItemDownCommand.getCommand().isEnabled());
			assertEquals("row " + myRow, myUpEnabled, moveItemTopCommand.getCommand().isEnabled());
			assertEquals("row " + myRow, myDownEnabled, moveItemBottomCommand.getCommand().isEnabled());

			myFilter.setText("2");
			sleep(500);
			postMouse(myTableViewer.getTable(), 0 + myViewerBinding.getFirstTableColumnOffset(), 0);
			yield();

			assertEquals("row " + myRow, false, moveItemUpCommand.getCommand().isHandled());
			assertEquals("row " + myRow, false, moveItemDownCommand.getCommand().isHandled());
			assertEquals("row " + myRow, false, moveItemTopCommand.getCommand().isHandled());
			assertEquals("row " + myRow, false, moveItemBottomCommand.getCommand().isHandled());

			myFilter.setText("");
			sleep(500);
			postMouse(myTableViewer.getTable(), 0 + myViewerBinding.getFirstTableColumnOffset(), myRow);
			yield();

			assertEquals("row " + myRow, true, moveItemUpCommand.getCommand().isHandled());
			assertEquals("row " + myRow, true, moveItemDownCommand.getCommand().isHandled());
			assertEquals("row " + myRow, true, moveItemTopCommand.getCommand().isHandled());
			assertEquals("row " + myRow, true, moveItemBottomCommand.getCommand().isHandled());

			assertEquals("row " + myRow, myUpEnabled, moveItemUpCommand.getCommand().isEnabled());
			assertEquals("row " + myRow, myDownEnabled, moveItemDownCommand.getCommand().isEnabled());
			assertEquals("row " + myRow, myUpEnabled, moveItemTopCommand.getCommand().isEnabled());
			assertEquals("row " + myRow, myDownEnabled, moveItemBottomCommand.getCommand().isEnabled());
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
	}
}
