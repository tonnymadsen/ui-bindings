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
package com.rcpcompany.uibindings.tests.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.part.ViewPart;

public class EmptyView extends ViewPart {

	private Composite myTop;
	private Table myTable;
	private Tree myTree;
	private ToolBar myToolBar;
	private Composite myWidgets;
	private TabFolder myTabFolder;

	public Composite getTop() {
		return myWidgets;
	}

	public Table getTable() {
		return myTable;
	}

	public Tree getTree() {
		return myTree;
	}

	@Override
	public void createPartControl(Composite parent) {
		myTop = new Composite(parent, SWT.NONE);
		myTop.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		myTop.setLayout(new GridLayout(1, false));

		myWidgets = new Composite(myTop, SWT.NONE);
		myWidgets.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		myWidgets.setLayout(new GridLayout(1, false));

		myTable = new Table(parent, SWT.SINGLE | SWT.FULL_SELECTION);
		myTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		myTable.setLinesVisible(true);
		myTable.setHeaderVisible(true);

		new TableColumn(myTable, SWT.NONE);

		myTree = new Tree(myTable, SWT.SINGLE | SWT.FULL_SELECTION);
		myTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		myTree.setLinesVisible(true);
		myTree.setHeaderVisible(true);

		new TreeColumn(myTree, SWT.NONE);

		myToolBar = new ToolBar(parent, SWT.NULL);
		myToolBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		myTabFolder = new TabFolder(parent, SWT.NULL);
		myTabFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	}

	@Override
	public void setFocus() {
	}

	public ToolBar getToolBar() {
		return myToolBar;
	}

	public TabFolder getTabFolder() {
		return myTabFolder;
	}
}
