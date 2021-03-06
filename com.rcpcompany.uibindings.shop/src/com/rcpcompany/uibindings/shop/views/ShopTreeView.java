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
package com.rcpcompany.uibindings.shop.views;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.SpecialBinding;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IDnDSupport;

public class ShopTreeView extends ViewPart {

	private Tree myTree;
	private TreeColumn myTreeColumn;
	private TreeColumn myNameColumn;

	private IBindingContext myContext;
	private IViewerBinding myTreeBinding;
	private IColumnBinding myTreeColumnBinding;
	private IColumnBinding myNameColumnBinding;

	@Override
	public void createPartControl(Composite parent) {
		myContext = IBindingContext.Factory.createContext(parent);

		myTree = new Tree(parent, SWT.SINGLE | SWT.FULL_SELECTION);
		myTree.setHeaderVisible(true);
		myTreeColumn = new TreeColumn(myTree, SWT.LEAD);
		myTreeColumn.setWidth(300);

		myNameColumn = new TreeColumn(myTree, SWT.LEAD);
		myNameColumn.setText("Detail");
		myNameColumn.setWidth(100);

		final IObservableList list = WritableList.withElementType(ShopPackage.Literals.SHOP);
		list.add(ShopFactory.eINSTANCE.getShop(EditingDomainUtils.getEditingDomain()));
		myTreeBinding = myContext.addViewer().viewer(myTree).model(list);
		myTreeColumnBinding = myTreeBinding.addColumn().column(myTreeColumn).model(SpecialBinding.TREE_ITEM);

		final IObservableFactory factory = new IObservableFactory() {
			@Override
			public IObservable createObservable(Object target) {
				if (target instanceof Shop) {
					final Shop shop = (Shop) target;
					return UIBindingsEMFObservables.observeValue(shop, IMOAOPackage.Literals.NAMED_OBJECT__NAME);
				}
				if (target instanceof Contact) {
					final Contact c = (Contact) target;
					return UIBindingsEMFObservables.observeValue(c, ShopPackage.Literals.CONTACT__COUNTRY);
				}
				return Observables.constantObservableValue("", EcorePackage.Literals.ESTRING);
			}
		};
		myNameColumnBinding = myTreeBinding.addColumn().column(myNameColumn).dynamic()
				.model(factory, EcorePackage.Literals.EJAVA_OBJECT);

		myContext.finish();

		IBindingContextSelectionProvider.Factory.adapt(myContext, getSite());
		IDnDSupport.Factory.installOn(myContext);
	}

	@Override
	public void setFocus() {
		myTree.setFocus();
	}
}
