/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.decorators;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.decorators.SimpleUIBindingDecorator;
import com.rcpcompany.utils.basic.ToStringUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * {@link IUIBindingDecorator} for EObject creation.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EObjectCreatorDecorator extends SimpleUIBindingDecorator implements IUIBindingDecorator {

	private EClass myEClass;
	private IObservableList myList;

	/**
	 * The string used for <code>null</code> in the binding.
	 */
	private String myNullLabel;

	/**
	 * Mapping UI to model with all the defined mappings.
	 */
	protected final Map<String, EClass> uiToModelClassMappings = new HashMap<String, EClass>();

	/**
	 * Mapping UI name to model objects.
	 */
	protected final Map<String, EObject> uiToModelObjectMappings = new HashMap<String, EObject>();

	/**
	 * Mapping model to UI with all the defined mappings.
	 * <p>
	 * Matching is based on an exact match
	 */
	protected final Map<EClass, String> modelToUIClassMappings = new HashMap<EClass, String>();

	private IValueChangeListener myModelObjectChangeListener = null;

	@Override
	public void init(IValueBinding binding) {
		super.init(binding);

		final EClassifier attributeType = binding.getDataType().getEType();
		if (!(attributeType instanceof EClass)) {
			getBinding().addErrorCondition("Attribute is not an EClass");
			return;
		}
		myEClass = (EClass) attributeType;

		/*
		 * Get the label used for the null value
		 */
		myNullLabel = getBinding().getArgument(Constants.ARG_NULL_LABEL, String.class, "");

		myList = getBinding().getArgument(Constants.ARG_VALID_VALUES, IObservableList.class, null);
		if (myList == null) {
			getBinding().addErrorCondition("No class list given");
			return;
		}
		// TODO: make this dynamic
		myValidUIList = WritableList.withElementType(String.class);
		for (final Object e : myList) {
			if (!(e instanceof EClass)) {
				getBinding().addErrorCondition("List element is not an EClass: " + e);
				return;
			}
			final EClass ec = (EClass) e;
			if (modelToUIClassMappings.get(ec) != null) {
				getBinding().addErrorCondition("List element is duplicated: " + ec);
			}

			final String name = ToStringUtils.formatHumanReadable(ec.getName());
			// TODO: get label if present
			if (uiToModelClassMappings.get(name) != null) {
				getBinding().addErrorCondition(
						"List element name is duplicated: '" + ec + "' and '" + uiToModelClassMappings.get(name) + "'");
			}
			modelToUIClassMappings.put(ec, name);
			uiToModelClassMappings.put(name, ec);
			myValidUIList.add(name);
		}
		if (!getBinding().getDataType().isRequired()) {
			myValidUIList.add(myNullLabel);
		}

		final IObservableValue ov = getBinding().getModelObservableValue();
		if (ov instanceof IObserving) {
			final IObserving observing = (IObserving) ov;
			myModelObjectChangeListener = new IValueChangeListener() {
				Object currentObserved = observing.getObserved();

				@Override
				public void handleValueChange(ValueChangeEvent event) {
					final Object newObserved = observing.getObserved();

					if (currentObserved == newObserved) return;
					currentObserved = newObserved;

					uiToModelObjectMappings.clear();
				}
			};
			ov.addValueChangeListener(myModelObjectChangeListener);
		}
	}

	@Override
	public void dispose() {
		if (myModelObjectChangeListener != null) {
			getBinding().getModelObservableValue().removeValueChangeListener(myModelObjectChangeListener);
		}
		super.dispose();
	}

	@Override
	protected Object convertModelToUI(Object fromObject) {
		if (fromObject == null) return myNullLabel;
		if (!(fromObject instanceof EObject)) {
			LogUtils.error(this, "Object not an EObject: " + fromObject, getBinding().getCreationPoint());
			return "";
		}
		final EObject e = (EObject) fromObject;
		final EClass ec = e.eClass();
		final String name = modelToUIClassMappings.get(ec);
		if (name == null) {
			LogUtils.error(this, "Object type not mapped: " + fromObject, getBinding().getCreationPoint());
			return "";
		}
		if (uiToModelObjectMappings.get(name) == null) {
			uiToModelObjectMappings.put(name, e);
		}
		return name;
	}

	@Override
	protected Object convertUIToModel(Object fromObject) {
		if (fromObject == null || fromObject.equals("") || fromObject.equals(myNullLabel)) return null;
		if (!(fromObject instanceof String)) {
			LogUtils.error(this, "Object not an String: " + fromObject, getBinding().getCreationPoint());
			return null;
		}
		final String name = (String) fromObject;
		// Look for an existing object
		if (uiToModelObjectMappings.get(name) != null) return uiToModelObjectMappings.get(name);
		// Create a new object
		final EClass ec = uiToModelClassMappings.get(name);
		if (ec == null) {
			LogUtils.error(this, "Name not mapped: " + name);
			return null;
		}
		/*
		 * Create and initialize the object
		 */
		final EObject e = EcoreUtil.create(ec);
		IManager.Factory.getManager().initializeObject(getBinding().getEditingDomain(), null, null, e, false);
		uiToModelObjectMappings.put(name, e);
		return e;
	}

	@Override
	public IObservableList getValidUIList() {
		return myValidUIList;
	}
}
