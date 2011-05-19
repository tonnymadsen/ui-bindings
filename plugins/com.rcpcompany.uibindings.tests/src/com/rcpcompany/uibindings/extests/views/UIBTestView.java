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
package com.rcpcompany.uibindings.extests.views;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.IGlobalNavigationManager.IGetSelectionTarget;

public class UIBTestView extends ViewPart implements IGetSelectionTarget, ISetSelectionTarget {
	private final FormToolkit myToolkit = IManager.Factory.getManager().getFormToolkit();
	private Composite myParent;

	private IFormCreator myForm;

	public IFormCreator createFormCreator(EObject obj) {
		myForm = IFormCreator.Factory.createScrolledForm(obj, myParent, "Header");
		myParent.layout();

		return myForm;
	}

	public Composite getParent() {
		return myParent;
	}

	/**
	 * The scrolled form
	 */
	private ScrolledForm myScrolledForm;

	/**
	 * Returns the scrolled form
	 * 
	 * @return the form
	 */
	public ScrolledForm getScrolledForm() {
		assertEquals("In IFormCreator mode", null, myForm);
		if (myScrolledForm == null) {
			getBody();
		}
		return myScrolledForm;
	}

	/**
	 * The body of the view with a {@link GridLayout}.
	 */
	private Composite myBody;
	private ISelection mySelection;

	/**
	 * Returns the body of the view with a {@link GridLayout}.
	 * 
	 * @return the body
	 */
	public Composite getBody() {
		assertEquals("In IFormCreator mode", null, myForm);
		if (myBody == null) {
			myScrolledForm = getToolkit().createScrolledForm(myParent);
			myScrolledForm.setText("Heading");
			getToolkit().decorateFormHeading(myScrolledForm.getForm());

			myBody = myScrolledForm.getBody();
			myBody.setLayout(new GridLayout());
			myParent.layout();
		}
		return myBody;
	}

	/**
	 * Returns the toolkit of ths view
	 * 
	 * @return the toolkit
	 */
	public FormToolkit getToolkit() {
		assertEquals("In IFormCreator mode", null, myForm);
		return myToolkit;
	}

	@Override
	public void createPartControl(Composite parent) {
		myParent = parent;
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void setPartName(String partName) {
		super.setPartName(partName);
	}

	@Override
	public ISelection getCurrentSelection() {
		return mySelection;
	}

	@Override
	public void selectReveal(ISelection selection) {
		mySelection = selection;
	}
}
