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
package com.rcpcompany.uibindings.navigator;

/**
 * Abstract version of {@link IEditorPart} used to isolate the sub-class from small future changes.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractEditorPart implements IEditorPart {
	@Override
	public void dispose() {
	}

	@Override
	public boolean canAcceptObjectChanges() {
		return true;
	}
}
