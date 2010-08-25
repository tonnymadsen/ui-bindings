package com.rcpcompany.uibindings.internal.decorators.extenders;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Extender that will add an image for a binding if known.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ArgumentImageExtender extends AbstractUIBindingDecoratorExtender {

	@Override
	public boolean isEnabled(IValueBinding binding) {
		// TODO: if show image
		if (binding.getParentBinding() != null && !binding.getArgument(Constants.ARG_SHOW_IMAGE, Boolean.class, false))
			return false;
		final ImageDescriptor id = binding.getArgument(Constants.ARG_IMAGE, ImageDescriptor.class, null);
		return id != null;
	}

	@Override
	public void extend(IUIBindingDecoratorExtenderContext context) {
		final IValueBinding binding = context.getBinding();
		final ImageDescriptor id = binding.getArgument(Constants.ARG_IMAGE, ImageDescriptor.class, null);
		if (id == null) return;

		final Image image = Activator.getDefault().getResourceManager().createImage(id);
		if (image == null) {
			LogUtils.error(binding, "Cannot create image for " + id);
			return;
		}

		context.setImage(image);
	}
}
