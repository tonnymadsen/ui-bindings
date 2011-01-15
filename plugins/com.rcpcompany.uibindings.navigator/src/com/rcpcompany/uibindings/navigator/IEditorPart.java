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
package com.rcpcompany.uibindings.navigator;

import com.rcpcompany.uibindings.IDisposable;

/**
 * An editor part as created by {@link IEditorPartFactory}.
 * <p>
 * The interface allows an editor part to be properly disposed.
 * <p>
 * Do not implement this interface directly - instead sub-class {@link AbstractEditorPart}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IEditorPart extends IDisposable {
	/**
	 * Returns whether this editor can accept changes in the object of the editor without
	 * re-creating the editor.
	 * <p>
	 * Some editors - e.g. the generic one - build the UI based on the current object and these
	 * cannot easily accept changes in the object as the UI is not changed in the same moment.
	 * 
	 * @return <code>true</code> if the object can be changed
	 */
	boolean canAcceptObjectChanges();
}
