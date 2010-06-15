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
import com.rcpcompany.uibindings.internal.bindingDataTypes.BindingDataTypeFactory;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Extender that will add an image for an enumeration value ({@link EEnumLiteral}) if known.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EnumImageExtender extends AbstractUIBindingDecoratorExtender {
	/**
	 * Map with all found mappings
	 */
	final static protected Map<Object, Image> theImageMap = new HashMap<Object, Image>();

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

		if (!theImageMap.containsKey(enumValue)) {
			final EEnum e = (EEnum) binding.getDataType().getEType();
			final EEnumLiteral literal = e.getEEnumLiteralByLiteral(enumValue.getLiteral());
			final IBindingDataType dataType = BindingDataTypeFactory.create(literal);
			final ImageDescriptor id = dataType.getArgument(binding, Constants.ARG_IMAGE, ImageDescriptor.class);

			if (id == null) {
				theImageMap.put(enumValue, null);
				return;
			}

			final Image image = Activator.getDefault().getResourceManager().createImage(id);
			if (image == null) {
				LogUtils.error(binding, "The image for enumration value "
						+ binding.getDataType().getDataType().getName() + "#" + enumValue.getLiteral()
						+ " cannot be loaded");
				theImageMap.put(enumValue, null);
				return;
			}
			theImageMap.put(enumValue, image);
		}

		final Image image = theImageMap.get(enumValue);
		if (image != null) {
			context.setImage(image);
		}
	}
}
