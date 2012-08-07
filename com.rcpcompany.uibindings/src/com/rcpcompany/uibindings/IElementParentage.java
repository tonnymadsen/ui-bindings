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
package com.rcpcompany.uibindings;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * This interface is used to specify the parentage for a specific element in a viewer in the form of
 * the parent5 object and the reference from that parent to the element in question.
 * <p>
 * The result is used to determine how an element can be delete/dragged/...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IElementParentage {
	/**
	 * Returns the element in question.
	 * 
	 * @return the element
	 */
	EObject getElement();

	/**
	 * Returns the parent object of the element.
	 * 
	 * @return the parent
	 */
	EObject getParent();

	/**
	 * Returns the reference for the element in the parent.
	 * 
	 * @return the reference
	 */
	EReference getReference();
}
