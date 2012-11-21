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
package com.rcpcompany.uibindings.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;

import com.rcpcompany.utils.logging.LogUtils;

/**
 * Various utilities related to the model.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public final class UIBEcoreUtils {
	private UIBEcoreUtils() {
	}

	/**
	 * Returns a description of the objects that has a <em>required</em> reference into the
	 * specified set of objects (or their containment children).
	 * 
	 * @param objects the objects to test
	 * @return the objects with references
	 */
	public static Map<EObject, Collection<EStructuralFeature.Setting>> findIncomingRequiredReferences(
			Collection<? extends EObject> objects) {
		/*
		 * Find the involved objects
		 */
		final Collection<EObject> eObjects = getContainmentTree(objects);

		/*
		 * Find all references into these objects
		 */
		final EditingDomain domain = EditingDomainUtils.getEditingDomain();
		final Map<EObject, Collection<EStructuralFeature.Setting>> usages = EcoreUtil.UsageCrossReferencer.findAll(
				eObjects, domain.getResourceSet());

		/*
		 * Find the objects that have a required reference into the objects
		 */
		for (final Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : usages.entrySet().toArray(
				new Map.Entry[usages.entrySet().size()])) {
			final EObject eObject = entry.getKey();
			if (eObject.eResource() != null) {
				continue;
			}
			final Collection<EStructuralFeature.Setting> settings = entry.getValue();
			for (final EStructuralFeature.Setting setting : settings.toArray(new EStructuralFeature.Setting[settings
					.size()])) {
				final EObject referencingEObject = setting.getEObject();
				if (eObjects.contains(referencingEObject)) {
					continue;
				}
				final EStructuralFeature sf = setting.getEStructuralFeature();
				/*
				 * Keep the reference if it is not-changeable
				 */
				if (!sf.isChangeable()) {
					continue;
				}
				/*
				 * If it is a to-one required reference, then we keep it
				 */
				if (!sf.isMany() && sf.isRequired()) {
					continue;
				}
				settings.remove(setting);
			}

			if (entry.getValue().isEmpty()) {
				usages.remove(eObject);
			}
		}

		if (usages.isEmpty()) return null;

		return usages;
	}

	/**
	 * Returns the collection of objects from the specified set of objects and their containment
	 * children.
	 * 
	 * @param objects the objects
	 * @return the same objects along with their containment children
	 */
	private static Collection<EObject> getContainmentTree(Collection<? extends EObject> objects) {
		final Collection<EObject> objs = new ArrayList<EObject>();
		for (final Object wrappedObject : objects) {
			final Object object = AdapterFactoryEditingDomain.unwrap(wrappedObject);
			if (object instanceof EObject) {
				objs.add((EObject) object);
				for (final Iterator<EObject> j = ((EObject) object).eAllContents(); j.hasNext();) {
					objs.add(j.next());
				}
			} else if (object instanceof Resource) {
				for (final Iterator<EObject> j = ((Resource) object).getAllContents(); j.hasNext();) {
					objs.add(j.next());
				}
			}
		}
		return objs;
	}

	/**
	 * Shows an error dialog.
	 * 
	 * @param title the title for the dialog
	 * @param description the first line(s) of a description used for the dialog
	 * @param references the references for the objects that cannot be handled
	 */
	public static void showErrorDialog(String title, String description, Map<EObject, Collection<Setting>> references) {
		LogUtils.debug("", title);

		if (references == null) {
			description += "\n\nReferences are found.";
		} else {
			description += "\n\nThe following references are found:\n";
			for (final Entry<EObject, Collection<Setting>> e : references.entrySet()) {
				description += "\n    " + IBindingObjectInformation.Factory.getQualifiedName(e.getKey()) + ":";
				for (final Setting s : e.getValue()) {
					description += "\n       " + s.getEStructuralFeature().getName() + " of "
							+ IBindingObjectInformation.Factory.getQualifiedName(s.getEObject());
				}
			}
		}

		MessageDialog.openError(null, title, description);
	}
}
