/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.shop.views;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.ISortableTableAdapter;
import com.rcpcompany.uibindings.utils.IViewerToolBar;

/**
 * A view that shows the basic shop information such as the name and all defined countries.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ShopBasicsView extends ViewPart {

	private Table myTable;
	private Text myShopName;
	private final FormToolkit myToolkit = IManager.Factory.getManager().getFormToolkit();
	private ScrolledForm myTop;
	private TableColumn myCountryName;
	private TableColumn myCountryAbbrev;
	private Button mySaveButton;
	public TableViewer myTableViewer;
	public IColumnBinding myNameColumn;

	@Override
	public void createPartControl(Composite parent) {
		myTop = myToolkit.createScrolledForm(parent);
		myTop.setText("Basic Shop Information");
		final Composite body = myTop.getBody();
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		body.setLayout(gridLayout);
		myToolkit.paintBordersFor(body);

		myToolkit.createLabel(body, "Shop Name", SWT.NONE);

		myShopName = myToolkit.createText(body, null, SWT.NONE);
		final GridData gd_shopName = new GridData(SWT.FILL, SWT.CENTER, true, false);
		myShopName.setLayoutData(gd_shopName);

		final Section countriesSection = myToolkit.createSection(body, SWT.NONE);
		final GridData gd_countriesSection = new GridData(SWT.FILL, SWT.TOP, true, true, 2, 1);
		countriesSection.setLayoutData(gd_countriesSection);
		countriesSection.setText("Countries");

		final Composite countriesComposite = myToolkit.createComposite(countriesSection, SWT.NONE);
		countriesComposite.setLayout(new GridLayout());
		myToolkit.paintBordersFor(countriesComposite);
		countriesSection.setClient(countriesComposite);

		myTable = myToolkit.createTable(countriesComposite, SWT.FULL_SELECTION);
		myTableViewer = new TableViewer(myTable);
		myTable.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));
		myTable.setLinesVisible(true);
		myTable.setHeaderVisible(true);

		myCountryName = new TableColumn(myTable, SWT.NONE);
		myCountryName.setWidth(100);

		myCountryAbbrev = new TableColumn(myTable, SWT.NONE);
		myCountryAbbrev.setWidth(40);

		mySaveButton = myToolkit.createButton(body, "Save", SWT.NONE);
		mySaveButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 2, 1));

		bindUI();
	}

	private void bindUI() {
		final Shop shop = ShopFactory.eINSTANCE.getShop(EditingDomainUtils.getEditingDomain());
		final IBindingContext context = IBindingContext.Factory.createContext(myTop);

		context.addBinding(myShopName, shop, IMOAOPackage.Literals.NAMED_OBJECT__NAME);

		final IViewerBinding viewer = context.addViewer().viewer(myTableViewer)
				.model(shop, ShopPackage.Literals.SHOP__COUNTRIES);
		myNameColumn = viewer.addColumn(myCountryName, IMOAOPackage.Literals.NAMED_OBJECT__NAME);
		viewer.addColumn(myCountryAbbrev, ShopPackage.Literals.COUNTRY__ABBREVIATION);

		context.finish();

		ISortableTableAdapter.Factory.adapt(viewer);
		IBindingContextSelectionProvider.Factory.adapt(context, getSite());
		IViewerToolBar.Factory.addToolBar(viewer, IViewerToolBar.HORIZONTAL | IViewerToolBar.STANDARD_ITEMS);

		mySaveButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shop.save();
			}
		});
	}

	@Override
	public void setFocus() {
		myShopName.setFocus();
	}
}
