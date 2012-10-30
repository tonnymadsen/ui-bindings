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
package com.rcpcompany.uibindings.extests.bindings;

import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.ICellEditorFactory;
import com.rcpcompany.uibindings.ICellEditorFactoryContext;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Tests that {@link IBinding#ARG_MESSAGE_FORMAT} works correctly.
 * <p>
 * Depends on:
 * <ul>
 * <li></li>
 * </ul>
 * 
 * @see SimplePreferredCellEditorTest
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class PreferredCellEditorFactoryTest {

	private WritableList myList;
	private TestObject myTestObject;

	private UIBTestView myView;
	private Composite myBody;
	private ITableCreator myCreator;
	private IColumnBinding myColumn;

	@Before
	public void setup() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellAnyKey(true);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
	}

	private void createModel() {
		myTestObject = TestModelFactory.eINSTANCE.createTestObject();
		myList = WritableList.withElementType(myTestObject.eClass());
		myList.add(myTestObject);
	}

	private void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);
		myBody = myView.getBody();

		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myCreator = ITableCreator.Factory.create(myContext, myBody, SWT.NONE, myList);
		myColumn = myCreator.addColumn("unit(w=100)").arg(Constants.ARG_PREFERRED_CELL_EDITOR_FACTORY,
				new TestFactory());

		myContext.finish();
		yield();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void testCellEditor() {
		final Table table = myCreator.getTable();

		postMouse(table, 0 + myCreator.getBinding().getFirstTableColumnOffset(), 0);
		yield();

		assertEquals(0, factoryCreated);
		postKeyStroke(table, "ENTER");
		yield();
		assertEquals(1, factoryCreated);

		assertTrue(myCreator.getBinding().getViewer().isCellEditorActive());

		final Control[] children = myCreator.getTable().getChildren();

		assertNotNull(children);
		assertEquals(1, children.length);

		final Control control = children[0];
		assertTrue(control instanceof CCombo);

		myCreator.getBinding().getViewer().cancelEditing();
	}

	int factoryCreated = 0;
	private IBindingContext myContext;

	public class TestFactory implements ICellEditorFactory {
		@Override
		public CellEditor create(ICellEditorFactoryContext context) {
			assertNotNull(context);
			assertEquals(myColumn.getCellInformation(myTestObject, false), context.getCell());
			assertEquals(myCreator.getTable(), context.getParent());

			factoryCreated++;

			final ComboBoxCellEditor ce = new ComboBoxCellEditor(context.getParent(), new String[0]);

			return ce;
		}
	}
}
