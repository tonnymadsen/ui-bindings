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
package com.rcpcompany.uibindings.scripting.internal.views;

import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.moao.IMOAO;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.observables.FilteredObservableList;
import com.rcpcompany.uibindings.scripting.IScriptingPackage;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;
import com.rcpcompany.uibindings.utils.SelectionUtils;

/**
 * Simple view that will show the current feature scripts of the current object.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FeatureScriptsView extends ViewPart {

	private IFormCreator myForm;
	private final IObservableValue myObject = WritableValue.withValueType(IMOAOPackage.Literals.MOAO);

	private final ISelectionListener mySelectionListener = new ISelectionListener() {
		@Override
		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			final List<IMOAO> moaos = SelectionUtils.computeSelection(selection, IMOAO.class);

			if (moaos.size() != 1) {
				return;
			}

			myObject.setValue(moaos.get(0));
		}
	};

	@Override
	public void createPartControl(Composite parent) {
		myForm = IFormCreator.Factory.createScrolledForm(myObject, parent, "Scripts");
		myForm.getContext().addBinding().ui(myForm.getScrolledForm()).model(myObject)
				.arg(Constants.ARG_MESSAGE_FORMAT, "Scripts in {0}").type(Constants.TYPE_QUALIFIED_NAME);

		final IObservableList facets = UIBindingsEMFObservables.observeDetailList(myObject,
				IMOAOPackage.Literals.MOAO__FACETS);
		final FilteredObservableList featureScripts = new FilteredObservableList(facets,
				IScriptingPackage.Literals.FEATURE_SCRIPT);

		final ITableCreator table = ITableCreator.Factory.create(myForm.getContext(), myForm.addComposite(true, true),
				SWT.NONE, featureScripts);
		table.addColumn("feature(w=10em, readonly)");
		table.addColumn("language(w=10em, readonly)");
		table.addColumn("expression.currentValue(w=10em, readonly,label='Value')");
		table.addColumn("script(w=30em, readonly)");

		myForm.finish();

		final ISelectionService ss = getSite().getWorkbenchWindow().getSelectionService();
		ss.addSelectionListener(mySelectionListener);
		mySelectionListener.selectionChanged(this, ss.getSelection());
	}

	@Override
	public void dispose() {
		final ISelectionService ss = getSite().getWorkbenchWindow().getSelectionService();
		ss.removeSelectionListener(mySelectionListener);
		super.dispose();
	}

	@Override
	public void setFocus() {
		myForm.setFocus();
	}
}
