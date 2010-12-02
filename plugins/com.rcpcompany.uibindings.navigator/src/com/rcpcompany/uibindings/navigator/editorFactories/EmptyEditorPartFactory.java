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
package com.rcpcompany.uibindings.navigator.editorFactories;

import com.rcpcompany.uibindings.navigator.AbstractEditorPart;
import com.rcpcompany.uibindings.navigator.AbstractEditorPartFactory;
import com.rcpcompany.uibindings.navigator.IEditorPart;
import com.rcpcompany.uibindings.navigator.IEditorPartContext;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;

/**
 * The generic editor, that shows... nothing.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EmptyEditorPartFactory extends AbstractEditorPartFactory implements IEditorPartFactory {

	@Override
	public IEditorPart createEditorPart(IEditorPartContext context) {
		return new AbstractEditorPart() {
		};
	}
}
