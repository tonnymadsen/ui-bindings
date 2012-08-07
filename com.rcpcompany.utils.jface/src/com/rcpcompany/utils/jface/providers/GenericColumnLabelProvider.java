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

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * The base column label provider used for all core features.
 * <p>
 * It provides two sets of extra functionality:
 * <ul>
 * <li>A set of public methods to decorate a control in a dialog or view.</li>
 * <li>A set of methods to adapt a generic {@link Object} to any of the core model objects.</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GenericColumnLabelProvider extends ColumnLabelProvider {

	/**
	 * The structural feature for the main.
	 */
	private final EStructuralFeature myFeature;

	/**
	 * Returns <code>true</code> if the changed property is the name of the feature that backs this
	 * label provider.
	 */
	@Override
	public boolean isLabelProperty(Object element, String property) {
		return (myFeature.getName().equals(property));
	}

	/**
	 * Constructs and returns a new column label provider.
	 * 
	 * @param feature the feature of the column
	 */
	public GenericColumnLabelProvider(EStructuralFeature feature) {
		myFeature = feature;
	}

	@Override
	public String getText(Object element) {
		if (!(element instanceof EObject)) return null;
		final EObject obj = (EObject) element;

		Assert.isTrue(obj.eClass() == myFeature.getEContainingClass());

		final Object o = obj.eGet(myFeature);
		return o == null ? "" : o.toString(); //$NON-NLS-1$
	}

	/**
	 * Updates the SWT properties of a general SWT control based on the specified element.
	 * 
	 * @param control the SWT control
	 * @param element the element
	 */
	public void update(Control control, Object element) {
		control.setBackground(getBackground(element));
		control.setForeground(getForeground(element));
		control.setFont(getFont(element));
	}

	/**
	 * Updates the SWT properties of a SWT text based on the specified element.
	 * 
	 * @param control the SWT text
	 * @param element the element
	 */
	public void update(Text control, Object element) {
		control.setText(getText(element));
		control.setBackground(getBackground(element));
		control.setForeground(getForeground(element));
		control.setFont(getFont(element));
	}

	/**
	 * Updates the SWT properties of a SWT label based on the specified element.
	 * 
	 * @param control the SWT label
	 * @param element the element
	 */
	public void update(Label control, Object element) {
		control.setText(getText(element));
		final Image image = getImage(element);
		if (image != null) {
			control.setImage(image);
		}
		control.setBackground(getBackground(element));
		control.setForeground(getForeground(element));
		control.setFont(getFont(element));
	}

	/**
	 * Updates the SWT properties of a SWT label based on the specified element.
	 * 
	 * @param control the SWT label
	 * @param element the element
	 */
	public void update(CLabel control, Object element) {
		control.setText(getText(element));
		final Image image = getImage(element);
		control.setImage(image);
		control.setBackground(getBackground(element));
		control.setForeground(getForeground(element));
		control.setFont(getFont(element));
	}
}
