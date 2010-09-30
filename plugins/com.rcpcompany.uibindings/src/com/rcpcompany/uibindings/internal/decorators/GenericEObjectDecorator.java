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
package com.rcpcompany.uibindings.internal.decorators;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.UIBindingsUtils.IClassIdentiferMapper;
import com.rcpcompany.uibindings.decorators.SimpleUIBindingDecorator;
import com.rcpcompany.uibindings.observables.EMFListAttributeList;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * {@link IUIBindingDecorator} used for {@link EObject} references.
 * <p>
 * It uses one of the {@link EStructualFeature structural features} of the reference.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GenericEObjectDecorator extends SimpleUIBindingDecorator implements IUIBindingDecorator,
		IExecutableExtension {

	/**
	 * The valid values in this decorator.
	 */
	private IObservableList myValidValues;

	/**
	 * The mapper used in this decorator.
	 */
	private IClassIdentiferMapper myClassIdentiferMapper = null;

	/**
	 * The string used for <code>null</code> in the binding.
	 */
	private String myNullLabel;

	/**
	 * Whether the UI name is qualified with the class name.
	 * <p>
	 * 
	 * TODO: Implement!
	 */
	private boolean myQualified = false;

	/**
	 * If the mapper has used any specific attribute from the EObject, then this must be added so we
	 * can track the value properly.
	 */
	@Override
	public IObservableValue getDisplayObservableValue(IObservableValue value) {
		if (myClassIdentiferMapper != null)
			return myClassIdentiferMapper.getObservableValue(value, getBinding().getContext().getEditingDomain());
		return super.getDisplayObservableValue(value);
	}

	@Override
	public void init(IValueBinding binding) {
		super.init(binding);

		/*
		 * Get the label used for the null value
		 */
		myNullLabel = getBinding().getArgument(Constants.ARG_NULL_LABEL, String.class, "");

		/*
		 * Now analyze the list to find the best mapping
		 */
		final EClassifier type = getBinding().getDataType().getEType();
		if (!(type instanceof EClass)) {
			myClassIdentiferMapper = UIBindingsUtils.DEFAULT_MAPPER;
		} else {
			myClassIdentiferMapper = UIBindingsUtils.createClassIdentiferMapper(getBinding(), (EClass) type);
		}
		deduceValidValues();
	}

	/**
	 * Calculates the valid values.
	 * <p>
	 * Must be called early, as the result is used to determine whether this decorator is r/o.
	 */
	private void deduceValidValues() {
		/*
		 * If the decoration is read-only, then there are no reason to find the valid values
		 */
		if (!super.isChangeable()) return;

		final IBindingDataType dynDataType = getBinding().getDataType();
		if (dynDataType == null) return;

		final IObservableList argument = getBinding().getArgument(Constants.ARG_VALID_VALUES, IObservableList.class,
				null);
		if (argument == null) return;

		final Object elementType = argument.getElementType();

		Class<?> actualElementType;
		if (elementType instanceof EClass) {
			actualElementType = ((EClass) elementType).getInstanceClass();
		} else if (elementType instanceof EReference) {
			actualElementType = ((EReference) elementType).getEReferenceType().getInstanceClass();
		} else {
			LogUtils.error(getBinding(), "List for '" + Constants.ARG_VALID_VALUES
					+ "' not with EClass or EReferences: got " + elementType, getBinding().getCreationPoint());
			return;
		}

		final Class<?> expectedElementType = dynDataType.getDataType();
		if (actualElementType != expectedElementType) {
			LogUtils.error(getBinding(), "List of supplied valid type does not match feature of binding: expected "
					+ expectedElementType.getName() + " got " + actualElementType.getName(), getBinding()
					.getCreationPoint());
			return;
		}

		myValidValues = argument;
	}

	@Override
	public boolean isChangeable() {
		return myValidValues != null && super.isChangeable();
	}

	@Override
	protected Object convertModelToUI(Object fromObject) {
		if (myClassIdentiferMapper == null) return myNullLabel;
		final Object o = myClassIdentiferMapper.map(fromObject);
		return o != null ? o.toString() : myNullLabel;
	}

	@Override
	public IObservableList getValidUIList() {
		if (!calculatedValidUIList) {
			calculatedValidUIList = true;
			if (!isChangeable()) return null;
			myValidUIList = new EMFListAttributeList(myValidValues, myClassIdentiferMapper, String.class);
			if (!getBinding().getDataType().isRequired()) {
				myValidUIList.add(myNullLabel);
			}
		}
		return myValidUIList;
	}

	@Override
	protected Object convertUIToModel(Object fromObject) {
		if (fromObject == null) return null;
		if (fromObject.equals("")) return null;
		if (!isChangeable()) throw new IllegalArgumentException("Value cannot be changed");
		if (myNullLabel.equals(fromObject)) return null;

		for (final Object to : myValidValues) {
			if (fromObject.equals(convertModelToUI(to))) return to;
		}
		// LogUtils.debug(this, "Unknown value: '" + fromObject + "'");
		throw new IllegalArgumentException("Unknown value");
	}

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		if ("qualified".equals(data)) {
			myQualified = true;
		}
	}
}
