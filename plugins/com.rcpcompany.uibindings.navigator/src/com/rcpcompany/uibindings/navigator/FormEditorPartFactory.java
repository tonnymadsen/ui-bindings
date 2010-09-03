package com.rcpcompany.uibindings.navigator;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * {@link IEditorPartFactory} aimed at {@link IFormCreator} based editor parts.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class FormEditorPartFactory extends AbstractEditorPartFactory implements IEditorPartFactory {
	@Override
	public final IEditorPart createEditorPart(IEditorPartContext context) {
		final IFormCreator form = IFormCreator.Factory.createScrolledForm(context.getCurrentValue(),
				context.getParent(), context.getDescriptor().getName());
		form.getContext().addBinding().ui(form.getScrolledForm()).model(context.getCurrentValue())
				.arg(Constants.ARG_MESSAGE_FORMAT, "{0} - " + context.getDescriptor().getName()).readonly();
		createForm(context, form);
		form.finish();

		/*
		 * IBindingContextSelectionProvider is automatically disposed with the context..
		 */
		IBindingContextSelectionProvider.Factory.adapt(form.getContext(), context.getWorkbenchPart().getSite());
		return new IEditorPart() {
			@Override
			public void dispose() {
				form.dispose();
			}
		};

	}

	/**
	 * Creates the content of the editor part based on a {@link IFormCreator}.
	 * 
	 * @param context the context
	 * @param form the form
	 */
	protected abstract void createForm(IEditorPartContext context, IFormCreator form);
}
