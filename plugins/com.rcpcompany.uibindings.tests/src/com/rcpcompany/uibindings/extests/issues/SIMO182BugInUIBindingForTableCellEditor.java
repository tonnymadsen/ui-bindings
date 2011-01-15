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
package com.rcpcompany.uibindings.extests.issues;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IColumnBindingCellInformation;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

/**
 * This test tests http://jira.marintek.sintef.no/jira/browse/SIMA-182 according to the recipe:
 * <ul>
 * <li>open Catenary model</li>
 * <li>go to line types in the navigator</li>
 * <li>double click old line type, and get line type editor for that type</li>
 * <li>create new line type</li>
 * <li>in line type editor</li>
 * <li>go to name field</li>
 * <li>press return to edit</li>
 * </ul>
 * <p>
 * The code below mimics the catenary editor very closely.
 * <p>
 * <strong>NOTE</strong>: Do not <em>click on anything</em> while this test is running - otherwise
 * it will fail
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SIMO182BugInUIBindingForTableCellEditor {
	private TestView myView;
	private Composite myBody;
	private TableViewer myViewer;
	private TableViewerColumn myNameColumn;

	private Shop myShop;

	private IBindingContext myContext;
	private IObservableList myCurrentCountry;
	private IViewerBinding myViewerBinding;
	private IColumnBinding myNameBinding;
	private EList<Country> myCountries;
	private Table myTable;

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(false);
		myShop = ShopFactory.eINSTANCE.getShop(EditingDomainUtils.getEditingDomain());
		myCountries = myShop.getCountries();

		createView();
		bindUI();
	}

	public void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();

		myViewer = new TableViewer(myBody, SWT.FULL_SELECTION);
		myTable = myViewer.getTable();
		myTable.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		myTable.setHeaderVisible(true);

		myNameColumn = new TableViewerColumn(myViewer, SWT.NONE);
		myNameColumn.getColumn().setWidth(200);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	public void bindUI() {
		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myCurrentCountry = WritableList.withElementType(ShopPackage.Literals.COUNTRY);
		myViewerBinding = myContext.addViewer(myViewer, myCurrentCountry);
		myNameBinding = myViewerBinding.addColumn(myNameColumn, IMOAOPackage.Literals.NAMED_OBJECT__NAME);

		myContext.finish();
		yield();
	}

	@After
	public void after() {
		IManager.Factory.getManager().setEditCellSingleClick(true);
	}

	@Test
	public void testIssue() {
		final IObservableList list = myViewerBinding.getList();
		assertNotNull(list);
		final EList<IBinding> bindings = myContext.getBindings();
		assertNotNull(bindings);
		final ColumnViewerEditor columnViewerEditor = myViewer.getColumnViewerEditor();
		assertNotNull(columnViewerEditor);

		assertEquals(0, list.size());
		assertEquals(2, bindings.size());

		sleep(200);

		/*
		 * - open Catenary model
		 * 
		 * - go to line types in the navigator
		 * 
		 * - double click old line type, and get line type editor for that type
		 */
		myView.getSite().getPage().activate(myView);
		myTable.setFocus();
		assertTrue(myTable.isFocusControl());

		myCurrentCountry.add(myShop.getCountries().get(0));
		assertEquals(1, list.size());
		assertEquals(3, bindings.size());
		myBody.layout();
		yield();
		myViewer.setSelection(new StructuredSelection(myShop.getCountries().get(0)));
		yield();
		assertEquals(0, myTable.getSelectionIndex());

		// Click on the item to get the focus cell
		postMouse(myTable, 0 + myViewerBinding.getFirstTableColumnOffset(), 0);
		yield();
		assertTrue(myTable.isFocusControl());
		assertNotNull(columnViewerEditor.getFocusCell());

		/*
		 * - create new line type
		 */
		final Country country = ShopFactory.eINSTANCE.createCountry();
		country.setName("xxx");
		myShop.getCountries().add(country);
		assertEquals(country, myCountries.get(myCountries.size() - 1));
		yield();
		// set the country of the viewer
		myCurrentCountry.set(0, country);
		yield();
		assertEquals(1, list.size());
		assertNotNull(columnViewerEditor.getFocusCell());

		/*
		 * - in line type editor
		 * 
		 * - go to name field
		 */
		assertTrue(myTable.isFocusControl());
		assertEquals(0, myTable.getSelectionIndex());
		assertNotNull(columnViewerEditor.getFocusCell());

		final IColumnBindingCellInformation ci = myNameBinding.getCellInformation(country);
		assertNotNull(ci);
		// Check the text is correct in non-edit mode
		assertEquals(country.getName(), ci.getDisplayText());
		assertTrue(ci.isChangeable());
		// TODO: does not work any more!
		assertEquals(country.getName(), myViewerBinding.getCell(0, 0, true).getDisplayText());

		/*
		 * - press return to edit
		 */
		assertTrue(myTable.isFocusControl());
		assertEquals(0, myTable.getSelectionIndex());
		assertNotNull(columnViewerEditor.getFocusCell());
		postKeyStroke(myTable, "ENTER");
		yield();
		assertNotNull(columnViewerEditor.getFocusCell());
		assertEquals(true, myViewer.isCellEditorActive());

		final IValueBinding editBinding = (IValueBinding) bindings.get(bindings.size() - 1);

		final Text t = (Text) editBinding.getControl();
		assertNotNull("edit controll null", t);

		assertEquals(country.getName(), t.getText());// !!!!

		postKeyStroke(myTable, "ESCAPE");
		sleep(100);
		assertEquals(false, myViewer.isCellEditorActive());
	}
}
