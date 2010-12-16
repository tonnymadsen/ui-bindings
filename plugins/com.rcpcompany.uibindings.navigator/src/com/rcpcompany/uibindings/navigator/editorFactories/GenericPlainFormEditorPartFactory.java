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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.navigator.FormEditorPartFactory;
import com.rcpcompany.uibindings.navigator.IEditorPartContext;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * The generic editor, that uses the {@link IFormCreator} to create the editor.
 * <p>
 * It very simply adds a single field for each structural feature in the object.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GenericPlainFormEditorPartFactory extends FormEditorPartFactory implements IEditorPartFactory {
	@Override
	protected void createForm(IEditorPartContext context, IFormCreator form) {
		final EObject obj = (EObject) context.getCurrentValue().getValue();
		final EClass cls = obj.eClass();

		for (final EStructuralFeature sf : cls.getEAllStructuralFeatures()) {
			boolean ro = false;
			Class<? extends Control> preferredControl = null;
			if (sf instanceof EReference) {
				final EReference ref = (EReference) sf;
				if (ref.isContainer()) {
					continue;
				}
				if (ref.isContainment()) {
					/*
					 * Containment references cannot be changed
					 */
					ro = true;
					preferredControl = Text.class;
				}
			}
			if (sf.isMany()) {
				continue;
			}

			if (!sf.isChangeable()) {
				ro = true;
			}
			if (EcoreUtil.isSuppressedVisibility(sf, EcoreUtil.SET)) {
				ro = true;
			}

			String spec = sf.getName();
			String options = "";
			if (ro) {
				/*
				 * TODO: also query model/feature
				 */
				options += "," + Constants.ARG_READONLY;
			}
			if (options.length() > 0) {
				spec += "(" + options.substring(1) + ")";
			}
			final IValueBinding binding = form.addField(spec);
			if (preferredControl != null) {
				binding.arg(Constants.ARG_PREFERRED_CONTROL, preferredControl.getName());
			}
		}
	}

	@Override
	public boolean canAcceptObjectChanges() {
		return false;
	}
}
