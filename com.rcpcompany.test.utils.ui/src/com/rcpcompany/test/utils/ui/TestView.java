/*******************************************************************************
 * Copyright (c) 2006-2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.test.utils.ui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class TestView extends ViewPart {
	private Composite myParent;

	public Composite getParent() {
		return myParent;
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
}
