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
package com.rcpcompany.uibindings.internal.decorators.extenders;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.IEnumDecoratorProvider;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Extender that will add an image for an enumeration value ({@link EEnumLiteral}) if known.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EnumImageExtender extends AbstractUIBindingDecoratorExtender {
	/**
	 * Map with all found mappings.
	 */
	protected static final Map<Object, Image> IMAGE_MAP = new HashMap<Object, Image>();

	@Override
	public boolean isEnabled(IValueBinding binding) {
		return binding.getDecoratorProvider() instanceof IEnumDecoratorProvider;
	}

	@Override
	public void extend(IUIBindingDecoratorExtenderContext context) {
		final IValueBinding binding = context.getBinding();
		if (!(binding.getDecoratorProvider() instanceof IEnumDecoratorProvider)) return;
		final IObservableValue modelObservable = binding.getModelObservableValue();
		if (modelObservable == null) return;

		final Object value = modelObservable.getValue();
		if (!(value instanceof Enumerator)) return;

		final Enumerator enumValue = (Enumerator) value;

		if (!IMAGE_MAP.containsKey(enumValue)) {
			final EEnum e = (EEnum) binding.getDataType().getEType();
			final EEnumLiteral literal = e.getEEnumLiteralByLiteral(enumValue.getLiteral());
			final IBindingDataType dataType = IBindingDataType.Factory.create(null, literal);
			final ImageDescriptor id = dataType.getArgument(Constants.ARG_IMAGE, binding.getType(),
					ImageDescriptor.class, null);

			if (id == null) {
				IMAGE_MAP.put(enumValue, null);
				return;
			}

			final Image image = Activator.getDefault().getResourceManager().createImage(id);
			if (image == null) {
				LogUtils.error(binding, "The image for enumration value "
						+ binding.getDataType().getDataType().getName() + "#" + enumValue.getLiteral()
						+ " cannot be loaded");
				IMAGE_MAP.put(enumValue, null);
				return;
			}
			IMAGE_MAP.put(enumValue, image);
		}

		final Image image = IMAGE_MAP.get(enumValue);
		if (image != null) {
			context.setImage(image);
		}
	}
}
