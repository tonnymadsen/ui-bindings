package com.rcpcompany.uibindings.navigator;

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

		createForm(context, form);

		form.finish();

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
