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

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IEnumDecoratorProvider;
import com.rcpcompany.uibindings.IEnumDecoratorProviderEntry;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.decorators.SimpleUIBindingDecorator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * The decorator for enumerations.
 */
public class EnumBindingDecorator extends SimpleUIBindingDecorator implements IUIBindingDecorator {

	/**
	 * The provider.
	 */
	private final IEnumDecoratorProvider myProvider;

	/**
	 * @param provider the provider
	 */
	public EnumBindingDecorator(IEnumDecoratorProvider provider) {
		myProvider = provider;
	}

	/**
	 * Mapping UI to model with all the defined mappings.
	 */
	protected final Map<String, String> uiToModelMappings = new HashMap<String, String>();

	/**
	 * The sequence of the ui elements.
	 */
	protected final List<String> uiSequence = new ArrayList<String>();

	/**
	 * Mapping model to UI with all the defined mappings..
	 */
	protected final Map<String, String> modelToUIMappings = new HashMap<String, String>();

	private EEnum myEnumeration;

	@Override
	public void init(IValueBinding binding) {
		super.init(binding);

		final EClassifier attributeType = binding.getDataType().getEType();
		if (!(attributeType instanceof EEnum)) {
			getBinding().addErrorCondition("Attribute is not an enumeration");
			return;
		}
		myEnumeration = (EEnum) attributeType;

		for (final IEnumDecoratorProviderEntry e : myProvider.getBaseMappings()) {
			final String uiValue = e.getUi();
			final String modelValue = e.getModel();
			uiToModelMappings.put(uiValue, modelValue);
			uiSequence.add(uiValue);
			if (!modelToUIMappings.containsKey(modelValue)) {
				modelToUIMappings.put(modelValue, uiValue);
			}
		}

		if (myProvider.isAddingDefaultMappings()) {
			for (final EEnumLiteral e : myEnumeration.getELiterals()) {
				final String modelValue = e.getName();
				final String uiValue = e.getLiteral();
				uiToModelMappings.put(uiValue, modelValue);
				uiSequence.add(uiValue);
				if (!modelToUIMappings.containsKey(modelValue)) {
					modelToUIMappings.put(modelValue, uiValue);
				}
			}
		}
	}

	@Override
	public IObservableList getValidUIList() {
		if (!calculatedValidUIList) {
			// If the valid values is specified, then use these
			myValidUIList = getBinding().getArgument(Constants.ARG_VALID_VALUES, IObservableList.class, null);
			if (myValidUIList == null) {
				// Otherwise use a list with the currently defined UI to model key
				myValidUIList = Observables.staticObservableList(uiSequence, String.class);
			}
			calculatedValidUIList = true;
		}
		return myValidUIList;
	}

	private final IObservableValue myImageOV = null;

	@Override
	protected Object convertModelToUI(Object fromObject) {
		final String key;
		if (fromObject == null)
			return "";
		else if (fromObject instanceof Enumerator) {
			key = ((Enumerator) fromObject).getName();
		} else {
			key = fromObject.toString();
		}
		if (!modelToUIMappings.containsKey(key))
			throw new IllegalArgumentException("Cannot map enumeration value '" + fromObject + "'");
		return modelToUIMappings.get(key);
	}

	@Override
	protected Object convertUIToModel(Object fromObject) {
		if (fromObject == null || fromObject.equals("")) return null;
		final String key = fromObject.toString();
		if (!uiToModelMappings.containsKey(key))
			throw new IllegalArgumentException(MessageFormat.format("Illegal value ''{0}''", fromObject));
		final String name = uiToModelMappings.get(key);
		if (name == null) return null;
		final EEnumLiteral literal = myEnumeration.getEEnumLiteral(name);
		if (literal == null) {
			LogUtils.error(EnumBindingDecorator.this.myProvider.getProviderCE(),
					"Mapping to unknown enumeration value: '" + name + "'", getBinding().getCreationPoint());
			throw new IllegalArgumentException(MessageFormat.format("Illegal value ''{0}''", fromObject));
		}
		return literal.getInstance();
	}
}
