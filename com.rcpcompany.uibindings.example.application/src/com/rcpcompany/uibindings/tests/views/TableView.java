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
package com.rcpcompany.uibindings.tests.views;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibinding.tests.model.TestContainer;
import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;

public class TableView extends ViewPart {

	private FormToolkit myToolkit;
	private ScrolledForm myForm;
	private TableViewer myTableViewer;
	private final TestContainer myContainer;
	private TableViewerColumn myTextColumn;
	private TableViewerColumn myBooleanColumn;
	private TableViewerColumn myDateColumn;
	private TableViewerColumn myNumberColumn;
	private TableViewerColumn myUnitColumn;
	private TableViewerColumn myACColumn;

	public TableView() {
		myContainer = TestModelFactory.eINSTANCE.getTestContainer();
	}

	@Override
	public void createPartControl(Composite parent) {
		myToolkit = IManager.Factory.getManager().getFormToolkit(parent);

		myForm = myToolkit.createScrolledForm(parent);
		final Composite body = myForm.getBody();
		body.setLayout(new GridLayout());
		myToolkit.paintBordersFor(body);

		myTableViewer = new TableViewer(body, SWT.SINGLE | SWT.FULL_SELECTION);
		final Table table = myTableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		table.setHeaderVisible(true);

		myTextColumn = new TableViewerColumn(myTableViewer, SWT.LEFT);
		myTextColumn.getColumn().setWidth(60);

		myBooleanColumn = new TableViewerColumn(myTableViewer, SWT.LEFT);
		myBooleanColumn.getColumn().setWidth(60);

		myDateColumn = new TableViewerColumn(myTableViewer, SWT.LEFT);
		myDateColumn.getColumn().setWidth(60);

		myNumberColumn = new TableViewerColumn(myTableViewer, SWT.LEFT);
		myNumberColumn.getColumn().setWidth(60);

		myUnitColumn = new TableViewerColumn(myTableViewer, SWT.LEFT);
		myUnitColumn.getColumn().setWidth(60);

		myACColumn = new TableViewerColumn(myTableViewer, SWT.LEFT);
		myACColumn.getColumn().setWidth(60);

		bind();
		initializeToolBar();
	}

	private void bind() {
		final IBindingContext context = IBindingContext.Factory.createContext(myForm);

		final IViewerBinding viewer = context.addViewer(myTableViewer, myContainer,
				TestModelPackage.Literals.TEST_CONTAINER__CHILDREN);
		viewer.addColumn(myTextColumn, TestModelPackage.Literals.TEST_OBJECT__TEXT);
		viewer.addColumn(myBooleanColumn, TestModelPackage.Literals.TEST_OBJECT__B);
		viewer.addColumn(myDateColumn, TestModelPackage.Literals.TEST_OBJECT__DATE);
		viewer.addColumn(myNumberColumn, TestModelPackage.Literals.TEST_OBJECT__NUMBER);
		viewer.addColumn(myUnitColumn, TestModelPackage.Literals.TEST_OBJECT__UNIT);
		viewer.addColumn(myACColumn, TestModelPackage.Literals.TEST_OBJECT__AC);

		context.finish();
	}

	@Override
	public void setFocus() {
	}

	private void initializeToolBar() {
		final IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();
	}
}
