package com.rcpcompany.uibindings.navigator.internal.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

public class SelectCurrentEditorPart extends WorkbenchWindowControlContribution {

	public SelectCurrentEditorPart(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Control createControl(Composite parent) {
		new CCombo(parent, SWT.NULL);

		return null;
	}
}
