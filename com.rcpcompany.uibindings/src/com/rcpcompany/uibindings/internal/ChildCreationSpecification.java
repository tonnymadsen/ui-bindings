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
package com.rcpcompany.uibindings.internal;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import com.rcpcompany.uibindings.IChildCreationSpecification;

/**
 * Generic {@link IChildCreationSpecification}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ChildCreationSpecification implements IChildCreationSpecification {
	private final EObject myParent;
	private final EReference myReference;
	private final EClass myChildType;
	private final int myIndex;

	/**
	 * Creates and returns a new specification.
	 * 
	 * @param parent the parent of the specification
	 * @param reference the reference of the specification
	 * @param childType the child type of the specification
	 * @param index index of object in parent or -1
	 */
	public ChildCreationSpecification(EObject parent, EReference reference, EClass childType, int index) {
		myParent = parent;
		myReference = reference;
		myChildType = childType;
		myIndex = index;
	}

	@Override
	public EObject getParent() {
		return myParent;
	}

	@Override
	public EReference getReference() {
		return myReference;
	}

	@Override
	public EClass getChildType() {
		return myChildType;
	}

	@Override
	public String getId() {
		return System.identityHashCode(getParent()) + ":" + getReference().getName() + ":" + getChildType().getName();
	}

	@Override
	public int getIndex() {
		return myIndex;
	}
}
