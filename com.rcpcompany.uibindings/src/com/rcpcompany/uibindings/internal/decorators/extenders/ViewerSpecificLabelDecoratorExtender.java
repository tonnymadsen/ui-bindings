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
package com.rcpcompany.uibindings.internal.decorators.extenders;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.DecorationContext;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.DecorationPosition;
import com.rcpcompany.uibindings.IContainerBinding;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IValueBindingCell;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.bindingMessages.ValidationLabelDecorator;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * This extender supports label decorations using any {@link IViewerBinding} specific local
 * decorator.
 * <p>
 * <em>NOTE:</em> Most methods and variables have default visibility for testing purposes.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerSpecificLabelDecoratorExtender extends AbstractUIBindingDecoratorExtender implements
		ILabelProviderListener {

	/**
	 * Resource manager used for the images in the {@link IDecoration}.
	 */
	private final ResourceManager myResourceManager;

	/**
	 * Returns the resource manager used for the images in the {@link IDecoration}.
	 * 
	 * @return the resource manager
	 */
	public ResourceManager getResourceManager() {
		return myResourceManager;
	}

	/**
	 * Constructs and returns a new extender.
	 */
	public ViewerSpecificLabelDecoratorExtender() {
		myResourceManager = Activator.getDefault().getResourceManager();
	}

	@Override
	public boolean isEnabled(IValueBinding binding) {
		final ValidationLabelDecorator labelDecorator = getLabelDecorator(binding);

		return labelDecorator != null;
	}

	ValidationLabelDecorator getLabelDecorator(IValueBinding binding) {
		if (!binding.getArgument(Constants.ARG_LABEL_DECORATOR, Boolean.class, false)) return null;

		final IValueBindingCell cell = binding.getCell();
		if (cell == null) return null;
		final IContainerBinding container = cell.getContainer();
		if (container == null) return null;
		final ValidationLabelDecorator labelDecorator = container.getValidationLabelDecorator();

		return labelDecorator;
	}

	@Override
	public void extend(final IUIBindingDecoratorExtenderContext context) {
		final ValidationLabelDecorator labelDecorator = getLabelDecorator(context.getBinding());

		if (labelDecorator == null) return;

		/*
		 * We want to be notified next time the decorator changes...
		 * 
		 * Note that we expect the decorator to conform to the comment of #addListener(): "Adds a
		 * listener to this label provider. Has no effect if an identical listener is already
		 * registered.".
		 * 
		 * This is done this way to avoid any references from the extender to the decorator, as
		 * these can be problematic when garbage collecting...
		 */
		labelDecorator.addListener(this);

		final EObject element = context.getBinding().getModelObject();

		final IDecoration decoration = new IDecoration() {
			@Override
			public void addPrefix(String prefix) {
				// TODO
			}

			@Override
			public void addSuffix(String suffix) {
				// TODO
			}

			@Override
			public void addOverlay(ImageDescriptor overlay) {
				final DecorationPosition pos = IManager.Factory.getManager().getMessageDecorationPosition();
				switch (pos) {
				case TOP_LEFT:
				case CENTER_LEFT:
					addOverlay(overlay, IDecoration.TOP_LEFT);
					break;
				case BOTTOM_LEFT:
					addOverlay(overlay, IDecoration.BOTTOM_LEFT);
					break;
				case TOP_RIGHT:
				case CENTER_RIGHT:
					addOverlay(overlay, IDecoration.TOP_RIGHT);
					break;
				case BOTTOM_RIGHT:
					addOverlay(overlay, IDecoration.BOTTOM_RIGHT);
					break;
				default:
					LogUtils.error(this, "Unknown position: " + pos);
					addOverlay(overlay, IDecoration.TOP_LEFT);
					break;
				}
			}

			@Override
			public void addOverlay(ImageDescriptor overlay, int quadrant) {
				final Image image = getResourceManager().createImage(overlay);
				switch (quadrant) {
				case IDecoration.BOTTOM_LEFT:
					context.setDecoratingImage(DecorationPosition.BOTTOM_LEFT, false, image, null);
					break;
				case IDecoration.TOP_LEFT:
					context.setDecoratingImage(DecorationPosition.TOP_LEFT, false, image, null);
					break;
				case IDecoration.BOTTOM_RIGHT:
					context.setDecoratingImage(DecorationPosition.BOTTOM_RIGHT, false, image, null);
					break;
				case IDecoration.TOP_RIGHT:
					context.setDecoratingImage(DecorationPosition.TOP_RIGHT, false, image, null);
					break;
				case IDecoration.REPLACE:
					context.setImage(image);
					break;
				default:
					LogUtils.error(this, "Unknown quadrant: " + quadrant);
					break;
				}
			}

			@Override
			public void setForegroundColor(Color color) {
				context.setForegound(color);
			}

			@Override
			public void setBackgroundColor(Color color) {
				context.setBackgound(color);
			}

			@Override
			public void setFont(Font font) {
				context.setFont(font);
			}

			@Override
			public IDecorationContext getDecorationContext() {
				return DecorationContext.DEFAULT_CONTEXT;
			}
		};
		labelDecorator.decorate(element, decoration);
	}

	@Override
	public void labelProviderChanged(LabelProviderChangedEvent event) {
		IManager.Factory.getManager().updateBindings(event.getElements());
	}
}
