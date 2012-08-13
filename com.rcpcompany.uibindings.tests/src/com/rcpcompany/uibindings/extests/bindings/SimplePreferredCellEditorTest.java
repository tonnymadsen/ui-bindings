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

import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.widgets.FileNameControl;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Tests that the correct simple cell editor widget is used for the simple data types.
 * <p>
 * Depends on:
 * <ul>
 * <li></li>
 * </ul>
 * 
 * @see PreferredCellEditorFactoryTest
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class SimplePreferredCellEditorTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

		{ TestModelPackage.Literals.TEST_OBJECT__TEXT, null, Text.class },
				{ TestModelPackage.Literals.TEST_OBJECT__B, null, null },
				{ TestModelPackage.Literals.TEST_OBJECT__UNIT, null, CCombo.class },

				/*
				 * Test that preferredCellEditor takes precedence over preferredControl
				 */
				{ TestModelPackage.Literals.TEST_OBJECT__UNIT, "simple", Text.class },

				{ TestModelPackage.Literals.TEST_OBJECT__NUMBER, null, Text.class },
				{ TestModelPackage.Literals.TEST_OBJECT__F, null, Text.class },
				{ TestModelPackage.Literals.TEST_OBJECT__BIG_DECIMAL, null, StyledText.class },

				{ TestModelPackage.Literals.TEST_OBJECT__TEXT, Constants.TYPE_FILE_NAME, FileNameControl.class },
				{ TestModelPackage.Literals.TEST_OBJECT__TEXT, Constants.TYPE_DIRECTORY_NAME, FileNameControl.class },

		});
	}

	private WritableList myList;
	private TestObject myTestObject;

	private UIBTestView myView;
	private Composite myBody;
	private TableViewer myViewer;
	private TableViewerColumn myColumn;

	private IBindingContext myContext;
	private IViewerBinding myViewerBinding;
	private final EStructuralFeature myFeature;
	private final String myType;
	private final Class<? extends Control> myExpectedCellEditor;
	private final String what;

	public SimplePreferredCellEditorTest(EStructuralFeature feature, String type,
			Class<? extends Control> expectedCellEditor) {
		myFeature = feature;
		myType = type;
		myExpectedCellEditor = expectedCellEditor;

		what = myFeature.getName() + "(" + myType + "): "
				+ (myExpectedCellEditor == null ? "<null>" : myExpectedCellEditor.getSimpleName());
		LogUtils.debug(this, what);
	}

	@Before
	public void setup() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellAnyKey(false);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
		bindUI();
	}

	private void createModel() {
		myTestObject = TestModelFactory.eINSTANCE.createTestObject();
		myList = WritableList.withElementType(myTestObject.eClass());
		myList.add(myTestObject);
	}

	private void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);
		myBody = myView.getBody();

		myViewer = new TableViewer(myBody, SWT.FULL_SELECTION);
		myViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		myColumn = new TableViewerColumn(myViewer, SWT.NONE);
		myColumn.getColumn().setWidth(100);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	private void bindUI() {
		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());

		myViewerBinding = myContext.addViewer(myViewer, myList);
		myViewerBinding.addColumn(myColumn, myFeature).type(myType);

		myContext.finish();
		yield();
	}

	@Test
	public void testCellEditor() {
		final Table table = myViewer.getTable();

		sleep(table.getDisplay().getDoubleClickTime() + 200);
		postMouse(table, 0 + myViewerBinding.getFirstTableColumnOffset(), 0);
		yield();

		postKeyStroke(table, "ENTER");
		yield();

		if (myExpectedCellEditor == null) {
			assertTrue(what, !myViewer.isCellEditorActive());
		} else {
			assertTrue(what, myViewer.isCellEditorActive());

			final EList<IBinding> bindings = myContext.getBindings();
			final IBinding binding = bindings.get(bindings.size() - 1);

			final Control control = binding.getControl();
			assertTrue(what + ": Expected " + myExpectedCellEditor.getName() + ", got " + control.getClass().getName(),
					myExpectedCellEditor.isInstance(control));
		}
		myViewer.cancelEditing();
	}
}
