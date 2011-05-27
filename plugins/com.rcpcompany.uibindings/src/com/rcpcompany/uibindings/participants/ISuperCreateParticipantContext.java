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
package com.rcpcompany.uibindings.participants;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.graphics.Point;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.utils.IClipboardConverterManager.IResult;

/**
 * Context for {@link ISuperCreateParticipant#createNeededRows(ISuperCreateParticipantContext)}.
 * <p>
 * Remember that new objects can be (partly) initialized using
 * {@link IManager#initializeObject(EditingDomain, EObject, EReference, EObject, boolean)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface ISuperCreateParticipantContext {
	/**
	 * The viewer that should have the new added rows.
	 * 
	 * @return the viewer
	 */
	IViewerBinding getViewer();

	/**
	 * Returns the parent object of the viewer, if known.
	 * 
	 * @return the parent object or <code>null</code>
	 */
	EObject getParent();

	/**
	 * Returns the list reference of the viewer, if known.
	 * 
	 * @return the list reference or <code>null</code>
	 */
	EReference getReference();

	/**
	 * The data to be copied from the clipboard.
	 * <p>
	 * The size of the data can be found as <code>getClipboardContent().getRows()</code>.
	 * 
	 * @return the clipboard data
	 */
	IResult getClipboardContent();

	/**
	 * The editing domain to be used for the creation of all the needed rows.
	 * <p>
	 * And whatever initialization that might be needed.
	 * 
	 * @return the editing domain
	 */
	EditingDomain getEditingDomain();

	/**
	 * Returns the destination position of the clipboard data.
	 * 
	 * @return the position
	 */
	Point getPosition();

	/**
	 * Returns the element from the specified position (the selection), if any.
	 * 
	 * @return the element or <code>null</code>
	 */
	EObject getElement();
}
