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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * This interface is used to specify the possible children that can be created in an
 * {@link IViewerBinding}.
 * <p>
 * The result is used to determine how an element can be added/dropped/...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IChildCreationSpecification {
	/**
	 * Internal ID for this specification.
	 * <p>
	 * Guaranteed to be the same for the same combination of parent, reference and childType.
	 * 
	 * @return the ID
	 */
	String getId();

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

	/**
	 * Returns the element type in question.
	 * 
	 * @return the element type
	 */
	EClass getChildType();

	/**
	 * The index in the references where the new item should be inserted.
	 * 
	 * @return the index of the new item or <code>-1</code> if unknown
	 */
	int getIndex();
}
