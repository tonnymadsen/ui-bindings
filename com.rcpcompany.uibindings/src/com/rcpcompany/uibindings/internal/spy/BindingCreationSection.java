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
package com.rcpcompany.uibindings.internal.spy;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingSpySection;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Basic section for {@link IValueBinding}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingCreationSection implements IBindingSpySection {
	@Override
	public void build(IFormCreator creator, ExecutionEvent event) {
		final IBinding b = (IBinding) creator.getObject();
		final Throwable creationPoint = b.getCreationPoint();
		if (creationPoint == null) return;

		final IFormCreator subform = creator.addSection("Location");

		final StringBuilder sb = new StringBuilder(500);
		sb.append("Creation point (copy to Eclipse Console View)");
		for (final StackTraceElement e : creationPoint.getStackTrace()) {
			sb.append("\n\tat ").append(e.getClassName()).append('.').append(e.getMethodName()).append(" (")
					.append(e.getFileName()).append(':').append(e.getLineNumber()).append(')');
		}
		sb.append("\n...");

		final Text text = subform.getToolkit().createText(subform.getTop(), sb.toString(),
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.READ_ONLY);
		subform.setLayoutData(text, true, false);
	}
}
