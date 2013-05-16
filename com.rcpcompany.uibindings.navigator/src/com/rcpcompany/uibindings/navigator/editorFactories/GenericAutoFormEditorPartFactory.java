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
package com.rcpcompany.uibindings.navigator.editorFactories;

import com.rcpcompany.uibindings.navigator.AbstractEditorPart;
import com.rcpcompany.uibindings.navigator.AbstractEditorPartFactory;
import com.rcpcompany.uibindings.navigator.IEditorPart;
import com.rcpcompany.uibindings.navigator.IEditorPartContext;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;
import com.rcpcompany.uibindings.utils.IAutoFormCreator;

/**
 * The generic editor, that uses the {@link IAutoFormCreator} to create the editor.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GenericAutoFormEditorPartFactory extends AbstractEditorPartFactory implements IEditorPartFactory {
	@Override
	public IEditorPart createEditorPart(IEditorPartContext context) {
		final IAutoFormCreator form = IAutoFormCreator.Factory.createForm(context.getCurrentValue(), context
				.getDescriptor().getName(), context.getParent(), context.getWorkbenchPart());
		return new AbstractEditorPart() {
			@Override
			public void dispose() {
				form.dispose();
			}

			@Override
			public boolean canAcceptObjectChanges() {
				return false;
			}
		};
	}
}
