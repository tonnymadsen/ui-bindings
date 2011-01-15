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
package com.rcpcompany.uibindings.internal.compositeform;

import java.util.Collection;
import java.util.Comparator;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.compositeform.ICompositeForm;
import com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor;
import com.rcpcompany.uibindings.compositeform.ICompositeFormFactory;
import com.rcpcompany.uibindings.compositeform.ICompositeFormManager;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPackage;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartFactory;
import com.rcpcompany.uibindings.internal.InternalConstants;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;
import com.rcpcompany.utils.extensionpoints.CEResourceHolder;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc -->
 * 
 * The manager of composite forms.
 * 
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormManagerImpl#getForms
 * <em>Forms</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CompositeFormManagerImpl extends EObjectImpl implements ICompositeFormManager {

	private static ICompositeFormManager MANAGER = null;

	public static ICompositeFormManager getManager() {
		if (MANAGER == null) {
			MANAGER = ICompositeFormFactory.eINSTANCE.createCompositeFormManager();
		}
		return MANAGER;
	}

	/**
	 * Creates the composite form for the specified ID.
	 * 
	 * @param form the form that will contain the composite form
	 * @param id the ID of the composite form
	 * @return the sub form
	 */
	public static ICompositeForm createForm(IFormCreator form, String id) {
		for (final ICompositeFormDescriptor fd : getManager().getForms()) {
			if (fd.getId().equals(id)) {
				final ICompositeForm cform = ICompositeFormFactory.eINSTANCE.createCompositeForm();
				cform.setFormCreator(form);
				cform.setDescriptor(fd);
				cform.create();

				return cform;
			}
		}
		return null;
	}

	/**
	 * The cached value of the '{@link #getForms() <em>Forms</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getForms()
	 * @generated
	 * @ordered
	 */
	protected EList<ICompositeFormDescriptor> forms;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected CompositeFormManagerImpl() {
		super();

		extensionReader();
	}

	private void extensionReader() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();

		CE: for (final IConfigurationElement ce : registry
				.getConfigurationElementsFor(InternalConstants.COMPOSITE_FORMS_EXTENSION_POINT)) {
			final String elementName = ce.getName();
			String attr;
			if (elementName.equals(InternalConstants.FORM_TAG)) {
				final String id = ce.getAttribute(InternalConstants.ID_TAG);
				if (id == null || id.length() == 0) {
					LogUtils.error(ce, InternalConstants.ID_TAG + " must be specified. Ignored"); //$NON-NLS-1$
					continue CE;
				}

				for (final ICompositeFormDescriptor f : getForms()) {
					if (f.getId().equals(id)) {
						LogUtils.error(ce, "Duplicate declaration of form '" + id + "'. Ignored.");
						continue CE;
					}
				}

				final ICompositeFormDescriptor form = ICompositeFormFactory.eINSTANCE.createCompositeFormDescriptor();
				form.setId(id);
				getForms().add(form);
			} else if (elementName.equals(InternalConstants.PART_TAG)) {
				final String id = ce.getAttribute(InternalConstants.FORM_ID_TAG);
				if (id == null || id.length() == 0) {
					LogUtils.error(ce, InternalConstants.FORM_ID_TAG + " must be specified. Ignored"); //$NON-NLS-1$
					continue CE;
				}

				ICompositeFormDescriptor form = null;
				for (final ICompositeFormDescriptor f : getForms()) {
					if (f.getId().equals(id)) {
						form = f;
						break;
					}
				}
				if (form == null) {
					LogUtils.error(ce, InternalConstants.FORM_ID_TAG + " must be a declared form. Ignored"); //$NON-NLS-1$
					continue CE;
				}

				final ICompositeFormPartDescriptor part = ICompositeFormFactory.eINSTANCE
						.createCompositeFormPartDescriptor();
				attr = ce.getAttribute(InternalConstants.TITLE_TAG);
				if (attr == null || attr.length() == 0) {
					LogUtils.error(ce, InternalConstants.TITLE_TAG + " must be specified. Ignored"); //$NON-NLS-1$
					continue CE;
				}
				part.setTitle(attr);
				part.setImage(new CEResourceHolder(ce));
				part.setFactory(new CEObjectHolder<ICompositeFormPartFactory>(ce, InternalConstants.FACTORY_TAG));

				final String priority = ce.getAttribute(InternalConstants.PRIORITY_TAG);
				if (priority != null && priority.length() > 0) {
					try {
						part.setPriority(Integer.parseInt(priority));
					} catch (final NumberFormatException ex) {
						LogUtils.error(ce, ex);
						continue;
					}
				} else {
					part.setPriority(1000);
				}

				form.getParts().add(part);
			} else {
				LogUtils.error(ce, "Unknown tag: '" + ce.getName() + "'");
			}
		}

		/*
		 * Sort the parts of the forms
		 */
		final Comparator<ICompositeFormPartDescriptor> comparator = new Comparator<ICompositeFormPartDescriptor>() {
			@Override
			public int compare(ICompositeFormPartDescriptor o1, ICompositeFormPartDescriptor o2) {
				return o2.getPriority() - o1.getPriority();
			}
		};
		for (final ICompositeFormDescriptor form : getForms()) {
			ECollections.sort(form.getParts(), comparator);
		}

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ICompositeFormPackage.Literals.COMPOSITE_FORM_MANAGER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<ICompositeFormDescriptor> getForms() {
		if (forms == null) {
			forms = new EObjectContainmentWithInverseEList<ICompositeFormDescriptor>(ICompositeFormDescriptor.class,
					this, ICompositeFormPackage.COMPOSITE_FORM_MANAGER__FORMS,
					ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__MANAGER);
		}
		return forms;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ICompositeFormPackage.COMPOSITE_FORM_MANAGER__FORMS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getForms()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ICompositeFormPackage.COMPOSITE_FORM_MANAGER__FORMS:
			return ((InternalEList<?>) getForms()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ICompositeFormPackage.COMPOSITE_FORM_MANAGER__FORMS:
			return getForms();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ICompositeFormPackage.COMPOSITE_FORM_MANAGER__FORMS:
			getForms().clear();
			getForms().addAll((Collection<? extends ICompositeFormDescriptor>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ICompositeFormPackage.COMPOSITE_FORM_MANAGER__FORMS:
			getForms().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ICompositeFormPackage.COMPOSITE_FORM_MANAGER__FORMS:
			return forms != null && !forms.isEmpty();
		}
		return super.eIsSet(featureID);
	}
} // CompositeFormManagerImpl
