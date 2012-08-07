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
package com.rcpcompany.utils.jface.providers;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.ui.PlatformUI;

/**
 * A label decorator for the name field of any of the base interfaces of the core model.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DecoratedColumnLabelProvider extends GenericColumnLabelProvider {
	/**
	 * The label decorator to use.
	 */
	private final ILabelDecorator myLabelDecorator;

	/**
	 * Constructs and returns a new provider.
	 * 
	 * @param feature the feature for the column of this
	 */
	public DecoratedColumnLabelProvider(EStructuralFeature feature) {
		super(feature);
		myLabelDecorator = PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator();
	}

	/**
	 * Returns the label decorator to use.
	 * 
	 * @return the decorator
	 */
	protected ILabelDecorator getLabelDecorator() {
		return myLabelDecorator;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		super.addListener(listener);
		myLabelDecorator.addListener(listener);
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		super.removeListener(listener);
		myLabelDecorator.removeListener(listener);
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		if (super.isLabelProperty(element, property)) return true;
		if (myLabelDecorator.isLabelProperty(element, property)) return true;

		return false;
	}
}
