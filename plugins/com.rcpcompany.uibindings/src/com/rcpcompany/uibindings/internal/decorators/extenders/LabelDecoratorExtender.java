package com.rcpcompany.uibindings.internal.decorators.extenders;

import org.eclipse.jface.viewers.DecorationContext;
import org.eclipse.jface.viewers.IColorDecorator;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.IFontDecorator;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelDecorator;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;

/**
 * This extender supports label decorations using
 * <code>PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator())</code>.
 * <p>
 * <em>NOTE:</em> Most methods and variables have default visibility for testing purposes.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class LabelDecoratorExtender extends AbstractUIBindingDecoratorExtender implements ILabelProviderListener {

	public LabelDecoratorExtender() {
		theWorkbenchDecorator.addListener(this);
	}

	@Override
	public void dispose() {
		theWorkbenchDecorator.removeListener(this);
		super.dispose();
	}

	@Override
	public boolean isEnabled(IValueBinding binding) {
		return binding.getArgument(Constants.ARG_LABEL_DECORATOR, Boolean.class, false);
	}

	@Override
	public void extend(IUIBindingDecoratorExtenderContext context) {
		final Object element = context.getDecoratedValue().getValue();

		// Text

		final Image image = context.getImage();
		Image decorated = null;
		if (theWorkbenchDecorator instanceof LabelDecorator) {
			decorated = ((LabelDecorator) theWorkbenchDecorator).decorateImage(image, element, getDecorationContext());
		} else {
			decorated = theWorkbenchDecorator.decorateImage(image, element);
		}
		if (decorated != null) {
			context.setImage(decorated);
		}

		if (theWorkbenchDecorator instanceof IColorDecorator) {
			final Color foreground = ((IColorDecorator) theWorkbenchDecorator).decorateForeground(element);
			if (foreground != null) {
				context.setForegound(foreground);
			}
			final Color background = ((IColorDecorator) theWorkbenchDecorator).decorateBackground(element);
			if (background != null) {
				context.setBackgound(background);
			}
		}
		if (theWorkbenchDecorator instanceof IFontDecorator) {
			final Font font = ((IFontDecorator) theWorkbenchDecorator).decorateFont(element);
			if (font != null) {
				context.setFont(font);
			}
		}

	}

	/* package */static final ILabelDecorator theWorkbenchDecorator = PlatformUI.getWorkbench().getDecoratorManager()
			.getLabelDecorator();

	/* package */final IDecorationContext myDecorationContext = DecorationContext.DEFAULT_CONTEXT;;

	/**
	 * Returns the decoration context associated with this label provider. It will be passed to the decorator if the
	 * decorator is an instance of {@link LabelDecorator}.
	 * 
	 * @return the decoration context associated with this label provider
	 */
	public IDecorationContext getDecorationContext() {
		return myDecorationContext;
	}

	@Override
	public void labelProviderChanged(LabelProviderChangedEvent event) {
		IManager.Factory.getManager().updateBindings(event.getElements());
	}
}
