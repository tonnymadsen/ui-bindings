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
package com.rcpcompany.uibindings.internal.spy;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.SWT;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingSpySection;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Basic section for {@link IColumnBinding}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ColumnBindingBasicSection implements IBindingSpySection {
	@Override
	public void build(IFormCreator creator, ExecutionEvent event) {
		final IBinding b = (IBinding) creator.getObject();
		if (!(b instanceof IColumnBinding)) return;
		final IColumnBinding cb = (IColumnBinding) b;

		final IFormCreator subform = creator.addSection("Column Information");

		if (cb.getBaseColumn() != null) {
			subform.addField(cb.getBaseColumn(), IUIBindingsPackage.Literals.BINDING__LABEL, SWT.NONE).readonly();
		}
		// subform.addSeparator();
		// subform.addField(null,
		// IUIBindingsPackage.Literals.COLUMN_BINDING__SUB_COLUMNS).readonly();
	}
}
