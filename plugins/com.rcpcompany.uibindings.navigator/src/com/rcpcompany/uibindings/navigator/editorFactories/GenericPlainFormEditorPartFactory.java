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

import com.rcpcompany.uibindings.Constants;
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
		System.out.println("=== " + obj);
		final EClass cls = obj.eClass();

		for (final EStructuralFeature sf : cls.getEAllStructuralFeatures()) {
			if (sf instanceof EReference) {
				final EReference ref = (EReference) sf;
				if (ref.isContainer()) {
					continue;
				}
			}
			if (sf.getUpperBound() != 1) {
				continue;
			}

			String spec = sf.getName();
			String options = "";
			if (!sf.isChangeable()) {
				options += "," + Constants.ARG_READONLY;
			}
			if (options.length() > 0) {
				spec += "(" + options.substring(1) + ")";
			}
			form.addField(spec);
		}
	}
}
