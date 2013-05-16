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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.handlers.IHandlerService;
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

/**
 * Tests the different moveItem commands.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class ViewerItemMoveTest {
	private Shop myShop;
	private Country myCountry1;
	private Country myCountry2;
	private Country myCountry3;
	private Country myCountry4;

	private UIBTestView myView;
	private Composite myBody;

	private TableViewer myTableViewer;
	private Table myTable;
	private TableViewerColumn myNameColumn;
	private TableViewerColumn myAbbrevColumn;

	private IBindingContext myContext;
	private IViewerBinding myViewerBinding;

	final int myRow;
	final int myNewRow;
	final int myColumn;
	final String myCommandId;
	final String mySeq;
	private final String what;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

				// int column, int row, String id, String seq

				// { 0, 1, "com.rcpcompany.uibindings.commands.moveItemUp", "2134" },
				{ 1, 1, "com.rcpcompany.uibindings.commands.moveItemUp", "2134" },
				{ 0, 1, "com.rcpcompany.uibindings.commands.moveItemDown", "1324" },
				{ 0, 1, "com.rcpcompany.uibindings.commands.moveItemToTop", "2134" },
		// { 0, 3, "com.rcpcompany.uibindings.commands.moveItemToTop", "4123" },
		// { 0, 1, "com.rcpcompany.uibindings.commands.moveItemToBottom", "1342" },

				});
	}

	public ViewerItemMoveTest(int column, int row, String id, String seq) {
		myRow = row;
		myColumn = column;
		myCommandId = id;
		mySeq = seq;
		myNewRow = seq.indexOf('0' + row + 1);

		what = id + "[" + column + ";" + row + "] seq=" + seq + ":";

		// LogUtils.debug(this, what + " start");
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

	@After
	public void after() {
		IManager.Factory.getManager().setEditCellSingleClick(true);
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myCountry1 = ShopFactory.eINSTANCE.createCountry();
		myCountry1.setName("1");
		myCountry1.setAbbreviation("1");
		myShop.getCountries().add(myCountry1);

		myCountry2 = ShopFactory.eINSTANCE.createCountry();
		myCountry2.setName("2");
		myCountry2.setAbbreviation("2");
		myShop.getCountries().add(myCountry2);

		myCountry3 = ShopFactory.eINSTANCE.createCountry();
		myCountry3.setName("3");
		myCountry3.setAbbreviation("3");
		myShop.getCountries().add(myCountry3);

		myCountry4 = ShopFactory.eINSTANCE.createCountry();
		myCountry4.setName("4");
		myCountry4.setAbbreviation("4");
		myShop.getCountries().add(myCountry4);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);
		myBody = myView.getBody();
		myBody.setLayout(new TableWrapLayout());

		myTableViewer = new TableViewer(myBody, SWT.FULL_SELECTION | SWT.BORDER);
		myTable = myTableViewer.getTable();
		myTable.setLayoutData(new TableWrapData(TableWrapData.FILL));
		myTable.setHeaderVisible(true);

		myNameColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myNameColumn.getColumn().setWidth(100);

		myAbbrevColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myAbbrevColumn.getColumn().setWidth(100);
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
		myViewerBinding.addColumn(myAbbrevColumn, ShopPackage.Literals.COUNTRY__ABBREVIATION);

		myContext.finish();
		yield();
	}

	/**
	 * Checks the operation of the move command with focus on the resulting selection and focus
	 */
	@Test
	public void testOp() {
		try {
			final ICommandService cs = (ICommandService) myView.getSite().getService(ICommandService.class);
			final IHandlerService hs = (IHandlerService) myView.getSite().getService(IHandlerService.class);

			final ParameterizedCommand command = cs.deserialize(myCommandId);
			assertTrue(what + " is defined", command.getCommand().isDefined());

			final Country country = myShop.getCountries().get(myRow);
			// LogUtils.debug(country, "" + country.getName());

			postMouse(myTableViewer.getTable(), myColumn + myViewerBinding.getFirstTableColumnOffset(), myRow);
			yield();

			assertTrue(what + " is not handled", command.getCommand().isHandled());
			assertTrue(what + " is not defined", command.getCommand().isDefined());

			ViewerCell viewerCell = myTableViewer.getColumnViewerEditor().getFocusCell();
			assertEquals(what + " index wrong", myColumn + myViewerBinding.getFirstTableColumnOffset(),
					viewerCell.getColumnIndex());
			assertEquals(what + " element wrong", country, viewerCell.getElement());
			assertEquals(what + " item wrong", myTableViewer.getTable().getItem(myRow), viewerCell.getViewerRow()
					.getItem());
			assertEquals(what + " row element", country, viewerCell.getViewerRow().getElement());

			assertEquals(4, myShop.getCountries().size());
			hs.executeCommand(command, null);
			assertEquals(4, myShop.getCountries().size());

			// Seq of items
			final List<Country> myResultList = new ArrayList<Country>();
			for (int i = 0; i < mySeq.length(); i++) {
				final String s = mySeq.substring(i, i + 1);
				for (final Country c : myShop.getCountries()) {
					if (c.getName().equals(s)) {
						myResultList.add(c);
						break;
					}
				}
			}
			assertArrayEquals(myResultList.toArray(), myShop.getCountries().toArray());

			// Selection
			final TableItem[] tableItems = myTable.getSelection();
			assertEquals(1, tableItems.length);
			assertEquals(country, tableItems[0].getData());

			// ISelection
			final ISelection selection = myTableViewer.getSelection();
			assertTrue(selection instanceof IStructuredSelection);
			final IStructuredSelection ss = (IStructuredSelection) selection;
			assertEquals(1, ss.toArray().length);
			assertEquals(country, ss.getFirstElement());

			// Viewer cell

			// Focus cell
			viewerCell = myTableViewer.getColumnViewerEditor().getFocusCell();
			assertEquals(myColumn + myViewerBinding.getFirstTableColumnOffset(), viewerCell.getColumnIndex());
			assertEquals(country, viewerCell.getElement());
			assertEquals(myTableViewer.getTable().getItem(myNewRow), viewerCell.getViewerRow().getItem());
			assertEquals(country, viewerCell.getViewerRow().getElement());
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
	}
}
